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
package org.geonetwork.search.ebrim.adhoc;

import org.geonetwork.dao.ebrim.AbstractCommitDaoTest;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.test.utilities.classification.ClassificationNodeFactory;
import org.geonetwork.search.ebrim.EbrimGenericSearchDao;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Tests for FindObjectsByClassificationPathQuery
 *
 * @author Jose
 */
public class FindObjectsByClassificationPathQueryTest extends AbstractCommitDaoTest {
    EbrimGenericSearchDao ebrimGenericSearchDao;
    FindObjectsByClassificationPathQuery findObjectsByClassificationPathQuery;

    public void setEbrimGenericSearchDao(EbrimGenericSearchDao ebrimGenericSearchDao) {
        this.ebrimGenericSearchDao = ebrimGenericSearchDao;
    }

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();

        findObjectsByClassificationPathQuery = new FindObjectsByClassificationPathQuery();
        findObjectsByClassificationPathQuery.setEbrimGenericSearchDao(ebrimGenericSearchDao);
    }

    @Test
    public void testQueryEmptyPathParameter() {
        try {
            Map<String, String> parameters = new HashMap<String, String>();
            findObjectsByClassificationPathQuery.query(parameters);

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
    public void testQueryNoValidSyntaxPathParameter() {
        try {
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("path", "sdfsfsd");
            findObjectsByClassificationPathQuery.query(parameters);

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
            parameters.put("path", "/root/otherpath");

            // Test empty results
            List<? extends RegistryObject> retrievedRegistryObjects = findObjectsByClassificationPathQuery.query(parameters);
            assertEquals(0, retrievedRegistryObjects.size());

            // Test non empty results
            ClassificationNode registryObject = ClassificationNodeFactory.create();
            registryObject.setObjectType(new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject"));
            registryObject.setPath("/root/path1");
            classificationDao.saveClassificationNode(registryObject);

            parameters = new HashMap<String, String>();
            parameters.put("path", "/root/path1");

            retrievedRegistryObjects = findObjectsByClassificationPathQuery.query(parameters);
            assertEquals(1, retrievedRegistryObjects.size());

            // Test regular expression
            // TODO: Check
            /*parameters = new HashMap<String, String>();
            parameters.put("path", "/root/p.th1");

            retrievedRegistryObjects = findObjectsByClassificationPathQuery.query(parameters);
            assertEquals(1, retrievedRegistryObjects.size()); */

       } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}