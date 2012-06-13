package org.geonetwork.dao.ebrim.provenance;

import java.util.List;

import junit.framework.TestCase;

import org.geonetwork.dao.ebrim.informationmodel.ProvenanceDao;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.provenance.EmailAddress;
import org.geonetwork.domain.ebrim.test.utilities.provenance.EmailAddressFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class does not use AbstractTransactionalSpringContextTests because every method is a
 * transaction. Lucene will only commit after the commit and therefore a commit within the method is
 * needed. Maybe playing with setup before transaction may solve this issue.
 * 
 * @author Erik van Ingen
 */

public class ProvenanceSearchDaoTest extends TestCase {

	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "applicationContext-gn-hibernate-ebrim-test.xml",
			"applicationContext-gn-persistence-ebrim.xml" });

	public void testSearchEmailAddressHql() {

		ProvenanceDao provenanceDao = (ProvenanceDao) ac.getBean("provenanceDao");
		ProvenanceSearchDao provenanceSearchDao = (ProvenanceSearchDao) ac.getBean("provenanceSearchDao");

		String address = "via della puta madre";
		String type = "buona";
		String searchTerm1 = "puta";
		String searchTerm2 = "uon";
		String searchTerm3 = "erik";

		EmailAddress emailAddress = EmailAddressFactory.create();
		emailAddress.getAddress().setValue(address);
		emailAddress.getType().setValue(type);

		// make sure no email addresses do exist.
		List<EmailAddress> list = provenanceDao.loadAllEmailAddress();
		for (EmailAddress emailAddresss : list) {
			provenanceDao.deleteEmailAddress(emailAddresss);
		}

		assertEquals(0, provenanceDao.loadAllEmailAddress().size());
		assertEquals(0, provenanceSearchDao.searchEmailAddressHql(searchTerm1).size());
		assertEquals(0, provenanceSearchDao.searchEmailAddressHql(searchTerm2).size());
		assertEquals(0, provenanceSearchDao.searchEmailAddressHql(searchTerm3).size());
		provenanceDao.saveEmailAddress(emailAddress);

		assertEquals(1, provenanceDao.loadAllEmailAddress().size());
		assertEquals(1, provenanceSearchDao.searchEmailAddressHql(searchTerm1).size());
		assertEquals(1, provenanceSearchDao.searchEmailAddressHql(searchTerm2).size());
		assertEquals(0, provenanceSearchDao.searchEmailAddressHql(searchTerm3).size());

	}

	public void testSearchEmailAddressLucene() throws GeoNetworkException {
		ProvenanceDao provenanceDao = (ProvenanceDao) ac.getBean("provenanceDao");
		ProvenanceSearchDao provenanceSearchDao = (ProvenanceSearchDao) ac.getBean("provenanceSearchDao");

		// make sure no email addresses do exist.
		List<EmailAddress> list = provenanceDao.loadAllEmailAddress();
		for (EmailAddress emailAddress : list) {
			provenanceDao.deleteEmailAddress(emailAddress);
		}

		String address = "via della puta madre";
		String type = "buona fide";
		String searchTerm1 = "puta";
		String searchTerm2 = "fide";
		String searchTerm3 = "erik";

		EmailAddress emailAddress = EmailAddressFactory.create();
		emailAddress.getAddress().setValue(address);
		emailAddress.getType().setValue(type);

		assertEquals(0, provenanceDao.loadAllEmailAddress().size());
		assertEquals(0, provenanceSearchDao.searchEmailAddressLucene(searchTerm1).size());
		assertEquals(0, provenanceSearchDao.searchEmailAddressLucene(searchTerm2).size());
		assertEquals(0, provenanceSearchDao.searchEmailAddressLucene(searchTerm3).size());
		provenanceDao.saveEmailAddress(emailAddress);

		assertEquals(1, provenanceDao.loadAllEmailAddress().size());
		assertEquals(1, provenanceSearchDao.searchEmailAddressLucene(searchTerm1).size());
		assertEquals(1, provenanceSearchDao.searchEmailAddressLucene(searchTerm2).size());
		assertEquals(0, provenanceSearchDao.searchEmailAddressLucene(searchTerm3).size());

	}

}
