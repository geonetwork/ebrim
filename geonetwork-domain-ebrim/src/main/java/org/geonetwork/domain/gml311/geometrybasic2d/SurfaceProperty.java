package org.geonetwork.domain.gml311.geometrybasic2d;

import org.geonetwork.domain.gml311.gmlbase.AssociationAttributeGroup;

/**
 * A property that has a surface as its value domain can either be an appropriate geometry element 
 * encapsulated in an element of this type or an XLink reference to a remote geometry element (where 
 * remote includes geometry elements located elsewhere in the same document). Either the reference or 
 * the contained element must be given, but neither both nor none.
 * 
 * @author heikki doeleman
 *
 */
public class SurfaceProperty {

	AbstractSurface surface;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((associationAttributeGroup == null) ? 0
						: associationAttributeGroup.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SurfaceProperty other = (SurfaceProperty) obj;
		if (associationAttributeGroup == null) {
			if (other.associationAttributeGroup != null)
				return false;
		} else if (!associationAttributeGroup
				.equals(other.associationAttributeGroup))
			return false;
		if (surface == null) {
			if (other.surface != null)
				return false;
		} else if (!surface.equals(other.surface))
			return false;
		return true;
	}

	AssociationAttributeGroup associationAttributeGroup = new AssociationAttributeGroup();

	public AbstractSurface getSurface() {
		return surface;
	}

	public void setSurface(AbstractSurface surface) {
		this.surface = surface;
	}

	public AssociationAttributeGroup getAssociationAttributeGroup() {
		return associationAttributeGroup;
	}

	public void setAssociationAttributeGroup(
			AssociationAttributeGroup associationAttributeGroup) {
		this.associationAttributeGroup = associationAttributeGroup;
	}
	
	
}
