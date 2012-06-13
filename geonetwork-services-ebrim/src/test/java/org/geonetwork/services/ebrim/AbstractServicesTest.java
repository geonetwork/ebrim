package org.geonetwork.services.ebrim;

import org.springframework.test.AbstractTransactionalSpringContextTests;

public abstract class AbstractServicesTest extends AbstractTransactionalSpringContextTests {

	protected String[] getConfigLocations() {
		return new String[] { "applicationContext-gn-hibernate-ebrim-test.xml",
				"applicationContext-gn-persistence-ebrim.xml", "applicationContext-gn-services-ebrim.xml" };
	}

}
