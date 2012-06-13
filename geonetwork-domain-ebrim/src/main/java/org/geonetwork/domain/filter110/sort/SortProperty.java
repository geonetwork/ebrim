package org.geonetwork.domain.filter110.sort;

import org.geonetwork.domain.filter110.expression.PropertyName;

/**
 * 
 * @author heikki doeleman
 *
 */
public class SortProperty {
	
	private PropertyName propertyName;
	private SortOrder sortOrder;
	
	public PropertyName getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(PropertyName propertyName) {
		this.propertyName = propertyName;
	}
	public SortOrder getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(SortOrder sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((propertyName == null) ? 0 : propertyName.hashCode());
		result = prime * result
				+ ((sortOrder == null) ? 0 : sortOrder.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SortProperty other = (SortProperty) obj;
		if (propertyName == null) {
			if (other.propertyName != null)
				return false;
		} else if (!propertyName.equals(other.propertyName))
			return false;
		if (sortOrder == null) {
			if (other.sortOrder != null)
				return false;
		} else if (!sortOrder.equals(other.sortOrder))
			return false;
		return true;
	}
	
	
}
