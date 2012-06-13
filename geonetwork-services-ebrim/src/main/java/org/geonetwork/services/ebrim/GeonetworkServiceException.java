package org.geonetwork.services.ebrim;
/**
 * 
 * @author heikki doeleman
 *
 */
public class GeonetworkServiceException extends Exception {

	private static final long serialVersionUID = 2847201416842342144L;

	public GeonetworkServiceException() {
	}

	public GeonetworkServiceException(String message) {
		super(message);
	}

	public GeonetworkServiceException(Throwable cause) {
		super(cause);
	}

	public GeonetworkServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
