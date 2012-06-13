package org.geonetwork.gaap.web.request;

import org.springframework.context.ApplicationContext;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.PrintWriter;

/**
 * Unknown request
 *
 * @author Jose
 */
public class UnknownRequest extends BaseGetRequest {
    public UnknownRequest(ApplicationContext waco, String requestName) {
        super(waco, requestName);
    }

    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            PrintWriter out = response.getWriter();
            out.print("Unknown request");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
