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

import org.geonetwork.gaap.dao.GroupDao;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.group.GroupUuid;
import org.geonetwork.gaap.services.exception.GaapServiceException;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Service to manage GeoNetwork groups.
 *
 * @author Heikki Doeleman
 */
public class GroupServiceImpl implements GroupService {

    private GroupDao groupDao;

    public Group retrieveGroup(String uuid) throws GaapServiceException {
        try {
            return groupDao.findGroupByUuid(uuid);
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public List<Group> retrieveAllGroups() throws GaapServiceException {
        try {
            return groupDao.loadAllGroups();
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public void createGroup(Group group) throws GaapServiceException {
        try {
            groupDao.saveGroup(group);
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public void updateGroup(Group group) throws GaapServiceException {
        try {

            Group dbGroup = groupDao.findGroupByUuid(group.getUuid());

            if (dbGroup != null) {
                group.setHibernateId(dbGroup.getHibernateId());
                groupDao.mergeGroup(group);
            } else {
                throw new GaapServiceException("Group doesn't exists");
            }              
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public void deleteGroup(Group group) throws GaapServiceException {
        try {
            // Base groups can't be deleted
            boolean canDeleteGroup = (!group.getUuid().equals(GroupUuid.ALL.toString()) &&
                                 !group.getUuid().equals(GroupUuid.INTRANET.toString()) &&
                                 !group.getUuid().equals(GroupUuid.GUEST.toString()));

            if (canDeleteGroup) {
                groupDao.deleteGroup(group);
            } else {
                throw new GaapServiceException("Group " + group.getUuid() + " can't be deleted.");
            }
        }
        catch (DataIntegrityViolationException x) {
            throw new GaapServiceException("Can't delete group. It's assigned to users");    
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public void deleteGroup(String uuid) throws GaapServiceException {
        try {
            Group group = groupDao.findGroupByUuid(uuid);

            if (group != null) groupDao.deleteGroup(group);
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public GroupDao getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
}