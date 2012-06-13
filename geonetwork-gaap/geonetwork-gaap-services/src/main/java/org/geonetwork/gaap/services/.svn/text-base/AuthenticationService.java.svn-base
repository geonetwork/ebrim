package org.geonetwork.gaap.services;

import org.geonetwork.gaap.services.exception.GaapServiceException;

/**
 * Service interface to manage user authentication.
 *
 * @author Jose
 */
public interface AuthenticationService {
    public String authenticate(String username, String providedPassword) throws GaapServiceException;
    public void logout(String username, String token) throws GaapServiceException;
    public boolean verifyUserToken(String username, String userToken) throws GaapServiceException;
    public String getUserUuidByAuthToken(String userToken) throws GaapServiceException;
}
