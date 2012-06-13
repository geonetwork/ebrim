package org.geonetwork.gaap.dao;

import org.junit.Test;
import org.geonetwork.gaap.domain.util.UserFactory;
import org.geonetwork.gaap.domain.util.GroupFactory;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.group.Group;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

/**
 * Tests for UserDao class
 *
 * @author Jose
 */
public class UserDaoTest extends AbstractDaoTest {
    UserDao userDao;
    GroupDao groupDao;

    public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

    public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

    @Test
    public void testCreateUser() {
        List<Group> groups = GroupFactory.createList();
        for(Group g: groups) {
            groupDao.saveGroup(g);
        }
        Set<Group> groupSet = new HashSet(groups);

        // Create a test user
        User user = UserFactory.create();
        user.setUuid("user1");
        user.setUsername("user1");
        user.setUserGroups(groupSet);
        userDao.saveUser(user);
        
        // Check user was saved correctly
        User result = userDao.findUserById(user.getHibernateId());
        assertEquals(user, result);

        
        // Check 1 user in database
        List<User> users = userDao.loadAllUsers();
        assertEquals(1, users.size());

        // Create another test user
        User user2 = UserFactory.create();
        user2.setUuid("user2");
        user2.setUsername("user2");
        user.setUserGroups(groupSet);
        userDao.saveUser(user2);

        // Check user was saved correctly
        User result2 = userDao.findUserById(user2.getHibernateId());       
        assertSame(user2, result2);

        // Check 2 user in database
        users = userDao.loadAllUsers();
        assertEquals(2, users.size());

         // Check saved users are distinct
        assertNotSame(result, result2);
    }

    @Test
    public void testUpdateUser() {
        User user = UserFactory.create();
        userDao.saveUser(user);

        User result = userDao.findUserById(user.getHibernateId());

        assertEquals(user, result);

        List<User> users = userDao.loadAllUsers();
        assertEquals(1, users.size());

        user.setUsername("new_username");

        userDao.saveUser(user);
        users = userDao.loadAllUsers();
        assertEquals(1, users.size());

    }

    @Test
    public void testDeleteUser() {
        User user = UserFactory.create();
        userDao.saveUser(user);

        User result = userDao.findUserById(user.getHibernateId());

        assertEquals(user, result);

        try {
            userDao.deleteUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        List<User> users = userDao.loadAllUsers();
        assertEquals(0, users.size());
    }

    @Test
    public void testGetUsers() {
        List<Group> groups = GroupFactory.createList();
        for(Group g: groups) {
            groupDao.saveGroup(g);
        }
        Set<Group> groupSet = new HashSet(groups);

        User user = UserFactory.create();
        user.setUuid("user1");
        user.setUsername("user1");
        user.setUserGroups(groupSet);
        userDao.saveUser(user);

        List<User> users = userDao.loadAllUsers();
        assertEquals(1, users.size());

        User user2 = UserFactory.create();
        user2.setUuid("user2");
        user2.setName("user2");
        user2.setUsername("user2");
        user.setUserGroups(groupSet);
        userDao.saveUser(user2);

        users = userDao.loadAllUsers();
        assertEquals(2, users.size());

        User result = userDao.findUserById(user.getHibernateId());
        assertEquals(user.getName(), result.getName());

        User result2 = userDao.findUserById(user2.getHibernateId());
        assertEquals(user2.getName(), result2.getName());

        assertFalse(result.getName().equals(result2.getName()));

        // findUserByUuid
        user = UserFactory.create();
        user.setUuid("aaa-bbbb-cccc");
        user.setUsername("user3");
        user.setUserGroups(groupSet);
        userDao.saveUser(user);

        result = userDao.findUserByUuid(user.getUuid());
        assertNotNull(result);
        assertEquals(user, result);

        result = userDao.findUserByUuid("zzzzzz");
        assertNull(result);

        // findUserByUsername
        user = UserFactory.create();
        user.setUuid("jose");
        user.setUsername("jose");
        user.setUserGroups(groupSet);
        userDao.saveUser(user);

        result = userDao.findUserByUsername(user.getUsername());
        assertNotNull(result);
        assertEquals(user, result);

        result = userDao.findUserByUsername("zzzzzz");
        assertNull(result);
    }
}
