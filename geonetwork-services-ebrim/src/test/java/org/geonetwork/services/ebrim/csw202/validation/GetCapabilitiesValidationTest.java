package org.geonetwork.services.ebrim.csw202.validation;

import static org.junit.Assert.*;

import org.geonetwork.domain.csw202.discovery.CapabilitiesSection;
import org.geonetwork.domain.csw202.discovery.GetCapabilities;
import org.geonetwork.domain.csw202.exception.Exception;
import org.geonetwork.domain.ows100.getcapabilities.AcceptFormats;
import org.geonetwork.domain.ows100.common.MimeType;
import org.geonetwork.services.ebrim.csw202.CSW202Constants;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;
import org.geonetwork.services.ebrim.csw202.ExceptionCodesOgcCommon;
import org.geonetwork.utils.RandomPopulator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetCapabilitiesValidationTest {

	@Test
	public void testGetCapabilitiesValidation() throws java.lang.Exception {
		GetCapabilities request = new GetCapabilities();
		runValidationExpectingINVALIDREQUEST(request);
		request = (GetCapabilities) RandomPopulator.instantiate(GetCapabilities.class, null);

        runValidationExpectingNOTSUPPORTED(request);
        AcceptFormats acceptFormats = new AcceptFormats();
        List<MimeType> mtList = new ArrayList<MimeType>();
        MimeType mt = new MimeType();
        mt.setValue(CSW202Constants.outputFormatapplicationXml);
        mtList.add(mt);
        acceptFormats.setOutputFormat(mtList);
        request.setAcceptFormats(acceptFormats);

        runValidationExpectingNOTSUPPORTED(request);
        request.setService(CSW202Constants.CSW_EBRIM);
        request.getSections().getSection().add(CapabilitiesSection.ServiceProvider.name());

		request.getSections().getSection().remove(0);
		request.getAcceptVersions().getVersion().add(0, " ");
		runValidationExpectingVersionNegotiationFailed(request);

		request.getSections().getSection().remove(0);
		request.getAcceptVersions().getVersion().add(0, CSW202Constants.VERSION);
		runValidationExpectingHeaven(request);
	}

	void runValidationExpectingNOTSUPPORTED(GetCapabilities request) {
		try {
			new GetCapabilitiesValidation(request);
			fail();
		} catch (CSW202ServiceException e) {
			Exception exception = e.getFaultMessage().getExceptionList().get(0);
			assertEquals(Exception.WRS_NOTSUPPORTED, exception.getExceptionCode());
			assertEquals(Exception.WRS_NOTSUPPORTED_EXCEPTION_TEXT, exception.getExceptionTexts().get(0));
		}
	}

	void runValidationExpectingINVALIDREQUEST(GetCapabilities request) {
		try {
			new GetCapabilitiesValidation(request);
			fail();
		} catch (CSW202ServiceException e) {
			Exception exception = e.getFaultMessage().getExceptionList().get(0);
			assertEquals(Exception.WRS_INVALIDREQUEST, exception.getExceptionCode());
			assertEquals(Exception.WRS_INVALIDREQUEST_EXCEPTION_TEXT, exception.getExceptionTexts().get(0));
		}
	}

	void runValidationExpectingVersionNegotiationFailed(GetCapabilities request) {
		try {
			new GetCapabilitiesValidation(request);
			fail();
		} catch (CSW202ServiceException e) {
			Exception exception = e.getFaultMessage().getExceptionList().get(0);
			assertEquals(ExceptionCodesOgcCommon.VersionNegotiationFailed, exception.getExceptionCode());
			assertEquals(ExceptionCodesOgcCommon.VersionNegotiationFailed_Description, exception.getExceptionTexts().get(0));
		}
	}

	void runValidationExpectingHeaven(GetCapabilities request) {
		try {
			new GetCapabilitiesValidation(request);
		} catch (CSW202ServiceException e) {
			fail();
		}
	}

}
