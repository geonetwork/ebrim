package org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * Represents gml:Envelope.
 * 
 * TODO move to gml package.
 * 
 * @author heikki doeleman
 *
 */
@Indexed
public class Envelope {
	
	@IndexedEmbedded
	private LowerCorner lowerCorner;
	
	@IndexedEmbedded
	private UpperCorner upperCorner;
	
	public LowerCorner getLowerCorner() {
		return lowerCorner;
	}
	public void setLowerCorner(LowerCorner lowerCorner) {
		this.lowerCorner = lowerCorner;
	}
	public UpperCorner getUpperCorner() {
		return upperCorner;
	}
	public void setUpperCorner(UpperCorner upperCorner) {
		this.upperCorner = upperCorner;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lowerCorner == null) ? 0 : lowerCorner.hashCode());
		result = prime * result
				+ ((upperCorner == null) ? 0 : upperCorner.hashCode());
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
		Envelope other = (Envelope) obj;
		if (lowerCorner == null) {
			if (other.lowerCorner != null)
				return false;
		} else if (!lowerCorner.equals(other.lowerCorner))
			return false;
		if (upperCorner == null) {
			if (other.upperCorner != null)
				return false;
		} else if (!upperCorner.equals(other.upperCorner))
			return false;
		return true;
	}
	
	
}
