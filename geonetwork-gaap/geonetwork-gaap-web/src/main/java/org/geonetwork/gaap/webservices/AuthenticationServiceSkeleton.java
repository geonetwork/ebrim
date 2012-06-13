/**
 * GroupServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5  Built on : Apr 30, 2009 (06:07:24 EDT)
 */
package org.geonetwork.gaap.webservices;

import org.geonetwork.gaap.services.GroupService;
import org.geonetwork.gaap.services.UserService;
import org.geonetwork.gaap.services.AuthenticationService;
import org.geonetwork.gaap.services.exception.GaapServiceException;

/**
 * AuthenticationServiceSkeleton java skeleton for the axisService
 */
public class AuthenticationServiceSkeleton {

    // Logical service layer
    AuthenticationService authenticationService;

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Routes request from Axis to the logical service layer (AuthenticationService)
     *
     * @param username
     * @param providedPassword
     * @throws GaapServiceFault :
     */

    public String authenticate(String username, String providedPassword) throws GaapServiceFault {
        try {
            return authenticationService.authenticate(username, providedPassword);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }


    /**
     * Routes request from Axis to the logical service layer (AuthenticationService)
     *
     * @param username
     * @param token
     * @throws GaapServiceFault :
     */
    public void logout(String username, String token) throws GaapServiceFault {
        try {
            authenticationService.logout(username, token);
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

    /**
     * Routes request from Axis to the logical service layer (AuthenticationService)
     *
     * @param token
     * @throws GaapServiceFault :
     */
    public String getUserUuidByAuthToken(String token) throws GaapServiceFault {
        try {
            return authenticationService.getUserUuidByAuthToken(token) ;
        } catch (GaapServiceException e) {
            throw new GaapServiceFault(e.getMessage());
        }
    }

}