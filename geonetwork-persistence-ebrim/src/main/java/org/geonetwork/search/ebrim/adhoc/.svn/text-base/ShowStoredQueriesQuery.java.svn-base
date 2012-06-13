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

import org.geonetwork.dao.ebrim.informationmodel.EventDao;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.search.ebrim.SearchEngineException;

import java.util.List;
import java.util.Map;

/**
 * Returns a listing of all predefined queries recognized by the service.
 *
 * @author Jose
 */
public class ShowStoredQueriesQuery extends AdhocQuerySearch {
    private static final String QUERY_IDENTIFIER = "urn:ogc:def:ebRIM-Query:OGC:showStoredQueries";

    EventDao eventDao;

    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    public static String getIdentifier() {
            return QUERY_IDENTIFIER;
    }

    public List<? extends RegistryObject> query(Map<String, String> parameters) throws SearchEngineException {
        return eventDao.loadAllAdhocQuery();
    }
}
