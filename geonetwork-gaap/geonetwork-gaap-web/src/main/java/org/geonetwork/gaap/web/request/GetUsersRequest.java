package org.geonetwork.gaap.web.request;

import org.springframework.context.ApplicationContext;
import org.geonetwork.gaap.services.UserService;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.GetUsersResponse;
import org.geonetwork.gaap.web.ServiceName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.List;

/**
 * Get service to get all users
 *
 * @author Jose
 */
public class GetUsersRequest extends BaseGetRequest {

    public GetUsersRequest(ApplicationContext waco, String requestName) {
        super(waco, requestName);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        UserService userService = (UserService) waco.getBean(ServiceName.USER_SERVICE);
        GetUsersResponse res = new GetUsersResponse();

        try {
            List<User> users = userService.retrieveAllUsers();
            res.setUsers(users);

            outputResponse(res, response);

        } catch (Exception e) {
            res.setStatus(ResponseStatusCode.ERROR);
            res.addException(e.getMessage());
            res.setUsers(null);
            
            outputResponse(res, response);
        }
    }
}
