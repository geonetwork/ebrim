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

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.ShortName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String32;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class PostalAddress {
	// for Hibernate
	@DocumentId
	private long id;

	@IndexedEmbedded
	private ShortName city;
	@IndexedEmbedded
	private ShortName country;
	@IndexedEmbedded
	private ShortName postalCode;
	@IndexedEmbedded
	private ShortName stateOrProvince;
	@IndexedEmbedded
	private ShortName street;
	@IndexedEmbedded
	private String32 streetNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<Slot> setFactory() {
		return new HashSet<Slot>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((stateOrProvince == null) ? 0 : stateOrProvince.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((streetNumber == null) ? 0 : streetNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostalAddress other = (PostalAddress) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (stateOrProvince == null) {
			if (other.stateOrProvince != null)
				return false;
		} else if (!stateOrProvince.equals(other.stateOrProvince))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (streetNumber == null) {
			if (other.streetNumber != null)
				return false;
		} else if (!streetNumber.equals(other.streetNumber))
			return false;
		return true;
	}

	public ShortName getCity() {
		return city;
	}

	public void setCity(ShortName city) {
		this.city = city;
	}

	public ShortName getCountry() {
		return country;
	}

	public void setCountry(ShortName country) {
		this.country = country;
	}

	public ShortName getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(ShortName postalCode) {
		this.postalCode = postalCode;
	}

	public ShortName getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(ShortName stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public ShortName getStreet() {
		return street;
	}

	public void setStreet(ShortName street) {
		this.street = street;
	}

	public String32 getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String32 streetNumber) {
		this.streetNumber = streetNumber;
	}

}
