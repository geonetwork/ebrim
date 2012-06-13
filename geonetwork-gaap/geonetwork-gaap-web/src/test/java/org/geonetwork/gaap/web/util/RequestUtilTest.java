package org.geonetwork.gaap.web.util;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Tests for RequestUtil
 *
 * @author Jose
 */
public class RequestUtilTest extends TestCase {

    @Test
    public void testGetParameter() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        req.setParameter("uuid", "sdss-fddd-sdfd");
        req.setParameter("Request", "deletegroup");

        String value = RequestUtil.getParameter(req,  "uuid");
        assertEquals("sdss-fddd-sdfd", value);

        value = RequestUtil.getParameter(req,  "UUID");
        assertEquals("sdss-fddd-sdfd", value);

        value = RequestUtil.getParameter(req,  "Request");
        assertEquals("deletegroup", value);

        value = RequestUtil.getParameter(req,  "reQueSt");
        assertEquals("deletegroup", value);


        value = RequestUtil.getParameter(req,  "request1");
        assertNull(value);
    }
}
