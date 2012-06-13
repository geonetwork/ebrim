package org.geonetwork.domain.filter110.comparisonop;

import org.geonetwork.domain.filter110.expression.Expression;
import org.geonetwork.domain.filter110.expression.LowerBoundary;
import org.geonetwork.domain.filter110.expression.UpperBoundary;

/**
 * 
 * @author heikki doeleman
 *
 */
public class PropertyIsBetween extends ComparisonOps {

	private Expression expression;
	private LowerBoundary lowerBoundary;
	private UpperBoundary upperBoundary;
	
	public Expression getExpression() {
		return expression;
	}
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	public LowerBoundary getLowerBoundary() {
		return lowerBoundary;
	}
	public void setLowerBoundary(LowerBoundary lowerBoundary) {
		this.lowerBoundary = lowerBoundary;
	}
	public UpperBoundary getUpperBoundary() {
		return upperBoundary;
	}
	public void setUpperBoundary(UpperBoundary upperBoundary) {
		this.upperBoundary = upperBoundary;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expression == null) ? 0 : expression.hashCode());
		result = prime * result
				+ ((lowerBoundary == null) ? 0 : lowerBoundary.hashCode());
		result = prime * result
				+ ((upperBoundary == null) ? 0 : upperBoundary.hashCode());
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
		PropertyIsBetween other = (PropertyIsBetween) obj;
		if (expression == null) {
			if (other.expression != null)
				return false;
		} else if (!expression.equals(other.expression))
			return false;
		if (lowerBoundary == null) {
			if (other.lowerBoundary != null)
				return false;
		} else if (!lowerBoundary.equals(other.lowerBoundary))
			return false;
		if (upperBoundary == null) {
			if (other.upperBoundary != null)
				return false;
		} else if (!upperBoundary.equals(other.upperBoundary))
			return false;
		return true;
	}
	
	
}
