//=============================================================================
//===	Copyright (C) 2009 European Space Agency (ESA).
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

//==============================================================================package org.geonetwork.gaap.services;
package org.geonetwork.gaap.services;

import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.services.exception.GaapServiceException;

import java.util.List;

/**
 * Service interface to manage GeoNetwork groups.
 *
 * @author Heikki Doeleman
 */
public interface GroupService {
    public Group retrieveGroup(String uuid) throws GaapServiceException;
    public List<Group> retrieveAllGroups() throws GaapServiceException;

    public void createGroup(Group group) throws GaapServiceException;
    public void updateGroup(Group group) throws GaapServiceException;

    public void deleteGroup(Group group) throws GaapServiceException;
    public void deleteGroup(String uuid) throws GaapServiceException;
}
