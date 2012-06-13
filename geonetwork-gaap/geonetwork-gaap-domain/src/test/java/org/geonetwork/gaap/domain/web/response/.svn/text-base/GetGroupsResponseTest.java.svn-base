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
 * Test class for GetGroupsResponse
 *
 * @author Jose
 */
public class GetGroupsResponseTest extends TestCase {
        @Test
    public void testUnmarshall() throws FileNotFoundException, JiBXException {
        // get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/web/response/GetGroupsResponseTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(GetGroupsResponse.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to GetGroupsResponse
		GetGroupsResponse unMarshallingResult = (GetGroupsResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		// get expected result from test factory
		GetGroupsResponse expectedResult = ResponseFactory.createGetGroupsResponse();

		// test equality
		assertEquals("Unmarshalling GetGroupsResponse", expectedResult, unMarshallingResult);
    }

    @Test
    public void testMarshall() throws JiBXException, SAXException, IOException {
        // create a GetGroupsResponse with some values
        GetGroupsResponse o = ResponseFactory.createGetGroupsResponse();

        // set up JiBX marshalling context
        IBindingFactory bfact = BindingDirectory.getFactory(GetGroupsResponse.class);
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
        FileInputStream fis = new FileInputStream(new File("src/test/resources/web/response/GetGroupsResponseTestData.xml"));
        InputSource expectedResult = new InputSource(fis);

        // comparison test
        DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
        Diff diff = new Diff(expectedResult, marshallingResult);
        diff.overrideDifferenceListener(differenceListener);
        assertTrue("Marshalled GetGroupsResponse matches expected XML " + diff, diff.similar());
    }
}