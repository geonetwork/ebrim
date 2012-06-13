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

import java.util.List;

import org.apache.log4j.Logger;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;

/**
 * Facade class to be used by service layer to save RegistryObjects
 * without care if they are new or existent .
 *
 * @author Jose
 */
public class RegistryObjectStoreFacade {
	
	private static Logger log = Logger.getLogger(RegistryObjectStoreFacade.class);
	
    private static final String IDENTIFIER_NAME = "http://purl.org/dc/elements/1.1/identifier";

    CoreDao coreDao;

    /**
     * Stores a RegistryObject. If exists a RegistryObject in database
     * with same fileIdentier (that is, an ISO file with that same id
     * was already registered in the ebRIM) it's replaced with new RegistryObject.
     *
     * @param registryObject    RegistryObject to save
     * @throws GeoNetworkException
     */
    public void save(RegistryObject registryObject) throws GeoNetworkException {
    	
    	log.debug("\n\n# slots: " + registryObject.getSlots().size());
    	if(registryObject.getSlots().size() > 0) {
    		for(Slot slot : registryObject.getSlots()) {
    		
    			if(slot.getName().getValue().equals(IDENTIFIER_NAME)) {
    		   log.debug(": " + registryObject.getObjectType().getValue() + " " + slot.getValueList().getValues().get(0).getValue());
    		   
    			}
    		}
    	}
        String fileIdentifier = getFileIdentifierValue(registryObject);

        if (fileIdentifier != null) {
            // Delete if exists the RegistryObject with same fileIdentifier
            List<RegistryObject> existingRegistryObject = coreDao.findRegistryObjectBySlotNameAndValue(IDENTIFIER_NAME, fileIdentifier);

            if (!existingRegistryObject.isEmpty()) {
                // fileIdentifier is different for each metadata record, so only 1 record must be returned
                coreDao.deleteRegistryObject(existingRegistryObject.get(0));
            }
        }
        coreDao.saveRegistryObject(registryObject);
    }


    /**
     * Gets the fileIdentifier slot value from a RegistryObject
     *
     * @param registryObject
     * @return Value of fileIdentifier value
     */
    private String getFileIdentifierValue(RegistryObject registryObject) {
        List<Slot> fileIdentifierSlots = registryObject.findSlotsByName(IDENTIFIER_NAME);

        if(fileIdentifierSlots == null || fileIdentifierSlots.size() == 0) {
        	log.debug("\n\n\n\n\n\nNO FILEIDENTIFER IN: ");
        	log.debug(registryObject.getObjectType().getValue());
        	log.debug(registryObject.getId().getValue());
        	log.debug(registryObject.getName().getLocalizedStrings().iterator().next().getValue());

        }
        
        for(Slot slot: fileIdentifierSlots) {
            ValueList valueList = slot.getValueList();
            if (valueList.getValues().size() > 0)
                return valueList.getValues().get(0).getValue();
        }

        return null;
    }

    public void setCoreDao(CoreDao coreDao) {
        this.coreDao = coreDao;
    }
}
