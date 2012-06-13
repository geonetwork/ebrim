package org.geonetwork.domain.csw202.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import org.geonetwork.domain.ebrim.test.utilities.csw202.exception.ExceptionReportFactory;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ExceptionReportTest {

	@Test
	public void testUnmarshal() throws FileNotFoundException, JiBXException {

		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File(
				"src/test/resources/csw202-record/ExceptionReportTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(ExceptionReport.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to ExceptionReport
		ExceptionReport unMarshallingResult = (ExceptionReport) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		System.out.println("actual: " + unMarshallingResult.toString());

		// get expected result from test factory
		ExceptionReport expectedResult = ExceptionReportFactory.create();

		System.out.println("expect: " + expectedResult.toString());

		// test equality
		assertEquals("Unmarshalling ExceptionReport", expectedResult, unMarshallingResult);
	}

	@Test
	public void testMarshal() throws JiBXException, SAXException, IOException {

		// create a ExceptionReport with some values
		ExceptionReport o = ExceptionReportFactory.create();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(ExceptionReport.class);
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
				"src/test/resources/csw202-record/ExceptionReportTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled ExceptionReport matches expected XML " + diff, diff.similar());
	}

	@Test
	public void testEquals() {
		ExceptionReport er1 = new ExceptionReport();
		ExceptionReport er2 = new ExceptionReport();
		assertTrue(er1.equals(er2));
		Exception e1 = new Exception();
		Exception e2 = new Exception();
		er1.addException(e1);
		er2.addException(e2);
		assertTrue(er1.equals(er2));
	}

}
