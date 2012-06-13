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

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * Note: in the ebXML schema, the URI members of this class are of type "referenceURI"; however in
 * the specification they are of type "ObjectRef".
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class Classification extends RegistryObject {

	@IndexedEmbedded
	private URI classificationScheme;
	@IndexedEmbedded
	private URI classificationNode;
	@IndexedEmbedded
	private URI classifiedObject;
	@IndexedEmbedded
	private LongName nodeRepresentation;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((classificationNode == null) ? 0 : classificationNode.hashCode());
		result = prime * result + ((classificationScheme == null) ? 0 : classificationScheme.hashCode());
		result = prime * result + ((classifiedObject == null) ? 0 : classifiedObject.hashCode());
		result = prime * result + ((nodeRepresentation == null) ? 0 : nodeRepresentation.hashCode());
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
		Classification other = (Classification) obj;
		if (classificationNode == null) {
			if (other.classificationNode != null)
				return false;
		} else if (!classificationNode.equals(other.classificationNode))
			return false;
		if (classificationScheme == null) {
			if (other.classificationScheme != null)
				return false;
		} else if (!classificationScheme.equals(other.classificationScheme))
			return false;
		if (classifiedObject == null) {
			if (other.classifiedObject != null)
				return false;
		} else if (!classifiedObject.equals(other.classifiedObject))
			return false;
		if (nodeRepresentation == null) {
			if (other.nodeRepresentation != null)
				return false;
		} else if (!nodeRepresentation.equals(other.nodeRepresentation))
			return false;
		return true;
	}

	public URI getClassificationScheme() {
		return classificationScheme;
	}

	public void setClassificationScheme(URI classificationScheme) {
		this.classificationScheme = classificationScheme;
	}

	public URI getClassificationNode() {
		return classificationNode;
	}

	public void setClassificationNode(URI classificationNode) {
		this.classificationNode = classificationNode;
	}

	public URI getClassifiedObject() {
		return classifiedObject;
	}

	public void setClassifiedObject(URI classifiedObject) {
		this.classifiedObject = classifiedObject;
	}

	public LongName getNodeRepresentation() {
		return nodeRepresentation;
	}

	public void setNodeRepresentation(LongName nodeRepresentation) {
		this.nodeRepresentation = nodeRepresentation;
	}

}
