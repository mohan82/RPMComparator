package org.rpmcomparator.service;

import com.google.common.base.Preconditions;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 29/07/12
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ValidatorUtil {
    /**
     * @param fileName
     * @return
     * @throws IOException,RuntimeException
     */
    public static File getValideFile(String fileName) {
        File file = new File(Preconditions.checkNotNull(fileName, "Give file cannot be null"));
        Preconditions.checkArgument(file.exists(), "Give file:" + fileName + "Should exist");
        return file;
    }
}
