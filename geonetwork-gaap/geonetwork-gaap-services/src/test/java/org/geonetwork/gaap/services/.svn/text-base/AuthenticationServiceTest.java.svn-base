package org.geonetwork.gaap.services;

import org.junit.Test;
import org.geonetwork.gaap.domain.util.UserFactory;
import org.geonetwork.gaap.domain.util.GroupFactory;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.services.exception.GaapServiceException;

import java.util.Set;
import java.util.HashSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;

/**
 * Test class for AuthenticationService
 *
 * @author Jose
 */
public class AuthenticationServiceTest extends AbstractServiceTest {
    AuthenticationService authenticationService;
    UserService userService;
    GroupService groupService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Test
    public void testAuthenticate() {
        User user = UserFactory.create();
        Group group = GroupFactory.create();

        try {
            groupService.createGroup(group);

            user.setUsername("user1");
            user.setPassword(scramble("password"));
            Set<Group> userGroups = new HashSet<Group>();
            userGroups.add(group);
            user.setUserGroups(userGroups);
            userService.createUser(user);

            String token = authenticationService.authenticate(user.getUsername(), "password");
            assertNotNull(token);

            assertTrue(authenticationService.verifyUserToken(user.getUsername(), token));

        } catch (GaapServiceException ex) {
            ex.printStackTrace();
            fail();
        }

        try {
            String token = authenticationService.authenticate(user.getUsername(), "nonvalidpassword");
            fail();

        } catch (GaapServiceException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testLogout() {
        User user = UserFactory.create();
        Group group = GroupFactory.create();

        try {
            groupService.createGroup(group);

            user.setUsername("user1");
            user.setPassword(scramble("password"));
            Set<Group> userGroups = new HashSet<Group>();
            userGroups.add(group);
            user.setUserGroups(userGroups);
            userService.createUser(user);

            String token = authenticationService.authenticate(user.getUsername(), "password");
            assertNotNull(token);

            // Use a non valid token
            authenticationService.logout(user.getUsername(), "nonvalidtoken");
            assertTrue(authenticationService.verifyUserToken(user.getUsername(), token));

            // Use a valid token
            authenticationService.logout(user.getUsername(), token);
            assertFalse(authenticationService.verifyUserToken(user.getUsername(), token));

        } catch (GaapServiceException ex) {
            ex.printStackTrace();
            fail();
        }
    }


    /**
     * Calculates SHA-1 encryption of a text
     *
     * @param text
     * @return
     */
    private static String scramble(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            md.update(text.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();

            for (byte b : md.digest())
                sb.append(Integer.toString(b & 0xFF, 16));

            return sb.toString();
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
