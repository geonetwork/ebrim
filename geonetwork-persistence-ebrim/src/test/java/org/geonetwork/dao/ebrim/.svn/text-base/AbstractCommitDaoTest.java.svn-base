package org.geonetwork.dao.ebrim;

import java.util.List;

import org.geonetwork.dao.ebrim.informationmodel.ClassificationDao;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalIdentifier;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalLink;
import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.ObjectRef;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public abstract class AbstractCommitDaoTest extends AbstractDependencyInjectionSpringContextTests {

	protected CoreDao coreDao;
	protected ClassificationDao classificationDao;
	protected TrashDetector trashDetector;

	protected String[] getConfigLocations() {
		return new String[] { "applicationContext-gn-hibernate-ebrim-test.xml",
				"applicationContext-gn-persistence-ebrim.xml" };
	}

	/**
	 * heikki: unfortunately, Spring's test support made setUp and tearDown final, so I cannot use them. So we'll need
	 * to call this method explicitly, all over the place ..
	 * 
	 */
	@Override
	protected void onTearDown() throws Exception {
		super.onTearDown();

		List<RegistryObject> trash5 = coreDao.loadAllRegistryObject();
		for (RegistryObject leftOver : trash5) {
			try {
				RegistryObject leftOverAux = coreDao.findRegistryObjectById(leftOver.getHibernateId());
				if (leftOverAux != null)
					coreDao.deleteRegistryObject(leftOverAux);
			} catch (HibernateObjectRetrievalFailureException e) {
				// Ignore exception > Object already deleted if has a relationship with another object
				// deleted before
			}
		}

		List<ExternalIdentifier> trash = coreDao.loadAllExternalIdentifier();
		for (ExternalIdentifier leftOver : trash) {
			coreDao.deleteExternalIdentifier(leftOver);
		}
		List<ExternalLink> trash2 = coreDao.loadAllExternalLink();
		for (ExternalLink leftOver : trash2) {
			coreDao.deleteExternalLink(leftOver);
		}
		List<ExtrinsicObject> trash3 = coreDao.loadAllExtrinsicObject();
		for (ExtrinsicObject leftOver : trash3) {
			coreDao.deleteExtrinsicObject(leftOver);
		}
		List<ObjectRef> trash4 = coreDao.loadAllObjectRef();
		for (ObjectRef leftOver : trash4) {
			coreDao.deleteObjectRef(leftOver);
		}

		List<Slot> trash6 = coreDao.loadAllSlot();
		for (Slot leftOver : trash6) {
			coreDao.deleteSlot(leftOver);
		}

		List<Classification> trash7 = classificationDao.loadAllClassification();
		for (Classification leftOver : trash7) {
			classificationDao.deleteClassification(leftOver);
		}

		List<ClassificationNode> trash8 = classificationDao.loadAllClassificationNode();
		for (ClassificationNode leftOver : trash8) {
			classificationDao.deleteClassificationNode(leftOver);
		}

		List<ClassificationScheme> trash9 = classificationDao.loadAllClassificationScheme();
		for (ClassificationScheme leftOver : trash9) {
			classificationDao.deleteClassificationScheme(leftOver);
		}
		trashDetector.runReport();
	}

	public void setCoreDao(CoreDao coreDao) {
		this.coreDao = coreDao;
	}

	public void setClassificationDao(ClassificationDao classificationDao) {
		this.classificationDao = classificationDao;
	}

	public void setTrashDetector(TrashDetector trashDetector) {
		this.trashDetector = trashDetector;
	}

}
