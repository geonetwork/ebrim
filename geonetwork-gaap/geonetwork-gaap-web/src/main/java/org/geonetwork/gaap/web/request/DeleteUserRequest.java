package org.geonetwork.gaap.web.request;

import org.geonetwork.gaap.web.util.RequestUtil;
import org.geonetwork.gaap.web.ServiceName;
import org.geonetwork.gaap.services.UserService;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.DeleteUserResponse;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;

/**
 * Get service to delete a user
 *
 * @author Jose
 */
public class DeleteUserRequest extends BaseGetRequest {

    public DeleteUserRequest(ApplicationContext waco, String requestName) {
        super(waco, requestName);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        DeleteUserResponse rr = new DeleteUserResponse();
        rr.setStatus(ResponseStatusCode.OK);

         // Validate request
        List<String> errors = new ArrayList<String>();
        if (!validate(request, errors)) {
            rr.setStatus(ResponseStatusCode.ERROR);
            for(String error: errors) {
                rr.addException(error);
            }
            outputResponse(rr, response);
            return;
        }
        
        String userUuid = RequestUtil.getParameter(request, UUID_PARAM);
        UserService userService = (UserService) waco.getBean(ServiceName.USER_SERVICE);

        try {
            userService.deleteUser(userUuid);
            outputResponse(rr, response);

        } catch (Exception e) {
            rr.setStatus(ResponseStatusCode.ERROR);
            rr.addException(e.getMessage());
            outputResponse(rr, response);
        }
    }

    protected boolean validate(HttpServletRequest request, List<String> errors) {
        return  super.validate(request, errors) && validateUuid(request, errors);
    }
}
