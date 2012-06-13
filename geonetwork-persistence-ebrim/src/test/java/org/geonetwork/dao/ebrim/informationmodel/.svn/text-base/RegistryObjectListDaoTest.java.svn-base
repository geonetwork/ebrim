package org.geonetwork.dao.ebrim.informationmodel;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectListFactory;
import org.geonetwork.utils.RandomPopulator;

/**
 * TestDao for registryObjectListDao
 * 
 * @author Erik van Ingen
 */
public class RegistryObjectListDaoTest extends AbstractDaoTest {

	RegistryObjectListDao registryObjectListDao;
	CoreDao coreDao;

	/**
	 * RegistryObjectList
	 */
	public void testSaveRegistryObjectList() {
		// TODO add appropriate test
		// new DaoTestDelegate(registryObjectListDao).testSave(RegistryObjectList.class);

	}

	public void testSaveRegistryObjectList2() throws Exception {
		ClassificationNode classificationNode = (ClassificationNode) RandomPopulator.instantiate(
				ClassificationNode.class, null);
		ExtrinsicObject extrinsicObject = (ExtrinsicObject) RandomPopulator.instantiate(ExtrinsicObject.class, null);

		RegistryObjectList registryObjectList = new RegistryObjectList();
		registryObjectList.setIso19139Id("Iso19139Id");
		registryObjectList.add(classificationNode);
		registryObjectList.add(extrinsicObject);
		registryObjectListDao.saveRegistryObjectList(registryObjectList);
		registryObjectListDao.flush();
		RegistryObjectList foundList = registryObjectListDao.findRegistryObjectListById(registryObjectList
				.getHibernateId());
		assertEquals(2, foundList.size());
		RegistryObject ro1 = foundList.get(0);
		RegistryObject ro2 = foundList.get(1);
        boolean classificationNodeFound = false;
        boolean extrinsicObjectFound = false;
		for(RegistryObject ro: foundList.getRegistryObjects()) {
            if (ro instanceof ClassificationNode) classificationNodeFound = true;
            if (ro instanceof ExtrinsicObject) extrinsicObjectFound = true;

        }
        assertTrue(classificationNodeFound && extrinsicObjectFound);
	}

	public void testSaveRegistryObjectList3() throws Exception {
		ClassificationNode classificationNode = new ClassificationNode();
		String classificationNodeId = "10";
		URN urnC = new URN();
		urnC.setValue(classificationNodeId);
		classificationNode.setId(urnC);

		RegistryObjectList registryObjectList = new RegistryObjectList();
		registryObjectList.setIso19139Id("Iso19139Id");
		registryObjectList.add(classificationNode);
		registryObjectListDao.saveRegistryObjectList(registryObjectList);
	}

	public void testMergeRegistryObjectList1() throws Exception {
		RegistryObjectList registryObjectList = (RegistryObjectList) RandomPopulator.instantiate(
				RegistryObjectList.class, null);
		registryObjectListDao.saveRegistryObjectList(registryObjectList);
		int numberOfElements = registryObjectList.size();
		RegistryObject registryObject = (RegistryObject) RandomPopulator.instantiate(RegistryObject.class, null);
		registryObjectList.add(registryObject);
		registryObjectListDao.mergeRegistryObjectList(registryObjectList);
		RegistryObjectList registryObjectListFound = registryObjectListDao
				.findRegistryObjectListById(registryObjectList.getHibernateId());
		assertEquals(++numberOfElements, registryObjectListFound.size());

	}

	/**
	 * Adding an object to an already persisted list does not work via a cascade. It should be saved
	 * upfront, added to the list and then the list can be updated.
	 * 
	 * However, cascading should also work for updates like this. Probably can be done via the
	 * hibernate mapping files. At this point will not be investigated further.
	 * 
	 * @throws Exception
	 */
	public void testMergeRegistryObjectList() throws Exception {
		RegistryObjectList registryObjectList = (RegistryObjectList) RandomPopulator.instantiate(
				RegistryObjectList.class, null);
		registryObjectListDao.saveRegistryObjectList(registryObjectList);
		int numberOfElements = registryObjectList.size();
		RegistryObject registryObject = (RegistryObject) RandomPopulator.instantiate(RegistryObject.class, null);
		coreDao.saveRegistryObject(registryObject);
		registryObjectList.add(registryObject);
		registryObjectListDao.mergeRegistryObjectList(registryObjectList);
		RegistryObjectList registryObjectListFound = registryObjectListDao
				.findRegistryObjectListById(registryObjectList.getHibernateId());
		assertEquals(++numberOfElements, registryObjectListFound.size());

	}

	public void testDeleteRegistryObjectList() {
		// TODO add appropriate test
		// new DaoTestDelegate(registryObjectListDao).testDelete(RegistryObjectList.class);
	}

	public void testfindRegistryObjectListById() {
		// TODO add appropriate test
		// new DaoTestDelegate(registryObjectListDao).testfindById(RegistryObjectList.class);
	}

	public void setRegistryObjectListDao(RegistryObjectListDao registryObjectListDao) {
		this.registryObjectListDao = registryObjectListDao;
	}

	public void testFindRegistryObjectListByISO19139Id() {
		try {
			// Create 2 RegistryObjectList objects with different ISO19139Id
			RegistryObjectList registryObjectList = RegistryObjectListFactory.create();
			String ISO19139Id = registryObjectList.getIso19139Id();

			registryObjectListDao.saveRegistryObjectList(registryObjectList);

			RegistryObjectList registryObjectList2 = RegistryObjectListFactory.create();
			registryObjectList2.setIso19139Id(registryObjectList2.getIso19139Id() + "00000");

			registryObjectListDao.saveRegistryObjectList(registryObjectList2);

			// Find existent ISO19139Id
			RegistryObjectList obtainedRegistryObjectList = registryObjectListDao
					.findRegistryObjectListByISO19139Id(ISO19139Id);
			assertNotNull(obtainedRegistryObjectList);
			assertEquals(registryObjectList, obtainedRegistryObjectList);
			assertEquals(1, obtainedRegistryObjectList.size());
			assertEquals(ISO19139Id, obtainedRegistryObjectList.getIso19139Id());

			// Find non existent ISO19139Id
			String nonExistentISO19139Id = ISO19139Id + "AAAAA";
			obtainedRegistryObjectList = registryObjectListDao
					.findRegistryObjectListByISO19139Id(nonExistentISO19139Id);
			assertNull(obtainedRegistryObjectList);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
			throw new RuntimeException(e);
		}
	}

	public void setCoreDao(CoreDao coreDao) {
		this.coreDao = coreDao;
	}
}
