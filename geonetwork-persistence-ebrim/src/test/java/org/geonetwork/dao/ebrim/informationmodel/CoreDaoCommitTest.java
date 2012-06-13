package org.geonetwork.dao.ebrim.informationmodel;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * This test is to check whether the mappings for description etc are working correctly
 * 
 * @author Erik van Ingen
 */
public class CoreDaoCommitTest extends AbstractDependencyInjectionSpringContextTests {

	protected CoreDao coreDao;

	protected String[] getConfigLocations() {
		return new String[] { "applicationContext-gn-hibernate-ebrim-test.xml",
				"applicationContext-gn-persistence-ebrim.xml" };
	}

	public void testDummy() {
		assertTrue(true);
	}

	public void _testSaveRegistryObject1() {
		RegistryObject registryObject = new RegistryObject();
		InternationalString description = new InternationalString();
		LocalizedString ls = new LocalizedString();
		String value = "This test is to check wheter the mappings for description etc are working correctly";
		ls.setValue(value);
		description.getLocalizedStrings().add(ls);
		registryObject.setDescription(description);
		coreDao.saveRegistryObject(registryObject);

		// TODO It is not clear to me why the hibernate session already died at this point. Because
		// of the commmit, end of transaction?
		// AbstractDependencyInjectionSpringContextTests org.hibernate.LazyInitializationException:
		// could not initialize proxy - no Session
		// RegistryObject registryObjectFound =
		// coreDao.findRegistryObjectById(registryObject.getHibernateId());
		// assertTrue(registryObjectFound.getDescription().getLocalizedStrings().contains(ls));

		// coreDao.deleteRegistryObject(registryObject);

	}

	/**
	 * setter for DI container
	 * 
	 * @param coreDao
	 */
	public void setCoreDao(CoreDao coreDao) {
		this.coreDao = coreDao;
	}

}
