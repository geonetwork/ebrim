package org.geonetwork.gaap.services;

import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.geonetwork.gaap.domain.operation.Permission;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.services.exception.GaapServiceException;
import org.geonetwork.gaap.services.authorization.AuthorizationManager;
import org.geonetwork.gaap.dao.OperationDao;
import org.geonetwork.gaap.dao.GroupDao;
import org.geonetwork.gaap.dao.UserDao;
import org.geonetwork.gaap.dao.PermissionDao;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Service to manage GeoNetwork metadata permissions.
 *
 * @author Jose
 */
public class MetadataPermissionsServiceImpl implements MetadataPermissionsService {
    private static final String GROUP_ALL_UUID = "all";
    private static final String VIEW_OPERATION_NAME = "view";

    OperationDao operationDao;
    UserDao userDao;
    GroupDao groupDao;
    PermissionDao permissionDao;


    /**
     * Gets a metadata operation by name
     *
     * @return List of metadata operations
     * @throws GaapServiceException
     */
    public List<Operation> getOperations() throws GaapServiceException {
        try {
            return operationDao.loadAllOperations();
        } catch (Exception x) {
            throw new GaapServiceException(x);
        }

    }

    /**
     * Gets all metadata operations
     *
     * @param name Operation name
     * @return Operation
     * @throws GaapServiceException
     */
    public Operation getOperation(String name) throws GaapServiceException {
        try {
            return operationDao.findOperationByName(name);
        } catch (Exception x) {
            throw new GaapServiceException(x);
        }

    }

    /**
     * Updates an operation
     *
     * @param operation Operation
     * @throws GaapServiceException
     */
    public void updateOperation(Operation operation) throws GaapServiceException {
        try {
            Operation dbOperation = operationDao.findOperationByName(operation.getName());

            if (dbOperation != null) {
                operation.setHibernateId(dbOperation.getHibernateId());

                operationDao.mergeOperation(operation);
            } else {
                throw new GaapServiceException("Operation doesn't exists");
            }
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    /**
     * Gets the metadata permissions
     *
     * @param metadataUuid Metadata uuid to get permissions
     * @return MetadataPermissions
     * @throws GaapServiceException
     */
    public MetadataPermissions getPermissions(String metadataUuid) throws GaapServiceException {
        MetadataPermissions metadataPermissions = new MetadataPermissions();

        metadataPermissions.setMetadataUuid(metadataUuid);
        metadataPermissions.setPermissions(new HashSet(permissionDao.findPermissionsByMetadataUuid(metadataUuid)));

        return metadataPermissions;
    }


    /**
     * Filter a list of metadata uuids that are allowed to view for the provided user.
     * If the user is not valid returns only public metadata uuids
     *
     * @param metadataUuids List of metadata uuids to filter
     * @param userName      User to check permissions
     * @return Filtered list of metadata uuids allowed to view for the user
     * @throws GaapServiceException
     */
    // TODO: Authenticate user here or in the web layer before invoke this service??
    public List<String> filterMetadata(List<String> metadataUuids, String userName) throws GaapServiceException {
        List<String> resultMetadataUuids = new ArrayList<String>();
        Set<Group> filterGroups = new HashSet<Group>();

        if (userName != null) {
            User user = userDao.findUserByUsername(userName);
            if (user != null) {
                filterGroups.addAll(user.getUserGroups());

                // Users with  profile Administrator can access all metadata
                if (user.getProfile() != null) {
                    if ((user.getProfile().equals(AuthorizationManager.PROFILE_ADMIN))) return metadataUuids;
                }
            }
        }

        Group allGroup = groupDao.findGroupByUuid(GROUP_ALL_UUID);
        if (allGroup != null) filterGroups.add(allGroup);

        Operation op = operationDao.findOperationByName(VIEW_OPERATION_NAME);

        try {
            int size = metadataUuids.size();
            int blockSize = 50;
            int pos = 0;
            while (pos < size) {
                int nextPos = pos + blockSize;
                if (nextPos > size) nextPos = size;

                resultMetadataUuids.addAll(permissionDao.filterMetadataAllowed(metadataUuids.subList(pos, nextPos), new ArrayList(filterGroups), op));
                pos = nextPos;
            }

            //resultMetadataUuids = permissionDao.filterMetadataAllowed(metadataUuids, new ArrayList(filterGroups), op);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GaapServiceException(e);
        }

        return resultMetadataUuids;
    }

    /**
     * Filter all metadata that are allowed to view for the provided groups.
     *
     * @param groupUuids List of group uuids to filter metadata
     * @return Filtered list of metadata uuids allowed to view for the groups
     * @throws GaapServiceException
     */
    public List<String> filterMetadataByGroups(List<String> groupUuids) throws GaapServiceException {
        List<String> resultMetadataUuids;
        Set<Group> filterGroups = new HashSet<Group>();

        Group allGroup = groupDao.findGroupByUuid(GROUP_ALL_UUID);
        if (allGroup != null) filterGroups.add(allGroup);

        Operation op = operationDao.findOperationByName(VIEW_OPERATION_NAME);

        try {
            resultMetadataUuids = permissionDao.filterMetadataAllowedForGroupsOperation(groupUuids, op);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GaapServiceException(e);
        }

        return resultMetadataUuids;
    }

    /**
     * Save permissions for a metadata record
     * The permissions retrieved from jibx are like:
     * <p/>
     * <opr:metadataPermissions xmlns:opr="http://geonetwork.org/gaap/domain/operation"
     * metadataUuid="aaaa-bbbb-dddd-ssss">
     * <opr:permission groupId="af36ea3e-6b86-44d6-8094-41ff3a66ee5e" operationId="view"/>
     * <opr:permission groupId="ggg-aaa2" operationId="view"/>
     * </opr:metadataPermissions>
     * <p/>
     * To save the permissions correctly must be processed before, retrieving group and operation
     * using uuid and name
     *
     * @param metadataPermissions
     * @throws GaapServiceException
     */
    public void savePermissions(MetadataPermissions metadataPermissions) throws GaapServiceException {
        try {
            String metadataUuid = metadataPermissions.getMetadataUuid();

            // Remove current permissions
            permissionDao.deletePermissionsByMetadataUuid(metadataUuid);

            // Save new permissions
            for (Permission permission : metadataPermissions.getPermissions()) {
                Permission permissionToSave = new Permission();
                permissionToSave.setMetadataUuid(metadataUuid);

                String groupUuid = permission.getGroup().getUuid();
                String opName = permission.getOperation().getName();

                Group group = groupDao.findGroupByUuid(groupUuid);
                permissionToSave.setGroup(group);

                Operation op = operationDao.findOperationByName(opName);
                permissionToSave.setOperation(op);

                permissionDao.savePermission(permissionToSave);
            }
        }
        catch (Exception x) {
            throw new GaapServiceException(x);
        }
    }

    /**
     * Saves a metadata permission
     *
     * @param metadataUuid Metadata uuid to get permissions
     * @return MetadataPermissions
     * @throws GaapServiceException
     */
    public void saveMetadataPermission(String metadataUuid, String groupUuid, String operationName) throws GaapServiceException {
        Permission permission = permissionDao.findPermission(metadataUuid, groupUuid, operationName);
        if (permission == null) {
            permission = new Permission();
            permission.setMetadataUuid(metadataUuid);
            permission.setGroup(groupDao.findGroupByUuid(groupUuid));
            permission.setOperation(operationDao.findOperationByName(operationName));
            permissionDao.savePermission(permission);
        }

    }

    /**
     * Removes a metadata permission
     *
     * @param metadataUuid Metadata uuid to get permissions
     * @return MetadataPermissions
     * @throws GaapServiceException
     */
    public void deleteMetadataPermission(String metadataUuid, String groupUuid, String operationName) throws GaapServiceException {
        Permission permission = permissionDao.findPermission(metadataUuid, groupUuid, operationName);
        if (permission != null) {
            permissionDao.deletePermission(permission);
        }

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void setOperationDao(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
}
