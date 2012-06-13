package org.geonetwork.gaap.domain.util;

import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.geonetwork.gaap.domain.operation.Permission;
import org.geonetwork.gaap.domain.operation.Operation;

import java.util.Set;
import java.util.HashSet;

/**
 * Factory class for MetadataPermissions test
 *
 * @author Jose
 */
public class MetadataPermissionsFactory {
    public static MetadataPermissions create() {
        MetadataPermissions permissions = new MetadataPermissions();

        permissions.setMetadataUuid("aaaa-bbbb-dddd-ssss");

        Operation op = new Operation();
        op.setName("view");
        
        Set<Permission> operationsAllowed = new HashSet<Permission>();

        Permission opAllowed = new Permission();
        opAllowed.setMetadataUuid("aaaa-bbbb-dddd-ssss");
        opAllowed.setOperation(op);

        Group group = new Group();
        group.setUuid("ggg-aaa1");
        opAllowed.setGroup(group);

        operationsAllowed.add(opAllowed);

        Permission opAllowed2 = new Permission();
        opAllowed2.setMetadataUuid("aaaa-bbbb-dddd-ssss");
        opAllowed2.setOperation(op);

        Group group2  = new Group();
        group2.setUuid("ggg-aaa2");

        opAllowed2.setGroup(group2);

        operationsAllowed.add(opAllowed2);

        permissions.setPermissions(operationsAllowed);

        return permissions;
    }

    public static MetadataPermissions create2() {
        MetadataPermissions permissions = new MetadataPermissions();

        permissions.setMetadataUuid("aaaa-bbbb-dddd-ssss");

        Operation op = new Operation();
        op.setName("view");

        Set<Permission> operationsAllowed = new HashSet<Permission>();

        Permission opAllowed = new Permission();
        opAllowed.setOperation(op);

        Group group = new Group();
        group.setUuid("ggg-aaa1");
        opAllowed.setGroup(group);

        operationsAllowed.add(opAllowed);

        Permission opAllowed2 = new Permission();
        opAllowed2.setOperation(op);

        Group group2  = new Group();
        group2.setUuid("ggg-aaa2");

        opAllowed2.setGroup(group2);

        operationsAllowed.add(opAllowed2);

        permissions.setPermissions(operationsAllowed);

        return permissions;
    }
}
