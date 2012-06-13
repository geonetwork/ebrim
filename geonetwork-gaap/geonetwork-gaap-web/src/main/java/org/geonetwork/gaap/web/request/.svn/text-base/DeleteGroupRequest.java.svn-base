package org.geonetwork.gaap.web.request;

import org.geonetwork.gaap.web.util.RequestUtil;
import org.geonetwork.gaap.web.ServiceName;
import org.geonetwork.gaap.services.GroupService;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.DeleteGroupResponse;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;

/**
 * Get service to delete a group
 *
 * @author Jose
 */
public class DeleteGroupRequest extends BaseGetRequest {

    public DeleteGroupRequest(ApplicationContext waco, String requestName) {
        super(waco, requestName);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        DeleteGroupResponse rr = new DeleteGroupResponse();
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

        String groupUuid = RequestUtil.getParameter(request, UUID_PARAM);
        GroupService groupService = (GroupService) waco.getBean(ServiceName.GROUP_SERVICE);

        try {
            groupService.deleteGroup(groupUuid);
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
