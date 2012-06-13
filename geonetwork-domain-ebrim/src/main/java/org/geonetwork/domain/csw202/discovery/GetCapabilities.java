package org.geonetwork.domain.csw202.discovery;

/**
 * Request for a description of service capabilities. See OGC 05-008 for more information.
 * <p/>
 * The mandatory GetCapabilities request allows a client to retrieve information about the service.
 * The body of the response message contains a service description that advertises the basic
 * operational and non-operational characteristics of the service; the description is structured
 * into subsections that may be retrieved individually by name.
 * <p/>
 * The GetCapabilities request is specified in cl. 7.2 of OGC 05-008 (OWS Common 1.0) and cl. 10.5
 * of OGC 07-006r1. The GET method shall be supported. Support for the POST method is optional; the
 * allowed content encoding(s) ("application/xml" and/or "application/x-www-form-urlencoded") shall
 * be advertised in the capabilities document as values of the operation-specific "Content-Type"
 * constraint. The value of the service parameter shall be the service type code "CSW-ebRIM". The
 * value of the version parameter shall be "1.0.0".
 * <p/>
 * The sections parameter may be used to request a subset of the complete capabilities document;
 * the value is a comma-separated list of section names. The set of recognized section names shall
 * be as specified in Table 7 of OGC 05-008 and Table 58 of OGC 07-006r1, with the exception of
 * "Contents".
 *
 * @author heikki doeleman
 */
public class GetCapabilities extends org.geonetwork.domain.ows100.getcapabilities.GetCapabilities {

    private String service = "http://www.opengis.net/cat/csw/2.0.2";

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
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
        if (!(obj instanceof GetCapabilities)) {
            return false;
        }
        GetCapabilities other = (GetCapabilities) obj;

        org.geonetwork.domain.ows100.getcapabilities.GetCapabilities other1 = (org.geonetwork.domain.ows100.getcapabilities.GetCapabilities) other;
        org.geonetwork.domain.ows100.getcapabilities.GetCapabilities this1 = (org.geonetwork.domain.ows100.getcapabilities.GetCapabilities) this;

        if (other1.equals(this1)) {
            if (service == null) {
                if (other.service != null)
                    return false;
            } else if (!service
                    .equals(other.service))
                return false;

        } else {
            return false;
        }

        return true;
    }
}
