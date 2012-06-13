package org.geonetwork.webservices.ebrim.csw202;

import static org.junit.Assert.*;

import org.geonetwork.domain.csw202.exception.ExceptionReport;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;
import org.junit.Test;

public class MsgInvalidRequestFaultTest {

	@Test
	public void msgInvalidRequestFault() {
		CSW202ServiceException c = new CSW202ServiceException();
		ExceptionReport er = new ExceptionReport(); 
		c.setFaultMessage(er);
		assertTrue(c instanceof CSW202ServiceException);
		MsgInvalidRequestFault m = new MsgInvalidRequestFault(c);
		assertTrue(m instanceof MsgInvalidRequestFault);
		assertEquals(er, m.getFaultMessage());
	}

}
