package org.geonetwork.gaap.client;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.geonetwork.gaap.domain.web.response.*;
import org.geonetwork.gaap.domain.web.request.GaapGetRequest;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.user.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Gaap client
 *
 * @author Jose
 */
public class GaapClient {
    private static final String REQUEST_PARAM = "request";
    private static final String UUID_PARAM = "uuid";

    public final static String urlPropertyName = "geonetwork.ebrim.webapp.url";
    public final static String defaultUrl = "http://localhost:8080/geonetwork-gaap-web/gaap";

    HttpClient client;
    PostMethod method;

    public GaapClient() {
        client = new HttpClient();
    }

    /**
     * Retrieves from GAAP the user groups list
     *
     * @return List of user groups
     * @throws GeonetworkGaapClientException
     */
    public List<Group> getGroups() throws GeonetworkGaapClientException {

        try {
            InputStream s = execGetMethod(new NameValuePair[]{
                    new NameValuePair(REQUEST_PARAM, GaapGetRequest.GETGROUPS.toString())
            });

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(GetGroupsResponse.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to GetGroupResponse
            GetGroupsResponse response = (GetGroupsResponse) unMarshallingContext.unmarshalDocument(s, "UTF-8");

            return response.getGroups();

        } catch (JiBXException e) {
            throw new GeonetworkGaapClientException(e);
        }
    }

    /**
     * Retrieves from GAAP the users list
     *
     * @return List of users
     * @throws GeonetworkGaapClientException
     */
    public List<User> getUsers() throws GeonetworkGaapClientException {
        try {
            InputStream s = execGetMethod(new NameValuePair[]{
                    new NameValuePair(REQUEST_PARAM, GaapGetRequest.GETUSERS.toString())
            });

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(GetUsersResponse.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to GetGroupResponse
            GetUsersResponse response = (GetUsersResponse) unMarshallingContext.unmarshalDocument(s, "UTF-8");

            return response.getUsers();

        } catch (JiBXException e) {
            throw new GeonetworkGaapClientException(e);
        }
    }

    /**
     * Retrieves from GAAP a user info
     *
     * @param uuid User identifier
     * @return User info
     * @throws GeonetworkGaapClientException
     */
    public User getUser(String uuid) throws GeonetworkGaapClientException {
        try {
            InputStream s = execGetMethod(new NameValuePair[]{
                    new NameValuePair(REQUEST_PARAM, GaapGetRequest.GETUSER.toString()),
                    new NameValuePair(UUID_PARAM, uuid)
            });

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(User.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to GetGroupResponse
            User response = (User) unMarshallingContext.unmarshalDocument(s, "UTF-8");

            return response;

        } catch (JiBXException e) {
            throw new GeonetworkGaapClientException(e);
        }
    }

    /**
     * Retrieves from GAAP a group info
     *
     * @param uuid Group identifier
     * @return Group info
     * @throws GeonetworkGaapClientException
     */
    public Group getGroup(String uuid) throws GeonetworkGaapClientException {
        try {
            InputStream s = execGetMethod(new NameValuePair[]{
                    new NameValuePair(REQUEST_PARAM, GaapGetRequest.GETGROUP.toString()),
                    new NameValuePair(UUID_PARAM, uuid)
            });

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(Group.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to GetGroupResponse
            Group response = (Group) unMarshallingContext.unmarshalDocument(s, "UTF-8");

            return response;

        } catch (JiBXException e) {
            throw new GeonetworkGaapClientException(e);
        }
    }

    /**
     * Deletes a user group from GAAP
     *
     * @param uuid Group identifier
     * @return Group info
     * @throws GeonetworkGaapClientException
     */
    public boolean deleteGroup(String uuid) throws GeonetworkGaapClientException {
        try {
            InputStream s = execGetMethod(new NameValuePair[]{
                    new NameValuePair(REQUEST_PARAM, GaapGetRequest.DELETEGROUP.toString()),
                    new NameValuePair(UUID_PARAM, uuid)
            });

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(DeleteGroupResponse.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to ResponseReport
            DeleteGroupResponse response = (DeleteGroupResponse) unMarshallingContext.unmarshalDocument(s, "UTF-8");

            return (response.getStatus() == ResponseStatusCode.OK);

        } catch (JiBXException e) {
            throw new GeonetworkGaapClientException(e);
        }
    }

    /**
     * Deletes a user  from GAAP
     *
     * @param uuid Group identifier
     * @return Group info
     * @throws GeonetworkGaapClientException
     */
    public boolean deleteUser(String uuid) throws GeonetworkGaapClientException {
        try {
            InputStream s = execGetMethod(new NameValuePair[]{
                    new NameValuePair(REQUEST_PARAM, GaapGetRequest.DELETEUSER.toString()),
                    new NameValuePair(UUID_PARAM, uuid)
            });

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(DeleteUserResponse.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to ResponseReport
            DeleteUserResponse response = (DeleteUserResponse) unMarshallingContext.unmarshalDocument(s, "UTF-8");

            return (response.getStatus() == ResponseStatusCode.OK);

        } catch (JiBXException e) {
            throw new GeonetworkGaapClientException(e);
        }
    }

    /**
     * Executes a GET method sending the supplied parameters
     *
     * @param params Parameters to call the method
     * @return InputStream with the response
     * @throws GeonetworkGaapClientException
     */
    private InputStream execGetMethod(NameValuePair[] params) throws GeonetworkGaapClientException {
        String url = System.getProperties().getProperty(urlPropertyName) == null ? defaultUrl : System.getProperties()
                .getProperty(urlPropertyName);

        // Create a method instance.
        GetMethod method = new GetMethod(url);

        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

        // Provide params
        method.setQueryString(params);

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                throw new GeonetworkGaapClientException("Method failed: " + method.getStatusLine());
            }

            return new ByteArrayInputStream(method.getResponseBody());

        } catch (HttpException e) {
            throw new GeonetworkGaapClientException(e);
        } catch (IOException e) {
            throw new GeonetworkGaapClientException(e);
        } finally {
            // Release the connection.
            if (method != null) method.releaseConnection();
        }
    }
}
