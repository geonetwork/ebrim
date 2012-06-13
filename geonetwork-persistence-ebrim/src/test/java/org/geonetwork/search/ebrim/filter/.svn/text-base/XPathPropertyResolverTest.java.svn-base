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

/**
 * Tests for XPathPropertyResolver class
 *
 * @author Jose
 *
 */
public class XPathPropertyResolverTest extends TestCase {
    @Test
    public void testResolverProperty() {
        XPathPropertyResolver propertyResolver;
        
        // Test property attribute
        String property = "@associationType";
        String expectedResult = "associationType.value";
        propertyResolver = new XPathPropertyResolver(property);

        Field fld = propertyResolver.resolveProperty("rim:Association");
        assertEquals(expectedResult, fld.getFieldName());

        // Test property attribute
        property = "rim:Association/@associationType";
        expectedResult = "associationsSet.associationType.value";
        propertyResolver = new XPathPropertyResolver(property);

        fld = propertyResolver.resolveProperty("rim:ExtrinsicObject");
        assertEquals(expectedResult, fld.getFieldName());

        // Test property
        property = "@timestamp";
        expectedResult = "timestamp.value";
        propertyResolver = new XPathPropertyResolver(property);

        fld = propertyResolver.resolveProperty("rim:AuditableEvent");
        assertEquals(expectedResult, fld.getFieldName());

        // Test property
        property = "rim:Association/@targetObject";
        expectedResult = "associationsSet.targetObject.value";
        propertyResolver = new XPathPropertyResolver(property);

        fld = propertyResolver.resolveProperty("rim:RegistryObject");
        assertEquals(expectedResult, fld.getFieldName());

        // Test property
        property = "rim:Slot/@slotType";
        expectedResult = "slots.slotType.value";
        propertyResolver = new XPathPropertyResolver(property);

        fld = propertyResolver.resolveProperty("rim:RegistryObject");
        assertEquals(expectedResult, fld.getFieldName());

          // Test property
        property = "rim:Name";
        expectedResult = "name.localizedStrings.value";
        propertyResolver = new XPathPropertyResolver(property);

        fld = propertyResolver.resolveProperty("rim:RegistryObject");
        assertEquals(expectedResult, fld.getFieldName());

    }
}
