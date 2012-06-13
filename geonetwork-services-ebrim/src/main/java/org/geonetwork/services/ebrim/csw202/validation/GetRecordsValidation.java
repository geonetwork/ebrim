package org.geonetwork.services.ebrim.csw202.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geonetwork.domain.csw202.discovery.ElementSetName;
import org.geonetwork.domain.csw202.discovery.GetRecords;
import org.geonetwork.domain.csw202.discovery.Query;
import org.geonetwork.domain.csw202.exception.Exception;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery.StoredQuery;
import org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery;
import org.geonetwork.domain.xsd.QName;
import org.geonetwork.services.ebrim.csw202.CSW202ExceptionReportGenerator;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;
import org.geonetwork.services.ebrim.csw202.CSW202Constants;
import org.geonetwork.utils.collection.CollectionUtil;

public class GetRecordsValidation extends RequestValidation {
	
	private static Logger log = Logger.getLogger(GetRecordsValidation.class);
    private final static String DEFAULT_NAMESPACE_MARKER = "[DEFAULT-NAMESPACE]:";

	public GetRecordsValidation(GetRecords request) throws CSW202ServiceException {
		
		
		
		Query cswQuery = request.getQuery();
		AdhocQuery adhocQuery = request.getAdhocQuery();
		
		//
		// Either cswQuery or adhocQuery must be present
		//
		if(cswQuery != null && adhocQuery == null) {
			//
			// Query must have a constraint
			//
			//if(cswQuery.getConstraint() == null) {
			//	String exceptionText = "GetRecords request query must contain a csw:Constraint";
			//	throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST, exceptionText);
			//}
			//
			// Constraint must have either an ogc:Filter or a csw:CqlText
			//
            if(cswQuery.getConstraint() != null) {
                if(cswQuery.getConstraint().getFilter() != null && cswQuery.getConstraint().getCQLText() == null) {
                    // OK
                }
                else if(cswQuery.getConstraint().getFilter() == null && cswQuery.getConstraint().getCQLText() != null) {
                    String exceptionText = "GetRecords request query constraint csw:CqlText is not supported";
                    throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTSUPPORTED, exceptionText);
                }
                else {
                    String exceptionText = "GetRecords request query constraint must contain either ogc:Filter or csw:CqlText";
                    throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST, exceptionText);
                }
            }
            
			//
			// at least 1 typename must be in the query
			//
			if(CollectionUtil.isEmpty(cswQuery.getTypeNames())) {
				String exceptionText = "GetRecords request query must contain at least 1 csw:TypeName";			
				throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST, exceptionText);
			}
			
			//
			// elementname and elementsetname are mutually exclusive
			//
			if(CollectionUtil.isNotEmpty(cswQuery.getElementName()) && cswQuery.getElementSetName() != null) {
				String exceptionText = "GetRecords request query cannot contain both a csw:ElementName and a csw:ElementSetName element";			
				throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST, exceptionText);			
			}
			
			//
			// typenames in elementsetname must be a proper subset of typenames in query
			//
			if(cswQuery.getElementSetName() != null) {
				ElementSetName elementSetName = cswQuery.getElementSetName();
				List<String> typeNamesinElementSetName = elementSetName.getTypeNames();
				List<QName> typeNamesinQuery = cswQuery.getTypeNames();

                List<String> typeNamesinQueryAsString = new ArrayList<String>();
                for(QName typeName : typeNamesinQuery) {
                    typeNamesinQueryAsString.add(typeName.getValue());
                }

                if (typeNamesinElementSetName != null) {
                    for(String typeName : typeNamesinElementSetName) {
                        if(!typeNamesinQueryAsString.contains(typeName)) {
                            String exceptionText = "GetRecords request query cannot contain a csw:TypeName in csw:ElementSetName that is not also listed in csw:Query";
                            throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST, exceptionText);
                        }
                    }
                }
			}

            //
            // Validate namespace in typenames for query and elementsetname
            //
            if(cswQuery.getElementSetName() != null) {
                validateTypeNames(request.getNamespace(), cswQuery.getElementSetName().getTypeNames());
            }

            List<QName> typeNamesinQuery = cswQuery.getTypeNames();
            List<String> typeNamesinQueryAsString = new ArrayList<String>();
            for(QName typeName : typeNamesinQuery) {
			    typeNamesinQueryAsString.add(typeName.getValue());
            }

            validateTypeNames(request.getNamespace(), typeNamesinQueryAsString);
            
		}
		else if(cswQuery == null && adhocQuery != null) {
			// OK
		}
		else {
			String exceptionText = "GetRecords request must contain one of csw:Query or rim:AdhocQuery";
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST, exceptionText);			
		}
		
		validateOutputFormat(request.getOutputFormat());

        // Checks CSW outputSchema and ebRIM outputSchema
        String outputSchema = request.getOutputSchema();
        if (outputSchema != null && !(outputSchema.equals(CSW202Constants.outputSchema) || outputSchema.equals(CSW202Constants.outputSchemaCsw))) {
			String exceptionText = "The outputSchema " + outputSchema + " is not supported";
			throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTSUPPORTED,
					exceptionText);
		}

	}


   private void validateTypeNames(List<String> namespaces, List<String> typeNames) throws CSW202ServiceException {
       if (namespaces == null) return;
       
       // map list of namespaces
		Map<String, String> namespaceMap = new HashMap<String, String>();
		for(String namespace : namespaces) {
			String[] split = namespace.split("=");
			if(split.length == 2) {
				String prefix = split[0];
				String namespaceUri = split[1];
				namespaceMap.put(prefix, namespaceUri);
			}
			// namespace mapping w/o prefix
			else {
				log.debug("namespace w/o prefix mapped as DEFAULT namespace: " + namespace);
				namespaceMap.put(DEFAULT_NAMESPACE_MARKER, namespace);
			}
		}

        if (typeNames != null) {
            for(String unresolvedTypename : typeNames) {
                log.debug("unresolvedTypename: " + unresolvedTypename);
                String[] split = unresolvedTypename.split(":");
                if(split.length == 2) {
                    String prefix = split[0];
                    String typeName = split[1];
                    if(namespaceMap.containsKey(prefix)) {
                        log.debug("resolved type: " + typeName + " to " + namespaceMap.get(prefix));
                    }
                    // namespace prefix of typename not in namespaces map
                    else {
                        log.debug("GetRecords request namespace prefix not found: " + prefix);
                        String exceptionText = "GetRecords request undeclared namespace prefix: " + prefix ;
                        throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST, exceptionText);
                    }
                }
                // typename without prefix
                else if(split.length == 1){
                    log.debug("typename without prefix: " + split[0]);
                    String defaultNamespace = namespaceMap.get(DEFAULT_NAMESPACE_MARKER);
                    log.debug("default namespace: " + defaultNamespace);
                }
                // invalid typename
                else {
                    String exceptionText = "Invalid typename: " + unresolvedTypename ;
                    throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST, exceptionText);
                }
            }
        }
	}
}
