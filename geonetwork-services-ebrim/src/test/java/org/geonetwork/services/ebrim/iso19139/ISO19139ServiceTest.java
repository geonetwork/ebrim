package org.geonetwork.services.ebrim.iso19139;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.geonetwork.services.ebrim.AbstractServicesTest;
import org.geonetwork.services.ebrim.GeonetworkServiceException;

public class ISO19139ServiceTest extends AbstractServicesTest {

	ISO19139Service iso19139Service;

	public void testDumyy() {
		assertTrue(true);
	}

	// TODO
	public void _testInsert() throws FileNotFoundException, GeonetworkServiceException {
		FileInputStream xml = new FileInputStream(new File(DataResource.iso19139));
		assertNotNull(xml);
		assertNotNull(iso19139Service);
		iso19139Service.insert(xml);
	}

	
	public void _testDelete() throws FileNotFoundException, GeonetworkServiceException {
		FileInputStream xml = new FileInputStream(new File(DataResource.iso19139));
		assertNotNull(xml);
		assertNotNull(iso19139Service);
		iso19139Service.insert(xml);
		String iso19139Id = " "; 
		iso19139Service.delete(iso19139Id);
	}

	
	
	
	/**
	 * Spring DI setter
	 * 
	 * @param iso19139Service
	 */
	public void setIso19139Service(ISO19139Service iso19139Service) {
		this.iso19139Service = iso19139Service;
	}

}