package org.geonetwork.domain.filter110.spatialop;
/**
 * 
 * @author heikki doeleman
 *
 */
public class Beyond extends DistanceBuffer {

	public boolean equals(Object o) {

		if(o instanceof Beyond) {
			return super.equals(((DistanceBuffer)o));
		}
		else {
			return false;
		}
	}
	
	public int hashCode() {
		return super.hashCode();
	}
}
