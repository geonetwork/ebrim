package org.geonetwork.gaap.web.request;


import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.web.response.DeleteGroupResponse;
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

/**
 * Tests for GetGroupRequest
 *
 * @author Jose
 */
public class DeleteGroupRequestTest extends AbstractWebTest {

    @Test
    public void testExec() {
        try {
            ApplicationContext waco = getApplicationContext();
            DeleteGroupRequest req = new DeleteGroupRequest(waco, "deletegroup");

            // Invalid request
            MockHttpServletRequest httpRequest = new MockHttpServletRequest();
            MockHttpServletResponse httpResponse = new MockHttpServletResponse();

            req.exec(httpRequest, httpResponse);
            InputStream fis =  new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(DeleteGroupResponse.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to DeleteGroupResponse
            DeleteGroupResponse unMarshallingResult = (DeleteGroupResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.ERROR, unMarshallingResult.getStatus());


            // Valid request
            httpRequest = new MockHttpServletRequest();
            httpResponse = new MockHttpServletResponse();

            httpRequest.setParameter("uuid", "dddddddd");
            req.exec(httpRequest, httpResponse);
            fis =  new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // unmarshal to ResponseReport
            unMarshallingResult = (DeleteGroupResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.OK, unMarshallingResult.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}