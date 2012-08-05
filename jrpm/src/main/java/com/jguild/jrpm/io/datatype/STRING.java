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
package com.jguild.jrpm.io.datatype;

import com.jguild.jrpm.io.IndexEntry;
import com.jguild.jrpm.io.constant.RPMIndexType;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A representation of a rpm string data object.
 *
 * @author kuss
 * @version $Id: STRING.java,v 1.4 2005/11/11 08:27:40 mkuss Exp $
 */
public final class STRING implements DataTypeIf {

    private static final Logger logger = Logger.getGlobal();
    private String data;

    private int size;

    STRING(final String data) {
        this.data = data;
        // add one to size for the \0 in C strings.
        this.size = data.length() + 1;
    }

    /**
     * Get the rpm string as a java string
     *
     * @return A string
     */
    public String getData() {
        return this.data;
    }

    /*
     * @see com.jguild.jrpm.io.datatype.DataTypeIf#getData()
     */
    public Object getDataObject() {
        return this.data;
    }

    /*
     * @see com.jguild.jrpm.io.datatype.DataTypeIf#getType()
     */
    public RPMIndexType getType() {
        return RPMIndexType.STRING;
    }

    /**
     * Constructs a type froma stream
     *
     * @param inputStream An input stream
     * @param indexEntry  The index informations
     * @param length      the length of the data
     * @return The size of the read data
     * @throws IOException if an I/O error occurs.
     */
    public static STRING readFromStream(final DataInputStream inputStream,
                                        final IndexEntry indexEntry, final long length) throws IOException {
        if (indexEntry.getType() != RPMIndexType.STRING) {
            throw new IllegalArgumentException("Type <" + indexEntry.getType()
                    + "> does not match <" + RPMIndexType.STRING + ">");
        }

        if (indexEntry.getCount() != 1) {
            throw new IllegalArgumentException(
                    "There can be only one string per tag of type STRING");
        }

        // initialize temporary space for data
        byte[] stringData = new byte[(int) length];

        // and read it from stream
        inputStream.readFully(stringData);

        String str = RPMUtil.cArrayToString(stringData, 0);
        STRING stringObject = new STRING(str);

        if (logger.isLoggable(Level.FINER)) {
            logger.finer(stringObject.toString());
            if (stringObject.size != stringData.length) {
                logger.warning("STRING size differs (is:" + stringData.length
                        + ";should:" + stringObject.size + ")");
            }
        }

        stringObject.size = stringData.length;

        return stringObject;
    }

    /*
     * @see com.jguild.jrpm.io.datatype.DataTypeIf#isArray()
     */
    public boolean isArray() {
        return false;
    }

    /*
     * @see com.jguild.jrpm.io.datatype.DataTypeIf#getElementCount()
     */
    public long getElementCount() {
        return 1;
    }

    /*
     * @see com.jguild.jrpm.io.datatype.DataTypeIf#getSize()
     */
    public long getSize() {
        return this.size;
    }

    /*
     * @see com.jguild.jrpm.io.datatype.DataTypeIf#get(int)
     */
    public Object get(final int i) {
        if (i != 0) {
            throw new IndexOutOfBoundsException();
        }

        return this.data;
    }

    /*
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return this.data;
    }
}
