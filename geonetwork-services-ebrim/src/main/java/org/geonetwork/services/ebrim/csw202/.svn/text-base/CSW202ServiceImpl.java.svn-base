package org.geonetwork.services.ebrim.csw202;

import java.io.IOException;
import java.util.*;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.log4j.Logger;
import org.geonetwork.domain.csw202.discovery.Capabilities;
import org.geonetwork.domain.csw202.discovery.CapabilitiesSection;
import org.geonetwork.domain.csw202.discovery.DescribeRecord;
import org.geonetwork.domain.csw202.discovery.DescribeRecordResponse;
import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.csw202.discovery.ElementSetName;
import org.geonetwork.domain.csw202.discovery.GetCapabilities;
import org.geonetwork.domain.csw202.discovery.GetDomain;
import org.geonetwork.domain.csw202.discovery.GetDomainResponse;
import org.geonetwork.domain.csw202.discovery.GetRecordById;
import org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse;
import org.geonetwork.domain.csw202.discovery.GetRecords;
import org.geonetwork.domain.csw202.discovery.GetRecordsResponse;
import org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse;
import org.geonetwork.domain.csw202.discovery.Query;
import org.geonetwork.domain.csw202.discovery.RequestStatus;
import org.geonetwork.domain.csw202.discovery.ResultType;
import org.geonetwork.domain.csw202.discovery.SchemaComponent;
import org.geonetwork.domain.csw202.discovery.SearchResults;
import org.geonetwork.domain.csw202.exception.Exception;
import org.geonetwork.domain.csw202.publication.Harvest;
import org.geonetwork.domain.csw202.publication.HarvestResponse;
import org.geonetwork.domain.csw202.publication.Transaction;
import org.geonetwork.domain.csw202.publication.TransactionResponse;
import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;
import org.geonetwork.domain.ows100._19115subset.*;
import org.geonetwork.domain.ows100.filtercapabilities.*;
import org.geonetwork.domain.ows100.getcapabilities.Sections;
import org.geonetwork.domain.ows100.operationsmetadata.*;
import org.geonetwork.domain.ows100.serviceidentification.ServiceIdentification;
import org.geonetwork.domain.ows100.serviceprovider.ServiceProvider;
import org.geonetwork.domain.xsd.QName;
import org.geonetwork.search.ebrim.SearchEngine;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.geonetwork.search.ebrim.adhoc.AdhocQuerySearchEngine;
import org.geonetwork.search.ebrim.query.QueryParameters;
import org.geonetwork.search.ebrim.query.QueryResult;
import org.geonetwork.services.ebrim.GeonetworkServiceException;
import org.geonetwork.services.ebrim.csw202.record.RegistryObjectToAbstractRecord;
import org.geonetwork.services.ebrim.csw202.validation.DescribeRecordValidation;
import org.geonetwork.services.ebrim.csw202.validation.GetCapabilitiesValidation;
import org.geonetwork.services.ebrim.csw202.validation.GetRecordByIdValidation;
import org.geonetwork.services.ebrim.csw202.validation.GetRecordsValidation;
import org.geonetwork.services.ebrim.csw202.validation.GetRepositoryItemValidation;
import org.geonetwork.services.ebrim.csw202.registryobject.RegistryObjectConversor;
import org.geonetwork.utils.collection.CollectionUtil;
import org.geonetwork.utils.string.StringUtil;
import org.geonetwork.utils.xsd.XSD;
import org.geonetwork.gaap.client.GaapServicesClient;
import org.geonetwork.gaap.client.GeonetworkGaapClientException;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;

/**
 *
 * @author heikki doelGEteman
 *
 */
public class CSW202ServiceImpl implements CSW202Service {

    private static Logger log = Logger.getLogger(CSW202ServiceImpl.class);
    /**
     * Value set by Spring.
     */
    private String legacyCswUrl;
    // private String getCapabilitiesConfigDef;
    //private String capabilitiesContactDetails;
    private String serviceCswUrl;

    private Map<String, String> capabilitiesContactInfo;

    private String xsdLocation = "xsd/csw-ebrim.xsd";
    private String xsdEbRimLocation = "xsd/rim.xsd";
    private String xsdBasicPackageLocation = "xsd/pkg-basic.xsd";
    private String xsdCswLocation = "xsd/csw202/CSW-discovery.xsd";

    private String xsdLocationUrl = "xsd/csw-ebrim.xsd";
    private String xsdEbRimLocationUrl = "xsd/rim.xsd";
    private String xsdBasicPackageLocationUrl = "xsd/pkg-basic.xsd";
    private String xsdCswLocationUrl = "xsd/csw202/CSW-discovery.xsd";

    private final static String DEFAULT_NAMESPACE_MARKER = "[DEFAULT-NAMESPACE]:";
    private final static String IDENTIFIER_SLOT_NAME = "http://purl.org/dc/elements/1.1/identifier";
    private final static String DEFAULT_GETRECORDS_RESPONSE_SCHEMA = "http://www.opengis.net/cat/csw/2.0.2";
    public final static String CSW_DISCOVERY_TNS = "http://www.opengis.net/cat/csw/2.0.2";
    public final static String CSW_DISCOVERY_XSD_LOCATION = "http://schemas.opengis.net/csw/2.0.2/CSW-discovery.xsd";
    public final static String EBRIM_TNS = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0";
    public final static String EBRIM_XSD_LOCATION = "xsd/rim.xsd";
    public final static String BASIC_PACKAGE_TNS = "http://www.opengis.net/cat/wrs";
    public final static String BASIC_PACKAGE_XSD_LOCATION = "xsd/pkg-basic.xsd";
    private List<String> supportedSchemas = new ArrayList<String>();
    private Map<String, String> targetNamespaces = new HashMap<String, String>();
    private Map<String, String> xsdLocationUrls = new HashMap<String, String>();

    private GaapServicesClient gaapClient;

    public CSW202ServiceImpl() {
        init();
    }


    public void init() {
        supportedSchemas.add(CSW_DISCOVERY_TNS);
        supportedSchemas.add(EBRIM_TNS);
        supportedSchemas.add(BASIC_PACKAGE_TNS);

        targetNamespaces.put(BASIC_PACKAGE_TNS, xsdBasicPackageLocation);
		targetNamespaces.put(EBRIM_TNS, xsdEbRimLocation);
        targetNamespaces.put(CSW_DISCOVERY_TNS, xsdCswLocation);

        xsdLocationUrls.put(BASIC_PACKAGE_TNS, serviceCswUrl + xsdBasicPackageLocationUrl);
		xsdLocationUrls.put(EBRIM_TNS,  serviceCswUrl + xsdEbRimLocationUrl);
        xsdLocationUrls.put(CSW_DISCOVERY_TNS,  serviceCswUrl + xsdCswLocationUrl);

    }

    SearchEngine filterSearchEngine;
    AdhocQuerySearchEngine adhocQuerySearchEngine;
    SearchEngine xpathSearchEngine;

    /**
     * When no typenames are provided in a DescribeRecord request, the complete XSDs are returned.
     *
     * @param namespaces
     * @return
     */
    private DescribeRecordResponse describeRecordWithoutTypeNames(List<String> namespaces) {
        DescribeRecordResponse describeRecordResponse = new DescribeRecordResponse();
        List<SchemaComponent> schemaComponents = new ArrayList<SchemaComponent>();
        // return complete schema for each namespace
        if (namespaces != null) {
            for (String namespace : namespaces) {

                String[] split = namespace.split("=");
                if (split.length == 2) {
                    String namespaceUri = split[1];

                    String schemaLocation = targetNamespaces.get(namespaceUri);
                    String schemaLocationUrl = xsdLocationUrls.get(namespaceUri);

                    log.debug("namespace: " + namespace + " schemalocation: " + schemaLocation);
                    XSD xsd = new XSD(schemaLocation, XSD.LOAD_INCLUSIONS.OFF);
                    Element schema = xsd.returnSchema();
                    if (schema != null) {
                        SchemaComponent schemaComponent = new SchemaComponent();
                        schemaComponent.setSchema(new XMLOutputter().outputString(schema));
                        //schemaComponent.setParentSchema(schemaLocationUrl);
                        schemaComponent.setSchemaLanguage(DescribeRecord.XMLSCHEMA);
                        schemaComponent.setTargetNamespace(namespaceUri);
                        schemaComponents.add(schemaComponent);
                    }
                }
            }
        }
        describeRecordResponse.setSchemaComponent(schemaComponents);
        return describeRecordResponse;
    }

    /**
     * The mandatory DescribeRecord operation allows a client to discover elements of the information model supported by
     * the target catalogue service. The operation allows some or all of the information model to be described.
	 *
     * The only schema language currently supported by this profile is W3C XML Schema. The corresponding value of the
     * schemaLanguage attribute is the following URI: "http://www.w3.org/2001/XMLSchema". The outputFormat attribute may
     * be used to specify an alternative format for the response; this may be requested, for example, to obtain a more
     * human readable representation. Supported values for this parameter shall be indicated in the capabilities
     * document using an operation-specific ows:Parameter element.
	 *
     * If the request is processed successfully, the body of the response message shall include an XML document where
     * the root element has the following infoset properties:
	 *
     * [local name] = "DescribeRecordResponse". [namespace name] = "http://www.opengis.net/cat/csw/2.0.2"
     * 	 *
If there were no matching schema components, the document element shall be empty. The content of a
     * csw:SchemaComponent element may be a complete schema or a schema component. If the latter, the value of the
     * parentSchema attribute shall be a URI reference to the source schema.
	 *
     * Spec document OGC 07-038 says : The DescribeRecord operation defined in its clause 9.3 from spec document OGC
     * 05-025
	 *
     * spec document OGC 05-025 says Table 3 — HTTP method bindings DescribeRecord POST (GET)
	 *
     * and says
	 *
     * 9.3 DescribeRecord 9.3.1 Summary The DescribeRecord operation allows a client to discover the information
     * model(s) supported by the catalogue and to retrieve record type definitions. Support for the POST method binding
     * is mandatory using either of the allowed content types, although the “application/xml” content type must be
     * understood in this case. The GET binding is optional. 9.3.2 DescribeRecord request The DescribeRecord operation
     * is described in Subclause 10.6 of OGC 04-021r3 (OGC Catalogue Services 2.0). The XML representation of the entity
     * body, if present, must conform to the csw:DescribeRecord element declaration (see CSW-discovery.xsd). The
     * TypeName elements, if present, identify the model elements for which type definitions are requested. The
     * targetNamespace attribute of the csw:TypeName element must be specified; it may have the value “##any” to
     * indicate any namespace. The only schema language currently supported by this profile is W3C XML Schema. The
     * corresponding value of the schemaLanguage attribute is given by the following URI:
     * “http://www.w3.org/2001/XMLSchema”. The outputFormat attribute may be used to specify an alternative MIME media
     * type for the response. In most cases this involves transforming the raw schema to a more human readable
     * representation. Such a capability is optional. 9.3.3 DescribeRecord response If the request is processed
     * successfully, the body of the response message shall include an XML document where the document element has the
     * following infoset properties: • a [local name] of “DescribeRecordResponse”. • a [namespace name] of
     * “http://www.opengis.net/cat/csw” If no TypeName elements were provided in the request, then all of the schemas
     * defining the information model must be included within csw:SchemaComponent elements. If there are no matching
     * schema components, the document element must be empty. The content of a csw:SchemaComponent element may be a
     * complete schema or a fragment of one. If it is a fragment, the parentSchema attribute must reference the source
     * schema (by identifier). 9.3.4 Exceptions If the request is deemed invalid for any reason (e.g. missing a required
     * element), then the service must return an ows:ExceptionReport containing a service exception with the code
     * wrs:InvalidRequest.
	 *
     * <wsd:operation name="DescribeRecord" pattern="http://www.w3.org/2005/08/wsdl/in-out" safe="true"> <wsd:input
     * element="csw:DescribeRecord" /> <wsd:output element="csw:DescribeRecordResponse" /> <wsd:outfault
     * ref="tns:InvalidRequestFault" /> </wsd:operation>
	 *
	 *
     */
    public DescribeRecordResponse describeRecord(DescribeRecord request) throws CSW202ServiceException {
        // perform validation or the request
        new DescribeRecordValidation(request);

        if (request.getNamespace() == null) {
            request.setNamespace(new ArrayList<String>());
        }

        List<SchemaComponent> schemaComponents = new ArrayList<SchemaComponent>();
        List<String> namespaces = request.getNamespace();
        List<String> typeNames = request.getTypeName();
        // no typenames specified
        if (CollectionUtil.isEmpty(typeNames)) {
            return describeRecordWithoutTypeNames(namespaces);
        }
        // typenames specified
        else {
            Map<String, String> resolved = resolveTypeNames(namespaces, typeNames);
            XSD xsd = new XSD(xsdLocation);
            for (String typeName : resolved.keySet()) {
                String namespace = resolved.get(typeName);
                log.debug(typeName + " was resolved to namespace: " + namespace);
                String unQualifiedTypeName = typeName.substring(typeName.indexOf(':') + 1);
                Element schemafragment = xsd.findElementByName(unQualifiedTypeName, namespace);
                // found
                if (schemafragment != null) {
                    SchemaComponent schemaComponent = new SchemaComponent();
                    schemaComponent.setSchema(new XMLOutputter().outputString(schemafragment));

                    String schemaLocationUrl = xsdLocationUrls.get(namespace);

                    schemaComponent.setParentSchema(schemaLocationUrl); //serviceCswUrl + xsdLocationUrl);
                    schemaComponent.setSchemaLanguage(DescribeRecord.XMLSCHEMA);
                    schemaComponent.setTargetNamespace(namespace);
                    schemaComponents.add(schemaComponent);
                }
                // not found: do nothing special
            }
        }
        DescribeRecordResponse describeRecordResponse = new DescribeRecordResponse();
        describeRecordResponse.setSchemaComponent(schemaComponents);
        return describeRecordResponse;
    }

    /*
      * Expands prefixed typenames to fully resolved namespaced typenames.
      *
      * Expects namespace to be a list in the format
      *
      * prefix=namespace-uri
      *
      * Returns a mapping from unresolved typename to its namespace.
      */
    private Map<String, String> resolveTypeNames(List<String> namespaces, List<String> typeNames)
            throws CSW202ServiceException {

        // map list of namespaces
        Map<String, String> namespaceMap = new HashMap<String, String>();
        for (String namespace : namespaces) {
            String[] split = namespace.split("=");
            if (split.length == 2) {
                String prefix = split[0];
                String namespaceUri = split[1];
                if (prefix.equals("tns")) {
                    // when defined tns, it will be considered as the default namespace.
                    namespaceMap.put(DEFAULT_NAMESPACE_MARKER, namespace);
                } else {
                    namespaceMap.put(prefix, namespaceUri);
                }
            }
            // namespace mapping w/o prefix
            else {
                log.debug("namespace w/o prefix mapped as DEFAULT namespace: " + namespace);
                namespaceMap.put(DEFAULT_NAMESPACE_MARKER, namespace);
            }
        }
        Map<String, String> resolved = new HashMap<String, String>();
        for (String unresolvedTypename : typeNames) {
            log.debug("unresolvedTypename: " + unresolvedTypename);
            String[] split = unresolvedTypename.split(":");
            if (split.length == 2) {
                String prefix = split[0];
                String typeName = split[1];
                if (namespaceMap.containsKey(prefix)) {
                    log.debug("resolved type: " + typeName + " to " + namespaceMap.get(prefix));
                    resolved.put(unresolvedTypename, namespaceMap.get(prefix));
                }
                // namespace prefix of typename not in namespaces map
                else {
                    log.debug("namespace prefix not found: " + prefix);
                    String exceptionText = "Undeclared namespace prefix: " + prefix;
                    throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
                            exceptionText);
                }
            }
            // typename without prefix
            else if (split.length == 1) {
                log.debug("typename without prefix: " + split[0]);
                String defaultNamespace = namespaceMap.get(DEFAULT_NAMESPACE_MARKER);
                log.debug("default namespace: " + defaultNamespace);
                resolved.put(DEFAULT_NAMESPACE_MARKER + split[0], defaultNamespace);
            }
            // invalid typename
            else {
                String exceptionText = "Invalid typename: " + unresolvedTypename;
                throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
                        exceptionText);
            }
        }
        return resolved;
    }

    /**
	 *
     * The mandatory GetCapabilities request allows a client to retrieve information about the service.
	 *
     * The body of the response message contains a service description that advertises the basic operational and
     * non-operational characteristics of the service; the description is structured into subsections that may be
     * retrieved individually by name.
	 *
     * The GetCapabilities request is specified in cl. 7.2 of OGC 05-008 (OWS Common 1.0) and cl. 10.5 of OGC 07-006r1.
     * The GET method shall be supported. Support for the POST method is optional; the allowed content encoding(s)
     * ("application/xml" and/or "application/x-www-form-urlencoded") shall be advertised in the capabilities document
     * as values of the operation-specific "Content-Type" constraint. The value of the service parameter shall be the
     * service type code "CSW-ebRIM". The value of the version parameter shall be "1.0.0".
	 *
     * The sections parameter may be used to request a subset of the complete capabilities document; the value is a
     * comma-separated list of section names. The set of recognized section names shall be as specified in Table 7 of
     * OGC 05-008 and Table 58 of OGC 07-006r1, with the exception of "Contents".
	 *
     * If the request is processed successfully, the body of the response message shall include a valid XML document
     * where the document element has the following infoset properties:
	 *
     * [local name] = "Capabilities" [namespace name] = "http://www.opengis.net/cat/wrs/1.0"
	 *
     * A sample capabilities document is listed in Annex C.1. The corresponding type definition is shown in the code
     * listing below. See clauses 10.5 and 10.13 in OGC 07-006r1 for details. <code>
     * <xsd:element name="Capabilities" type="csw:CapabilitiesType" />
     * </code>
     *
	 * @throws CSW202ServiceException
	 *
	 *
	             <?xml version="1.0" encoding="UTF-8"?> <GetCapabilities xmlns="http://www.opengis.net/wcs/1.1"
     *                                xmlns:ows="http://www.opengis.net/ows/1.1" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     *                                xsi:schemaLocation="http://www.opengis.net/wcs/1.1 ../wcsGetCapabilities.xsd" service="WCS"
     *                                updateSequence="XYZ123"> <!-- Maximum example for WCS. Primary editor: Arliss Whiteside. Last updated
     *                                2008-02-11--> <ows:AcceptVersions> <ows:Version>1.0.0</ows:Version> <ows:Version>1.1.2</ows:Version>
     *                                </ows:AcceptVersions> <ows:Sections> <ows:Section>Contents</ows:Section> </ows:Sections>
     *                                <ows:AcceptFormats> <ows:OutputFormat>text/xml</ows:OutputFormat> </ows:AcceptFormats>
     *                                </GetCapabilities>
	 *
	 *
 	 *
     */
    public Capabilities getCapabilities(GetCapabilities request) throws CSW202ServiceException {
        // validate request
        new GetCapabilitiesValidation(request);
        // create response
        Capabilities response = new Capabilities();
        response.setUpdateSequence("0");
        response.setVersion("1.0.0");

        // Filter_Capabilities section is mandatory in xsd
        // The xsd differs from the specification
        response.setFilterCapabilities(filterCapabilities());

        // handle requested sections
        Sections sections = request.getSections();
        boolean sectionFound = (sections != null);


        // one or more sections requested
        if (sectionFound) {
            // return requested sections
            List<String> sectionList = sections.getSection();

            // If section not provided, return document with no sections
            // (except Filter_Capabilities that is required by xsd
            if (sectionList != null) {
                for (String section : sectionList) {
                    CapabilitiesSection cSection = null;
                   
                    try {
                        cSection = CapabilitiesSection.valueOf(section);
                    } catch (IllegalArgumentException e) {
                        // Ignore the exception: will be processed as a non existing section
                    }

                    if (cSection != null) {
                        switch (cSection) {
                            // where is Contents ? Not supported in CSW/ebRIM ? TODO check
                            case Contents:
                                break;
                            case Filter_Capabilities:
                                response.setFilterCapabilities(filterCapabilities());
                                break;
                            case OperationsMetadata:
                                response.setOperationsMetadata(operationsMetadata());
                                break;
                            case ServiceIdentification:
                                response.setServiceIdentification(serviceIdentification());
                                break;
                            case ServiceProvider:
                                response.setServiceProvider(serviceProvider());
                                break;
                            case All:
                                response = completeCapabilities(response);
                                break;
                        }
                    // Unsupported capabilities section
                    } else {
                        // the required section is none of the supported ones from the specification
                        // just log a warning and return complete capa document. TODO check if that is
                        // allowed by the spec
                        log.debug("WARNING: unsupported capabilities section in request: '" + cSection
                                + "', responding with complete capabilities");
                        response = completeCapabilities(response);
                    }
                }
            }
        }
        // no sections requested
        else {
            // add complete Capabilities document to response
            response = completeCapabilities(response);
        }
        return response;
    }

    private Capabilities completeCapabilities(Capabilities response) {
        response.setFilterCapabilities(filterCapabilities());
        response.setServiceIdentification(serviceIdentification());
        response.setServiceProvider(serviceProvider());
        response.setOperationsMetadata(operationsMetadata());
        response.setUpdateSequence("0");
        response.setVersion("1.0.0");
        return response;
    }

    private OperationsMetadata operationsMetadata() {
        OperationsMetadata operationsMetadata = new OperationsMetadata();
        List<Operation> operationList = new ArrayList<Operation>();


        Domain version = new Domain();
        version.setName("version");
        List<String> versionValues = new ArrayList<String>();
        versionValues.add(CSW202Constants.version);
        version.setValue(versionValues);

        Domain service = new Domain();
        service.setName("service");
        List<String> serviceValues = new ArrayList<String>();
        serviceValues.add("CSW");
        service.setValue(serviceValues);

        //
        // getcapabilities
        //
        Operation getCapabilities = new Operation();
        getCapabilities.setName("GetCapabilities");
        List<DCP> dcpList = new ArrayList<DCP>();
        DCP http = new DCP();
        List<RequestMethod> requestMethods = new ArrayList<RequestMethod>();
        RequestMethod get = new Get();
        get.setValue(serviceCswUrl + "cswebrim?");
        RequestMethod post = new Post();
        post.setValue(serviceCswUrl + "services/csw/GetCapabilities");
        requestMethods.add(get);
        requestMethods.add(post);
        http.setValue(requestMethods);
        dcpList.add(http);
        getCapabilities.setDCP(dcpList);

        Domain requestCapabilities = new Domain();
        requestCapabilities.setName("request");
        List<String> requestCapabilitiesValues = new ArrayList<String>();
        requestCapabilitiesValues.add("GetCapabilities");
        requestCapabilities.setValue(requestCapabilitiesValues);

        Domain sectionsCapabilities = new Domain();
        sectionsCapabilities.setName("Sections");
        List<String> sectionsCapabilitiesValues = new ArrayList<String>();
        sectionsCapabilitiesValues.add(CapabilitiesSection.ServiceIdentification.toString());
        sectionsCapabilitiesValues.add(CapabilitiesSection.ServiceProvider.toString());
        sectionsCapabilitiesValues.add(CapabilitiesSection.OperationsMetadata.toString());
        sectionsCapabilitiesValues.add(CapabilitiesSection.Filter_Capabilities.toString());
        sectionsCapabilitiesValues.add(CapabilitiesSection.All.toString());
        sectionsCapabilities.setValue(sectionsCapabilitiesValues);

        Domain acceptVersions = new Domain();
        acceptVersions.setName("AcceptVersions");
        List<String> acceptVersionsValues = new ArrayList<String>();
        acceptVersionsValues.add(CSW202Constants.VERSION);
        acceptVersions.setValue(acceptVersionsValues);

        Domain acceptFormats = new Domain();
        acceptFormats.setName("AcceptFormats");
        List<String> acceptFormatsValues = new ArrayList<String>();
        acceptFormatsValues.add(CSW202Constants.outputFormatapplicationXml);
        acceptFormats.setValue(acceptFormatsValues);

        Domain serviceCapabilities = new Domain();
        serviceCapabilities.setName("service");
        List<String> serviceCapabilitiesValues = new ArrayList<String>();
        serviceCapabilitiesValues.add(CSW202Constants.CSW_EBRIM);
        serviceCapabilities.setValue(serviceCapabilitiesValues);

        List<Domain> parameterList = new ArrayList<Domain>();
        parameterList.add(requestCapabilities);
        parameterList.add(serviceCapabilities);
        parameterList.add(sectionsCapabilities);
        parameterList.add(acceptVersions);
        parameterList.add(acceptFormats);

        getCapabilities.setParameter(parameterList);

        operationList.add(getCapabilities);

        //
        // describerecord
        //
        Operation describeRecord = new Operation();
        describeRecord.setName("DescribeRecord");

        dcpList = new ArrayList<DCP>();
        http = new DCP();
        requestMethods = new ArrayList<RequestMethod>();
        get = new Get();
        get.setValue(serviceCswUrl + "cswebrim?");
        post = new Post();
        post.setValue(serviceCswUrl + "services/csw/DescribeRecord");
        requestMethods.add(get);
        requestMethods.add(post);
        http.setValue(requestMethods);
        dcpList.add(http);
        describeRecord.setDCP(dcpList);

        Domain requestDescribeRecord = new Domain();
        requestDescribeRecord.setName("request");
        List<String> requestDescribeRecordValues = new ArrayList<String>();
        requestDescribeRecordValues.add("DescribeRecord");
        requestDescribeRecord.setValue(requestDescribeRecordValues);

        Domain typeName = new Domain();
        typeName.setName("typeName");
        List<String> typeNameValues = new ArrayList<String>();
        typeNameValues.add("csw:Record");
        typeNameValues.add("rim:ExtrinsicObject");
        typeName.setValue(typeNameValues);

        Domain outputFormat = new Domain();
        outputFormat.setName("outputFormat");
        List<String> outputFormatValues = new ArrayList<String>();
        outputFormatValues.add("application/xml");
        outputFormat.setValue(outputFormatValues);

        Domain schemaLanguage = new Domain();
        schemaLanguage.setName("schemaLanguage");
        List<String> schemaLanguageValues = new ArrayList<String>();
        schemaLanguageValues.add("XMLSCHEMA");
        schemaLanguage.setValue(schemaLanguageValues);

        parameterList = new ArrayList<Domain>();
        parameterList.add(requestDescribeRecord);
        parameterList.add(service);
        parameterList.add(version);
        parameterList.add(typeName);
        parameterList.add(outputFormat);
        parameterList.add(schemaLanguage);
        describeRecord.setParameter(parameterList);

        operationList.add(describeRecord);

        //
        // GetRepositoryItem
        //
        Operation getRepositoryItem = new Operation();
        getRepositoryItem.setName("GetRepositoryItem");

        dcpList = new ArrayList<DCP>();
        http = new DCP();
        requestMethods = new ArrayList<RequestMethod>();
        get = new Get();
        get.setValue(serviceCswUrl + "cswebrim?");

        requestMethods.add(get);
        http.setValue(requestMethods);
        dcpList.add(http);
        getRepositoryItem.setDCP(dcpList);

        parameterList = new ArrayList<Domain>();

        Domain requestGetRepositoryItem = new Domain();
        requestGetRepositoryItem.setName("request");
        List<String> requestGetRepositoryItemValues = new ArrayList<String>();
        requestGetRepositoryItemValues.add("GetRepositoryItem");
        requestGetRepositoryItem.setValue(requestGetRepositoryItemValues);
        parameterList.add(requestGetRepositoryItem);

        // OGC 07-110r2: The values of the request and service parameters shall be GetRepositoryItem and CSW-ebRIM, respectively
        Domain serviceGetRepositoryItem = new Domain();
        serviceGetRepositoryItem.setName("service");
        List<String> serviceGetRepositoryItemValues = new ArrayList<String>();
        serviceGetRepositoryItemValues.add(CSW202Constants.CSW_EBRIM);
        serviceGetRepositoryItem.setValue(serviceGetRepositoryItemValues);
        parameterList.add(serviceGetRepositoryItem);

        Domain idParameter = new Domain();
        idParameter.setName("id");
        List<String> idParameterValues = new ArrayList<String>();
        idParameterValues.add("");
        idParameter.setValue(idParameterValues);
        parameterList.add(idParameter);
        getRepositoryItem.setParameter(parameterList);

        operationList.add(getRepositoryItem);

        //
        // GetRecordById
        //
        Operation getRecordById = new Operation();
        getRecordById.setName("GetRecordById");

        dcpList = new ArrayList<DCP>();
        http = new DCP();
        requestMethods = new ArrayList<RequestMethod>();
        get = new Get();
        get.setValue(serviceCswUrl + "cswebrim?");
        post = new Post();
        post.setValue(serviceCswUrl + "services/csw/GetRecordById");
        requestMethods.add(get);
        requestMethods.add(post);
        http.setValue(requestMethods);
        dcpList.add(http);
        getRecordById.setDCP(dcpList);

        parameterList = new ArrayList<Domain>();

        Domain requestGetRecordById = new Domain();
        requestGetRecordById.setName("request");
        List<String> requestGetRecordByIdValues = new ArrayList<String>();
        requestGetRecordByIdValues.add("GetRecordById");
        requestGetRecordById.setValue(requestGetRecordByIdValues);
        parameterList.add(requestGetRecordById);

        parameterList.add(service);
        parameterList.add(version);

        Domain identifierGetRecordById = new Domain();
        identifierGetRecordById.setName("id");
        List<String> identifierGetRecordByIdValues = new ArrayList<String>();
        identifierGetRecordByIdValues.add("");
        identifierGetRecordById.setValue(identifierGetRecordByIdValues);
        parameterList.add(identifierGetRecordById);

        Domain elementSetNameParameter = new Domain();
        elementSetNameParameter.setName("ElementSetName");
        List<String> elementSetNameValues = new ArrayList<String>();
        elementSetNameValues.add(ElementSet.brief.toString());
        elementSetNameValues.add(ElementSet.summary.toString());
        elementSetNameValues.add(ElementSet.full.toString());
        elementSetNameParameter.setValue(elementSetNameValues);
        parameterList.add(elementSetNameParameter);

        Domain outputFormatParameter = new Domain();
        outputFormatParameter.setName("outputFormat");
        outputFormatValues = new ArrayList<String>();
        outputFormatValues.add("application/xml");
        outputFormatParameter.setValue(outputFormatValues);
        parameterList.add(outputFormatParameter);

        Domain outputSchemaParameter = new Domain();
        outputSchemaParameter.setName("outputSchema");
        List<String> outputSchemaParameterValues = new ArrayList<String>();
        outputSchemaParameterValues.add("urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0");
        outputSchemaParameterValues.add("http://www.opengis.net/cat/csw/2.0.2");
        outputSchemaParameter.setValue(outputSchemaParameterValues);
        
        parameterList.add(outputSchemaParameter);

        getRecordById.setParameter(parameterList);

        operationList.add(getRecordById);

        // GetRecords
        Operation getRecords = new Operation();
        getRecords.setName("GetRecords");

        dcpList = new ArrayList<DCP>();
        http = new DCP();
        requestMethods = new ArrayList<RequestMethod>();
        get = new Get();
        post = new Post();
        requestMethods.add(get);
        get.setValue(serviceCswUrl + "cswebrim?");
        requestMethods.add(post);
        post.setValue(serviceCswUrl + "services/csw/GetRecords");
        http.setValue(requestMethods);
        dcpList.add(http);
        getRecords.setDCP(dcpList);

        parameterList = new ArrayList<Domain>();

        parameterList.add(service);
        parameterList.add(version);

        Domain namespaceParameter = new Domain();
        namespaceParameter.setName("NAMESPACE");
        List<String> namespaceParameterValues = new ArrayList<String>();
        namespaceParameterValues.add("");
        namespaceParameter.setValue(namespaceParameterValues);
        parameterList.add(namespaceParameter);

        Domain resultTypeParameter = new Domain();
        resultTypeParameter.setName("resultType");
        List<String> resultTypeValue = new ArrayList<String>();
        resultTypeValue.add(ResultType.hits.toString());
        resultTypeValue.add(ResultType.results.toString());
        resultTypeValue.add(ResultType.validate.toString());

        resultTypeParameter.setValue(resultTypeValue);
        parameterList.add(resultTypeParameter);

        Domain requestIdParameter = new Domain();
        requestIdParameter.setName("requestId");
        List<String> requestIdParameterValues = new ArrayList<String>();
        requestIdParameterValues.add("");
        requestIdParameter.setValue(requestIdParameterValues);
        parameterList.add(requestIdParameter);

        outputFormatParameter = new Domain();
        outputFormatParameter.setName("outputFormat");
        outputFormatValues = new ArrayList<String>();
        outputFormatValues.add("application/xml");
        outputFormatParameter.setValue(outputFormatValues);
        parameterList.add(outputFormatParameter);

        parameterList.add(outputSchemaParameter);

        Domain startPositionParameter = new Domain();
        startPositionParameter.setName("startPosition");
        List<String> startPositionParameterValues = new ArrayList<String>();
        startPositionParameterValues.add("");
        startPositionParameter.setValue(startPositionParameterValues);
        parameterList.add(startPositionParameter);

        Domain maxRecordsParameter = new Domain();
        List<String> maxRecordsParameterValues = new ArrayList<String>();
        maxRecordsParameterValues.add("");
        maxRecordsParameter.setValue(maxRecordsParameterValues);
        maxRecordsParameter.setName("maxRecords");
        
        parameterList.add(maxRecordsParameter);

        Domain typeNamesParameter = new Domain();
        typeNamesParameter.setName("typeNames");
        List<String> typeNamesParameterValues = new ArrayList<String>();
        typeNamesParameterValues.add("");
        typeNamesParameter.setValue(typeNamesParameterValues);
        parameterList.add(typeNamesParameter);

        parameterList.add(elementSetNameParameter);

        Domain elementNameParameter = new Domain();
        elementNameParameter.setName("ElementName");
        List<String> elementNameParameterValues = new ArrayList<String>();
        elementNameParameterValues.add("");
        elementNameParameter.setValue(elementNameParameterValues);
        parameterList.add(elementNameParameter);

        Domain constraintLanguageParameter = new Domain();
        constraintLanguageParameter.setName("CONSTRAINTLANGUAGE");
        List<String> constraintLanguageValues = new ArrayList<String>();
        constraintLanguageValues.add("FILTER");
        constraintLanguageParameter.setValue(constraintLanguageValues);
        parameterList.add(constraintLanguageParameter);

        Domain constraintParameter = new Domain();
        constraintParameter.setName("Constraint");
        List<String> constraintParameterValues = new ArrayList<String>();
        constraintParameterValues.add("");
        constraintParameter.setValue(constraintParameterValues);
        parameterList.add(constraintParameter);

        Domain sortByParameter = new Domain();
        sortByParameter.setName("SortBy");
        List<String> sortByParameterValues = new ArrayList<String>();
        sortByParameterValues.add("");
        sortByParameter.setValue(sortByParameterValues);
        parameterList.add(sortByParameter);

        getRecords.setParameter(parameterList);

        operationList.add(getRecords);

        operationsMetadata.setOperation(operationList);

        ExtendedCapabilities extendedCapabilities = new ExtendedCapabilities();

        extendedCapabilities.setWsdlLocation("urn:ogc:specification:wrs:1.0:wsdl-1.1:service " + serviceCswUrl + "wsdl/csw.wsdl");
        
        operationsMetadata.setExtendedCapabilities(extendedCapabilities);
        return operationsMetadata;
    }

    private ServiceIdentification serviceIdentification() {
        ServiceIdentification si = new ServiceIdentification();
        si.setServiceType(CSW202Constants.CSW_EBRIM_SERVICE_TYPE);
        List<String> serviceTypeVersion = new ArrayList<String>();
        serviceTypeVersion.add(CSW202Constants.VERSION);
        si.setTitle(CSW202Constants.CSW_EBRIM);
        si.setServiceTypeVersion(serviceTypeVersion);
        return si;
    }

    private ServiceProvider serviceProvider() {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setProviderName(capabilitiesContactInfo.get("provider.name"));
        OnlineResource providerSite = new OnlineResource();
        providerSite.setValue(capabilitiesContactInfo.get("provider.site"));
        serviceProvider.setProviderSite(providerSite);
        // ResponsiblePartySubset serviceContact = new ResponsiblePartySubset();
        Contact contactInfo = new Contact();
        Address address = new Address();

        address.setAdministrativeArea(capabilitiesContactInfo.get("address.adminarea"));
        address.setCity(capabilitiesContactInfo.get("address.city"));
        address.setCountry(capabilitiesContactInfo.get("address.country"));
        address.setPostalCode(capabilitiesContactInfo.get("address.postalcode"));

        String emailAddresses = capabilitiesContactInfo.get("address.email");
        if (!StringUtil.isEmpty(emailAddresses)) {
            List<String> emailAdressesList = Arrays.asList(emailAddresses.split(","));
            address.setElectronicMailAddress(emailAdressesList);
        }

        String deliveryPoints = capabilitiesContactInfo.get("address.deliverypoint");
        if (!StringUtil.isEmpty(deliveryPoints)) {
            List<String> deliveryPointsList = Arrays.asList(deliveryPoints.split(","));
            address.setDeliveryPoint(deliveryPointsList);
        }

        contactInfo.setAddress(address);

        contactInfo.setHoursOfService(capabilitiesContactInfo.get("hoursofservice"));

        Telephone phone = new Telephone();
        String voicePhones = capabilitiesContactInfo.get("phone.voice");
        log.debug("phone.voice" + voicePhones);
        if (!StringUtil.isEmpty(voicePhones)) {
            List<String> voicePhonesList = Arrays.asList(voicePhones.split(","));
            log.debug("phone.voice" + voicePhonesList.size());

            phone.setVoice(voicePhonesList);
        }
        String facsimilesPhones = capabilitiesContactInfo.get("phone.facsimile");
        log.debug("phone.facsimile" + facsimilesPhones);
        if (!StringUtil.isEmpty(facsimilesPhones)) {
            List<String> facsimilesPhonesList = Arrays.asList(facsimilesPhones.split(","));
            log.debug("phone.voice" + facsimilesPhonesList.size());
            phone.setFacsimile(facsimilesPhonesList);
        }
        contactInfo.setPhone(phone);
        contactInfo.setContactInstructions(capabilitiesContactInfo.get("contactinstructions"));
        capabilitiesContactInfo.get("hoursofservice");

        ResponsiblePartySubset serviceContact = new ResponsiblePartySubset();
        serviceContact.setContactInfo(contactInfo);
        serviceContact.setIndividualName(capabilitiesContactInfo.get("individualname"));
        serviceContact.setPositionName(capabilitiesContactInfo.get("positionname"));

        // TODO: Role


        serviceProvider.setServiceContact(serviceContact);
        return serviceProvider;
    }

    private FilterCapabilities filterCapabilities() {
        //
        // filtercapabilities
        //
        FilterCapabilities filterCapabilities = new FilterCapabilities();

        IdCapabilities idCapabilities = new IdCapabilities();
        List<ID> ids = new ArrayList<ID>();
        ids.add(new EID());
        ids.add(new FID());        
        idCapabilities.setIds(ids);
        filterCapabilities.setIdCapabilities(idCapabilities);

        ScalarCapabilities scalarCapabilities = new ScalarCapabilities();
        //List<ArithmeticOperator> arithmeticOperators = new ArrayList<ArithmeticOperator>();
        // no arithmetic is supported
        //scalarCapabilities.setArithmeticsOperators(arithmeticOperators);

        List<ComparisonOperator> comparisonOperators = new ArrayList<ComparisonOperator>();
        comparisonOperators.add(ComparisonOperator.Between);
        comparisonOperators.add(ComparisonOperator.EqualTo);
        comparisonOperators.add(ComparisonOperator.GreaterThan);
        comparisonOperators.add(ComparisonOperator.GreaterThanEqualTo);
        comparisonOperators.add(ComparisonOperator.LessThan);
        comparisonOperators.add(ComparisonOperator.LessThanEqualTo);
        comparisonOperators.add(ComparisonOperator.Like);
        comparisonOperators.add(ComparisonOperator.NotEqualTo);
        scalarCapabilities.setComparisonOperators(comparisonOperators);

        List<LogicalOperator> logicalOperators = new ArrayList<LogicalOperator>();
        scalarCapabilities.setLogicalOperators(logicalOperators);
        filterCapabilities.setScalarCapabilities(scalarCapabilities);

        SpatialCapabilities spatialCapabilities = new SpatialCapabilities();

        List<GeometryOperand> geometryOperands = new ArrayList<GeometryOperand>();
        geometryOperands.add(GeometryOperand.gml_Envelope);
        spatialCapabilities.setGeometryOperands(geometryOperands);
        
        List<SpatialOperator> spatialOperators = new ArrayList<SpatialOperator>();
        SpatialOperator bbox = new SpatialOperator();
        bbox.setName(SpatialOperatorName.BBOX);
        spatialOperators.add(bbox);
        spatialCapabilities.setSpatialOperators(spatialOperators);
        filterCapabilities.setSpatialCapabilities(spatialCapabilities);

        return filterCapabilities;
    }

    /**
     * The optional GetDomain request is specified in clause 10.7 of OGC 07-006r1. This request produces a description
     * of the value domain of a given data element or request parameter, where the value domain is the set of actual or
     * permissible values. The value domain may be enumerated or non-enumerated. A possible use of this request is to
     * discover 'active' terms in a taxonomy that are currently being used to classify registry objects. The actual type
     * of the data element is always returned, even if additional information about the value space is available.
	 *
     * The value of the csw:PropertyName element shall be an XPath expression (location path) that refers to some ebRIM
     * property. Many of the ebRIM properties can be accessed in this manner, and those that refer to nodes in canonical
     * classification schemes can be queried in this manner.
	 *
     * As a special case, a request for a list of published�rather than supported�object types must identify only those
     * object types of which instances exist in the catalogue. That is, specifying a PropertyName value of
     * "rim:RegistryObject/@objectType" will yield a list of object types that currently populate the catalogue. In
     * general, all properties that refer to nodes in canonical classification schemes shall be handled in this manner.
	 *
     */
    public GetDomainResponse getDomain(GetDomain request) throws CSW202ServiceException {
        String parameter = request.getParameterName();
        String property = request.getPropertyName();
        GetDomainResponse response = new GetDomainResponse();

        if (parameter == null && property == null) {
            String exceptionText = "Parametername and PropertyName of the request are empty.";
            throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_INVALIDREQUEST,
                    exceptionText);
        }

        // one of those should be present
        if (parameter != null) {
            // TODO what would be the value of parameter? XPATH too ?
        } else if (property != null) {
            // TODO process XPATH in property
        }
        return response;
    }

    /**
     * Implements CSW 2.0.2 ebRIM profile GetRecordById operation. The supplied identifier values are checked for
     * matches against either the id attribute of a registry object (rim:RegistryObject/@id) or an external identifier
     * (rim:ExternalIdentifier/@value) assigned to a registry object.
	 *
	 *
     * From the specs document OGC 07-110r2
	 *
     * 11.2 GetRecordById request The XML representation of the message body in a request submitted using the POST
     * method shall be a valid csw:GetRecordById element.
	 *
     * 11.3 GetRecordById response If the request is processed successfully, the body of the response message shall
     * include an XML document where the root element has the following infoset properties: - [local name] =
     * "GetRecordByIdResponse". - [namespace name] = "http://www.opengis.net/cat/csw/2.0.2". The document element shall
     * contain registry object representations corresponding to the requested output schema and element set (view). A
     * registry object in the result set shall satisfy any of the following cases: a) have a matching @id attribute
     * value; or b) have a child rim:ExternalIdentifier element with a matching @value attribute.
	 *
	 *
	 *
     */
    public GetRecordByIdResponse getRecordById(GetRecordById request) throws CSW202ServiceException {
        new GetRecordByIdValidation(request);

        // collect request parameters
        List<String> ids = request.getId();
        ElementSetName elementSetName = request.getElementSetName();
        ElementSet elementSet = elementSetName.getElementSet();
        try {
            // search
            List<RegistryObject> results = filterSearchEngine.queryById(ids);

            // create response
            GetRecordByIdResponse response = new GetRecordByIdResponse();
            // If there is no matching record, the response message must be empty
            if (results.size() > 0) {
                String outputSchema = request.getOutputSchema();

                if (outputSchema.equals(CSW202Constants.outputSchemaCsw)) {
                    List<AbstractRecord> records = convertResultsToAbstractRecords(elementSet, null, results);
                    response.setAbstractRecords(records);

                } else {
                    if (elementSet == ElementSet.full) {
                        response.setOtherRecords(results);
                    } else {
                        List<RegistryObject> records = convertResultsToRegistryObjects(elementSet, null, results);

                        response.setOtherRecords(records);
                    }
                }

            }
            return response;
        } catch (SearchEngineException e) {
            String exceptionText = "SearchEngineException: " + e.getMessage();
            throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTIMPLEMENTED,
                    exceptionText);
        }
    }

    /**
     * Implements CSW 2.0.2 ebRIM profile GetRecords operation.
     */
    public GetRecordsResponse getRecords(GetRecords request) throws CSW202ServiceException {
        new GetRecordsValidation(request);
        //
        // collect request parameters
        //
        // The maxRecords parameter is used to define the maximum number of records that should be
        // returned from the result set of a query. If it is not specified, then 10 records shall
        // be returned. If its value is set to zero, then the behaviour is identical to setting
        // "resultType=hits" as described in subclause 10.8.4.2.
        Integer maxRecords = request.getMaxRecords();
        // The startPosition parameter is used to indicate at which record position the catalogue
        // should start generating output. The default value is 1 meaning it starts at the first
        // record in the result set.
        Integer startPosition = request.getStartPosition();
        // The requestId parameter may be included to uniquely identify this request message. If
        // the client specifies a requestId in its request, the server shall use it in its
        // responses. If the client does not specify a requestId but includes a ResponseHandler in
        // its request and if the service supports asynchronous processing, the server shall
        // generate a requestId and put it in the acknowledgement message and in the response. If
        // the client specifies neither a requestId nor a ResponseHandler in its request, the
        // server shall not put a requestId in its response. Whether generated by the client or by
        // the server, the requestId specified shall include a UUID (Universal Unique Identifier),
        // generated using the mechanism described in the X.667 specification. The ResponseHandler
        // should use requestId as part of it value.
        String requestId = request.getRequestID();
        // The resultType parameter may have the value "hits", "results", or "validate"; the value
        // determines whether the catalogue service returns just a summary of the result set,
        // includes one or more records from the result set, or validates the request message and
        // processes it asynchronously.
        //
        // If the resultType parameter is set to "hits", the catalogue service shall return a
        // <GetRecordsResponse> element containing an empty <SearchResults> element that
        // indicates the estimated size of the result set. Optional attributes may or may not be
        // set accordingly.
        //
        // If the resultType parameter is set to "results", the catalogue service shall include any
        // matching records within the <SearchResults> element, up to the maximum number of records
        // specified in the request.
        //
        // If the resultType parameter is set to "validate", the catalogue service shall validate
        // the request and return an <Acknowledgement> message if validation succeeds. An
        // <ows:ExceptionReport> element, as described in Subclause 10.3.7, is returned if
        // validation fails. If the catalogue supports asynchronous query processing, the
        // acknowledgment response shall include a RequestId element that may be subsequently used
        // to retrieve the result set when processing is complete.
        ResultType resultType = request.getResultType();
        // The outputFormat parameter is used to control the format of the output that is generated
        // in response to a GetRecords request. Its value shall be a MIME type. The default value,
        // "application/xml", means that the output shall be an XML document. All catalogs shall at
        // least support XML as an output format. Other output formats may be supported and may
        // include output formats such as TEXT (MIME type text/plain), HTML (MIME type text/html) or
        // XML without an associated schema (MIME type text/xml). The list of output formats that a
        // CSW
        // instance provides shall be advertised in the Capabilities document.
        //
        // In the case where the output format is application/xml, the CSW shall generate an XML
        // document
        // that validates against a schema document that is specified in the output document via the
        // xsi:schemaLocation attribute defined in XML.
        // String outputFormat = request.getOutputFormat();
        // The outputSchema parameter is used to indicate the schema of the output that is generated
        // in response to a GetRecords request. The default value for this parameter shall be:
        // http://www.opengis.net/cat/csw/2.0.2
        // indicating that the schema for the core returnable properties (as defined in Subclause
        // 10.2.5) shall be used. Application profiles may define additional values for
        // outputSchema,
        // but all profiles shall support the value
        // http://www.opengis.net/cat/csw/2.0.2.
        //
        // Although the value of this parameter can be any URI, any additional values defined for
        // the outputSchema parameter should be the target namespace of the additionally supported
        // output schemas and should include a version number. For example, the value
        // urn:oasis:names:tc:ebxml-regrep:rim:xsd:2.5
        // might be used to indicate an ebRIM v2.5 output schema, while the value
        // urn:oasis:names:tc:ebxml-regrep:rim:xsd:3.0
        // might be used to indicate an ebRIM v3.0 output schema.
        //
        // The list of supported output schemas shall be advertised in the capabilities document of
        // the service using the Parameter element as outlined in OGC 05-008.
        String outputSchema = request.getOutputSchema();

        //
        // Query handling
        //

        //
        // csw:Query -- Filter or CQL
        //
        Query query = request.getQuery();
        String filter = null;
        // note: cql is not supported.
        @SuppressWarnings("unused")
        String cqlText = null;

        if ((query != null) && (query.getConstraint() != null)) {
            filter = query.getConstraint().getFilter();
            cqlText = query.getConstraint().getCQLText();
        }

        //
        // wrs:StoredQuery
        //
        //StoredQuery storedQuery = request.getStoredQuery();

        //
        // rim:AdhocQuery
        //
        @SuppressWarnings("unused")
        AdhocQuery adhocQuery = request.getAdhocQuery();

        // The ResponseHandler and DistributedSearch elements, if present, shall be ignored and the
        // request processed in the normal synchronous manner by the recipient.

        QueryParameters queryContext = new QueryParameters();
        if (request.getQuery() != null) {
            queryContext.setElementNames(request.getQuery().getElementName());
            queryContext.setElementSetName(request.getQuery().getElementSetName());
            if (request.getQuery().getElementSetName() != null) {
                if (request.getQuery().getElementSetName().getTypeNames() != null) {
                    queryContext.setTypeNameList(request.getQuery().getElementSetName().getTypeNames());
                } else {
                    List<String> typeNames = new ArrayList<String>();
                    for(QName n : request.getQuery().getTypeNames()) {
                        typeNames.add(n.getValue());
                    }
                    queryContext.setTypeNameList(typeNames);    
                }

            }
            queryContext.setSortBy(request.getQuery().getSortBy());
        }
        queryContext.setFilter(filter);
        queryContext.setMaxRecords(maxRecords);
        queryContext.setResultType(resultType);
        queryContext.setStartPosition(startPosition);

        if ((request.getAuthToken() != null) && (!request.getAuthToken().equals(""))) {
            try {
                gaapClient.setAuthToken(request.getAuthToken());
                String userUuid = gaapClient.getUserUuidByAuthToken();

                queryContext.setUserUuid(userUuid);
            } catch (GeonetworkGaapClientException ex) {
                // Ignore user info. Return public metadata
             
            }
        }
        
        //
        // search
        //
        QueryResult queryResult = null;
        try {
            if ((filter != null) || (adhocQuery == null)) {
                // use OGC Filter search engine
                queryResult = filterSearchEngine.query(query, queryContext);
            } else if (adhocQuery != null) {
                queryResult = adhocQuerySearchEngine.query(adhocQuery, queryContext);
            } else {
                String exceptionText = "SearchEngineException: only Filter and AdhocQuery is implemented";
                throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTIMPLEMENTED,
                        exceptionText);
            }
        } catch (SearchEngineException e) {
            String exceptionText = "SearchEngineException: " + e.getMessage();
            throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTIMPLEMENTED,
                    exceptionText);
        }

        //
        // create response
        //
        GetRecordsResponse response = new GetRecordsResponse();

        if (StringUtil.isNotEmpty(requestId)) {
            response.setRequestId(requestId);
        }
        RequestStatus requestStatus = new RequestStatus();
        requestStatus.setTimestamp(new Date());
        response.setSearchStatus(requestStatus);

        SearchResults searchResults = new SearchResults();

        // TODO take the outputSchema into account
        // TODO take the outputFormat into account

        // If the resultType attribute in the request has the value "validate" (i.e., process the
        // request asynchronously), the response shall include an exception with code
        // "wrs:NotSupported".
        if (resultType == ResultType.validate) {
            String exceptionText = "SearchEngineException: ResultType 'validate' is not supported";
            throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(Exception.WRS_NOTSUPPORTED,
                    exceptionText);
        }
        //
        // Include results in the response.
        //
        else if (resultType == ResultType.results) {
            // TODO find out what the default should be. CSW spec doesnt say it..
            ElementSet returnElementSet = null;

            String schemaToUse = null;
            
            if (adhocQuery != null) {
                searchResults.setOtherRecords(queryResult.getData());
                schemaToUse = EBRIM_TNS;
            } else {
                if (query.getElementName() == null) returnElementSet =  ElementSet.summary;
                if (query != null && query.getElementSetName() != null && query.getElementSetName().getElementSet() != null) {
                    returnElementSet = query.getElementSetName().getElementSet();
                }
                schemaToUse = determineSchemaToUse(outputSchema);

                if (schemaToUse.equals(EBRIM_TNS)) {
                    if ((returnElementSet != null) && (returnElementSet == ElementSet.full)) {                       
                        searchResults.setOtherRecords(queryResult.getData());
                    } else {
                        List<RegistryObject> records = convertResultsToRegistryObjects(returnElementSet, request.getQuery().getElementName(),
                                queryResult.getData());
                        searchResults.setOtherRecords(records);
                    }
                } else if (schemaToUse.equals(CSW_DISCOVERY_TNS)) {
                    List<AbstractRecord> records = convertResultsToAbstractRecords(returnElementSet, request.getQuery().getElementName(),
                            queryResult.getData());
                    searchResults.setRecords(records);
                }
            }

            searchResults.setNumberOfRecordsMatched(queryResult.getNumberOfRecordsMatched());
            searchResults.setNumberOfRecordsReturned(queryResult.getData().size());
            int nextRecord = startPosition + queryResult.getData().size() ;

            if (nextRecord < queryResult.getNumberOfRecordsMatched())
                searchResults.setNextRecord(nextRecord);
            else
                searchResults.setNextRecord(0);


            searchResults.setElementSet(returnElementSet);
            searchResults.setRecordSchema(schemaToUse);
        }
        //
        // Provide a result set summary, but no results.
        //
        else if (resultType == ResultType.hits) {
            searchResults.setNumberOfRecordsMatched(queryResult.getNumberOfRecordsMatched());
            searchResults.setNumberOfRecordsReturned(0);
            searchResults.setNextRecord(0);
        }

        // If a supplied query is expressed in an unsupported query language, the response shall
        // include an exception with code "wrs:NotSupported".
        // TODO should we really do this ?
        boolean queryLanguageSupported = true;
        if (!queryLanguageSupported) {
            // TODO see how to include an exception in the response
        }
     
        response.setSearchResults(searchResults);

        return response;
    }

    /**
     * Converts a list of search results (RegistryObjects) to a list of AbstractRecords, taking into account the
     * elementSet ('brief', 'summary' or 'full')
     *
     * @param elementSet
     * @param searchResults
     * @return
     */
    private List<AbstractRecord> convertResultsToAbstractRecords(ElementSet elementSet, List<String> elementNames,
                                                                 List<RegistryObject> searchResults) {
        List<AbstractRecord> abstractRecords = new ArrayList<AbstractRecord>();
        for (RegistryObject registryObject : searchResults) {
            AbstractRecord abstractRecord = RegistryObjectToAbstractRecord.convert(elementSet, elementNames, registryObject);
            abstractRecords.add(abstractRecord);
        }
        return abstractRecords;
    }

    /**
     * Converts a list of search results (RegistryObjects) to a list of RegistryObjects, taking into account the
     * elementSet ('brief', 'summary' or 'full')
     *
     * @param elementSet
     * @param searchResults
     * @return
     */
    private List<RegistryObject> convertResultsToRegistryObjects(ElementSet elementSet, List<String> elementNames,
                                                                 List<RegistryObject> searchResults) {
        List<RegistryObject> registryObjectRecords = new ArrayList<RegistryObject>();
        for (RegistryObject registryObject : searchResults) {
            RegistryObject registryObjectConverted =  RegistryObjectConversor.convert(elementSet, elementNames, registryObject);

            registryObjectRecords.add(registryObjectConverted);
        }
        return registryObjectRecords;
    }

    /**
     * Only http://www.opengis.net/cat/csw/2.0.2 is supported.
     *
     * @param requestedSchema
     * @return
     */
    private String determineSchemaToUse(String requestedSchema) {
        if (supportedSchemas.contains(requestedSchema)) {
            return requestedSchema;
        } else {
            return DEFAULT_GETRECORDS_RESPONSE_SCHEMA;
        }
    }

    /**
     * The mandatory GetRepositoryItem request is used to retrieve the repository item corresponding to some extrinsic
     * object. If available, the item is included in the body of the response; it shall be an instance of the media type
     * indicated by the value of the Content-Type entity header field.
	 *
     * This request is submitted using the GET method. The values of the request and service parameters shall be
     * GetRepositoryItem and CSW-ebRIM, respectively. The mandatory id parameter shall be an absolute URI that specifies
     * the identifier of the extrinsic object that describes the item.
	 *
     * If the request is processed successfully and a repository item is accessible, the body of the response message
     * shall include the repository item with status code 200. The Content-Type header shall correctly identify the
     * media type of the enclosed resource. If an additional encoding has been applied to the resource (such as
     * compression using gzip) this shall be indicated by the Content-Encoding entity header.
	 *
     * If the supplied identifier does not match any registry object or if a repository item cannot be located, the
     * response shall include a status code of 404.
     *
     * @param id
     * @return
     */
    public GetRepositoryItemResponse getRepositoryItem(String id) throws CSW202ServiceException {
        GetRepositoryItemValidation.validate(id);
        GetRepositoryItemResponse response = new GetRepositoryItemResponse();
        String fileIdentifier = null;
        try {
            // find registry object with that id
            RegistryObject registryObject = filterSearchEngine.queryById(id);
            if (registryObject != null) {
                // find the fileIdentifier (that's the RepositoryItem ID)
                for (Slot slot : registryObject.findSlotsByName(IDENTIFIER_SLOT_NAME)) {
                    ValueList valueList = slot.getValueList();
                    if (valueList.getValues().size() > 0) {
                        fileIdentifier = valueList.getValues().get(0).getValue();
                    }
                }
            } else {
                // empty response -- should be returned as HTTP 404.
                return response;
            }
        } catch (SearchEngineException x) {
            log.debug("GetRepositoryItem: SearchEngineException: " + x.getMessage());
            throw new CSW202ServiceException(x.getMessage(), x);
        }

        // send GetRecordById request to the legacy Geonetwork application
        //
        // set up GetRecordById request
        //
        //NameValuePair requestParam = new NameValuePair("request", GetRecordById.GET_RECORD_BY_ID);
        NameValuePair idParam = new NameValuePair("uuid", fileIdentifier);
        //NameValuePair elementSetParam = new NameValuePair("elementsetname", ElementSet.full.toString());
        //NameValuePair[] queryString = {requestParam, idParam, elementSetParam};
        NameValuePair[] queryString = {idParam};
        log.debug("queryString: " + queryString);
        log.debug("legacyCswUrl: " + legacyCswUrl);

        HttpMethod getGetRecordById = null;
        try {
            HttpClient httpClient = new HttpClient();
            getGetRecordById = new GetMethod(legacyCswUrl + "/iso19139.xml");
            getGetRecordById.setQueryString(queryString);
            //
            // send GetRecordById to legacy application
            //
            httpClient.executeMethod(getGetRecordById);
            //
            // handle response
            //
            byte[] responseBody = getGetRecordById.getResponseBody();
            log.debug("local getrecordbyid response: " + new String(responseBody));
            response.setResponse(new String(responseBody));
            return response;
        } catch (HttpException x) {
            log.debug("GetRepositoryItem: HttpException: " + x.getMessage());
            throw new CSW202ServiceException(x.getMessage(), x);
        } catch (IOException x) {
            log.debug("GetRepositoryItem: IOException: " + x.getMessage());
            throw new CSW202ServiceException(x.getMessage(), x);
        } finally {
            getGetRecordById.releaseConnection();
        }
    }

    public HarvestResponse harvest(Harvest request) {
        return null;
    }

    public TransactionResponse transaction(Transaction request) {
        return null;
    }

    public void setFilterSearchEngine(SearchEngine filterSearchEngine) {
        this.filterSearchEngine = filterSearchEngine;
    }

    public void setAdhocQuerySearchEngine(AdhocQuerySearchEngine adhocQuerySearchEngine) {
        this.adhocQuerySearchEngine = adhocQuerySearchEngine;
    }

    public void setXpathSearchEngine(SearchEngine xpathSearchEngine) {
        this.xpathSearchEngine = xpathSearchEngine;
    }

    public void setLegacyCswUrl(String legacyCswUrl) {
        this.legacyCswUrl = legacyCswUrl;
    }

    public void setServiceCswUrl(String serviceCswUrl) {
        this.serviceCswUrl = serviceCswUrl;

        if (!serviceCswUrl.endsWith("/")) this.serviceCswUrl = this.serviceCswUrl + "/";
    }



    public void setCapabilitiesContactInfo(Map<String, String> capabilitiesContactInfo) {
        this.capabilitiesContactInfo = capabilitiesContactInfo;
    }

    // public void setGetCapabilitiesConfigDef(String getCapabilitiesConfigDef) {
    // this.getCapabilitiesConfigDef = getCapabilitiesConfigDef;
    // }

    /*public void setCapabilitiesContactDetails(String capabilitiesContactDetails) {
         this.capabilitiesContactDetails = capabilitiesContactDetails;
     }*/

    /**
     * DI setter for Spring.
	 *
     * This is a cute one: Dependent on the context, Spring is using the correct resource implementation: Which can be a
     * file system context or a Servlet context.
     *
     * @param xsdLocation
     * @throws GeonetworkServiceException
     */
    public void setXsdLocation(Resource xsdLocation) throws GeonetworkServiceException {
        try {
            this.xsdLocation = xsdLocation.getFile().getPath();

            ServletContextResource scr = (ServletContextResource) xsdLocation;
            this.xsdLocationUrl = scr.getPathWithinContext();
            if (this.xsdLocationUrl.startsWith("/")) this.xsdLocationUrl = this.xsdLocationUrl.substring(1);

        } catch (IOException e) {
            throw new GeonetworkServiceException(e);
        }
    }

    public void setXsdEbRimLocation(Resource xsdLocation) throws GeonetworkServiceException {
        try {
            this.xsdEbRimLocation = xsdLocation.getFile().getPath();

            ServletContextResource scr = (ServletContextResource) xsdLocation;
            this.xsdEbRimLocationUrl = scr.getPathWithinContext();
            if (this.xsdEbRimLocationUrl.startsWith("/")) this.xsdEbRimLocationUrl = this.xsdEbRimLocationUrl.substring(1);

 		} catch (IOException e) {
			throw new GeonetworkServiceException(e);
		}
	}

    public void setXsdBasicPackageLocation(Resource xsdLocation) throws GeonetworkServiceException {
		try {
			this.xsdBasicPackageLocation = xsdLocation.getFile().getPath();

            ServletContextResource scr = (ServletContextResource) xsdLocation;
            this.xsdBasicPackageLocationUrl = scr.getPathWithinContext();
            if (this.xsdBasicPackageLocationUrl.startsWith("/")) this.xsdBasicPackageLocationUrl = this.xsdBasicPackageLocationUrl.substring(1);

		} catch (IOException e) {
			throw new GeonetworkServiceException(e);
		}
	}

    public void setXsdCswLocation(Resource xsdCswLocation) throws GeonetworkServiceException {
        try {
            this.xsdCswLocation = xsdCswLocation.getFile().getPath();

            ServletContextResource scr = (ServletContextResource) xsdCswLocation;
            this.xsdCswLocationUrl = scr.getPathWithinContext();
            if (this.xsdCswLocationUrl.startsWith("/")) this.xsdCswLocationUrl = this.xsdCswLocationUrl.substring(1);

		} catch (IOException e) {
			throw new GeonetworkServiceException(e);
		}
	}

    public void setTargetNamespaces(Map<String,String> targetNamespaces) {
        this.targetNamespaces = targetNamespaces;
    }

    public void setGaapClient(GaapServicesClient gaapClient) {
        this.gaapClient = gaapClient;
    }
}
