package org.geonetwork.dao.ebrim.provenance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.geonetwork.dao.ebrim.informationmodel.ProvenanceDao;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.association.Annotates;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject.Image;
import org.geonetwork.domain.ebrim.informationmodel.core.ObjectRef;
import org.geonetwork.domain.ebrim.informationmodel.event.NotifyAction;
import org.geonetwork.domain.ebrim.informationmodel.provenance.EmailAddress;
import org.geonetwork.domain.ebrim.informationmodel.provenance.Organization;
import org.geonetwork.domain.ebrim.informationmodel.provenance.User;
import org.geonetwork.domain.ebrim.test.utilities.core.ObjectRefFactory;
import org.geonetwork.domain.ebrim.test.utilities.event.NotifyActionFactory;
import org.geonetwork.domain.ebrim.test.utilities.provenance.EmailAddressFactory;
import org.geonetwork.domain.ebrim.test.utilities.provenance.OrganizationFactory;
import org.geonetwork.domain.ebrim.test.utilities.provenance.UserFactory;
import org.junit.Test;

public class DaoTestDelegateTest {
	ProvenanceDao provenanceDao = new ProvenanceDao();

	@Test
	public void testDaoTestDelegate() {

		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(provenanceDao);
		assertNotNull(testDaoTestDelegate);
	}

	@Test
	public void testTestSave() {
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertFalse(dao.executedSaveEmailAddress);
		testDaoTestDelegate.testSave(EmailAddress.class);
		assertTrue(dao.executedSaveEmailAddress);
	}

	@Test
	public void testTestMerge1() {
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertFalse(dao.executedMergeEmailAddress);
		testDaoTestDelegate.testMerge(EmailAddress.class, "address");
		assertTrue(dao.executedMergeEmailAddress);
	}

	@Test
	public void testTestMerge2() {
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertFalse(dao.executedMergeAnnotates);
		testDaoTestDelegate.testMerge(Annotates.class, "associationType");
		assertTrue(dao.executedMergeAnnotates);
	}

	@Test
	public void testTestDelete() {
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		testDaoTestDelegate.testDelete(EmailAddress.class);
		assertTrue(dao.executedDeleteEmailAddress);
	}

	@Test
	public void testTestfindById() {
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		testDaoTestDelegate.testfindById(EmailAddress.class);
	}

	@Test
	public void testCreateTestDomainObject() {

		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(provenanceDao);
		Object testObject = testDaoTestDelegate.createTestDomainObject(EmailAddress.class);
		assertTrue(testObject instanceof EmailAddress);
	}

	@Test
	public void testGetValue() {
		EmailAddress emailAddress = EmailAddressFactory.create();
		String value = emailAddress.getAddress().getValue();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(provenanceDao);
		assertEquals(value, testDaoTestDelegate.getValue(emailAddress, "address"));
		assertEquals(value, testDaoTestDelegate.getValue(emailAddress, "Address"));
	}

	@Test
	public void testSetValue() {
		EmailAddress emailAddress = EmailAddressFactory.create();
		String value = "fjdklsfjsdl fdsfsd";
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(provenanceDao);
		testDaoTestDelegate.setValue(emailAddress, "address", value);
		assertEquals(value, testDaoTestDelegate.getValue(emailAddress, "address"));
		testDaoTestDelegate.setValue(emailAddress, "Address", value);
		assertEquals(value, testDaoTestDelegate.getValue(emailAddress, "address"));
	}

	@Test
	public void testFindById() {
		EmailAddress emailAddress = EmailAddressFactory.create();
		HelperDao dao = new HelperDao();
		dao.saveEmailAddress(emailAddress);
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertNotNull(testDaoTestDelegate.findById(EmailAddress.class, 456l));
	}

	/**
	 * test with 'normal' domain object
	 */
	@Test
	public void testGetId1() {
		EmailAddress emailAddress = EmailAddressFactory.create();
		long id = 7l;
		emailAddress.setId(id);
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertEquals(id, testDaoTestDelegate.getId(emailAddress));
	}

	/**
	 * test with domain object which extends Identifiable
	 */
	@Test
	public void testGetId2() {
		Organization organization = OrganizationFactory.create();
		long id = 7l;
		organization.setHibernateId(id);
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertEquals(id, testDaoTestDelegate.getId(organization));
	}

	/**
	 * test with domain object which extends an abstract class which holds the id
	 */
	@Test
	public void testGetId3() {
		NotifyAction o = NotifyActionFactory.create();
		long id = 7l;
		o.setId(id);
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertEquals(id, testDaoTestDelegate.getId(o));
	}

	@Test
	public void testGetId4() {
		ObjectRef o = ObjectRefFactory.create();
		long id = 7l;
		o.setHibernateId(id);
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertEquals(id, testDaoTestDelegate.getId(o));
	}

	@Test
	public void testGetId5() {
		User o = UserFactory.create();
		long id = 7l;
		o.setHibernateId(id);
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertEquals(id, testDaoTestDelegate.getId(o));
	}

	@Test
	public void testGetId6() {
		Image image = new Image();
		long id = 7l;
		image.setHibernateId(id);
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		assertEquals(id, testDaoTestDelegate.getId(image));
	}

	@Test
	public void testSearchMethodUpInTree() {
		HelperDao dao = new HelperDao();
		DaoTestDelegate testDaoTestDelegate = new DaoTestDelegate(dao);
		String methodName = "getMimeType";
		assertEquals(methodName, testDaoTestDelegate.searchMethodUpInTree(Image.class, methodName).getName());
	}

}
