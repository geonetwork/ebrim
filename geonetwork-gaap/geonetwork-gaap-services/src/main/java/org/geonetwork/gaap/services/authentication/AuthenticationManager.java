package org.geonetwork.gaap.services.authentication;

import org.geonetwork.gaap.domain.user.User;

import java.util.*;

/**
 * Authentication manager
 *
 * @author Jose
 */
public final class AuthenticationManager {
    private Map<String, AuthToken> authTokens;

    // Session expiry time. Default 30 minutes
    private long sessionExpiry = 30;

    public void setSessionExpiry(long sessionExpiry) {
        this.sessionExpiry = sessionExpiry;
    }


    public AuthenticationManager() {
        authTokens = new HashMap<String, AuthToken>();

        // Registers the process to expiry AuthTokens
        AuthExpiryTokensTask task = new AuthExpiryTokensTask(this);

        // Run task every 10 minutes
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, sessionExpiry * 60, sessionExpiry * 60);
    }

    /**
     * Creates an authToken for a user
     *
     * @param user User to register
     * @return Authorization token
     */
    public String registerUserToken(User user) {
        // TODO: Review hash creation
        Date now = new Date();

        Random r = new Random();
        long l1 = r.nextLong();
        r = new Random(user.getUsername().hashCode() * user.getProfile().hashCode());
        long l2 = r.nextLong();

        String hash = Long.toHexString(l1) + Long.toHexString(l2);

        synchronized (this) {
            AuthToken authToken = new AuthToken(hash, user, now);
            authTokens.put(hash, authToken);
        }

        return hash;
    }

    /**
     * Verifies an authentication token
     *
     * @param authToken Authorization token for the user
     * @return User if the AuthorizationToken it's valid, null otherwise
     */
    public User verifyToken(String authToken) {
        AuthToken token = authTokens.get(authToken);

        if (token != null) {
            if (token.getToken().equals(authToken)) {
                synchronized (this) {
                    // Update old of authToken
                    Date now = new Date();
                    token.setOld(now);
                }

                return token.getUser();
            }
        }

        return null;
    }

    /**
     * Unregisters a user
     *
     * @param user      User to register
     * @param authToken Authorization token for the user
     */
    public synchronized void unregisterUserToken(User user, String authToken) {
        AuthToken token = authTokens.get(authToken);

        if ((token != null) && (token.getUser().getUsername().equals(user.getUsername()))) {
            authTokens.remove(authToken);
        }
    }

    /**
     * Method invoked by the AuthExpiryTokensTask to expiry authorization tokens
     *
     */
    synchronized void expiryAuthTokens() {
        Date now = new Date();
        // Get time to expiry tokens
        Date expiryDate = new Date(now.getTime() - (sessionExpiry * javax.management.timer.Timer.ONE_MINUTE));

        Set<String> keys = authTokens.keySet();

        for (String key : keys) {
            AuthToken authToken = authTokens.get(key);

            // Expiry tokens not used since one hour before
            if (authToken.getOld().before(expiryDate)) {
                authTokens.remove(key);
            }
        }

    }
}
