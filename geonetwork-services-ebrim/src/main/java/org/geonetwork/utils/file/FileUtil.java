package org.geonetwork.utils.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Class with file utilities
 *
 * @author Jose
 */
public class FileUtil {

   /**
     * Gets all files under directory with an specified extension
     *
     * @param path          Path directory to process
     * @param extension     Extension of files
     * @return              Array of files finded
     */
    public static File[] getFiles(String path, final String extension) {
        File dir = new File(path);

        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("." + extension);
            }
        };

        return dir.listFiles(filter);
    }
}
