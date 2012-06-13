/**
 * UserService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package org.geonetwork.gaap.client.user;

/*
*  UserService java interface
*/

public interface UserService {


    /**
     * Auto generated method signature
     *
     * @param UpdateUser
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     */


    public org.geonetwork.gaap.domain.web.response.UpdateUserResponse UpdateUser(

            org.geonetwork.gaap.domain.web.request.UpdateUser UpdateUser)
            throws java.rmi.RemoteException

            , org.geonetwork.gaap.client.GaapServiceFault;


    /**
     * Auto generated method signature
     *
     * @param CreateUser
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     */


    public org.geonetwork.gaap.domain.web.response.CreateUserResponse CreateUser(

            org.geonetwork.gaap.domain.web.request.CreateUser CreateUser)
            throws java.rmi.RemoteException

            , org.geonetwork.gaap.client.GaapServiceFault;


    /**
     * Auto generated method signature
     *
     * @param GetUser
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     */


    public org.geonetwork.gaap.domain.web.response.GetUserResponse GetUser(

            org.geonetwork.gaap.domain.web.request.GetUser GetUser)
            throws java.rmi.RemoteException

            , org.geonetwork.gaap.client.GaapServiceFault;


    /**
     * Auto generated method signature
     *
     * @param DeleteUser
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     */


    public org.geonetwork.gaap.domain.web.response.DeleteUserResponse DeleteUser(

            org.geonetwork.gaap.domain.web.request.DeleteUser DeleteUser)
            throws java.rmi.RemoteException

            , org.geonetwork.gaap.client.GaapServiceFault;


    /**
     * Auto generated method signature
     *
     * @param GetUsers
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     */


    public org.geonetwork.gaap.domain.web.response.GetUsersResponse GetUsers(

            org.geonetwork.gaap.domain.web.request.GetUsers GetUsers)
            throws java.rmi.RemoteException

            , org.geonetwork.gaap.client.GaapServiceFault;


        /**
     * Auto generated method signature
     *
     * @param GetUserByUsername
     * @throws org.geonetwork.gaap.client.GaapServiceFault
     *          :
     */


    public org.geonetwork.gaap.domain.web.response.GetUserResponse GetUserByUsername(

            org.geonetwork.gaap.domain.web.request.GetUserByUsername GetUserByUsername)
            throws java.rmi.RemoteException

            , org.geonetwork.gaap.client.GaapServiceFault;

    //
}
    