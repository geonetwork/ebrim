package org.geonetwork.gaap.services;

import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.services.exception.GaapServiceException;

import java.util.List;

/**
 * Service interface to manage GeoNetwork metadata permissions.
 *
 * @author Jose
 */
public interface MetadataPermissionsService {
    public Operation getOperation(String name) throws GaapServiceException;   
    public List<Operation> getOperations() throws GaapServiceException;
    public void updateOperation(Operation operation) throws GaapServiceException;

    public MetadataPermissions getPermissions(String metadataUuid) throws GaapServiceException;

    public List<String> filterMetadata(List<String> metadataUuids, String userName) throws GaapServiceException;
    public List<String> filterMetadataByGroups(List<String> groupUuids) throws GaapServiceException;

    public void saveMetadataPermission(String metadataUuid, String groupUuid, String operationName) throws GaapServiceException;
    public void deleteMetadataPermission(String metadataUuid, String groupUuid, String operationName) throws GaapServiceException;       
    public void savePermissions(MetadataPermissions permissions) throws GaapServiceException;

}
