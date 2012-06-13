package org.geonetwork.gaap.services;

import org.junit.Test;
import org.geonetwork.gaap.domain.util.UserFactory;
import org.geonetwork.gaap.domain.util.GroupFactory;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.services.exception.GaapServiceException;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * Tests for UserService class
 */
public class UserServiceTest extends AbstractServiceTest {
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void testCreateUpdateUser() {
        User user = UserFactory.create();
        Group group = GroupFactory.create();

        try {
            getGroupDao().saveGroup(group);

            // Create a user
            Set<Group> userGroups = new HashSet<Group>();
            userGroups.add(group);
            user.setUserGroups(userGroups);
            userService.createUser(user);

            User result = userService.retrieveUser(user.getUuid());
            assertSame(user, result);

            // Modify a user property
            user.setName("modified-group");
            userService.updateUser(user);

            result = userService.retrieveUser(user.getUuid());
            assertSame(user, result);

        } catch (GaapServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testDelete() {
        try {
            Group group = GroupFactory.create();
            getGroupDao().saveGroup(group);
            Set<Group> groups = new HashSet();
            groups.add(group);

            // Delete using user
            User user = UserFactory.create();
            user.setUserGroups(groups);
            userService.createUser(user);

            User result = userService.retrieveUser(user.getUuid());
            assertSame(user, result);

            userService.deleteUser(user);

            result = userService.retrieveUser(user.getUuid());
            assertNull(result);

            // Delete by uuid
            user = UserFactory.create();
            user.setUuid("user2");
            user.setUsername("user2");
            user.setUserGroups(groups);

            userService.createUser(user);

            result = userService.retrieveUser(user.getUuid());
            assertSame(user, result);

            userService.deleteUser(user.getUuid());

            result = userService.retrieveUser(user.getUuid());
            assertNull(result);

        } catch (GaapServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testRetrieve() {
        try {
            Group group = GroupFactory.create();
            getGroupDao().saveGroup(group);
            Set<Group> groups = new HashSet();
            groups.add(group);

            // Create a user
            User user = UserFactory.create();
            user.setUserGroups(groups);
            userService.createUser(user);

            User result = userService.retrieveUser(user.getUuid());
            assertSame(user, result);

            // Create another user
            User user2 = UserFactory.create();
            user2.setUsername("g2");
            user2.setName("g2");
            user2.setUuid("g2");
            user2.setUserGroups(groups);
            userService.createUser(user2);

            result = userService.retrieveUser(user2.getUuid());
            assertSame(user2, result);

            List<User> users = userService.retrieveAllUsers();
            assertEquals(2, users.size());
            for(User u: users) {
               assertTrue(u.equals(user) || u.equals(user2));
            }

        } catch (GaapServiceException e) {
            e.printStackTrace();
            fail();
        }
    }


}