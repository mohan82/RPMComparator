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

import java.io.UnsupportedEncodingException;

/**
 * Misc utilities functions.
 *
 * @author kuss
 * @version $Id: RPMUtil.java,v 1.3 2005/11/11 08:27:40 mkuss Exp $
 */
public final class RPMUtil {
    /**
     * Default encoding is US-ASCII for normal string in rpm header. For I18
     * entries the specified encoding (as defined in HEADERI18NTABLE) should be
     * user.
     */
    private static final String DEFAULT_ENCODING = "US-ASCII";

    /**
     * hide constructor
     */
    private RPMUtil() {
        // do nothing
    }

    /**
     * Method to get a beautyfied representation of an byte array as a hex
     * string. One byte will always be displayed as two hex digits.
     *
     * @param barray An byte array that should be converted to a hex string
     * @return The hex string
     */
    public static String byteArrayToHexString(final byte[] barray) {
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < barray.length; i++) {
            buf.append(byteToHexString(barray[i]));
        }

        return buf.toString();
    }

    /**
     * Method to get a beautyfied representation of a byte as a hex string. The
     * hex block will be displayed always as two digits.
     *
     * @param b A byte that should be converted to a hex string
     * @return The hex string
     */
    public static String byteToHexString(final byte b) {
        String hex = Integer.toHexString(0x0FF & b);

        if (hex.length() == 1) {
            hex = "0" + hex;
        }

        return hex;
    }

    /**
     * Method to convert a null terminated C string into a java string using the
     * DEFAULT_ENCODING
     *
     * @param data   An array of bytes containing a C string
     * @param offset An offset from which to start to read the string from the data
     *               array
     * @return A java string representig a null terminated C string
     * @throws UnsupportedEncodingException if the encoding is not supported
     */
    public static String cArrayToString(final byte[] data, final int offset)
            throws UnsupportedEncodingException {
        return cArrayToString(data, offset, DEFAULT_ENCODING);
    }

    /**
     * Method to convert a null terminated C string into a java string using the
     * defined encoding
     *
     * @param data   An array of bytes containing a C string
     * @param offset An offset from which to start to read the string from the data
     *               array
     * @param enc    A encoding as defined in java.lang.String
     * @return A java string representig a null terminated C string
     * @throws UnsupportedEncodingException if the encoding is not supported
     */
    public static String cArrayToString(final byte[] data, final int offset,
                                        final String enc) throws UnsupportedEncodingException {
        if (offset > data.length) {
            throw new IllegalArgumentException("Data offset is too big");
        }

        for (int i = offset; i < data.length; i++) {
            if (data[i] == 0) {
                return new String(data, offset, i - offset, enc);
            }
        }

        // TODO: Warning goes here that there is no null terminated string
        return "";
    }
}
