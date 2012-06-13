package org.geonetwork.gaap.services.authentication;

import org.junit.Test;
import org.geonetwork.gaap.dao.UserDao;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.util.UserFactory;
import org.geonetwork.gaap.services.AbstractServiceTest;

/**
 * AuthenticationManager tests
 */
public class AuthenticationManagerTest extends AbstractServiceTest {

    @Test
    public void testAuthenticate() {
        User user = UserFactory.create();
        user.setUsername("user1");
        getUserDao().saveUser(user);

        User user2 = UserFactory.create();
        user2.setUsername("user2");
        getUserDao().saveUser(user2);

        AuthenticationManager authManager = new AuthenticationManager();

        String token = authManager.registerUserToken(user);
        assertNotNull(authManager.verifyToken(token));
        assertEquals(user, authManager.verifyToken(token));

        String token2 = authManager.registerUserToken(user2);
        assertNotNull(authManager.verifyToken(token2));
        assertEquals(user2, authManager.verifyToken(token2));
        assertNotSame(token, token2);

        String nonvalidToken = "dsadasdada";
        assertNull(authManager.verifyToken(nonvalidToken));
    }

    @Test
    public void testLogout() {
        User user = UserFactory.create();
        user.setUsername("user1");
        getUserDao().saveUser(user);

        AuthenticationManager authManager = new AuthenticationManager();

        String token = authManager.registerUserToken(user);
        assertEquals(user, authManager.verifyToken(token));

        // Use a non valid token
        String nonvalidToken = "dsadasdada";
        authManager.unregisterUserToken(user, nonvalidToken);

        assertEquals(user, authManager.verifyToken(token));

        // Use the valid token
        authManager.unregisterUserToken(user, token);
        assertNotSame(user, authManager.verifyToken(token));
    }

}
