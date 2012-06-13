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

import java.util.List;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.informationmodel.EventDao;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery;
import org.geonetwork.domain.ebrim.informationmodel.event.QueryExpression;
import org.geonetwork.domain.ebrim.test.utilities.event.AdhocQueryFactory;
import org.geonetwork.domain.ebrim.test.utilities.event.QueryExpressionFactory;
import org.junit.Test;

/**
 * Tests for ShowStoredQueriesQuery
 *
 * @author Jose
 */
public class ShowStoredQueriesQueryTest extends AbstractDaoTest {
    EventDao eventDao;
    ShowStoredQueriesQuery showStoredQueriesQuery;

    public void setCoreDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();

        showStoredQueriesQuery = new ShowStoredQueriesQuery();
        showStoredQueriesQuery.setEventDao(this.eventDao);
    }

    @Test
    public void testQuery() {
        try {
            // Test empty results
            List<? extends RegistryObject> retrievedAdhocQueries = showStoredQueriesQuery.query(null);
            assertEquals(0, retrievedAdhocQueries.size());

            // Test non empty results
            AdhocQuery adhocQuery = AdhocQueryFactory.create();
            QueryExpression queryExpression = QueryExpressionFactory.create();
            adhocQuery.setQueryExpression(queryExpression);
            eventDao.saveAdhocQuery(adhocQuery);

            retrievedAdhocQueries = showStoredQueriesQuery.query(null);
            assertEquals(1, retrievedAdhocQueries.size());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}