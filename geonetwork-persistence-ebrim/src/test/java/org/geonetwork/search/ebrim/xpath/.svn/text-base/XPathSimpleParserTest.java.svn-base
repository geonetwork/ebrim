package org.geonetwork.search.ebrim.xpath;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Tests for XPathSimpleParser
 */
public class XPathSimpleParserTest extends TestCase {

    @Test
    public void testParse() {
        XPathSimpleParser parser = new XPathSimpleParser();

        String xpath1 = "/rim:Association/@targetObject";

        List<XPathToken> tokens = parser.parse(xpath1);

        assertEquals(2, tokens.size());

        assertEquals(XPathToken.XPathTokenType.XPATH_ELEMENT, tokens.get(0).getType());
        assertEquals("rim", tokens.get(0).getPrefix());
        assertEquals("Association", tokens.get(0).getName());
        assertFalse(tokens.get(0).hasPredicate());

        assertEquals(XPathToken.XPathTokenType.XPATH_ATTRIBUTE, tokens.get(1).getType());
        assertEquals("targetObject", tokens.get(1).getName());
        assertEquals("", tokens.get(1).getPrefix());


        String xpath2 = "/rim:RegistryPackage/rim:RegistryObjectList[*]/rim:RegistryObject/@id";

        tokens = parser.parse(xpath2);
        assertEquals(4, tokens.size());

        assertEquals(XPathToken.XPathTokenType.XPATH_ELEMENT, tokens.get(0).getType());
        assertEquals("rim", tokens.get(0).getPrefix());
        assertEquals("RegistryPackage", tokens.get(0).getName());
        assertFalse(tokens.get(0).hasPredicate());

        assertEquals(XPathToken.XPathTokenType.XPATH_ELEMENT, tokens.get(1).getType());
        assertEquals("rim", tokens.get(1).getPrefix());
        assertEquals("RegistryObjectList", tokens.get(1).getName());
        assertTrue(tokens.get(1).hasPredicate());

        assertEquals(XPathToken.XPathTokenType.XPATH_ELEMENT, tokens.get(2).getType());
        assertEquals("rim", tokens.get(2).getPrefix());
        assertEquals("RegistryObject", tokens.get(2).getName());
        assertFalse(tokens.get(2).hasPredicate());

        assertEquals(XPathToken.XPathTokenType.XPATH_ATTRIBUTE, tokens.get(3).getType());
        assertEquals("id", tokens.get(3).getName());
        assertEquals("", tokens.get(3).getPrefix());


         String xpath3 = "/rim:ExtrinsicObject[@objectType='urn:ogc:def:ebRIM-ObjectType:OGC:DataMetadata']/rim:Slot[@name='http://purl.org/dc/terms/spatial' and @slotType ='urn:ogc:def:dataType:ISO-19107:GM_Envelope']/wrs:ValueList/wrs:AnyValue[1]";

        tokens = parser.parse(xpath3);

        assertEquals(4, tokens.size());

    }
}
