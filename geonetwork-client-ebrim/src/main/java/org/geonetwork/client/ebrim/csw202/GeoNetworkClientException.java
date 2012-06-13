package org.geonetwork.client.ebrim.csw202;

/**
 * GeoNetworkException is a CheckedException.
 * 
 * See also http://trac.osgeo.org/geonetwork/wiki/GeoNetworkException
 * 
 * @author Erik van Ingen
 */

public class GeoNetworkClientException extends Exception {

	private static final long serialVersionUID = 1335641171109181321L;

	public GeoNetworkClientException(Throwable e) {
		super(e);
	}

	public GeoNetworkClientException(String newMessage) {
		super(newMessage);
	}

	public GeoNetworkClientException(String msg, Throwable e) {
		super(msg, e);
	}

}
