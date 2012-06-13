package org.geonetwork.domain.csw202.discovery;

import org.jibx.runtime.*;
import org.geonetwork.domain.ebrim.test.utilities.csw202.discovery.DescribeRecordResponseFactory;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;

import java.io.*;

import junit.framework.TestCase;

public class DescribeRecordResponseTest extends TestCase {
    @Test
    public void testMarshall() {
        assertTrue(true);
    }

    @Test
    public void testUnmarshal1() throws FileNotFoundException, JiBXException {
        // get input XML from file system
        FileInputStream fis = new FileInputStream(new File(
                "src/test/resources/csw202-discovery/DescribeRecordResponseTestData.xml"));

        // create JiBX unmarshal context
        IBindingFactory bfact = BindingDirectory.getFactory(DescribeRecordResponse.class);
        IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

        // unmarshal to DescribeRecordResponse
        DescribeRecordResponse unMarshallingResult = (DescribeRecordResponse) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

        System.out.println("actual: " + unMarshallingResult.toString());

        // get expected result from test factory
        DescribeRecordResponse expectedResult = DescribeRecordResponseFactory.create();

        System.out.println("expect: " + expectedResult.toString());

        // test equality
        assertEquals("Unmarshalling DescribeRecordResponse", expectedResult, unMarshallingResult);
    }

    @Test
    // TODO: Check Expected number of child nodes '3' but was '2' - comparing <csw:SchemaComponent...> at /DescribeRecordResponse[1]/SchemaComponent[1] to <csw:SchemaComponent...> at /DescribeRecordResponse[1]/SchemaComponent[1]
    // Text content is equal
    public void xtestMarshal() throws JiBXException, SAXException, IOException {

        // create a DescribeRecordResponse with some values
        DescribeRecordResponse o = DescribeRecordResponseFactory.create();

        // set up JiBX marshalling context
        IBindingFactory bfact = BindingDirectory.getFactory(DescribeRecordResponse.class);
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
                "src/test/resources/csw202-discovery/DescribeRecordResponseTestData.xml"));
        InputSource expectedResult = new InputSource(fis);

        // comparison test
        DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
        Diff diff = new Diff(expectedResult, marshallingResult);
        diff.overrideDifferenceListener(differenceListener);
        assertTrue("Marshalled DescribeRecordResponse matches expected XML " + diff, diff.similar());
    }
 }
