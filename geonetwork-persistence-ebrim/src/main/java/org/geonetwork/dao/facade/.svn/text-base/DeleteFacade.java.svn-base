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

import org.geonetwork.dao.ebrim.informationmodel.RegistryObjectListDao;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;

/**
 * Façade for delete operations on the ebRIM persistency layer.
 * 
 * @author heikki doeleman
 * 
 */
public class DeleteFacade {

	private RegistryObjectListDao registryObjectListDao;

	/**
	 * Deletes all the ebrim documents related to the iso19139Id
	 * 
	 * @param iso19139Id
	 * @throws GeoNetworkException
	 */
	public void deleteByISOId(String iso19139Id) throws GeoNetworkException {
		RegistryObjectList registryObjectList = registryObjectListDao.findRegistryObjectListByISO19139Id(iso19139Id);
		registryObjectListDao.deleteRegistryObjectList(registryObjectList);
	}

	/**
	 * Setter for DI Spring
	 * 
	 * @param registryObjectListDao
	 */
	public void setRegistryObjectListDao(RegistryObjectListDao registryObjectListDao) {
		this.registryObjectListDao = registryObjectListDao;
	}

}
