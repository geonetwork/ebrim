package org.geonetwork.domain.csw202.record;

public class BoundingBox {

	private String lowerCorner;
	private String upperCorner;
	private String crs;
	private String dimensions;
	private String bbtype;

	public String getLowerCorner() {
		return lowerCorner;
	}

	public void setLowerCorner(String lowerCorner) {
		this.lowerCorner = lowerCorner;
	}

	public String getUpperCorner() {
		return upperCorner;
	}

	public void setUpperCorner(String upperCorner) {
		this.upperCorner = upperCorner;
	}

	public String getCrs() {
		return crs;
	}

	public void setCrs(String crs) {
		this.crs = crs;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getBbtype() {
		return bbtype;
	}

	public void setBbtype(String bbtype) {
		this.bbtype = bbtype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bbtype == null) ? 0 : bbtype.hashCode());
		result = prime * result + ((crs == null) ? 0 : crs.hashCode());
		result = prime * result + ((dimensions == null) ? 0 : dimensions.hashCode());
		result = prime * result + ((lowerCorner == null) ? 0 : lowerCorner.hashCode());
		result = prime * result + ((upperCorner == null) ? 0 : upperCorner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BoundingBox))
			return false;
		BoundingBox other = (BoundingBox) obj;
		if (bbtype == null) {
			if (other.bbtype != null)
				return false;
		} else if (!bbtype.equals(other.bbtype))
			return false;
		if (crs == null) {
			if (other.crs != null)
				return false;
		} else if (!crs.equals(other.crs))
			return false;
		if (dimensions == null) {
			if (other.dimensions != null)
				return false;
		} else if (!dimensions.equals(other.dimensions))
			return false;
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
