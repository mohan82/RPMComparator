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

import com.jguild.jrpm.io.constant.RPMIndexType;

/**
 * Global interface for all RPM data types.
 *
 * @author kuss
 * @version $Id: DataTypeIf.java,v 1.3 2005/11/11 08:27:40 mkuss Exp $
 */
public interface DataTypeIf {
    /**
     * Returns TRUE if this object contains an array or FALSE if it is not an
     * array.
     *
     * @return TRUE if this object contains an array
     */
    boolean isArray();

    /**
     * Get the data as an object.
     *
     * @return The object
     */
    Object getDataObject();

    /**
     * Returns the number of elements stored in this data type.
     *
     * @return The number of elements
     */
    long getElementCount();

    /**
     * Returns the size of this type in the RPM file
     *
     * @return The size in bytes
     */
    long getSize();

    /**
     * Get the type of this data object
     *
     * @return The type
     */
    RPMIndexType getType();

    /**
     * Gets the i-th element of this object.
     *
     * @param i The element number
     * @return The object
     * @throws IndexOutOfBoundsException if i doesn't fit into the array
     */
    Object get(int i);
}
