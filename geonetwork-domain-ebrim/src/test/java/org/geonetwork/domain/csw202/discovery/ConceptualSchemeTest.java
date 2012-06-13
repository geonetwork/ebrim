package org.geonetwork.domain.csw202.discovery;

import java.io.*;

import junit.framework.TestCase;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.geonetwork.domain.ebrim.test.utilities.csw202.discovery.ConceptualSchemeFactory;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;
import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ConceptualSchemeTest extends TestCase {

	// @Test
	public void testUnmarshal() throws FileNotFoundException, JiBXException {

		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File(
				"src/test/resources/csw202-discovery/ConceptualSchemeTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(ConceptualScheme.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to ConceptualScheme
		ConceptualScheme unMarshallingResult = (ConceptualScheme) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		System.out.println("actual: " + unMarshallingResult.toString());

		// get expected result from test factory
		ConceptualScheme expectedResult = ConceptualSchemeFactory.create();

		System.out.println("expect: " + expectedResult.toString());

		// test equality
		assertEquals("Unmarshalling ConceptualScheme", expectedResult, unMarshallingResult);
	}

	@Test
	public void testMarshal() throws JiBXException, SAXException, IOException {

		// create a ConceptualScheme with some values
		ConceptualScheme o = ConceptualSchemeFactory.create();

		// set up JiBX marshalling context
		IBindingFactory bfact = BindingDirectory.getFactory(ConceptualScheme.class);
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
        //String res = slurp(marshallingResult.getByteStream());

        // get expected result from filesystem
		FileInputStream fis = new FileInputStream(new File(
				"src/test/resources/csw202-discovery/ConceptualSchemeTestData.xml"));
		InputSource expectedResult = new InputSource(fis);
        //String exp = slurp(expectedResult.getByteStream());

        //assertTrue("Marshalled ConceptualScheme matches expected XML ", exp.equals(res));

		// comparison test
		DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();

        Diff diff = new Diff(expectedResult, marshallingResult);
		diff.overrideDifferenceListener(differenceListener);
		assertTrue("Marshalled ConceptualScheme matches expected XML " + diff, diff.similar());
	}

    private static String slurp (InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }

        String outString = out.toString();
        outString = outString.replace("\n", "");
        outString = outString.replace("\r", "");
        outString = outString.replaceAll(" ", "");
        return outString;
    }

}