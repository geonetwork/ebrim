package org.geonetwork.web.ebrim.iso19139;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.geonetwork.services.ebrim.iso19139.ISO19139Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class ISO19139InsertionWebService
 */
public class ISO19139InsertionWebService extends HttpServlet {

    private static Logger log = Logger.getLogger(ISO19139InsertionWebService.class);
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        ServletContext servletContext = this.getServletConfig().getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        ISO19139Service iso19139Service = (ISO19139Service) wac.getBean("iso19139Service");
        try {
            iso19139Service.insert(getUTFInputStream(request.getInputStream()));
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // response.getOutputStream().write(b, off, len)
        log.debug(" ------ISO19139InsertionWebService---------- hit! ----------------doGet-----------------");
        log.debug(" ------ISO19139InsertionWebService---------- hit! ---------------------------------");
        log.debug(" ------ISO19139InsertionWebService---------- hit! ---------------------------------");
        log.debug(" ------ISO19139InsertionWebService---------- hit! ---------------------------------");
        log.debug(" ------ISO19139InsertionWebService---------- hit! ---------------------------------");
        log.debug(" ------ISO19139InsertionWebService---------- hit! ---------------------------------");
        log.debug(" ------ISO19139InsertionWebService---------- hit! ---------------------------------");
        log.debug(" ------ISO19139InsertionWebService---------- hit! -----------------doGet----------------");

    }


    private InputStream getUTFInputStream(InputStream is) throws Exception {
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        StringBuilder content = new StringBuilder();

        char[] buffer = new char[4 * 1024];
        int n = 0;
        while (n >= 0) {
            n = isr.read(buffer, 0, buffer.length);
            if (n > 0) {
                content.append(buffer, 0, n);
            }
        }

        byte currentXMLBytes[] = content.toString().getBytes("UTF-8");
        return new ByteArrayInputStream(currentXMLBytes);
    }

}
