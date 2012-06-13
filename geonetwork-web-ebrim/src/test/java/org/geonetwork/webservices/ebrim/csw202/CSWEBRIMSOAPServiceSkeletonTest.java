package org.geonetwork.webservices.ebrim.csw202;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class CSWEBRIMSOAPServiceSkeletonTest extends AbstractDependencyInjectionSpringContextTests {

	CSWEBRIMSOAPServiceSkeleton csw202Service;

	protected String[] getConfigLocations() {
		return new String[] { "applicationContext-gn-hibernate-ebrim-test.xml",
				"applicationContext-gn-persistence-ebrim.xml", "applicationContext-gn-services-ebrim.xml",
				"applicationContext-gn-web-ebrim.xml" };
	}

	public void testGetRecords() {
		assertNotNull(csw202Service);
		assertNotNull(csw202Service.csw202Service);
	}

	public void testGetDomain() {
		// fail("Not yet implemented");
	}

	public void testGetRecordByIdXml() {
		// fail("Not yet implemented");
	}

	public void testDescribeRecord() {
		// fail("Not yet implemented");
	}

	public void setCsw202Service(CSWEBRIMSOAPServiceSkeleton csw202Service) {
		this.csw202Service = csw202Service;
	}

}
