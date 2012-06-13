package org.geonetwork.gaap.web.request;

import org.springframework.context.ApplicationContext;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.AuthenticationResponse;
import org.geonetwork.gaap.web.util.RequestUtil;
import org.geonetwork.gaap.web.ServiceName;
import org.geonetwork.gaap.services.AuthenticationService;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;

/**
 * Get service to authenticate users
 *
 * @author Jose
 */
public class AuthenticationRequest extends BaseGetRequest {
    private static final String USERNAME_PARAM = "username";
    private static final String PASSWORD_PARAM = "password";

    public AuthenticationRequest(ApplicationContext waco, String requestName) {
        super(waco, requestName);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        AuthenticationResponse res = new AuthenticationResponse();

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

        String userName = RequestUtil.getParameter(request, USERNAME_PARAM);
        String password = RequestUtil.getParameter(request, PASSWORD_PARAM);

        AuthenticationService authenticationService = (AuthenticationService) waco.getBean(ServiceName.AUTHENTICATION_SERVICE);

        try {
            String authToken = authenticationService.authenticate(userName, password);

            res.setAuthenticationToken(authToken);
            outputResponse(res, response);

        } catch (Exception e) {
            res.setStatus(ResponseStatusCode.ERROR);
            res.addException(e.getMessage());
            outputResponse(res, response);
        }
    }

    protected boolean validate(HttpServletRequest request, List<String> errors) {
        if (super.validate(request, errors)) {
            String userName = RequestUtil.getParameter(request, USERNAME_PARAM);
            String password = RequestUtil.getParameter(request, PASSWORD_PARAM);

            if (StringUtils.isEmpty(userName)) {
                errors.add("Username param is required.");

                return false;
            }

            if (StringUtils.isEmpty(password)) {
                errors.add("Password paramis required.");

                return false;
            }

            return true;
        } else {
            return false;
        }
    }
}
