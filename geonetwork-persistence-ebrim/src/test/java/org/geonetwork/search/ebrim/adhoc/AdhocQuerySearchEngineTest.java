package org.geonetwork.search.ebrim.adhoc;

import org.geonetwork.dao.ebrim.AbstractCommitDaoTest;
import org.geonetwork.dao.ebrim.informationmodel.EventDao;
import org.geonetwork.dao.ebrim.informationmodel.ServiceDao;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryPackage;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;
import org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery;
import org.geonetwork.domain.ebrim.informationmodel.event.QueryExpression;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryPackageFactory;
import org.geonetwork.domain.ebrim.test.utilities.classification.ClassificationNodeFactory;
import org.geonetwork.domain.ebrim.test.utilities.event.AdhocQueryFactory;
import org.geonetwork.domain.ebrim.test.utilities.event.QueryExpressionFactory;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery.StoredQuery;
import org.geonetwork.search.ebrim.EbrimGenericSearchDao;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.geonetwork.search.ebrim.query.QueryParameters;
import org.geonetwork.search.ebrim.query.QueryResult;
import org.junit.Test;

import java.util.*;

/**
 * Tests for AdhocQuerySearchEngine
 *
 * @author Jose
 */
// TODO: Add more testing
public class AdhocQuerySearchEngineTest extends AbstractCommitDaoTest {
    AdhocQuerySearchEngine adhocQuerySearchEngine;
        
    EbrimGenericSearchDao ebrimGenericSearchDao;
    EventDao eventDao;
    ServiceDao serviceDao;

    public void setEbrimGenericSearchDao(EbrimGenericSearchDao ebrimGenericSearchDao) {
        this.ebrimGenericSearchDao = ebrimGenericSearchDao;
    }
    
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();

        adhocQuerySearchEngine = new AdhocQuerySearchEngine();
        adhocQuerySearchEngine.setCoreDao(coreDao);
        adhocQuerySearchEngine.setEbrimGenericSearchDao(ebrimGenericSearchDao);
        adhocQuerySearchEngine.setEventDao(eventDao);
        adhocQuerySearchEngine.setServiceDao(serviceDao);
    }

    @Test
    public void testSearchFindObjectsByClassificationNodeQuery() {
        AdhocQuery storedQuery;
        QueryParameters queryParams;
                
        try {
            // Create test data
            RegistryObject registryObject = RegistryObjectFactory.create();
            registryObject.setObjectType(new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject"));
            coreDao.saveRegistryObject(registryObject);


            // StoredQuery
            storedQuery = new AdhocQuery();
            storedQuery.setId(new URN(FindObjectsByClassificationNodeQuery.getIdentifier()));
            storedQuery.setHome(new URI("storedQueryHome"));

            Slot slot = new Slot();
            slot.setName(new LongName("node"));
            ValueList valueList = new ValueList();
            valueList.add(new LongName("http://*"));
            slot.setValueList(valueList);

            Set<Slot> slots = new HashSet<Slot>();
            slots.add(slot);
            storedQuery.setSlots(slots);

            // QueryParams
            queryParams = new QueryParameters();
            queryParams.setMaxRecords(100);
            queryParams.setStartPosition(1);

            QueryResult queryResults = adhocQuerySearchEngine.query(storedQuery, queryParams);

            assertEquals(0,queryResults.getNextRecord());
            assertEquals(1,queryResults.getData().size());

        } catch (SearchEngineException e) {
            e.printStackTrace();
            fail();
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testSearchFindObjectsByClassificationPathQuery() {
        AdhocQuery storedQuery;
        QueryParameters queryParams;

        try {
            ClassificationNode registryObject = ClassificationNodeFactory.create();
            registryObject.setObjectType(new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject"));
            registryObject.setPath("/root/path1");
            classificationDao.saveClassificationNode(registryObject);

            // StoredQuery
            storedQuery = new AdhocQuery();
            storedQuery.setId(new URN(FindObjectsByClassificationPathQuery.getIdentifier()));
            storedQuery.setHome(new URI("storedQueryHome"));

            Slot slot = new Slot();
            slot.setName(new LongName("path"));
            ValueList valueList = new ValueList();
            valueList.add(new LongName("/root/path1"));
            slot.setValueList(valueList);

            Set<Slot> slots = new HashSet<Slot>();
            slots.add(slot);
            storedQuery.setSlots(slots);

            // QueryParams
            queryParams = new QueryParameters();
            queryParams.setMaxRecords(100);
            queryParams.setStartPosition(1);

            QueryResult queryResults = adhocQuerySearchEngine.query(storedQuery, queryParams);

            assertEquals(0,queryResults.getNextRecord());
            assertEquals(1,queryResults.getData().size());

        } catch (SearchEngineException e) {
            e.printStackTrace();
            fail();

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testSearchListExtensionPackagesQuery() {
        AdhocQuery storedQuery;
        QueryParameters queryParams;

        try {
            // Create test data
            RegistryPackage regPackage = RegistryPackageFactory.create();
            coreDao.saveRegistryPackage(regPackage);


            // StoredQuery
            storedQuery = new AdhocQuery();
            storedQuery.setId(new URN(ListExtensionPackagesQuery.getIdentifier()));
            storedQuery.setHome(new URI("storedQueryHome"));

            // QueryParams
            queryParams = new QueryParameters();
            queryParams.setMaxRecords(100);
            queryParams.setStartPosition(1);

            QueryResult queryResults = adhocQuerySearchEngine.query(storedQuery, queryParams);

            assertEquals(0,queryResults.getNextRecord());
            assertEquals(1,queryResults.getData().size());

        } catch (SearchEngineException e) {
            e.printStackTrace();
            fail();

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testShowStoredQueriesQuery() {
        AdhocQuery storedQuery;
        QueryParameters queryParams;

        try {
            // Create test data
            AdhocQuery adhocQuery = AdhocQueryFactory.create();
            QueryExpression queryExpression = QueryExpressionFactory.create();
            adhocQuery.setQueryExpression(queryExpression);
            eventDao.saveAdhocQuery(adhocQuery);

            // StoredQuery
            storedQuery = new AdhocQuery();
            storedQuery.setId(new URN(ShowStoredQueriesQuery.getIdentifier()));
            storedQuery.setHome(new URI("storedQueryHome"));

            // QueryParams
            queryParams = new QueryParameters();
            queryParams.setMaxRecords(100);
            queryParams.setStartPosition(1);

            QueryResult queryResults = adhocQuerySearchEngine.query(storedQuery, queryParams);

            assertEquals(0,queryResults.getNextRecord());
            assertEquals(1,queryResults.getData().size());

        } catch (SearchEngineException e) {
            e.printStackTrace();
            fail();

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}