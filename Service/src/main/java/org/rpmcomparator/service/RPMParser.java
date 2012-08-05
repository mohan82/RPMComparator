package org.rpmcomparator.service;

import com.google.common.collect.Maps;
import com.google.common.io.ByteStreams;
import com.jguild.jrpm.io.RPMHeader;
import com.jguild.jrpm.io.RPMLead;
import com.jguild.jrpm.io.RPMSignature;
import com.jguild.jrpm.io.Store;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.rpmcompartor.data.MimeLookUp;
import org.rpmcompartor.data.RPM;
import org.rpmcompartor.data.RPMFileHeaderData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tukaani.xz.LZMA2InputStream;
import org.tukaani.xz.XZInputStream;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.rpmcomparator.service.ValidatorUtil.getValideFile;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 29/07/12
 * Time: 3:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class RPMParser {
    private Logger logger = LoggerFactory.getLogger(RPMParser.class);


    public RPMParser() {

    }

    public RPM parseRPM(String fileName) throws RPMParseException {
        try {
            return parseRPMFromFile(getValideFile(fileName));
        } catch (Exception e) {
            throw new RPMParseException("Cannot parse :", e);
        }
    }

    public RPM parseRPMFromFile(File file) throws RPMParseException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            return parseRPMFromStreamAndClose(new BufferedInputStream(new FileInputStream(file)));
        } catch (Exception e) {
            throw new RPMParseException("Cannot parse: ", e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    fileInputStream = null;
                    //cannot do much here other than dereferencing
                    // the stream object
                }
            }
        }
    }

    /**
     * NOTICE: Always Closes stream after parsing RPM or so hold on to RPM Object
     * after this call and dont try to open stream again
     *
     * @param inputStream
     * @return
     * @throws RPMParseException
     */

    public RPM parseRPMFromStreamAndClose(InputStream inputStream) throws RPMParseException {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(inputStream);
            return new RPMBuilder(dataInputStream).buildRPMPayload();

        } catch (Exception e) {
            throw new RPMParseException("Cannot parse: ", e);
        } finally {
            try {
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
            } catch (IOException e) {
                dataInputStream = null;
            }
        }

    }

    //Helper Method TODO: Use Guava instead

    /***
     *
     * @param buf
     * @return
     * @throws IOException
     */
    public static byte[] readBufferFully(ByteBuffer buf) throws IOException {
        byte b[] = new byte[buf.capacity()];
        if (buf.hasRemaining()) {
            buf.get(b, 0, b.length);

        }
        return b;

    }
}

