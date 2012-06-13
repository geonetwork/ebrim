package org.geonetwork.services.ebrim.csw202.validation;

import java.util.List;

import org.geonetwork.domain.csw202.discovery.CapabilitiesSection;
import org.geonetwork.domain.csw202.discovery.GetCapabilities;
import org.geonetwork.domain.csw202.exception.Exception;
import org.geonetwork.domain.ows100.getcapabilities.Sections;
import org.geonetwork.domain.ows100.getcapabilities.AcceptFormats;
import org.geonetwork.domain.ows100.common.MimeType;
import org.geonetwork.services.ebrim.csw202.CSW202Constants;
import org.geonetwork.services.ebrim.csw202.CSW202ExceptionReportGenerator;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;
import org.geonetwork.services.ebrim.csw202.ExceptionCodesOgcCommon;
import org.geonetwork.utils.string.StringUtil;

public class GetCapabilitiesValidation {

	public GetCapabilitiesValidation(GetCapabilities request) throws CSW202ServiceException {
		if (request.getAcceptVersions() == null || request.getAcceptVersions().getVersion() == null) {
			String exceptionText = "AcceptVersions or the version itself is empty";
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
					exceptionText);
		}

        // Check accept if accept formats are supported
        // 05-008: When omitted or not supported by server, return service metadata document using MIME type "text/xml"
        // In 07-006r2 defines application/xml as output format for other operations, no mention to GetCapabilities
        // As this mimetype seems deprecated, we are using application/xml instead,
        AcceptFormats formats = request.getAcceptFormats();
        boolean validOutputFormat = false;
        for(MimeType format: formats.getOutputFormat()) {
            if (format.getValue().equals(CSW202Constants.outputFormatapplicationXml)) {
                validOutputFormat = true;
                break;
            }

        }
        if (!validOutputFormat) {

            String outputFormats = "";
            for(MimeType format: formats.getOutputFormat()) {
                if (StringUtil.isEmpty(outputFormats))
                    outputFormats = format.getValue();
                else
                    outputFormats = outputFormats + "," + format.getValue();
            }
            String exceptionText = "The outputFormats (" + outputFormats + ") are not supported";;
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTSUPPORTED,
					exceptionText);
        }

        // 07-110r2: The value of the service parameter shall be the service type code CSW-ebRIM.
		String service = request.getService();
		List<String> versionList = request.getAcceptVersions().getVersion();
		if (service == null || !service.equals(CSW202Constants.CSW_EBRIM) || versionList == null) {
			String exceptionText = "Service is not running or is not supported.";
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTSUPPORTED,
					exceptionText);
		}

        // 07-110r2: The value of the version parameter shall be 1.0.0
        boolean supportedVersion = false;
        for(String version: versionList) {
            if (version.equals(CSW202Constants.VERSION)) {
                supportedVersion = true;
                break;
            }
        }
		if (!supportedVersion) {
			String exceptionText = "Version of the service " + service + " is null or is not supported.";
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(ExceptionCodesOgcCommon.VersionNegotiationFailed,
					exceptionText);
		}

        // Check requested sections
		Sections sections = request.getSections();
		if(sections != null) {
			List<String> sectionList = sections.getSection();
			if (sectionList != null && sectionList.size() > 0) {
				// return the requested sections
				for (String section : sectionList) {
					if (section.equals(CapabilitiesSection.Contents.name())) {
						String exceptionText = "The section: " + section + " is not recognized in ebRIM profile of CSW.";
						throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
								exceptionText);
					}
				}
			}
		}
	}
}
