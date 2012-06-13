package org.geonetwork.gaap.dao;

import org.junit.Test;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.geonetwork.gaap.domain.operation.Permission;
import org.geonetwork.gaap.domain.group.Group;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Tests for PermissionDao class (filter metadata)
 *
 * @author Jose
 */
public class PermissionDaoFilterTest extends AbstractCommitDaoTest {
    
    @Test
    public void testFilterMetadataAllowed() {
        try {
            createFilterMetadataTestData();

            Operation op = operationDao.findOperationByName("filter-view");

            // Filter permissions for metadata "aaaa-mmmm-ffff" and group1
            // Expected 1 result
            List<String> metadataUuids = new ArrayList<String>();
            metadataUuids.add("filter-aaaa-mmmm-ffff");

            List<Group> groups = new ArrayList<Group>();
            groups.add(groupDao.findGroupByUuid("filter-group1"));

            List<String> filteredMetadataUuids = permissionDao.filterMetadataAllowed(metadataUuids, groups, op);
            assertEquals(1, filteredMetadataUuids.size());

            // Filter permissions for metadata "aaaa-mmmm-ffff" and group3
            // Expected 0 results
            metadataUuids = new ArrayList<String>();
            metadataUuids.add("filter-aaaa-mmmm-ffff");

            groups = new ArrayList<Group>();
            groups.add(groupDao.findGroupByUuid("filter-group3"));

            filteredMetadataUuids = permissionDao.filterMetadataAllowed(metadataUuids, groups, op);
            assertEquals(0, filteredMetadataUuids.size());

            // Filter permissions for metadata: "aaaa-mmmm-ffff", "aaaa-mmmm-ffff"
            // and groups: group1, group3
            // Expected 2 results
            metadataUuids = new ArrayList<String>();
            metadataUuids.add("filter-aaaa-mmmm-ffff");
            metadataUuids.add("filter-aaaa-mmmm-gggg");

            groups = new ArrayList<Group>();
            groups.add(groupDao.findGroupByUuid("filter-group1"));
            groups.add(groupDao.findGroupByUuid("filter-group3"));

            filteredMetadataUuids = permissionDao.filterMetadataAllowed(metadataUuids, groups, op);
            assertEquals(2, filteredMetadataUuids.size());

            deleteFilterMetadataTestData();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }


     @Test
    public void testFilterAllMetadataAllowed() {
        try {
            createFilterMetadataTestData();

            Operation op = operationDao.findOperationByName("filter-view");

            // Filter permissions for group1
            // Expected 1 result
            List<String> groups = new ArrayList<String>();
            groups.add("filter-group1");

            List<String> filteredMetadataUuids = permissionDao.filterMetadataAllowedForGroupsOperation(groups, op);
            assertEquals(1, filteredMetadataUuids.size());

            // Filter permissions for and group3
            // Expected 0 results
            groups = new ArrayList<String>();
            groups.add("filter-group3");

            filteredMetadataUuids = permissionDao.filterMetadataAllowedForGroupsOperation(groups, op);
            assertEquals(1, filteredMetadataUuids.size());

            // Filter permissions for groups: group1, group3
            // Expected 2 results
            groups = new ArrayList<String>();
            groups.add("filter-group1");
            groups.add("filter-group3");

            filteredMetadataUuids = permissionDao.filterMetadataAllowedForGroupsOperation(groups, op);
            assertEquals(2, filteredMetadataUuids.size());

            deleteFilterMetadataTestData();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    private void createFilterMetadataTestData() {
        Operation op = new Operation();
        op.setName("filter-view");
        operationDao.saveOperation(op);

        Group group = new Group();
        group.setUuid("filter-group1");
        group.setName("filter-group1");
        groupDao.saveGroup(group);

        Group group2 = new Group();
        group2.setUuid("filter-group2");
        group2.setName("filter-group2");
        groupDao.saveGroup(group2);

        Group group3 = new Group();
        group3.setUuid("filter-group3");
        group3.setName("filter-group3");
        groupDao.saveGroup(group3);

        // Permissions for metadata "aaaa-mmmm-ffff"
        MetadataPermissions metadataPermissions = new MetadataPermissions();

        Set<Permission> permissions = new HashSet<Permission>();

        Permission permission = new Permission();
        permission.setGroup(group);
        permission.setOperation(op);
        permission.setMetadataUuid("filter-aaaa-mmmm-ffff");

        permissions.add(permission);

        permission = new Permission();
        permission.setGroup(group2);
        permission.setOperation(op);
        permission.setMetadataUuid("filter-aaaa-mmmm-ffff");

        permissions.add(permission);

        metadataPermissions.setPermissions(permissions);
        permissionDao.saveMetadataPermissions(metadataPermissions);

        // Permissions for metadata "aaaa-mmmm-gggg"
        metadataPermissions = new MetadataPermissions();

        permissions = new HashSet<Permission>();

        permission = new Permission();
        permission.setGroup(group3);
        permission.setOperation(op);
        permission.setMetadataUuid("filter-aaaa-mmmm-gggg");

        permissions.add(permission);

        metadataPermissions.setPermissions(permissions);
        permissionDao.saveMetadataPermissions(metadataPermissions);
    }

    private void deleteFilterMetadataTestData() {
        permissionDao.deletePermissionsByMetadataUuid("filter-aaaa-mmmm-ffff");
        permissionDao.deletePermissionsByMetadataUuid("filter-aaaa-mmmm-gggg");
        operationDao.deleteOperation(operationDao.findOperationByName("filter-view"));
        groupDao.deleteGroup(groupDao.findGroupByUuid("filter-group1"));
        groupDao.deleteGroup(groupDao.findGroupByUuid("filter-group2"));
        groupDao.deleteGroup(groupDao.findGroupByUuid("filter-group3"));
    }

}
