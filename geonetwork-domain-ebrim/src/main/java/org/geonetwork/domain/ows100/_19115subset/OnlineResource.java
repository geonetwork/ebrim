package org.geonetwork.domain.ows100._19115subset;

/**
 * Reference to on-line resource from which data can be obtained. 
 * 
 * For OWS use in the service metadata document, the CI_OnlineResource class was XML encoded as 
 * the attributeGroup "xlink:simpleLink", as used in GML. 
 * 
 * @author heikki doeleman
 *
 */
public class OnlineResource {

    private String value ;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OnlineResource)) {
			return false;
		}
		OnlineResource other = (OnlineResource) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value
                .equals(other.value))
            return false;

		return true;
	}
}
