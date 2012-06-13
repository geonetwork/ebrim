package org.geonetwork.search.ebrim.adhoc;

import org.geonetwork.dao.ebrim.AbstractCommitDaoTest;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import org.geonetwork.domain.ebrim.test.utilities.classification.ClassificationFactory;
import org.geonetwork.search.ebrim.EbrimGenericSearchDao;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

/**
 * Tests for FindObjectsByClassificationNodeQuery
 *
 * @author Jose
 */
public class FindObjectsByClassificationNodeQueryTest extends AbstractCommitDaoTest {
    EbrimGenericSearchDao ebrimGenericSearchDao;
    FindObjectsByClassificationNodeQuery findObjectsByClassificationNodeQuery;

    public void setEbrimGenericSearchDao(EbrimGenericSearchDao ebrimGenericSearchDao) {
        this.ebrimGenericSearchDao = ebrimGenericSearchDao;
    }

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();

        findObjectsByClassificationNodeQuery = new FindObjectsByClassificationNodeQuery();
        findObjectsByClassificationNodeQuery.setEbrimGenericSearchDao(ebrimGenericSearchDao);
    }

    @Test
    public void testQueryEmptyNodeParameter() {
        try {
            Map<String, String> parameters = new HashMap<String, String>();
            findObjectsByClassificationNodeQuery.query(parameters);

            // Fail, SearchEngineException must be launched
            fail();

        } catch (SearchEngineException e) {
            assertTrue(true);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }


        try {
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("node", "");
            findObjectsByClassificationNodeQuery.query(parameters);

            // Fail, SearchEngineException must be launched
            fail();
        } catch (SearchEngineException e) {
            assertTrue(true);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void testQuery() {
        try {
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("node", "sdsadas");

            // Test empty results
            List<? extends RegistryObject> retrievedRegistryObjects = findObjectsByClassificationNodeQuery.query(parameters);
            assertEquals(0, retrievedRegistryObjects.size());

            // Test non empty results
            RegistryObject registryObject = RegistryObjectFactory.create();
            registryObject.setObjectType(new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject"));

            Set<Classification> classifications = registryObject.getClassifications();
            Classification c = ClassificationFactory.create();
            classifications.clear();
            classifications.add(c);
            coreDao.saveRegistryObject(registryObject);

            Classification[] classificationsArray = classifications.toArray(new Classification[classifications.size()]);

            parameters = new HashMap<String, String>();
            parameters.put("node", classificationsArray[0].getClassificationNode().getValue());

            retrievedRegistryObjects = findObjectsByClassificationNodeQuery.query(parameters);
            assertEquals(1, retrievedRegistryObjects.size());

            // Test regular expression
            parameters = new HashMap<String, String>();
            parameters.put("node", "http:*");

            retrievedRegistryObjects = findObjectsByClassificationNodeQuery.query(parameters);
            assertEquals(1, retrievedRegistryObjects.size());

            // Test regular expression (non existent value)
            parameters = new HashMap<String, String>();
            parameters.put("node", "h?cx{3}zc*");

            retrievedRegistryObjects = findObjectsByClassificationNodeQuery.query(parameters);
            assertEquals(0, retrievedRegistryObjects.size());

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}