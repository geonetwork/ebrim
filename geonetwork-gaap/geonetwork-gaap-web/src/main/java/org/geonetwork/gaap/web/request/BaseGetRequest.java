package org.geonetwork.gaap.web.request;

import org.springframework.context.ApplicationContext;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IMarshallingContext;
import org.apache.commons.lang.StringUtils;
import org.geonetwork.gaap.web.util.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Interface implemented by Get Gaap requests
 *
 * @author Jose
 */
public abstract class BaseGetRequest {
    public static final String UUID_PARAM = "uuid";

    protected ApplicationContext waco;
    protected String requestName;

    public BaseGetRequest(ApplicationContext waco, String requestName) {
        this.waco = waco;
        this.requestName = requestName;
    }

    /**
     * Method to implement by requests
     *
     * @param request               HttpServletRequest
     * @param response              HttpServletResponse
     * @throws ServletException
     */
    public abstract void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException;

    /**
     * Outputs the jibx xml mashalling of an object
     *
     * @param er                    Object to marshall
     * @param response              HttpServletResponse to output the xml
     * @throws ServletException
     */
    protected void outputResponse(Object er, HttpServletResponse response) throws ServletException {
        try {
            IBindingFactory bfact = BindingDirectory.getFactory(er.getClass());
            IMarshallingContext marshallingContext = bfact.createMarshallingContext();

            // marshal to servlet response outputstream
            response.setContentType("application/xml");
            Writer writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            marshallingContext.setIndent(3);
            marshallingContext.setOutput(writer);
            marshallingContext.marshalDocument(er, "UTF-8", null);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    /**
     * Method to validate request parameters. Default implementation
     *
     * @param request               HttpServletRequest
     * @param errors                List of errors
     * @throws ServletException
     */
    protected boolean validate(HttpServletRequest request, List<String> errors) {
        return true;
    }

    /**
     * Validation for UUID param
     *
     * @param request               HttpServletRequest
     * @param errors                List of errors
     * @return
     */
    protected boolean validateUuid(HttpServletRequest request, List<String> errors) {
        if (StringUtils.isEmpty(RequestUtil.getParameter(request, UUID_PARAM))) {
            errors.add("Param uuid is required.");

            return false;
        }

        return true;
    }
}
