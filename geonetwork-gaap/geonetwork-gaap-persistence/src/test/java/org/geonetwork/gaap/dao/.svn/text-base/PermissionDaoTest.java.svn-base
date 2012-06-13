package org.geonetwork.gaap.dao;

import org.junit.Test;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.geonetwork.gaap.domain.operation.Permission;
import org.geonetwork.gaap.domain.util.GroupFactory;
import org.geonetwork.gaap.domain.util.OperationFactory;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Tests for PermissionDao class
 *
 * @author Jose
 */
public class PermissionDaoTest extends AbstractDaoTest {
    PermissionDao permissionDao;
    GroupDao groupDao;
    OperationDao operationDao;

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public void setOperationDao(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    /**
     * Permission entity
     */
    @Test
    public void testCreatePermission() {
        Group group = GroupFactory.create();
        groupDao.saveGroup(group);

        Operation op = OperationFactory.create();
        operationDao.saveOperation(op);

        Permission permission = new Permission();
        permission.setMetadataUuid("aaa-bbb-ccc-fff");
        permission.setGroup(group);
        permission.setOperation(op);
        permissionDao.savePermission(permission);

        // Check permission was saved correctly
        Permission result = permissionDao.findPermissionById(permission.getHibernateId());
        assertEquals(permission, result);
    }

    @Test
    public void testDeletePermission() {
        Group group = GroupFactory.create();
        groupDao.saveGroup(group);

        Operation op = OperationFactory.create();
        operationDao.saveOperation(op);

        Permission permission = new Permission();
        permission.setMetadataUuid("aaa-bbb-ccc-fff");
        permission.setGroup(group);
        permission.setOperation(op);
        permissionDao.savePermission(permission);

        permissionDao.deletePermission(permission);

        Permission result = permissionDao.findPermissionById(permission.getHibernateId());
        assertNull(result);

        // Check Group and Operation haven't been deleted
        Group resultGroup = groupDao.findGroupById(group.getHibernateId());
        assertEquals(group, resultGroup);

        Operation resultOp = operationDao.findOperationById(op.getHibernateId());
        assertEquals(op, resultOp);
    }

    @Test
    public void testFindPermissionsByMetadataUuid() {
        Group group = GroupFactory.create();
        groupDao.saveGroup(group);

        Operation op = OperationFactory.create();
        operationDao.saveOperation(op);

        Permission permission = new Permission();
        permission.setMetadataUuid("aaa-bbb-ccc-fff");
        permission.setGroup(group);
        permission.setOperation(op);
        permissionDao.savePermission(permission);

        Operation op2 = OperationFactory.create();
        op2.setName("op2");
        operationDao.saveOperation(op2);

        permission = new Permission();
        permission.setMetadataUuid("aaa-bbb-ccc-fff");
        permission.setGroup(group);
        permission.setOperation(op2);
        permissionDao.savePermission(permission);

        permission = new Permission();
        permission.setMetadataUuid("mmm-bbb-ccc-fff");
        permission.setGroup(group);
        permission.setOperation(op2);
        permissionDao.savePermission(permission);

        List<Permission> result = permissionDao.findPermissionsByMetadataUuid("aaa-bbb-ccc-fff");
        assertEquals(2, result.size());

        result = permissionDao.findPermissionsByMetadataUuid("mmm-bbb-ccc-fff");
        assertEquals(1, result.size());

        result = permissionDao.findPermissionsByMetadataUuid("ccc");
        assertEquals(0, result.size());
    }

    @Test
    public void testDeletePermissionsByMetadataUuid() {
        Group group = GroupFactory.create();
        groupDao.saveGroup(group);

        Operation op = OperationFactory.create();
        operationDao.saveOperation(op);

        Permission permission = new Permission();
        permission.setMetadataUuid("aaa-bbb-ccc-fff");
        permission.setGroup(group);
        permission.setOperation(op);
        permissionDao.savePermission(permission);

        Operation op2 = OperationFactory.create();
        op2.setName("op2");
        operationDao.saveOperation(op2);

        permission = new Permission();
        permission.setMetadataUuid("aaa-bbb-ccc-fff");
        permission.setGroup(group);
        permission.setOperation(op2);
        permissionDao.savePermission(permission);

        permission = new Permission();
        permission.setMetadataUuid("mmm-bbb-ccc-fff");
        permission.setGroup(group);
        permission.setOperation(op2);
        permissionDao.savePermission(permission);

        permissionDao.deletePermissionsByMetadataUuid("aaa-bbb-ccc-fff");

        List<Permission> result = permissionDao.findPermissionsByMetadataUuid("aaa-bbb-ccc-fff");
        assertEquals(0, result.size());

        result = permissionDao.findPermissionsByMetadataUuid("mmm-bbb-ccc-fff");
        assertEquals(1, result.size());
    }

    @Test
    public void testSaveMetadataPermissions() {
        Operation op = new Operation();
        op.setName("view");
        operationDao.saveOperation(op);

        Group group = new Group();
        group.setName("group1");
        groupDao.saveGroup(group);

        Group group2 = new Group();
        group2.setName("group2");
        groupDao.saveGroup(group2);

        MetadataPermissions metadataPermissions = new MetadataPermissions();

        Set<Permission> permissions = new HashSet<Permission>();

        Permission permission = new Permission();
        permission.setGroup(group);
        permission.setOperation(op);
        permission.setMetadataUuid("aaaa-mmmm-ffff");

        permissions.add(permission);

        permission = new Permission();
        permission.setGroup(group2);
        permission.setOperation(op);
        permission.setMetadataUuid("aaaa-mmmm-ffff");

        permissions.add(permission);

        metadataPermissions.setPermissions(permissions);

        permissionDao.saveMetadataPermissions(metadataPermissions);

        List<Permission> results = permissionDao.findPermissionsByMetadataUuid("aaaa-mmmm-ffff");
        assertEquals(2, results.size());
    }

    @Test
    public void testFindPermission() {
        Operation op = new Operation();
        op.setName("view");
        operationDao.saveOperation(op);

        Group group = new Group();
        group.setUuid("group1");
        group.setName("group1");
        groupDao.saveGroup(group);

        Group group2 = new Group();
        group2.setUuid("group2");
        group2.setName("group2");
        groupDao.saveGroup(group2);

        MetadataPermissions metadataPermissions = new MetadataPermissions();

        Set<Permission> permissions = new HashSet<Permission>();

        Permission permission = new Permission();
        permission.setGroup(group);
        permission.setOperation(op);
        permission.setMetadataUuid("aaaa-mmmm-ffff");

        permissions.add(permission);

        permission = new Permission();
        permission.setGroup(group2);
        permission.setOperation(op);
        permission.setMetadataUuid("aaaa-mmmm-ffff");

        permissions.add(permission);

        metadataPermissions.setPermissions(permissions);

        permissionDao.saveMetadataPermissions(metadataPermissions);

        Permission result = permissionDao.findPermission("aaaa-mmmm-ffff", "group1", "view");
        assertNotNull(result);

        result = permissionDao.findPermission("aaaa-mmmm-ffff", "group2", "view");
        assertNotNull(result);

        result = permissionDao.findPermission("aaaa-mmmm-ffff", "non valid group", "view");
        assertNull(result);
    }
}