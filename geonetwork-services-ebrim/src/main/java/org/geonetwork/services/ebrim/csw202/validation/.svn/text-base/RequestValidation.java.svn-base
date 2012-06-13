package org.geonetwork.services.ebrim.csw202.validation;

import org.geonetwork.domain.csw202.exception.Exception;
import org.geonetwork.services.ebrim.csw202.CSW202Constants;
import org.geonetwork.services.ebrim.csw202.CSW202ExceptionReportGenerator;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;

public abstract class RequestValidation {

	void validateOutputFormat(String outputFormat) throws CSW202ServiceException {
		if (outputFormat != null && !CSW202Constants.outputFormats.contains(outputFormat)) {
			String exceptionText = "The outputFormat " + outputFormat + " is not supported";
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTSUPPORTED,
					exceptionText);
		}
	}

	void validateOutputSchema(String outputSchema) throws CSW202ServiceException {
		if (outputSchema != null && !((outputSchema.equals(CSW202Constants.outputSchema))
                || (outputSchema.equals(CSW202Constants.outputSchemaCsw)) )) {
			String exceptionText = "The outputSchema " + outputSchema + " is not supported";
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTSUPPORTED,
					exceptionText);
		}
	}

}
