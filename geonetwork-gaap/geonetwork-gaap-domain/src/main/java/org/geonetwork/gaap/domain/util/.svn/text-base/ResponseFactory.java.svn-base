package org.geonetwork.gaap.domain.util;

import org.geonetwork.gaap.domain.web.response.*;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;
import org.geonetwork.gaap.domain.operation.Permission;
import org.geonetwork.gaap.domain.operation.Operation;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Factory class for web response tests
 *
 * @author Jose
 */
public class ResponseFactory {

    public static GetGroupResponse createGetGroupResponse() {
        GetGroupResponse response = new GetGroupResponse();

        Group g = GroupFactory.create();

        response.setGroup(g);

        return response;
    }

    public static GetUserResponse createGetUserResponse() {
        GetUserResponse response = new GetUserResponse();

        User u = UserFactory.create();

        response.setUser(u);

        return response;
    }

    public static FilterMetadataResponse createFilterMetadataResponse() {
        FilterMetadataResponse response = new FilterMetadataResponse();

        List<String> metadataUuids = new ArrayList<String>();
        metadataUuids.add("ddd-fff-saa-eee");
        metadataUuids.add("jjj-fhf-ohg-nvh");

        response.setMetadataUuids(metadataUuids);

        return response;
    }

    public static GetGroupsResponse createGetGroupsResponse() {
        GetGroupsResponse response = new GetGroupsResponse();
        List<Group> groups = GroupFactory.createList();

        response.setNextPosition(0);
        response.setGroups(groups);

        return response;
    }

    public static GetUsersResponse createGetUsersResponse() {
        GetUsersResponse response = new GetUsersResponse();
        List<User> users = UserFactory.createList();

        response.setNextPosition(0);
        response.setUsers(users);

        return response;
    }

    public static AuthenticationResponse createAuthenticationResponse() {
        AuthenticationResponse response = new AuthenticationResponse();
        String authToken = "dafh3ab434c4cc654bhe9a";

        response.setAuthenticationToken(authToken);

        return response;
    }

    public static GetMetadataPermissionsResponse createGetMetadataPermissionsResponse() {
        GetMetadataPermissionsResponse response = new GetMetadataPermissionsResponse();

        MetadataPermissions metadataPermissions = new MetadataPermissions();
        metadataPermissions.setMetadataUuid("aaa-bbb-ccc-ddd");

        Group g1 = new Group();
        g1.setUuid("g1");

        Group g2 = new Group();
        g2.setUuid("g2");

        Operation op1 = new Operation();
        op1.setName("view");

        Set<Permission> permissions = new HashSet<Permission>();
        Permission p = new Permission();
        p.setGroup(g1);
        p.setOperation(op1);

        permissions.add(p);

        p = new Permission();
        p.setGroup(g2);
        p.setOperation(op1);

        permissions.add(p);

        metadataPermissions.setPermissions(permissions);

        response.setMetadataPermissions(metadataPermissions);

        return response;

    }
}