package org.geonetwork.domain.filter110.expression;

public abstract class Expression {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Expression other = (Expression) obj;
		if (value == null) {
			if (other.value != null){
				return false;
			}
		} else if (!value.equals(other.value)){
			return false;
		}
		return true;
	}
	private String value;
	
	public void setValue(String value) {
		this.value = value;		
	}
	public String getValue() {
		return value;
	}	
}
