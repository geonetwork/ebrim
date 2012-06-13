package org.geonetwork.gaap.web.request;

import org.junit.Test;
import org.geonetwork.gaap.domain.web.request.GaapGetRequest;
import junit.framework.TestCase;

/**
 * Tests for GetRequestFactory
 *
 * @author Jose
 */
public class GetRequestFactoryTest extends TestCase {

    @Test
    public void testGetRequest() {

        BaseGetRequest req = GetRequestFactory.getRequest(GaapGetRequest.DELETEGROUP.toString(), null);
        assertTrue(req instanceof DeleteGroupRequest);

        req = GetRequestFactory.getRequest(GaapGetRequest.AUTHENTICATION.toString(), null);
        assertTrue(req instanceof AuthenticationRequest);

        req = GetRequestFactory.getRequest(GaapGetRequest.DELETEUSER.toString(), null);
        assertTrue(req instanceof DeleteUserRequest);

        req = GetRequestFactory.getRequest(GaapGetRequest.FILTERMETADATA.toString(), null);
        assertTrue(req instanceof FilterMetadataRequest);

        req = GetRequestFactory.getRequest(GaapGetRequest.GETGROUP.toString(), null);
        assertTrue(req instanceof GetGroupRequest);

        req = GetRequestFactory.getRequest(GaapGetRequest.GETGROUPS.toString(), null);
        assertTrue(req instanceof GetGroupsRequest);

        req = GetRequestFactory.getRequest(GaapGetRequest.GETGROUPS.toString(), null);
        assertTrue(req instanceof GetGroupsRequest);

        req = GetRequestFactory.getRequest(GaapGetRequest.GETUSER.toString(), null);
        assertTrue(req instanceof GetUserRequest);

        req = GetRequestFactory.getRequest(GaapGetRequest.GETUSERS.toString(), null);
        assertTrue(req instanceof GetUsersRequest);

        req = GetRequestFactory.getRequest("other", null);
        assertTrue(req instanceof UnknownRequest);
    }
}
