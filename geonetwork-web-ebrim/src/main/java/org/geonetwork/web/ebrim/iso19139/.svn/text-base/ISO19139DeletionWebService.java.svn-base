package org.geonetwork.web.ebrim.iso19139;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.geonetwork.services.ebrim.iso19139.ISO19139Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class ISO19139InsertionWebService
 */
public class ISO19139DeletionWebService extends HttpServlet {

	private static Logger log = Logger.getLogger(ISO19139DeletionWebService.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		ServletContext servletContext = this.getServletConfig().getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		ISO19139Service iso19139Service = (ISO19139Service) wac.getBean("iso19139Service");
		try {
			String iso19139Id = IOUtils.toString(request.getInputStream());
			iso19139Service.delete(iso19139Id);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// response.getOutputStream().write(b, off, len)
		log.debug(" ------ISO19139DeletionWebService---------- hit! ----------------doGet-----------------");
		log.debug(" ------ISO19139DeletionWebService---------- hit! ---------------------------------");
		log.debug(" ------ISO19139DeletionWebService---------- hit! ---------------------------------");
		log.debug(" ------ISO19139DeletionWebService---------- hit! ---------------------------------");
		log.debug(" ------ISO19139DeletionWebService---------- hit! ---------------------------------");
		log.debug(" ------ISO19139DeletionWebService---------- hit! ---------------------------------");
		log.debug(" ------ISO19139DeletionWebService---------- hit! ---------------------------------");
		log.debug(" ------ISO19139DeletionWebService---------- hit! -----------------doGet----------------");

	}


}
