/*
 * Copyright (c) 2012. Mohan Ambalavanan
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *    Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License
 */

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
