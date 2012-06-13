package org.geonetwork.domain.ows100.operationsmetadata;

/**
 * Information for one distributed Computing Platform (DCP) supported for this operation. At 
 * present, only the HTTP DCP is defined, so this element only includes the HTTP element.
 * 
 * @author heikki doeleman
 *
 */
public class DCP extends HTTP {

    @Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
