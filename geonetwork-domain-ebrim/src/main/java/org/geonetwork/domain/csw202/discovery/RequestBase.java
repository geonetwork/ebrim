package org.geonetwork.domain.csw202.discovery;

/**
 * Base type for all request messages except GetCapabilities. The attributes identify the 
 * relevant service type and version.
 * 
 * @author heikki doeleman
 *
 */
public abstract class RequestBase {

	public static final String SERVICE = "CSW" ;
	public static final String VERSION = "2.0.2";
	
	public boolean equals(Object o) {
		return o instanceof RequestBase;
	}
	public int hashCode() {
		return super.hashCode();
	}
}
