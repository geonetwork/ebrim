package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.apache.log4j.Logger;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dao for RegistryObjectList
 * 
 * @author Erik van Ingen
 */
@Transactional
public class RegistryObjectListDao extends HibernateDaoSupport {
	
	private static Logger log = Logger.getLogger(RegistryObjectListDao.class);

	/**
	 * RegistryObjectList
	 */
	public void saveRegistryObjectList(RegistryObjectList registryObjectList) {
		if (registryObjectList.getIso19139Id() == null) {
			log.error("Error: registryObjectList.getIso19139Id() == null");
		}
		this.getHibernateTemplate().save(registryObjectList);
	}

	public void mergeRegistryObjectList(RegistryObjectList registryObjectList) {
		this.getHibernateTemplate().merge(registryObjectList);
	}

	public void deleteRegistryObjectList(RegistryObjectList registryObjectList) {
		this.getHibernateTemplate().delete(registryObjectList);
	}

	@SuppressWarnings("unchecked")
	public List<RegistryObjectList> loadAllRegistryObjectList() {
		return this.getHibernateTemplate().loadAll(RegistryObjectList.class);
	}

	public RegistryObjectList findRegistryObjectListById(long id) {
		return (RegistryObjectList) this.getHibernateTemplate().load(RegistryObjectList.class, id);
	}

	public void flush() {
		this.getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	public RegistryObjectList findRegistryObjectListByISO19139Id(String iso19139Id) {
		List<RegistryObjectList> registryObjects = this.getHibernateTemplate().find(
				"from org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList reg "
						+ "where reg.iso19139Id = ?", iso19139Id);

		if (!registryObjects.isEmpty())
			return registryObjects.get(0);
		else
			return null;
	}
}