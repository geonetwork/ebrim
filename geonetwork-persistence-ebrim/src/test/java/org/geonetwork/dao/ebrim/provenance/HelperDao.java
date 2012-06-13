package org.geonetwork.dao.ebrim.provenance;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.ebrim.extensionpackage.basicextension.association.Annotates;
import org.geonetwork.domain.ebrim.informationmodel.provenance.EmailAddress;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HelperDao extends HibernateDaoSupport {

	boolean executedSaveEmailAddress = false;
	boolean executedSaveAnnotates = false;
	boolean executedMergeEmailAddress = false;
	boolean executedDeleteEmailAddress = false;
	boolean executedDeleteAnnotates = false;
	boolean executedMergeAnnotates = false;

	EmailAddress emailAddress;
	Annotates annotates;

	void saveEmailAddress(EmailAddress emailAddress) {
		executedSaveEmailAddress = true;
		this.emailAddress = emailAddress;
	}

	void saveAnnotates(Annotates annotates) {
		executedSaveAnnotates = true;
		this.annotates = annotates;
	}

	void mergeEmailAddress(EmailAddress emailAddress) {
		executedMergeEmailAddress = true;
	}

	void mergeAnnotates(Annotates annotates) {
		executedMergeAnnotates = true;
	}

	void deleteEmailAddress(EmailAddress emailAddress) {
		executedDeleteEmailAddress = true;
	}

	List<EmailAddress> loadAllEmailAddress() {
		EmailAddress emailAddress = new EmailAddress();
		List<EmailAddress> list = new ArrayList<EmailAddress>();
		if (executedSaveEmailAddress && !executedDeleteEmailAddress)
			list.add(emailAddress);
		return list;
	}

	List<Annotates> loadAllAnnotates() {
		Annotates annotates = new Annotates();
		List<Annotates> list = new ArrayList<Annotates>();

		if (executedSaveAnnotates && !executedDeleteAnnotates)
			list.add(annotates);
		return list;
	}

	EmailAddress findEmailAddressById(long id) {
		return emailAddress;
	}

	Annotates findAnnotatesById(long id) {
		return annotates;
	}

}
