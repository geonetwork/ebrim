package org.geonetwork.gaap.web.request;

import org.geonetwork.gaap.web.util.RequestUtil;
import org.geonetwork.gaap.web.ServiceName;
import org.geonetwork.gaap.services.UserService;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.GetUserResponse;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;

/**
 * Get service to get a user
 *
 * @author Jose
 */
public class GetUserRequest extends BaseGetRequest {
    public GetUserRequest(ApplicationContext waco, String requestName) {
        super(waco, requestName);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        GetUserResponse res = new GetUserResponse();

        // Validate request
        List<String> errors = new ArrayList<String>();
        if (!validate(request, errors)) {
            res.setStatus(ResponseStatusCode.ERROR);
            for (String error : errors) {
                res.addException(error);
            }
            outputResponse(res, response);
            return;
        }
        
        String userUuid = RequestUtil.getParameter(request, UUID_PARAM);
        UserService userService = (UserService) waco.getBean(ServiceName.USER_SERVICE);

        try {
            User user = userService.retrieveUser(userUuid);
            res.setUser(user);

            outputResponse(res, response);

        } catch (Exception e) {
            res.setStatus(ResponseStatusCode.ERROR);
            res.setUser(null);
            res.addException(e.getMessage());

            outputResponse(res, response);
        }
    }

    protected boolean validate(HttpServletRequest request, List<String> errors) {
        return super.validate(request, errors) && validateUuid(request, errors);
    }
}
