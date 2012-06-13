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

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.FreeFormText;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * Depends on commons collections for using the class Bag.
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class SpecificationLink extends RegistryObject {

	// private ObjectRef serviceBinding;
	// private ObjectRef specificationObject;
	@IndexedEmbedded
	private URI serviceBinding;
	@IndexedEmbedded
	private URI specificationObject;
	@IndexedEmbedded
	private InternationalString usageDescription;
	// private Bag<FreeFormText> usageParameters;
	// private Bag usageParameters;
	@IndexedEmbedded
	private List<FreeFormText> usageParameters;

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 * @SuppressWarnings("unused") private static HashBag usageParameterBagFactory() { return
	 *                             (HashBag)TypedBag.decorate(new HashBag(),
	 *                             org.geonetwork.ebxml.informationmodel
	 *                             .core.datatype.FreeFormText.class); }
	 */
	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<FreeFormText> usageParameterBagFactory() {
		return new ArrayList<FreeFormText>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((serviceBinding == null) ? 0 : serviceBinding.hashCode());
		result = prime * result + ((specificationObject == null) ? 0 : specificationObject.hashCode());
		result = prime * result + ((usageDescription == null) ? 0 : usageDescription.hashCode());
		result = prime * result + ((usageParameters == null) ? 0 : usageParameters.hashCode());
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
		SpecificationLink other = (SpecificationLink) obj;
		if (serviceBinding == null) {
			if (other.serviceBinding != null)
				return false;
		} else if (!serviceBinding.equals(other.serviceBinding))
			return false;
		if (specificationObject == null) {
			if (other.specificationObject != null)
				return false;
		} else if (!specificationObject.equals(other.specificationObject))
			return false;
		if (usageDescription == null) {
			if (other.usageDescription != null)
				return false;
		} else if (!usageDescription.equals(other.usageDescription))
			return false;
		if (usageParameters == null) {
			if (other.usageParameters != null)
				return false;
		} else if (!usageParameters.equals(other.usageParameters))
			return false;
		return true;
	}

	public URI getServiceBinding() {
		return serviceBinding;
	}

	public void setServiceBinding(URI serviceBinding) {
		this.serviceBinding = serviceBinding;
	}

	public URI getSpecificationObject() {
		return specificationObject;
	}

	public void setSpecificationObject(URI specificationObject) {
		this.specificationObject = specificationObject;
	}

	public InternationalString getUsageDescription() {
		return usageDescription;
	}

	public void setUsageDescription(InternationalString usageDescription) {
		this.usageDescription = usageDescription;
	}

	public List<FreeFormText> getUsageParameters() {
		return usageParameters;
	}

	public void setUsageParameters(List<FreeFormText> usageParameters) {
		this.usageParameters = usageParameters;
	}

}
