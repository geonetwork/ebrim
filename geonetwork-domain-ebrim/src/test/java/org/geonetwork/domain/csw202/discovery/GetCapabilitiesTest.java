package org.geonetwork.domain.csw202.discovery;

import junit.framework.TestCase;

import java.io.*;

import org.jibx.runtime.*;
import org.geonetwork.domain.ebrim.test.utilities.csw202.discovery.GetCapabilitiesFactory;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;

public class GetCapabilitiesTest extends TestCase {
    @Test
    public void xtestUnmarshal() throws FileNotFoundException, JiBXException {
        // get input XML from file system
        FileInputStream fis = new FileInputStream(new File(
                "src/test/resources/csw202-discovery/GetCapabilitiesTestData.xml"));

        // create JiBX unmarshal context
        IBindingFactory bfact = BindingDirectory.getFactory(GetCapabilities.class);
        IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

        // unmarshal to GetCapabilities
        GetCapabilities unMarshallingResult = (GetCapabilities) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

        System.out.println("actual: " + unMarshallingResult.toString());

        // get expected result from test factory
        GetCapabilities expectedResult = GetCapabilitiesFactory.create();

        System.out.println("expect: " + expectedResult.toString());

        // test equality
        assertEquals("Unmarshalling GetCapabilities", expectedResult, unMarshallingResult);
    }

    @Test
    public void testMarshal() throws JiBXException, SAXException, IOException {

        // create a GetCapabilities with some values
        GetCapabilities o = GetCapabilitiesFactory.create();

        // set up JiBX marshalling context
        IBindingFactory bfact = BindingDirectory.getFactory(GetCapabilities.class);
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
                "src/test/resources/csw202-discovery/GetCapabilitiesTestData.xml"));
        InputSource expectedResult = new InputSource(fis);

        // comparison test
        DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
        Diff diff = new Diff(expectedResult, marshallingResult);
        diff.overrideDifferenceListener(differenceListener);
        assertTrue("Marshalled Capabilities matches expected XML " + diff, diff.similar());
    }
}
