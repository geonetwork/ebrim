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
package org.geonetwork.dao.facade;

import org.apache.log4j.Logger;
import org.geonetwork.dao.ebrim.informationmodel.RegistryObjectListDao;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;

/**
 * Facade class to be used by service layer to save RegistryObjectList. The RegistryObjectList has a list
 * of RegistryObjects which are the result of transforming 1 ISO19139 metadata document into ebRIM.
 * 
 *  The ISO19139 fileIdentifier is the 'logical' ID for this list of RegistryObjects. If no RegistryObjectList
 *  with that identifier was stored before, it is the result of the insertion of a new ISO19139 document. If it
 *  already exists, it is the result of updating an existing ISO19139 object -- in that case all existing
 *  RegistryObjects correlated to that RegistryObjectList are deleted, and the new ones inserted.
 *
 * @author Heikki Doeleman
 */
public class RegistryObjectListStoreFacade {

	private static Logger log = Logger.getLogger(RegistryObjectListStoreFacade.class);
	
	private RegistryObjectListDao registryObjectListDao;

    /**
     * Stores a RegistryObject. If exists a RegistryObject in database
     * with same fileIdentier (that is, an ISO file with that same id
     * was already registered in the ebRIM) it's replaced with new RegistryObject.
     *
     * @param registryObjectList    RegistryObject to save
     * @throws GeoNetworkException
     */
    public void save(RegistryObjectList registryObjectList) throws GeoNetworkException {
        String fileIdentifier = registryObjectList.getIso19139Id();
    	log.debug("saving RegistryObjectList with ISO ID: " + fileIdentifier);
        if (fileIdentifier != null) {
        	RegistryObjectList existingRegistryObjectList = registryObjectListDao.findRegistryObjectListByISO19139Id(fileIdentifier);
            if(existingRegistryObjectList == null) {
                for(RegistryObject reg: registryObjectList.getRegistryObjects()) {
                    reg.setRegistryObjectListInverse(registryObjectList);
                }
                
        		// ISO was inserted
        		registryObjectListDao.saveRegistryObjectList(registryObjectList);
        	}
        	else {
        		// ISO was updated
        		registryObjectListDao.deleteRegistryObjectList(existingRegistryObjectList);

                for(RegistryObject reg: registryObjectList.getRegistryObjects()) {
                    reg.setRegistryObjectListInverse(registryObjectList);
                }
        		registryObjectListDao.saveRegistryObjectList(registryObjectList);        		
        	}        	
        }
        else {
        	// invalid RegistryObjectList
        	log.error("RegistryObjectList has no ID");
        	throw new GeoNetworkException("ERROR: RegistryObjectList has no ID");
        }
    }

    public void setRegistryObjectListDao(RegistryObjectListDao registryObjectListDao) {
        this.registryObjectListDao = registryObjectListDao;
    }
}
