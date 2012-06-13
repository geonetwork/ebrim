package org.geonetwork.gaap.domain.web.request;

import org.junit.Test;
import org.jibx.runtime.*;
import org.geonetwork.gaap.domain.util.RequestFactory;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;

import java.io.*;

import junit.framework.TestCase;

/**
 * Test class for SaveUser request
 *
 * @author Jose
 */
public class SaveMetadataPermissionsTest extends TestCase {
        @Test
    public void testUnmarshall() throws FileNotFoundException, JiBXException {
        // get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/web/request/SaveMetadataPermissionsTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(SaveMetadataPermissions.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to SaveMetadataPermissions
		SaveMetadataPermissions unMarshallingResult = (SaveMetadataPermissions) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		// get expected result from test factory
		SaveMetadataPermissions expectedResult = RequestFactory.createSaveMetadataPermissionsRequest();

		// test equality
		assertEquals("Unmarshalling SaveMetadataPermissions", expectedResult, unMarshallingResult);
    }

    @Test
    public void testMarshall() throws JiBXException, SAXException, IOException {
        // create a SaveMetadataPermissions with some values
        SaveMetadataPermissions o = RequestFactory.createSaveMetadataPermissionsRequest();

        // set up JiBX marshalling context
        IBindingFactory bfact = BindingDirectory.getFactory(SaveMetadataPermissions.class);
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
        FileInputStream fis = new FileInputStream(new File("src/test/resources/web/request/SaveMetadataPermissionsTestData.xml"));
        InputSource expectedResult = new InputSource(fis);

        // comparison test
        DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
        Diff diff = new Diff(expectedResult, marshallingResult);
        diff.overrideDifferenceListener(differenceListener);
        assertTrue("Marshalled SaveMetadataPermissions matches expected XML " + diff, diff.similar());
    }
}