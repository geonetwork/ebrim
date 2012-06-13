package org.geonetwork.client.ebrim.csw202;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import junit.framework.TestCase;

public class ISO19139ClientTest extends TestCase {

	public void _testWebInsert1() throws FileNotFoundException, GeoNetworkClientException {
		ISO19139Client client = new ISO19139Client();
		FileInputStream xml = new FileInputStream(new File(DataResource.iso19139));
		client.webInsert(xml);
	}

	public void _testWebInsert2() throws FileNotFoundException, GeoNetworkClientException {
		System.getProperties().setProperty(ISO19139Client.urlPropertyName, ISO19139Client.defaultUrl);
		ISO19139Client client = new ISO19139Client();
		FileInputStream xml = new FileInputStream(new File(DataResource.iso19139));
		client.webInsert(xml);
		System.getProperties().setProperty(ISO19139Client.urlPropertyName, "blaat");
		System.out.println(System.getProperties().getProperty(ISO19139Client.urlPropertyName));
		System.getProperties().setProperty(ISO19139Client.urlPropertyName, "blaat");
		try {
			client.webInsert(xml);
			fail();
		} catch (Exception e) {
		}
		System.getProperties().setProperty(ISO19139Client.urlPropertyName, ISO19139Client.defaultUrl);
		client.webInsert(xml);
	}

	public void _testWebDelete() throws FileNotFoundException, GeoNetworkClientException {
		ISO19139Client client = new ISO19139Client();
		FileInputStream xml = new FileInputStream(new File(DataResource.iso19139));
		// client.webInsert(xml);

		String iso19139Id = "test_iso19139Id";

		client.webDelete(iso19139Id);
	}

	/**
	 * Latest status
	 * 
	 * Correct processed files: 0
	 * 
	 * fail processed files: 85
	 * 
	 * The problem is this: The abstract of the ISO allows larger fields. Ebrim allows 1024. We decided to cut this.
	 * TODO cut this.
	 * 
	 * 
	 * 
	 * @throws FileNotFoundException
	 */
	public void testWebInsert16Untill100() throws FileNotFoundException {
		ISO19139Client client = new ISO19139Client();

		String fileName = "src/test/resources/data/ESA_ISO19139_test_metadata/";
		String fileNameExtension = ".xml";

		int correct = 0;
		int fail = 0;

		for (int i = 16; i < 101; i++) {
			String realFileName = fileName + i + fileNameExtension;
			FileInputStream xml = new FileInputStream(new File(
					"src/test/resources/data/ESA_ISO19139_test_metadata/16.xml"));
			try {
				client.webInsert(xml);
				correct++;
			} catch (GeoNetworkClientException e) {
				fail++;
			}
		}

		System.out.println(" Correct processed files: " + correct);
		System.out.println(" fail processed files: " + fail);
		assertEquals(84, correct);

	}

}
