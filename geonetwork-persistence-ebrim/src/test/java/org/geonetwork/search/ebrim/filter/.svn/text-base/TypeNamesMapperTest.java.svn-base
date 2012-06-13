package org.geonetwork.search.ebrim.filter;

import junit.framework.TestCase;
import org.junit.Test;
import org.geonetwork.domain.ebrim.informationmodel.service.Service;

/**
 * Tests for class TypeNamesMapper
 */
public class TypeNamesMapperTest extends TestCase {

    @Test
    public void testTypeNamesMapper() {
        // Test a non valid typeName
        Class<?> classz = TypeNamesMapper.getTypeNameClass("xxxxx");
        assertNull(classz);

        classz = TypeNamesMapper.getTypeNameClass("rim:Service");
        assertEquals(classz, Service.class);
    }
}
