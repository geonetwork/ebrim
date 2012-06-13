package org.geonetwork.domain.filter110.spatialop;

import org.geonetwork.domain.filter110.expression.PropertyName;
import org.geonetwork.domain.gml311.geometrybasic0d1d.AbstractGeometry;

/**
 * 
 * @author heikki doeleman
 *
 */
public class DistanceBuffer extends SpatialOps {

	private PropertyName propertyName;
	private AbstractGeometry geometry;
	private Distance distance;
	
	public PropertyName getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(PropertyName propertyName) {
		this.propertyName = propertyName;
	}
	public AbstractGeometry getGeometry() {
		return geometry;
	}
	public void setGeometry(AbstractGeometry geometry) {
		this.geometry = geometry;
	}
	public Distance getDistance() {
		return distance;
	}
	public void setDistance(Distance distance) {
		this.distance = distance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distance == null) ? 0 : distance.hashCode());
		result = prime * result
				+ ((geometry == null) ? 0 : geometry.hashCode());
		result = prime * result
				+ ((propertyName == null) ? 0 : propertyName.hashCode());
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
		DistanceBuffer other = (DistanceBuffer) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (geometry == null) {
			if (other.geometry != null)
				return false;
		} else if (!geometry.equals(other.geometry))
			return false;
		if (propertyName == null) {
			if (other.propertyName != null)
				return false;
		} else if (!propertyName.equals(other.propertyName))
			return false;
		return true;
	}
	
	
}
