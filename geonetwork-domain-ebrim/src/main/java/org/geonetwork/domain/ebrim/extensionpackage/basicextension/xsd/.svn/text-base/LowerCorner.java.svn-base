package org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Index;

/**
 * Represents gml:lowerCorner.
 * 
 * @author heikki doeleman
 *
 */
@Indexed
public class LowerCorner {
	
	public LowerCorner() {}
	
	public LowerCorner(String value) {
		setValue(value);
	}
	
	public String toString() {
		return this.value;
	}
	
	//@Field(index = Index.UN_TOKENIZED)
    @Field
	private String value;

    //@Field(index = Index.UN_TOKENIZED)
    @Field
	private String latitude;

    //@Field(index = Index.UN_TOKENIZED)
    @Field
	private String longitude;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;

        if (value.matches("[-+]?[0-9]*\\.?[0-9]+ [-+]?[0-9]*\\.?[0-9]+")) {
            double lat = new Double(value.split(" ")[0]).doubleValue() + 360;
            double lon = new Double(value.split(" ")[1]).doubleValue() + 360;

            longitude = new Double(lon).toString();
            latitude = new Double(lat).toString();
        }
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		LowerCorner other = (LowerCorner) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	
}
