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

import org.geonetwork.gaap.dao.UserDao;
import org.geonetwork.gaap.dao.GroupDao;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.services.exception.GaapServiceException;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Service to manage GeoNetwork users.
 *
 * @author Heikki Doeleman
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private GroupDao groupDao;

    public User retrieveUser(String uuid) throws GaapServiceException {
        try {
            return userDao.findUserByUuid(uuid);
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public User retrieveUserByUsername(String username) throws GaapServiceException {
        try {
            return userDao.findUserByUsername(username);
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public List<User> retrieveAllUsers() throws GaapServiceException {
        try {
            return userDao.loadAllUsers();
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public void createUser(User user) throws GaapServiceException {
        try {
            Set<Group> userGroups = new HashSet<Group>();

            for(Group g: user.getUserGroups()) {
                Group group = groupDao.findGroupByUuid(g.getUuid());
                userGroups.add(group);    
            }
            user.setUserGroups(userGroups);

            userDao.saveUser(user);
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }

    }

    public void updateUser(User user) throws GaapServiceException {
        try {
            User dbUser = userDao.findUserByUuid(user.getUuid());

            if (dbUser != null) {
                user.setHibernateId(dbUser.getHibernateId());
                Set<Group> userGroups = new HashSet<Group>();

                for(Group g: user.getUserGroups()) {
                    Group group = groupDao.findGroupByUuid(g.getUuid());
                    userGroups.add(group);
                }
                user.setUserGroups(userGroups);

                userDao.mergeUser(user);
            } else {
                throw new GaapServiceException("User doesn't exists");
            }
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public void deleteUser(User user) throws GaapServiceException {
        try {
            userDao.deleteUser(user);
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public void deleteUser(String uuid) throws GaapServiceException {
        try {
            User user = userDao.findUserByUuid(uuid);

            if (user != null) userDao.deleteUser(user);
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
}
