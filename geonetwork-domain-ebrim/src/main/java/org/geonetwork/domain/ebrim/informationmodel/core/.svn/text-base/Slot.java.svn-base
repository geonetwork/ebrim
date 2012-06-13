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

package org.geonetwork.domain.ebrim.informationmodel.core;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class Slot {

	// for Hibernate
	@DocumentId
	private long id;
	@IndexedEmbedded
	public LongName name;
	@IndexedEmbedded
	public LongName slotType;
	@IndexedEmbedded
	public ValueList valueList;
	@IndexedEmbedded
	public org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.ValueList basicExtensionValueList;

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
		result = prime
				* result
				+ ((basicExtensionValueList == null) ? 0
						: basicExtensionValueList.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((slotType == null) ? 0 : slotType.hashCode());
		result = prime * result
				+ ((valueList == null) ? 0 : valueList.hashCode());
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
		Slot other = (Slot) obj;
		if (basicExtensionValueList == null) {
			if (other.basicExtensionValueList != null)
				return false;
		} else if (!basicExtensionValueList
				.equals(other.basicExtensionValueList))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (slotType == null) {
			if (other.slotType != null)
				return false;
		} else if (!slotType.equals(other.slotType))
			return false;
		if (valueList == null) {
			if (other.valueList != null)
				return false;
		} else if (!valueList.equals(other.valueList))
			return false;
		return true;
	}

	public LongName getName() {
		return name;
	}

	public void setName(LongName name) {
		this.name = name;
	}

	public LongName getSlotType() {
		return slotType;
	}

	public void setSlotType(LongName slotType) {
		this.slotType = slotType;
	}

	public org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.ValueList getBasicExtensionValueList() {
		return basicExtensionValueList;
	}

	public void setBasicExtensionValueList(
			org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.ValueList basicExtensionValueList) {
		this.basicExtensionValueList = basicExtensionValueList;
        updateValueLists();
	}

	public ValueList getValueList() {
		return valueList;
	}

	public void setValueList(ValueList valueList) {
		this.valueList = valueList;
        updateValueLists();
	}

    /*
     * valueList and basicExtensionValueList are exclusive according to xsd
     */
    private void updateValueLists() {
        if ((basicExtensionValueList != null) && (basicExtensionValueList.size() > 0)) {
            valueList = null;
        } else {
            basicExtensionValueList = null;
        }
    }
}
