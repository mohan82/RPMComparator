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

import org.rpmcomparator.service.data.RPM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;

import static org.rpmcomparator.service.ValidatorUtil.getValideFile;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 29/07/12
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class RPMParser {
    private Logger logger = LoggerFactory.getLogger(RPMParser.class);


    public RPMParser() {

    }

    public RPM parseRPM(String fileName) throws RPMParseException {
        try {
            return parseRPMFromFile(getValideFile(fileName));
        } catch (Exception e) {
            throw new RPMParseException("Cannot parse :", e);
        }
    }

    public RPM parseRPMFromFile(File file) throws RPMParseException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            return parseRPMFromStreamAndClose(new BufferedInputStream(new FileInputStream(file)));
        } catch (Exception e) {
            throw new RPMParseException("Cannot parse: ", e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    fileInputStream = null;
                    //cannot do much here other than dereferencing
                    // the stream object
                }
            }
        }
    }

    /**
     * NOTICE: Always Closes stream after parsing RPM or so hold on to RPM Object
     * after this call and dont try to open stream again
     *
     * @param inputStream
     * @return
     * @throws RPMParseException
     */

    public RPM parseRPMFromStreamAndClose(InputStream inputStream) throws RPMParseException {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(inputStream);
            return new RPMBuilder(dataInputStream).buildRPMPayload();

        } catch (Exception e) {
            throw new RPMParseException("Cannot parse: ", e);
        } finally {
            try {
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
            } catch (IOException e) {
                dataInputStream = null;
            }
        }

    }

    //Helper Method TODO: Use Guava instead

    /***
     *
     * @param buf
     * @return
     * @throws IOException
     */
    public static byte[] readBufferFully(ByteBuffer buf) throws IOException {
        byte b[] = new byte[buf.capacity()];
        if (buf.hasRemaining()) {
            buf.get(b, 0, b.length);

        }
        return b;

    }
}

