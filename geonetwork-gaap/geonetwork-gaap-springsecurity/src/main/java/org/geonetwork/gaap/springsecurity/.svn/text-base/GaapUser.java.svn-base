package org.geonetwork.gaap.springsecurity;

import org.springframework.security.userdetails.User;
import org.springframework.security.GrantedAuthority;

/**
 * Gaap user
 *
 * @author Jose
 */
public class GaapUser extends User {
    // Authentication token provided by Gaap
    private String authToken;

    public GaapUser(String username, String password,
      boolean enabled, boolean accountNonExpired,
      boolean credentialsNonExpired, boolean accountNonLocked,
      GrantedAuthority[] authorities) throws IllegalArgumentException {

        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
