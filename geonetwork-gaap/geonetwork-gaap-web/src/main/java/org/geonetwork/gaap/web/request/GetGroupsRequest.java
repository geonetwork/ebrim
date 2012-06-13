package org.geonetwork.gaap.web.request;

import org.springframework.context.ApplicationContext;
import org.geonetwork.gaap.services.GroupService;
import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.web.response.GetGroupsResponse;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.web.ServiceName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.List;

/**
 * Get service to get all groups
 *
 * @author Jose
 */
public class GetGroupsRequest extends BaseGetRequest {

    public GetGroupsRequest(ApplicationContext waco, String requestName) {
        super(waco, requestName);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        GroupService groupService = (GroupService) waco.getBean(ServiceName.GROUP_SERVICE);
        GetGroupsResponse res = new GetGroupsResponse();

        try {
            List<Group> groups = groupService.retrieveAllGroups();
            res.setGroups(groups);

            outputResponse(res, response);

        } catch (Exception e) {
            GetGroupsResponse er = new GetGroupsResponse();
            er.setStatus(ResponseStatusCode.ERROR);
            er.addException(e.getMessage());
            outputResponse(er, response);

            res.setStatus(ResponseStatusCode.ERROR);
            res.addException(e.getMessage());
            res.setGroups(null);

            outputResponse(res, response);
        }
    }
}