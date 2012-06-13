package org.geonetwork.dao.ebrim.informationmodel;

import java.util.List;

import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.dao.ebrim.provenance.DaoTestDelegate;
import org.geonetwork.domain.ebrim.informationmodel.provenance.EmailAddress;
import org.geonetwork.domain.ebrim.informationmodel.provenance.Organization;
import org.geonetwork.domain.ebrim.informationmodel.provenance.Person;
import org.geonetwork.domain.ebrim.informationmodel.provenance.PostalAddress;
import org.geonetwork.domain.ebrim.informationmodel.provenance.TelephoneNumber;
import org.geonetwork.domain.ebrim.informationmodel.provenance.User;
import org.geonetwork.domain.ebrim.test.utilities.provenance.PersonFactory;
import org.geonetwork.domain.ebrim.test.utilities.provenance.UserFactory;

/**
 * TestDao for EmailAddress, Organization, Person, PostalAddress, TelephoneNumber, User
 * <p/>
 * Is person needed?
 *
 * @author Erik van Ingen
 */
public class ProvenanceDaoTest extends AbstractDaoTest {

    ProvenanceDao provenanceDao;

    /**
     * Some things I don't even want to know. Somehow in the database emailaddresses do remain. It
     * is not happening when running the tests in eclipse. From the prompt however they do remain.
     * It is probably a stupid bug in AbstractTransactionalSpringContextTests.
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        List<EmailAddress> list = provenanceDao.loadAllEmailAddress();
        for (EmailAddress emailAddress : list) {
            provenanceDao.deleteEmailAddress(emailAddress);
        }

    }

    /**
     * EmailAddress
     */
    public void testSaveEmailAddress() {
        clean();
        new DaoTestDelegate(provenanceDao).testSave(EmailAddress.class);
    }

    public void testMergeEmailAddress() {
        clean();
        new DaoTestDelegate(provenanceDao).testMerge(EmailAddress.class, "address");
    }

    public void testDeleteEmailAddress() {
        clean();
        new DaoTestDelegate(provenanceDao).testDelete(EmailAddress.class);
    }

    public void testfindEmailAddressById() {
        clean();
        new DaoTestDelegate(provenanceDao).testfindById(EmailAddress.class);
    }

    /**
     * Organization
     */
    public void testSaveOrganization() {
        clean();
        new DaoTestDelegate(provenanceDao).testSave(Organization.class);
    }

    public void testMergeOrganization() {
        clean();
        new DaoTestDelegate(provenanceDao).testMerge(Organization.class, "parent");
    }

    public void testDeleteOrganization() {
        clean();
        new DaoTestDelegate(provenanceDao).testDelete(Organization.class);
    }

    public void testfindOrganizationById() {
        clean();
        new DaoTestDelegate(provenanceDao).testfindById(Organization.class);
    }

    /**
     * Person
     */
    public void testSavePerson() {
        clean();
        new DaoTestDelegate(provenanceDao).testSave(Person.class);
    }

    public void testMergePerson() {
        clean();
        String value = " fdsfksdfj dfsdfklsdj fsfjsdklf lks78907809";
        Person person = PersonFactory.create();
        provenanceDao.savePerson(person);
        assertEquals(1, provenanceDao.loadAllPerson().size());
        for (PostalAddress postalAddress : person.getAddresses()) {
            postalAddress.getCity().setValue(value);
        }
        provenanceDao.mergePerson(person);
        Person personFound = provenanceDao.loadAllPerson().get(0);
        for (PostalAddress postalAddress : personFound.getAddresses()) {
            assertEquals(value, postalAddress.getCity().getValue());
        }
    }

    public void testDeletePerson() {
        clean();
        new DaoTestDelegate(provenanceDao).testDelete(Person.class);
    }

    public void testfindPersonById() {
        clean();
        new DaoTestDelegate(provenanceDao).testfindById(Person.class);
    }

    /**
     * PostalAddress
     */

    public void testSavePostalAddress() {
        clean();
        new DaoTestDelegate(provenanceDao).testSave(PostalAddress.class);
    }

    public void testMergePostalAddress() {
        clean();
        new DaoTestDelegate(provenanceDao).testMerge(PostalAddress.class, "streetNumber");
    }

    public void testDeletePostalAddress() {
        clean();
        new DaoTestDelegate(provenanceDao).testDelete(PostalAddress.class);
    }

    public void testfindPostalAddressById() {
        clean();
        new DaoTestDelegate(provenanceDao).testfindById(PostalAddress.class);
    }

    /**
     * TelephoneNumber
     */

    public void testSaveTelephoneNumber() {
        clean();
        new DaoTestDelegate(provenanceDao).testSave(TelephoneNumber.class);
    }

    public void testMergeTelephoneNumber1() {
        clean();
        new DaoTestDelegate(provenanceDao).testMerge(TelephoneNumber.class, "areaCode");
    }

    public void testMergeTelephoneNumber2() {
        clean();
        new DaoTestDelegate(provenanceDao).testMerge(TelephoneNumber.class, "countryCode");
    }

    public void testMergeTelephoneNumber3() {
        clean();
        new DaoTestDelegate(provenanceDao).testMerge(TelephoneNumber.class, "extension");
    }

    public void testMergeTelephoneNumber4() {
        clean();
        new DaoTestDelegate(provenanceDao).testMerge(TelephoneNumber.class, "number");
    }

    public void testMergeTelephoneNumber5() {
        clean();
        new DaoTestDelegate(provenanceDao).testDelete(TelephoneNumber.class);
    }

    public void testDeleteTelephoneNumber() {
        clean();
        new DaoTestDelegate(provenanceDao).testDelete(TelephoneNumber.class);
    }

    public void testfindTelephoneNumberById() {
        clean();
        new DaoTestDelegate(provenanceDao).testfindById(TelephoneNumber.class);
    }

    public void setProvenanceDao(ProvenanceDao provenanceDao) {
        this.provenanceDao = provenanceDao;
    }

    /**
     * User
     */

    public void testSaveUser() {
        clean();
        new DaoTestDelegate(provenanceDao).testSave(User.class);
    }

    public void testMergeUser() {
        clean();
        String firstName = "fjdksjfdskljfdkls fjds";
        User user = UserFactory.create();
        provenanceDao.saveUser(user);
        assertEquals(1, provenanceDao.loadAllUser().size());
        user.getPersonName().getFirstName().setValue(firstName);
        provenanceDao.mergeUser(user);
        User userFound = provenanceDao.loadAllUser().get(0);
        assertEquals(firstName, userFound.getPersonName().getFirstName().getValue());
    }

    public void testDeleteUser() {
        clean();
        new DaoTestDelegate(provenanceDao).testDelete(User.class);
    }

    public void testfindUserById() {
        clean();
        new DaoTestDelegate(provenanceDao).testfindById(User.class);
    }


    public void clean() {
        List<EmailAddress> trash7 = provenanceDao.loadAllEmailAddress();
        for (EmailAddress leftOver : trash7) {
            provenanceDao.deleteEmailAddress(leftOver);
        }

        List<Organization> trash8 = provenanceDao.loadAllOrganization();
        for (Organization leftOver : trash8) {
            provenanceDao.deleteOrganization(leftOver);
        }

        List<Person> trash10 = provenanceDao.loadAllPerson();
        for (Person leftOver : trash10) {
            provenanceDao.deletePerson(leftOver);
        }

        List<PostalAddress> trash11 = provenanceDao.loadAllPostalAddress();
        for (PostalAddress leftOver : trash11) {
            provenanceDao.deletePostalAddress(leftOver);
        }

        List<TelephoneNumber> trash12 = provenanceDao.loadAllTelephoneNumber();
        for (TelephoneNumber leftOver : trash12) {
            provenanceDao.deleteTelephoneNumber(leftOver);
        }

        List<User> trash14 = provenanceDao.loadAllUser();
        for (User leftOver : trash14) {
            provenanceDao.deleteUser(leftOver);
        }

    }

}
