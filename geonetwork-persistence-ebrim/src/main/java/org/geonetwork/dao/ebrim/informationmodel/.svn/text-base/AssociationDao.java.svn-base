package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class AssociationDao extends HibernateDaoSupport {
	/**
	 * Association
	 */
	public void saveAssociation(Association association) {
		this.getHibernateTemplate().save(association);
	}

	public void mergeAssociation(Association association) {
		this.getHibernateTemplate().merge(association);
	}

	public void deleteAssociation(Association association) {
		this.getHibernateTemplate().delete(association);
	}

	@SuppressWarnings("unchecked")
	public List<Association> loadAllAssociation() {
		return this.getHibernateTemplate().loadAll(Association.class);
	}

	public Association findAssociationById(long id) {
		return (Association) this.getHibernateTemplate().load(Association.class, id);
	}

}
