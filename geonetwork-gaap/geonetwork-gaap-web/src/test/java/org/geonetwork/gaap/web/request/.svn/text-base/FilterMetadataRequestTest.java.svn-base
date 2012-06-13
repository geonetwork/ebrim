package org.geonetwork.gaap.web.request;

import org.geonetwork.gaap.domain.web.response.FilterMetadataResponse;
import org.geonetwork.gaap.domain.web.response.ResponseStatusCode;
import org.geonetwork.gaap.domain.user.User;
import org.geonetwork.gaap.domain.util.UserFactory;
import org.geonetwork.gaap.domain.util.OperationFactory;
import org.geonetwork.gaap.domain.operation.Operation;
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
 * Tests for FilterMetadataRequest
 *
 * @author Jose
 */
public class FilterMetadataRequestTest extends AbstractWebTest {

    @Test
    public void testExec() {
        try {
            ApplicationContext waco = getApplicationContext();
            FilterMetadataRequest req = new FilterMetadataRequest(waco, "filtermetadata");

            // Invalid request 1
            MockHttpServletRequest httpRequest = new MockHttpServletRequest();
            MockHttpServletResponse httpResponse = new MockHttpServletResponse();

            req.exec(httpRequest, httpResponse);
            InputStream fis = new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // create JiBX unmarshal context
            IBindingFactory bfact = BindingDirectory.getFactory(FilterMetadataResponse.class);
            IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

            // unmarshal to FilterMetadataResponse
            FilterMetadataResponse unMarshallingResult = (FilterMetadataResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.ERROR, unMarshallingResult.getStatus());

            // Invalid request 2
            httpRequest = new MockHttpServletRequest();
            httpResponse = new MockHttpServletResponse();

            httpRequest.setParameter("userName", "dddddddd");
            req.exec(httpRequest, httpResponse);
            fis = new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // unmarshal to FilterMetadataResponse
            unMarshallingResult = (FilterMetadataResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.ERROR, unMarshallingResult.getStatus());


            // Valid request
            User user = UserFactory.create();
            user.setUsername("dddddddd");
            user.setPassword("sdfsdfdsf");
            getUserDao().saveUser(user);

            Operation op = OperationFactory.create();
            op.setName("view");
            getOperationDao().saveOperation(op);


            httpRequest = new MockHttpServletRequest();
            httpResponse = new MockHttpServletResponse();

            httpRequest.setParameter("metadataUuids", "dddddddd");
            httpRequest.setParameter("userName", "dddddddd");
            req.exec(httpRequest, httpResponse);
            fis = new ByteArrayInputStream(httpResponse.getContentAsByteArray());

            // unmarshal to FilterMetadataResponse
            unMarshallingResult = (FilterMetadataResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

            assertEquals(ResponseStatusCode.OK, unMarshallingResult.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}