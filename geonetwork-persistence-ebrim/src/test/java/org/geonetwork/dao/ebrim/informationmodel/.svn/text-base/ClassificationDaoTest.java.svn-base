package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.provenance.DaoTestDelegate;
import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;

public class ClassificationDaoTest extends AbstractDaoTest {
    ClassificationDao classificationDao;

	/**
	 * heikki: unfortunately, Spring's test support made setUp and tearDown final, so
	 * I cannot use them. So we'll need to call this method explicitly, all over the place ..
	 *
	 */
	private void emptyTrash() {
		List<Classification> trash = classificationDao.loadAllClassification();
		for(Classification leftOver : trash) {
			classificationDao.deleteClassification(leftOver);
    }
		List<ClassificationNode> trash2 = classificationDao.loadAllClassificationNode();
		for(ClassificationNode leftOver2 : trash2) {
			classificationDao.deleteClassificationNode(leftOver2);
    }
		List<ClassificationScheme> trash3 = classificationDao.loadAllClassificationScheme();
		for(ClassificationScheme leftOver3 : trash3) {
			classificationDao.deleteClassificationScheme(leftOver3);
    }
	}

	public void setClassificationDao(ClassificationDao classificationDao) {
		this.classificationDao = classificationDao;
    }

    /**
     * Classification
     */
    public void testSaveClassification() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testSaveExpectsGreater(Classification.class);
    }

    public void testMergeClassification1() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testMergeExpectsGreater(Classification.class, "classificationScheme");
    }

    public void testMergeClassification2() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testMergeExpectsGreater(Classification.class, "classificationNode");
    }

    public void testMergeClassification3() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testMergeExpectsGreater(Classification.class, "classifiedObject");
    }

    public void testMergeClassification4() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testMergeExpectsGreater(Classification.class, "nodeRepresentation");
    }

    public void testDeleteClassification() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testDeleteExpectsGreater(Classification.class);
    }

    public void testfindClassificationById() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testfindByIdExpectsGreater(Classification.class);
    }

    /**
     * ClassificationNode
     */
    public void testSaveClassificationNode() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testSave(ClassificationNode.class);
    }

    public void testMergeClassificationNode1() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testMerge(ClassificationNode.class, "parent");
    }

    public void testMergeClassificationNode2() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testMerge(ClassificationNode.class, "code");
    }

    public void testDeleteClassificationNode() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testDelete(ClassificationNode.class);
    }

    public void testfindClassificationNodeById() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testfindById(ClassificationNode.class);
    }

    /**
     * ClassificationScheme
     */
    public void testSaveClassificationScheme() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testSave(ClassificationScheme.class);
        emptyTrash();
    }

    public void testMergeClassificationScheme2() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testMerge(ClassificationScheme.class, "nodeType");
    }

    public void testDeleteClassificationScheme() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testDelete(ClassificationScheme.class);
    }

    public void testfindClassificationSchemeById() {
        emptyTrash();
        new DaoTestDelegate(classificationDao).testfindById(ClassificationScheme.class);
    }

}
