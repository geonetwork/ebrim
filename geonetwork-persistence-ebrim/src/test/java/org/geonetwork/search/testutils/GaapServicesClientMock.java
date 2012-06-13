package org.geonetwork.search.testutils;

import org.geonetwork.gaap.client.GeonetworkGaapClientException;
import org.geonetwork.gaap.client.GaapServicesClient;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.operation.Operation;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.apache.axis2.AxisFault;

import java.util.List;
import java.util.ArrayList;

/**
 * Gaap client mock for tests
 */
public class GaapServicesClientMock extends GaapServicesClient {

    private String authToken;

    private boolean initialized = false;
    private String webserviceUrl;


    private List<User> users = new ArrayList<User>();
    private List<Group> groups = new ArrayList<Group>();
    private List<Operation> operations = new ArrayList<Operation>();

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setWebserviceUrl(String webserviceUrl) throws GeonetworkGaapClientException {
        try {
            this.webserviceUrl = webserviceUrl;
            init();
        } catch (AxisFault e) {
            throw new GeonetworkGaapClientException(e);
        }
    }


    public GaapServicesClientMock() throws GeonetworkGaapClientException {
        this("http://localhost:8080/geonetwork-gaap-web/services");
    }

    public GaapServicesClientMock(String webserviceUrl) throws GeonetworkGaapClientException {
        try {
            this.authToken = "";
            this.webserviceUrl = webserviceUrl;

            init();

        } catch (AxisFault e) {
            throw new GeonetworkGaapClientException(e);
        }
    }

    private void init() throws AxisFault {

        initialized = true;

        // Init users
        User usr1 = new User();
        usr1.setUuid("sss-fddf-erer-fds1");
        usr1.setName("name1");
        usr1.setUsername("userName1");

        User usr2 = new User();
        usr2.setUuid("sss-fddf-erer-fds2");
        usr2.setName("name2");
        usr2.setUsername("userName2");

        users.add(usr1);
        users.add(usr2);

        // Init groups
        Group grp1 = new Group();
        grp1.setUuid("sss-fddf-erer-fds1");
        grp1.setName("name1");


        Group grp2 = new Group();
        grp2.setUuid("sss-fddf-erer-fds2");
        grp2.setName("name2");
        usr2.setUsername("userName2");

        groups.add(grp1);
        groups.add(grp2);


        // Init operations
        Operation op1 = new Operation();
        op1.setName("view");
        op1.setReserved(true);

        Operation op2 = new Operation();
        op2.setName("edit");
        op2.setReserved(true);

        operations.add(op1);
        operations.add(op2);
    }

    /*
     *  Users
     */

    public User getUser(String uuid) throws GeonetworkGaapClientException {
        for (User usr : users) {
            if (usr.getUuid().equals(uuid)) return usr;
        }

        return null;
    }

    public User getUserByUsername(String userName) throws GeonetworkGaapClientException {
        for (User usr : users) {
            if (usr.getUsername().equals(userName)) return usr;
        }

        return null;
    }

    public List<User> getUsers() throws GeonetworkGaapClientException {

        return users;
    }

    public void createUser(User user) throws GeonetworkGaapClientException {
        users.add(user);
    }

    public void updateUser(User user) throws GeonetworkGaapClientException {
    for (User user2 : users) {
            if (user2.getUuid().equals(user.getUuid())) {
                users.remove(user2);
                users.remove(user);
                break;
            }
        }
    }

    public void deleteUser(String uuid) throws GeonetworkGaapClientException {
        for (User usr : users) {
            if (usr.getUuid().equals(uuid)) {
                users.remove(usr);
                break;
            }
        }
    }


    /*
     *  Groups
     */

    public Group getGroup(String uuid) throws GeonetworkGaapClientException {
        for (Group grp : groups) {
            if (grp.getUuid().equals(uuid)) return grp;
        }

        return null;
    }

    public List<Group> getGroups() throws GeonetworkGaapClientException {
        return groups;
    }

    public void createGroup(Group group) throws GeonetworkGaapClientException {
        groups.add(group);
    }

    public void updateGroup(Group group) throws GeonetworkGaapClientException {
        for (Group grp2 : groups) {
            if (grp2.getUuid().equals(group.getUuid())) {
                groups.remove(grp2);
                groups.remove(group);
                break;
            }
        }
    }

    public void deleteGroup(String uuid) throws GeonetworkGaapClientException {
        for (User usr : users) {
            if (usr.getUuid().equals(uuid)) {
                users.remove(usr);
                break;
            }
        }
    }

    /*
     *  Authenticate
     */
    public String authenticate(String username, String password) throws GeonetworkGaapClientException {
        return "da23sf234srfs435435";
    }

    public void logout(String username) throws GeonetworkGaapClientException {
        
    }


    /*
     *  Metadata
     */

    public Operation getOperation(String opName) throws GeonetworkGaapClientException {
        for (Operation op : operations) {
            if (op.getName().equals(opName)) return op;
        }

        return null;
    }

    public List<Operation> getOperations() throws GeonetworkGaapClientException {
        return operations;
    }

    public void updateOperation(Operation op) throws GeonetworkGaapClientException {
       for (Operation op2 : operations) {
            if (op2.getName().equals(op.getName())) {
                operations.remove(op2);
                operations.remove(op);
                break;
            }
        }
    }

    public MetadataPermissions getPermissions(String metadataUuid) throws GeonetworkGaapClientException {
        return null;
    }

    public void savePermissions(MetadataPermissions permissions) throws GeonetworkGaapClientException {

    }

    public void removeMetadataPermission(String metadaUuid, String groupUuid, String opName) throws GeonetworkGaapClientException {

    }

    public void saveMetadataPermission(String metadaUuid, String groupUuid, String opName) throws GeonetworkGaapClientException {

    }


    public List<String> filterMetadata(List<String> metadataUUids, String username) throws GeonetworkGaapClientException {
        return metadataUUids;
    }

    public List<String> filterMetadataByGroups(List<String> groupUUids) throws GeonetworkGaapClientException {
       return new ArrayList<String>();
    }

    public String getUserUuidByAuthToken() throws GeonetworkGaapClientException {
        return "admin";
    }

}
