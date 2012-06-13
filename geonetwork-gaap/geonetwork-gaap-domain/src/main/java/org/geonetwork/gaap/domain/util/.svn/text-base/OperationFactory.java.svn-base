package org.geonetwork.gaap.domain.util;

import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.operation.OperationDescription;
import org.geonetwork.gaap.domain.operation.Permission;
import org.geonetwork.gaap.domain.group.Group;

import java.util.Set;
import java.util.HashSet;

/**
 * Factory class for Operation test
 *
 * @author Jose
 */
public class OperationFactory {
    public static Operation create() {
        Operation op = new Operation();
        op.setName("view");
        op.setReserved(true);

        Set<OperationDescription> descriptions = new HashSet<OperationDescription>();
        OperationDescription des = new OperationDescription();
        des.setLangId("en");
        des.setLabel("view");
        descriptions.add(des);

        des = new OperationDescription();
        des.setLangId("es");
        des.setLabel("ver");
        descriptions.add(des);

        op.setDescriptions(descriptions);
        
        return op;
    }

    public static Permission createPermission() {
        Operation op = new Operation();
        op.setName("view");
        op.setReserved(true);

        Group group = new Group();
        group.setUuid("aaa-bbb-ccc");

        Permission permission = new Permission();
        permission.setMetadataUuid("bbb-aaa-bbb-ccc");
        permission.setGroup(group);
        permission.setOperation(op);

        return permission;
    }
}
