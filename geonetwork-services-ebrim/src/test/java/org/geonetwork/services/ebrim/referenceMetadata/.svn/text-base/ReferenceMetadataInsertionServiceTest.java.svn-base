package org.geonetwork.services.ebrim.referenceMetadata;

import java.io.File;
import java.util.List;

import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryPackage;
import org.geonetwork.services.ebrim.AbstractServicesTest;
import org.geonetwork.services.ebrim.GeonetworkServiceException;
import org.junit.Test;

/**
 * Test class for ReferenceMetadataInsertionService
 * 
 * @author Jose
 */
public class ReferenceMetadataInsertionServiceTest extends AbstractServicesTest {

	// Identifiers of CIM extension package and Basic Extension package
	private final String CIM_PACKAGE_ID = "urn:ogc:def:ebRIM-RegistryPackage:OGC:CIM";
	private final String BASIC_EXTENSION_PACKAGE_ID = "urn:x-ogc:specification:csw-ebrim:package:Basic";

	ReferenceMetadataInsertionService referenceMetadataInsertionService;
	CoreDao coreDao;

	/**
	 * testing while using files on the filesystem
	 */
	@Test
	public void testInsert1() {
		String resourceMetadataPath = DataResource.resourceMetadata;
		try {
			File file = new File(resourceMetadataPath);
			assertTrue(file.isDirectory());
			referenceMetadataInsertionService.setResourceMetadataPath(resourceMetadataPath);
			referenceMetadataInsertionService.insert();
			performChecks();
		} catch (GeonetworkServiceException e) {
			fail();
		}
	}

	/**
	 * testing while using 1 file from the classpath
	 */
	@Test
	public void testInsert2() {
		try {
			referenceMetadataInsertionService.insert();
			performChecks();
		} catch (GeonetworkServiceException e) {
			fail();
		}
	}

	void performChecks() {

		List<RegistryPackage> regPackages = coreDao.loadAllRegistryPackage();
		// Check CIM extension package and Basic Extension package have been loaded
		assertNotNull(regPackages);
		assertEquals(2, regPackages.size());

		// Check identifiers of loaded packages
		RegistryPackage r1 = regPackages.get(0);
		RegistryPackage r2 = regPackages.get(1);

		assertTrue(r1.getId().getValue().equals(CIM_PACKAGE_ID)
				|| r1.getId().getValue().equals(BASIC_EXTENSION_PACKAGE_ID));

		assertTrue(r2.getId().getValue().equals(CIM_PACKAGE_ID)
				|| r2.getId().getValue().equals(BASIC_EXTENSION_PACKAGE_ID));

		assertFalse(r1.getId().getValue().equals(r2.getId().getValue()));

	}

	public void setReferenceMetadataInsertionService(ReferenceMetadataInsertionService referenceMetadataInsertionService) {
		this.referenceMetadataInsertionService = referenceMetadataInsertionService;
	}

	public void setCoreDao(CoreDao coreDao) {
		this.coreDao = coreDao;
	}
}
