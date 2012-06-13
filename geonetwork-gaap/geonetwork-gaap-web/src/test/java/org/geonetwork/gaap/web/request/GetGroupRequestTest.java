package org.geonetwork.gaap.web.request;

import org.geonetwork.gaap.web.AbstractWebTest;
import org.geonetwork.gaap.domain.web.response.GetGroupResponse;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IUnmarshallingContext;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

/**
 * Tests for GetGroupRequest
 *
 * @author Jose
 */
public class GetGroupRequestTest extends AbstractWebTest {

    @Test
    public void testExec() {       
        try {
            ApplicationContext waco = getApplicationContext();
            GetGroupRequest req = new GetGroupRequest(waco, "getgroup");

            // Invalid request
            MockHttpServletRequest httpRequest = new MockHttpServletRequest();
            MockHttpServletResponse httpResponse = new MockHttpServletResponse();

            req.exec(httpRequest, httpResponse);
            InputStream fis =  new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(GetGroupResponse.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to GetGroupResponse
            GetGroupResponse unMarshallingResult = (GetGroupResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.ERROR, unMarshallingResult.getStatus());

            
            // Valid request
            httpRequest = new MockHttpServletRequest();
            httpResponse = new MockHttpServletResponse();

            httpRequest.setParameter("uuid", "dddddddd");
            req.exec(httpRequest, httpResponse);
            fis =  new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // unmarshal to GetGroupResponse
            unMarshallingResult = (GetGroupResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.OK, unMarshallingResult.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
