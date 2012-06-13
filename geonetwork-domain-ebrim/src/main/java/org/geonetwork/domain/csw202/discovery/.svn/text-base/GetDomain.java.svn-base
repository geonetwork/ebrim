package org.geonetwork.domain.csw202.discovery;

/**
 * Requests the actual values of some specified request parameter or other data element.
 * 
 * The optional GetDomain request is specified in clause 10.7 of OGC 07-006r1. This request produces 
 * a description of the value domain of a given data element or request parameter, where the value 
 * domain is the set of actual or permissible values. The value domain may be enumerated or 
 * non-enumerated. A possible use of this request is to discover 'active' terms in a taxonomy that 
 * are currently being used to classify registry objects. The actual type of the data element is 
 * always returned, even if additional information about the value space is available.
 * 
 * The XML representation of the entity body in a request submitted using the POST method shall be a 
 * csw:GetDomain element. The value of the csw:PropertyName element shall be an XPath expression 
 * (location path) that refers to some ebRIM property. Many of the ebRIM properties can be accessed 
 * in this manner, and those that refer to nodes in canonical classification schemes can be queried 
 * in this manner.
 * 
 * As a special case, a request for a list of published—rather than supported—object types must 
 * identify only those object types of which instances exist in the catalogue. That is, specifying 
 * a PropertyName value of rim:RegistryObject/@objectType will yield a list of object types that 
 * currently populate the catalogue. In general, all properties that refer to nodes in canonical 
 * classification schemes shall be handled in this manner. 
 * 
 * EXAMPLE Request a listing of all catalogued object types. 
 * <code>
 * 		<csw:GetDomain service="CSW-ebRIM" version="1.0.0">
 * 				<csw:PropertyName>
 * 					rim:RegistryObject/@objectType
 * 				</csw:PropertyName> 
 * 		</csw:GetDomain>
 * </code>
 * 
 * @author heikki doeleman
 *
 */
public class GetDomain extends RequestBase {
	
	// the 2 below are in a choice (either is present)	
	private String propertyName;
	private String parameterName;

    private String service;

    private String version;

    //
    // Basic Retrieval Options
    //

    public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

    
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;

        this.parameterName = null;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;

        this.propertyName = null;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((propertyName == null) ? 0 : propertyName.hashCode());
        result = prime * result + ((parameterName == null) ? 0 : parameterName.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        result = prime * result + ((service == null) ? 0 : service.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GetDomain)) {
			return false;
		}
		GetDomain other = (GetDomain) obj;

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

        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version
                .equals(other.version))
            return false;

        if (service == null) {
            if (other.service != null)
                return false;
        } else if (!service
                .equals(other.service))
            return false;
        return true;
	}
}
