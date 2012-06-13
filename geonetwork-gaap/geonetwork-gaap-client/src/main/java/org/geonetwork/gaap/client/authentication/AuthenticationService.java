/**
 * AuthenticationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package org.geonetwork.gaap.client.authentication;

/*
*  AuthenticationService java interface
*/

public interface AuthenticationService {


    /**
     * Auto generated method signature
     *
     * @param Logout
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     */


    public org.geonetwork.gaap.domain.web.response.LogoutResponse Logout(

            org.geonetwork.gaap.domain.web.request.Logout Logout)
            throws java.rmi.RemoteException

            , org.geonetwork.gaap.client.GaapServiceFault;


    /**
     * Auto generated method signature
     *
     * @param Authenticate
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     */


    public org.geonetwork.gaap.domain.web.response.AuthenticationResponse Authenticate(

            org.geonetwork.gaap.domain.web.request.Authenticate Authenticate)
            throws java.rmi.RemoteException

            , org.geonetwork.gaap.client.GaapServiceFault;

     public org.geonetwork.gaap.domain.web.response.GetUserUuidByAuthTokenResponse GetUserUuidByAuthToken(

            org.geonetwork.gaap.domain.web.request.GetUserUuidByAuthToken GetUserUuidByAuthToken)
            throws java.rmi.RemoteException

            , org.geonetwork.gaap.client.GaapServiceFault;



    //
}
    