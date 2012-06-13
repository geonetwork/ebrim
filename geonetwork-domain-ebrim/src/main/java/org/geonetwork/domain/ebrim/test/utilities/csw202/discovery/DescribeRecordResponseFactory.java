package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import org.geonetwork.domain.csw202.discovery.DescribeRecordResponse;
import org.geonetwork.domain.csw202.discovery.SchemaComponent;

import java.util.List;
import java.util.ArrayList;

public class DescribeRecordResponseFactory {
    public synchronized static DescribeRecordResponse create() {
        DescribeRecordResponse dr = new DescribeRecordResponse();
        SchemaComponent sc = new SchemaComponent();
        sc.setTargetNamespace("http://purl.org/dc/elements/1.1/");
        sc.setSchemaLanguage("XMLSCHEMA");
        sc.setSchema("<xsd:element xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" name=\"Record\" type=\"csw:RecordType\" substitutionGroup=\"csw:AbstractRecord\"/>");

        List<SchemaComponent> lsc = new ArrayList<SchemaComponent>();
        lsc.add(sc);
        dr.setSchemaComponent(lsc);
        
        return dr;
    }
}
