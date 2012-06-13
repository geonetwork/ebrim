package org.geonetwork.dao.ebrim.informationmodel;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.provenance.DaoTestDelegate;
import org.geonetwork.domain.ebrim.informationmodel.cooperatingregistries.Federation;
import org.geonetwork.domain.ebrim.informationmodel.cooperatingregistries.Registry;
import org.geonetwork.domain.ebrim.informationmodel.xsd.Duration;
import org.geonetwork.domain.ebrim.test.utilities.cooperatingregistries.FederationFactory;

public class CooperatingRegistriesDaoTest extends AbstractDaoTest {
	CooperatingRegistriesDao cooperatingRegistriesDao;

	public void setCooperatingRegistriesDao(CooperatingRegistriesDao cooperatingRegistriesDao) {
		this.cooperatingRegistriesDao = cooperatingRegistriesDao;
	}

	/**
	 * Federation
	 */
	public void testSaveFederation() {
		new DaoTestDelegate(cooperatingRegistriesDao).testSave(Federation.class);
	}

	public void testMergeFederation1() {
		Federation federation = FederationFactory.create();
		cooperatingRegistriesDao.saveFederation(federation);
		Duration duration = new Duration();
		duration.setHours(2);
		federation.setReplicationSyncLatency(duration);
		cooperatingRegistriesDao.mergeFederation(federation);
		assertEquals(2, cooperatingRegistriesDao.findFederationById(federation.getHibernateId())
				.getReplicationSyncLatency().getHours());
	}

	public void testDeleteFederation() {
		new DaoTestDelegate(cooperatingRegistriesDao).testDelete(Federation.class);
	}

	public void testfindFederationById() {
		new DaoTestDelegate(cooperatingRegistriesDao).testfindById(Federation.class);
	}

	/**
	 * Registry
	 */
	public void testSaveRegistry() {
		new DaoTestDelegate(cooperatingRegistriesDao).testSave(Registry.class);
	}

	public void testMergeRegistry1() {
		new DaoTestDelegate(cooperatingRegistriesDao).testMerge(Registry.class, "conformanceProfile");
	}

	public void testMergeRegistry2() {
		new DaoTestDelegate(cooperatingRegistriesDao).testMerge(Registry.class, "operator");
	}

	public void testMergeRegistry4() {
		new DaoTestDelegate(cooperatingRegistriesDao).testMerge(Registry.class, "specificationVersion");
	}

	public void testDeleteRegistry() {
		new DaoTestDelegate(cooperatingRegistriesDao).testDelete(Registry.class);
	}

	public void testfindRegistryById() {
		new DaoTestDelegate(cooperatingRegistriesDao).testfindById(Registry.class);
	}

}
