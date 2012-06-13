package org.geonetwork.gaap.services;

import org.junit.Test;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.util.GroupFactory;
import org.geonetwork.gaap.services.exception.GaapServiceException;

import java.util.List;

/**
 * Tests for GroupService class
 */
public class GroupServiceTest extends AbstractServiceTest {
    GroupService groupService;

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }


    @Test
    public void testCreateUpdateGroup() {
        Group group = GroupFactory.create();

        try {
            // Create a group
            groupService.createGroup(group);

            Group result = groupService.retrieveGroup(group.getUuid());
            assertSame(group, result);

            // Modify a group property
            group.setName("modified-group");
            groupService.updateGroup(group);

            result = groupService.retrieveGroup(group.getUuid());
            assertSame(group, result);

        } catch (GaapServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testDelete() {
        try {
            // Delete using group
            Group group = GroupFactory.create();

            groupService.createGroup(group);

            Group result = groupService.retrieveGroup(group.getUuid());
            assertSame(group, result);

            groupService.deleteGroup(group);

            result = groupService.retrieveGroup(group.getUuid());
            assertNull(result);

            // Delete by uuid
            group = GroupFactory.create();
            groupService.createGroup(group);

            result = groupService.retrieveGroup(group.getUuid());
            assertSame(group, result);

            groupService.deleteGroup(group.getUuid());

            result = groupService.retrieveGroup(group.getUuid());
            assertNull(result);

        } catch (GaapServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testRetrieve() {
        try {
            // Create a group
            Group group = GroupFactory.create();
            groupService.createGroup(group);

            Group result = groupService.retrieveGroup(group.getUuid());
            assertSame(group, result);

            // Create another group
            Group group2 = GroupFactory.create();
            group2.setName("g2");
            group2.setUuid("g2");
            groupService.createGroup(group2);

            result = groupService.retrieveGroup(group2.getUuid());
            assertSame(group2, result);

            List<Group> groups = groupService.retrieveAllGroups();
            assertEquals(2, groups.size());
            for(Group g: groups) {
               assertTrue(g.equals(group) || g.equals(group2));     
            }
            
        } catch (GaapServiceException e) {
            e.printStackTrace();
            fail();
        }
    }
}
