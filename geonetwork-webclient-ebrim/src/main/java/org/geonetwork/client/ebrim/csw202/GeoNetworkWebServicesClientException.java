package org.geonetwork.client.ebrim.csw202;


public class GeoNetworkWebServicesClientException extends Exception {

	private static final long serialVersionUID = 1335641171109181321L;

	public GeoNetworkWebServicesClientException(Throwable e) {
		super(e);
	}

	public GeoNetworkWebServicesClientException(String newMessage) {
		super(newMessage);
	}

	public GeoNetworkWebServicesClientException(String msg, Throwable e) {
		super(msg, e);
	}

}
