/**
 * GroupServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */
package org.geonetwork.gaap.webservices;

import org.geonetwork.gaap.services.GroupService;
import org.geonetwork.gaap.services.UserService;
import org.geonetwork.gaap.services.AuthenticationService;
import org.geonetwork.gaap.services.MetadataPermissionsService;
import org.geonetwork.gaap.services.authorization.AuthorizationManager;
import org.geonetwork.gaap.services.exception.GaapServiceException;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.geonetwork.gaap.domain.operation.Operation;

import java.util.List;

/**
 * MetadataPermissionsServiceSkeleton java skeleton for the axisService
 */
public class MetadataPermissionsServiceSkeleton {

    // Logical service layer
    MetadataPermissionsService permissionsService;

    AuthorizationManager authorizationManager;

    public void setPermissionsService(MetadataPermissionsService permissionsService) {
        this.permissionsService = permissionsService;
    }

    public void setAuthorizationManager(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }

    /**
     * Routes request from Axis to the logical service layer (MetadataPermissionsServiceImpl)
     *
     * @param opName
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */

    public Operation getOperation(String opName, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(MetadataPermissionsService.class, "getOperation", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to retrieve an operation.");

            return permissionsService.getOperation(opName);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (MetadataPermissionsServiceImpl)
     *
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */

    public List<Operation> getOperations(String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(MetadataPermissionsService.class, "getOperations", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to retrieve operations.");

            return permissionsService.getOperations();
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (MetadataPermissionsServiceImpl)
     *
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */

    public void updateOperation(Operation operation, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(MetadataPermissionsService.class, "updateOperation", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to update an operation.");

            permissionsService.updateOperation(operation);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (MetadataPermissionsServiceImpl)
     *
     * @param metadataUuids
     * @param userName
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */

    public List<String> filterMetadata(List<String> metadataUuids, String userName, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(MetadataPermissionsService.class, "filterMetadata", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to filter metadata.");

            return permissionsService.filterMetadata(metadataUuids, userName);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }


    /**
     * Routes request from Axis to the logical service layer (MetadataPermissionsServiceImpl)
     *
     * @param groupUuids
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */

    public List<String> filterMetadataByGroups(List<String> groupUuids, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(MetadataPermissionsService.class, "filterMetadataByGroups", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to filter metadata.");

            return permissionsService.filterMetadataByGroups(groupUuids);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }


    /**
     * Routes request from Axis to the logical service layer (MetadataPermissionsServiceImpl)
     *
     * @param metadataUuid
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */
    public MetadataPermissions getPermissions(String metadataUuid, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(MetadataPermissionsService.class, "getPermissions", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to retrieve metadata permissions.");

            return permissionsService.getPermissions(metadataUuid);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (MetadataPermissionsServiceImpl)
     *
     * @param permissions
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */
    public void savePermissions(MetadataPermissions permissions, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(MetadataPermissionsService.class, "savePermissions", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to save metadata permissions.");

            permissionsService.savePermissions(permissions);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }


    /**
     * Routes request from Axis to the logical service layer (MetadataPermissionsServiceImpl)
     *
     * @param metadataUuid
     * @param groupUuid
     * @param operationName
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */
    public void saveMetadataPermission(String metadataUuid, String groupUuid, String operationName, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(MetadataPermissionsService.class, "saveMetadataPermission", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to save metadata permission.");
            
            permissionsService.saveMetadataPermission(metadataUuid, groupUuid, operationName);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (MetadataPermissionsServiceImpl)
     *
     * @param metadataUuid
     * @param groupUuid
     * @param operationName
     * @throws org.geonetwork.gaap.webservices.GaapServiceFault
     *          :
     */
    public void deleteMetadataPermission(String metadataUuid, String groupUuid, String operationName, String authToken) throws GaapServiceFault {
        try {
            boolean canInvoke = authorizationManager.hasAuthorization(MetadataPermissionsService.class, "deleteMetadataPermission", authToken);
            if (!canInvoke)
                throw new GaapServiceException("Not authorized to delete metadata permission.");

            permissionsService.deleteMetadataPermission(metadataUuid, groupUuid, operationName);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

}