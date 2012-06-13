package org.geonetwork.domain.filter110.comparisonop;

import org.geonetwork.domain.filter110.Operator;

/**
 * 
 * @author heikki doeleman
 *
 */
public abstract class ComparisonOps extends Operator {
	public boolean equals(Object o) {
		if(o instanceof ComparisonOps) {
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
