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

package org.geonetwork.domain.ebrim.informationmodel.cooperatingregistries;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String16;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String8;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.xsd.Duration;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */

@Indexed
public class Registry extends RegistryObject {

	@IndexedEmbedded
	private Duration catalogingLatency;
	@IndexedEmbedded
	private String16 conformanceProfile;
	@IndexedEmbedded
	private URI operator;
	// private ObjectRef operator;
	@IndexedEmbedded
	private Duration replicationSyncLatency;
	@IndexedEmbedded
	private String8 specificationVersion;

	public enum conformanceProfileType {
		registryFull, registryLite
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((catalogingLatency == null) ? 0 : catalogingLatency.hashCode());
		result = prime * result + ((conformanceProfile == null) ? 0 : conformanceProfile.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		result = prime * result + ((replicationSyncLatency == null) ? 0 : replicationSyncLatency.hashCode());
		result = prime * result + ((specificationVersion == null) ? 0 : specificationVersion.hashCode());
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
		Registry other = (Registry) obj;
		if (catalogingLatency == null) {
			if (other.catalogingLatency != null)
				return false;
		} else if (!catalogingLatency.equals(other.catalogingLatency))
			return false;
		if (conformanceProfile == null) {
			if (other.conformanceProfile != null)
				return false;
		} else if (!conformanceProfile.equals(other.conformanceProfile))
			return false;
		if (operator == null) {
			if (other.operator != null)
				return false;
		} else if (!operator.equals(other.operator))
			return false;
		if (replicationSyncLatency == null) {
			if (other.replicationSyncLatency != null)
				return false;
		} else if (!replicationSyncLatency.equals(other.replicationSyncLatency))
			return false;
		if (specificationVersion == null) {
			if (other.specificationVersion != null)
				return false;
		} else if (!specificationVersion.equals(other.specificationVersion))
			return false;
		return true;
	}

	public Duration getCatalogingLatency() {
		return catalogingLatency;
	}

	public void setCatalogingLatency(Duration catalogingLatency) {
		this.catalogingLatency = catalogingLatency;
	}

	public String16 getConformanceProfile() {
		return conformanceProfile;
	}

	public void setConformanceProfile(String16 conformanceProfile) {
		this.conformanceProfile = conformanceProfile;
	}

	public URI getOperator() {
		return operator;
	}

	public void setOperator(URI operator) {
		this.operator = operator;
	}

	public Duration getReplicationSyncLatency() {
		return replicationSyncLatency;
	}

	public void setReplicationSyncLatency(Duration replicationSyncLatency) {
		this.replicationSyncLatency = replicationSyncLatency;
	}

	public String8 getSpecificationVersion() {
		return specificationVersion;
	}

	public void setSpecificationVersion(String8 specificationVersion) {
		this.specificationVersion = specificationVersion;
	}

}
