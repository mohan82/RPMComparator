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
 * A representation of a rpm 8 byte integer array data object.
 *
 * @author kuss
 * @version $Id: INT8.java,v 1.4 2005/11/11 08:27:40 mkuss Exp $
 */
public final class INT8 implements DataTypeIf {

    private static final Logger logger = Logger.getGlobal();
    private byte[] data;

    private long size;

    INT8(final byte[] data) {
        this.data = data;
        this.size = data.length;
    }

    /**
     * Get the rpm int8 array as a java byte array
     *
     * @return An array of bytes
     */
    public byte[] getData() {
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
        return RPMIndexType.INT8;
    }

    /**
     * Constructs a type froma stream
     *
     * @param inputStream An input stream
     * @param indexEntry  The index informations
     * @return The size of the read data
     * @throws IOException if an I/O error occurs.
     */
    public static INT8 readFromStream(final DataInputStream inputStream,
                                      final IndexEntry indexEntry) throws IOException {
        if (indexEntry.getType() != RPMIndexType.INT8) {
            throw new IllegalArgumentException("Type <" + indexEntry.getType()
                    + "> does not match <" + RPMIndexType.INT8 + ">");
        }

        byte[] data = new byte[(int) indexEntry.getCount()];

        for (int pos = 0; pos < indexEntry.getCount(); pos++) {
            data[pos] = inputStream.readByte();
        }

        INT8 int8Object = new INT8(data);

        if (logger.isLoggable(Level.FINER)) {
            logger.finer(int8Object.toString());
        }

        // int8Object.size = indexEntry.getType().getSize()
        // * indexEntry.getCount();

        return int8Object;
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
        return new Byte(this.data[i]);
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
            buf.append(this.data[pos] & 0x0FF);

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
