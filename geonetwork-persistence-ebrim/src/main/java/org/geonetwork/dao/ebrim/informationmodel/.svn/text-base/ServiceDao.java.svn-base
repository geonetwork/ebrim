package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.service.Service;
import org.geonetwork.domain.ebrim.informationmodel.service.ServiceBinding;
import org.geonetwork.domain.ebrim.informationmodel.service.SpecificationLink;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * Dao for Service, ServiceBinding and SpecificationLink
 * 
 * 
 * @author Erik van Ingen
 * 
 */
public class ServiceDao extends HibernateDaoSupport {

	/**
	 * Service
	 */
	public void saveService(Service service) {
		this.getHibernateTemplate().save(service);
	}

	public void mergeService(Service service) {
		this.getHibernateTemplate().merge(service);
	}

	public void deleteService(Service service) {
		this.getHibernateTemplate().delete(service);
	}

	@SuppressWarnings("unchecked")
	public List<Service> loadAllService() {
		return this.getHibernateTemplate().loadAll(Service.class);
	}

	public Service findServiceById(long id) {
		return (Service) this.getHibernateTemplate().load(Service.class, id);
	}

	/**
	 * ServiceBinding
	 */
	public void saveServiceBinding(ServiceBinding serviceBinding) {
		this.getHibernateTemplate().save(serviceBinding);
	}

	public void mergeServiceBinding(ServiceBinding serviceBinding) {
		this.getHibernateTemplate().merge(serviceBinding);
	}

	public void deleteServiceBinding(ServiceBinding serviceBinding) {
		this.getHibernateTemplate().delete(serviceBinding);
	}

	@SuppressWarnings("unchecked")
	public List<ServiceBinding> loadAllServiceBinding() {
		return this.getHibernateTemplate().loadAll(ServiceBinding.class);
	}

	public ServiceBinding findServiceBindingById(long id) {
		return (ServiceBinding) this.getHibernateTemplate().load(ServiceBinding.class, id);
	}

	/**
	 * SpecificationLink
	 */
	public void saveSpecificationLink(SpecificationLink specificationLink) {
		this.getHibernateTemplate().save(specificationLink);
	}

	public void mergeSpecificationLink(SpecificationLink specificationLink) {
		this.getHibernateTemplate().merge(specificationLink);
	}

	public void deleteSpecificationLink(SpecificationLink specificationLink) {
		this.getHibernateTemplate().delete(specificationLink);
	}

	@SuppressWarnings("unchecked")
	public List<SpecificationLink> loadAllSpecificationLink() {
		return this.getHibernateTemplate().loadAll(SpecificationLink.class);
	}

	public SpecificationLink findSpecificationLinkById(long id) {
		return (SpecificationLink) this.getHibernateTemplate().load(SpecificationLink.class, id);
	}

}
