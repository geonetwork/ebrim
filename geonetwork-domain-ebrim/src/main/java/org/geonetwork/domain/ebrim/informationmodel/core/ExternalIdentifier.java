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
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class ExternalIdentifier extends RegistryObject {
	// private ObjectRef identificationScheme;
	// private ObjectRef registryObject;
	@IndexedEmbedded
	private URI identificationScheme;
	@IndexedEmbedded
	private URI registryObject;
	@IndexedEmbedded
	private LongName value;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((identificationScheme == null) ? 0 : identificationScheme.hashCode());
		result = prime * result + ((registryObject == null) ? 0 : registryObject.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ExternalIdentifier other = (ExternalIdentifier) obj;
		if (identificationScheme == null) {
			if (other.identificationScheme != null)
				return false;
		} else if (!identificationScheme.equals(other.identificationScheme))
			return false;
		if (registryObject == null) {
			if (other.registryObject != null)
				return false;
		} else if (!registryObject.equals(other.registryObject))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	public URI getIdentificationScheme() {
		return identificationScheme;
	}

	public void setIdentificationScheme(URI identificationScheme) {
		this.identificationScheme = identificationScheme;
	}

	public URI getRegistryObject() {
		return registryObject;
	}

	public void setRegistryObject(URI registryObject) {
		this.registryObject = registryObject;
	}

	public LongName getValue() {
		return value;
	}

	public void setValue(LongName value) {
		this.value = value;
	}

}
