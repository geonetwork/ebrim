/**
 * GroupServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */
package org.geonetwork.gaap.webservices;

import org.geonetwork.gaap.services.GroupService;
import org.geonetwork.gaap.services.UserService;
import org.geonetwork.gaap.services.authorization.AuthorizationManager;
import org.geonetwork.gaap.services.exception.GaapServiceException;

/**
 * UserServiceSkeleton java skeleton for the axisService
 */
public class UserServiceSkeleton {

    // Logical service layer
    UserService userService;

    AuthorizationManager authorizationManager;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setAuthorizationManager(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }


    /**
     * Routes request from Axis to the logical service layer (UserServiceImpl)
     *
     * @param uuid
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */

    public void deleteUser(String uuid, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(UserService.class, "deleteUser", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to delete a user.");

            userService.deleteUser(uuid);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }


    /**
     * Routes request from Axis to the logical service layer (UserServiceImpl)
     *
     * @param user
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */
    public void updateUser(org.geonetwork.gaap.domain.user.User user, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(UserService.class, "updateUser", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to update a user.");

            userService.updateUser(user);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }


    /**
     * Routes request from Axis to the logical service layer (UserServiceImpl)
     *
     * @param user
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */
    public void createUser(org.geonetwork.gaap.domain.user.User user, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(UserService.class, "createUser", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to create all users.");

            userService.createUser(user);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }

    }

    /**
     * Routes request from Axis to the logical service layer (UserServiceImpl)
     *
     * @throws GaapServiceFault :
     */
    public java.util.List<org.geonetwork.gaap.domain.user.User> retrieveAllUsers(String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(UserService.class, "retrieveAllUsers", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to retrieve all users.");

            return userService.retrieveAllUsers();
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (UserServiceImpl)
     *
     * @param uuid
     * @throws GaapServiceFault :
     */
    public org.geonetwork.gaap.domain.user.User retrieveUser(java.lang.String uuid, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(UserService.class, "retrieveUser", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to retrieve a user.");

            return userService.retrieveUser(uuid);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (UserServiceImpl)
     *
     * @param username
     * @throws GaapServiceFault :
     */
    public org.geonetwork.gaap.domain.user.User retrieveUserByUsername(java.lang.String username) throws GaapServiceFault {
        try {
            return userService.retrieveUserByUsername(username);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

}