package org.geonetwork.domain.csw202.exception;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExceptionTest {
	@Test
	public void testExceptionCodeIsValid() {
		assertTrue(Exception.exceptionCodeIsValid(Exception.WRS_INVALIDREQUEST));
		assertFalse(Exception.exceptionCodeIsValid(""));
		assertFalse(Exception.exceptionCodeIsValid("498723894 39284932"));
		assertFalse(Exception.exceptionCodeIsValid(null));
	}
	
	@Test
	public void testEquals() {
		Exception e1 = new Exception();
		Exception e2 = new Exception();
		assertTrue(e1.equals(e2));
	}	
	
	
}
