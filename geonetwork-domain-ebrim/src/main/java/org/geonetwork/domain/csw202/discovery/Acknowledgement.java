package org.geonetwork.domain.csw202.discovery;

import java.util.Date;

/**
 * This is a general acknowledgement response message for all requests that may be processed in an
 * asynchronous manner.
 * 
 * 
 * @author heikki doeleman
 * 
 */
public class Acknowledgement {

	/**
	 * Echoes the submitted request message
	 */
	private EchoedRequest echoedRequest;

	/**
	 * identifier for polling purposes (if no response handler is available, or the URL scheme is
	 * unsupported)
	 * 
	 * The type String might be replaced with a generic URI type from the core xsd's
	 */
	private String requestId;

	private Date timestamp;

	public EchoedRequest getEchoedRequest() {
		return echoedRequest;
	}

	public void setEchoedRequest(EchoedRequest echoedRequest) {
		this.echoedRequest = echoedRequest;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((echoedRequest == null) ? 0 : echoedRequest.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Acknowledgement)) {
			return false;
		}
		Acknowledgement other = (Acknowledgement) obj;
		if (echoedRequest == null) {
			if (other.echoedRequest != null) {
				return false;
			}
		} else if (!echoedRequest.equals(other.echoedRequest)) {
			return false;
		}
		if (requestId == null) {
			if (other.requestId != null) {
				return false;
			}
		} else if (!requestId.equals(other.requestId)) {
			return false;
		}
		if (timestamp == null) {
			if (other.timestamp != null)
			return false;
		} else if (other.timestamp == null || timestamp.getTime() != other.timestamp.getTime()) {
			return false;
		}
		return true;
	}

}
