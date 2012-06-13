package org.geonetwork.domain.csw202.discovery;

import java.util.List;
import java.util.ArrayList;

/**
 * Returns the actual values for some property. In general this is a subset of the value domain 
 * (that is, set of permissible values), although in some cases these may be the same.
 * 
 * If the request is processed successfully, the body of the response message shall include a valid 
 * XML document where the root element has the following infoset properties:
 * 
 * [local name] = GetDomainResponse.
 * [namespace name] = http://www.opengis.net/cat/csw/2.0.2
 * 
 * If the request specifies an unknown parameter or property, the response shall include a status 
 * code of 404; an exception with the code wrs:NotFound may also be included in the body of the 
 * response.
 * 
 * @author heikki doeleman
 *
 */
public class GetDomainResponse {
	
	private List<DomainValues> domainValues;

	public List<DomainValues> getDomainValues() {
		return domainValues;
	}

	public void setDomainValues(List<DomainValues> domainValues) {
		this.domainValues = domainValues;
	}
	

    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<DomainValues> domainValuesFactory() {
		return new ArrayList<DomainValues>();
	}

   @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainValues == null) ? 0 : domainValues.hashCode());
        return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GetDomainResponse)) {
			return false;
		}
		GetDomainResponse other = (GetDomainResponse) obj;

        if (domainValues == null) {
            if (other.domainValues != null)
                return false;
        } else if (!domainValues
                .equals(other.domainValues))
            return false;
        
		return true;
	}
}
