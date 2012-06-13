package org.geonetwork.gaap.domain.web.response;

import org.junit.Test;
import org.jibx.runtime.*;
import org.geonetwork.gaap.domain.util.ResponseFactory;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;

import java.io.*;

import junit.framework.TestCase;

/**
 * Test class for GetGroupResponse
 *
 * @author Jose
 */
public class FilterMetadataResponseTest extends TestCase {
        @Test
    public void testUnmarshall() throws FileNotFoundException, JiBXException {
        // get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/web/response/FilterMetadataResponseTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(FilterMetadataResponse.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to FilterMetadataResponse
		FilterMetadataResponse unMarshallingResult = (FilterMetadataResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		// get expected result from test factory
		FilterMetadataResponse expectedResult = ResponseFactory.createFilterMetadataResponse();

		// test equality
		assertEquals("Unmarshalling FilterMetadataResponse", expectedResult, unMarshallingResult);
    }

    @Test
    public void testMarshall() throws JiBXException, SAXException, IOException {
        // create a FilterMetadataResponse with some values
        FilterMetadataResponse o = ResponseFactory.createFilterMetadataResponse();

        // set up JiBX marshalling context
        IBindingFactory bfact = BindingDirectory.getFactory(FilterMetadataResponse.class);
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
        FileInputStream fis = new FileInputStream(new File("src/test/resources/web/response/FilterMetadataResponseTestData.xml"));
        InputSource expectedResult = new InputSource(fis);

        // comparison test
        DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
        Diff diff = new Diff(expectedResult, marshallingResult);
        diff.overrideDifferenceListener(differenceListener);
        assertTrue("Marshalled FilterMetadataResponse matches expected XML " + diff, diff.similar());
    }
}