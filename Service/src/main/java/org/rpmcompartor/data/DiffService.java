package org.rpmcompartor.data;

import name.fraser.neil.plaintext.diff_match_patch;

import java.io.*;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: mohan
 * Date: 31/07/12
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
public final class DiffService {

    private  DiffService(){

    }
    public static String extractTextFromStream(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        LineNumberReader reader = new LineNumberReader(new BufferedReader(new InputStreamReader(inputStream)));
        String line = null;
        while ((line = reader.readLine()) != null) {
            builder.append(line);

        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {

        String text1 = extractTextFromStream(new BufferedInputStream(new FileInputStream(new File("/home/mohan/test1.txt"))));
        String text2 = extractTextFromStream(new BufferedInputStream(new FileInputStream(new File("/home/mohan/test2.txt"))));
        diff_match_patch diffObj = new diff_match_patch();
        LinkedList<diff_match_patch.Diff> diffList = diffObj.diff_main(text1, text2);
        diffObj.diff_cleanupEfficiency(diffList);
        for (diff_match_patch.Diff diff : diffList) {
            System.out.println(text1);
            System.out.println(diff.operation + "----" + diff.text);

        }
    }
}
