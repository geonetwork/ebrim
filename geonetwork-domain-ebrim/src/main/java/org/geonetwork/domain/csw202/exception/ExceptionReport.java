package org.geonetwork.domain.csw202.exception;

import java.util.ArrayList;
import java.util.List;

public class ExceptionReport {

	/**
	 * Specification version for OWS operation. The string value shall contain one x.y.z "version"
	 * value (e.g., "2.1.3"). A version number shall contain three non-negative integers separated
	 * by decimal points, in the form "x.y.z". The integers y and z shall not exceed 99. Each
	 * version shall be for the Implementation Specification (document) and the associated XML
	 * Schemas to which requested operations will conform. An Implementation Specification version
	 * normally specifies XML Schemas against which an XML encoded operation response must conform
	 * and should be validated. See Version negotiation subclause for more information.
	 */
	String version;

	/**
	 * Identifier of the language used by all included exception text values. These language
	 * identifiers shall be as specified in IETF RFC 4646. When this attribute is omitted, the
	 * language used is not identified.
	 */
	String lang;
	List<Exception> exceptionList = new ArrayList<Exception>();

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public List<Exception> getExceptionList() {
		return exceptionList;
	}

	public void setExceptionList(List<Exception> exceptionList) {
		this.exceptionList = exceptionList;
	}

	public void addException(Exception exception) {
		this.exceptionList.add(exception);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exceptionList == null) ? 0 : exceptionList.hashCode());
		result = prime * result + ((lang == null) ? 0 : lang.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ExceptionReport))
			return false;
		ExceptionReport other = (ExceptionReport) obj;
		if (exceptionList == null) {
			if (other.exceptionList != null)
				return false;
		} else if (exceptionList.size() != other.exceptionList.size()) {
			return false;
		} else {
			if (exceptionList.size() > 0) {
				boolean found = false;
				for (Exception exception : exceptionList) {
					for (Exception exceptionOther : other.exceptionList) {
						if (exception.equals(exceptionOther))
							found = true;
					}
				}
				if (!found)
					return false;
			}
		}

		if (lang == null) {
			if (other.lang != null)
				return false;
		} else if (!lang.equals(other.lang))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	/**
	 * For Jixb binding.
	 */
	@SuppressWarnings("unused")
	private static List<Exception> exceptionListFactory() {
		return new ArrayList<Exception>();
	}

}
