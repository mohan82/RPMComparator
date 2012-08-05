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

import com.jguild.jrpm.io.datatype.DataTypeIf;
import com.jguild.jrpm.io.datatype.TypeFactory;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents the abstract definition of a header structur. It can be
 * either a signature or a header. The tags of such a structure can be accessed
 * by either their tag id or by their tag name. Also all available and all read
 * tag names in this structure can be accessed.
 *
 * @author kuss
 * @version $Id: Header.java,v 1.10 2004/09/09 09:52:33 pnasrat Exp $
 */

/**
 * Modified:
 * 1) Implemented Serializable
 * 2) Optimized Imports
 * 3) Fixed findbugs suggestions
 * 4) Minor changes
 *
 * @author mohan
 */
public abstract class Header implements java.io.Serializable {
    private static final int HEADER_LENGTH = 16;

    private static final Logger logger = Logger.getLogger("Header");

    private IndexEntry[] indexes;

    private int version;

    private long indexDataSize;

    private long indexNumber;

    private Store store;

    /**
     * The size in bytes of this structure.
     */
    protected long size;

    /**
     * Create a header structure from an input stream. <p/> The header
     * structure of a signature or a header can be read and also the index
     * entries containing the tags for this rpm section (signature or
     * header). <p/> Unless we have a raw header from headerUnload or the
     * database, a header is read consisting of the following fields:
     * <code><pre>
     * byte magic[3];      (3  byte)  (8e ad e8)
     * int version;        (1  byte)
     * byte reserved[4];   (4  byte)
     * long num_index;     (4  byte)
     * long num_data;      (4  byte)
     * </pre></code> <p/> Afterwards the index entries are read and then the tags
     * and the correspondig data entries are read.
     *
     * @param inputStream An inputstream containing rpm file informations
     * @param rawHeader   Are we a raw header (from headerUnload or rpmdb)
     * @throws IOException if an error occurs on reading informations out of the
     *                     stream
     */
    public Header(DataInputStream inputStream, boolean rawHeader, Store store)
            throws IOException {
        this.store = store;

        if (logger.isLoggable(Level.FINER)) {
            logger.finer("Start Reading Header");
        }

        if (!rawHeader) {
            // Read header
            size = HEADER_LENGTH;

            int magic = 0;

            do {
                magic = inputStream.readUnsignedByte();
                if (magic == 0) {
                    inputStream.skip(7);
                }
            } while (magic == 0);

            check(magic == 0x8E, "Header magic 0x" + Integer.toHexString(magic)
                    + " != 0x8E");
            magic = inputStream.readUnsignedByte();
            check(magic == 0xAD, "Header magic 0x" + Integer.toHexString(magic)
                    + " != 0xAD");
            magic = inputStream.readUnsignedByte();
            check(magic == 0xE8, "Header magic 0x" + Integer.toHexString(magic)
                    + " != 0xE8");
            version = inputStream.readUnsignedByte();

            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "version: {0}", version);
            }

            // skip reserved bytes
            inputStream.skipBytes(4);
        }

        indexNumber = inputStream.readInt();

        if (logger.isLoggable(Level.FINER)) {
            logger.log(Level.FINER, "indexes available: {0}", indexNumber);
        }

        indexDataSize = inputStream.readInt();

        if (logger.isLoggable(Level.FINER)) {
            logger.log(Level.FINER, "index data size: {0}", indexDataSize);
        }

        // Read indexes
        // make sure to sort them in order of offset to
        // be able to read the store without jumping arround in
        // the file
        TreeSet _indexes = new TreeSet(new Comparator() {
            public int compare(Object o1, Object o2) {
                return (int) (((IndexEntry) o1).getOffset() - ((IndexEntry) o2)
                        .getOffset());
            }
        });

        for (int i = 0; i < indexNumber; i++) {
            IndexEntry index = new IndexEntry(inputStream);

            _indexes.add(index);
            size += index.getSize();
        }

        indexes = new IndexEntry[0];
        indexes = (IndexEntry[]) _indexes.toArray(indexes);

        // Read store
        for (int i = 0; i < indexes.length; i++) {
            IndexEntry index = indexes[i];
            DataTypeIf dataObject = null;

            if (logger.isLoggable(Level.FINER)) {
                logger.log(Level.FINER, "Reading for tag ''{0}'' ''{1}'' entries of type ''{2}''",
                        new Object[]{store.getTagNameForId(index.getTag()), index.getCount(), index.getType().getName()});
            }

            dataObject = TypeFactory
                    .createFromStream(inputStream, index,
                            (i < (indexes.length - 1)) ? (indexes[i + 1]
                                    .getOffset() - index.getOffset())
                                    : (indexDataSize - index.getOffset()));

            // adjust size
            size += dataObject.getSize();

            store.setTag(index.getTag(), dataObject);
        }

        if (logger.isLoggable(Level.FINER)) {
            logger.finer("");
        }

        if (logger.isLoggable(Level.FINER)) {
            logger.finer("Finished Reading Header");
        }
    }

    /**
     * Construct a header structure for the given input stream.
     *
     * @param inputStream
     * @throws IOException
     */
    public Header(DataInputStream inputStream, Store store) throws IOException {
        this(inputStream, false, store);
    }

    /**
     * Get the size in bytes of this structure
     *
     * @return The size in bytes.
     */
    public long getSize() {
        return size;
    }

    /**
     * Asserts a boolean value and throws an exception if it is false
     *
     * @param test A boolean test variable
     * @throws IOException if the variable test is false
     */
    private static void check(boolean test, String message)
            throws IOException {
        if (!test) {
            throw new IOException("Corrupted archive: " + message);
        }
    }
}
