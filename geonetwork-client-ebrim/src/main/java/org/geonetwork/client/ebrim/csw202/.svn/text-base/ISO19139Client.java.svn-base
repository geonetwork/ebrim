package org.geonetwork.client.ebrim.csw202;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class ISO19139Client {
	HttpClient client;
	PostMethod method;

	public final static String urlPropertyName = "geonetwork.ebrim.webapp.url";
	public final static String insertServletName = "/ISO19139InsertionWebService";
	public final static String deleteServletName = "/ISO19139DeletionWebService";
	public final static String defaultUrl = "http://localhost:8080/geonetwork-web-ebrim-3.0.0";
	

	public ISO19139Client() {
		// Create an instance of HttpClient.
		client = new HttpClient();
	}

	public void webInsert(InputStream isoDocumentInputStream) throws GeoNetworkClientException {
		String url = System.getProperties().getProperty(urlPropertyName) == null ? defaultUrl : System.getProperties()
				.getProperty(urlPropertyName);

		// complete the url with the servlet name which implements the webservice
		url = url + insertServletName;

		// Create a method instance.
		PostMethod method = new PostMethod(url);

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

		RequestEntity requestEntity = new InputStreamRequestEntity(isoDocumentInputStream);

		method.setRequestEntity(requestEntity);

		try {
			// Execute the method.
			int statusCode = client.executeMethod(method);

			if (statusCode != HttpStatus.SC_OK) {
				throw new GeoNetworkClientException("Method failed: " + method.getStatusLine());
			}

			// Read the response body.
			// byte[] responseBody = method.getResponseBody();

			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary data
			// System.out.println(new String(responseBody));

		} catch (HttpException e) {
			throw new GeoNetworkClientException(e);
		} catch (IOException e) {
			throw new GeoNetworkClientException(e);
		} finally {
			// Release the connection.
			method.releaseConnection();
		}
	}

	public void webDelete(String iso19139Id) throws GeoNetworkClientException {
		String url = System.getProperties().getProperty(urlPropertyName) == null ? defaultUrl : System.getProperties()
				.getProperty(urlPropertyName);

		// complete the url with the servlet name which implements the webservice
		url = url + deleteServletName;

		// Create a method instance.
		PostMethod method = new PostMethod(url);

		// Provide custom retry handler is necessary
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

		try {
			RequestEntity requestEntity = new StringRequestEntity(iso19139Id, null, null);

			method.setRequestEntity(requestEntity);

			// Execute the method.
			int statusCode = client.executeMethod(method);

			if (statusCode != HttpStatus.SC_OK) {
				throw new GeoNetworkClientException("Method failed: " + method.getStatusLine());
			}

			// Read the response body.
			// byte[] responseBody = method.getResponseBody();

			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary data
			// System.out.println(new String(responseBody));

		} catch (HttpException e) {
			throw new GeoNetworkClientException(e);
		} catch (IOException e) {
			throw new GeoNetworkClientException(e);
		} finally {
			// Release the connection.
			method.releaseConnection();
		}
	}

}
