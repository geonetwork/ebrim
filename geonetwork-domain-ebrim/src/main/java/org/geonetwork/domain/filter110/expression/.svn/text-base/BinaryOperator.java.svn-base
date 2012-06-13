package org.geonetwork.domain.filter110.expression;
/**
 * 
 * @author heikki doeleman
 *
 */
public class BinaryOperator extends Expression{
	
	Expression expression1;
	Expression expression2;
	
	public Expression getExpression1() {
		return expression1;
	}
	public void setExpression1(Expression expression1) {
		this.expression1 = expression1;
	}
	public Expression getExpression2() {
		return expression2;
	}
	public void setExpression2(Expression expression2) {
		this.expression2 = expression2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((expression1 == null) ? 0 : expression1.hashCode());
		result = prime * result
				+ ((expression2 == null) ? 0 : expression2.hashCode());
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
		BinaryOperator other = (BinaryOperator) obj;
		if (expression1 == null) {
			if (other.expression1 != null)
				return false;
		} else if (!expression1.equals(other.expression1))
			return false;
		if (expression2 == null) {
			if (other.expression2 != null)
				return false;
		} else if (!expression2.equals(other.expression2))
			return false;
		return true;
	}
	
}
