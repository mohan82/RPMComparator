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

/**
 * Constants for Architecture type.
 *
 * @version $Id: LeadArchitecture.java,v 1.3 2003/10/20 16:32:12 mkuss Exp $
 */
public final class LeadArchitecture implements EnumIf {
    public static final LeadArchitecture UNKNOWN = new LeadArchitecture(_UNKNOWN, "UNKNOWN");
    public static final int _I386 = 1;
    public static final LeadArchitecture I386 = new LeadArchitecture(_I386, "i386");
    public static final int _ALPHA = 2;
    public static final LeadArchitecture ALPHA = new LeadArchitecture(_ALPHA, "Alpha");
    public static final int _SPARC = 3;
    public static final LeadArchitecture SPARC = new LeadArchitecture(_SPARC, "Sparc");
    public static final int _MIPS = 4;
    public static final LeadArchitecture MIPS = new LeadArchitecture(_MIPS, "MIPS");
    public static final int _POWERPC = 5;
    public static final LeadArchitecture POWERPC = new LeadArchitecture(_POWERPC, "PowerPC");
    public static final int _A68000 = 6;
    public static final LeadArchitecture A68000 = new LeadArchitecture(_A68000, "68000");
    public static final int _SGI = 7;
    public static final LeadArchitecture SGI = new LeadArchitecture(_SGI, "SGI");
    public static final int _RS6000 = 8;
    public static final LeadArchitecture RS6000 = new LeadArchitecture(_RS6000, "RS6000");
    public static final int _IA64 = 9;
    public static final LeadArchitecture IA64 = new LeadArchitecture(_IA64, "IA64");
    public static final int _SPARC64 = 10;
    public static final LeadArchitecture SPARC64 = new LeadArchitecture(_SPARC64, "Sparc64");
    public static final int _MIPSEL = 11;
    public static final LeadArchitecture MIPSEL = new LeadArchitecture(_MIPSEL, "Mipsel");
    public static final int _ARM = 12;
    public static final LeadArchitecture ARM = new LeadArchitecture(_ARM, "ARM");
    public static final int _M68KMINT = 13;
    public static final LeadArchitecture M68KMINT = new LeadArchitecture(_M68KMINT, "m68kmint");
    public static final int _S390 = 14;
    public static final LeadArchitecture S390 = new LeadArchitecture(_S390, "S/390");
    public static final int _S390X = 15;
    public static final LeadArchitecture S390X = new LeadArchitecture(_S390X, "S/390x");
    private EnumIf delegate;

    private LeadArchitecture(int architecture, String name) {
        delegate = new EnumDelegate(LeadArchitecture.class, architecture, name, this);
    }

    /**
     * Get a enum by id
     *
     * @param id The id of the enum
     * @return The enum object
     */
    public static EnumIf getEnumById(long id) {
        return EnumDelegate.getEnumById(LeadArchitecture.class, id);
    }

    /**
     * Get a enum by name
     *
     * @param name The name of the enum
     * @return The enum object
     */
    public static EnumIf getEnumByName(String name) {
        return EnumDelegate.getEnumByName(LeadArchitecture.class, name);
    }

    /**
     * Get all defined enums of this class
     *
     * @return An array of all defined enum objects
     */
    public static String[] getEnumNames() {
        return EnumDelegate.getEnumNames(LeadArchitecture.class);
    }

    /**
     * Get a enum of this class by id
     *
     * @param architecture The id
     * @return The enum object
     */
    public static LeadArchitecture getLeadArchitecture(int architecture) {
        return (LeadArchitecture) getEnumById(architecture);
    }

    /**
     * Check if this enum class contains a enum of a specified id
     *
     * @param id The id of the enum
     * @return TRUE if the enum is defined in this class
     */
    public static boolean containsEnumId(Long id) {
        return EnumDelegate.containsEnumId(LeadArchitecture.class, id);
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
