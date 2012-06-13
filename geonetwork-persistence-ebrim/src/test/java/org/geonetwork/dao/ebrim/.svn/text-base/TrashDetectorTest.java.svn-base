package org.geonetwork.dao.ebrim;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class TrashDetectorTest extends AbstractDependencyInjectionSpringContextTests {
	protected String[] getConfigLocations() {
		return new String[] { "applicationContext-gn-hibernate-ebrim-test.xml",
				"applicationContext-gn-persistence-ebrim.xml" };
	}

	TrashDetector trashDetector;

	public void testRunReport() {
		trashDetector.runReport();
	}

	public void setTrashDetector(TrashDetector trashDetector) {
		this.trashDetector = trashDetector;
	}
}
