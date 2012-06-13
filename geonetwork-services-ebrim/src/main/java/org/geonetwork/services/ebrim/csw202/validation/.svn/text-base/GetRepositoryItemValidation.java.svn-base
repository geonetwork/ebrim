package org.geonetwork.services.ebrim.csw202.validation;

import org.geonetwork.domain.csw202.exception.Exception;
import org.geonetwork.services.ebrim.csw202.CSW202ExceptionReportGenerator;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;
import org.geonetwork.utils.string.StringUtil;

/**
 * 
 * Validation for GetRepositoryItem requests.
 * 
 * @author heikki doeleman
 *
 */
public class GetRepositoryItemValidation {
	
	public static void validate(String id) throws CSW202ServiceException {
		if(StringUtil.isEmpty(id)) {
			String exceptionText = "GetRepositoryItem: id parameter value cannot be empty";
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST, exceptionText);					
		}
	}
}
