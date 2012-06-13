package org.geonetwork.gaap.web.request;

import org.springframework.context.ApplicationContext;
import org.geonetwork.gaap.domain.web.request.GaapGetRequest;

/**
 * Gaap Get request factory
 *
 * @author Jose
 */
public class GetRequestFactory {

    public static BaseGetRequest getRequest(String requestName, ApplicationContext waco) {
        if (requestName.equalsIgnoreCase(GaapGetRequest.DELETEGROUP.toString())) {
            return new DeleteGroupRequest(waco, requestName);

        } else if (requestName.equalsIgnoreCase(GaapGetRequest.DELETEUSER.toString())) {
            return new DeleteUserRequest(waco, requestName);

        } else if (requestName.equalsIgnoreCase(GaapGetRequest.GETUSER.toString())) {
            return new GetUserRequest(waco, requestName);
            
        } else if (requestName.equalsIgnoreCase(GaapGetRequest.GETGROUP.toString())) {
            return new GetGroupRequest(waco, requestName);

        } else if (requestName.equalsIgnoreCase(GaapGetRequest.GETUSERS.toString())) {
            return new GetUsersRequest(waco, requestName);

        } else if (requestName.equalsIgnoreCase(GaapGetRequest.GETGROUPS.toString())) {
            return new GetGroupsRequest(waco, requestName);

        } else if (requestName.equalsIgnoreCase(GaapGetRequest.FILTERMETADATA.toString())) {
            return new FilterMetadataRequest(waco, requestName);

        } else if (requestName.equalsIgnoreCase(GaapGetRequest.AUTHENTICATION.toString())) {
            return new AuthenticationRequest(waco, requestName);
        } else {
           return new UnknownRequest(waco, requestName);
        }
    }
}
