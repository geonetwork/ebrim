package org.geonetwork.domain.csw202.discovery;

import org.junit.Test;
import org.jibx.runtime.*;
import org.geonetwork.domain.ebrim.test.utilities.csw202.discovery.GetRecordsFactory;

import java.io.*;

import junit.framework.TestCase;

/**
 * Test for GetRecords class
 *
 * @author Jose
 */
public class GetRecordsTest extends TestCase {
    
	/**
	 * Tests unmarshalling GetRecords with csw:Query containing a Filter.
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
    @Test
	public void testUnmarshalFilter() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/csw202-discovery/GetRecordsTestData.xml"));
		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(GetRecords.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
		// unmarshal to GetRecords
		GetRecords unMarshallingResult = (GetRecords) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		// get expected result from test factory
		GetRecords expectedResult = GetRecordsFactory.createFilter();
				
		// test equality
		assertEquals("Unmarshalling GetRecords", expectedResult, unMarshallingResult);
	}
	/**
	 * Tests unmarshalling GetRecords with csw:Query containing a CQL Query (not supported).
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
    @Test
	public void testUnmarshalCQLQuery() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/csw202-discovery/GetRecordsTestData4.xml"));
		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(GetRecords.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
		// unmarshal to GetRecords
		GetRecords unMarshallingResult = (GetRecords) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		// get expected result from test factory
		GetRecords expectedResult = GetRecordsFactory.createCQL();
		
		// test equality
		assertEquals("Unmarshalling GetRecords", expectedResult, unMarshallingResult);
	}
	/**
	 * Tests unmarshalling GetRecords with rim:AdhocQuery.
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
    @Test
	public void testUnmarshalAdhocQuery() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/csw202-discovery/GetRecordsTestData3.xml"));
		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(GetRecords.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
		// unmarshal to GetRecords
		GetRecords unMarshallingResult = (GetRecords) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		// get expected result from test factory
		GetRecords expectedResult = GetRecordsFactory.createAdhocQuery();	
		// test equality
		assertEquals("Unmarshalling GetRecords", expectedResult, unMarshallingResult);
	}
	/**
	 * Tests unmarshalling GetRecords with wrs:AdhocQuery (not supported).
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 
    @Test
	public void testUnmarshalAdhocQuery() throws FileNotFoundException, JiBXException {
		// get input XML from file system
		FileInputStream fis = new FileInputStream(new File("src/test/resources/csw202-discovery/GetRecordsTestData5.xml"));
		// create JiBX unmarshal context
		IBindingFactory bfact = BindingDirectory.getFactory(GetRecords.class);
		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
		// unmarshal to GetRecords
		GetRecords unMarshallingResult = (GetRecords) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		// get expected result from test factory
		GetRecords expectedResult = GetRecordsFactory.createAdhoc();
		System.out.println("results actual / expected :\n\n");
		System.out.println(unMarshallingResult + " " + expectedResult);
		System.out.println(unMarshallingResult.getOutputFormat() + " " + expectedResult.getOutputFormat());
		System.out.println(unMarshallingResult.getOutputSchema() + " " + expectedResult.getOutputSchema());
		System.out.println(unMarshallingResult.getRequestID() + " " + expectedResult.getRequestID());
		System.out.println(unMarshallingResult.getService() + " " + expectedResult.getService());
		System.out.println(unMarshallingResult.getVersion() + " " + expectedResult.getVersion());
		System.out.println(unMarshallingResult.hashCode() + " " + expectedResult.hashCode());
		System.out.println(unMarshallingResult.getMaxRecords() + " " + expectedResult.getMaxRecords());
		System.out.println(unMarshallingResult.getResultType() + " " + expectedResult.getResultType());
		System.out.println(unMarshallingResult.getStoredQuery() + " " + expectedResult.getStoredQuery());
		System.out.println(unMarshallingResult.getQuery() + " " + expectedResult.getQuery());
		System.out.println(unMarshallingResult.getQuery().getConstraint() + " " + expectedResult.getQuery().getConstraint());
		System.out.println(unMarshallingResult.getQuery().getConstraint().getCQLText() + " " + expectedResult.getQuery().getConstraint().getCQLText());
				
			// test equality
		assertEquals("Unmarshalling GetRecords", expectedResult, unMarshallingResult);
	}*/
    
}
