package org.geonetwork.domain.filter110.comparisonop;

import org.geonetwork.domain.filter110.expression.PropertyName;

/**
 * 
 * @author heikki doeleman
 *
 */
public class PropertyIsNull extends ComparisonOps {

	private PropertyName propertyName;

	public PropertyName getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(PropertyName propertyName) {
		this.propertyName = propertyName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((propertyName == null) ? 0 : propertyName.hashCode());
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
		PropertyIsNull other = (PropertyIsNull) obj;
		if (propertyName == null) {
			if (other.propertyName != null)
				return false;
		} else if (!propertyName.equals(other.propertyName))
			return false;
		return true;
	} 
	
	
}
