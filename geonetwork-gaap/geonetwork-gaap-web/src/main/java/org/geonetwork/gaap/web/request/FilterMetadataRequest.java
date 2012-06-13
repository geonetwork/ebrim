package org.geonetwork.gaap.web.request;

import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.FilterMetadataResponse;
import org.geonetwork.gaap.web.util.RequestUtil;
import org.geonetwork.gaap.web.ServiceName;
import org.geonetwork.gaap.services.MetadataPermissionsService;
import org.springframework.context.ApplicationContext;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Get service to filter metadata allowed to a user
 *
 * @author Jose
 */
public class FilterMetadataRequest extends BaseGetRequest {
    private static final String USERNAME_PARAM = "userName";
    private static final String METADATAUUIDS_PARAM = "metadataUuids";

    public FilterMetadataRequest(ApplicationContext waco, String requestName) {
        super(waco, requestName);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        FilterMetadataResponse res = new FilterMetadataResponse();

         // Validate request
        List<String> errors = new ArrayList<String>();
        if (!validate(request, errors)) {
            res.setStatus(ResponseStatusCode.ERROR);
            for(String error: errors) {
                res.addException(error);
            }
            outputResponse(res, response);
            return;
        }

        String uuids = RequestUtil.getParameter(request, METADATAUUIDS_PARAM);
        List<String> metadataUuids = Arrays.asList(uuids.split(","));

        String userName = RequestUtil.getParameter(request, USERNAME_PARAM);

        MetadataPermissionsService metadataPermissionsService = (MetadataPermissionsService) waco.getBean(ServiceName.METADATA_SERVICE);

        try {
            List<String> filteredMetadataUuids = metadataPermissionsService.filterMetadata(metadataUuids, userName);
            res.setMetadataUuids(filteredMetadataUuids);

            outputResponse(res, response);

        } catch (Exception e) {
            res.setStatus(ResponseStatusCode.ERROR);
            res.addException(e.getMessage());
            outputResponse(res, response);
        }
    }

      protected boolean validate(HttpServletRequest request, List<String> errors) {
        if (!super.validate(request, errors)) return false;

        if (StringUtils.isEmpty(RequestUtil.getParameter(request, METADATAUUIDS_PARAM))) {
            errors.add("Param metadataUuids is required.");

            return false;
        }

        return true;
    }
}
