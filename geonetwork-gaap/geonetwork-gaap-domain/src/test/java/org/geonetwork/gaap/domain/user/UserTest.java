package org.geonetwork.gaap.domain.user;

import junit.framework.TestCase;
import org.junit.Test;
import org.jibx.runtime.*;
import org.geonetwork.gaap.domain.util.UserFactory;
import org.geonetwork.gaap.domain.util.GroupFactory;
import org.geonetwork.gaap.domain.group.Group;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;

import java.io.*;

/**
 * Test class for User Jibx binding
 * 
 * @author Jose
 */
public class UserTest extends TestCase {

     @Test
    public void testUnmarshall() throws FileNotFoundException, JiBXException {
        // get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/UserTestData.xml"));

		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(User.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();

		// unmarshal to User
		User unMarshallingResult = (User) unMarshallingContext.unmarshalDocument(fis, "UTF-8");

		// get expected result from test factory
		User expectedResult = UserFactory.create();

		// test equality
		assertEquals("Unmarshalling User", expectedResult, unMarshallingResult);
    }

    @Test
    public void testMarshall() throws JiBXException, SAXException, IOException {
        // create a User with some values
        User o = UserFactory.create();

        // set up JiBX marshalling context
        IBindingFactory bfact = BindingDirectory.getFactory(User.class);
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
        FileInputStream fis = new FileInputStream(new File("src/test/resources/UserTestData.xml"));
        InputSource expectedResult = new InputSource(fis);

        // comparison test
        DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
        Diff diff = new Diff(expectedResult, marshallingResult);
        diff.overrideDifferenceListener(differenceListener);
        assertTrue("Marshalled User matches expected XML " + diff, diff.similar());
    }
}
