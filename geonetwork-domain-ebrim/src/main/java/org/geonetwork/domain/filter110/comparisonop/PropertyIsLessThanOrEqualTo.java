package org.geonetwork.domain.filter110.comparisonop;
/**
 * 
 * @author heikki doeleman
 *
 */
public class PropertyIsLessThanOrEqualTo extends BinaryComparisonOp {
	public boolean equals(Object o) {
		if(o instanceof PropertyIsLessThanOrEqualTo) {
			BinaryComparisonOp base = (BinaryComparisonOp) o;
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
