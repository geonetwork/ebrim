package org.geonetwork.domain.csw202.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exception {

	public static final String WRS_SENDER_EXCEPTION_TEXT = "Intended for cases in which the message sender seems to have erred in some manner (this corresponds to an HTTP status code of 4xx).";
	public static final String WRS_SENDER = "wrs:Sender";
	public static final String WRS_RECEIVER_EXCEPTION_TEXT = "Intended for cases in which an unexpected condition prevented the service from fulfilling the request (this corresponds to an HTTP status code of 5xx).";
	public static final String WRS_RECEIVER = "wrs:Receiver";
	public static final String WRS_INVALIDREQUEST_EXCEPTION_TEXT = " The request message is either invalid or is not well-formed.";
	public static final String WRS_INVALIDREQUEST = "wrs:InvalidRequest";
	public static final String WRS_TRANSACTIONFAILED_EXCEPTION_TEXT = "The requested transaction could not be completed.";
	public static final String WRS_TRANSACTIONFAILED = "wrs:TransactionFailed";
	public static final String WRS_NOTIMPLEMENTED_EXCEPTION_TEXT = "The (abstract) operation has not been implemented.";
	public static final String WRS_NOTIMPLEMENTED = "wrs:NotImplemented";
	public static final String WRS_NOTFOUND_EXCEPTION_TEXT = "The requested resource does not exist or could not be found.";
	public static final String WRS_NOTFOUND = "wrs:NotFound";
	public static final String WRS_NOTSUPPORTED_EXCEPTION_TEXT = "A service option, feature, or capability is not supported.";
	public static final String WRS_NOTSUPPORTED = "wrs:NotSupported";

	String exceptionCode;
	String locator;
	List<String> exceptionTexts = new ArrayList<String>();

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public List<String> getExceptionTexts() {
		return exceptionTexts;
	}

	public void setExceptionTexts(List<String> exceptionTexts) {
		this.exceptionTexts = exceptionTexts;
	}

	public void addException(String exceptionText) {
		this.exceptionTexts.add(exceptionText);
	}

	public static boolean exceptionCodeIsValid(String exceptionCode) {
		return codeDescriptionMap.containsKey(exceptionCode);
	}

	public static Map<String, String> codeDescriptionMap = new HashMap<String, String>();
	static {
		codeDescriptionMap.put(WRS_SENDER, WRS_SENDER_EXCEPTION_TEXT);
		codeDescriptionMap.put(WRS_RECEIVER, WRS_RECEIVER_EXCEPTION_TEXT);
		codeDescriptionMap.put(WRS_INVALIDREQUEST, WRS_INVALIDREQUEST_EXCEPTION_TEXT);
		codeDescriptionMap.put(WRS_TRANSACTIONFAILED, WRS_TRANSACTIONFAILED_EXCEPTION_TEXT);
		codeDescriptionMap.put(WRS_NOTIMPLEMENTED, WRS_NOTIMPLEMENTED_EXCEPTION_TEXT);
		codeDescriptionMap.put(WRS_NOTFOUND, WRS_NOTFOUND_EXCEPTION_TEXT);
		codeDescriptionMap.put(WRS_NOTSUPPORTED, WRS_NOTSUPPORTED_EXCEPTION_TEXT);
	}

	/**
	 * For Jixb binding.
	 */
	@SuppressWarnings("unused")
	private static List<String> exceptionTextsFactory() {
		return new ArrayList<String>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exceptionCode == null) ? 0 : exceptionCode.hashCode());
		result = prime * result + ((exceptionTexts == null) ? 0 : exceptionTexts.hashCode());
		result = prime * result + ((locator == null) ? 0 : locator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Exception))
			return false;
		Exception other = (Exception) obj;
		if (exceptionCode == null) {
			if (other.exceptionCode != null)
				return false;
		} else if (!exceptionCode.equals(other.exceptionCode))
			return false;
		if (exceptionTexts == null) {
			if (other.exceptionTexts != null)
				return false;
		} else if (exceptionTexts.size() != other.exceptionTexts.size())
			return false;
		if (locator == null) {
			if (other.locator != null)
				return false;
		} else if (!locator.equals(other.locator))
			return false;
		return true;
	}

}
