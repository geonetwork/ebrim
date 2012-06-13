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

package org.geonetwork.domain.ebrim.informationmodel.provenance;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class Organization extends RegistryObject {

	@IndexedEmbedded
	private Set<PostalAddress> addresses;
	@IndexedEmbedded
	private Set<EmailAddress> emailAddresses;
	// private ObjectRef parent;
	// private ObjectRef primaryContact;
	@IndexedEmbedded
	private URI parent;
	@IndexedEmbedded
	private URI primaryContact;
	@IndexedEmbedded
	private Set<TelephoneNumber> telephoneNumbers;

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<TelephoneNumber> telephoneNumberSetFactory() {
		return new HashSet<TelephoneNumber>();
	}

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<EmailAddress> emailAddressSetFactory() {
		return new HashSet<EmailAddress>();
	}

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<PostalAddress> postalAddressSetFactory() {
		return new HashSet<PostalAddress>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((emailAddresses == null) ? 0 : emailAddresses.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((primaryContact == null) ? 0 : primaryContact.hashCode());
		result = prime * result + ((telephoneNumbers == null) ? 0 : telephoneNumbers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (emailAddresses == null) {
			if (other.emailAddresses != null)
				return false;
		} else if (!emailAddresses.equals(other.emailAddresses))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (primaryContact == null) {
			if (other.primaryContact != null)
				return false;
		} else if (!primaryContact.equals(other.primaryContact))
			return false;
		if (telephoneNumbers == null) {
			if (other.telephoneNumbers != null)
				return false;
		} else if (!telephoneNumbers.equals(other.telephoneNumbers))
			return false;
		return true;
	}

	public Set<PostalAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<PostalAddress> addresses) {
		this.addresses = addresses;
	}

	public Set<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(Set<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public URI getParent() {
		return parent;
	}

	public void setParent(URI parent) {
		this.parent = parent;
	}

	public URI getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(URI primaryContact) {
		this.primaryContact = primaryContact;
	}

	public Set<TelephoneNumber> getTelephoneNumbers() {
		return telephoneNumbers;
	}

	public void setTelephoneNumbers(Set<TelephoneNumber> telephoneNumbers) {
		this.telephoneNumbers = telephoneNumbers;
	}

}
