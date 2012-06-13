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

package org.geonetwork.domain.ebrim.informationmodel.classification;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */

@Indexed
public class ClassificationScheme extends RegistryObject {

	@Field
	private Boolean isInternal;
	// private ObjectRef nodeType;
	@IndexedEmbedded
	private URI nodeType;

	@IndexedEmbedded
	protected Set<ClassificationNode> classificationNodes = new HashSet<ClassificationNode>();
	/**
	 * For JiBX binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<ClassificationNode> classificationNodesFactory() {
		return new HashSet<ClassificationNode>();
	}	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((isInternal == null) ? 0 : isInternal.hashCode());
		result = prime * result
				+ ((nodeType == null) ? 0 : nodeType.hashCode());
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
		ClassificationScheme other = (ClassificationScheme) obj;
		if (isInternal == null) {
			if (other.isInternal != null)
				return false;
		} else if (!isInternal.equals(other.isInternal))
			return false;
		if (nodeType == null) {
			if (other.nodeType != null)
				return false;
		} else if (!nodeType.equals(other.nodeType))
			return false;
		return true;
	}

	public Boolean getIsInternal() {
		return isInternal;
	}

	public void setIsInternal(Boolean isInternal) {
		this.isInternal = isInternal;
	}

	public URI getNodeType() {
		return nodeType;
	}

	public void setNodeType(URI nodeType) {
		this.nodeType = nodeType;
	}

	public Set<ClassificationNode> getClassificationNodes() {
		return classificationNodes;
	}

	public void setClassificationNodes(Set<ClassificationNode> classificationNodes) {
		this.classificationNodes = classificationNodes;
	}

}
