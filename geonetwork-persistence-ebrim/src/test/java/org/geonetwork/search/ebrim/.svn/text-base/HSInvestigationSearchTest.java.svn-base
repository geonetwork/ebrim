package org.geonetwork.search.ebrim;

import java.util.List;

import org.geonetwork.dao.ebrim.AbstractCommitDaoTest;
import org.geonetwork.dao.ebrim.informationmodel.ProvenanceDao;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalIdentifier;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.utils.RandomPopulator;

import com.vividsolutions.jts.util.Stopwatch;

public class HSInvestigationSearchTest extends AbstractCommitDaoTest {

	EbrimGenericSearchDao ebrimGenericSearchDao;
	ProvenanceDao provenanceDao;


	public void testDummy() {
		assertTrue(true);
	}

	/**
	 * 
	 * this search works only in combination with the HSInvestigationSaveTest and is not meant to
	 * run in every build.
	 */
	public void _testSearch() throws Exception {

		String searchTerm = "piet";
		ExternalIdentifier a1 = (ExternalIdentifier) RandomPopulator.instantiate(ExternalIdentifier.class, null);
		URI identificationScheme = new URI();
		identificationScheme.setValue(searchTerm);
		URI registryObject = new URI();
		registryObject.setValue(searchTerm);
		LongName longName = new LongName();
		longName.setValue(searchTerm);
		a1.setValue(longName);
		a1.setIdentificationScheme(identificationScheme);
		a1.setRegistryObject(registryObject);
		Stopwatch sw = new Stopwatch();
		String log = "";

		String[] properties = { "registryObject.value" };

		List<Object> list = ebrimGenericSearchDao.search(searchTerm, properties, ExternalIdentifier.class);

		log = log + " search: " + sw.getTimeString();
		sw.stop();
		sw.reset();
		sw.start();

		list = ebrimGenericSearchDao.search(searchTerm, properties, ExternalIdentifier.class);

		log = log + " search?: " + sw.getTimeString();
		sw.stop();

		System.out.println(log);

		assertEquals(1, list.size());

		assertTrue(list.get(0) instanceof ExternalIdentifier);

	}

	public void setEbrimGenericSearchDao(EbrimGenericSearchDao ebrimGenericSearchDao) {
		this.ebrimGenericSearchDao = ebrimGenericSearchDao;
	}

	public void setProvenanceDao(ProvenanceDao provenanceDao) {
		this.provenanceDao = provenanceDao;
	}

	public EbrimGenericSearchDao getEbrimGenericSearchDao() {
		return ebrimGenericSearchDao;
	}

	public ProvenanceDao getProvenanceDao() {
		return provenanceDao;
	}

}
