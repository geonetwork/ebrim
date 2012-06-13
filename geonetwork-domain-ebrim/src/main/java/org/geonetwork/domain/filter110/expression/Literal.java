package org.geonetwork.domain.filter110.expression;

public class Literal extends Expression {
	
	private String whatever ;

	public String getWhatever() {
		return whatever;
	}

	public void setWhatever(String whatever) {
		this.whatever = whatever;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((whatever == null) ? 0 : whatever.hashCode());
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
		Literal other = (Literal) obj;
		if (whatever == null) {
			if (other.whatever != null)
				return false;
		} else if (!whatever.equals(other.whatever))
			return false;
		return true;
	}
	
}
