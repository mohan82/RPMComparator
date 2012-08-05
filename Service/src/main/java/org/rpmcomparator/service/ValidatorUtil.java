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

import com.google.common.base.Preconditions;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 29/07/12
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidatorUtil {
    /**
     * @param fileName
     * @return
     * @throws IOException,RuntimeException
     */
    public static File getValideFile(String fileName) {
        File file = new File(Preconditions.checkNotNull(fileName, "Give file cannot be null"));
        Preconditions.checkArgument(file.exists(), "Give file:" + fileName + "Should exist");
        return file;
    }
}
