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

//==============================================================================package org.geonetwork.gaap.services;package org.geonetwork.gaap.services;
package org.geonetwork.gaap.services;

import org.geonetwork.gaap.dao.UserDao;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.services.exception.GaapServiceException;
import org.geonetwork.gaap.services.authentication.AuthenticationManager;
import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

/**
 * Service to authenticate users.
 *
 * @author Heikki Doeleman
 */
public class AuthenticationServiceImpl implements AuthenticationService {
    private static Logger log = Logger.getLogger(AuthenticationServiceImpl.class);

    private UserDao userDao;

    private AuthenticationManager authenticationManager;

    public String authenticate(String username, String providedPassword) throws GaapServiceException {
        User user = userDao.findUserByUsername(username);

        if (user != null) {
            String password = user.getPassword();

            if (password.equals(scramble(providedPassword))) {
                return authenticationManager.registerUserToken(user);
            } else {
                throw new GaapServiceException("User not valid");
            }
        } else {
            throw new GaapServiceException("User not valid");
        }
    }

    public void logout(String username, String token) throws GaapServiceException {
        User user = userDao.findUserByUsername(username);
        if (user != null) {
            authenticationManager.unregisterUserToken(user, token);
        } else {
            throw new GaapServiceException("User not valid");
        }
    }

    public boolean verifyUserToken(String username, String userToken) throws GaapServiceException {
        User user = userDao.findUserByUsername(username);
        if (user != null) {
            User userLogged =  authenticationManager.verifyToken(userToken);
            return user.equals(userLogged);
        } else {
            return false;

        }
    }

     public String getUserUuidByAuthToken(String userToken) throws GaapServiceException {
        User userLogged =  authenticationManager.verifyToken(userToken);
         if (userLogged != null) {
            return userLogged.getUuid();
         } else {
             return "";
         }
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

        /**
     * Calculates SHA-1 encryption of a text
     *
     * @param text
     * @return
     */
    private static String scramble(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            md.update(text.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();

            for (byte b : md.digest())
                sb.append(Integer.toString(b & 0xFF, 16));

            return sb.toString();
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}