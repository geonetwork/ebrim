package org.geonetwork.services.ebrim.csw202.validation;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.csw202.discovery.GetRecords;
import org.geonetwork.domain.csw202.discovery.Query;
import org.geonetwork.domain.csw202.discovery.QueryConstraint;
import org.geonetwork.domain.csw202.discovery.ElementSetName;
import org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery;
import org.geonetwork.domain.xsd.QName;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;
import org.junit.Test;

public class GetRecordsValidationTest {

	@Test
	public void testGetRecordsValidation() throws CSW202ServiceException {
		GetRecords request = new GetRecords();
		try {
			new GetRecordsValidation(request);
			fail();
		} catch (CSW202ServiceException e) {
		}
		try {
			//Query q = new Query();
			List<QName> typeNames = new ArrayList<QName>();
			QName qName = new QName();
			qName.setValue("csw:WhatTheFuck");
			typeNames.add(qName);
			//q.setTypeNames(typeNames);
			//request.setQuery(q);
			new GetRecordsValidation(request);
			fail();
		} catch (CSW202ServiceException x) {
			// query is missing
		}

        try {
            request = new GetRecords();
            Query q = new Query();

            QueryConstraint qc = new QueryConstraint();
            qc.setFilter("<ogc:Filter xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                    "\txmlns:ogc=\"http://www.opengis.net/ogc\"\n" +
                    "\txmlns=\"http://www.opengis.net/ogc\"\n" +
                    "\txsi:schemaLocation=\"http://www.opengis.net/ogc filter.xsd\">\n" +
                    "    <ogc:PropertyIsEqualTo>\n" +
                    "        <ogc:PropertyName>title</ogc:PropertyName>\n" +
                    "        <ogc:Literal>africa</ogc:Literal>\n" +
                    "    </ogc:PropertyIsEqualTo>\n" +
                    "</ogc:Filter>");

            q.setConstraint(qc);
            List<String> namespace = new ArrayList<String>();
            namespace.add("wrs=http://www.opengis.net/cat/wrs/1.0");
            request.setNamespace(namespace);

            List<QName> typeNames = new ArrayList<QName>();
			QName qName = new QName();
			qName.setValue("csw:WhatTheFuck");
			typeNames.add(qName);
			q.setTypeNames(typeNames);
			request.setQuery(q);

			new GetRecordsValidation(request);
			fail();
		} catch (CSW202ServiceException e) {
			// "GetRecords request namespace prefix not found";
            e.printStackTrace();
		}

               try {
            request = new GetRecords();
            Query q = new Query();

            QueryConstraint qc = new QueryConstraint();
            qc.setFilter("<ogc:Filter xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                    "\txmlns:ogc=\"http://www.opengis.net/ogc\"\n" +
                    "\txmlns=\"http://www.opengis.net/ogc\"\n" +
                    "\txsi:schemaLocation=\"http://www.opengis.net/ogc filter.xsd\">\n" +
                    "    <ogc:PropertyIsEqualTo>\n" +
                    "        <ogc:PropertyName>title</ogc:PropertyName>\n" +
                    "        <ogc:Literal>africa</ogc:Literal>\n" +
                    "    </ogc:PropertyIsEqualTo>\n" +
                    "</ogc:Filter>");

            ElementSetName elementSetName = new ElementSetName();
            List<String> typeNamesESN = new ArrayList<String>();
			typeNamesESN.add("csw:WhatTheFuck");
            elementSetName.setTypeNames(typeNamesESN);
            q.setElementSetName(elementSetName);
                   
            q.setConstraint(qc);
            List<String> namespace = new ArrayList<String>();
            namespace.add("wrs=http://www.opengis.net/cat/wrs/1.0");
            request.setNamespace(namespace);

            List<QName> typeNames = new ArrayList<QName>();
			QName qName = new QName();
			qName.setValue("csw:WhatTheFuck");
			typeNames.add(qName);
			q.setTypeNames(typeNames);
			request.setQuery(q);

			new GetRecordsValidation(request);
			fail();
		} catch (CSW202ServiceException e) {
			// "GetRecords request namespace prefix not found";
            e.printStackTrace();
		}
	}

}
