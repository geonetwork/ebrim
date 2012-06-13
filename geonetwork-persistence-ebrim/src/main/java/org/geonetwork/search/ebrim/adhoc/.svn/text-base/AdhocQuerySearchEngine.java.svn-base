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
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery;
import org.geonetwork.search.ebrim.query.QueryParameters;
import org.geonetwork.search.ebrim.query.QueryResult;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.geonetwork.search.ebrim.EbrimGenericSearchDao;
import org.geonetwork.dao.ebrim.informationmodel.EventDao;
import org.geonetwork.dao.ebrim.informationmodel.ServiceDao;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;

/**
 * Search engine using Adhoc queries
 *
 * @author Jose
 *
 */
public class AdhocQuerySearchEngine {
    private CoreDao coreDao;
    private ServiceDao serviceDao;
    private EventDao eventDao;
    private EbrimGenericSearchDao searchDao;

    // Spring DAO Injection
    public void setCoreDao(CoreDao coreDao) {
        this.coreDao = coreDao;
    }

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public void setServiceDao(ServiceDao serviceDao) {
            this.serviceDao = serviceDao;
    }

    public void setEbrimGenericSearchDao(EbrimGenericSearchDao searchDao) {
            this.searchDao = searchDao;
    }

    /**
     * Jose, I changed the interface for this to receive a StoredQuery, not an AdhocQuery.
     * The StoreQuery is the query request and must use the AdhocQueries that are persisted.
     * The StoredQuery id is the id of the stored AdhocQuery.
     * Any Slots in the StoredQuery represent arguments (parameters) for the stored query.
     * @param query
     * @param params
     * @return
     * @throws SearchEngineException
     */
    @SuppressWarnings("unchecked")
	public QueryResult query(AdhocQuery query, QueryParameters params) throws SearchEngineException {
        try {
            // Get the query to execute
            String queryId = query.getId().getValue();
            AdhocQuerySearch search = getAdhocQuerySearch(queryId);

            if (search == null) throw new SearchEngineException("StoredQuery with id: " + queryId + " not found");

            // Get parameters
            Set<Slot> queryFields = query.getSlots();

            Map<String, String> queryFieldsMap = new HashMap<String,String>();
            if (queryFields != null) {
                for(Slot field: queryFields) {
                    String fieldName = field.getName().toString();
                    String fieldValue = field.getValueList().getValues().get(0).getValue();
                    queryFieldsMap.put(fieldName, fieldValue);
                }
            }
            
            List<RegistryObject> data = (List<RegistryObject>) search.query(queryFieldsMap);

            return processData(data, params);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SearchEngineException(ex);
        }
	}

    /**
     * Process data returned by  AdhocQuerySearch
     *
     * @param data      Data returned by AdhocQuerySearch
     * @param params    Parameters of query
     * @return          QueryResults with data and info of the search
     */
    private QueryResult processData(List<RegistryObject> data, QueryParameters params) {
        QueryResult queryResult = new QueryResult();

        // Set number of records matched
        queryResult.setNumberOfRecordsMatched(data.size());

        // Set number of records returned and data to return
        int maxRecords = params.getMaxRecords();
        int startPosition = params.getStartPosition();

        if ((startPosition +  maxRecords) >= data.size()) {
            queryResult.setNumberOfRecordsReturned(data.size()-startPosition+1);
            queryResult.setData(data.subList(startPosition-1, data.size()));
            queryResult.setNextRecord(0);

        } else {
            queryResult.setNumberOfRecordsReturned(maxRecords);
            queryResult.setData(data.subList(startPosition-1, maxRecords));
            queryResult.setNextRecord(startPosition+maxRecords+1);
        }

        // TODO: Sort data


        return queryResult;
    }


    /**
     * Gets the AdhocQuerySearch that has identifer value
     *
     * @param identifier    Identifier of AdhocQuerySearch
     * @return              AdhocQuerySearch if identifier is valid, null otherwise
     */
    private AdhocQuerySearch getAdhocQuerySearch(String identifier) {
        AdhocQuerySearch query = null;

        if (FindObjectsByClassificationNodeQuery.getIdentifier().equals(identifier)) {
            FindObjectsByClassificationNodeQuery q = new FindObjectsByClassificationNodeQuery();
            q.setEbrimGenericSearchDao(searchDao);
            query = q;

        } else if (FindObjectsByClassificationPathQuery.getIdentifier().equals(identifier)) {
            FindObjectsByClassificationPathQuery q = new FindObjectsByClassificationPathQuery();
            q.setEbrimGenericSearchDao(searchDao);
            query = q;

        }  else if (FindServicesQuery.getIdentifier().equals(identifier)) {
            FindServicesQuery q = new FindServicesQuery();
            q.setServiceDao(serviceDao);
            query = q;

        } else if (ListExtensionPackagesQuery.getIdentifier().equals(identifier)) {
            ListExtensionPackagesQuery q = new ListExtensionPackagesQuery();
            q.setCoreDao(coreDao);
            query = q;

        } else if (ShowStoredQueriesQuery.getIdentifier().equals(identifier)) {
            ShowStoredQueriesQuery q = new ShowStoredQueriesQuery();
            q.setEventDao(eventDao);
            query = q;
        }

        return query;
    }
}