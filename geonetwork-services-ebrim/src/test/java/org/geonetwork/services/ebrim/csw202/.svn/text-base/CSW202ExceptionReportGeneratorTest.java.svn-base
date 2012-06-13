package org.geonetwork.services.ebrim.csw202;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.geonetwork.domain.csw202.exception.ExceptionReport;
import org.junit.Test;

public class CSW202ExceptionReportGeneratorTest {

	@Test
	public void testGenerateExceptionReportBasedOn() {
		String exceptionCode = " ";
		String exceptionText = " ";
		assertNotNull(CSW202ExceptionReportGenerator.generateExceptionReportBasedOn(exceptionCode, exceptionText));

		exceptionCode = null;
		exceptionText = null;
		assertNotNull(CSW202ExceptionReportGenerator.generateExceptionReportBasedOn(exceptionCode, exceptionText));

		exceptionCode = org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST;
		exceptionText = "additional information about the WRS_INVALIDREQUEST ";
		ExceptionReport e = CSW202ExceptionReportGenerator.generateExceptionReportBasedOn(exceptionCode, exceptionText);
		assertNotNull(e);

		assertEquals(exceptionCode, e.getExceptionList().get(0).getExceptionCode());
		assertEquals(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST_EXCEPTION_TEXT, e
				.getExceptionList().get(0).getExceptionTexts().get(0));
		assertEquals(exceptionText, e.getExceptionList().get(0).getExceptionTexts().get(1));

	}

	@Test
	public void testGenerateServiceExceptionBasedOn() {
		String exceptionCode = " ";
		String exceptionText = " ";
		assertNotNull(CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(exceptionCode, exceptionText));

		exceptionCode = null;
		exceptionText = null;
		assertNotNull(CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(exceptionCode, exceptionText));

		exceptionCode = org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST;
		exceptionText = " ";
		assertNotNull(CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(exceptionCode, exceptionText));
	}

}
