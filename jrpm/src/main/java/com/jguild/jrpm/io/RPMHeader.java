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

/**
 * RPM Header.
 *
 * @version $Id: RPMHeader.java,v 1.7 2004/09/09 09:52:48 pnasrat Exp $
 */
public class RPMHeader extends Header {
    /**
     * Creates a new RPMHeader object out of an input stream.
     *
     * @param inputStream The input stream
     * @throws IOException if an error occured during read of the rpm
     */
    public RPMHeader(DataInputStream inputStream, Store store)
            throws IOException {
        super(inputStream, store);
    }

    public RPMHeader(DataInputStream inputStream, boolean raw, Store store)
            throws IOException {
        super(inputStream, raw, store);
    }
}