package org.geonetwork.services.ebrim.csw202;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.dao.facade.RegistryObjectListStoreFacade;
import org.geonetwork.domain.csw202.discovery.DescribeRecord;
import org.geonetwork.domain.csw202.discovery.DescribeRecordResponse;
import org.geonetwork.domain.csw202.discovery.SchemaComponent;
import org.geonetwork.services.ebrim.AbstractServicesTest;

/**
 * 
 * @author heikki doeleman
 * 
 */
public class DescribeRecordsTest extends AbstractServicesTest {

	CSW202Service csw202Service;
	RegistryObjectListStoreFacade registryObjectListStoreFacade;

	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		assertNotNull(csw202Service);
	}

	/**
	 * Fully specified DescribeRecord for ExtrinsicObjectType.
	 * 
	 * @throws Exception
	 */
	public void testDescribeRecord1() throws Exception {
		DescribeRecord describeRecord = new DescribeRecord();

		describeRecord.setOutputFormat("application/xml");
		describeRecord.setSchemaLanguage("http://www.w3.org/2001/XMLSchema");
		describeRecord.setService("CSW");
		describeRecord.setVersion("2.0.2");
		List<String> typenames = new ArrayList<String>();
		typenames.add("rim:ExtrinsicObjectType");
		describeRecord.setTypeName(typenames);
		List<String> namespaces = new ArrayList<String>();
		namespaces.add("rim=" + CSW202ServiceImpl.EBRIM_TNS);
		describeRecord.setNamespace(namespaces);

		DescribeRecordResponse response = csw202Service.describeRecord(describeRecord);

		List<SchemaComponent> schemaComponents = response.getSchemaComponent();
		assertEquals("# schemas loaded: ", 1, schemaComponents.size());
		for (SchemaComponent schemaComponent : schemaComponents) {
			// nice if you're looking
			System.out.println(schemaComponent.getSchema().toString());
		}
	}

	/**
	 * DescribeRecord without TypeNames but with Namespace (must return complete schema).
	 * 
	 * @throws Exception
	 */
	public void testDescribeRecord2() throws Exception {
		DescribeRecord describeRecord = new DescribeRecord();
		describeRecord.setOutputFormat("application/xml");
		describeRecord.setSchemaLanguage("http://www.w3.org/2001/XMLSchema");
		describeRecord.setService("CSW");
		describeRecord.setVersion("2.0.2");
		List<String> typenames = new ArrayList<String>();
		describeRecord.setTypeName(typenames);
		List<String> namespaces = new ArrayList<String>();
		namespaces.add("rim=" + CSW202ServiceImpl.EBRIM_TNS);
		describeRecord.setNamespace(namespaces);
		DescribeRecordResponse response = csw202Service.describeRecord(describeRecord);
		List<SchemaComponent> schemaComponents = response.getSchemaComponent();
		assertEquals("# schemas loaded: ", 1, schemaComponents.size());
		for (SchemaComponent schemaComponent : schemaComponents) {
			// nice if you're looking
			System.out.println(schemaComponent.getSchema().toString());
		}
	}

	/**
	 * DescribeRecord without TypeNames and without Namespaces.
	 * 
	 * @throws Exception
	 */
	public void testDescribeRecord3() throws Exception {
		DescribeRecord describeRecord = new DescribeRecord();
		describeRecord.setOutputFormat("application/xml");
		describeRecord.setSchemaLanguage("http://www.w3.org/2001/XMLSchema");
		describeRecord.setService("CSW");
		describeRecord.setVersion("2.0.2");
		List<String> typenames = new ArrayList<String>();
		describeRecord.setTypeName(typenames);
		List<String> namespaces = new ArrayList<String>();
		describeRecord.setNamespace(namespaces);
		DescribeRecordResponse response = csw202Service.describeRecord(describeRecord);
		List<SchemaComponent> schemaComponents = response.getSchemaComponent();
		assertEquals("# schemas loaded: ", 0, schemaComponents.size());
		for (SchemaComponent schemaComponent : schemaComponents) {
			// nice if you're looking
			System.out.println(schemaComponent.getSchema().toString());
		}
	}

	/**
	 * DescribeRecord for ExtrinsicObjectType with missing prefix declaration.
	 * 
	 * @throws Exception
	 */
	public void testDescribeRecord4() throws Exception {
		DescribeRecord describeRecord = new DescribeRecord();

		describeRecord.setOutputFormat("application/xml");
		describeRecord.setSchemaLanguage("http://www.w3.org/2001/XMLSchema");
		describeRecord.setService("CSW");
		describeRecord.setVersion("2.0.2");
		List<String> typenames = new ArrayList<String>();
		typenames.add("rim:ExtrinsicObjectType");
		describeRecord.setTypeName(typenames);
		List<String> namespaces = new ArrayList<String>();
		namespaces.add("different-prefix=" + CSW202ServiceImpl.EBRIM_TNS);
		describeRecord.setNamespace(namespaces);
		try {
			csw202Service.describeRecord(describeRecord);
			fail("Expected CSW202ServiceException");
		} catch (CSW202ServiceException x) {
			// OK
		}
	}

	/**
	 * Fully specified DescribeRecord for ExtrinsicObjectType using default schema.
	 * 
	 * @throws Exception
	 */
	public void testDescribeRecord5() throws Exception {
		DescribeRecord describeRecord = new DescribeRecord();

		describeRecord.setOutputFormat("application/xml");
		describeRecord.setSchemaLanguage("http://www.w3.org/2001/XMLSchema");
		describeRecord.setService("CSW");
		describeRecord.setVersion("2.0.2");
		List<String> typenames = new ArrayList<String>();
		typenames.add("ExtrinsicObjectType");
		describeRecord.setTypeName(typenames);
		List<String> namespaces = new ArrayList<String>();
		namespaces.add(CSW202ServiceImpl.EBRIM_TNS);
		describeRecord.setNamespace(namespaces);
		DescribeRecordResponse response = csw202Service.describeRecord(describeRecord);
		List<SchemaComponent> schemaComponents = response.getSchemaComponent();
		assertEquals("# schemas loaded: ", 1, schemaComponents.size());
		for (SchemaComponent schemaComponent : schemaComponents) {
			// nice if you're looking
			System.out.println(schemaComponent.getSchema().toString());
		}
	}

	/**
	 * DescribeRecord without TypeNames and without Namespaces - null version.
	 * 
	 * @throws Exception
	 */
	public void testDescribeRecord6() throws Exception {
		DescribeRecord describeRecord = new DescribeRecord();
		describeRecord.setOutputFormat("application/xml");
		describeRecord.setSchemaLanguage("http://www.w3.org/2001/XMLSchema");
		describeRecord.setService("CSW");
		describeRecord.setVersion("2.0.2");
		describeRecord.setTypeName(null);
		describeRecord.setNamespace(null);
		DescribeRecordResponse response = csw202Service.describeRecord(describeRecord);
		List<SchemaComponent> schemaComponents = response.getSchemaComponent();
		assertEquals("# schemas loaded: ", 0, schemaComponents.size());
		for (SchemaComponent schemaComponent : schemaComponents) {
			// nice if you're looking
			System.out.println(schemaComponent.getSchema().toString());
		}
	}

	/**
	 * Similair to this testmessage /geonetwork-teamengine-ebrim/testdata/SoapDescriberRecord1.xml
	 * 
	 * 
	 * @throws Exception
	 */
	public void testDescribeRecord7() throws Exception {
		DescribeRecord describeRecord = new DescribeRecord();
		describeRecord.setOutputFormat("application/xml");
		describeRecord.setSchemaLanguage("http://www.w3.org/2001/XMLSchema");
		describeRecord.setService("CSW");
		describeRecord.setVersion("2.0.2");
		
		List<String> typeName = new ArrayList<String>(); 
		typeName.add("csw:Record"); 
		describeRecord.setTypeName(typeName);
		List<String> namespace = new ArrayList<String>();
		namespace.add("tns=urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0"); 
		namespace.add("csw=http://www.opengis.net/cat/csw/2.0.2"); 
		describeRecord.setNamespace(namespace);
		DescribeRecordResponse response = csw202Service.describeRecord(describeRecord);
		List<SchemaComponent> schemaComponents = response.getSchemaComponent();
//		assertEquals("# schemas loaded: ", 1, schemaComponents.size());
//		for (SchemaComponent schemaComponent : schemaComponents) {
//			// nice if you're looking
//			System.out.println(schemaComponent.getSchema().toString());
//		}
	}

	public void setCsw202Service(CSW202Service csw202Service) {
		this.csw202Service = csw202Service;
	}

	public void setRegistryObjectStoreFacade(RegistryObjectListStoreFacade registryObjectListStoreFacade) {
		this.registryObjectListStoreFacade = registryObjectListStoreFacade;
	}
}
