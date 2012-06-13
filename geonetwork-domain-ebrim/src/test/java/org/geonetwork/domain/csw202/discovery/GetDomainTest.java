package org.geonetwork.domain.csw202.discovery;

import org.jibx.runtime.*;
import org.geonetwork.domain.ebrim.test.utilities.csw202.discovery.GetDomainFactory;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;

import java.io.*;

import junit.framework.TestCase;

public class GetDomainTest extends TestCase {
    @Test
    public void testUnmarshalWithParameter() throws FileNotFoundException, JiBXException {
        // get input XML from file system
        FileInputStream fis = new FileInputStream(new File(
                "src/test/resources/csw202-discovery/GetDomainTestData.xml"));

        // create JiBX unmarshal context
        IBindingFactory bfact = BindingDirectory.getFactory(GetDomain.class);
        IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

        // unmarshal to GetDomain
        GetDomain unMarshallingResult = (GetDomain) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

        System.out.println("actual: " + unMarshallingResult.toString());

        // get expected result from test factory
        GetDomain expectedResult = GetDomainFactory.createWithParameterName();

        System.out.println("expect: " + expectedResult.toString());

        // test equality
        assertEquals("Unmarshalling GetDomain", expectedResult, unMarshallingResult);
    }

    @Test
    public void testMarshalWithParameter() throws JiBXException, SAXException, IOException {

        // create a GetDomain with some values
        GetDomain o = GetDomainFactory.createWithParameterName();

        // set up JiBX marshalling context
        IBindingFactory bfact = BindingDirectory.getFactory(GetDomain.class);
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
                "src/test/resources/csw202-discovery/GetDomainTestData.xml"));
        InputSource expectedResult = new InputSource(fis);

        // comparison test
       DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
       Diff diff = new Diff(expectedResult, marshallingResult);
       diff.overrideDifferenceListener(differenceListener);
       assertTrue("Marshalled GetDomain matches expected XML " + diff, diff.similar());

    }

    @Test
    public void testUnmarshalWithPropertyName() throws FileNotFoundException, JiBXException {
        // get input XML from file system
        FileInputStream fis = new FileInputStream(new File(
                "src/test/resources/csw202-discovery/GetDomainTestData2.xml"));

        // create JiBX unmarshal context
        IBindingFactory bfact = BindingDirectory.getFactory(GetDomain.class);
        IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

        // unmarshal to GetDomain
        GetDomain unMarshallingResult = (GetDomain) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

        System.out.println("actual: " + unMarshallingResult.toString());

        // get expected result from test factory
        GetDomain expectedResult = GetDomainFactory.createWithPropertyName();

        System.out.println("expect: " + expectedResult.toString());

        // test equality
        assertEquals("Unmarshalling GetDomain", expectedResult, unMarshallingResult);
    }

    @Test
    public void testMarshalWithPropertyName() throws JiBXException, SAXException, IOException {

        // create a GetDomain with some values
        GetDomain o = GetDomainFactory.createWithPropertyName();

        // set up JiBX marshalling context
        IBindingFactory bfact = BindingDirectory.getFactory(GetDomain.class);
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
                "src/test/resources/csw202-discovery/GetDomainTestData2.xml"));
        InputSource expectedResult = new InputSource(fis);

        // comparison test
       DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
       Diff diff = new Diff(expectedResult, marshallingResult);
       diff.overrideDifferenceListener(differenceListener);
       assertTrue("Marshalled GetDomain matches expected XML " + diff, diff.similar());
    }
}
