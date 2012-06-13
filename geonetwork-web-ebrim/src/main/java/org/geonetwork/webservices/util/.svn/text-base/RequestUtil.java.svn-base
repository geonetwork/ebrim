package org.geonetwork.webservices.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Utility class to get parameters values in HttpServletRequest
 * using case insensitive parameters names
 *
 * @author Jose
 * 
 */
public class RequestUtil {
    /**
     * Gets a HttpServletRequest parameter value, using a case insensitive name
     *
     * @param request       HttpServletRequest
     * @param paramName     Name of the parameter
     * @return              Value of parameter, null for non valid parameter
     */
    public static String getParameter(HttpServletRequest request, String paramName) {
        Enumeration paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String name = (String) paramNames.nextElement();

            if (name.equalsIgnoreCase(paramName)) {
                return request.getParameter(name);
            }
        }

        return null;
    }
}