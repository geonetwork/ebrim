/**
 * MsgInvalidRequestFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 * 
 * Then the business logic has been moved to CSW202ServiceException in the service layer. 
 * Doing this, the weblayer needs very little code in order to expose the 
 * logical service as a webservice. 
 * 
 * 
 */

package org.geonetwork.webservices.ebrim.csw202;

import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;

public class MsgInvalidRequestFault extends CSW202ServiceException {

	public MsgInvalidRequestFault(CSW202ServiceException c) {
		super(c);
		this.setFaultMessage(c.getFaultMessage());
	}

	private static final long serialVersionUID = -7292806425476452454L;

}
