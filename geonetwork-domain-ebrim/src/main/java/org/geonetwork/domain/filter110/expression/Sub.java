package org.geonetwork.domain.filter110.expression;


/**
 * 
 * @author heikki doeleman
 *
 */
public class Sub extends BinaryOperator{

	public boolean equals(Object o) {
		if(o instanceof Sub) {
			BinaryOperator base = (BinaryOperator) o;
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
