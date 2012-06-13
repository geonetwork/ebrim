package org.geonetwork.services.ebrim.csw202.validation;

import org.geonetwork.domain.csw202.discovery.GetRecordById;
import org.geonetwork.domain.csw202.exception.Exception;
import org.geonetwork.services.ebrim.csw202.CSW202ExceptionReportGenerator;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;

public class GetRecordByIdValidation extends RequestValidation {

	public GetRecordByIdValidation(GetRecordById request) throws CSW202ServiceException {
		if (request.getId() == null || request.getId().size() == 0 || request.getOutputSchema() == null
				|| request.getElementSetName() == null || request.getElementSetName().getElementSet() == null) {
			String exceptionText = "GetRecordById request contains empty elements";
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
					exceptionText);
		}
		validateOutputFormat(request.getOutputFormat());
		validateOutputSchema(request.getOutputSchema());
	}
}
