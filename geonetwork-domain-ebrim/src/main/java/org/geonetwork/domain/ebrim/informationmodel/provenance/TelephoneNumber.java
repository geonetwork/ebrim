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

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String16;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String32;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String8;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class TelephoneNumber {
	// for Hibernate
	@DocumentId
	private long id;

	@IndexedEmbedded
	private String8 areaCode;
	@IndexedEmbedded
	private String8 countryCode;
	@IndexedEmbedded
	private String8 extension;
	@IndexedEmbedded
	private String16 number;
	@IndexedEmbedded
	private String32 phoneType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((phoneType == null) ? 0 : phoneType.hashCode());
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
		TelephoneNumber other = (TelephoneNumber) obj;
		if (areaCode == null) {
			if (other.areaCode != null)
				return false;
		} else if (!areaCode.equals(other.areaCode))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (phoneType == null) {
			if (other.phoneType != null)
				return false;
		} else if (!phoneType.equals(other.phoneType))
			return false;
		return true;
	}

	public String8 getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String8 areaCode) {
		this.areaCode = areaCode;
	}

	public String8 getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String8 countryCode) {
		this.countryCode = countryCode;
	}

	public String8 getExtension() {
		return extension;
	}

	public void setExtension(String8 extension) {
		this.extension = extension;
	}

	public String16 getNumber() {
		return number;
	}

	public void setNumber(String16 number) {
		this.number = number;
	}

	public String32 getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String32 phoneType) {
		this.phoneType = phoneType;
	}

}
