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

package org.geonetwork.search.ebrim;

import java.util.List;
import java.util.ArrayList;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.csw202.discovery.Query;
import org.geonetwork.search.ebrim.query.QueryResult;
import org.geonetwork.search.ebrim.query.QueryParameters;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
//import org.geonetwork.gaap.client.GaapServicesClient;
import org.apache.log4j.Logger;

/**
 * Abstract class that must extend specific Search Engines
 * 
 * @author Jose
 */
public abstract class SearchEngine {
    private static Logger log = Logger.getLogger(SearchEngine.class);

	protected CoreDao coreDao;

	protected EbrimGenericSearchDao searchDao;

    //protected GaapServicesClient gaapClient;


	/**
	 * Searches metadata and gets a list of RegistryObjects that complain search criteria. This method must be
	 * implemented by subclasses.
	 * 
	 * @param query
	 *            Query data
     * @param params
	 *            Parameters of the query (startPosition, maxRecords, ...)
	 * @return Data and information about query results
	 * @throws SearchEngineException
	 */
	public abstract QueryResult query(Query query, QueryParameters params) throws SearchEngineException;

	/**
	 * Gets the list of RegistryObjects their id is in id's list parameter
	 * 
	 * @param ids
	 *            List of RegistryObjects identifiers
	 * @return A list of RegistryObjects their id is in id's list parameter
	 * @throws SearchEngineException
	 */
	public List<RegistryObject> queryById(List<String> ids) throws SearchEngineException {
		try {
			List<RegistryObject> data = new ArrayList<RegistryObject>();

			// TODO: Check for duplicated ids to return one instance of RegistryObject
			// Using a Set instead of List for data launches a lazy loading exception!!

			for (String id : ids) {
				// A registry object in the result set shall satisfy any of the following cases:
				// a) have a matching @id attribute value; or
				RegistryObject record = coreDao.findRegistryObjectByUrnId(id);
				if (record != null)
					data.add(record);

				// b) have a child rim:ExternalIdentifier element with a matching @value attribute.
				List<RegistryObject> registryObjectsByExternalIdentifier = coreDao
						.findRegistryObjectByExternalIdentifierValue(id);
				if (registryObjectsByExternalIdentifier != null)
					data.addAll(registryObjectsByExternalIdentifier);
			}
			return data;
		} catch (Exception ex) {
			throw new SearchEngineException(ex);
		}
	}
	
	/**
	 * Searches the registry for a RegistryObject with the specified id. If not found by
	 * URN ID, it goes on to try ExternalIdentifier. If it again is not found, returns null.
	 * @param id                        RegistryObject identifier
	 * @return RegistryObject
	 * @throws SearchEngineException
	 */
	public RegistryObject queryById(String id) throws SearchEngineException {
		try {
            log.info("queryId:" + id);
			RegistryObject registryObject = coreDao.findRegistryObjectByUrnId(id);
            log.info("queryId:" + (registryObject == null));

            if(registryObject == null) {
				List<RegistryObject> registryObjectList = coreDao.findRegistryObjectByExternalIdentifierValue(id);
				if(registryObjectList != null && registryObjectList.size() > 0) {
					registryObject = registryObjectList.get(0);
				}
			}
			return registryObject;
		}
		catch (Exception ex) {
			throw new SearchEngineException(ex);
		}
	}

	// Spring DAO injection
	public void setCoreDao(CoreDao coreDao) {
		this.coreDao = coreDao;
	}

	// Spring DAO injection
	public void setSearchDao(EbrimGenericSearchDao searchDao) {
		this.searchDao = searchDao;
	}

    // Gaap client
	/*public void setGaapClient(GaapServicesClient gaapClient) {
		this.gaapClient = gaapClient;
	}*/

}
