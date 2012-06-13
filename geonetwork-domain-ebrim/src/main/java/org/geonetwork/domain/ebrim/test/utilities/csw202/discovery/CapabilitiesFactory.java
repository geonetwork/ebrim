package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.csw202.discovery.Capabilities;
import org.geonetwork.domain.ows100._19115subset.*;
import org.geonetwork.domain.ows100.filtercapabilities.ArithmeticOperator;
import org.geonetwork.domain.ows100.filtercapabilities.ComparisonOperator;
import org.geonetwork.domain.ows100.filtercapabilities.EID;
import org.geonetwork.domain.ows100.filtercapabilities.FID;
import org.geonetwork.domain.ows100.filtercapabilities.FilterCapabilities;
import org.geonetwork.domain.ows100.filtercapabilities.FunctionName;
import org.geonetwork.domain.ows100.filtercapabilities.GeometryOperand;
import org.geonetwork.domain.ows100.filtercapabilities.ID;
import org.geonetwork.domain.ows100.filtercapabilities.IdCapabilities;
import org.geonetwork.domain.ows100.filtercapabilities.LogicalOperator;
import org.geonetwork.domain.ows100.filtercapabilities.ScalarCapabilities;
import org.geonetwork.domain.ows100.filtercapabilities.SimpleArithmetic;
import org.geonetwork.domain.ows100.filtercapabilities.SpatialCapabilities;
import org.geonetwork.domain.ows100.filtercapabilities.SpatialOperator;
import org.geonetwork.domain.ows100.filtercapabilities.SpatialOperatorName;
import org.geonetwork.domain.ows100.operationsmetadata.*;
import org.geonetwork.domain.ows100.serviceidentification.ServiceIdentification;
import org.geonetwork.domain.ows100.serviceprovider.ServiceProvider;

public class CapabilitiesFactory {

    public synchronized static Capabilities create() {
        Capabilities c = new Capabilities();

        c.setVersion("2.0.0");
        c.setUpdateSequence("0");

        c.setServiceIdentification(createServiceIdentification());
        c.setServiceProvider(createServiceProvider());
        c.setOperationsMetadata(createOperationsMetadata());

        c.setFilterCapabilities(createFilterCapabilities());
        
        return c;
    }


    private static ServiceIdentification createServiceIdentification() {
        ServiceIdentification servIdentification = new ServiceIdentification();
        servIdentification.setTitle("Company CSW");
        servIdentification.setAbstrakt("A catalogue service that conforms to the HTTP protocol");
        Keywords keywords = new Keywords();
        List<String> keywordValues = new ArrayList<String>();
        keywordValues.add("CSW");
        keywordValues.add("Company Name");
        keywordValues.add("geospatial");
        keywordValues.add("catalogue");
        keywords.setKeyword(keywordValues);
        servIdentification.setKeywords(keywords);

        servIdentification.setFees("NONE");
        servIdentification.setServiceType("CSW");
        List<String> serviceTypeVersion = new ArrayList<String>();
        serviceTypeVersion.add("2.0.0");
        servIdentification.setServiceTypeVersion(serviceTypeVersion);

        List<String> accessConstraints = new ArrayList<String>();
        accessConstraints.add("NONE");
        servIdentification.setAccessConstraints(accessConstraints);

        return servIdentification;
    }

    private static ServiceProvider createServiceProvider() {
        ServiceProvider servProvider = new ServiceProvider();
        servProvider.setProviderName("Company Name");

        ResponsiblePartySubset servContact = new ResponsiblePartySubset();
        servContact.setIndividualName("Contact Person Name");
        servContact.setPositionName("Staff");

        Contact contactInfo = new Contact();
        Address address = new Address();
        address.setAdministrativeArea("StateName");
        address.setCity("CityName");
        List<String> deliveryPoint = new ArrayList<String>();
        deliveryPoint.add("1 Street Name");
        address.setDeliveryPoint(deliveryPoint);
        address.setCountry("USA");
        List<String> email = new ArrayList<String>();
        email.add("contact.person@company.com");
        address.setElectronicMailAddress(email);
        contactInfo.setAddress(address);

        Telephone phone = new Telephone();
        List<String> phoneList = new ArrayList<String>();
        phoneList.add("33333333");
        phoneList.add("22222222");
        phone.setVoice(phoneList);

        List<String> facsimileList = new ArrayList<String>();
        facsimileList.add("11111111");
        phone.setFacsimile(facsimileList);
       
        contactInfo.setPhone(phone);

        servContact.setContactInfo(contactInfo);
        servProvider.setServiceContact(servContact);

        return servProvider;
    }


    private static OperationsMetadata createOperationsMetadata() {
        OperationsMetadata opMetadata = new OperationsMetadata();

        List<Operation> operations = new ArrayList<Operation>();

        // GetCapabilities
        Operation op1 = new Operation();
        op1.setName("GetCapabilities");
        List<DCP> DCPList = new ArrayList<DCP>();
        DCP dcp1 = new DCP();
        List<RequestMethod> reqMethods = new ArrayList<RequestMethod>();
        RequestMethod reqMethod = new Get();
        reqMethod.setValue("http://localhost:8888/SpatialWS-SpatialWS-context-root/cswservlet");
        reqMethods.add(reqMethod);

        reqMethod = new Post();
        reqMethod.setValue("http://localhost:8888/SpatialWS-SpatialWS-context-root/SpatialWSSoapHttpPort");
        reqMethods.add(reqMethod);

        dcp1.setValue(reqMethods);

        DCPList.add(dcp1);

        op1.setDCP(DCPList);

        operations.add(op1);


        // DescribeRecord
        Operation op2 = new Operation();
        op2.setName("DescribeRecord");
        DCPList = new ArrayList<DCP>();
        dcp1 = new DCP();
        reqMethods = new ArrayList<RequestMethod>();
        reqMethod = new Post();
        reqMethod.setValue("http://localhost:8888/SpatialWS-SpatialWS-context-root/SpatialWSSoapHttpPort");
        reqMethods.add(reqMethod);
        dcp1.setValue(reqMethods);

        DCPList.add(dcp1);
        op2.setDCP(DCPList);

        List<Domain> parameters = new ArrayList<Domain>();
        Domain parameter = new Domain();
        parameter.setName("schemaLanguage");
        List<String> parameterValues = new ArrayList<String>();
        parameterValues.add("XMLSCHEMA");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        parameter = new Domain();
        parameter.setName("typeName");
        parameterValues = new ArrayList<String>();
        parameterValues.add("ns0:SampleRecord");
        parameterValues.add("ns1:Record");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        parameter = new Domain();
        parameter.setName("outputFormat");
        parameterValues = new ArrayList<String>();
        parameterValues.add("text/xml");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        op2.setParameter(parameters);

        operations.add(op2);


        // GetRecords
        Operation op3 = new Operation();
        op3.setName("GetRecords");
        DCPList = new ArrayList<DCP>();
        dcp1 = new DCP();
        reqMethods = new ArrayList<RequestMethod>();
        reqMethod = new Post();
        reqMethod.setValue("http://localhost:8888/SpatialWS-SpatialWS-context-root/SpatialWSSoapHttpPort");
        reqMethods.add(reqMethod);
        dcp1.setValue(reqMethods);

        DCPList.add(dcp1);
        op3.setDCP(DCPList);

        parameters = new ArrayList<Domain>();

        parameter = new Domain();
        parameter.setName("typeName");
        parameterValues = new ArrayList<String>();
        parameterValues.add("ns0:SampleRecord");
        parameterValues.add("ns1:Record");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        parameter = new Domain();
        parameter.setName("outputFormat");
        parameterValues = new ArrayList<String>();
        parameterValues.add("text/xml");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        parameter = new Domain();
        parameter.setName("outputSchema");
        parameterValues = new ArrayList<String>();
        parameterValues.add("OGCCORE");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        parameter = new Domain();
        parameter.setName("resultType");
        parameterValues = new ArrayList<String>();
        parameterValues.add("hits");
        parameterValues.add("results");
        parameterValues.add("validate");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        parameter = new Domain();
        parameter.setName("ElementSetName");
        parameterValues = new ArrayList<String>();
        parameterValues.add("brief");
        parameterValues.add("summary");
        parameterValues.add("full");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        parameter = new Domain();
        parameter.setName("CONSTRAINTLANGUAGE");
        parameterValues = new ArrayList<String>();
        parameterValues.add("Filter");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        op3.setParameter(parameters);

        operations.add(op3);


        // GetRecordById
       Operation op4 = new Operation();
        op4.setName("GetRecordById");
        DCPList = new ArrayList<DCP>();
        dcp1 = new DCP();
        reqMethods = new ArrayList<RequestMethod>();
        reqMethod = new Post();
        reqMethod.setValue("http://localhost:8888/SpatialWS-SpatialWS-context-root/SpatialWSSoapHttpPort");
        reqMethods.add(reqMethod);
        dcp1.setValue(reqMethods);

        DCPList.add(dcp1);
        op4.setDCP(DCPList);

        parameters = new ArrayList<Domain>();



        parameter = new Domain();
        parameter.setName("ElementSetName");
        parameterValues = new ArrayList<String>();
        parameterValues.add("brief");
        parameterValues.add("summary");
        parameterValues.add("full");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        op4.setParameter(parameters);

        operations.add(op4);

        // GetDomain
        Operation op5 = new Operation();
        op5.setName("GetDomain");
        DCPList = new ArrayList<DCP>();
        dcp1 = new DCP();
        reqMethods = new ArrayList<RequestMethod>();
        reqMethod = new Post();
        reqMethod.setValue("http://localhost:8888/SpatialWS-SpatialWS-context-root/SpatialWSSoapHttpPort");
        reqMethods.add(reqMethod);
        dcp1.setValue(reqMethods);

        DCPList.add(dcp1);
        op5.setDCP(DCPList);

        parameters = new ArrayList<Domain>();
        parameter = new Domain();
        parameter.setName("ParameterName");
        parameterValues = new ArrayList<String>();
        parameterValues.add("GetRecords.resultType");
        parameterValues.add("GetRecords.outputFormat");
        parameterValues.add("GetRecords.outputRecType");
        parameterValues.add("GetRecords.typeNames");
        parameterValues.add("GetRecords.ElementSetName");
        parameterValues.add("GetRecords.ElementName");
        parameterValues.add("GetRecords.CONSTRAINTLANGUAGE");
        parameterValues.add("GetRecordById.ElementSetName");
        parameterValues.add("DescribeRecord.typeName");
        parameterValues.add("DescribeRecord.schemaLanguage");
        parameter.setValue(parameterValues);

        parameters.add(parameter);

        op5.setParameter(parameters);

        operations.add(op5);

        // Transaction
        Operation op6 = new Operation();
        op6.setName("Transaction");
        DCPList = new ArrayList<DCP>();
        dcp1 = new DCP();
        reqMethods = new ArrayList<RequestMethod>();
        reqMethod = new Post();
        reqMethod.setValue("http://localhost:8888/SpatialWS-SpatialWS-context-root/SpatialWSSoapHttpPort");
        reqMethods.add(reqMethod);
        dcp1.setValue(reqMethods);

        DCPList.add(dcp1);
        op6.setDCP(DCPList);

        operations.add(op6);

        opMetadata.setOperation(operations);

        
        // Operation metadata parameters
        List<Domain> opMetatadaParameters = new ArrayList<Domain>();
        parameter = new Domain();
        parameter.setName("service");
        parameterValues = new ArrayList<String>();
        parameterValues.add("CSW");
        parameter.setValue(parameterValues);

        opMetatadaParameters.add(parameter);

        parameter = new Domain();
        parameter.setName("version");
        parameterValues = new ArrayList<String>();
        parameterValues.add("2.0.0");
        parameter.setValue(parameterValues);

        opMetatadaParameters.add(parameter);

        opMetadata.setParameter(opMetatadaParameters);

        ExtendedCapabilities extendedCapabilities = new ExtendedCapabilities();
        extendedCapabilities.setWsdlLocation("wsdllocation");
        opMetadata.setExtendedCapabilities(extendedCapabilities);

        return opMetadata;
    }


    private static FilterCapabilities createFilterCapabilities() {
        FilterCapabilities filterCapabilities = new FilterCapabilities();

        SpatialCapabilities spatialCapabilities = new SpatialCapabilities();

        List<GeometryOperand> go = new ArrayList<GeometryOperand>();
        go.add(GeometryOperand.gml_Envelope);

        spatialCapabilities.setGeometryOperands(go);

        List<SpatialOperator> so = new ArrayList<SpatialOperator>();
        SpatialOperator op1 = new SpatialOperator();
        op1.setName(SpatialOperatorName.BBOX);
        so.add(op1);
        spatialCapabilities.setSpatialOperators(so);

        filterCapabilities.setSpatialCapabilities(spatialCapabilities);

        ScalarCapabilities scalarCapabilities = new ScalarCapabilities();

        List<ComparisonOperator> co = new ArrayList<ComparisonOperator>();
        co.add(ComparisonOperator.LessThan);
        co.add(ComparisonOperator.GreaterThan);
        co.add(ComparisonOperator.LessThanEqualTo);
        co.add(ComparisonOperator.GreaterThanEqualTo);
        co.add(ComparisonOperator.EqualTo);
        co.add(ComparisonOperator.NotEqualTo);
        co.add(ComparisonOperator.Like);
        co.add(ComparisonOperator.Between);
        co.add(ComparisonOperator.NullCheck);


        scalarCapabilities.setComparisonOperators(co);

        scalarCapabilities.setLogicalOperators(new ArrayList<LogicalOperator>());
        List<ArithmeticOperator> ao = new ArrayList<ArithmeticOperator>();
        ArithmeticOperator ao1 = new ArithmeticOperator();

        ao1.setSimpleArithmetic(new SimpleArithmetic());
        
        List<FunctionName> fn = new ArrayList<FunctionName>();
        FunctionName fn1 = new FunctionName();
        fn1.setName("MIN");
        fn1.setNArgs("1");
        fn.add(fn1);

        fn1 = new FunctionName();
        fn1.setName("MAX");
        fn1.setNArgs("1");
        fn.add(fn1);

        fn1 = new FunctionName();
        fn1.setName("SIN");
        fn1.setNArgs("1");
        fn.add(fn1);

        fn1 = new FunctionName();
        fn1.setName("COS");
        fn1.setNArgs("1");
        fn.add(fn1);

        fn1 = new FunctionName();
        fn1.setName("TAN");
        fn1.setNArgs("1");
        fn.add(fn1);

        ao1.setFunctions(fn);

        ao.add(ao1);
        scalarCapabilities.setArithmeticsOperators(ao);
        filterCapabilities.setScalarCapabilities(scalarCapabilities);

        IdCapabilities idCapabilities = new IdCapabilities();
        List<ID> ids = new ArrayList<ID>();
        ids.add(new EID());
        ids.add(new FID());
        idCapabilities.setIds(ids);

        filterCapabilities.setIdCapabilities(idCapabilities);
        
        return filterCapabilities;
    }

}
