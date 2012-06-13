package org.geonetwork.domain.gml311.basictypes;
/**
 * XML List based on XML Schema double type.  An element of this type contains a 
 * space-separated list of double values.
 * 
 * @author heikki doeleman
 *
 */
public class DoubleList {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
