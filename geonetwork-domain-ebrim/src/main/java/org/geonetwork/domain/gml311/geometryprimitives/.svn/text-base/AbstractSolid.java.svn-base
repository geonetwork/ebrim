package org.geonetwork.domain.gml311.geometryprimitives;

import org.geonetwork.domain.gml311.geometrybasic0d1d.AbstractGeometricPrimitive;

/**
 * An abstraction of a solid to support the different levels of complexity. A solid is always contiguous.
 * 
 * @author heikki doeleman
 *
 */
public abstract class AbstractSolid extends AbstractGeometricPrimitive {
	
	public boolean equals(Object o) {
		if(o instanceof AbstractSolid) {
			AbstractGeometricPrimitive base = (AbstractGeometricPrimitive) o;
			return super.equals(base);
		}
		else {
			return false;
		}
	}
	
	public int hashcode() {
		return super.hashCode();
	}

}
