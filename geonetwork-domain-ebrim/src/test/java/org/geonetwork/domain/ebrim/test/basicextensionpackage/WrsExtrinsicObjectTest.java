package org.geonetwork.domain.ebrim.test.basicextensionpackage;

import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;
import org.jibx.runtime.*;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery.StoredQuery;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject.WrsExtrinsicObject;
import org.geonetwork.domain.ebrim.test.utilities.basicextensionpackage.StoredQueryFactory;
import org.geonetwork.domain.ebrim.test.utilities.basicextensionpackage.WrsExtrinsicObjectFactory;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;

import java.io.*;

/**
 * Tests marshalling and unmarshalling.
 *
 * @author jose
 *
 */
public class WrsExtrinsicObjectTest  extends XMLTestCase {

	public WrsExtrinsicObjectTest(String name) {
		super(name);
	}

	/**
	 * Tests unmarshalling (XML is instantiated as Java object) for StoredQuery.
	 *
	 * @throws java.io.FileNotFoundException
	 * @throws org.jibx.runtime.JiBXException
	 */
	public void testUnmarshal() throws FileNotFoundException, JiBXException {

		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/basicextension/WrsExtrinsicObjectTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(WrsExtrinsicObject.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to WrsExtrinsicObject
		WrsExtrinsicObject unMarshallingResult = (WrsExtrinsicObject) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		// get expected result from test factory
		WrsExtrinsicObject expectedResult = WrsExtrinsicObjectFactory.create();

		// test equality
		assertEquals("Unmarshalling WrsExtrinsicObject", expectedResult, unMarshallingResult);

	}

	/**
	 * Tests marshalling (Java object puts out XML) a StoredQuery.
	 *
	 * @throws JiBXException
	 * @throws org.xml.sax.SAXException
	 * @throws java.io.IOException
	 */
	public void testMarshal() throws JiBXException, SAXException, IOException {

		// create a StoredQuery with some values
		WrsExtrinsicObject o = WrsExtrinsicObjectFactory.create();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(WrsExtrinsicObject.class);
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
		FileInputStream fis = new FileInputStream(new File("src/test/resources/basicextension/WrsExtrinsicObjectTestData.xml"));
		InputSource expectedResult = new InputSource(fis);

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
		Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled WrsExtrinsicObject matches expected XML " + diff, diff.similar());

	}

}
