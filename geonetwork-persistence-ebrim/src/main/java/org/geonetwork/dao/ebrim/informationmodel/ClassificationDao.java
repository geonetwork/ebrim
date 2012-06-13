package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ClassificationDao extends HibernateDaoSupport {
	/**
	 * Classification
	 */
	public void saveClassification(Classification classification) {
		this.getHibernateTemplate().save(classification);
	}

	public void mergeClassification(Classification classification) {
		this.getHibernateTemplate().merge(classification);
	}

	public void deleteClassification(Classification classification) {
		this.getHibernateTemplate().delete(classification);
	}

	@SuppressWarnings("unchecked")
	public List<Classification> loadAllClassification() {
		return this.getHibernateTemplate().loadAll(Classification.class);
	}

	public Classification findClassificationById(long id) {
		return (Classification) this.getHibernateTemplate().load(Classification.class, id);
	}

	/**
	 * ClassificationNode
	 */
	public void saveClassificationNode(ClassificationNode classificationNode) {
		this.getHibernateTemplate().save(classificationNode);
	}

	public void mergeClassificationNode(ClassificationNode classificationNode) {
		this.getHibernateTemplate().merge(classificationNode);
	}

	public void deleteClassificationNode(ClassificationNode classificationNode) {
		this.getHibernateTemplate().delete(classificationNode);
	}

	@SuppressWarnings("unchecked")
	public List<ClassificationNode> loadAllClassificationNode() {
		return this.getHibernateTemplate().loadAll(ClassificationNode.class);
	}

	public ClassificationNode findClassificationNodeById(long id) {
		return (ClassificationNode) this.getHibernateTemplate().load(ClassificationNode.class, id);
	}

    public List<ClassificationNode> findClassificationNodesByParent(String urnId) {
        List<ClassificationNode> classificationNodes = this.getHibernateTemplate().find(
                "from org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode reg where reg.parent.value = ?",urnId);

       return classificationNodes;
	}

	/**
	 * ClassificationScheme
	 */
	public void saveClassificationScheme(ClassificationScheme classificationScheme) {
		this.getHibernateTemplate().save(classificationScheme);
	}

	public void mergeClassificationScheme(ClassificationScheme classificationScheme) {
		this.getHibernateTemplate().merge(classificationScheme);
	}

	public void deleteClassificationScheme(ClassificationScheme classificationScheme) {
		this.getHibernateTemplate().delete(classificationScheme);
	}

	@SuppressWarnings("unchecked")
	public List<ClassificationScheme> loadAllClassificationScheme() {
		return this.getHibernateTemplate().loadAll(ClassificationScheme.class);
	}

	public ClassificationScheme findClassificationSchemeById(long id) {
		return (ClassificationScheme) this.getHibernateTemplate().load(ClassificationScheme.class, id);
	}

}
