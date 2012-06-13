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
package org.geonetwork.domain.csw202.discovery;

import org.junit.Test;
import org.jibx.runtime.*;
import org.geonetwork.domain.ebrim.test.utilities.csw202.discovery.GetRecordByIdResponseFactory;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;

import java.io.*;

import junit.framework.TestCase;

/**
 * Test for class GetRecordByIdResponse Jibx binding
 *
 * @author Jose
 */
public class GetRecordByIdResponseTest extends TestCase {
    @Test
    public void testDummy() {
        assertTrue(true);
    }
    
    /*
<csw:GetRecordByIdResponse xmlns:csw="http://www.opengis.net/cat/csw/2.0.2">
  <csw:Record xmlns:ows="http://www.opengis.net/ows" xmlns:gmd="http://www.isotc211.org/2005/gmd" xmlns:gco="http://www.isotc211.o
rg/2005/gco" xmlns:dct="http://purl.org/dc/terms/" xmlns:dc="http://purl.org/dc/elements/1.1/">
    <dc:identifier>urn:hma:eum:msg1:6666</dc:identifier>
    <dc:title>Meteosat 8 (MSG product family) - SEVI - MSG15</dc:title>
    <dc:creator>EUMETSAT</dc:creator>
    <dct:abstract>Meteosat 8 (MSG product family), SEVI instrument (MSG), MSG Level 1.5</dct:abstract>
    <dc:language />
    <ows:BoundingBox crs="::">
      <ows:LowerCorner>180.00 -90.00</ows:LowerCorner>
      <ows:UpperCorner>-180.00 90.00</ows:UpperCorner>
    </ows:BoundingBox>
    <dc:type>series</dc:type>
  </csw:Record>
</csw:GetRecordByIdResponse>
*/
    @Test
	public void testUnmarshal() throws FileNotFoundException, JiBXException {

		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File(
				"src/test/resources/csw202-discovery/GetRecordByIdResponseTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(GetRecordByIdResponse.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to GetRecordByIdResponse
		GetRecordByIdResponse unMarshallingResult = (GetRecordByIdResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		System.out.println("actual: " + unMarshallingResult.toString());

		// get expected result from test factory
		GetRecordByIdResponse expectedResult = GetRecordByIdResponseFactory.create();

		System.out.println("expect: " + expectedResult.toString());

		// test equality
		assertEquals("Unmarshalling GetRecordByIdResponse", expectedResult, unMarshallingResult);
	}

	@Test
	public void testMarshal() throws JiBXException, SAXException, IOException {

		// create a GetRecordByIdResponse with some values
		GetRecordByIdResponse o = GetRecordByIdResponseFactory.create();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(GetRecordByIdResponse.class);
		IMarshallingContext marshallingContext = bfact.createMarshallingContext();

		// marshal to console - nice if you're looking
		Writer outConsole = new BufferedWriter(new OutputStreamWriter(System.out));
		marshallingContext.setOutput(outConsole);
		marshallingContext.setIndent(3);
		marshallingContext.marshalDocument(o, "UTF-8", null);

		// marshal to outputstream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Writer out = new BufferedWriter(new OutputStreamWriter(outputStream));
		marshallingContext.setIndent(3);
		marshallingContext.setOutput(out);
		marshallingContext.marshalDocument(o, "UTF-8", null);

		// convert to InputSource for the comparison test
		InputSource marshallingResult = new InputSource(new ByteArrayInputStream(outputStream.toByteArray()));

		// get expected result from filesystem
		FileInputStream fis = new FileInputStream(new File(
				"src/test/resources/csw202-discovery/GetRecordByIdResponseTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

        // comparison test
        DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
        Diff diff = new Diff(expectedResult, marshallingResult);
        diff.overrideDifferenceListener(differenceListener);
        assertTrue("Marshalled GetRecordByIdResponse matches expected XML " + diff, diff.similar());        
	}
}
