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

package org.geonetwork.domain.ebrs.test;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.XMLTestCase;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;
import org.geonetwork.domain.ebrs.SubmitObjectsRequest;
import org.geonetwork.domain.ebrs.test.utilities.SubmitObjectsRequestFactory;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Tests marshalling and unmarshalling.
 * 
 * @author heikki doeleman
 * 
 */
public class SubmitObjectsRequestTest extends XMLTestCase {

	public SubmitObjectsRequestTest(String name) {
		super(name);
	}

	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for SubmitObjectsRequest.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshal() throws FileNotFoundException, JiBXException {

		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/SubmitObjectsRequest_EmailTypeScheme.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(SubmitObjectsRequest.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to SubmitObjectsRequest
		SubmitObjectsRequest unMarshallingResult = (SubmitObjectsRequest) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		System.out.println("\n\n\n##### "+unMarshallingResult.getRegistryObjectList().size());
		ClassificationScheme cs = (ClassificationScheme)unMarshallingResult.getRegistryObjectList().get(0);
		System.out.println(cs.getId().getValue() + " ");
		// get expected result from test factory
		SubmitObjectsRequest expectedResult = SubmitObjectsRequestFactory.create();

		// test equality
		assertEquals("Unmarshalling SubmitObjectsRequest", expectedResult, unMarshallingResult);

	}

	/**
	 * Tests marshalling (Java object puts out XML) a SubmitObjectsRequest.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void xtestMarshal() throws JiBXException, SAXException, IOException {

		// create a SubmitObjectsRequest with some values
		SubmitObjectsRequest o = SubmitObjectsRequestFactory.create();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(SubmitObjectsRequest.class);
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
		FileInputStream fis = new FileInputStream(new File("src/test/resources/SubmitObjectsRequest_EmailTypeScheme.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled SubmitObjectsRequest matches expected XML " + diff, diff.similar());

	}

}
