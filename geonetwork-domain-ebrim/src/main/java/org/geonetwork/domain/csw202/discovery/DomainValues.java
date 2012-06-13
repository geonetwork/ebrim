package org.geonetwork.domain.csw202.discovery;

/**
 * 
 * @author heikki doeleman
 *
 */
public class DomainValues {

	// the 2 below are in a choice (either is present)	
	private String propertyName;	
	private String parameterName;
	
	private ListOfValues listOfValues;
	private ConceptualScheme conceptualScheme;
	private RangeOfValues rangeOfValues;
	
	private String type;
	
	private String uom;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public ListOfValues getListOfValues() {
		return listOfValues;
	}

	public void setListOfValues(ListOfValues listOfValues) {
		this.listOfValues = listOfValues;
	}

	public ConceptualScheme getConceptualScheme() {
		return conceptualScheme;
	}

	public void setConceptualScheme(ConceptualScheme conceptualScheme) {
		this.conceptualScheme = conceptualScheme;
	}

	public RangeOfValues getRangeOfValues() {
		return rangeOfValues;
	}

	public void setRangeOfValues(RangeOfValues rangeOfValues) {
		this.rangeOfValues = rangeOfValues;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((propertyName == null) ? 0 : propertyName.hashCode());
        result = prime * result + ((parameterName == null) ? 0 : parameterName.hashCode());
        result = prime * result + ((listOfValues == null) ? 0 : listOfValues.hashCode());
        result = prime * result + ((conceptualScheme == null) ? 0 : conceptualScheme.hashCode());
        result = prime * result + ((rangeOfValues == null) ? 0 : rangeOfValues.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DomainValues)) {
			return false;
		}
		DomainValues other = (DomainValues) obj;

        if (propertyName == null) {
            if (other.propertyName != null)
                return false;
        } else if (!propertyName
                .equals(other.propertyName))
            return false;

        if (parameterName == null) {
            if (other.parameterName != null)
                return false;
        } else if (!parameterName
                .equals(other.parameterName))
            return false;

        if (listOfValues == null) {
            if (other.listOfValues != null)
                return false;
        } else if (!listOfValues
                .equals(other.listOfValues))
            return false;

        if (conceptualScheme == null) {
            if (other.conceptualScheme != null)
                return false;
        } else if (!conceptualScheme
                .equals(other.conceptualScheme))
            return false;

        if (rangeOfValues == null) {
            if (other.rangeOfValues != null)
                return false;
        } else if (!rangeOfValues
                .equals(other.rangeOfValues))
            return false;

        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type
                .equals(other.type))
            return false;

        if (uom == null) {
            if (other.uom != null)
                return false;
        } else if (!uom
                .equals(other.uom))
            return false;

		return true;
	}
	
}
