package org.rpmcomparator.service;

import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.rpmcompartor.data.MimeLookUp;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 5/08/12
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */

/***
 * This class helps to parse the compressed rpm payload
 *  Currently supports zip,cpio
 *  TODO:tar...other zip processors
 *
 */
public class CompressedRPMPayloadProcessor {
    /**
     * Process a compressed stream and puts them in memory
     */
    public static interface CompressedStreamProcessor {
        /***
         *
         * @param inputStream Given any input stream
         * @return a map of file name and content as byte buffer
         * @throws IOException
         */
        Map<String, ByteBuffer> processStream(InputStream inputStream) throws IOException;
    }

    /**
     *  Decompresses Zip and returns them as (filename, bytebuffer content)
     */
    public static class ZipInputStreamProcessor implements CompressedStreamProcessor {
        @Override
        public Map<String, ByteBuffer> processStream(InputStream inputStream) throws IOException {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            ReadableByteChannel channel = Channels.newChannel(zipInputStream);
            ZipEntry readEntry = null;
            Map<String, ByteBuffer> bufferMap = Maps.newHashMap();
            MimeLookUp mimeLookUp = MimeLookUp.getInstance();
            while ((readEntry = zipInputStream.getNextEntry()) != null) {
                if (!readEntry.isDirectory() && mimeLookUp.isTextFile(readEntry.getName())) {
                    byte[] bytes = ByteStreams.toByteArray(zipInputStream);
                    bufferMap.put(readEntry.getName(), ByteBuffer.wrap(bytes));
                }
            }
            return bufferMap;
        }
    }

    /***
     * Decompresses cpio and returns them as (filename,bytebuffer cotent)
     */
    public static class CpioInputStreamProcessor implements CompressedStreamProcessor {
        @Override
        public Map<String, ByteBuffer> processStream(InputStream inputStream) throws IOException {
            CpioArchiveInputStream cpioArchiveInputStream = new CpioArchiveInputStream(inputStream);
            ReadableByteChannel channel = Channels.newChannel(cpioArchiveInputStream);
            CpioArchiveEntry readEntry = null;
            Map<String, ByteBuffer> bufferMap = Maps.newHashMap();
            MimeLookUp mimeLookUp = MimeLookUp.getInstance();
            while ((readEntry = cpioArchiveInputStream.getNextCPIOEntry()) != null) {
                if (!readEntry.isRegularFile())
                    continue;
                String fileName = readEntry.getName();
                if (mimeLookUp.isTextFile(fileName)) {
                    ByteBuffer buffer = MappedByteBuffer.allocateDirect((int) readEntry.getSize());
                    channel.read(buffer);
                    bufferMap.put(readEntry.getName(), buffer);
                } else if (mimeLookUp.isJavaArchiveFile(fileName)) {
                    bufferMap.putAll(new ZipInputStreamProcessor().processStream(cpioArchiveInputStream));

                }
            }
            return bufferMap;
        }
    }

}
