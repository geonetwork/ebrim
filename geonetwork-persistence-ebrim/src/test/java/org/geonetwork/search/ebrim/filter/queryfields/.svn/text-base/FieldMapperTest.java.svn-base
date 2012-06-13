package org.geonetwork.search.ebrim.filter.queryfields;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Tests for FieldMapper class
 */
public class FieldMapperTest extends TestCase {
    @Test
    public void testGetField() {
        FieldMapper fldMapper = new FieldMapper();

        // Get an existent field
        Field fld = fldMapper.findField("title");
        assertNotNull(fld);

        // Try to get a non existent field
        fld = fldMapper.findField("xxxxx");
        assertNull(fld);
    }

}
