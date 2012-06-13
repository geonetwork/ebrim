package org.geonetwork.domain.filter110;

import org.geonetwork.domain.filter110.spatialop.Beyond;
import org.geonetwork.domain.filter110.spatialop.DWithin;

public abstract class Operator {
	
	public boolean equals(Object o) {
		if(o instanceof Operator) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return this.getClass().getCanonicalName();
	}
	
	public static Operator beyondFactory() {
		return new Beyond();
	}
	public static Operator dWithinFactory() {
		return new DWithin();
	}	
	
	
}
