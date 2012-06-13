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

package org.geonetwork.domain.ebrim.informationmodel.service;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class Service extends RegistryObject {

	@IndexedEmbedded
	private Set<ServiceBinding> serviceBindings;

	public Set<ServiceBinding> getServiceBindings() {
		return serviceBindings;
	}

	public void setServiceBindings(Set<ServiceBinding> serviceBindings) {
		this.serviceBindings = serviceBindings;
	}

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<ServiceBinding> serviceBindingSetFactory() {
		return new HashSet<ServiceBinding>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((serviceBindings == null) ? 0 : serviceBindings.hashCode());
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
		Service other = (Service) obj;
		if (serviceBindings == null) {
			if (other.serviceBindings != null)
				return false;
		} else if (!serviceBindings.equals(other.serviceBindings))
			return false;
		return true;
	}

}
