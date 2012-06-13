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

import java.util.HashSet;
import java.util.Set;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class RegistryPackage extends RegistryObject {

	@IndexedEmbedded
	protected Set<RegistryObject> registryObjectList;

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<RegistryObject> registryObjectSetFactory() {
		return new HashSet<RegistryObject>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((registryObjectList == null) ? 0 : registryObjectList.hashCode());
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
		RegistryPackage other = (RegistryPackage) obj;
		if (registryObjectList == null) {
			if (other.registryObjectList != null)
				return false;
		} else if (!registryObjectList.equals(other.registryObjectList))
			return false;
		return true;
	}

	public Set<RegistryObject> getRegistryObjectList() {
		return registryObjectList;
	}

	public void setRegistryObjectList(Set<RegistryObject> registryObjectList) {
		this.registryObjectList = registryObjectList;
	}

}
