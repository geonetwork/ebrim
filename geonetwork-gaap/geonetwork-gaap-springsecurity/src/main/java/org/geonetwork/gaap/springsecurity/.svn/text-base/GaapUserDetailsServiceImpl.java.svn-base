package org.geonetwork.gaap.springsecurity;

import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.geonetwork.gaap.client.GaapServicesClient;
import org.geonetwork.gaap.client.GeonetworkGaapClientException;
import org.geonetwork.gaap.domain.user.User;

/**
 * GaapUserDetailsService implementation
 *
 * @author Jose
 */
public class GaapUserDetailsServiceImpl  implements UserDetailsService {
    private GaapServicesClient gaapClient;

    public void setGaapClient(GaapServicesClient gaapClient) {
        this.gaapClient = gaapClient;
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            User user = gaapClient.getUserByUsername(s);
            if (user == null)
                throw new UsernameNotFoundException("User not found");
            
            return buildGaapUser(user);
        } catch (GeonetworkGaapClientException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Builds a GaapUser with 
     * @param user
     * @return
     */
    private GaapUser buildGaapUser(User user) {
        //TODO: Complete with authorities
        GrantedAuthority[] grantedAuthorities = new GrantedAuthorityImpl[0];

        return new GaapUser(user.getUsername(), user.getPassword(), true,
                false, false, true, grantedAuthorities);
    }
}
