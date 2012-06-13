package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.provenance.EmailAddress;
import org.geonetwork.domain.ebrim.informationmodel.provenance.Organization;
import org.geonetwork.domain.ebrim.informationmodel.provenance.Person;
import org.geonetwork.domain.ebrim.informationmodel.provenance.PostalAddress;
import org.geonetwork.domain.ebrim.informationmodel.provenance.TelephoneNumber;
import org.geonetwork.domain.ebrim.informationmodel.provenance.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Dao for EmailAddress, Organization, Person, PostalAddress, TelephoneNumber, User
 * 
 * @author Erik van Ingen
 */
@Transactional
public class ProvenanceDao extends HibernateDaoSupport {

	/**
	 * EmailAddress
	 */
	public void saveEmailAddress(EmailAddress emailAddress) {
		this.getHibernateTemplate().save(emailAddress);
	}

	public void mergeEmailAddress(EmailAddress emailAddress) {
		this.getHibernateTemplate().merge(emailAddress);
	}

	public void deleteEmailAddress(EmailAddress emailAddress) {
		this.getHibernateTemplate().delete(emailAddress);
	}

	@SuppressWarnings("unchecked")
	public List<EmailAddress> loadAllEmailAddress() {
		return this.getHibernateTemplate().loadAll(EmailAddress.class);
	}

	public EmailAddress findEmailAddressById(long id) {
		return (EmailAddress) this.getHibernateTemplate().load(EmailAddress.class, id);
	}

	/**
	 * Organization
	 */
	public void saveOrganization(Organization organization) {
		this.getHibernateTemplate().save(organization);
	}

	public void mergeOrganization(Organization organization) {
		this.getHibernateTemplate().merge(organization);
	}

	public void deleteOrganization(Organization organization) {
		this.getHibernateTemplate().delete(organization);
	}

	@SuppressWarnings("unchecked")
	public List<Organization> loadAllOrganization() {
		return this.getHibernateTemplate().loadAll(Organization.class);
	}

	public Organization findOrganizationById(long id) {
		return (Organization) this.getHibernateTemplate().load(Organization.class, id);
	}

	/**
	 * Person
	 */
	public void savePerson(Person person) {
		this.getHibernateTemplate().save(person);
	}

	public void mergePerson(Person person) {
		this.getHibernateTemplate().merge(person);
	}

	public void deletePerson(Person person) {
		this.getHibernateTemplate().delete(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> loadAllPerson() {
		return this.getHibernateTemplate().loadAll(Person.class);
	}

	public Person findPersonById(long id) {
		return (Person) this.getHibernateTemplate().load(Person.class, id);
	}

	/**
	 * PostalAddress
	 */
	public void savePostalAddress(PostalAddress postalAddress) {
		this.getHibernateTemplate().save(postalAddress);
	}

	public void mergePostalAddress(PostalAddress postalAddress) {
		this.getHibernateTemplate().merge(postalAddress);
	}

	public void deletePostalAddress(PostalAddress postalAddress) {
		this.getHibernateTemplate().delete(postalAddress);
	}

	@SuppressWarnings("unchecked")
	public List<PostalAddress> loadAllPostalAddress() {
		return this.getHibernateTemplate().loadAll(PostalAddress.class);
	}

	public PostalAddress findPostalAddressById(long id) {
		return (PostalAddress) this.getHibernateTemplate().load(PostalAddress.class, id);
	}

	/**
	 * TelephoneNumber
	 */

	public void saveTelephoneNumber(TelephoneNumber telephoneNumber) {
		this.getHibernateTemplate().save(telephoneNumber);
	}

	public void mergeTelephoneNumber(TelephoneNumber telephoneNumber) {
		this.getHibernateTemplate().merge(telephoneNumber);
	}

	public void deleteTelephoneNumber(TelephoneNumber telephoneNumber) {
		this.getHibernateTemplate().delete(telephoneNumber);
	}

	@SuppressWarnings("unchecked")
	public List<TelephoneNumber> loadAllTelephoneNumber() {
		return this.getHibernateTemplate().loadAll(TelephoneNumber.class);
	}

	public TelephoneNumber findTelephoneNumberById(long id) {
		return (TelephoneNumber) this.getHibernateTemplate().load(TelephoneNumber.class, id);
	}

	/**
	 * User
	 */
	public void saveUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	public void mergeUser(User user) {
		this.getHibernateTemplate().merge(user);
	}

	public void deleteUser(User user) {
		this.getHibernateTemplate().delete(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> loadAllUser() {
		return this.getHibernateTemplate().loadAll(User.class);
	}

	public User findUserById(long id) {
		return (User) this.getHibernateTemplate().load(User.class, id);
	}

}
