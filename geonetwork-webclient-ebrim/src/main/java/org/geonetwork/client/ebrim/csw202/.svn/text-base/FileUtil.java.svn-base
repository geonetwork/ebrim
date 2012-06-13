package org.geonetwork.client.ebrim.csw202;

import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilenameFilter;


public class FileUtil {
    public static String readFileAsString(String filePath) throws java.io.IOException {
        byte[] buffer = new byte[(int) new File(filePath).length()];
        BufferedInputStream f = new BufferedInputStream(new FileInputStream(filePath));
        f.read(buffer);
        return new String(buffer);
    }

    public static String[] getFilesfromDir(String dirPath, final String ext) {
        File dir = new File(dirPath);

        String[] children = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(ext);
            }
        });
        return children;

    }
}

