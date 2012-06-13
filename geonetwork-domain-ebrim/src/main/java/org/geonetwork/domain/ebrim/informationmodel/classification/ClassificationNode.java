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
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Index;

/**
 *
 * Note about @IndexedEmbedded depth property: (API documentation)
 *      Stop indexing embedded elements when depth is reached depth=1 means the associated element is index,
 *      but not its embedded elements
 *      Default: infinite (an exception will be raised if a class circular reference occurs while infinite is chosen)
 *
 * @author Heikki Doeleman
 * 
 */

@Indexed
public class ClassificationNode extends RegistryObject {

	// private ObjectRef parent;
	@IndexedEmbedded
	private URI parent;
	@IndexedEmbedded
	private LongName code;
	@Field //(index = Index.UN_TOKENIZED)
	private String path;

	@IndexedEmbedded(depth = 2)
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		ClassificationNode other = (ClassificationNode) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	public Set<ClassificationNode> getClassificationNodes() {
		return classificationNodes;
	}

	public void setClassificationNodes(Set<ClassificationNode> classificationNodes) {
		this.classificationNodes = classificationNodes;
	}

	public URI getParent() {
		return parent;
	}

	public void setParent(URI parent) {
		this.parent = parent;
	}

	public LongName getCode() {
		return code;
	}

	public void setCode(LongName code) {
		this.code = code;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
