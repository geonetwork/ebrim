package org.geonetwork.services.ebrim.csw202;

import java.util.HashMap;
import java.util.Map;

/**
 * Excpetion codes taken from this spec document:
 * 
 * Open Geospatial Consortium Inc. Date: 2007-07-19 Reference number of this OGC® Document: 07-045
 * 
 * 8.2.4 Error handling In the event that the submitted request is invalid, an exception report message is generated and
 * returned to the client. This report complies with the definition of exception reports that are specified by OGC
 * Common specification (see [OGC 05-008c1]). Table 39 shows an excerpt from that document that lists valid exception
 * codes and meanings that are supported by this profile35.
 * 
 * @author Erik van Ingen
 * 
 */
public class ExceptionCodesOgcCommon {

	public static final String MissingParameterValue = "MissingParameterValue";
	public static final String MissingParameterValue_Description = "Operation request does not include a parameter value, and this server did not declare a default value for that parameter";

	public static final String InvalidParameterValue = "InvalidParameterValue";
	public static final String InvalidParameterValue_Description = "Operation request contains an invalid parameter value";

	public static final String VersionNegotiationFailed = "VersionNegotiationFailed";
	public static final String VersionNegotiationFailed_Description = "List of versions in “AcceptVersions” parameter value, in GetCapabilities operation request, did not include any version supported by this server";

	public static final String InvalidUpdateSequence = "InvalidUpdateSequence";
	public static final String InvalidUpdateSequence_Description = "Value of (optional) updateSequence parameter, in GetCapabilities operation request, is greater than current value of service metadata updateSequence number";

	public static final String NoApplicableCode = "NoApplicableCode";
	public static final String NoApplicableCode_Description = "No other exceptionCode specified by this service and server applies to this exception";

	public static final Map<String, String> codeDescriptionMap = new HashMap<String, String>();
	static {
		codeDescriptionMap.put(MissingParameterValue, MissingParameterValue_Description);
		codeDescriptionMap.put(InvalidParameterValue, InvalidParameterValue_Description);
		codeDescriptionMap.put(VersionNegotiationFailed, VersionNegotiationFailed_Description);
		codeDescriptionMap.put(InvalidUpdateSequence, InvalidUpdateSequence_Description);
		codeDescriptionMap.put(NoApplicableCode, NoApplicableCode_Description);
	}

}
