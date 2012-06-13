package org.geonetwork.domain.referencedata;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 * @author heikki doeleman
 *
 */
public class DomainLoaderFilenameFilter implements FilenameFilter {

	/**
	 * Accepts all file names that do not start with a dot ('.') and that end in '.xml'.
	 */
	public boolean accept(File dir, String name) {
		return name.charAt(0) != '.' && name.endsWith(".xml");
	}

}
