package org.geonetwork.dao.facade;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.dao.ebrim.informationmodel.RegistryObjectListDao;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryPackage;
import org.geonetwork.utils.RandomPopulator;

public class DeleteFacadeTest extends AbstractDaoTest {

	RegistryObjectListDao registryObjectListDao;
	DeleteFacade deleteFacade;
	CoreDao coreDao;

	public void testDeleteByISOId() throws Exception {
		assertEquals(0, coreDao.loadAllRegistryObject().size()); 
		String iso19139Id = "go with the flow"; 
		RegistryObject ro = (RegistryObject) RandomPopulator.instantiate(RegistryObject.class);
		RegistryPackage rp1 = (RegistryPackage) RandomPopulator.instantiate(RegistryPackage.class);
		RegistryPackage rp2 = (RegistryPackage) RandomPopulator.instantiate(RegistryPackage.class);
		RegistryObjectList registryObjectList = new RegistryObjectList();
		registryObjectList.add(ro);
		registryObjectList.add(rp1);
		registryObjectList.add(rp2);
		registryObjectList.setIso19139Id(iso19139Id);
		registryObjectListDao.saveRegistryObjectList(registryObjectList);
		
		assertTrue(ro.getHibernateId()>0); 
		assertTrue(rp1.getHibernateId()>0); 
		assertTrue(rp2.getHibernateId()>0); 
		assertTrue(registryObjectList.getHibernateId()>0); 
		
		assertTrue(coreDao.loadAllRegistryObject().size()>0); 
		deleteFacade.deleteByISOId(iso19139Id);
		assertEquals(0, coreDao.loadAllRegistryObject().size()); 
	}

	/**
	 * setter for Spring
	 * 
	 * @param registryObjectListDao
	 */
	public void setRegistryObjectListDao(RegistryObjectListDao registryObjectListDao) {
		this.registryObjectListDao = registryObjectListDao;
	}

	/**
	 * setter for Spring
	 */
	public void setDeleteFacade(DeleteFacade deleteFacade) {
		this.deleteFacade = deleteFacade;
	}

	/**
	 * setter for Spring
	 */
	public void setCoreDao(CoreDao coreDao) {
		this.coreDao = coreDao;
	}

}
