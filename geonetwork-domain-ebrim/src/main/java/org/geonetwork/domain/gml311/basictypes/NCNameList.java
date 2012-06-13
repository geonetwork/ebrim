package org.geonetwork.domain.gml311.basictypes;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.xsd.NCName;

/**
 * 
 * @author heikki doeleman
 *
 */
public class NCNameList {

	List<NCName> values = new ArrayList<NCName>();

	public List<NCName> getValues() {
		return values;
	}

	public void setValues(List<NCName> values) {
		this.values = values;
	}
	
	
}
