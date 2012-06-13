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

package org.geonetwork.services.utils;

import java.io.IOException;

import org.custommonkey.xmlunit.XMLTestCase;
import org.geonetwork.utils.xslt.GeonetworkTransformerException;
import org.xml.sax.SAXException;

/**
 * Tests RandomFiller.
 * 
 * @author heikki doeleman
 * 
 */
public class RandomFillerTest extends XMLTestCase {

	public RandomFillerTest(String name) {
		super(name);
	}

	public void testRandomFillerString() throws Exception {
		//String s = (String) RandomPopulator.populate(String.class) ;
		//assertNotNull("randomly fill String", s);
	}
	public void testRandomFillerInteger() throws GeonetworkTransformerException, SAXException, IOException {
	}
	public void testRandomFillerDouble() throws GeonetworkTransformerException, SAXException, IOException {
	}
	public void testRandomFillerFloat() throws GeonetworkTransformerException, SAXException, IOException {
	}
	public void testRandomFillerDate() throws GeonetworkTransformerException, SAXException, IOException {
	}
	public void testRandomFillerDateRange() throws GeonetworkTransformerException, SAXException, IOException {
	}
	public void testRandomFillerBoolean() throws GeonetworkTransformerException, SAXException, IOException {
	}


}
