package org.geonetwork.gaap.web.request;

import org.springframework.context.ApplicationContext;
import org.geonetwork.gaap.web.util.RequestUtil;
import org.geonetwork.gaap.web.ServiceName;
import org.geonetwork.gaap.services.GroupService;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.GetGroupResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;

/**
 * Get service to get a group
 *
 * @author Jose
 */
public class GetGroupRequest extends BaseGetRequest {

    public GetGroupRequest(ApplicationContext waco, String requestName) {
        super(waco, requestName);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        GetGroupResponse res = new GetGroupResponse();

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

        String groupUuid = RequestUtil.getParameter(request, UUID_PARAM);
        GroupService groupService = (GroupService) waco.getBean(ServiceName.GROUP_SERVICE);

        try {
            Group group = groupService.retrieveGroup(groupUuid);
            res.setGroup(group);

            outputResponse(res, response);

        } catch (Exception e) {
            res.setStatus(ResponseStatusCode.ERROR);
            res.setGroup(null);
            res.addException(e.getMessage());

            outputResponse(res, response);
        }
    }

    protected boolean validate(HttpServletRequest request, List<String> errors) {
        return super.validate(request, errors) && validateUuid(request, errors);
    }
}