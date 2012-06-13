package org.geonetwork.gaap.domain.operation;

import junit.framework.TestCase;
import org.junit.Test;
import org.geonetwork.gaap.domain.util.OperationFactory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.JiBXException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.custommonkey.xmlunit.Diff;

import java.io.*;

public class PermissionTest extends TestCase {

     @Test
    public void testUnmarshall() {

    }

    @Test
    public void testMarshall() throws JiBXException, SAXException, IOException {
        // create a Operation with some values
         Permission o = OperationFactory.createPermission();

         // set up JiBX marshalling context
         IBindingFactory bfact = BindingDirectory.getFactory(Permission.class);
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
         FileInputStream fis = new FileInputStream(new File("src/test/resources/PermissionTestData.xml"));
         InputSource expectedResult = new InputSource(fis);

         // comparison test
         DifferenceListener differenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
         Diff diff = new Diff(expectedResult, marshallingResult);
         diff.overrideDifferenceListener(differenceListener);
         assertTrue("Marshalled OperationAllowed matches expected XML " + diff, diff.similar());
    }

}
