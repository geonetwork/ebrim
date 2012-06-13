package org.geonetwork.gaap.springsecurity;

import org.springframework.security.providers.UsernamePasswordAuthenticationToken;
import org.springframework.security.GrantedAuthority;

/**
 * Authentication token
 */
public class GaapAuthenticationToken extends UsernamePasswordAuthenticationToken {
    String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public GaapAuthenticationToken(Object principal, Object credentials, String authToken) {
        super(principal, credentials);
        this.authToken = authToken;
    }

    public GaapAuthenticationToken(Object principal, Object credentials, GrantedAuthority[] authorities,String authToken) {
        super(principal, credentials, authorities);
        this.authToken = authToken;
    }
}
