//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================

package org.geonetwork.search.ebrim.filter;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalIdentifier;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.*;
import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.ExternalIdentifierFactory;
import org.geonetwork.domain.ebrim.test.utilities.association.AssociationFactory;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype.FormatSlot;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.*;
import org.geonetwork.domain.csw202.discovery.Query;
import org.geonetwork.domain.csw202.discovery.QueryConstraint;
import org.geonetwork.domain.filter110.sort.SortBy;
import org.geonetwork.domain.filter110.sort.SortProperty;
import org.geonetwork.domain.filter110.sort.SortOrder;
import org.geonetwork.domain.filter110.expression.PropertyName;
import org.geonetwork.domain.xsd.QName;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.geonetwork.search.ebrim.EbrimGenericSearchDao;
import org.geonetwork.search.ebrim.SearchEngine;
import org.geonetwork.search.ebrim.query.QueryResult;
import org.geonetwork.search.ebrim.query.QueryParameters;
import org.geonetwork.search.testutils.FileUtil;
import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.dao.facade.RegistryObjectListStoreFacade;
import org.geonetwork.gaap.client.GaapServicesClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Tests for FilterSearchEngine class
 *
 * @author Jose
 */
public class FilterSearchEngineTest extends AbstractDaoTest {
    EbrimGenericSearchDao ebRimGenericSearchDao;
    CoreDao coreDao;
    GaapServicesClient gaapClient;
    RegistryObjectListStoreFacade registryObjectListStoreFacade;

    public void setCoreDao(CoreDao coreDao) {
        this.coreDao = coreDao;
    }

    public void setEbrimGenericSearchDao(EbrimGenericSearchDao ebRimGenericSearchDao) {
        this.ebRimGenericSearchDao = ebRimGenericSearchDao;
    }

    public void setGaapClient(GaapServicesClient gaapClient) {
        this.gaapClient = gaapClient;
    }

    public void setRegistryObjectListStoreFacade(RegistryObjectListStoreFacade registryObjectListStoreFacade) {
        this.registryObjectListStoreFacade = registryObjectListStoreFacade;
    }

    private FilterSearchEngine searchEngine;

    public void onSetUp() throws Exception {
        super.onSetUp();

        searchEngine = new FilterSearchEngine();
        searchEngine.setCoreDao(coreDao);
        searchEngine.setSearchDao(ebRimGenericSearchDao);
        searchEngine.setGaapClient(gaapClient); 
    }

    public void testNothing() {
        assertTrue(true);
    }

    public void testQueryById() {
        try {
            // Test ebRIM registry empty
            List<String> ids = new ArrayList<String>();
            List<RegistryObject> registryObjects = searchEngine.queryById(ids);
            assertEquals(0, registryObjects.size());

            // Create test data
            RegistryObject testRegistryObject1 = RegistryObjectFactory.create();
            testRegistryObject1.setId(new URN("1"));
            coreDao.saveRegistryObject(testRegistryObject1);

            RegistryObject testRegistryObject2 = RegistryObjectFactory.create();
            testRegistryObject2.setId(new URN("2"));
            coreDao.saveRegistryObject(testRegistryObject2);

            ExternalIdentifier testExternalIdentifier = ExternalIdentifierFactory.create();
            testExternalIdentifier.setValue(new LongName("long_name_external"));
            testExternalIdentifier.setRegistryObject(new URI(testRegistryObject2.getId().toString()));
            coreDao.saveExternalIdentifier(testExternalIdentifier);

            // Search for one RegistryObject identifier
            ids = new ArrayList<String>();
            ids.add(testRegistryObject1.getId().getValue());
            registryObjects = searchEngine.queryById(ids);
            assertEquals(1, registryObjects.size());
            assertEquals(testRegistryObject1.getId(), registryObjects.get(0).getId());

            // Search for two RegistryObject identifier
            ids = new ArrayList<String>();
            ids.add(testRegistryObject1.getId().getValue());
            ids.add(testRegistryObject2.getId().getValue());
            registryObjects = searchEngine.queryById(ids);
            assertEquals(2, registryObjects.size());

            // Search for one ExternalIdentifier value
            ids = new ArrayList<String>();
            ids.add(testExternalIdentifier.getValue().getValue());
            registryObjects = searchEngine.queryById(ids);
            assertEquals(1, registryObjects.size());
            assertEquals(testRegistryObject2.getId(), registryObjects.get(0).getId());

            // Search for a RegistryObject identifier and an ExternalIdentifier value
            ids = new ArrayList<String>();
            ids.add(testRegistryObject1.getId().getValue());
            ids.add(testExternalIdentifier.getValue().getValue());
            ids.add("non_existent_value");
            registryObjects = searchEngine.queryById(ids);
            assertEquals(2, registryObjects.size());

        } catch (SearchEngineException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testQuery() {
        try {
            // Create test data
            createTestQueryData();

            startNewTransaction();

            String filter = FileUtil.convertStreamToString(
                    new FileInputStream(new File("src/test/resources/search/FilterTitle.xml")));

            Query query = new Query();
            QueryConstraint qc = new QueryConstraint();
            qc.setFilter(filter);
            query.setConstraint(qc);

            QueryParameters params = new QueryParameters();
            params.setMaxRecords(10);
            params.setStartPosition(1);

            QueryResult queryResult = searchEngine.query(query, params);

            assertNotNull(queryResult.getData());
            assertEquals(1, queryResult.getData().size());

            RegistryObject resultRegistryObject = queryResult.getData().get(0);
            LocalizedString lsResult = (LocalizedString) resultRegistryObject.getName().getLocalizedStrings().toArray()[0];
            assertEquals("Africa", lsResult.getValue());


            filter = FileUtil.convertStreamToString(
                    new FileInputStream(new File("src/test/resources/search/MixedFilter.xml")));

            qc = new QueryConstraint();
            qc.setFilter(filter);
            query.setConstraint(qc);

            params = new QueryParameters();
            params.setMaxRecords(10);
            params.setStartPosition(1);

            List<QName> typeNames = new ArrayList<QName>();
            QName qn = new QName();
            qn.setValue("rim:RegistryObject");
            typeNames.add(qn);
            query.setTypeNames(typeNames);

            queryResult = searchEngine.query(query, params);

            assertNotNull(queryResult.getData());
            assertEquals(1, queryResult.getData().size());

        } catch (SearchEngineException e) {
            e.printStackTrace();
            fail();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
            fail();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void xtestBBoxQuery() {
        try {
            // Create test data
            //createTestQueryData();
            //startNewTransaction();

            // Included envelope
            String filter = FileUtil.convertStreamToString(
                    new FileInputStream(new File("src/test/resources/search/FilterBBox.xml")));

            Query query = new Query();
            QueryConstraint qc = new QueryConstraint();
            qc.setFilter(filter);
            query.setConstraint(qc);

            QueryParameters params = new QueryParameters();
            params.setMaxRecords(10);
            params.setStartPosition(1);

            QueryResult queryResult = searchEngine.query(query, params);
            assertNotNull(queryResult.getData());
            assertEquals(1, queryResult.getData().size());

            RegistryObject resultRegistryObject = queryResult.getData().get(0);
            LocalizedString lsResult = (LocalizedString) resultRegistryObject.getName().getLocalizedStrings().toArray()[0];
            assertEquals("Africa", lsResult.getValue());

            // Overlaps envelope
            filter = FileUtil.convertStreamToString(
                    new FileInputStream(new File("src/test/resources/search/FilterBBox2.xml")));
            query.getConstraint().setFilter(filter);

            queryResult = searchEngine.query(query, params);

            assertNotNull(queryResult.getData());
            assertEquals(1, queryResult.getData().size());

            resultRegistryObject = queryResult.getData().get(0);
            lsResult = (LocalizedString) resultRegistryObject.getName().getLocalizedStrings().toArray()[0];
            assertEquals("Africa", lsResult.getValue());


            // Non overlaps/included envelope
            filter = FileUtil.convertStreamToString(
                    new FileInputStream(new File("src/test/resources/search/FilterBBox3.xml")));
            query.getConstraint().setFilter(filter);

            queryResult = searchEngine.query(query, params);

            assertNotNull(queryResult.getData());
            assertEquals(0, queryResult.getData().size());

        } catch (SearchEngineException e) {
            e.printStackTrace();
            fail();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
            fail();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    private void createTestQueryData() throws Exception{
        RegistryObjectList rol = new RegistryObjectList();
        rol.setIso19139Id("aaa-dddd-eeee-ffff");

        // Test RegistryObject 1
        RegistryObject testRegistryObject1 = RegistryObjectFactory.create();
        testRegistryObject1.setId(new URN("1"));
        InternationalString description = new InternationalString();
        Set<LocalizedString> descriptionLs = new HashSet<LocalizedString>();
        LocalizedString ds = new LocalizedString();
        ds.setValue("Oceania");
        descriptionLs.add(ds);
        description.setLocalizedStrings(descriptionLs);
        testRegistryObject1.setDescription(description);

        Association a = AssociationFactory.create();
        a.setAssociationType(new URI("OperatesOn"));
		URI sourceUri = new URI(testRegistryObject1.getId().getValue());
		a.setSourceObject(sourceUri);
		Set<Association> associationsSet = new HashSet<Association>();
		associationsSet.add(a);
		testRegistryObject1.setAssociationsSet(associationsSet);

        // Format slot
        FormatSlot fs = new FormatSlot();
        fs.setName(new LongName("formatname"));
        testRegistryObject1.getSlots().add(fs);

        // Envelope slot
        Slot envelopeSlot = new Slot();
        envelopeSlot.setSlotType(new LongName("urn:ogc:def:dataType:ISO-19107:GM_Envelope"));
        envelopeSlot.setName(new LongName("http://purl.org/dc/terms/spatial"));

        ValueList envelopeValues = new ValueList();
        AnyValue envelopValue = new AnyValue();
        Envelope envelope = new Envelope();
        envelope.setLowerCorner(new LowerCorner("10.0 10.0"));
        envelope.setUpperCorner(new UpperCorner("20.0 20.0"));
        envelopValue.setValue(envelope);

        List<AnyValue> anyValuesList = new ArrayList<AnyValue>();
        anyValuesList.add(envelopValue);
        envelopeValues.setValues(anyValuesList);
        envelopeSlot.setBasicExtensionValueList(envelopeValues);

        testRegistryObject1.getSlots().add(envelopeSlot);


        InternationalString name = new InternationalString();

        Set<LocalizedString> setLocalizedStrings = new HashSet<LocalizedString>();
        LocalizedString ls = new LocalizedString();
        Language lang = new Language();
        lang.setValue("es");

        ls.setLang(lang);
        ls.setCharset("UTF-8");
        ls.setValue("Africa");
        setLocalizedStrings.add(ls);

        name.setLocalizedStrings(setLocalizedStrings);
        testRegistryObject1.setName(name);

        ExternalIdentifier testExternalIdentifier = ExternalIdentifierFactory.create();
        testExternalIdentifier.setValue(new LongName("long_name"));
        testExternalIdentifier.setRegistryObject(new URI("fdfsdfds"));

        Set<ExternalIdentifier> eiSet = new HashSet<ExternalIdentifier>();
        eiSet.add(testExternalIdentifier);

        testRegistryObject1.setExternalIdentifiers(eiSet);


        rol.add(testRegistryObject1);


        //coreDao.saveRegistryObject(testRegistryObject1);

        // Test RegistryObject 2
        RegistryObject testRegistryObject2 = RegistryObjectFactory.create();

        testRegistryObject1.setId(new URN("1"));

        a = AssociationFactory.create();
        a.setAssociationType(new URI("OperatesOn"));
        sourceUri = new URI(testRegistryObject1.getId().getValue());
        a.setSourceObject(sourceUri);
        associationsSet = new HashSet<Association>();
        associationsSet.add(a);
        testRegistryObject2.setAssociationsSet(associationsSet);


        name = new InternationalString();
        setLocalizedStrings = new HashSet<LocalizedString>();
        ls = new LocalizedString();
        lang = new Language();
        lang.setValue("es");

        ls.setLang(lang);
        ls.setCharset("UTF-8");
        ls.setValue("Oceania");
        setLocalizedStrings.add(ls);
        name.setLocalizedStrings(setLocalizedStrings);
        testRegistryObject2.setName(name);

        //coreDao.saveRegistryObject(testRegistryObject2);

        rol.add(testRegistryObject2);

        registryObjectListStoreFacade.save(rol);
        // Commit transaction, if not is done Hibernate Search doesn't find nothing
        setComplete();
        endTransaction();
    }
}