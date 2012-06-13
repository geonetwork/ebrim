package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.csw202.discovery.ElementSetName;
import org.geonetwork.domain.csw202.discovery.GetRecords;
import org.geonetwork.domain.csw202.discovery.Query;
import org.geonetwork.domain.csw202.discovery.QueryConstraint;
import org.geonetwork.domain.csw202.discovery.ResultType;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery.StoredQuery;
import org.geonetwork.domain.ebrim.test.utilities.basicextensionpackage.StoredQueryFactory;
import org.geonetwork.domain.ebrim.test.utilities.event.AdhocQueryFactory;
import org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery;
import org.geonetwork.domain.xsd.QName;

import java.util.List;
import java.util.ArrayList;

public class GetRecordsFactory {
	
	public synchronized static GetRecords createCQL() {
        GetRecords r = new GetRecords();

        List<String> namespace = new ArrayList<String>();
        namespace.add("tns=urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0");
        namespace.add("csw=http://www.opengis.net/cat/csw/2.0.2");
        namespace.add("gml=http://www.opengis.net/gml");
        namespace.add("xsi=http://www.w3.org/2001/XMLSchema-instance");
        r.setNamespace(namespace);

        r.setRequestID("1");
        r.setService("CSW");
        r.setVersion("2.0.2");
        r.setResultType(ResultType.results);
        Query query = new Query();
        ElementSetName elementSetName = new ElementSetName();
        elementSetName.setElementSet(ElementSet.summary);
        query.setElementSetName(elementSetName);

        List<QName> listQNames = new ArrayList<QName>();
        QName qName = new QName();
        qName.setValue("tns:ExtrinsicObject");
        listQNames.add(qName);
        query.setTypeNames(listQNames);

        QueryConstraint c = new QueryConstraint();
        c.setVersion("2.0.0");
        c.setCQLText("xxxx");
        query.setConstraint(c);
        r.setQuery(query);
        return r;
	}
	
	public synchronized static GetRecords createAdhoc() {
        GetRecords r = new GetRecords();
        return r;
	}
	
	public synchronized static GetRecords createAdhocQuery() {
        GetRecords r = new GetRecords();
        r.setService("CSW");
        r.setVersion("2.0.2");
        r.setMaxRecords(10);
        r.setStartPosition(1);
        r.setResultType(ResultType.results);
        r.setOutputFormat("application/xml");

        AdhocQuery adhocQuery = AdhocQueryFactory.create2();;
        
        r.setAdhocQuery(adhocQuery);
        
        return r;
	}
	
	
	public synchronized static GetRecords createFilter() {
        GetRecords r = new GetRecords();
        r.setRequestID("1");
        r.setService("CSW");
        r.setVersion("2.0.2");
        r.setResultType(ResultType.results);
        Query query = new Query();
        ElementSetName elementSetName = new ElementSetName();
        elementSetName.setElementSet(ElementSet.summary);
        query.setElementSetName(elementSetName);
        QueryConstraint c = new QueryConstraint();

        List<QName> listQNames = new ArrayList<QName>();
        QName qName = new QName();
        qName.setValue("tns:ExtrinsicObject");
        listQNames.add(qName);
        query.setTypeNames(listQNames);

        c.setVersion("2.0.0");
        String f="<ogc:Filter>\n" +
        "                <ogc:And>\n" +
        "                    <ogc:PropertyIsLessThan>\n" +
        "                        <ogc:PropertyName>DEPTH</ogc:PropertyName>\n" +
        "                        <ogc:Literal>30</ogc:Literal>\n" +
        "                    </ogc:PropertyIsLessThan>\n" +
        "                    <ogc:Not>\n" +
        "                        <ogc:Disjoint>\n" +
        "                            <ogc:PropertyName>Geometry</ogc:PropertyName>\n" +
        "                            <gml:Envelope srsName=\"http://www.opengis.net/gml/srs/epsg.xml#63266405\">\n" +
        "                                <gml:lowerCorner>13.0983 31.5899</gml:lowerCorner>\n" +
        "                                <gml:upperCorner>35.5472 42.8143</gml:upperCorner>\n" +
        "                            </gml:Envelope>\n" +
        "                        </ogc:Disjoint>\n" +
        "                    </ogc:Not>\n" +
        "                </ogc:And>\n" +
        "            </ogc:Filter>";
        c.setFilter(f);
        query.setConstraint(c);
        r.setQuery(query);
        return r;
	}
	
    public synchronized static GetRecords create() {
        GetRecords r = new GetRecords();

        r.setOutputFormat("text/xml");        
        r.setResultType(ResultType.results);

        Query query = new Query();
        ElementSetName elementSetName = new ElementSetName();
        elementSetName.setElementSet(ElementSet.summary);
        query.setElementSetName(elementSetName);

        QueryConstraint queryContraint = new QueryConstraint();
        queryContraint.setVersion("2.0.0");
        
        String filter="<ogc:Filter>\n" +
                "                <And>\n" +
                "                    <PropertyIsLessThan>\n" +
                "                        <PropertyName>DEPTH</PropertyName>\n" +
                "                        <Literal>30</Literal>\n" +
                "                    </PropertyIsLessThan>\n" +
                "                    <Not>\n" +
                "                        <Disjoint>\n" +
                "                            <PropertyName>Geometry</PropertyName>\n" +
                "                            <gml:Envelope srsName=\"http://www.opengis.net/gml/srs/epsg.xml#63266405\">\n" +
                "                                <gml:lowerCorner>13.0983 31.5899</gml:lowerCorner>\n" +
                "                                <gml:upperCorner>35.5472 42.8143</gml:upperCorner>\n" +
                "                            </gml:Envelope>\n" +
                "                        </Disjoint>\n" +
                "                    </Not>\n" +
                "                </And>\n" +
                "            </ogc:Filter>";
        queryContraint.setFilter(filter);

        query.setConstraint(queryContraint);

        r.setQuery(query);
        r.setResultType(ResultType.results);
        r.setMaxRecords(new Integer(10));
        r.setRequestID("1");
        r.setStartPosition(new Integer(1));

        return r;
    }
}
