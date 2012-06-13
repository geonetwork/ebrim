//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================
package org.geonetwork.search.ebrim.filter;

import junit.framework.TestCase;
import org.junit.Test;
import org.geonetwork.search.ebrim.filter.queryfields.Field;
import org.geonetwork.search.ebrim.filter.queryfields.FieldMapper;

/**
 * Tests for SimplePropertyResolver class
 *
 * @author Jose
 *
 */
public class SimplePropertyResolverTest extends TestCase {
    private FieldMapper fldMapper;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        fldMapper = new FieldMapper();
    }

    @Test
    public void testResolverProperty() {
        SimplePropertyResolver propertyResolver;
        
        // Test property title
        String property = "title";

        assertNotNull(fldMapper.findField(property));

        String expectedResult = fldMapper.findField(property).getFieldName();
        propertyResolver = new SimplePropertyResolver(property);

        Field fld = propertyResolver.resolveProperty("");
        assertEquals(expectedResult, fld.getFieldName());

        // Test non valid property
        property = "nonvalid";
        propertyResolver = new SimplePropertyResolver(property);

        fld = propertyResolver.resolveProperty("");
        assertNull(fld);

    }
}