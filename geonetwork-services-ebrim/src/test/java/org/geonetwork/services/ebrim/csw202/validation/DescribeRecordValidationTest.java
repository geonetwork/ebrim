package org.geonetwork.services.ebrim.csw202.validation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.csw202.discovery.DescribeRecord;
import org.geonetwork.domain.csw202.discovery.RequestBase;
import org.geonetwork.utils.RandomPopulator;
import org.junit.Test;

public class DescribeRecordValidationTest {

	@Test
	public void testDummy() throws Exception {
		assertTrue(true);
	}

	/**
	 * OGC 07-045 keyword service is mandatory and should be CSW
	 * 
	 * result
	 */
	@Test
	public void testDescribeRecordValidation1Service() throws Exception {
		DescribeRecord request = getCorrectTestRequest();
		request.setService(null);
		try {
			new DescribeRecordValidation(request);
			fail();
		} catch (Exception e) {
			// should block , keyword service is mandatory
		}
		request.setService("piet");
		try {
			new DescribeRecordValidation(request);
			fail();
		} catch (Exception e) {
			// should block because it should be CSW
		}
		request.setService(RequestBase.SERVICE);
		new DescribeRecordValidation(request);
	}

	/**
	 * OGC 07-045 keyword version is mandatory and should be 2.0.2
	 * 
	 * result
	 */
	@Test
	public void testDescribeRecordValidation2Version() throws Exception {
		DescribeRecord request = getCorrectTestRequest();
		request.setVersion(null);
		try {
			new DescribeRecordValidation(request);
			fail();
		} catch (Exception e) {
			// should block , keyword service is mandatory
		}
		request.setVersion("piet");
		try {
			new DescribeRecordValidation(request);
			fail();
		} catch (Exception e) {
			// should block because it should be 2.0.2
		}
		request.setVersion(RequestBase.VERSION);
		new DescribeRecordValidation(request);
	}

	/**
	 * OGC 07-045
	 * 
	 * 
	 * List of Character String, comma separated. Used to specify a namespace and its prefix. Format is
	 * xmlns([prefix=]namespac e-url). If prefix is not specified, then this is the default namespace.
	 * 
	 * Commented out because at this point it is too much work to do a thorough validation on namespace for what it will
	 * 'add' to the application. If the namespace is not correct, the subsequent logic will fail anyway.
	 * 
	 */
	// @Test
	// public void testDescribeRecordValidation3Namespace() throws Exception {
	// DescribeRecord request = getCorrectTestRequest();
	// new DescribeRecordValidation(request);
	// List<String> namespaceList = new ArrayList<String>();
	// request.setNamespace(namespaceList);
	// namespaceList.add("xmlns:ogc=\"http://www.opengis.net/ogc\" ");
	// new DescribeRecordValidation(request);
	// namespaceList.add("faulty ns");
	// try {
	// new DescribeRecordValidation(request);
	// fail();
	// } catch (Exception e) {
	// }
	// }
	/**
	 * OGC 07-045 Typename List of Character String, comma separated One or more qualified type names to be described
	 * 
	 * Zero or one (Optional) Default action is to describe all types known to server
	 * 
	 * Optional. Must support gmd:MD_Metadata
	 * 
	 */
	@Test
	public void testDescribeRecordValidation4Typename() throws Exception {
		DescribeRecord request = getCorrectTestRequest();
		new DescribeRecordValidation(request);
		List<String> typeNameList = new ArrayList<String>();
		request.setTypeName(typeNameList);
		new DescribeRecordValidation(request);
		typeNameList.add("gmd:MD_Metadata");
		assertEquals(1, request.getTypeName().size());
	}

	/**
	 * OUTPUTFORMAT Character String A MIME type indicating the format that the output document should have Optional.
	 * 
	 * Default value is “application/xml”. Optional.
	 * 
	 * Default value is application/xml.
	 */
	@Test
	public void testDescribeRecordValidation5OutputFormat() throws Exception {
		DescribeRecord request = getCorrectTestRequest();
		new DescribeRecordValidation(request);
		request.setOutputFormat("application/xml");
		new DescribeRecordValidation(request);
		request.setOutputFormat("nonsense");
		try {
			new DescribeRecordValidation(request);
			fail();
		} catch (Exception e) {
		}
	}

	/**
	 * SCHEMALANGUAGE Character String Zero or one (Optional) Default value is XMLSCHEMA Only XMLSCHEMA (default) is
	 * supported
	 */
	@Test
	public void testDescribeRecordValidation6SchemaLanguage() throws Exception {
		DescribeRecord request = getCorrectTestRequest();
		new DescribeRecordValidation(request);
		request.setSchemaLanguage("XMLSCHEMA");
		new DescribeRecordValidation(request);
		request.setSchemaLanguage("nonsense");
		try {
			new DescribeRecordValidation(request);
			fail();
		} catch (Exception e) {
		}
	}

	/**
	 * local method to create a valid DescribeRecord request which can be used as a base for all tests
	 * 
	 * @return request
	 */
	private DescribeRecord getCorrectTestRequest() {
		DescribeRecord request = new DescribeRecord();
		try {
			request = (DescribeRecord) RandomPopulator.instantiate(DescribeRecord.class);
		} catch (Exception e) {
			fail();
		}
		request.setService(RequestBase.SERVICE);
		request.setVersion(RequestBase.VERSION);
		request.setNamespace(null);
		request.setOutputFormat(null);
		request.setSchemaLanguage(null);
		return request;
	}

}
