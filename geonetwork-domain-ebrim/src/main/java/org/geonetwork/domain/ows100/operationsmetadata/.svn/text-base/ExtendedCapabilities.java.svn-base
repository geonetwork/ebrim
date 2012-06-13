package org.geonetwork.domain.ows100.operationsmetadata;

/**
 * Base class for extended capabilities
 *
 * @Author Jose
 */
public class ExtendedCapabilities {
    private String wsdlLocation;

    public String getWsdlLocation() {
        return wsdlLocation;
    }

    public void setWsdlLocation(String wsdlLocation) {
        this.wsdlLocation = wsdlLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExtendedCapabilities that = (ExtendedCapabilities) o;

        if (wsdlLocation != null ? !wsdlLocation.equals(that.wsdlLocation) : that.wsdlLocation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return wsdlLocation != null ? wsdlLocation.hashCode() : 0;
    }
}
