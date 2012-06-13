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

package org.geonetwork.services.utils.xslt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.XMLTestCase;
import org.geonetwork.utils.xslt.GeonetworkTransformerException;
import org.geonetwork.utils.xslt.Transformer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Tests XSLT transformer.
 * 
 * @author heikki doeleman
 * 
 */
public class TransformerTest extends XMLTestCase {

	public TransformerTest(String name) {
		super(name);
	}

	public void testTransformer() throws GeonetworkTransformerException, SAXException, IOException {

		FileInputStream xml = new FileInputStream(new File("src/test/resources/xslt/birds.xml"));
		FileInputStream xslt = new FileInputStream(new File("src/test/resources/xslt/birds.xslt"));
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Transformer.transform(xml, xslt, outputStream);
		
		// convert to InputSource for the comparison test
		InputSource actualResult = new InputSource(new ByteArrayInputStream(outputStream.toByteArray()));

		// get expected result from filesystem
		FileInputStream fis = new FileInputStream(new File("src/test/resources/xslt/birds.expectedresult.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, actualResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Transformer result matches expected XML " + diff, diff.similar());
	}


}
