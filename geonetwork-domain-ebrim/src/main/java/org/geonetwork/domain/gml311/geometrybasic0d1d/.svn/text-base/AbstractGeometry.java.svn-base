package org.geonetwork.domain.gml311.geometrybasic0d1d;

import org.geonetwork.domain.gml311.basictypes.NCNameList;
import org.geonetwork.domain.gml311.geometryprimitives.Solid;
import org.geonetwork.domain.gml311.gmlbase.AbstractGML;

/**
 * 
 * All geometry elements are derived directly or indirectly from this abstract supertype.
 * 
 * A geometry element may have an identifying attribute ("gml:id"), a name (attribute "name") and a 
 * description (attribute "description"). It may be associated with a spatial reference system (attribute 
 * "srsName"). 
 * 
 * The following rules shall be adhered: 
 * 
 * - Every geometry type shall derive from this abstract type. 
 * - Every geometry element (i.e. an element of a geometry type) shall be directly or indirectly in the substitution group of _Geometry.
 * 
 * 
 * @author heikki doeleman
 *
 */
public abstract class AbstractGeometry extends AbstractGML {

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result
				+ ((srsDimension == null) ? 0 : srsDimension.hashCode());
		result = prime * result + ((srsName == null) ? 0 : srsName.hashCode());
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
		AbstractGeometry other = (AbstractGeometry) obj;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (srsDimension == null) {
			if (other.srsDimension != null)
				return false;
		} else if (!srsDimension.equals(other.srsDimension))
			return false;
		if (srsName == null) {
			if (other.srsName != null)
				return false;
		} else if (!srsName.equals(other.srsName))
			return false;
		return true;
	}

	public static AbstractGeometry solidFactory() {
		return new Solid();
	}
	
	/**
	 * This attribute is included for backward compatibility with GML 2 and is deprecated 
	 * with GML 3. This identifer is superceded by "gml:id" inherited from AbstractGMLType. 
	 * The attribute "gid" should not be used anymore and may be deleted in future versions 
	 * of GML without further notice.
	 */
	private String gid;
	
	/**
	 * In general this reference points to a CRS instance of gml:CoordinateReferenceSystemType (see 
	 * coordinateReferenceSystems.xsd). For well known references it is not required that the CRS 
	 * description exists at the location the URI points to. If no srsName attribute is given, the 
	 * CRS must be specified as part of the larger context this geometry element is part of, e.g. a 
	 * geometric element like point, curve, etc. It is expected that this attribute will be specified 
	 * at the direct position level only in rare cases.
	 */
	private String srsName;
	
	/**
	 * The "srsDimension" is the length of coordinate sequence (the number of entries in the list). This 
	 * dimension is specified by the coordinate reference system. When the srsName attribute is omitted, 
	 * this attribute shall be omitted.
	 */
	private Integer srsDimension;
	
	/**
	 * Ordered list of labels for all the axes of this CRS. The gml:axisAbbrev value should be used for 
	 * these axis labels, after spaces and forbiddden characters are removed. When the srsName attribute 
	 * is included, this attribute is optional. When the srsName attribute is omitted, this attribute shall also be omitted.
	 */
	private NCNameList axisLabels;
	
	/**
	 * Ordered list of unit of measure (uom) labels for all the axes of this CRS. The value of the string 
	 * in the gml:catalogSymbol should be used for this uom labels, after spaces and forbiddden characters 
	 * are removed. When the axisLabels attribute is included, this attribute shall also be included. When 
	 * the axisLabels attribute is omitted, this attribute shall also be omitted.
	*/
	private NCNameList uomLabels;

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getSrsName() {
		return srsName;
	}

	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}

	public Integer getSrsDimension() {
		return srsDimension;
	}

	public void setSrsDimension(Integer srsDimension) {
		this.srsDimension = srsDimension;
	}

	public NCNameList getAxisLabels() {
		return axisLabels;
	}

	public void setAxisLabels(NCNameList axisLabels) {
		this.axisLabels = axisLabels;
	}

	public NCNameList getUomLabels() {
		return uomLabels;
	}

	public void setUomLabels(NCNameList uomLabels) {
		this.uomLabels = uomLabels;
	}	
	
	
}