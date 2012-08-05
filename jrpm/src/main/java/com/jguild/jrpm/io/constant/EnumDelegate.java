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

import java.util.HashMap;
import java.util.TreeMap;


/**
 * Abstract Enum class.
 *
 * @version $Id: EnumDelegate.java,v 1.2 2003/10/20 16:32:12 mkuss Exp $
 */
class EnumDelegate implements EnumIf {
    private static final HashMap map = new HashMap();
    public static final int _UNKNOWN = -1;
    private String name;
    private long id;

    /**
     * Creates a new EnumDelegate object.
     *
     * @param refClass Referencing class for this enum (the class that implements the enum)
     * @param id       A id for this enum
     * @param name     A name for this enum
     * @param realEnum The actual reference of the enum object (the real enum object that implements EnumIf)
     */
    public EnumDelegate(Class refClass, long id, String name, EnumIf realEnum) {
        this.id = id;
        this.name = name;

        MapEntry mapEntry;

        if (map.containsKey(refClass)) {
            mapEntry = (MapEntry) map.get(refClass);
        } else {
            mapEntry = new MapEntry();
            map.put(refClass, mapEntry);
        }

        mapEntry.idMap.put(new Long(id), realEnum);
        mapEntry.nameMap.put(name.toLowerCase(), realEnum);
    }

    /**
     * Get a enum by id
     *
     * @param refClass referencing class
     * @param id       The id of the enum
     * @return The enum object
     */
    public static EnumIf getEnumById(Class refClass, long id) {
        EnumIf ret = null;
        MapEntry mapEntry = null;

        mapEntry = (MapEntry) map.get(refClass);

        if (mapEntry != null) {
            ret = (EnumIf) mapEntry.idMap.get(new Long(id));

            if (ret == null) {
                // warn
                ret = (EnumIf) mapEntry.idMap.get(new Long(_UNKNOWN));
            }
        }

        return ret;
    }

    /**
     * Get a enum by name
     *
     * @param refClass referencing class
     * @param name     The name of the enum
     * @return The enum object
     */
    public static EnumIf getEnumByName(Class refClass, String name) {
        EnumIf ret = null;
        MapEntry mapEntry = null;

        mapEntry = (MapEntry) map.get(refClass);

        if (mapEntry != null) {
            ret = (EnumIf) mapEntry.nameMap.get(name.toLowerCase());

            if (ret == null) {
                ret = (EnumIf) mapEntry.idMap.get(new Long(_UNKNOWN));
            }
        }

        return ret;
    }

    /**
     * Get all defined enums of this class
     *
     * @param refClass referencing class
     * @return An array of all defined enum objects
     */
    public static String[] getEnumNames(Class refClass) {
        String[] ret = new String[0];
        MapEntry mapEntry = null;

        mapEntry = (MapEntry) map.get(refClass);

        if (mapEntry != null) {
            ret = (String[]) mapEntry.nameMap.keySet().toArray(ret);
        }

        return ret;
    }

    /*
     * @see com.jguild.jrpm.io.constant.EnumIf#getId()
     */
    public long getId() {
        return id;
    }

    /*
     * @see com.jguild.jrpm.io.constant.EnumIf#getName()
     */
    public String getName() {
        return name;
    }

    /**
     * Check if this enum class contains a enum of a specified id
     *
     * @param refClass referencing class
     * @param id       The id of the enum
     * @return TRUE if the enum is defined in this class
     */
    public static boolean containsEnumId(Class refClass, Long id) {
        boolean ret = false;
        MapEntry mapEntry = null;

        mapEntry = (MapEntry) map.get(refClass);

        if (mapEntry != null) {
            ret = mapEntry.idMap.containsKey(id);
        }

        return ret;
    }

    /*
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return id + " : " + name;
    }

    /**
     * Inner class to map ids and names of enums
     *
     * @author kuss
     */
    private class MapEntry {
        TreeMap idMap = new TreeMap();
        TreeMap nameMap = new TreeMap();
    }
}
