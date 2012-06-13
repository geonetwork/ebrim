package org.geonetwork.search.ebrim.stub;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.csw202.discovery.Query;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import org.geonetwork.search.ebrim.SearchEngine;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.geonetwork.search.ebrim.query.QueryResult;
import org.geonetwork.search.ebrim.query.QueryParameters;

/**
 * 
 * Stub to simulate non-existing search engines.
 * 
 * TODO move to test package
 * 
 * @author heikki doeleman
 *
 */
public class StubSearchEngine extends SearchEngine {


	@Override
	public List<RegistryObject> queryById(List<String> ids) throws SearchEngineException {
		List<RegistryObject> resultList = new ArrayList<RegistryObject>();
		RegistryObject o = RegistryObjectFactory.create();
		String requestedId = ids.get(0);
		if(requestedId != null) {
			o.setId(new URN(requestedId));
			resultList.add(o);
			return resultList;
		}
		else {
			return null;
		}
	}

    /**
     *  Returns an empty list result
     *
     * @param params Parameters of the query
     * @return Empty list  
     * @throws SearchEngineException
     */
    public QueryResult query(Query query, QueryParameters params) throws SearchEngineException {
        return new QueryResult(); 
    }
}
