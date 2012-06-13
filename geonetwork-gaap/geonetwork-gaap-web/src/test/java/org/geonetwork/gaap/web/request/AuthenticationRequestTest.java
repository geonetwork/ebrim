package org.geonetwork.gaap.web.request;

import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.AuthenticationResponse;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.util.UserFactory;
import org.geonetwork.gaap.web.AbstractWebTest;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Tests for AuthenticationRequest
 *
 * @author Jose
 */
public class AuthenticationRequestTest extends AbstractWebTest {

    @Test
    public void testExec() {
        try {
            ApplicationContext waco = getApplicationContext();
            AuthenticationRequest req = new AuthenticationRequest(waco, "authentication");

            // Invalid request 1
            MockHttpServletRequest httpRequest = new MockHttpServletRequest();
            MockHttpServletResponse httpResponse = new MockHttpServletResponse();

            httpRequest.setParameter("userName", "dddddddd");

            req.exec(httpRequest, httpResponse);
            InputStream fis = new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(AuthenticationResponse.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to AuthenticationResponse
            AuthenticationResponse unMarshallingResult = (AuthenticationResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.ERROR, unMarshallingResult.getStatus());


            // Invalid request 2
            httpRequest = new MockHttpServletRequest();
            httpResponse = new MockHttpServletResponse();

            httpRequest.setParameter("password", "sdfsdfdsf");
            req.exec(httpRequest, httpResponse);
            fis = new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // unmarshal to AuthenticationResponse
            unMarshallingResult = (AuthenticationResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.ERROR, unMarshallingResult.getStatus());

            
            // Invalid request 3
            httpRequest = new MockHttpServletRequest();
            httpResponse = new MockHttpServletResponse();

            req.exec(httpRequest, httpResponse);
            fis = new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // unmarshal to AuthenticationResponse
            unMarshallingResult = (AuthenticationResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.ERROR, unMarshallingResult.getStatus());


            // Valid request (non existent user)
            httpRequest = new MockHttpServletRequest();
            httpResponse = new MockHttpServletResponse();

            httpRequest.setParameter("userName", "dddddddd");
            httpRequest.setParameter("password", "sdfsdfdsf");
            req.exec(httpRequest, httpResponse);
            fis = new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // unmarshal to AuthenticationResponse
            unMarshallingResult = (AuthenticationResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.ERROR, unMarshallingResult.getStatus());


            // Valid request (existent user)
            User user = UserFactory.create();
            user.setUsername("dddddddd");
            user.setPassword(scramble("sdfsdfdsf"));
            getUserDao().saveUser(user);

            httpRequest = new MockHttpServletRequest();
            httpResponse = new MockHttpServletResponse();

            httpRequest.setParameter("userName", "dddddddd");
            httpRequest.setParameter("password", "sdfsdfdsf");
            req.exec(httpRequest, httpResponse);
            fis = new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // unmarshal to AuthenticationResponse
            unMarshallingResult = (AuthenticationResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.OK, unMarshallingResult.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Calculates SHA-1 encryption of a text
     *
     * @param text
     * @return
     */
    private static String scramble(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            md.update(text.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();

            for (byte b : md.digest())
                sb.append(Integer.toString(b & 0xFF, 16));

            return sb.toString();
        }
        catch (UnsupportedEncodingException e) {
            return null;
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}