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
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class ServiceBinding extends RegistryObject {

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<SpecificationLink> specificationLinkSetFactory() {
		return new HashSet<SpecificationLink>();
	}

	@IndexedEmbedded
	private URI accessURI;
	// private ObjectRef service;
	@IndexedEmbedded
	private URI service;
	@IndexedEmbedded
	private Set<SpecificationLink> specificationLinks;
	// private ObjectRef targetBinding;
	@IndexedEmbedded
	private URI targetBinding;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((accessURI == null) ? 0 : accessURI.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((specificationLinks == null) ? 0 : specificationLinks.hashCode());
		result = prime * result + ((targetBinding == null) ? 0 : targetBinding.hashCode());
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
		ServiceBinding other = (ServiceBinding) obj;
		if (accessURI == null) {
			if (other.accessURI != null)
				return false;
		} else if (!accessURI.equals(other.accessURI))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (specificationLinks == null) {
			if (other.specificationLinks != null)
				return false;
		} else if (!specificationLinks.equals(other.specificationLinks))
			return false;
		if (targetBinding == null) {
			if (other.targetBinding != null)
				return false;
		} else if (!targetBinding.equals(other.targetBinding))
			return false;
		return true;
	}

	public URI getAccessURI() {
		return accessURI;
	}

	public void setAccessURI(URI accessURI) {
		this.accessURI = accessURI;
	}

	public URI getService() {
		return service;
	}

	public void setService(URI service) {
		this.service = service;
	}

	public Set<SpecificationLink> getSpecificationLinks() {
		return specificationLinks;
	}

	public void setSpecificationLinks(Set<SpecificationLink> specificationLinks) {
		this.specificationLinks = specificationLinks;
	}

	public URI getTargetBinding() {
		return targetBinding;
	}

	public void setTargetBinding(URI targetBinding) {
		this.targetBinding = targetBinding;
	}

}
