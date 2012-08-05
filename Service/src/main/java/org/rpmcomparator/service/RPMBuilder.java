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

package org.rpmcomparator.service;

import com.jguild.jrpm.io.RPMHeader;
import com.jguild.jrpm.io.RPMLead;
import com.jguild.jrpm.io.RPMSignature;
import com.jguild.jrpm.io.Store;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.rpmcompartor.data.RPM;
import org.rpmcompartor.data.RPMFileHeaderData;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.XZInputStream;
import  static org.rpmcomparator.service.CompressedRPMPayloadProcessor.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 5/08/12
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class RPMBuilder {
        private final DataInputStream inputStream;
        private final Store store;
        private RPMHeaderBuilder rpmHeaderBuilder;
        private RPMPayloadBuilder rpmPayloadBuilder;

        public RPMBuilder(DataInputStream inputStream) {
            this.inputStream = inputStream;
            rpmHeaderBuilder = new RPMHeaderBuilder();
            this.rpmPayloadBuilder = new RPMPayloadBuilder();
            this.store = new Store();
        }

        public RPM buildRPMPayload() throws IOException {
            RPMFileHeaderData fileHeaderData = buildRPMFileHeaderData();
            Map<String, ByteBuffer> data = rpmPayloadBuilder.buildPayload();
            return new RPM(fileHeaderData, data);
        }

        protected RPMFileHeaderData buildRPMFileHeaderData() throws IOException {
            RPMLead lead = rpmHeaderBuilder.buildRPMLead();
            RPMSignature signature = rpmHeaderBuilder.buildRPMSignature();
            RPMHeader header = rpmHeaderBuilder.buildRPMHeader();
            return new RPMFileHeaderData(header, lead, signature, store);
        }

        public class RPMHeaderBuilder {
            //all the protected builders carry state
            // should be called in the following order
            // 1)Lead 2)Signature 3) header
            protected RPMLead buildRPMLead() throws IOException {
                return new RPMLead(inputStream);
            }

            protected RPMSignature buildRPMSignature() throws IOException {
                return new RPMSignature(inputStream, store);
            }

            protected RPMHeader buildRPMHeader() throws IOException {
                return new RPMHeader(inputStream, store);
            }
        }

        public class RPMPayloadBuilder {

            protected Map<String, ByteBuffer> buildPayload() throws IOException {
                String payloadCompressor = RPMFileFinderUtil.getPayloadCompressor(store);
                return processStream(payloadCompressor);
            }

            private Map<String, ByteBuffer> processStream(String compressor) throws IOException {
                InputStream compressedStream = null;
                if (compressor.equalsIgnoreCase("gzip")) {
                    compressedStream = new GZIPInputStream(inputStream, (1024 * 1024));
                } else if (compressor.equalsIgnoreCase("bzip2")) {
                    compressedStream = new BZip2CompressorInputStream(inputStream);
                } else if (compressor.equals("lzma")) {
                    compressedStream = new LZMA2InputStream(inputStream, (1024 * 1024));
                    return new CpioInputStreamProcessor().processStream(compressedStream);
                } else if (compressor.equals("xz")) {
                    compressedStream = new XZInputStream(inputStream);
                } else {
                    throw new UnsupportedOperationException("We do not support given compression format Report a bug for this compression format:" + compressor);
                }
                return new CpioInputStreamProcessor().processStream(compressedStream);
            }
        }
}
