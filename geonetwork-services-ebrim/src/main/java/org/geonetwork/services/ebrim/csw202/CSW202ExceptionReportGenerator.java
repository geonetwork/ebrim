package org.geonetwork.services.ebrim.csw202;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.csw202.exception.ExceptionReport;
import org.geonetwork.utils.string.StringUtil;

/**
 * This class reflects how the application generates its ExceptionReport's. The specs do not define in detail how the
 * application should handle this. This is implementation is just based on logical reasoning.
 * 
 * 
 * 
 * @author Erik van Ingen
 * 
 */

public class CSW202ExceptionReportGenerator {

	/**
	 * creates an ExceptionReport with 1 Exception. This Exception has 2 exceptionText's. The first corresponds with the
	 * code and the second is the @param exceptionText.
	 * 
	 * @param exceptionCode
	 * @param exceptionText
	 * @return exceptionReport
	 */
	public static ExceptionReport generateExceptionReportBasedOn(String exceptionCode, String exceptionText) {
        List<String> exceptionTexts = new ArrayList<String>();
        if (!StringUtil.isEmpty(exceptionText)) {
		    exceptionTexts.add(exceptionText);
        }
		return generateExceptionReportBasedOn(exceptionCode, exceptionTexts);
	}

	/**
	 * creates an ExceptionReport with 1 Exception. This Exception has 2 exceptionText's. The first corresponds with the
	 * code and the second is the @param exceptionText.
	 * 
	 * @param exceptionCode
	 * @param exceptionTexts
	 * @return exceptionReport
	 */
	public static ExceptionReport generateExceptionReportBasedOn(String exceptionCode, List<String> exceptionTexts) {
		ExceptionReport exceptionReport = new ExceptionReport();
		exceptionReport.setLang(CSW202Constants.lang);
		exceptionReport.setVersion(CSW202Constants.version);

		org.geonetwork.domain.csw202.exception.Exception exception = new org.geonetwork.domain.csw202.exception.Exception();
		exception.setExceptionCode(exceptionCode);

		// CSW exception code
		if (org.geonetwork.domain.csw202.exception.Exception.codeDescriptionMap.containsKey(exceptionCode)) {
			exception.addException(org.geonetwork.domain.csw202.exception.Exception.codeDescriptionMap
					.get(exceptionCode));
		}
		// OGC common exception code
		if (ExceptionCodesOgcCommon.codeDescriptionMap.containsKey(exceptionCode)) {
			exception.addException(ExceptionCodesOgcCommon.codeDescriptionMap.get(exceptionCode));
		}

		for (String exceptionText : exceptionTexts) {
			exception.addException(exceptionText);
		}
		exceptionReport.addException(exception);
		return exceptionReport;
	}

	/**
	 * generates a CSW202ServiceException with a ExceptionReport based on generateExceptionReportBasedOn( exceptionCode,
	 * exceptionText) in this class
	 * 
	 * @param exceptionCode
	 * @param exceptionTexts
	 * @return csw202ServiceException
	 */
	public static CSW202ServiceException generateServiceExceptionBasedOn(String exceptionCode,
			List<String> exceptionTexts) {
		CSW202ServiceException csw202ServiceException = new CSW202ServiceException();
		csw202ServiceException.setFaultMessage(generateExceptionReportBasedOn(exceptionCode, exceptionTexts));
		return csw202ServiceException;
	}

	/**
	 * generates a CSW202ServiceException with a ExceptionReport based on generateExceptionReportBasedOn( exceptionCode,
	 * exceptionText) in this class
	 * 
	 * @param exceptionCode
	 * @param exceptionText
	 * @return csw202ServiceException
	 */
	public static CSW202ServiceException generateServiceExceptionBasedOn(String exceptionCode, String exceptionText) {
		CSW202ServiceException csw202ServiceException = new CSW202ServiceException();
		List<String> exceptionTexts = new ArrayList<String>();
		exceptionTexts.add(exceptionText);
		csw202ServiceException.setFaultMessage(generateExceptionReportBasedOn(exceptionCode, exceptionTexts));
		return csw202ServiceException;
	}

}
