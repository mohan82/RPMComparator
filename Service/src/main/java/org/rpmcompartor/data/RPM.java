package org.rpmcompartor.data;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 29/07/12
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class RPM implements Serializable {
    private static final long serialVersionUID = -2671595086609357206L;
    private RPMFileHeaderData rpmFileHeaderData;
    private Map<String, ByteBuffer> byteBufferMap;

    public RPM(RPMFileHeaderData rpmFileHeaderData,Map<String, ByteBuffer> byteBufferMap) {
        this.rpmFileHeaderData = rpmFileHeaderData;
        this.byteBufferMap = byteBufferMap;

    }

    public RPMFileHeaderData getRpmFileHeaderData() {
        return rpmFileHeaderData;
    }

    public Map<String, ByteBuffer> getByteBufferMap() {
        return byteBufferMap;
    }
}
