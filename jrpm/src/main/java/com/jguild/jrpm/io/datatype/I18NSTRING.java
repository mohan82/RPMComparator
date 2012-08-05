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
 * A representation of a rpm I18N string data object.
 *
 * @author kuss
 * @version $Id: I18NSTRING.java,v 1.4 2005/11/11 08:27:40 mkuss Exp $
 */
public final class I18NSTRING implements DataTypeIf {

    private static final Logger logger = Logger.getLogger("I18NSTRING");
    private String[] data;

    private int localeIndex;

    private long size;

    I18NSTRING(final String[] data) {
        this.data = data;
        // add 1 to each string for \0 in C strings
        for (int pos = 0; pos < data.length; pos++) {
            this.size += data[pos].length() + 1;
        }
    }

    /**
     * Get the rpm I18N string array as a java string array
     *
     * @return An array of I18N strings (as defined in the tag HEADERI18NTABLE)
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

    /**
     * Set the locale that should be returned by toString()
     *
     * @param index The index of the I18N string array. This should match the tag
     *              HEADERI18NTABLE.
     */
    public void setLocaleIndex(final int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index less than 0");
        }

        if (index > this.data.length) {
            throw new IndexOutOfBoundsException("Index grater than "
                    + (this.data.length - 1));
        }

        this.localeIndex = index;
    }

    /*
     * @see com.jguild.jrpm.io.datatype.DataTypeIf#getType()
     */
    public RPMIndexType getType() {
        return RPMIndexType.I18NSTRING;
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
    public static I18NSTRING readFromStream(final DataInputStream inputStream,
                                            final IndexEntry indexEntry, final long length) throws IOException {
        if (indexEntry.getType() != RPMIndexType.I18NSTRING) {
            throw new IllegalArgumentException("Type <" + indexEntry.getType()
                    + "> does not match <" + RPMIndexType.I18NSTRING + ">");
        }

        // initialize temporary space for data
        byte[] stringData = new byte[(int) length];

        // and read it from stream
        inputStream.readFully(stringData);

        String[] data = new String[(int) indexEntry.getCount()];

        int off = 0;

        for (int pos = 0; pos < indexEntry.getCount(); pos++) {
            data[pos] = RPMUtil.cArrayToString(stringData, off);

            // offset for new string is stringlength + 1 for the \0 in c
            // strings
            if (data[pos].length() == 0) {
                off += data[pos].length();
            } else {
                off += (data[pos].length() + 1);
            }

            if (off > stringData.length) {
                throw new IllegalStateException(
                        "Index wrong; Strings doesn't fit into data area. ["
                                + off + ", " + stringData.length + "]");
            }
        }

        I18NSTRING stringObject = new I18NSTRING(data);

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
        return this.data[this.localeIndex];
    }
}
