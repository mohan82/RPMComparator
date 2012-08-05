/*
 * Copyright (c) 2012. Mohan Ambalavanan
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *    Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License
 */

package org.rpmcomparator.service;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 5/08/12
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA. User: mohan Date: 5/08/12 Time: 3:13 PM To change
 * this template use File | Settings | File Templates.
 */
public class MimeLookUp {

    private static final String MIME_TYPE_FILE_PATH = "mime-types.txt";
    private Multimap<String, String> mimeFileMap = ArrayListMultimap.create();
    private static MimeLookUp INSTANCE;
    private static final Logger logger = LoggerFactory.getLogger("MimeLookUp");

    private MimeLookUp() {
    }

    public static synchronized MimeLookUp getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            INSTANCE = new MimeLookUp();
            populateMimeMap(INSTANCE.mimeFileMap);

        }
        return INSTANCE;
    }

    public boolean isJavaArchiveFile(String fileName) {
        String extension = Files.getFileExtension(fileName);
        if (extension.equals("jar")) {
            return true;
        } else {
            return false;
        }
    }

    public static class MimeLineProcessor implements LineProcessor<Multimap<String, String>> {

        private Multimap<String, String> mimeFileMap;

        public MimeLineProcessor(Multimap<String, String> mimeFileMap) {
            this.mimeFileMap = mimeFileMap;
        }

        @Override
        public boolean processLine(String line) throws IOException {
            String[] fields = line.split(",");
            if (fields == null || fields.length != 2) {
                logger.warn("Incorrect number of fieleds at line"
                        + line);
                return false;
            }
            String extension = fields[0].replace(".", "");

            String name = fields[1];
            mimeFileMap.put(extension, name);
            return true;
        }

        @Override
        public Multimap<String, String> getResult() {
            return mimeFileMap;
        }
    }

    public boolean isTextFile(String fileName) {
        String extension = Files.getFileExtension(fileName);
        if (mimeFileMap.containsKey(extension)) {
            Collection<String> names = mimeFileMap.get(extension);
            for (String name : names) {
                if (name.contains("text")) {
                    return true;
                }
            }
        } else {
            logger.warn("Currently we do not support extension :" + extension);
        }
        return false;
    }

    public static Multimap<String, String> populateMimeMap(Multimap<String, String> mimeFileMap) {
        MimeLineProcessor mimeLineProcessor = new MimeLineProcessor(mimeFileMap);
        try {
            return Resources.readLines(Resources.getResource(MIME_TYPE_FILE_PATH),
                    Charset.defaultCharset(), mimeLineProcessor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}