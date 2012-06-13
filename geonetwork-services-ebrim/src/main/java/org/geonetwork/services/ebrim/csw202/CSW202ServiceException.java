/**
 * CSW202Exception.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package org.geonetwork.services.ebrim.csw202;

/**
 * 
 * 
 * document: OGC 07-110r2
 * 
 * 
 * 7.9.2 Fault handling In the event that an exception report is produced for any reason, a single SOAP Fault element
 * information item shall be included as the only child element information item of the SOAP body element (see SOAP12,
 * sec. 5.4). The elements of the SOAP Fault are constructed as follows: a) env:Code/env:Value = ―env:Sender‖ or
 * ―env:Receiver‖, depending on the source of the error and the HTTP status code (i.e., 4xx, 5xx); OGC 07-110r2
 * Copyright © 2008 Open Geospatial Consortium, Inc. All Rights Reserved. 15 b) env:Code/env:Subcode/env:Value = value
 * of ows:Exception[1]/@exceptionCode (an OWS exception code value shall be prepended with ―ows:‖); c)
 * env:Reason/env:Text = ows:Exception[1]/ows:ExceptionText[1], where @xml:lang = ows:ExceptionReport/@language; d)
 * env:Detail contains the original ows:ExceptionReport element NOTE The ―env‖ prefix maps to the namespace URI
 * ―http://www.w3.org/2003/05/soap-envelope‖.
 * 
 * 
 * @author Erik van Ingen
 * 
 */
public class CSW202ServiceException extends Exception {

	private static final long serialVersionUID = -1074066802419921224L;
	private org.geonetwork.domain.csw202.exception.ExceptionReport faultMessage;

	public CSW202ServiceException() {
		super("CSW202Exception");
	}

	public CSW202ServiceException(Throwable e) {
		super(e);
	}

	public CSW202ServiceException(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public void setFaultMessage(org.geonetwork.domain.csw202.exception.ExceptionReport msg) {
		faultMessage = msg;
	}

	public org.geonetwork.domain.csw202.exception.ExceptionReport getFaultMessage() {
		return faultMessage;
	}
}
