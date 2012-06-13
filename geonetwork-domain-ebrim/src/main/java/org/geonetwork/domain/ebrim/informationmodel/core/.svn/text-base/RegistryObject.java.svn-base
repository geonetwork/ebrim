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

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * Note: in the ebXML schema, the URI members of this class are of type "referenceURI"; however in the specification
 * they are of type "ObjectRef".
 * 
 * Note about @IndexedEmbedded depth property: (API documentation) Stop indexing embedded elements when depth is reached
 * depth=1 means the associated element is index, but not its embedded elements Default: infinite (an exception will be
 * raised if a class circular reference occurs while infinite is chosen)
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class RegistryObject extends Identifiable {

	@IndexedEmbedded(depth = 2)
	Set<Association> associationsSet = new HashSet<Association>();
	@IndexedEmbedded(depth = 2)
	protected Set<Classification> classifications = new HashSet<Classification>();
	@IndexedEmbedded(depth = 2)
	protected Set<ExternalIdentifier> externalIdentifiers = new HashSet<ExternalIdentifier>();
	@IndexedEmbedded
	protected InternationalString description;
	@IndexedEmbedded
	protected URN lid;
	@IndexedEmbedded
	protected InternationalString name;
	@IndexedEmbedded
	protected URI objectType;
	@IndexedEmbedded
	protected URI status;
	@IndexedEmbedded
	protected VersionInfo versionInfo;

	/**
	 * The hibernate mapping strategy "table per concrete-class (union-subclass)" is used. Therefore the  
	 * the relationt need to be able to work reverser, see	 * 
	 * http://www.redhat.com/docs/manuals/jboss/jboss-eap-4.2/doc/hibernate/Hibernate_Reference_Guide/Inheritance_Mapping-Limitations.html
	 * This registryObjectListInverse services this purpose. 
	 */
	RegistryObjectList registryObjectListInverse;


	/**
	 * The hibernate mapping strategy "table per concrete-class (union-subclass)" is used. Therefore the
	 * the relationt need to be able to work reverser, see	 *
	 * http://www.redhat.com/docs/manuals/jboss/jboss-eap-4.2/doc/hibernate/Hibernate_Reference_Guide/Inheritance_Mapping-Limitations.html
	 * This registryObjectListInverse services this purpose.
	 */
	RegistryPackage registryPackageInverse;

    public RegistryPackage getRegistryPackageInverse() {
        return registryPackageInverse;
    }

    public void setRegistryPackageInverse(RegistryPackage registryPackageInverse) {
        this.registryPackageInverse = registryPackageInverse;
    }

    public enum statusType {
		Approved, Deprecated, Submitted, Withdrawn
	}

    /**
	 * For JiBX binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<Classification> classificationSetFactory() {
		return new HashSet<Classification>();
	}

	/**
	 * For JiBX binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<ExternalIdentifier> externalIdentifierSetFactory() {
		return new HashSet<ExternalIdentifier>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((classifications == null) ? 0 : classifications.hashCode());
		result = prime * result + ((externalIdentifiers == null) ? 0 : externalIdentifiers.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((lid == null) ? 0 : lid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objectType == null) ? 0 : objectType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((versionInfo == null) ? 0 : versionInfo.hashCode());
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
		RegistryObject other = (RegistryObject) obj;
		if (classifications == null) {
			if (other.classifications != null)
				return false;
		} else if (!classifications.equals(other.classifications))
			return false;
		if (externalIdentifiers == null) {
			if (other.externalIdentifiers != null)
				return false;
		} else if (!externalIdentifiers.equals(other.externalIdentifiers))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (lid == null) {
			if (other.lid != null)
				return false;
		} else if (!lid.equals(other.lid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objectType == null) {
			if (other.objectType != null)
				return false;
		} else if (!objectType.equals(other.objectType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (versionInfo == null) {
			if (other.versionInfo != null)
				return false;
		} else if (!versionInfo.equals(other.versionInfo))
			return false;
		return true;
	}

	public Set<Classification> getClassifications() {
		return classifications;
	}

	public void setClassifications(Set<Classification> classifications) {
		this.classifications = classifications;
	}

	public Set<ExternalIdentifier> getExternalIdentifiers() {
		return externalIdentifiers;
	}

	public void setExternalIdentifiers(Set<ExternalIdentifier> externalIdentifiers) {
		this.externalIdentifiers = externalIdentifiers;
	}

	public InternationalString getDescription() {
		return description;
	}

	public void setDescription(InternationalString description) {
		this.description = description;
	}

	public URN getLid() {
		return lid;
	}

	public void setLid(URN lid) {
		this.lid = lid;
	}

	public InternationalString getName() {
		return name;
	}

	public void setName(InternationalString name) {
		this.name = name;
	}

	public URI getObjectType() {
		return objectType;
	}

	public void setObjectType(URI objectType) {
		this.objectType = objectType;
	}

	public URI getStatus() {
		return status;
	}

	public void setStatus(URI status) {
		this.status = status;
	}

	public VersionInfo getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(VersionInfo versionInfo) {
		this.versionInfo = versionInfo;
	}

	public Set<Association> getAssociationsSet() {
		return associationsSet;
	}

	public void setAssociationsSet(Set<Association> associationsSet) {
		this.associationsSet = associationsSet;
	}

	public RegistryObjectList getRegistryObjectListInverse() {
		return registryObjectListInverse;
	}

	public void setRegistryObjectListInverse(RegistryObjectList registryObjectListInverse) {
		this.registryObjectListInverse = registryObjectListInverse;
	}
}
