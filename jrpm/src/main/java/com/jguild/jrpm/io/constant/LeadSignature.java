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
 * Constants for signature type.
 *
 * @version $Id: LeadSignature.java,v 1.3 2003/10/20 16:32:12 mkuss Exp $
 */
public class LeadSignature implements EnumIf {
    public static final LeadSignature UNKNOWN = new LeadSignature(_UNKNOWN, "UNKNOWN");
    public static final int _SIZE = 4;
    public static final LeadSignature SIZE = new LeadSignature(_SIZE, "size");
    public static final int _MD5 = 5;
    public static final LeadSignature MD5 = new LeadSignature(_MD5, "MD5");
    public static final int _PGP = 6;
    public static final LeadSignature PGP = new LeadSignature(_PGP, "PGP");
    private EnumIf delegate;

    private LeadSignature(int signature, String name) {
        delegate = new EnumDelegate(LeadSignature.class, signature, name, this);
    }

    /**
     * Get a enum by id
     *
     * @param id The id of the enum
     * @return The enum object
     */
    public static EnumIf getEnumById(long id) {
        return EnumDelegate.getEnumById(LeadSignature.class, id);
    }

    /**
     * Get a enum by name
     *
     * @param name The name of the enum
     * @return The enum object
     */
    public static EnumIf getEnumByName(String name) {
        return EnumDelegate.getEnumByName(LeadSignature.class, name);
    }

    /**
     * Get all defined enums of this class
     *
     * @return An array of all defined enum objects
     */
    public static String[] getEnumNames() {
        return EnumDelegate.getEnumNames(LeadSignature.class);
    }

    /**
     * Get a enum of this class by id
     *
     * @param signature The id
     * @return The enum object
     */
    public static LeadSignature getLeadSignature(int signature) {
        return (LeadSignature) getEnumById(signature);
    }

    /**
     * Check if this enum class contains a enum of a specified id
     *
     * @param id The id of the enum
     * @return TRUE if the enum is defined in this class
     */
    public static boolean containsEnumId(Long id) {
        return EnumDelegate.containsEnumId(LeadSignature.class, id);
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
