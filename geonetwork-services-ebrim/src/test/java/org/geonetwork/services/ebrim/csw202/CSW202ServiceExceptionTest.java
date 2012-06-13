package org.geonetwork.services.ebrim.csw202;

import junit.framework.TestCase;

import org.geonetwork.domain.csw202.exception.ExceptionReport;

public class CSW202ServiceExceptionTest extends TestCase {

	public void testSetFaultMessage() {
		String fm = "er is iets heel naars gebeurd"; 
		
		CSW202ServiceException e = new CSW202ServiceException();
		assertEquals("CSW202Exception", e.getMessage());
		ExceptionReport msg = new ExceptionReport(); 
		org.geonetwork.domain.csw202.exception.Exception ee = new org.geonetwork.domain.csw202.exception.Exception(); 
		ee.addException(fm);
		msg.addException(ee); 
		e.setFaultMessage(msg); 
		
	}

}
