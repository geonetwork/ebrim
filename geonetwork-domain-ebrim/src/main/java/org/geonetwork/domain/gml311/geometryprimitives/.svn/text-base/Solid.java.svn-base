package org.geonetwork.domain.gml311.geometryprimitives;

import org.geonetwork.domain.gml311.geometrybasic2d.SurfaceProperty;

/**
 * A solid is the basis for 3-dimensional geometry. The extent of a solid is defined by the boundary 
 * surfaces (shells). A shell is represented by a composite surface, where every  shell is used to 
 * represent a single connected component of the boundary of a solid. It consists of a composite 
 * surface (a list of orientable surfaces) connected in a topological cycle (an object whose boundary 
 * is empty). Unlike a Ring, a Shell's elements have no natural sort order. Like Rings, Shells are simple.
 * 
 * @author heikki doeleman
 *
 */
public class Solid extends AbstractSolid {

	/**
	 * Boundaries of solids are similar to surface boundaries. In normal 3-dimensional Euclidean space, 
	 * one (composite) surface is distinguished as the exterior. In the more general case, this is not 
	 * always possible.
	 */
	private SurfaceProperty exterior;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((exterior == null) ? 0 : exterior.hashCode());
		result = prime * result
				+ ((interior == null) ? 0 : interior.hashCode());
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
		Solid other = (Solid) obj;
		if (exterior == null) {
			if (other.exterior != null)
				return false;
		} else if (!exterior.equals(other.exterior))
			return false;
		if (interior == null) {
			if (other.interior != null)
				return false;
		} else if (!interior.equals(other.interior))
			return false;
		return true;
	}
	/**
	 * Boundaries of solids are similar to surface boundaries.
	 */
	private SurfaceProperty interior;
	
	public SurfaceProperty getExterior() {
		return exterior;
	}
	public void setExterior(SurfaceProperty exterior) {
		this.exterior = exterior;
	}
	public SurfaceProperty getInterior() {
		return interior;
	}
	public void setInterior(SurfaceProperty interior) {
		this.interior = interior;
	}	
	
	
}
