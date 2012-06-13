package org.geonetwork.search.ebrim.filter;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Tests for PropertyResolverFactory class
 */
public class PropertyResolverFactoryTest extends TestCase {

    @Test
    public void testGetPropertyResolver() {
        PropertyResolver pr = PropertyResolverFactory.getPropertyResolver("wrs:Dataset/@id");
        assertEquals(XPathPropertyResolver.class, pr.getClass());

        pr = PropertyResolverFactory.getPropertyResolver("/wrs:Dataset/@id");
        assertEquals(XPathPropertyResolver.class, pr.getClass());

        pr = PropertyResolverFactory.getPropertyResolver("title");
        assertEquals(SimplePropertyResolver.class, pr.getClass());
    }
}
