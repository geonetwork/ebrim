package org.geonetwork.domain.csw202.discovery;

import org.geonetwork.domain.ows100.getcapabilities.CapabilitiesBase;
import org.geonetwork.domain.ows100.filtercapabilities.FilterCapabilities;

/**
 * This type extends ows:CapabilitiesBaseType defined in OGC-05-008 to include information 
 * about supported OGC filter components. A profile may extend this type to describe additional 
 * capabilities.
 * 
 * If the request is processed successfully, the body of the response message shall include a valid 
 * XML document where the document element has the following infoset properties:
 * 
 * [local name] = "Capabilities"
 * [namespace name] = "http://www.opengis.net/cat/wrs/1.0"
 * 
 * A sample capabilities document is listed in Annex C.1. The corresponding type definition is shown 
 * in the code listing below. See clauses 10.5 and 10.13 in OGC 07-006r1 for details. 
 * <code>
 * 		<xsd:element name="Capabilities" type="csw:CapabilitiesType" />
 * </code>
 * 
 * @author heikki doeleman
 *
 */
public class Capabilities extends CapabilitiesBase {

	private FilterCapabilities filterCapabilities;

	public FilterCapabilities getFilterCapabilities() {
		return filterCapabilities;
	}

	public void setFilterCapabilities(FilterCapabilities filterCapabilities) {
		this.filterCapabilities = filterCapabilities;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = super.hashCode();
        result = prime * result + ((filterCapabilities == null) ? 0 : filterCapabilities.hashCode());
 		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Capabilities)) {
			return false;
		}
		Capabilities other = (Capabilities) obj;

        if (!super.equals(obj))
            return false;

        if (filterCapabilities == null) {
            if (other.filterCapabilities != null)
                return false;
        } else if (!filterCapabilities
                .equals(other.filterCapabilities))
            return false;

		return true;
	}
	
}
