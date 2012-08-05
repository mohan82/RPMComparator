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
 * Constants for OS type.
 */
public final class LeadOS implements EnumIf {
    public static final LeadOS UNKNOWN = new LeadOS(_UNKNOWN, "UNKNOWN");
    public static final int _LINUX = 1;
    public static final LeadOS LINUX = new LeadOS(_LINUX, "Linux");
    public static final int _IRIX = 2;
    public static final LeadOS IRIX = new LeadOS(_IRIX, "IRIX");
    public static final int _SUNOS5 = 3;
    public static final LeadOS SUNOS5 = new LeadOS(_SUNOS5, "SunOS 5");
    public static final int _SUNOS4 = 4;
    public static final LeadOS SUNOS4 = new LeadOS(_SUNOS4, "SunOS 4");
    public static final int _AIX = 5;
    public static final LeadOS AIX = new LeadOS(_AIX, "AIX");
    public static final int _HPUX = 6;
    public static final LeadOS HPUX = new LeadOS(_HPUX, "HP-UX");
    public static final int _OSF = 7;
    public static final LeadOS OSF = new LeadOS(_OSF, "OSF");
    public static final int _FREEBSD = 8;
    public static final LeadOS FREEBSD = new LeadOS(_FREEBSD, "FreeBSD");
    public static final int _SCO_SV = 9;
    public static final LeadOS SCO_SV = new LeadOS(_SCO_SV, "SVO SV");
    public static final int _IRIX64 = 10;
    public static final LeadOS IRIX64 = new LeadOS(_IRIX64, "IRIX 64");
    public static final int _NEXTSTEP = 11;
    public static final LeadOS NEXTSTEP = new LeadOS(_NEXTSTEP, "NextStep");
    public static final int _BSD_OS = 12;
    public static final LeadOS BSD_OS = new LeadOS(_BSD_OS, "BSD OS");
    public static final int _MACHTEN = 13;
    public static final LeadOS MACHTEN = new LeadOS(_MACHTEN, "machten");
    public static final int _CYGWIN_NT = 14;
    public static final LeadOS CYGWIN_NT = new LeadOS(_CYGWIN_NT, "Cygwin NT");
    public static final int _CYGWIN_9X = 15;
    public static final LeadOS CYGWIN_9X = new LeadOS(_CYGWIN_9X, "Cygwin 9x");
    public static final int _UNIX_SV = 16;
    public static final LeadOS UNIX_SV = new LeadOS(_UNIX_SV, "UNIX SV");
    public static final int _MINT = 17;
    public static final LeadOS MINT = new LeadOS(_MINT, "MiNT");
    public static final int _OS_390 = 18;
    public static final LeadOS OS_390 = new LeadOS(_OS_390, "OS/390");
    public static final int _VM_ESA = 19;
    public static final LeadOS VM_ESA = new LeadOS(_VM_ESA, "VM/ESA");
    public static final int _LINUX_390 = 20;
    public static final LeadOS LINUX_390 = new LeadOS(_LINUX_390, "Linux OS/390");
    private EnumIf delegate;

    private LeadOS(int os, String name) {
        delegate = new EnumDelegate(LeadOS.class, os, name, this);
    }

    /**
     * Get a enum by id
     *
     * @param id The id of the enum
     * @return The enum object
     */
    public static EnumIf getEnumById(long id) {
        return EnumDelegate.getEnumById(LeadOS.class, id);
    }

    /**
     * Get a enum by name
     *
     * @param name The name of the enum
     * @return The enum object
     */
    public static EnumIf getEnumByName(String name) {
        return EnumDelegate.getEnumByName(LeadOS.class, name);
    }

    /**
     * Get all defined enums of this class
     *
     * @return An array of all defined enum objects
     */
    public static String[] getEnumNames() {
        return EnumDelegate.getEnumNames(LeadOS.class);
    }

    /**
     * Get a enum of this class by id
     *
     * @param os The id
     * @return The enum object
     */
    public static LeadOS getLeadOS(int os) {
        return (LeadOS) getEnumById(os);
    }

    /**
     * Check if this enum class contains a enum of a specified id
     *
     * @param id The id of the enum
     * @return TRUE if the enum is defined in this class
     */
    public static boolean containsEnumId(Long id) {
        return EnumDelegate.containsEnumId(LeadOS.class, id);
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
