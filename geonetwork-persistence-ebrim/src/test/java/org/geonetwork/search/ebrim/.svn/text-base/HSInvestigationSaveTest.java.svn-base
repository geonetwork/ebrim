package org.geonetwork.search.ebrim;

import org.geonetwork.dao.ebrim.AbstractCommitDaoTest;
import org.geonetwork.dao.ebrim.informationmodel.ProvenanceDao;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject.Annotation;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.utils.RandomPopulator;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.vividsolutions.jts.util.Stopwatch;

public class HSInvestigationSaveTest extends AbstractCommitDaoTest {

	EbrimGenericSearchDao ebrimGenericSearchDao;
	ProvenanceDao provenanceDao;
	LocalSessionFactoryBean sessionFactory;


	public void testSave() throws Exception {

		String searchTerm = "piet";
		Annotation a1 = (Annotation) RandomPopulator.instantiate(Annotation.class, null);
		LocalizedString ls = (LocalizedString) RandomPopulator.instantiate(LocalizedString.class, null);
		ls.setValue(searchTerm);
		a1.getDescription().getLocalizedStrings().add(ls);

		Annotation a2 = (Annotation) RandomPopulator.instantiate(Annotation.class, null);
		LocalizedString ls2 = (LocalizedString) RandomPopulator.instantiate(LocalizedString.class, null);
		ls2.setValue(searchTerm);
		a2.getDescription().getLocalizedStrings().add(ls2);

		
		Stopwatch sw = new Stopwatch();
		String log = "";
		sw.start();
		//extrinsicObjectBeDao.saveAnnotation(a1);
		log = log + " saveAnnotation1: " + sw.getTimeString();
		sw.stop();
		sw.reset();
		sw.start();
		//extrinsicObjectBeDao.saveAnnotation(a2);
		log = log + " saveAnnotation2: " + sw.getTimeString();
		sw.stop();

		System.out.println(log);

//		assertEquals(2, extrinsicObjectBeDao.loadAllAnnotation().size());

	}

	public void setEbrimGenericSearchDao(EbrimGenericSearchDao ebrimGenericSearchDao) {
		this.ebrimGenericSearchDao = ebrimGenericSearchDao;
	}

	public void setProvenanceDao(ProvenanceDao provenanceDao) {
		this.provenanceDao = provenanceDao;
	}

	public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public EbrimGenericSearchDao getEbrimGenericSearchDao() {
		return ebrimGenericSearchDao;
	}
	public ProvenanceDao getProvenanceDao() {
		return provenanceDao;
	}

}
