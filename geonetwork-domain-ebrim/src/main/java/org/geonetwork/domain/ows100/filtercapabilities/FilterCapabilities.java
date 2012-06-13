package org.geonetwork.domain.ows100.filtercapabilities;

/**
 * 
 * @author Erik van Ingen
 * 
 *         http://www.opengis.net/ogc
 * 
 *[local name] = "FilterCapabilities" 
 *
 *[namespace name] = "http://www.opengis.net/ogc"
 * 
 * 
 * 
 * 
 */
public class FilterCapabilities {
	private SpatialCapabilities spatialCapabilities;

	private ScalarCapabilities scalarCapabilities;

	private IdCapabilities idCapabilities;

	public SpatialCapabilities getSpatialCapabilities() {
		return spatialCapabilities;
	}

	public void setSpatialCapabilities(SpatialCapabilities spatialCapabilities) {
		this.spatialCapabilities = spatialCapabilities;
	}

	public ScalarCapabilities getScalarCapabilities() {
		return scalarCapabilities;
	}

	public void setScalarCapabilities(ScalarCapabilities scalarCapabilities) {
		this.scalarCapabilities = scalarCapabilities;
	}

	public IdCapabilities getIdCapabilities() {
		return idCapabilities;
	}

	public void setIdCapabilities(IdCapabilities idCapabilities) {
		this.idCapabilities = idCapabilities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((spatialCapabilities == null) ? 0 : spatialCapabilities.hashCode());
		// System.out.println("FilterCapabilities (spatialCapabilities) hashCode:" + result);
		result = prime * result + ((scalarCapabilities == null) ? 0 : scalarCapabilities.hashCode());
		System.out.println("FilterCapabilities (scalarCapabilities) hashCode:" + result);
		result = prime * result + ((idCapabilities == null) ? 0 : idCapabilities.hashCode());
		System.out.println("FilterCapabilities (idCapabilities) hashCode:" + result);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FilterCapabilities)) {
			return false;
		}
		FilterCapabilities other = (FilterCapabilities) obj;

		if (spatialCapabilities == null) {
			if (other.spatialCapabilities != null)
				return false;
		} else if (!spatialCapabilities.equals(other.spatialCapabilities))
			return false;

		if (scalarCapabilities == null) {
			if (other.scalarCapabilities != null)
				return false;
		} else if (!scalarCapabilities.equals(other.scalarCapabilities))
			return false;

		if (idCapabilities == null) {
			if (other.idCapabilities != null)
				return false;
		} else if (!idCapabilities.equals(other.idCapabilities))
			return false;

		return true;
	}
}
