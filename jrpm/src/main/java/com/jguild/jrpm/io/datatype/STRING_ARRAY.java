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
 * A representation of a rpm string array data object.
 *
 * @author kuss
 * @version $Id: STRING_ARRAY.java,v 1.4 2005/11/11 08:27:40 mkuss Exp $
 */
public final class STRING_ARRAY implements DataTypeIf {

    private static final Logger logger = Logger.getGlobal();
    private String[] data;

    private long size;

    STRING_ARRAY(final String[] data) {
        this.data = data;
        // add 1 to each string for \0 in C strings
        for (int pos = 0; pos < data.length; pos++)
            this.size += data[pos].length() + 1;
    }

    /**
     * Get the rpm string array as a java string array
     *
     * @return An array of strings
     */
    public String[] getData() {
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
        return RPMIndexType.STRING_ARRAY;
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
    public static STRING_ARRAY readFromStream(
            final DataInputStream inputStream, final IndexEntry indexEntry,
            final long length) throws IOException {
        if (indexEntry.getType() != RPMIndexType.STRING_ARRAY) {
            throw new IllegalArgumentException("Type <" + indexEntry.getType()
                    + "> does not match <" + RPMIndexType.STRING_ARRAY + ">");
        }

        // initialize temporary space for data
        byte[] stringData = new byte[(int) length];

        // and read it from stream
        inputStream.readFully(stringData);

        String data[] = new String[(int) indexEntry.getCount()];

        int off = 0;

        for (int pos = 0; pos < indexEntry.getCount(); pos++) {
            data[pos] = RPMUtil.cArrayToString(stringData, off);

            // add 1 for \0 in C strings
            off += (data[pos].length() + 1);

            // throw an exception if we have read out of the data space
            if (off > stringData.length) {
                throw new IllegalStateException(
                        "Index wrong; Strings doesn't fit into data area. ["
                                + off + ", " + stringData.length + "]");
            }
        }

        STRING_ARRAY stringObject = new STRING_ARRAY(data);
        if (logger.isLoggable(Level.FINER)) {
            logger.finer(stringObject.toString());
            if (stringObject.size != stringData.length) {
                logger.warning("STRING_ARRAY size differs (is:" + stringData.length
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
        return true;
    }

    /*
     * @see com.jguild.jrpm.io.datatype.DataTypeIf#getElementCount()
     */
    public long getElementCount() {
        return this.data.length;
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
        return this.data[i];
    }

    /*
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer buf = new StringBuffer();

        if (this.data.length > 1) {
            buf.append("[");
        }

        for (int pos = 0; pos < this.data.length; pos++) {
            buf.append(this.data[pos]);

            if (pos < (this.data.length - 1)) {
                buf.append(", ");
            }
        }

        if (this.data.length > 1) {
            buf.append("]");
        }

        return buf.toString();
    }
}
