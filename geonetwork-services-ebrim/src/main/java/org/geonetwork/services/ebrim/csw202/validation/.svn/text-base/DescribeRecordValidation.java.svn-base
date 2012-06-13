package org.geonetwork.services.ebrim.csw202.validation;

import org.geonetwork.domain.csw202.discovery.DescribeRecord;
import org.geonetwork.domain.csw202.discovery.RequestBase;
import org.geonetwork.domain.csw202.exception.Exception;
import org.geonetwork.services.ebrim.csw202.CSW202Constants;
import org.geonetwork.services.ebrim.csw202.CSW202ExceptionReportGenerator;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;

/**
 * Validates a request according the spec documents
 * 
 * @author Erik van Ingen
 * 
 */
public class DescribeRecordValidation {

	/**
	 * Constructing this object means having finished the validation succesfully.
	 * 
	 * 
	 * 
	 * @param request
	 * @throws CSW202ServiceException
	 */
	public DescribeRecordValidation(DescribeRecord request) throws CSW202ServiceException {
		// validation service name
		if (!request.getService().equals(RequestBase.SERVICE)) {
			String exceptionText = "Service should be " + RequestBase.SERVICE;
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
					exceptionText);
		}
		// validation version
		if (!request.getVersion().equals(RequestBase.VERSION)) {
			String exceptionText = "Version should be " + RequestBase.VERSION;
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
					exceptionText);
		}
		
		// no validation for namespace implemented  
		// no validation for typenames implemented.

		// validation output format
		if (request.getOutputFormat() != null && !CSW202Constants.outputFormats.contains(request.getOutputFormat())) {
			String exceptionText = "This output format is not supported: " + request.getOutputFormat();
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
					exceptionText);
		}

		// validation schema language
		if (!CSW202Constants.schemaLanguagesAllowed.contains(request.getSchemaLanguage())) {
			String exceptionText = "SchemaLanguage should be: " + CSW202Constants.SCHEMA_LANGUAGE_1 + " or "
					+ CSW202Constants.SCHEMA_LANGUAGE_2;
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
					exceptionText);
		}

	}
}
