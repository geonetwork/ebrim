package org.geonetwork.utils.collection;

import java.util.Collection;

/**
 * 
 * Very handy collection utilities.
 * 
 * @author heikki doeleman
 *
 */
public class CollectionUtil {
	
	public static boolean isNotEmpty(Collection<?> c) {
		return c != null && c.size() > 0 ;
	}
	public static boolean isNotEmpty(byte[] c) {
		return c != null && c.length > 0 ;
	}	
	public static boolean isEmpty(Collection<?> c) {
		return c == null || c.size() == 0 ;
	}
	public static boolean isEmpty(byte[] c) {
		return c == null || c.length == 0 ;
	}	
}
