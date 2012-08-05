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
package com.jguild.jrpm.io;

import com.jguild.jrpm.io.constant.LeadArchitecture;
import com.jguild.jrpm.io.constant.LeadOS;
import com.jguild.jrpm.io.constant.LeadSignature;
import com.jguild.jrpm.io.constant.LeadType;
import com.jguild.jrpm.io.datatype.RPMUtil;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * The Java Version of the C struct for the lead.
 * <p/>
 * <code><pre>C struct :
 * struct rpmlead {
 *    unsigned char magic[4];
 *    unsigned char major, minor;
 *    short type;            (2 byte)
 *    short archnum;         (2 byte)
 *    char name[66];
 *    short osnum;           (2 byte)
 *    short signature_type;  (2 byte)
 *    char reserved[16];
 * } ;</pre></code>
 *
 * @version $Id: RPMLead.java,v 1.6 2003/10/20 16:32:11 mkuss Exp $
 */

/**
 * 1) implemented serializable
 * 2) Minor changes
 * 3) Changed constructor level from protected to public
 *
 * @author mohan
 */
public class RPMLead implements Serializable {
    private static final Logger logger = Logger.getLogger("RPMLead");
    private LeadArchitecture arch;
    private LeadOS os;
    private LeadSignature sigType;
    private LeadType type;
    private String name;
    private int major;
    private int minor;

    public RPMLead(DataInputStream inputStream)
            throws IOException {
        if (logger.isLoggable(Level.FINER)) {
            logger.finer("Start Reading Lead");
        }

        try {
            int magic = inputStream.readUnsignedByte();
            check(magic == 0xED, "Lead magic 0x" + Integer.toHexString(magic) + " != 0xED");
            magic = inputStream.readUnsignedByte();
            check(magic == 0xAB, "Lead magic 0x" + Integer.toHexString(magic) + " != 0xAB");
            magic = inputStream.readUnsignedByte();
            check(magic == 0xEE, "Lead magic 0x" + Integer.toHexString(magic) + " != 0xEE");
            magic = inputStream.readUnsignedByte();
            check(magic == 0xDB, "Lead magic 0x" + Integer.toHexString(magic) + " != 0xDB");
            major = inputStream.readUnsignedByte();
            check(major < 5, "Major Number should be less than 5");

            if (logger.isLoggable(Level.FINER)) {
                logger.finer("major: " + major);
            }

            minor = inputStream.readUnsignedByte();

            if (logger.isLoggable(Level.FINER)) {
                logger.finer("minor: " + minor);
            }

            type = LeadType.getLeadType(inputStream.readUnsignedShort());

            if (logger.isLoggable(Level.FINER)) {
                logger.finer("type: " + type.getName());
            }

            arch = LeadArchitecture.getLeadArchitecture(inputStream.readUnsignedShort());

            if (logger.isLoggable(Level.FINER)) {
                logger.finer("arch: " + arch.getName());
            }

            byte[] nameBuf = new byte[66];

            inputStream.readFully(nameBuf);
            name = RPMUtil.cArrayToString(nameBuf, 0);

            if (logger.isLoggable(Level.FINER)) {
                logger.finer("name: " + name);
            }

            os = LeadOS.getLeadOS(inputStream.readUnsignedShort());

            if (logger.isLoggable(Level.FINER)) {
                logger.finer("os: " + os.getName());
            }

            sigType = LeadSignature.getLeadSignature(inputStream.readUnsignedShort());

            if (logger.isLoggable(Level.FINER)) {
                logger.finer("sigType: " + sigType.getName());
            }

            inputStream.skipBytes(16);

            check(!type.equals(LeadType.UNKNOWN), "Type is not specified");
            check(!sigType.equals(LeadType.UNKNOWN), "Signaturetype is not specified");
        } finally {
            if (logger.isLoggable(Level.FINER)) {
                logger.finer("Finished Reading Lead");
            }
        }
    }

    /**
     * Get the architecture of a rpm
     *
     * @return the architecture
     */
    public LeadArchitecture getArchitecture() {
        return arch;
    }

    /**
     * Get the major number of the rpm version a rpm is build for
     *
     * @return The major number
     */
    public int getMajorVersion() {
        return major;
    }

    /**
     * Get the minor number of the rpm version a rpm is build for
     *
     * @return The minor number
     */
    public int getMinorVersion() {
        return minor;
    }

    /**
     * Get the name of this rpm. This field has a maximum length of 65
     * characters + one for the ending \0 for c strings.
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the operation system a rpm is build for
     *
     * @return The operation system
     */
    public LeadOS getOperationSystem() {
        return os;
    }

    /**
     * Get the type of signature this rpm provides
     *
     * @return The signature
     */
    public LeadSignature getSignatureType() {
        return sigType;
    }

    /**
     * Get the size of this structure in bytes (as defined for a rpm file)
     *
     * @return The size (96 bytes)
     */
    public final long getSize() {
        return 96;
    }

    /**
     * Get the type of a rpm file (binary or source)
     *
     * @return The type
     */
    public LeadType getType() {
        return type;
    }

    private static final void check(boolean test, String message)
            throws IOException {
        if (!test) {
            throw new IOException("Corrupted archive: " + message);
        }
    }
}
