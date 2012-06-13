package org.geonetwork.gaap.client;

/**
 * Exception launched by Geonetwork gaap client
 *
 * @author Jose
 */
public class GeonetworkGaapClientException extends Exception {
    private static final long serialVersionUID = 1335641171109181321L;

	public GeonetworkGaapClientException(Throwable e) {
		super(e);
	}

	public GeonetworkGaapClientException(String newMessage) {
		super(newMessage);
	}

	public GeonetworkGaapClientException(String msg, Throwable e) {
		super(msg, e);
	}
}
