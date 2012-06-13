package org.geonetwork.gaap.domain.util;

import org.geonetwork.gaap.domain.web.request.*;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;

import java.util.List;
import java.util.ArrayList;

/**
 * Factory class for web request tests
 *
 * @author Jose
 */
public class RequestFactory {

    public static DeleteGroup createDeleteGroupRequest() {
        DeleteGroup request = new DeleteGroup();
        request.setGroupUuid("dddd-ssss-ffff-eeee");

        return request;
    }

    public static DeleteUser createDeleteUserRequest() {
        DeleteUser request = new DeleteUser();
        request.setUserUuid("dddd-ssss-ffff-eeee");

        return request;
    }

    public static GetGroup createGetGroupRequest() {
        GetGroup request = new GetGroup();
        request.setGroupUuid("dddd-ssss-ffff-eeee");

        return request;
    }

    public static GetUser createGetUserRequest() {
        GetUser request = new GetUser();
        request.setUserUuid("dddd-ssss-ffff-eeee");

        return request;
    }

    public static CreateGroup createCreateGroupRequest() {
        CreateGroup request = new CreateGroup();
        Group g = GroupFactory.create();

        request.setGroup(g);

        return request;
    }

    public static CreateUser createCreateUserRequest() {
        CreateUser request = new CreateUser();
        User u = UserFactory.create();

        request.setUser(u);

        return request;
    }

    public static FilterMetadata createFilterMetadataRequest() {
        FilterMetadata request = new FilterMetadata();
        request.setUserName("test-user");

        List<String> metadataUuids = new ArrayList<String>();
        metadataUuids.add("ddd-fff-saa-eee");
        metadataUuids.add("sss-khg-wfe-hgf");
        metadataUuids.add("jjj-fhf-ohg-nvh");

        request.setMetadataUuids(metadataUuids);

        return request;
    }

    public static SaveMetadataPermissions createSaveMetadataPermissionsRequest() {
        SaveMetadataPermissions request = new SaveMetadataPermissions();

        MetadataPermissions p = MetadataPermissionsFactory.create2();

        request.setPermissions(p);

        return request;
    }

    public static GetGroups createGetGroupsRequest() {
        GetGroups request = new GetGroups();

        request.setStartPosition(20);
        request.setPageSize(10);

        return request;
    }

    public static GetUsers createGetUsersRequest() {
        GetUsers request = new GetUsers();

        return request;
    }

    public static Authenticate createAuthenticateRequest() {
        Authenticate request = new Authenticate();

        request.setUserName("john");
        request.setPassword("password");

        return request;
    }


    public static GetMetadataPermissions createGetMetadataPermissionsRequest() {
        GetMetadataPermissions request = new GetMetadataPermissions();

        request.setMetadataUuid("dddd-ssss-ffff-eeee");

        return request;
    }
}
