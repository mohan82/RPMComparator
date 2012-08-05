/*
 *  Copyright 2003 jRPM Team
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jguild.jrpm.io;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RPM Signature.
 */
public class RPMSignature extends Header {

    private static final Logger logger = Logger.getLogger("RPMSignature");

    /**
     * Creates a new RPMSignature object from an input stream
     *
     * @param inputStream The input stream
     * @throws IOException if an error occurs on reading informations out of the
     *                     stream
     */
    public RPMSignature(DataInputStream inputStream, Store store)
            throws IOException {
        super(inputStream, store);

        // Make signature size modulo 8 = 0
        long fill = (size % 8L);

        if (fill != 0) {
            fill = 8 - fill;
        }

        if (logger.isLoggable(Level.FINER)) {
            logger.finer("skip " + fill + " bytes for signature");
        }

        size += inputStream.skip(fill);
    }
}
