package org.geonetwork.gaap.springsecurity;

import org.springframework.security.providers.AuthenticationProvider;
import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationException;
import org.springframework.security.AuthenticationCredentialsNotFoundException;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UserDetails;
import org.geonetwork.gaap.client.GaapServicesClient;
import org.geonetwork.gaap.client.GeonetworkGaapClientException;

/**
 * Gaap authentication provider
 *
 * @author
 */
public class GaapAuthenticationProvider implements AuthenticationProvider {
    private GaapServicesClient gaapClient;
    private UserDetailsService userDetailsService;

    public void setGaapClient(GaapServicesClient gaapClient) {
        this.gaapClient = gaapClient;
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!supports(authentication.getClass())) {
            return null;
        }
        
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        try {
            String authToken = gaapClient.authenticate(username, password);

            // Lookup user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            return new GaapAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), userDetails.getAuthorities(), authToken);
        } catch (GeonetworkGaapClientException e) {
            throw new AuthenticationCredentialsNotFoundException(e.getMessage());
        }

    }

     /**
     * Used to load the authorities for the authenticated Gaap user.
     */
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.providers.AuthenticationProvider#supports(java.lang.Class)
     */
    public boolean supports(Class authentication) {
        return GaapAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
