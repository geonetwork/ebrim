package org.geonetwork.gaap.dao;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.operation.Permission;

import java.util.List;

public abstract class AbstractCommitDaoTest extends AbstractDependencyInjectionSpringContextTests {
    PermissionDao permissionDao;
    GroupDao groupDao;
    OperationDao operationDao;

    protected String[] getConfigLocations() {
        return new String[]{"applicationContext-gn-persistence-gaap-test.xml", "applicationContext-gn-persistence-gaap.xml"};
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

    @Override
    protected void onTearDown() throws Exception {
        super.onTearDown();

        List<Permission> permissions = permissionDao.loadAllPermissions();
        for (Permission p : permissions) {
            permissionDao.deletePermission(p);
        }

        List<Group> groups = groupDao.loadAllGroups();
        for (Group gr : groups) {
            groupDao.deleteGroup(gr);
        }

        List<Operation> operations = operationDao.loadAllOperations();
        for (Operation op : operations) {
            operationDao.deleteOperation(op);
        }

    }
}
