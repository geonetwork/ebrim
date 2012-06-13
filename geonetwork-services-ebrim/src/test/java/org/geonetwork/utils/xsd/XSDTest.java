package org.geonetwork.utils.xsd;

import org.geonetwork.utils.xsd.XSD.State;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.junit.Test;

import junit.framework.TestCase;
/**
 * 
 * @author heikki doeleman
 *
 */
public class XSDTest extends TestCase {
	public XSDTest(String name) {
		super(name);
	}
	
	/**
	 * The XSD should be loaded. If it is partially loaded, we consider that's fine.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testXSDLoadingFromFile() throws java.lang.Exception {
		XSD xsd = new XSD("xsd/pkg-basic.xsd");
		State state = xsd.getState();
		assertNotSame(State.NOTHING_LOADED, state);
	}

	/**
	 * The XSD should be loaded. If it is partially loaded, we consider that's fine. NOTE this will fail if 
	 * an internet connection cannot be established or if the site containing the csw schema 
	 * is otherwise unavailable.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testXSDLoadingFromHTTP() throws java.lang.Exception {
		XSD xsd = new XSD("http://schemas.opengis.net/csw/2.0.2/CSW-discovery.xsd");
		Element element = xsd.findElementByName("GetCapabilitiesType", "http://www.opengis.net/cat/csw/2.0.2");
		assertNotNull(element);
		// nice if you're looking
		new XMLOutputter().output(element, System.out);
		State state = xsd.getState();
		assertNotSame(State.NOTHING_LOADED, state);
	}
	
	/**
	 * Find an element in the loaded schema.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testFindElementByName1() throws java.lang.Exception  {
		XSD xsd = new XSD("xsd/pkg-basic.xsd");
		Element element = xsd.findElementByName("ValueListType", "http://www.opengis.net/cat/wrs");
		// nice if you're looking
		new XMLOutputter().output(element, System.out);
		assertNotNull(element);
	}
	
	/**
	 * Find an element in a schema imported by the loaded schema. NOTE this will fail if 
	 * an internet connection cannot be established or if the site containing the ebrim schema 
	 * is otherwise unavailable.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testFindElementByName2() throws java.lang.Exception  {
		XSD xsd = new XSD("xsd/pkg-basic.xsd");
		Element element = xsd.findElementByName("ExtrinsicObjectType", "urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0");
		// nice if you're looking
		new XMLOutputter().output(element, System.out);
		assertNotNull(element);
	}
	
	/**
	 * Do not find an element in the loaded schema if the namespace is incorrect.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testFindElementByName3() throws java.lang.Exception  {
		XSD xsd = new XSD("xsd/pkg-basic.xsd");
		Element element = xsd.findElementByName("ValueListType", "incorrect namespace");
		assertNull(element);
	}	

	/**
	 * Test null input.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testFindElementByName4() throws java.lang.Exception  {
		XSD xsd = new XSD(null);
		Element element = xsd.findElementByName(null, null);
		assertNull(element);
		assertEquals(State.NOTHING_LOADED, xsd.getState());
	}		

	/**
	 * Check state after loading nonexisting schema.
	 * @throws java.lang.Exception
	 */
	@Test
	public void testFindElementByName5() throws java.lang.Exception  {
		XSD xsd = new XSD("xsd/XXXXpkg-basic.xsd");
		assertEquals(State.NOTHING_LOADED, xsd.getState());
	}	


    @Test
	public void testFindElementByName6() throws java.lang.Exception  {
		XSD xsd = new XSD("xsd/csw-ebrim.xsd");
        Element element = xsd.findElementByName("Record", "http://www.opengis.net/cat/csw/2.0.2");
		assertNotNull(element);
        // nice if you're looking
		new XMLOutputter().output(element, System.out);
		State state = xsd.getState();
		assertNotSame(State.NOTHING_LOADED, state);
	}


}
