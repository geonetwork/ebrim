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

package org.geonetwork.domain.ebrim.test.informationmodel.event;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.XMLTestCase;
import org.geonetwork.domain.ebrim.informationmodel.event.Subscription;
import org.geonetwork.domain.ebrim.test.utilities.event.SubscriptionFactory;
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
public class SubscriptionTest extends XMLTestCase {

	public SubscriptionTest(String name) {
		super(name);
	}

	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for Subscription.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshal() throws FileNotFoundException, JiBXException {

		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/SubscriptionTestData.xml"));
		InputStreamReader fileReader = new InputStreamReader(fis);

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(Subscription.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to Subscription
		Subscription unMarshallingResult = (Subscription) unMarshallingContext.unmarshalDocument(fileReader);

		// get expected result from test factory
		Subscription expectedResult = SubscriptionFactory.create();

		// test equality
		assertEquals("Unmarshalling Subscription", expectedResult, unMarshallingResult);

	}

	/**
	 * Tests marshalling (Java object puts out XML) a Subscription.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void testMarshal() throws JiBXException, SAXException, IOException {

		// create a Subscription with some values
		Subscription o = SubscriptionFactory.create();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(Subscription.class);
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
		FileInputStream fis = new FileInputStream(new File("src/test/resources/SubscriptionTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled Subscription matches expected XML " + diff, diff.similar());

	}

}
