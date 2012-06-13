package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.cooperatingregistries.Federation;
import org.geonetwork.domain.ebrim.informationmodel.cooperatingregistries.Registry;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * Dao for Federation and Registry
 * 
 * @author Erik van Ingen
 * 
 */

public class CooperatingRegistriesDao extends HibernateDaoSupport {

	/**
	 * Federation
	 */
	public void saveFederation(Federation association) {
		this.getHibernateTemplate().save(association);
	}

	public void mergeFederation(Federation association) {
		this.getHibernateTemplate().merge(association);
	}

	public void deleteFederation(Federation association) {
		this.getHibernateTemplate().delete(association);
	}

	@SuppressWarnings("unchecked")
	public List<Federation> loadAllFederation() {
		return this.getHibernateTemplate().loadAll(Federation.class);
	}

	public Federation findFederationById(long id) {
		return (Federation) this.getHibernateTemplate().load(Federation.class, id);
	}

	/**
	 * Registry
	 */
	public void saveRegistry(Registry association) {
		this.getHibernateTemplate().save(association);
	}

	public void mergeRegistry(Registry association) {
		this.getHibernateTemplate().merge(association);
	}

	public void deleteRegistry(Registry association) {
		this.getHibernateTemplate().delete(association);
	}

	@SuppressWarnings("unchecked")
	public List<Registry> loadAllRegistry() {
		return this.getHibernateTemplate().loadAll(Registry.class);
	}

	public Registry findRegistryById(long id) {
		return (Registry) this.getHibernateTemplate().load(Registry.class, id);
	}

}
