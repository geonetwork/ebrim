package org.geonetwork.domain.csw202.discovery;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import junit.framework.TestCase;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.geonetwork.domain.ebrim.test.utilities.csw202.discovery.DescribeRecordFactory;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DescribeRecordTest extends TestCase {

	public void testUnmarshal() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File(
				"src/test/resources/csw202-discovery/DescribeRecordTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(DescribeRecord.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to DescribeRecord
		DescribeRecord unMarshallingResult = (DescribeRecord) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		// System.out.println("actual: " + unMarshallingResult.getNamespace().toString());

		// get expected result from test factory
		DescribeRecord expectedResult = DescribeRecordFactory.create();

		System.out.println("expect: " + expectedResult.toString());

		// test equality
		assertEquals("Unmarshalling DescribeRecord", expectedResult, unMarshallingResult);
	}

	
	/**
	 * This test is to verify that the namespaces are correctly processed by Jibx. 
	 * 
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testUnmarshal2() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File(
				"src/test/resources/csw202-discovery/DescribeRecordTestData2.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(DescribeRecord.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to DescribeRecord
		DescribeRecord unMarshallingResult = (DescribeRecord) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		// System.out.println("actual: " + unMarshallingResult.getNamespace().toString());

		// get expected result from test factory
		assertEquals(2, unMarshallingResult.getNamespace().size());
		assertEquals("tns=urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0", unMarshallingResult.getNamespace().get(0));
		assertEquals("csw=http://www.opengis.net/cat/csw/2.0.2", unMarshallingResult.getNamespace().get(1));


	}

	public void testMarshal() throws JiBXException, SAXException, IOException {

		// create a DescribeRecord with some values
		DescribeRecord o = DescribeRecordFactory.create();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(DescribeRecord.class);
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
				"src/test/resources/csw202-discovery/DescribeRecordTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled DescribeRecord matches expected XML " + diff, diff.similar());
	}
}