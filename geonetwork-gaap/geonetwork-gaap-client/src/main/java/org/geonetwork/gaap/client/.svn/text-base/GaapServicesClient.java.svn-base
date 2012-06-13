package org.geonetwork.gaap.client;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;
import org.geonetwork.gaap.domain.web.response.*;
import org.geonetwork.gaap.domain.web.request.*;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.geonetwork.gaap.client.user.UserServiceStub;
import org.geonetwork.gaap.client.group.GroupServiceStub;
import org.geonetwork.gaap.client.authentication.AuthenticationServiceStub;
import org.geonetwork.gaap.client.metadata.MetadataPermissionsServiceStub;

import java.util.List;

/**
 * Gaap axis2 webservices client
 *
 * @author Jose
 */
public class GaapServicesClient {
    private UserServiceStub userServiceStub;
    private GroupServiceStub groupServiceStub;
    private AuthenticationServiceStub authenticationServiceStub;
    private MetadataPermissionsServiceStub metadataServiceStub;

    private String authToken;

    private boolean initialized = false;
    private String webserviceUrl;
    
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setWebserviceUrl(String webserviceUrl) throws GeonetworkGaapClientException {
        this.webserviceUrl = webserviceUrl;

        try {
            init();
         } catch (AxisFault e) {
            throw new GeonetworkGaapClientException(e);
        }
    }

    public GaapServicesClient() throws GeonetworkGaapClientException {
        this("http://localhost/geonetwork-gaap-web");
    }

    public GaapServicesClient(String webserviceUrl) throws GeonetworkGaapClientException {
        try {
            this.authToken = "";
            this.webserviceUrl = webserviceUrl;

            init();

        } catch (AxisFault e) {
            throw new GeonetworkGaapClientException(e);
        }
    }

    private void init() throws AxisFault {
        userServiceStub = new UserServiceStub(webserviceUrl + "/services/UserService");
        groupServiceStub = new GroupServiceStub(webserviceUrl + "/services/GroupService");
        authenticationServiceStub = new AuthenticationServiceStub(webserviceUrl + "/services/AuthenticationService");
        authenticationServiceStub._getServiceClient().getOptions().setProperty(HTTPConstants.CHUNKED, "false");
        metadataServiceStub = new MetadataPermissionsServiceStub(webserviceUrl + "/services/MetadataPermissionsService");

        initialized = true;

    }
    /*
     *  Users
     */

    public User getUser(String uuid) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            GetUser request = new GetUser();
            request.setUserUuid(uuid);
            request.setAuthToken(authToken);
            GetUserResponse response = userServiceStub.GetUser(request);

            return response.getUser();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public User getUserByUsername(String userName) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            GetUserByUsername request = new GetUserByUsername();
            request.setUsername(userName);
            request.setAuthToken(authToken);
            GetUserResponse response = userServiceStub.GetUserByUsername(request);

            return response.getUser();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public List<User> getUsers() throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            GetUsers request = new GetUsers();
            request.setAuthToken(authToken);

            GetUsersResponse response = userServiceStub.GetUsers(request);

            return response.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void createUser(User user) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            CreateUser request = new CreateUser();
            request.setAuthToken(authToken);
            request.setUser(user);

            CreateUserResponse response = userServiceStub.CreateUser(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void updateUser(User user) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            UpdateUser request = new UpdateUser();
            request.setAuthToken(authToken);
            request.setUser(user);

            UpdateUserResponse response = userServiceStub.UpdateUser(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void deleteUser(String uuid) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            DeleteUser request = new DeleteUser();
            request.setAuthToken(authToken);
            request.setUserUuid(uuid);

            DeleteUserResponse response = userServiceStub.DeleteUser(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }


    /*
     *  Groups
     */

    public Group getGroup(String uuid) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            GetGroup request = new GetGroup();
            request.setAuthToken(authToken);
            request.setGroupUuid(uuid);
            GetGroupResponse response = groupServiceStub.GetGroup(request);

            return response.getGroup();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public List<Group> getGroups() throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            GetGroups request = new GetGroups();
            request.setAuthToken(authToken);

            GetGroupsResponse response = groupServiceStub.GetGroups(request);

            return response.getGroups();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void createGroup(Group group) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            CreateGroup request = new CreateGroup();
            request.setAuthToken(authToken);
            request.setGroup(group);

            CreateGroupResponse response = groupServiceStub.CreateGroup(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void updateGroup(Group group) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            UpdateGroup request = new UpdateGroup();
            request.setAuthToken(authToken);
            request.setGroup(group);

            UpdateGroupResponse response = groupServiceStub.UpdateGroup(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void deleteGroup(String uuid) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            DeleteGroup request = new DeleteGroup();
            request.setAuthToken(authToken);

            request.setGroupUuid(uuid);

            DeleteGroupResponse response = groupServiceStub.DeleteGroup(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    /*
     *  Authenticate
     */
    public String authenticate(String username, String password) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            Authenticate request = new Authenticate();
            request.setUserName(username);
            request.setPassword(password);

            AuthenticationResponse response = authenticationServiceStub.Authenticate(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

            return response.getAuthenticationToken();

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void logout(String username) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            Logout request = new Logout();
            request.setUserName(username);
            request.setAuthToken(authToken);

            LogoutResponse response = authenticationServiceStub.Logout(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }


    /*
     *  Metadata
     */

    public Operation getOperation(String opName) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            GetOperation request = new GetOperation();
            request.setAuthToken(authToken);

            request.setOperationName(opName);

            GetOperationResponse response = metadataServiceStub.GetOperation(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

            return response.getOperation();

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public List<Operation> getOperations() throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            GetOperations request = new GetOperations();
            request.setAuthToken(authToken);

            GetOperationsResponse response = metadataServiceStub.GetOperations(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

            return response.getOperations();

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void updateOperation(Operation op) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            UpdateOperation request = new UpdateOperation();
            request.setAuthToken(authToken);
            request.setOperation(op);

            UpdateOperationResponse response = metadataServiceStub.UpdateOperation(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public MetadataPermissions getPermissions(String metadataUuid) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            GetMetadataPermissions request = new GetMetadataPermissions();
            request.setAuthToken(authToken);
            request.setMetadataUuid(metadataUuid);

            GetMetadataPermissionsResponse response = metadataServiceStub.GetPermissions(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

            return response.getMetadataPermissions();

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void savePermissions(MetadataPermissions permissions) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            SaveMetadataPermissions request = new SaveMetadataPermissions();
            request.setAuthToken(authToken);
            request.setPermissions(permissions);

            SavePermissionsResponse response = metadataServiceStub.SavePermissions(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void removeMetadataPermission(String metadaUuid, String groupUuid, String opName) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            DeleteMetadataPermission request = new DeleteMetadataPermission();
            request.setAuthToken(authToken);
            request.setMetadataUuid(metadaUuid);
            request.setGroupUuid(groupUuid);
            request.setOperationName(opName);

            DeleteMetadataPermissionResponse response = metadataServiceStub.DeleteMetadataPermission(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public void saveMetadataPermission(String metadaUuid, String groupUuid, String opName) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            SaveMetadataPermission request = new SaveMetadataPermission();
            request.setAuthToken(authToken);
            request.setMetadataUuid(metadaUuid);
            request.setGroupUuid(groupUuid);
            request.setOperationName(opName);

            SaveMetadataPermissionResponse response = metadataServiceStub.SaveMetadataPermission(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }


    public List<String> filterMetadata(List<String> metadataUUids, String username) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            FilterMetadata request = new FilterMetadata();
            request.setAuthToken(authToken);
            request.setMetadataUuids(metadataUUids);
            request.setUserName(username);

            FilterMetadataResponse response = metadataServiceStub.FilterMetadata(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

            return response.getMetadataUuids();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

    public List<String> filterMetadataByGroups(List<String> groupUUids) throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();
            
            FilterMetadataByGroups request = new FilterMetadataByGroups();
            request.setAuthToken(authToken);
            request.setGroupUuids(groupUUids);

            FilterMetadataByGroupsResponse response = metadataServiceStub.FilterMetadataByGroups(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

            return response.getMetadataUuids();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

     public String getUserUuidByAuthToken() throws GeonetworkGaapClientException {
        try {
            if (!initialized) init();

            GetUserUuidByAuthToken request = new GetUserUuidByAuthToken();
            request.setAuthToken(authToken);

            GetUserUuidByAuthTokenResponse response = authenticationServiceStub.GetUserUuidByAuthToken(request);
            if (response.getStatus() == ResponseStatusCode.ERROR) {
                // TODO: Change
                throw new GeonetworkGaapClientException(response.getExceptionList().get(0));
            }

            return response.getUserUuid();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeonetworkGaapClientException(e);
        }
    }

}