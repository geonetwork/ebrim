package org.geonetwork.gaap.domain.util;

import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.user.User;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 * Factory class for User test
 *
 * @author Jose
 */
public class UserFactory {
    public static User create() {
        User user = new User();
        user.setUuid("aaa-bbb-ccc-ddd");

        user.setName("name");
        user.setSurname("surname");
        user.setAddress("address");
        user.setCity("city");
        user.setZip("11111");
        user.setCountry("country");
        user.setKind("kind");
        user.setOrganisation("organisation");
        user.setUsername("username");
        user.setPassword("password");
        user.setProfile("admin");
        user.setEmail("user@mail.com");

        Group group = new Group();
        group.setUuid("ddd-eee-fff-ggg");
        group.setName("groupname");

        Set<Group> userGroups = new HashSet<Group>();
        userGroups.add(group);

        user.setUserGroups(userGroups);

        return user;
    }

    public static List<User> createList() {
        List<User> users = new ArrayList<User>();
        users.add(create());

        User user = create();
        user.setUuid("xcz-gfd-bvc-tre");

        user.setName("name2");
        user.setSurname("surname2");
        user.setAddress("address2");
        user.setCity("city2");
        user.setZip("2222");
        user.setCountry("country2");
        user.setKind("kind2");
        user.setOrganisation("organisation2");
        user.setUsername("username2");
        user.setPassword("password2");
        user.setProfile("admin2");
        user.setEmail("user@mail.com");
       
        users.add(user);

        return users;
    }
}