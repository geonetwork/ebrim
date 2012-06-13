//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================

package org.geonetwork.domain.ebrim.test.utilities.provenance;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.VersionInfo;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.ShortName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String16;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.provenance.EmailAddress;
import org.geonetwork.domain.ebrim.informationmodel.provenance.PersonName;
import org.geonetwork.domain.ebrim.informationmodel.provenance.PostalAddress;
import org.geonetwork.domain.ebrim.informationmodel.provenance.TelephoneNumber;
import org.geonetwork.domain.ebrim.informationmodel.provenance.User;
import org.geonetwork.domain.ebrim.test.utilities.classification.ClassificationFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.SlotFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.VersionInfoFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.datatype.InternationalStringFactory;

public class UserFactory {

	public synchronized static User create() {
		User o = new User();

		Set<PostalAddress> addresses = new HashSet<PostalAddress>();
		PostalAddress postalAddress1 = PostalAddressFactory.create();
		PostalAddress postalAddress2 = PostalAddressFactory.create();
		postalAddress2.setCity(new ShortName("city2"));
		addresses.add(postalAddress1);
		addresses.add(postalAddress2);
		o.setAddresses(addresses);

		Set<Classification> classifications = new HashSet<Classification>();
		Classification classification1 = ClassificationFactory.create();
		Classification classification2 = ClassificationFactory.create();
		classification2.setClassificationNode(new URI("http://classification-node2"));
		classifications.add(classification1);
		classifications.add(classification2);
		o.setClassifications(classifications);

		InternationalString description = InternationalStringFactory.create();
		o.setDescription(description);

		Set<EmailAddress> emailAddresses = new HashSet<EmailAddress>();
		EmailAddress emailAddress1 = EmailAddressFactory.create();
		EmailAddress emailAddress2 = EmailAddressFactory.create();
		emailAddress2.setAddress(new ShortName("emailaddress2@example.org"));
		emailAddresses.add(emailAddress1);
		emailAddresses.add(emailAddress2);
		o.setEmailAddresses(emailAddresses);

		o.setHome(new URI("http://personhome"));
		o.setId(new URN("urn:person-urn"));
		o.setLid(new URN("urn:person-lid"));
		InternationalString name = InternationalStringFactory.create();
		o.setName(name);

		o.setObjectType(new URI("http://person-objecttype"));
		PersonName personName = PersonNameFactory.create();
		o.setPersonName(personName);

		Set<Slot> slots = new HashSet<Slot>();
		Slot slot1 = SlotFactory.create();
		Slot slot2 = SlotFactory.create();
		slot2.setName(new LongName("slot2-name"));
		slots.add(slot1);
		slots.add(slot2);
		o.setSlots(slots);

		o.setStatus(new URI("http://person-status"));
		Set<TelephoneNumber> telephoneNumbers = new HashSet<TelephoneNumber>();
		TelephoneNumber telephoneNumber1 = TelephoneNumberFactory.create();
		TelephoneNumber telephoneNumber2 = TelephoneNumberFactory.create();
		telephoneNumber2.setNumber(new String16("number2-number"));
		telephoneNumbers.add(telephoneNumber1);
		telephoneNumbers.add(telephoneNumber2);
		o.setTelephoneNumbers(telephoneNumbers);

		VersionInfo versionInfo = VersionInfoFactory.create();
		o.setVersionInfo(versionInfo);

		return o;
	}
}
