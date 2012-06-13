package org.geonetwork.gaap.web;

import org.geonetwork.gaap.web.util.RequestUtil;
import org.geonetwork.gaap.web.request.GetRequestFactory;
import org.geonetwork.gaap.web.request.BaseGetRequest;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Gaap GET interface
 *
 * @author Jose
 */
public class GaapGetService extends HttpServlet {
    private static final String REQUEST_PARAM = "request";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedOperation = RequestUtil.getParameter(request, REQUEST_PARAM);

        ServletContext servletContext = this.getServletConfig().getServletContext();
        WebApplicationContext waco = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        BaseGetRequest getRequest = GetRequestFactory.getRequest(requestedOperation, waco);


        getRequest.exec(request, response);
    }
}
