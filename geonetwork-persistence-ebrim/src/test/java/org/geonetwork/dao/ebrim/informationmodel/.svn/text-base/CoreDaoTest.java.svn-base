package org.geonetwork.dao.ebrim.informationmodel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.provenance.DaoTestDelegate;
import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalIdentifier;
import org.geonetwork.domain.ebrim.informationmodel.core.ExternalLink;
import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.ObjectRef;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryPackage;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;
import org.geonetwork.domain.ebrim.test.utilities.core.ObjectRefFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryPackageFactory;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.AnyValue;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.Envelope;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.LowerCorner;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.UpperCorner;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject.WrsExtrinsicObject;
import org.geonetwork.utils.RandomPopulator;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

/**
 * TestDao for ExternalIdentifier ExternalLink ExtrinsicObject ObjectRef RegistryObject RegistryPackage Slot VersionInfo
 * 
 * @author Erik van Ingen
 */
public class CoreDaoTest extends AbstractDaoTest {

	CoreDao coreDao;
	AssociationDao associationDao;

	
	/**
	 * TODO investigate why tests in this class in the long run are not working
	 */
	public void testDummy() {
		assertTrue(true);
	}

	
	
    /**
	 * ExternalIdentifier
	 */
	public void testSaveExternalIdentifier() {
        clean();
		new DaoTestDelegate(coreDao).testSaveExpectsGreater(ExternalIdentifier.class);
	}

	public void testMergeExternalIdentifier() {
		clean();
        new DaoTestDelegate(coreDao).testMergeExpectsGreater(ExternalIdentifier.class, "identificationScheme");
	}

	public void testDeleteExternalIdentifier() {
		clean();
        new DaoTestDelegate(coreDao).testDeleteExpectsGreater(ExternalIdentifier.class);
	}

	public void testfindExternalIdentifierById() {
		clean();
        new DaoTestDelegate(coreDao).testfindByIdExpectsGreater(ExternalIdentifier.class);
	}

	/**
	 * ExternalLink
	 */
	public void testSaveExternalLink() {
		clean();
        new DaoTestDelegate(coreDao).testSave(ExternalLink.class);
	}

	public void testMergeExternalLink() {
		clean();
        new DaoTestDelegate(coreDao).testMerge(ExternalLink.class, "externalURI");
	}

	public void testDeleteExternalLink() {
		clean();
        new DaoTestDelegate(coreDao).testDelete(ExternalLink.class);
	}

	public void testfindExternalLinkById() {
		clean();
        new DaoTestDelegate(coreDao).testfindById(ExternalLink.class);
	}

	/**
	 * ExtrinsicObject
	 */
	public void testSaveExtrinsicObject() {
		clean();
        new DaoTestDelegate(coreDao).testSave(ExtrinsicObject.class);
	}

	public void testMergeExtrinsicObject() {
		clean();
        new DaoTestDelegate(coreDao).testMerge(ExtrinsicObject.class, "mimeType");
	}

	public void testDeleteExtrinsicObject() {
		clean();
        new DaoTestDelegate(coreDao).testDelete(ExtrinsicObject.class);
	}

	public void testfindExtrinsicObjectById() {
		clean();
        new DaoTestDelegate(coreDao).testfindById(ExtrinsicObject.class);
	}

    /**
	 * WrsExtrinsicObject
	 */
	public void testSaveWrsExtrinsicObject() {
		clean();
        new DaoTestDelegate(coreDao).testSave(WrsExtrinsicObject.class);
	}

	public void testMergeWrsExtrinsicObject() {
		clean();
        new DaoTestDelegate(coreDao).testMerge(WrsExtrinsicObject.class, "mimeType");
	}

	public void testDeleteWrsExtrinsicObject() {
		clean();
        new DaoTestDelegate(coreDao).testDelete(WrsExtrinsicObject.class);
	}

	public void testfindWrsExtrinsicObjectById() {
		clean();
        new DaoTestDelegate(coreDao).testfindById(WrsExtrinsicObject.class);
	}

	/**
	 * ObjectRef
	 */
	public void testSaveObjectRef() {
        clean();
		new DaoTestDelegate(coreDao).testSave(ObjectRef.class);
	}

	public void testMergeObjectRef() {
		clean();
        ObjectRef objectRef = ObjectRefFactory.create();
		coreDao.saveObjectRef(objectRef);
		boolean value = objectRef.getCreateReplica();
		objectRef.setCreateReplica(!objectRef.getCreateReplica());
		coreDao.mergeObjectRef(objectRef);
		assertNotSame(value, objectRef.getCreateReplica());
	}

	public void testDeleteObjectRef() {
		clean();
        new DaoTestDelegate(coreDao).testDelete(ObjectRef.class);
	}

	public void testfindObjectRefById() {
		clean();
        new DaoTestDelegate(coreDao).testfindById(ObjectRef.class);
	}

	/**
	 * RegistryObject
	 */
	public void testSaveRegistryObject() {
		clean();
        new DaoTestDelegate(coreDao).testSaveExpectsGreater(RegistryObject.class);
	}

	public void testMergeRegistryObject1() {
		clean();
        new DaoTestDelegate(coreDao).testMergeExpectsGreater(RegistryObject.class, "lid");
	}

	public void testMergeRegistryObject2() {
		clean();
        new DaoTestDelegate(coreDao).testMergeExpectsGreater(RegistryObject.class, "status");
	}

	public void testMergeRegistryObject3() {
		clean();
        new DaoTestDelegate(coreDao).testMergeExpectsGreater(RegistryObject.class, "objectType");
	}

	public void xtestDeleteRegistryObject() {
		// covered by the testRegistryObjectRelationWithAssociation tests
	}

	public void testFindRegistryObjectByName() {
		clean();
        RegistryObject testObject;
		try {
			// create the RegistryObject for test
			testObject = (RegistryObject) RandomPopulator.instantiate(RegistryObject.class, null);
			coreDao.saveRegistryObject(testObject);

			testObject.setId(new URN(new Long(testObject.getHibernateId()).toString()));
			coreDao.mergeRegistryObject(testObject);

			RegistryObject findedRegistryObject = coreDao.findRegistryObjectByUrnId(testObject.getId().toString());
			assertNotNull(findedRegistryObject);
			assertEquals(testObject.getId(), findedRegistryObject.getId());
		} catch (Exception e) {
			fail();
			throw new RuntimeException(e);
		}
	}

    public void testSaveSpatialSlot() {
		clean();
        RegistryObject testObject;
		try {
			// create the RegistryObject for test
			testObject = RegistryObjectFactory.create();
			Slot spatial = new Slot();
            org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.ValueList valueList =
                     new org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.ValueList();
            AnyValue envelope = new AnyValue();
            Envelope env = new Envelope();
            env.setLowerCorner(new LowerCorner("10 15"));
            env.setUpperCorner(new UpperCorner("20 35"));
            envelope.setValue(env);

            List<AnyValue> values = new ArrayList<AnyValue>();
            values.add(envelope);
            valueList.setValues(values);
            spatial.setBasicExtensionValueList(valueList);

            testObject.addSlot(spatial);
            
            coreDao.saveRegistryObject(testObject);

			RegistryObject findedRegistryObject = coreDao.findRegistryObjectByUrnId(testObject.getId().toString());
			assertNotNull(findedRegistryObject);
            
            for(Slot s1: testObject.getSlots()) {
                boolean finded = false;
                for (Slot s2: findedRegistryObject.getSlots() ) {
                    if (s1.equals(s2)) {
                        finded = true;
                        break;
                    }
                }

                assertTrue(finded);
            }

		} catch (Exception e) {
			fail();
			throw new RuntimeException(e);
		}
	}

	public void testfindRegistryObjectById() {
		clean();
        new DaoTestDelegate(coreDao).testfindByIdExpectsGreater(RegistryObject.class);
	}

	public void testFindRegistryObjectByExternalIdentifierValue() {
		clean();
        RegistryObject testRegistryObject;
		ExternalIdentifier testExternalIdentifierObject;

		try {
			// create the RegistryObject and ExternalIdentifier for test
			testRegistryObject = (RegistryObject) RandomPopulator.instantiate(RegistryObject.class, null);
			testRegistryObject.setId(new URN(new Long(testRegistryObject.getHibernateId()).toString()));

			testExternalIdentifierObject = (ExternalIdentifier) RandomPopulator.instantiate(ExternalIdentifier.class,
					null);
			testExternalIdentifierObject.setValue(new LongName("long_name"));
			testExternalIdentifierObject.setRegistryObject(new URI(testRegistryObject.getId().getValue()));

			coreDao.saveRegistryObject(testRegistryObject);
			coreDao.saveExternalIdentifier(testExternalIdentifierObject);

			// Test an existent child rim:ExternalIdentifier element with a matching @value attribute.
			List<RegistryObject> findedRegistryObject = coreDao
					.findRegistryObjectByExternalIdentifierValue("long_name");
			assertEquals(findedRegistryObject.size(), 1);
			assertEquals(testRegistryObject.getId(), findedRegistryObject.get(0).getId());
			assertEquals(testExternalIdentifierObject.getRegistryObject().getValue(), findedRegistryObject.get(0)
					.getId(), testRegistryObject.getId());

			assertEquals(findedRegistryObject.get(0).getId().getValue(), testExternalIdentifierObject
					.getRegistryObject().getValue());

			// Test a non existent child rim:ExternalIdentifier element value
			findedRegistryObject = coreDao.findRegistryObjectByExternalIdentifierValue("long_name_nox_existent");
			assertNull(findedRegistryObject);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
			throw new RuntimeException(e);
		}
	}

    public void testFindRegistryObjectBySlotNameAndValue() {

		try {
            clean();
              // Initializes a fileIdentifier slot
            String fileIdentifier = "63C2378A-17A7-B863-BFF4-CC3EF507D10E";
            Slot slotFileIdentifier = new Slot();
            slotFileIdentifier.setName(new LongName("http://purl.org/dc/elements/1.1/identifier"));
            slotFileIdentifier.setSlotType(new LongName("xsd:string"));
            LongName slotValue = new LongName(fileIdentifier);
            ValueList valueList = new ValueList();
            valueList.add(slotValue);
            slotFileIdentifier.setValueList(valueList);

            // Creates registryObject1 with slot fileIdentifier
            RegistryObject registryObject1 = RegistryObjectFactory.create();
            registryObject1.setId(new URN("id1"));
            registryObject1.getSlots().add(slotFileIdentifier);
            coreDao.saveRegistryObject(registryObject1);

            fileIdentifier = "AAAAAAAA-17A7-B863-BFF4-CC3EF507D10E";
            slotFileIdentifier = new Slot();
            slotFileIdentifier.setName(new LongName("http://purl.org/dc/elements/1.1/identifier"));
            slotFileIdentifier.setSlotType(new LongName("xsd:string"));
            slotValue = new LongName(fileIdentifier);
            valueList = new ValueList();
            valueList.add(slotValue);
            slotFileIdentifier.setValueList(valueList);

            // Creates registryObject1 with slot fileIdentifier
            RegistryObject registryObject2 = RegistryObjectFactory.create();
            registryObject2.setId(new URN("id1"));
            registryObject2.getSlots().add(slotFileIdentifier);
            coreDao.saveRegistryObject(registryObject2);

            // Test find non existent slot value
			List<RegistryObject> findedRegistryObjects = coreDao.findRegistryObjectBySlotNameAndValue(
                    "http://purl.org/dc/elements/1.1/identifier", "AAAA");
            assertEquals(0, findedRegistryObjects.size());

            // Test find non existent slot name
			findedRegistryObjects = coreDao.findRegistryObjectBySlotNameAndValue(
                    "ZZZZZZZZZZZ", "AAAAAAAA-17A7-B863-BFF4-CC3EF507D10E");
            assertEquals(0, findedRegistryObjects.size());

            // Test find and existent slot name and value
			findedRegistryObjects = coreDao.findRegistryObjectBySlotNameAndValue(
                    "http://purl.org/dc/elements/1.1/identifier", "63C2378A-17A7-B863-BFF4-CC3EF507D10E");
            assertEquals(1, findedRegistryObjects.size());

             // Test find and existent slot name and value
			findedRegistryObjects = coreDao.findRegistryObjectBySlotNameAndValue(
                    "http://purl.org/dc/elements/1.1/identifier", "AAAAAAAA-17A7-B863-BFF4-CC3EF507D10E");
            assertEquals(1, findedRegistryObjects.size());
            
		} catch (Exception e) {
			e.printStackTrace();
			fail();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Testing relation of RegistryObject with Association
	 * 
	 */
	public void _() {
		assertEquals(0, coreDao.loadAllRegistryObject().size());
		RegistryObject ro = RegistryObjectFactory.create();
		assertEquals(0, associationDao.loadAllAssociation().size());
		coreDao.saveRegistryObject(ro);
		List<RegistryObject> list = coreDao.loadAllRegistryObject();
		int i = 0;
		for (RegistryObject roFound : list) {
			if (ro == roFound)
				i++;
		}
		assertEquals(1, i);
		coreDao.deleteRegistryObject(ro);
		assertEquals(1, coreDao.loadAllRegistryObject().size());
		assertEquals(0, associationDao.loadAllAssociation().size());
	}

	/**
	 * Testing relation of RegistryObject with Association
	 * 
	 * assocition with itself
	 * 
	 */
	public void testRegistryObjectRelationWithAssociation2() {
		clean();
		assertEquals(0, coreDao.loadAllRegistryObject().size());
		assertEquals(0, associationDao.loadAllAssociation().size());
		RegistryObject ro = new RegistryObject();
		Association a = new Association();
		a.setTargetRegistryObject(ro);
		Set<Association> associationsSet = new HashSet<Association>();
		associationsSet.add(a);
		ro.setAssociationsSet(associationsSet);
		coreDao.saveRegistryObject(ro);
		assertEquals(2, coreDao.loadAllRegistryObject().size());
		assertEquals(1, associationDao.loadAllAssociation().size());
		coreDao.deleteRegistryObject(ro);
		assertEquals(0, coreDao.loadAllRegistryObject().size());
		assertEquals(0, associationDao.loadAllAssociation().size());
	}

	/**
	 * Testing relation of RegistryObject with Association
	 * 
	 * assocition with another, testing cascade="save-update" on targetRegistryObject
	 * 
	 */
	public void testRegistryObjectRelationWithAssociation3() {
		clean();
		assertEquals(0, coreDao.loadAllRegistryObject().size());
		assertEquals(0, associationDao.loadAllAssociation().size());
		RegistryObject ro1 = new RegistryObject();
		RegistryObject ro2 = new RegistryObject();
		Association a = new Association();
		a.setTargetRegistryObject(ro2);
		Set<Association> associationsSet = new HashSet<Association>();
		associationsSet.add(a);
		ro1.setAssociationsSet(associationsSet);
		coreDao.saveRegistryObject(ro1);
		assertEquals(3, coreDao.loadAllRegistryObject().size());
		assertEquals(1, associationDao.loadAllAssociation().size());
		coreDao.deleteRegistryObject(ro1);
		assertEquals(1, coreDao.loadAllRegistryObject().size());
		assertEquals(0, associationDao.loadAllAssociation().size());
	}

	/**
	 * RegistryPackage
	 */
	public void testSaveRegistryPackage1() {
		clean();
        new DaoTestDelegate(coreDao).testSave(RegistryPackage.class);
	}

	/**
	 * RegistryPackage
	 */
	public void testSaveRegistryPackage2() {
		clean();
        RegistryPackage r = RegistryPackageFactory.create();
		assertEquals(0, coreDao.loadAllRegistryPackage().size());
		coreDao.saveRegistryPackage(r);
		assertEquals(1, coreDao.loadAllRegistryPackage().size());
	}

	public void testMergeRegistryPackage() {
		clean();
        new DaoTestDelegate(coreDao).testMerge(RegistryPackage.class, "status");
	}

	public void testDeleteRegistryPackage() {
		clean();
        new DaoTestDelegate(coreDao).testDelete(RegistryPackage.class);
	}

	public void testfindRegistryPackageById() {
		clean();
        new DaoTestDelegate(coreDao).testfindById(RegistryPackage.class);
	}

	/**
	 * Slot
	 */
	public void testSaveSlot() {
		clean();
        new DaoTestDelegate(coreDao).testSave(Slot.class);
	}

	public void testMergeSlot1() {
		clean();
        new DaoTestDelegate(coreDao).testMerge(Slot.class, "name");
	}

	public void testMergeSlot2() {
		clean();
        new DaoTestDelegate(coreDao).testMerge(Slot.class, "slotType");
	}

	public void testDeleteSlot() {
		clean();
        new DaoTestDelegate(coreDao).testDelete(Slot.class);
	}

	public void testfindEmailAddressById() {
		clean();
        new DaoTestDelegate(coreDao).testfindById(Slot.class);
	}

	public void setCoreDao(CoreDao coreDao) {
		this.coreDao = coreDao;
	}

	public void setAssociationDao(AssociationDao associationDao) {
		this.associationDao = associationDao;
	}

    public void clean() {

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

        List<Association> trashAssociation = associationDao.loadAllAssociation();
        for (Association leftOver : trashAssociation) {
            associationDao.deleteAssociation(leftOver);
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

    }
}
