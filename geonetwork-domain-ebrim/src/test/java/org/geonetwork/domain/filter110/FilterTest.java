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

package org.geonetwork.domain.filter110;

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
import org.geonetwork.domain.ebrim.test.utilities.filter110.FilterFactory;
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
public class FilterTest extends XMLTestCase {

	public FilterTest(String name) {
		super(name);
	}

	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for Filter Beyond.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshalBeyond() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/BeyondTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
	
		// unmarshal to Filter
		Filter unMarshallingResult = (Filter) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		
		// get expected result from test factory
		Filter expectedResult = FilterFactory.createBeyond();

		// test equality
		assertEquals("Unmarshalling Filter Beyond", expectedResult, unMarshallingResult);
	}

	/**
	 * Tests marshalling (Java object puts out XML) a Filter Beyond.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void testMarshalBeyond() throws JiBXException, SAXException, IOException {

		// create a Filter Beyond with some values
		Filter o = FilterFactory.createBeyond();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IMarshallingContext marshallingContext = bfact.createMarshallingContext();

		// marshal to console - nice if you're looking
		//Writer outConsole = new BufferedWriter(new OutputStreamWriter(System.out));
		//marshallingContext.setOutput(outConsole);
		//marshallingContext.setIndent(3);
		//marshallingContext.marshalDocument(o, "UTF-8", null);

		// marshal to outputstream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Writer out = new BufferedWriter(new OutputStreamWriter(outputStream));
		marshallingContext.setIndent(3);
		marshallingContext.setOutput(out);
		marshallingContext.marshalDocument(o, "UTF-8", null);

		// convert to InputSource for the comparison test
		InputSource marshallingResult = new InputSource(new ByteArrayInputStream(outputStream.toByteArray()));

		// get expected result from filesystem
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/BeyondTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled Filter Beyond matches expected XML " + diff, diff.similar());
	}
	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for Filter DWithin.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshalDWithin() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/DWithinTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
	
		// unmarshal to Filter
		Filter unMarshallingResult = (Filter) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		
		// get expected result from test factory
		Filter expectedResult = FilterFactory.createDWithin();

		
		//System.out.println("hmm: " + unMarshallingResult.getOperator().getClass());
		//System.out.println("hmmmm: " + expectedResult.getOperator().getClass());
		// test equality
		assertEquals("Unmarshalling Filter DWithin", expectedResult, unMarshallingResult);
	}
	

	/**
	 * Tests marshalling (Java object puts out XML) a Filter Dwithin.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void testMarshalDWithin() throws JiBXException, SAXException, IOException {

		// create a Filter Beyond with some values
		Filter o = FilterFactory.createDWithin();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IMarshallingContext marshallingContext = bfact.createMarshallingContext();

		// marshal to console - nice if you're looking
		//Writer outConsole = new BufferedWriter(new OutputStreamWriter(System.out));
		//marshallingContext.setOutput(outConsole);
		//marshallingContext.setIndent(3);
		//marshallingContext.marshalDocument(o, "UTF-8", null);

		// marshal to outputstream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Writer out = new BufferedWriter(new OutputStreamWriter(outputStream));
		marshallingContext.setIndent(3);
		marshallingContext.setOutput(out);
		marshallingContext.marshalDocument(o, "UTF-8", null);

		// convert to InputSource for the comparison test
		InputSource marshallingResult = new InputSource(new ByteArrayInputStream(outputStream.toByteArray()));

		// get expected result from filesystem
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/DWithinTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled Filter DWithin matches expected XML " + diff, diff.similar());
	}

	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for Filter PropertyIsEqualTo.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshalPropertyIsEqualTo() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsEqualToTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
	
		// unmarshal to Filter
		Filter unMarshallingResult = (Filter) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		
		// get expected result from test factory
		Filter expectedResult = FilterFactory.createPropertyIsEqualTo();

		// test equality
		assertEquals("Unmarshalling Filter PropertyIsEqualTo", expectedResult, unMarshallingResult);
	}

	/**
	 * Tests marshalling (Java object puts out XML) a Filter PropertyIsEqualTo.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void testMarshalPropertyIsEqualTo() throws JiBXException, SAXException, IOException {

		// create a Filter Beyond with some values
		Filter o = FilterFactory.createPropertyIsEqualTo();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
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
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsEqualToTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled Filter PropertyIsEqualTo matches expected XML " + diff, diff.similar());
	}
	
	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for Filter PropertyIsNotEqualTo.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshalPropertyIsNotEqualTo() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsNotEqualToTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
	
		// unmarshal to Filter
		Filter unMarshallingResult = (Filter) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		
		// get expected result from test factory
		Filter expectedResult = FilterFactory.createPropertyIsNotEqualTo();

		// test equality
		assertEquals("Unmarshalling Filter PropertyIsNotEqualTo", expectedResult, unMarshallingResult);
	}

	/**
	 * Tests marshalling (Java object puts out XML) a Filter PropertyIsNotEqualTo.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void testMarshalPropertyIsNotEqualTo() throws JiBXException, SAXException, IOException {

		// create a Filter Beyond with some values
		Filter o = FilterFactory.createPropertyIsNotEqualTo();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
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
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsNotEqualToTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled Filter PropertyIsNotEqualTo matches expected XML " + diff, diff.similar());
	}	
	
	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for Filter PropertyIsGreaterThan.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshalPropertyIsGreaterThan() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsGreaterThanTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
	
		// unmarshal to Filter
		Filter unMarshallingResult = (Filter) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		
		// get expected result from test factory
		Filter expectedResult = FilterFactory.createPropertyIsGreaterThan();

		// test equality
		assertEquals("Unmarshalling Filter PropertyIsGreaterThan", expectedResult, unMarshallingResult);
	}

	/**
	 * Tests marshalling (Java object puts out XML) a Filter PropertyIsGreaterThan.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void testMarshalPropertyIsGreaterThan() throws JiBXException, SAXException, IOException {

		// create a Filter Beyond with some values
		Filter o = FilterFactory.createPropertyIsGreaterThan();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
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
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsGreaterThanTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled Filter PropertyIsGreaterThan matches expected XML " + diff, diff.similar());
	}	
	
	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for Filter PropertyIsGreaterThanOrEqualTo.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshalPropertyIsGreaterThanOrEqualTo() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsGreaterThanOrEqualToTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
	
		// unmarshal to Filter
		Filter unMarshallingResult = (Filter) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		
		// get expected result from test factory
		Filter expectedResult = FilterFactory.createPropertyIsGreaterThanOrEqualTo();

		// test equality
		assertEquals("Unmarshalling Filter PropertyIsGreaterThanOrEqualTo", expectedResult, unMarshallingResult);
	}

	/**
	 * Tests marshalling (Java object puts out XML) a Filter PropertyIsGreaterThanOrEqualTo.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void testMarshalPropertyIsGreaterThanOrEqualTo() throws JiBXException, SAXException, IOException {

		// create a Filter Beyond with some values
		Filter o = FilterFactory.createPropertyIsGreaterThanOrEqualTo();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
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
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsGreaterThanOrEqualToTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled Filter PropertyIsGreaterThanOrEqualTo matches expected XML " + diff, diff.similar());
	}	
	
	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for Filter PropertyIsLessThanOrEqualTo.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshalPropertyIsLessThanOrEqualTo() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsLessThanOrEqualToTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
	
		// unmarshal to Filter
		Filter unMarshallingResult = (Filter) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		
		// get expected result from test factory
		Filter expectedResult = FilterFactory.createPropertyIsLessThanOrEqualTo();

		// test equality
		assertEquals("Unmarshalling Filter PropertyIsLessThanOrEqualTo", expectedResult, unMarshallingResult);
	}

	/**
	 * Tests marshalling (Java object puts out XML) a Filter PropertyIsLessThanOrEqualTo.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void testMarshalPropertyIsLessThanOrEqualTo() throws JiBXException, SAXException, IOException {

		// create a Filter Beyond with some values
		Filter o = FilterFactory.createPropertyIsLessThanOrEqualTo();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
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
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsLessThanOrEqualToTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled Filter PropertyIsLessThanOrEqualTo matches expected XML " + diff, diff.similar());
	}		
	
	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for Filter PropertyIsLessThan.
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshalPropertyIsLessThan() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsLessThanTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
	
		// unmarshal to Filter
		Filter unMarshallingResult = (Filter) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		
		// get expected result from test factory
		Filter expectedResult = FilterFactory.createPropertyIsLessThan();

		// test equality
		assertEquals("Unmarshalling Filter PropertyIsLessThan", expectedResult, unMarshallingResult);
	}

	/**
	 * Tests marshalling (Java object puts out XML) a Filter PropertyIsLessThan.
	 * 
	 * @throws JiBXException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void testMarshalPropertyIsLessThan() throws JiBXException, SAXException, IOException {

		// create a Filter Beyond with some values
		Filter o = FilterFactory.createPropertyIsLessThan();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(Filter.class);
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
		FileInputStream fis = new FileInputStream(new File("src/test/resources/filter/PropertyIsLessThanTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled Filter PropertyIsLessThan matches expected XML " + diff, diff.similar());
	}			
}
