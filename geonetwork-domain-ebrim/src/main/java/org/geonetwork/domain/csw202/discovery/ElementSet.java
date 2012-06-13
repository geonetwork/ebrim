package org.geonetwork.domain.csw202.discovery;

/**
 * Named subsets of catalogue object properties; these views are mapped to a specific information 
 * model and are defined in an application profile.
 * 
 * @author heikki doeleman
 *
 */
public enum ElementSet {
		brief,
		summary,
		full
}

/**
 * For Jibx
 */
class ElementSetConversion {
    public static ElementSet deserializeElementSetEnum(String str) {
        if (str == null) {
            return null;
        } else {
            return ElementSet.valueOf(str);
        }
    }
}