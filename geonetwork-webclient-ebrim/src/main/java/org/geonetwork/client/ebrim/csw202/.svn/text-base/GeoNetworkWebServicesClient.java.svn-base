package org.geonetwork.client.ebrim.csw202;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * EbRim web services client to send GetRecords request to an ebRim server
 *
 * @author Jose
 */
public class GeoNetworkWebServicesClient {
    private HttpClient client;
    private String ebRimUrl;

    private final static String defaultUrl = "http://localhost/geonetwork-web-ebrim/";
    private final static String servicePath = "services/csw/GetRecords";


    public GeoNetworkWebServicesClient() throws IOException {
        // Create an instance of HttpClient.
        client = new HttpClient();

        try {
            // Read ebRim server url from properties. If not configured the url parameter
            // or file don't exists, use default
            Properties prop = getPropertiesFromClasspath("app.properties");

            String url = prop.getProperty("url");
            if (url == null) {
                ebRimUrl = defaultUrl + servicePath;
            } else {
                if (!url.endsWith("/")) url = url + "/";
                ebRimUrl = url + servicePath;
            }
        } catch (FileNotFoundException e) {
            ebRimUrl = defaultUrl + servicePath;
        }
    }

    public void execRequest(InputStream request) throws GeoNetworkWebServicesClientException {

        System.out.println("EbRim services url: " + ebRimUrl);

        // Create a method instance.
        PostMethod method = new PostMethod(ebRimUrl);
        Header requestHeader = new Header();
        requestHeader.setName("content-type");
        requestHeader.setValue("application/xml");
        method.addRequestHeader(requestHeader);

        // Provide custom retry handler is necessary
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

        RequestEntity requestEntity = new InputStreamRequestEntity(request);

        method.setRequestEntity(requestEntity);

        try {
            // Execute the method.
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                throw new GeoNetworkWebServicesClientException("Method failed: " + method.getStatusLine());
            }

            // Read the response body.
            byte[] responseBody = method.getResponseBody();

            // Deal with the response.
            // Use caution: ensure correct character encoding and is not binary data
            System.out.println("GeoNetworkWebServicesClient (response): " + new String(responseBody));

        } catch (HttpException e) {
            throw new GeoNetworkWebServicesClientException(e);
        } catch (IOException e) {
            throw new GeoNetworkWebServicesClientException(e);
        } finally {
            // Release the connection.
            method.releaseConnection();
        }
    }

    private Properties getPropertiesFromClasspath(String propFileName) throws IOException {
        // loading xmlProfileGen.properties from the classpath
        Properties props = new Properties();
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream(propFileName);

        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + propFileName
                    + "' not found in the classpath");
        }

        props.load(inputStream);

        return props;
    }

    public static void main(String args[]) {
        try {
            if ((args.length == 1) && (args[0].equals("-h")) || (args.length > 1)) {
                System.out.println("usage: \n" +
                        "\tWebServicesClient folder\n\n" +
                        "\tfolder: folder path with GetRecords xml files");
                System.exit(1);
            }

            String folder = "src/main/resources/";
            if (args.length == 1) {
                folder = args[0];
            }
            if (!folder.endsWith("/")) folder = folder + "/";

            String[] fileNames = FileUtil.getFilesfromDir(folder, "xml");

            GeoNetworkWebServicesClient webServicesClient = new GeoNetworkWebServicesClient();

            for (int i = 0; i < fileNames.length; i++) {
                InputStream inputStream = null;
                try {
                    System.out.println("Processing file: " + folder + fileNames[i] + "\n");

                    inputStream = new FileInputStream(folder + fileNames[i]);
                    webServicesClient.execRequest(inputStream);

                    System.out.println("End Processing file: " + folder + fileNames[i]);
                    System.out.println("------------------------------------------------------\n");

                } finally {
                    if (inputStream != null) inputStream.close();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
