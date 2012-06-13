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

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.geonetwork.search.testutils.FileUtil;
import org.geonetwork.domain.xsd.QName;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for FilterTypeNamesProcessor class
 *
 * @author Jose
 */
public class FilterTypeNamesProcessorTest extends TestCase {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testProcess() {
        try {
            FilterTypeNamesProcessor filterTypeNamesProcessor = getFilterTypeNamesProcessor();

            String result = filterTypeNamesProcessor.process();
            System.out.println("Result:\n" + result);
            
            String expectedResult = FileUtil.convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/TypeNamesProcessorExpected.xml")));

            assertEquals(expectedResult, result);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }


    }

    private FilterTypeNamesProcessor getFilterTypeNamesProcessor() throws Exception {
       String filter = FileUtil.convertStreamToString(new FileInputStream(new File(
                "src/test/resources/search/TypeNamesProcessor.xml")));

        List<QName> typeNames = new ArrayList<QName>();
        QName t = new QName();
        t.setValue("rim:ExtrinsicObject");
        typeNames.add(t);

        t = new QName();
        t.setValue("rim:ExtrinsicObject_acquisitionPlatform");
        typeNames.add(t);

        t = new QName();
        t.setValue("rim:ExtrinsicObject_dataLayer");
        typeNames.add(t);

        t = new QName();
        t.setValue("rim:Association_acquisitionPlatAsso");
        typeNames.add(t);

        t = new QName();
        t.setValue("rim:Association_dataLayerAsso");
        typeNames.add(t);

        t = new QName();
        t.setValue("rim:Classification");
        typeNames.add(t);

        t = new QName();
        t.setValue("rim:ClassificationNode");
        typeNames.add(t);

        return new FilterTypeNamesProcessor(filter, typeNames);
    }
}
