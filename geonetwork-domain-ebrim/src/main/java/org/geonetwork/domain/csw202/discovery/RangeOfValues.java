package org.geonetwork.domain.csw202.discovery;

/**
 * 
 * @author heikki doeleman
 *
 */
public class RangeOfValues {

	private Object minValue;
	private Object maxValue;
	
	public Object getMinValue() {
		return minValue;
	}
	public void setMinValue(Object minValue) {
		this.minValue = minValue;
	}
	public Object getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(Object maxValue) {
		this.maxValue = maxValue;
	}
	
   @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((minValue == null) ? 0 : minValue.hashCode());
        result = prime * result + ((maxValue == null) ? 0 : maxValue.hashCode());
 		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RangeOfValues)) {
			return false;
		}
		RangeOfValues other = (RangeOfValues) obj;

        if (minValue == null) {
            if (other.minValue != null)
                return false;
        } else if (!minValue
                .equals(other.minValue))
            return false;
        if (maxValue == null) {
            if (other.maxValue != null)
                return false;
        } else if (!maxValue
                .equals(other.maxValue))
            return false;

		return true;
	}
}
