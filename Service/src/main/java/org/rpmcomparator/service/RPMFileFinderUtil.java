package org.rpmcomparator.service;

import com.jguild.jrpm.io.Store;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 29/07/12
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class RPMFileFinderUtil {
    private enum RPMConstants {
        PAYLOADFORMAT("PAYLOADFORMAT"),
        PAYLOADCOMPRESSOR("PAYLOADCOMPRESSOR");

        private RPMConstants(String name) {
            this.name = name;
        }

        private String name;

        public String val() {
            return name;
        }
    }

    public static String getPayloadFormat(Store store) {
        try {
            return getTagName(getTagIDForName(RPMConstants.PAYLOADFORMAT, store), store);
        } catch (NullPointerException ne) {
            throw new IllegalArgumentException("Cannot find Payload format in given store :", ne);
        }
    }

    public static String getPayloadCompressor(Store store) {
        try {
            return getTagName(getTagIDForName(RPMConstants.PAYLOADCOMPRESSOR, store), store);
        } catch (NullPointerException ne) {
            throw new IllegalArgumentException("Cannot find Payload Compressor in given store ", ne);
        }
    }

    private static Long getTagIDForName(RPMConstants rpmConstants, Store store) {
        return store.getTagIdForName(rpmConstants.val());
    }

    private static String getTagName(Long id, Store store) {
        return store.getTag(id).toString();
    }
}
