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

package org.geonetwork.domain.ebrim.informationmodel.association;

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
public class Association extends RegistryObject {

	@IndexedEmbedded
	RegistryObject targetRegistryObject;

	@IndexedEmbedded
	protected URI associationType;
	@IndexedEmbedded
	protected URI sourceObject;
	@IndexedEmbedded
	protected URI targetObject;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((associationType == null) ? 0 : associationType.hashCode());
		result = prime * result + ((sourceObject == null) ? 0 : sourceObject.hashCode());
		result = prime * result + ((targetObject == null) ? 0 : targetObject.hashCode());
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
		Association other = (Association) obj;
		if (associationType == null) {
			if (other.associationType != null)
				return false;
		} else if (!associationType.equals(other.associationType))
			return false;
		if (sourceObject == null) {
			if (other.sourceObject != null)
				return false;
		} else if (!sourceObject.equals(other.sourceObject))
			return false;
		if (targetObject == null) {
			if (other.targetObject != null)
				return false;
		} else if (!targetObject.equals(other.targetObject))
			return false;
		return true;
	}

	public URI getAssociationType() {
		return associationType;
	}

	public void setAssociationType(URI associationType) {
		this.associationType = associationType;
	}

	public URI getSourceObject() {
		return sourceObject;
	}

	public void setSourceObject(URI sourceObject) {
		this.sourceObject = sourceObject;
	}

	public URI getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(URI targetObject) {
		this.targetObject = targetObject;
	}

	public RegistryObject getTargetRegistryObject() {
		return targetRegistryObject;
	}

	public void setTargetRegistryObject(RegistryObject targetRegistryObject) {
		this.targetRegistryObject = targetRegistryObject;
	}
}
