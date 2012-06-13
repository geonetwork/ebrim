package org.geonetwork.domain.filter110.spatialop;

import org.geonetwork.domain.filter110.Operator;

/**
 * 
 * @author heikki doeleman
 *
 */
public abstract class SpatialOps extends Operator {
	
	public boolean equals(Object o) {
		System.out.println("equals spatialops");		
		if(o instanceof SpatialOps) {
			Operator base = (Operator) o;
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
