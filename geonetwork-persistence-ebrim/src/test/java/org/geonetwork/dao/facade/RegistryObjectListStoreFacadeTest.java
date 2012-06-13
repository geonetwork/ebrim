package org.geonetwork.dao.facade;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.dao.ebrim.informationmodel.RegistryObjectListDao;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;

import java.util.List;

public class RegistryObjectListStoreFacadeTest extends AbstractDaoTest {

	RegistryObjectListStoreFacade registryObjectListStoreFacade;
	CoreDao coreDao;
	RegistryObjectListDao registryObjectListDao;

  	/**
	 * Problem:
	 *
	 * The save facade does not seem to update when the same ISO metadata is offered a
	 * second time. Instead, it creates new ebrim stuff in addition to the earlier
	 *
	 * Status: The problem cannot be reproduced in a unit test. What is the problem?
	 *
     * The problem was with hibernate mapping, storing foreign keys as null,
     * If the test parent class is changed to AbstractDependencyInjectionSpringContextTests
     * the problem can be reproduced
     *
	 * @throws GeoNetworkException
	 */
	public void testSave() throws GeoNetworkException {
		String isoId1 = "IsoId1";
		String isoId2 = "IsoId2";

		String id1String = "1";
		String id2String = "2";
		URN id1 = new URN();
		id1.setValue(id1String);
		URN id11 = new URN();
		id11.setValue(id1String);
		URN id111 = new URN();
		id111.setValue(id1String);
		URN id2 = new URN();
		id2.setValue(id2String);
		URN id22 = new URN();
		id22.setValue(id2String);
		URN id222 = new URN();
		id222.setValue(id2String);

		// facade saves a RegistryObjectList with 2 RegistryObject
		// Result should be 1 RegistryObjectList and 2 RegistryObject
		assertEquals(0, coreDao.loadAllRegistryObject().size());
		assertEquals(0, registryObjectListDao.loadAllRegistryObjectList().size());
		RegistryObject registryObject1 = new RegistryObject();
		registryObject1.setId(id1);
		RegistryObject registryObject2 = new RegistryObject();
		registryObject2.setId(id2);
		RegistryObjectList registryObjectList1 = new RegistryObjectList();
		registryObjectList1.setIso19139Id(isoId1);
		registryObjectList1.add(registryObject1);
		registryObjectList1.add(registryObject2);
		registryObjectListStoreFacade.save(registryObjectList1);
		assertEquals(2, coreDao.loadAllRegistryObject().size());
        List<RegistryObjectList> rol = registryObjectListDao.loadAllRegistryObjectList();
		assertEquals(1, rol.size());
        assertEquals(2, rol.get(0).getRegistryObjects().size());
        assertEquals(2, coreDao.loadAllRegistryObject().size());
		                  
		// facade saves the same objects again (RegistryObjectList has the SAME isoId).
		// Result: number of objects is the same, they are updated
		RegistryObjectList registryObjectList2 = new RegistryObjectList();
		registryObjectList2.setIso19139Id(isoId1);
		RegistryObject registryObject3 = new RegistryObject();
		registryObject3.setId(id11);
		registryObjectList2.add(registryObject3);
		RegistryObject registryObject4 = new RegistryObject();
		registryObject4.setId(id22);
		registryObjectList2.add(registryObject4);
		registryObjectListStoreFacade.save(registryObjectList2);
		coreDao.flush();
		assertEquals(2, coreDao.loadAllRegistryObject().size());
		assertEquals(1, registryObjectListDao.loadAllRegistryObjectList().size());

		// facade saves another RegistryObjectList with the same 2 RegistryObject(RegistryObjectList
		// has ANOTHER isoId).
		// Result should be 2 RegistryObjectList and 4 RegistryObject?
		RegistryObjectList registryObjectList3 = new RegistryObjectList();
		registryObjectList3.setIso19139Id(isoId2);
		RegistryObject registryObject5 = new RegistryObject();
		registryObject5.setId(id111);
		registryObjectList3.add(registryObject5);
		RegistryObject registryObject6 = new RegistryObject();
		registryObject6.setId(id222);
		registryObjectList3.add(registryObject6);
		registryObjectListStoreFacade.save(registryObjectList3);
		assertEquals(4, coreDao.loadAllRegistryObject().size());
		assertEquals(2, registryObjectListDao.loadAllRegistryObjectList().size());

	}

	/**
	 * Spring DI setter
	 *
	 * @param coreDao
	 */
	public void setCoreDao(CoreDao coreDao) {
		this.coreDao = coreDao;
	}

	/**
	 * Spring DI setter
	 *
	 * @param registryObjectListStoreFacade
	 */
	public void setRegistryObjectListStoreFacade(RegistryObjectListStoreFacade registryObjectListStoreFacade) {
		this.registryObjectListStoreFacade = registryObjectListStoreFacade;
	}

	/**
	 * Spring DI setter
	 *
	 * @param registryObjectListDao
	 */
	public void setRegistryObjectListDao(RegistryObjectListDao registryObjectListDao) {
		this.registryObjectListDao = registryObjectListDao;
	}

}
