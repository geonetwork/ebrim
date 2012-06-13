package org.geonetwork.gaap.dao;

import org.springframework.test.AbstractTransactionalSpringContextTests;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;


public abstract class AbstractDaoTest extends AbstractTransactionalSpringContextTests {

	protected String[] getConfigLocations() {
		return new String[] { "applicationContext-gn-persistence-gaap-test.xml", "applicationContext-gn-persistence-gaap.xml" };
	}

}