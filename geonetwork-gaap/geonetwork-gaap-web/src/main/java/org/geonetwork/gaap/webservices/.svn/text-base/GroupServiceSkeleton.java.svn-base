/**
 * GroupServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */
package org.geonetwork.gaap.webservices;

import org.geonetwork.gaap.services.GroupService;
import org.geonetwork.gaap.services.authorization.AuthorizationManager;
import org.geonetwork.gaap.services.exception.GaapServiceException;

/**
 * GroupServiceSkeleton java skeleton for the axisService
 */
public class GroupServiceSkeleton {

    // Logical service layer
    GroupService groupService;

    AuthorizationManager authorizationManager;

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public void setAuthorizationManager(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }


    /**
     * Routes request from Axis to the logical service layer (GroupServiceImpl)
     *
     * @param uuid
     * @throws GaapServiceFault :
     */
    public void deleteGroup(String uuid, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(GroupService.class, "deleteGroup", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to delete a group.");

            groupService.deleteGroup(uuid);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }


    /**
     * Routes request from Axis to the logical service layer (GroupServiceImpl)
     *
     * @param group
     * @throws GaapServiceFault :
     */
    public void updateGroup(org.geonetwork.gaap.domain.group.Group group, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(GroupService.class, "updateGroup", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to update a group.");

            groupService.updateGroup(group);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }

    }


    /**
     * Routes request from Axis to the logical service layer (GroupServiceImpl)
     *
     * @param group
     * @throws GaapServiceFault :
     */
    public void createGroup(org.geonetwork.gaap.domain.group.Group group, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(GroupService.class, "createGroup", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to create a group.");

            groupService.createGroup(group);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (GroupServiceImpl)
     *
     * @throws GaapServiceFault :
     */
    public java.util.List<org.geonetwork.gaap.domain.group.Group> retrieveAllGroups(String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(GroupService.class, "retrieveAllGroups", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to retrieve groups.");

            return groupService.retrieveAllGroups();
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (GroupServiceImpl)
     *
     * @param uuid
     * @throws GaapServiceFault :
     */
    public org.geonetwork.gaap.domain.group.Group retrieveGroup(java.lang.String uuid, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(GroupService.class, "retrieveGroup", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to retrieve a group.");

            return groupService.retrieveGroup(uuid);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }
}
    