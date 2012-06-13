package org.geonetwork.gaap.dao;

import org.junit.Test;
import org.geonetwork.gaap.domain.util.GroupFactory;
import org.geonetwork.gaap.domain.group.Group;

import java.util.List;

/**
 * Tests for GroupDao class
 *
 * @author Jose
 */
public class GroupDaoTest extends AbstractDaoTest {
    GroupDao groupDao;
                                       
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Test
    public void testCreateGroup() {
        // Create a test group
        Group group = GroupFactory.create();
        group.setUuid("group");
        groupDao.saveGroup(group);

        // Check group was saved correctly
        Group result = groupDao.findGroupById(group.getHibernateId());
        assertEquals(group, result);

        // Check 1 group in database
        List<Group> groups = groupDao.loadAllGroups();
        assertEquals(1, groups.size());

        // Create another test group
        Group group2 = GroupFactory.create();
        group2.setUuid("group2");
        group2.setName("group2");
        groupDao.saveGroup(group2);

        // Check group was saved correctly
        Group result2 = groupDao.findGroupById(group2.getHibernateId());
        assertEquals(group2, result2);

        // Check 2 group in database
        groups = groupDao.loadAllGroups();
        assertEquals(2, groups.size());

        // Check saved groups are distinct
        assertNotSame(result, result2);
    }

    @Test
    public void testUpdateGroup() {
        Group group = GroupFactory.create();
        groupDao.saveGroup(group);

        Group result = groupDao.findGroupById(group.getHibernateId());

        assertEquals(group, result);

        List<Group> groups = groupDao.loadAllGroups();
        assertEquals(1, groups.size());

        group.setName("new_groupname");

        groupDao.saveGroup(group);
        groups = groupDao.loadAllGroups();
        assertEquals(1, groups.size());

    }

    @Test
    public void testDeleteGroup() {
        Group group = GroupFactory.create();
        groupDao.saveGroup(group);

        Group result = groupDao.findGroupById(group.getHibernateId());

        assertEquals(group, result);

        try {
            groupDao.deleteGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        List<Group> groups = groupDao.loadAllGroups();
        assertEquals(0, groups.size());
    }

    @Test
    public void testGetGroups() {
        Group group = GroupFactory.create();
        group.setUuid("group1");
        group.setName("group1");
        groupDao.saveGroup(group);

        List<Group> groups = groupDao.loadAllGroups();
        assertEquals(1, groups.size());

        Group group2 = GroupFactory.create();
        group2.setUuid("group2");
        group2.setName("group2");
        groupDao.saveGroup(group2);

        groups = groupDao.loadAllGroups();
        assertEquals(2, groups.size());

        Group result = groupDao.findGroupById(group.getHibernateId());
        assertEquals(group.getName(), result.getName());

        Group result2 = groupDao.findGroupById(group2.getHibernateId());
        assertEquals(group2.getName(), result2.getName());

        assertFalse(result.getName().equals(result2.getName()));

        // findGroupByUuid
        Group group3 = GroupFactory.create();
        group3.setUuid("aaa-bbbb-cccc");
        group3.setName("group3");
        groupDao.saveGroup(group3);

        result = groupDao.findGroupByUuid(group3.getUuid());
        assertNotNull(result);
        assertEquals(group3, result);

        result = groupDao.findGroupByUuid("zzzzzz");
        assertNull(result);

        // findGroupByName
        result = groupDao.findGroupByName("group1");
        assertNotNull(result);
        assertEquals(group, result);

        result = groupDao.findGroupByName("zzzzzz");
        assertNull(result);
    }
}