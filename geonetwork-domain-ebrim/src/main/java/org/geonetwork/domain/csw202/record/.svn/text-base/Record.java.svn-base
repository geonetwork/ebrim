package org.geonetwork.domain.csw202.record;

/**
 * This type extends DCMIRecordType to add ows:BoundingBox; it may be used to specify a spatial
 * envelope for the catalogued resource.
 * 
 * @author heikki doeleman
 * 
 */
public class Record extends DCMIRecord {

	private String anyText;

	private BoundingBox boundingBox;

	public String getAnyText() {
		return anyText;
	}

	public void setAnyText(String anyText) {
		this.anyText = anyText;
	}

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anyText == null) ? 0 : anyText.hashCode());
		result = prime * result + ((boundingBox == null) ? 0 : boundingBox.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Record))
			return false;
		Record other = (Record) obj;
		if (anyText == null) {
			if (other.anyText != null)
				return false;
		} else if (!anyText.equals(other.anyText))
			return false;
		if (boundingBox == null) {
			if (other.boundingBox != null)
				return false;
		} else if (!boundingBox.equals(other.boundingBox))
			return false;
		return true;
	}
}
