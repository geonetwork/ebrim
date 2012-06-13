package org.geonetwork.webservices.ebrim.csw202;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Enumeration;
import java.lang.Exception;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.geonetwork.domain.csw202.discovery.Capabilities;
import org.geonetwork.domain.csw202.discovery.DescribeRecord;
import org.geonetwork.domain.csw202.discovery.DescribeRecordResponse;
import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.csw202.discovery.ElementSetName;
import org.geonetwork.domain.csw202.discovery.GetCapabilities;
import org.geonetwork.domain.csw202.discovery.GetRecordById;
import org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse;
import org.geonetwork.domain.csw202.discovery.GetRecords;
import org.geonetwork.domain.csw202.discovery.GetRecordsResponse;
import org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse;
import org.geonetwork.domain.csw202.discovery.Query;
import org.geonetwork.domain.csw202.discovery.QueryConstraint;
import org.geonetwork.domain.csw202.discovery.ResultType;
import org.geonetwork.domain.csw202.exception.*;
import org.geonetwork.domain.filter110.expression.PropertyName;
import org.geonetwork.domain.filter110.sort.SortBy;
import org.geonetwork.domain.filter110.sort.SortOrder;
import org.geonetwork.domain.filter110.sort.SortProperty;
import org.geonetwork.domain.ows100.common.MimeType;
import org.geonetwork.domain.ows100.getcapabilities.AcceptFormats;
import org.geonetwork.domain.ows100.getcapabilities.AcceptVersions;
import org.geonetwork.domain.ows100.getcapabilities.Sections;
import org.geonetwork.domain.xsd.QName;
import org.geonetwork.services.ebrim.csw202.CSW202Service;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;
import org.geonetwork.services.ebrim.csw202.CSW202ExceptionReportGenerator;
import org.geonetwork.services.ebrim.csw202.CSW202Constants;
import org.geonetwork.utils.string.StringUtil;
import org.geonetwork.webservices.util.RequestUtil;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.JiBXException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author heikki doeleman
 */
public class CswEbrimGETService extends HttpServlet {

    private static Logger log = Logger.getLogger(CswEbrimGETService.class);


    /**
     *
     */
    private static final long serialVersionUID = -7530539986421781568L;
    public static final String REQUEST = "request";
    public static final String GETCAPABILITIES = "GetCapabilities";
    //	public static final String SERVICE = "CSW-ebRIM";
    public static final String VERSION = "1.0.0";
    public static final String ACCEPT_FORMATS = "AcceptFormats";
    public static final String SECTIONS = "sections";
    public static final String SERVICE = "service";
    public static final String GETRECORDS = "GetRecords";
    public static final String GETRECORDBYID = "GetRecordById";
    public static final String GETREPOSITORYITEM = "GetRepositoryItem";
    public static final String RESULT_TYPE = "resultType";
    public static final String REQUEST_ID = "requestId";
    public static final String OUTPUT_FORMAT = "outputFormat";
    public static final String OUTPUT_SCHEMA = "outputSchema";
    public static final String START_POSITION = "startPosition";
    public static final String MAX_RECORDS = "maxRecords";
    public static final String DESCRIBERECORD = "DescribeRecord";
    public static final String TYPE_NAME_GET_RECORDS = "typeNames";
    public static final String TYPE_NAME_DESCRIBE_RECORD = "TypeName";
    public static final String NAMESPACE = "NAMESPACE";
    public static final String ELEMENT_SET_NAME = "ElementSetName";
    public static final String ELEMENT_NAME = "ElementName";
    public static final String CONSTRAINT_LANGUAGE = "CONSTRAINTLANGUAGE";
    public static final String CONSTRAINT = "Constraint";
    public static final String CQL_TEXT = "CQL_TEXT";
    public static final String FILTER = "FILTER";
    public static final String SORT_BY = "SortBy";
    public static final String ID = "Id";
    public static final String ACCEPT_VERSIONS = "AcceptVersion";
    public static final String AUTH_TOKEN = "authToken";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestedOperation = RequestUtil.getParameter(request, REQUEST);

        if (requestedOperation.equalsIgnoreCase(GETCAPABILITIES)) {
            handleGetCapabilities(request, response);
        } else if (requestedOperation.equalsIgnoreCase(GETRECORDS)) {
            handleGetRecords(request, response);
        } else if (requestedOperation.equalsIgnoreCase(DESCRIBERECORD)) {
            handleDescribeRecord(request, response);
        } else if (requestedOperation.equalsIgnoreCase(GETRECORDBYID)) {
            handleGetRecordById(request, response);
        } else if (requestedOperation.equalsIgnoreCase(GETREPOSITORYITEM)) {
            handleGetRepositoryItem(request, response);
        }
        // unknown operation
        else {

            CSW202ServiceException cswException =
                    CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_NOTSUPPORTED, requestedOperation);

            outputError(cswException.getFaultMessage(), response);
        }
    }

    private void handleGetRepositoryItem(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String id = RequestUtil.getParameter(request, ID);
        ServletContext servletContext = this.getServletConfig().getServletContext();
        WebApplicationContext waco = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        CSW202Service csw202Service = (CSW202Service) waco.getBean("csw202Service");
        try {
            GetRepositoryItemResponse getRepositoryItemResponse = csw202Service.getRepositoryItem(id);
            if (StringUtil.isEmpty(getRepositoryItemResponse.getResponse())) {
                log.debug("Did not find repository item for id: " + id);
                
                String exceptionText = "Did not find repository item for id: " + id;
                throw CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_NOTFOUND, exceptionText);

            } else {
                // set up JiBX marshalling context
                IBindingFactory bfact = BindingDirectory.getFactory(GetRepositoryItemResponse.class);
                IMarshallingContext marshallingContext = bfact.createMarshallingContext();
                // marshal to servlet response outputstream
                response.setContentType("text/xml");
                marshallingContext.setIndent(3);

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                Writer out = new BufferedWriter(new OutputStreamWriter(outputStream));
                marshallingContext.setOutput(out);

                marshallingContext.marshalDocument(getRepositoryItemResponse, "UTF-8", null);
                // Process marshalling to remove GetRepositoryItemResponse and return only content
                String result = outputStream.toString();
                result = result.replaceAll("<tns:GetRepositoryItemResponse [^>]*>", "");
                result = result.replaceAll("</tns:GetRepositoryItemResponse>", "");

                PrintWriter writer = response.getWriter();
                writer.write(result);
            }
        }
        catch (CSW202ServiceException e) {
            outputError(e.getFaultMessage(), response);
        }
        catch (JiBXException e) {
            CSW202ServiceException cswException =
                    CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST, e.getMessage());

            outputError(cswException.getFaultMessage(), response);
        }
        catch (IOException e) {
            CSW202ServiceException cswException =
                    CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST, e.getMessage());

            outputError(cswException.getFaultMessage(), response);
        }
    }

    private void handleGetCapabilities(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GetCapabilities getCapabilities = new GetCapabilities();

        //
        // service
        //
        // OGC 07-110r2: The value of the service parameter shall be the service type code
        // "CSW-ebRIM".
        String service = RequestUtil.getParameter(request, SERVICE);

        getCapabilities.setService(service);
        //
        // version
        //
        // OGC 07-110r2: The value of the version parameter shall be "1.0.0".
        AcceptVersions acceptVersions = new AcceptVersions();
        String acceptVersionsParameter = RequestUtil.getParameter(request, ACCEPT_VERSIONS);
        // acceptVersions provided and not empty
        if ((acceptVersionsParameter != null) &&
                (!acceptVersionsParameter.trim().equals(""))) {
            String[] acceptVersionsArray = acceptVersionsParameter.split(",");
            List<String> acceptVersionsList = Arrays.asList(acceptVersionsArray);
            acceptVersions.setVersion(acceptVersionsList);

            getCapabilities.setAcceptVersions(acceptVersions);
        } else {
            List<String> acceptVersionsList = new ArrayList<String>();
            acceptVersionsList.add(VERSION);
            acceptVersions.setVersion(acceptVersionsList);
            getCapabilities.setAcceptVersions(acceptVersions);
        }

        //
        // sections
        //
        // OGC 07-110r2: The sections parameter may be used to request a subset of the complete
        // capabilities
        // document; the value is a comma-separated list of section names. The set of recognized
        // section
        // names shall be as specified in Table 7 of OGC 05-008 and Table 58 of OGC 07-006r1,
        // with the exception of "Contents".
        // Table 7 of OGC 05-008:
        // ServiceIdentification
        // ServiceProvider
        // OperationsMetadata
        // Contents
        // Table 58 of OGC 07-006r1:
        // Filter_Capabilities
        Sections sections = new Sections();
        String sectionsParameter = RequestUtil.getParameter(request, SECTIONS);
        // Sections parameter provided
        if (sectionsParameter != null) {
            // Check if almost one section is provided
            if (!sectionsParameter.trim().equals("")) {
                String[] sectionsArray = sectionsParameter.split(",");
                List<String> sectionsList = Arrays.asList(sectionsArray);
                sections.setSection(sectionsList);
            }

            getCapabilities.setSections(sections);
        }
        //
        // updatesequence
        //
        // not supported, server must return latest version
        // getCapabilities.setUpdateSequence(updateSequence);
        //
        // acceptformats
        //
        // not supported, always use text/xml
        //
        List<String> acceptHeaders = getAcceptHeaderValues(request);

        String acceptFormatsParameter = RequestUtil.getParameter(request, ACCEPT_FORMATS);
        AcceptFormats acceptFormats = new AcceptFormats();
        List<MimeType> outputFormat = new ArrayList<MimeType>();

        // Process AcceptFormats parameter
        if (acceptFormatsParameter != null) {
            if (!acceptFormatsParameter.trim().equals("")) {
                String[] acceptFormatsArray = acceptFormatsParameter.split(",");
                List<String> acceptFormatsList = Arrays.asList(acceptFormatsArray);

                boolean checkAcceptHeaders = !acceptHeaders.isEmpty();
                for (String format : acceptFormatsList) {
                    MimeType textXML = new MimeType();
                    if (checkAcceptHeaders) {
                        if (acceptHeaders.contains(format) ||
                            (acceptHeaders.contains("*/*") ||
                            (acceptHeaders.contains("*")))) {

                            textXML.setValue(format);
                            outputFormat.add(textXML);
                        }
                    } else {
                        textXML.setValue(format);
                        outputFormat.add(textXML);
                    }
                }

                // Accept header and AcceptFormats parameter disagree: Raise an exception
                if ((checkAcceptHeaders) && (outputFormat.isEmpty())) {
                    CSW202ServiceException cswException =
                            CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST, "Non valid accept format");

                    outputError(cswException.getFaultMessage(), response);
                    return;
                }
            }

            // If not provided AcceptFormats parameter, use Accept header
        } else if (!acceptHeaders.isEmpty()) {
            for (String format : acceptHeaders) {
                MimeType textXML = new MimeType();
                if ((format.equals("*/*")) || ((format.equals("*")))) format = CSW202Constants.outputFormatapplicationXml;
                textXML.setValue(format);
                outputFormat.add(textXML);
            }

            // If not provided none of them, use default outputFormat
        } else {
            MimeType textXML = new MimeType();
            textXML.setValue(CSW202Constants.outputFormatapplicationXml);
            outputFormat.add(textXML);
        }

        acceptFormats.setOutputFormat(outputFormat);
        getCapabilities.setAcceptFormats(acceptFormats);


        ServletContext servletContext = this.getServletConfig().getServletContext();
        WebApplicationContext waco = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        CSW202Service csw202Service = (CSW202Service) waco.getBean("csw202Service");

        try {
            Capabilities capabilities = csw202Service.getCapabilities(getCapabilities);
            // set up JiBX marshalling context
            IBindingFactory bfact = BindingDirectory.getFactory(Capabilities.class);
            IMarshallingContext marshallingContext = bfact.createMarshallingContext();
            // marshal to servlet response outputstream
            response.setContentType(CSW202Constants.outputFormatapplicationXml);


            //Writer writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            marshallingContext.setIndent(3);
            marshallingContext.setOutput(response.getWriter());
            marshallingContext.marshalDocument(capabilities, "UTF-8", null);
        }
        catch (CSW202ServiceException x) {
            outputError(x.getFaultMessage(), response);
        }
        catch (JiBXException x) {
            CSW202ServiceException cswException =
                    CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST, x.getMessage());

            outputError(cswException.getFaultMessage(), response);
        }
    }

    /**
     * OGC 07-110r2: The ResponseHandler and DistributedSearch parameters shall be ignored.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void handleGetRecords(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        GetRecords getRecords = new GetRecords();

        //
        // authToken: custom extension for security validation
        //
        String authToken = RequestUtil.getParameter(request, AUTH_TOKEN);
        getRecords.setAuthToken(authToken);

        //
        // namespace
        //
        // OGC 07-006r1: The NAMESPACE parameter is included in the KVP encoding to allow clients to bind any namespace
        // prefixes
        // that might be used for qualified names specified in other parameters.
        String namespaceParameter = RequestUtil.getParameter(request, NAMESPACE);
        if (!StringUtil.isEmpty(namespaceParameter)) {
            String[] namespaces = namespaceParameter.split(",");
            List<String> resultNamespacesList = new ArrayList<String>();
            List<String> namespacesList = Arrays.asList(namespaces);
            // the part 'xmlns(' is stripped, as is the closing bracket
            for (String namespace : namespacesList) {
                if (namespace.startsWith("xmlns(")) {
                    namespace = namespace.substring("xmlns(".length());
                }
                if (namespace.endsWith(")")) {
                    namespace = namespace.substring(0, namespace.length() - 1);
                }
                resultNamespacesList.add(namespace);
            }
            getRecords.setNamespace(resultNamespacesList);
        }

        //
        // resultType
        //
        // OGC 07-006r1: CodeList with allowed values: "hits", "results" or "validate"
        String resultTypeParameter = RequestUtil.getParameter(request, RESULT_TYPE);
        if (!StringUtil.isEmpty(resultTypeParameter)) {
            ResultType resultType = ResultType.valueOf(resultTypeParameter);
            getRecords.setResultType(resultType);
        }
        //
        // requestId
        //
        // OGC 07-006r1: Include when client chooses to assign requestId
        String requestIDParameter = RequestUtil.getParameter(request, REQUEST_ID);
        getRecords.setRequestID(requestIDParameter);
        //
        // outputFormat
        //
        // OGC 07-006r1: Value is Mime type
        // The only value that is required to be supported is application/xml. Other supported
        // values may include
        // text/html and text/plain
        String outputFormatParameter = RequestUtil.getParameter(request, OUTPUT_FORMAT);
        getRecords.setOutputFormat(outputFormatParameter);
        //
        // outputSchema
        //
        // OGC 07-006r1: Any URI..
        String outputSchemaParameter = RequestUtil.getParameter(request, OUTPUT_SCHEMA);
        getRecords.setOutputSchema(outputSchemaParameter);
        //
        // startPosition
        //
        // OGC 07-006r1: Non-Zero Positive Integer. Default value is 1.
        Integer startposition = new Integer(1);
        String startPositionParameter = RequestUtil.getParameter(request, START_POSITION);
        if (startPositionParameter != null) {
            startposition = new Integer(startPositionParameter);
        }
        getRecords.setStartPosition(startposition);
        //
        // maxRecords
        //
        // OGC 07-006r1: Positive Integer. Default values is 10.
        Integer maxrecords = new Integer(10);
        String maxRecordsParameter = RequestUtil.getParameter(request, MAX_RECORDS);
        if (maxRecordsParameter != null) {
            maxrecords = new Integer(maxRecordsParameter);
        }
        getRecords.setMaxRecords(maxrecords);

        //
        // Query parameters
        //
        Query query = new Query();

        //
        // typeNames
        //
        // OGC 07-006r1 : List of Character String, comma separated. Unordered List of object types
        // implicated in the query.
        String typeNamesParameter = RequestUtil.getParameter(request, TYPE_NAME_GET_RECORDS);
        if (!StringUtil.isEmpty(typeNamesParameter)) {
            String[] typeNames = typeNamesParameter.split(",");
            List<String> typeNamesList = Arrays.asList(typeNames);
            List<QName> qtypeNamesList = new ArrayList<QName>();
            for (String typeName : typeNamesList) {
                QName qtypeName = new QName();
                qtypeName.setValue(typeName);
                qtypeNamesList.add(qtypeName);
            }
            query.setTypeNames(qtypeNamesList);
        }

        //
        // elementSetName
        //
        // OGC 07-006r1 : List of Character String. Zero or one (Mutually exclusive with
        // ElementName).
        String elementSetNameParameter = RequestUtil.getParameter(request, ELEMENT_SET_NAME);
        if (!StringUtil.isEmpty(elementSetNameParameter)) {
            ElementSetName elementSetName = new ElementSetName();
            elementSetName.setElementSet(ElementSet.valueOf(elementSetNameParameter));
            query.setElementSetName(elementSetName);
        }

        //
        // elementName
        //
        // OGC 07-006r1 : List of Character String. Zero or more (Mutually exclusive with
        // ElementSetName).
        String elementNameParameter = RequestUtil.getParameter(request, ELEMENT_NAME);
        if (!StringUtil.isEmpty(elementNameParameter)) {
            String[] elementNames = elementNameParameter.split(",");
            List<String> elementNameList = Arrays.asList(elementNames);
            query.setElementName(elementNameList);
        }

        //
        // CONSTRAINTLANGUAGE
        //
        // OGC 07-006r1 : CodeList with allowed values: CQL_TEXT or FILTER. Include when Constraint
        // included.
        String constraintLanguageParameter = RequestUtil.getParameter(request, CONSTRAINT_LANGUAGE);
        QueryConstraint queryConstraint = new QueryConstraint();
        //
        // Constraint
        //
        // OGC 07-006r1 : Predicate expression specified in the language indicated by the
        // CONSTRAINTLANGUAGE parameter
        String constraintParameter = RequestUtil.getParameter(request, CONSTRAINT);
        if (!StringUtil.isEmpty(constraintLanguageParameter)) {
            if (constraintLanguageParameter.equalsIgnoreCase(CQL_TEXT)) {
                queryConstraint.setCQLText(constraintParameter);
            } else if (constraintLanguageParameter.equalsIgnoreCase(FILTER)) {
                queryConstraint.setFilter(constraintParameter);
            }
            query.setConstraint(queryConstraint);
        }

        //
        // SortBy
        //
        // OGC 07-006r1 : List of Character String, comma separated.
        // Ordered list of names of metadata elements to use for sorting the response.
        // Format of each list item is metadata_element_name:A indicating an ascending sort or
        // metadata_ element_name:D indicating descending sort.
        // Default action is to present the records in the order in which they are retrieved.
        String sortByParameter = RequestUtil.getParameter(request, SORT_BY);
        if (!StringUtil.isEmpty(sortByParameter)) {
            String[] split = sortByParameter.split(",");
            SortBy sortBy = new SortBy();
            List<SortProperty> sortPropertyList = new ArrayList<SortProperty>();
            for (String sortBy$ : split) {
                String[] splet = sortBy$.split(":");
                SortProperty sortProperty = new SortProperty();
                PropertyName propertyName = new PropertyName();
                propertyName.setValue(splet[0]);
                sortProperty.setPropertyName(propertyName);
                sortProperty.setSortOrder(SortOrder.valueOf(splet[1]));
                sortPropertyList.add(sortProperty);
            }
            sortBy.setSortPropertyList(sortPropertyList);
            query.setSortBy(sortBy);
        }

        //
        // DistributedSearch
        //
        // OGC 07-110r2: The ResponseHandler and DistributedSearch parameters shall be ignored.

        //
        // hopCount
        //
        // OGC 07-006r1 : Include only if DistributedSearch parameter is included. Default value is
        // 2
        // OGC 07-110r2: The ResponseHandler and DistributedSearch parameters shall be ignored.

        //
        // ResponseHandler
        //
        // OGC 07-110r2: The ResponseHandler and DistributedSearch parameters shall be ignored.

        getRecords.setQuery(query);

        ServletContext servletContext = this.getServletConfig().getServletContext();
        WebApplicationContext waco = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        CSW202Service csw202Service = (CSW202Service) waco.getBean("csw202Service");

        try {
            GetRecordsResponse getRecordsResponse = csw202Service.getRecords(getRecords);
            // set up JiBX marshalling context
            IBindingFactory bfact = BindingDirectory.getFactory(GetRecordsResponse.class);
            IMarshallingContext marshallingContext = bfact.createMarshallingContext();
            // marshal to servlet response outputstream
            response.setContentType("text/html");
            Writer writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            marshallingContext.setIndent(3);
            marshallingContext.setOutput(writer);
            marshallingContext.marshalDocument(getRecordsResponse, "UTF-8", null);
        } catch (CSW202ServiceException x) {
            outputError(x.getFaultMessage(), response);
        } catch (JiBXException x) {
            CSW202ServiceException cswException =
                    CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST, x.getMessage());

            outputError(cswException.getFaultMessage(), response);
        }

    }

    private void handleDescribeRecord(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DescribeRecord describeRecord = new DescribeRecord();
        //
        // namespace
        //
        // OGC 07-006r1: If the DescribeRecord request is XML encoded, then
        // namespaces shall be declared according to the conventions of XML. If
        // the DescribeRecord request is KVP encoded, then the namespaces
        // referenced shall be declared using the NAMESPACE parameter.
        // (heikki: that's about namespaces for typenames).
        // List of Character String, comma separated. Used to specify
        // namespace(s) and their prefix(es). Format is
        // xmlns([prefix=]namespace-url).
        // If prefix is not specified, then this is the default namespace.
        // Include declarations for each namespace used in a TypeName.
        String namespaceParameter = RequestUtil.getParameter(request, NAMESPACE);
        if (namespaceParameter != null) {
            String[] namespaces = namespaceParameter.split(",");
            List<String> resultNamespacesList = new ArrayList<String>();
            List<String> namespacesList = Arrays.asList(namespaces);
            // the part 'xmlns(' is stripped, as is the closing bracket
            for (String namespace : namespacesList) {
                if (namespace.startsWith("xmlns(")) {
                    namespace = namespace.substring("xmlns(".length());
                }
                if (namespace.endsWith(")")) {
                    namespace = namespace.substring(0, namespace.length() - 1);
                }
                resultNamespacesList.add(namespace);
            }
            describeRecord.setNamespace(resultNamespacesList);
        }

        //
        // typeName
        //
        // OGC 07-006r1: List of Character String, comma separated.
        // One or more qualified type names to be described.
        // Default action is to describe all types known to server.
        String typeNamesParameter = RequestUtil.getParameter(request, TYPE_NAME_DESCRIBE_RECORD);
        if (typeNamesParameter != null) {
            String[] typeNames = typeNamesParameter.split(",");
            List<String> typeNamesList = Arrays.asList(typeNames);
            describeRecord.setTypeName(typeNamesList);
        }

        //
        // outputFormat
        //
        // OGC 07-006r1: A MIME type indicating the format that the output document should have.
        // Default value is application/xml.
        //
        // Ignored, only application/xml is used.
        // describeRecord.setOutputFormat(outputFormat);

        //
        // schemaLanguage
        //
        // OGC 07-006r1: Default value is XMLSCHEMA.
        // The schemaLanguage parameter is used to specify the schema language
        // that should be used to describe the specified types. The default
        // value is XMLSCHEMA, which indicates that the XML-Schema, schema
        // description language shall be used. Other schemas languages are
        // possible as long as the required schemaLanguage values are declared
        // in the Capabilities document.

        // We ignore this, only XML SCHEMA is supported.
        // describeRecord.setSchemaLanguage(schemaLanguage);

        ServletContext servletContext = this.getServletConfig().getServletContext();
        WebApplicationContext waco = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        CSW202Service csw202Service = (CSW202Service) waco.getBean("csw202Service");

        try {
            DescribeRecordResponse describeRecordResponse = csw202Service.describeRecord(describeRecord);
            // set up JiBX marshalling context
            IBindingFactory bfact = BindingDirectory.getFactory(DescribeRecordResponse.class);
            IMarshallingContext marshallingContext = bfact.createMarshallingContext();
            // marshal to servlet response outputstream
            response.setContentType("application/xml");
            Writer writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            marshallingContext.setIndent(3);
            marshallingContext.setOutput(writer);
            marshallingContext.marshalDocument(describeRecordResponse, "UTF-8", null);

        } catch (CSW202ServiceException e) {
            outputError(e.getFaultMessage(), response);

        } catch (JiBXException e) {
            CSW202ServiceException cswException =
                    CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST, e.getMessage());

            outputError(cswException.getFaultMessage(), response);
        }
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void handleGetRecordById(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        GetRecordById getRecordById = new GetRecordById();

        //
        // authToken: custom extension for security validation
        //
        String authToken = RequestUtil.getParameter(request, AUTH_TOKEN);
        getRecordById.setAuthToken(authToken);

        //
        // ElementSetName
        //

        /**
         * CodeList with allowed values: "brief", "summary" or "full"
         */
        String elementSetNameParam = RequestUtil.getParameter(request, ELEMENT_SET_NAME);
        if (!StringUtil.isEmpty(elementSetNameParam)) {
            ElementSetName elementSetName = new ElementSetName();
            elementSetName.setElementSet(ElementSet.valueOf(elementSetNameParam));
            getRecordById.setElementSetName(elementSetName);
        }
        //
        // Id
        //
        /**
         * The Id parameter is a comma-separated list of record identifiers for the records that a CSW shall return to
         * the client.
         */
        String idParam = RequestUtil.getParameter(request, ID);
        if (!StringUtil.isEmpty(idParam)) {
            String[] ids = idParam.split(",");
            List<String> idList = Arrays.asList(ids);
            getRecordById.setId(idList);
        }

        //
        // outputformat
        //
        String outputFormat = RequestUtil.getParameter(request, OUTPUT_FORMAT);
        if (!StringUtil.isEmpty(outputFormat)) {
            getRecordById.setOutputFormat(outputFormat);
        }

        //
        // outputschema
        //
        String outputSchema = RequestUtil.getParameter(request, OUTPUT_SCHEMA);
        if (!StringUtil.isEmpty(outputSchema)) {
            getRecordById.setOutputSchema(outputSchema);
        }

        // service and version as usual are fixed values, we accept anything
        // getRecordById.setService(service);
        // getRecordById.setVersion(version);

        ServletContext servletContext = this.getServletConfig().getServletContext();
        WebApplicationContext waco = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        CSW202Service csw202Service = (CSW202Service) waco.getBean("csw202Service");

        try {
            GetRecordByIdResponse getRecordByIdResponse = csw202Service.getRecordById(getRecordById);
            // set up JiBX marshalling context
            IBindingFactory bfact = BindingDirectory.getFactory(GetRecordByIdResponse.class);
            IMarshallingContext marshallingContext = bfact.createMarshallingContext();
            // marshal to servlet response outputstream
            response.setContentType("application/xml");
            Writer writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            marshallingContext.setIndent(3);
            marshallingContext.setOutput(writer);
            marshallingContext.marshalDocument(getRecordByIdResponse, "UTF-8", null);
        } catch (CSW202ServiceException e) {
            outputError(e.getFaultMessage(), response);
        } catch (JiBXException e) {
            CSW202ServiceException cswException =
                    CSW202ExceptionReportGenerator.generateServiceExceptionBasedOn(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST, e.getMessage());

            outputError(cswException.getFaultMessage(), response);
        }

    }

    private void outputError(ExceptionReport er, HttpServletResponse response) throws ServletException {
        try {          
            setResponseStatus(er, response);

            IBindingFactory bfact = BindingDirectory.getFactory(ExceptionReport.class);
            IMarshallingContext marshallingContext = bfact.createMarshallingContext();

            // marshal to servlet response outputstream
            response.setContentType("application/xml");
            Writer writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            marshallingContext.setIndent(3);
            marshallingContext.setOutput(writer);
            marshallingContext.marshalDocument(er, "UTF-8", null);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private List<String> getAcceptHeaderValues(HttpServletRequest request) {
        List<String> acceptHeaders = new ArrayList<String>();
        for (Enumeration e = request.getHeaders("Accept"); e.hasMoreElements();) {
            String acceptHeadersValues = (String) e.nextElement();
            String acceptHeadersValuesList = acceptHeadersValues.split(";")[0];
            String[] acceptHeadersValuesList2 = acceptHeadersValuesList.split(",");
            for (int i = 0; i < acceptHeadersValuesList2.length; i++) {
                acceptHeaders.add((acceptHeadersValuesList2[i].split(";")[0]).trim());
            }
        }

        return acceptHeaders;
    }

    /**
     * Sets the HTTP response status code
     *
     * @param er
     * @param response
     */
    private void setResponseStatus(ExceptionReport er, HttpServletResponse response) {
        for (org.geonetwork.domain.csw202.exception.Exception ex : er.getExceptionList()) {
            String exceptionCode = ex.getExceptionCode();

            if (exceptionCode.equals(org.geonetwork.domain.csw202.exception.Exception.WRS_INVALIDREQUEST)) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                break;

            } else if ((exceptionCode.equals(org.geonetwork.domain.csw202.exception.Exception.WRS_NOTIMPLEMENTED)) ||
                    (exceptionCode.equals(org.geonetwork.domain.csw202.exception.Exception.WRS_TRANSACTIONFAILED))) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                break;

            } else if (exceptionCode.equals(org.geonetwork.domain.csw202.exception.Exception.WRS_NOTSUPPORTED)) {
                response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
                break;

            } else if (exceptionCode.equals(org.geonetwork.domain.csw202.exception.Exception.WRS_NOTFOUND)) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                break;
            }
        }
    }
}
