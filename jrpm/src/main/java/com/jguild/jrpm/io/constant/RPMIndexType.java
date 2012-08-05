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
package com.jguild.jrpm.io.constant;

import java.io.Serializable;


/**
 * Constants for index type.
 *
 * @version $Id: RPMIndexType.java,v 1.3 2003/10/20 16:32:12 mkuss Exp $
 */

/**
 * Modified:
 * 1) Implemented Serializable
 * 2) Optimized Imports
 *
 * @author mohan
 */
public final class RPMIndexType implements EnumIf, Serializable {
    public static final RPMIndexType UNKNOWN = new RPMIndexType(_UNKNOWN, "UNKNOWN", 0);
    public static final int _NULL = 0;
    public static final RPMIndexType NULL = new RPMIndexType(_NULL, "NULL", 0);
    public static final int _CHAR = 1;
    public static final RPMIndexType CHAR = new RPMIndexType(_CHAR, "CHAR", 1);
    public static final int _INT8 = 2;
    public static final RPMIndexType INT8 = new RPMIndexType(_INT8, "INT8", 1);
    public static final int _INT16 = 3;
    public static final RPMIndexType INT16 = new RPMIndexType(_INT16, "INT16", 2);
    public static final int _INT32 = 4;
    public static final RPMIndexType INT32 = new RPMIndexType(_INT32, "INT32", 4);
    public static final int _INT64 = 5;
    public static final RPMIndexType INT64 = new RPMIndexType(_INT64, "INT64", 8);
    public static final int _STRING = 6;
    public static final RPMIndexType STRING = new RPMIndexType(_STRING, "STRING", 1);
    public static final int _BIN = 7;
    public static final RPMIndexType BIN = new RPMIndexType(_BIN, "BIN", 1);
    public static final int _STRING_ARRAY = 8;
    public static final RPMIndexType STRING_ARRAY = new RPMIndexType(_STRING_ARRAY, "STRING_ARRAY", 1);
    public static final int _I18NSTRING = 9;
    public static final RPMIndexType I18NSTRING = new RPMIndexType(_I18NSTRING, "I18NSTRING", 1);
    private EnumIf delegate;
    private int size;

    private RPMIndexType(int type, String name, int size) {
        delegate = new EnumDelegate(RPMIndexType.class, type, name, this);
        this.size = size;
    }

    /**
     * Get a enum by id
     *
     * @param id The id of the enum
     * @return The enum object
     */
    public static EnumIf getEnumById(long id) {
        return EnumDelegate.getEnumById(RPMIndexType.class, id);
    }

    /**
     * Get a enum by name
     *
     * @param name The name of the enum
     * @return The enum object
     */
    public static EnumIf getEnumByName(String name) {
        return EnumDelegate.getEnumByName(RPMIndexType.class, name);
    }

    /**
     * Get all defined enums of this class
     *
     * @return An array of all defined enum objects
     */
    public static String[] getEnumNames() {
        return EnumDelegate.getEnumNames(RPMIndexType.class);
    }

    /**
     * Get a enum of this class by id
     *
     * @param type The id
     * @return The enum object
     */
    public static RPMIndexType getRPMIndexType(long type) {
        return (RPMIndexType) getEnumById(type);
    }

    /**
     * Get the size of this enum in byte
     *
     * @return The size in byte
     */
    public int getSize() {
        return size;
    }

    /**
     * Check if this enum class contains a enum of a specified id
     *
     * @param id The id of the enum
     * @return TRUE if the enum is defined in this class
     */
    public static boolean containsEnumId(Long id) {
        return EnumDelegate.containsEnumId(RPMIndexType.class, id);
    }

    /*
     * @see com.jguild.jrpm.io.constant.EnumIf#getId()
     */
    public long getId() {
        return delegate.getId();
    }

    /*
     * @see com.jguild.jrpm.io.constant.EnumIf#getName()
     */
    public String getName() {
        return delegate.getName();
    }

    /*
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return delegate.toString();
    }
}
