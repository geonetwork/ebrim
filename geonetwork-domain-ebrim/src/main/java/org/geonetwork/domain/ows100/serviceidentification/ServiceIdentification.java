package org.geonetwork.domain.ows100.serviceidentification;

import org.geonetwork.domain.ows100.dataidentification.Description;

import java.util.List;
import java.util.ArrayList;

public class ServiceIdentification extends Description {

    private String serviceType;

    private List<String> serviceTypeVersion;

    private String fees;

    private List<String> accessConstraints;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public List<String> getAccessConstraints() {
        return accessConstraints;
    }

    public void setAccessConstraints(List<String> accessConstraints) {
        this.accessConstraints = accessConstraints;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public List<String> getServiceTypeVersion() {
        return serviceTypeVersion;
    }

    public void setServiceTypeVersion(List<String> serviceTypeVersion) {
        this.serviceTypeVersion = serviceTypeVersion;
    }

    /**
      * For Jixb binding.
      *
      * @return
      */
     @SuppressWarnings("unused")
     private static  List<String> serviceTypeVersionListFactory() {
         return new ArrayList<String>();
     }

    @SuppressWarnings("unused")
     private static  List<String> accessConstraintsListFactory() {
         return new ArrayList<String>();
     }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
        result = prime * result + ((serviceTypeVersion == null) ? 0 : serviceTypeVersion.hashCode());
        result = prime * result + ((fees == null) ? 0 : fees.hashCode());
        result = prime * result + ((accessConstraints == null) ? 0 : accessConstraints.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ServiceIdentification)) {
            return false;
        }

        if (!super.equals(obj))
            return false;

        ServiceIdentification other = (ServiceIdentification) obj;

        if (serviceType == null) {
            if (other.serviceType != null)
                return false;
        } else if (!serviceType
                .equals(other.serviceType))
            return false;

        if (serviceTypeVersion == null) {
            if (other.serviceTypeVersion != null)
                return false;
        } else if (!serviceTypeVersion
                .equals(other.serviceTypeVersion))
            return false;

        if (fees == null) {
            if (other.fees != null)
                return false;
        } else if (!fees
                .equals(other.fees))
            return false;

        if (accessConstraints == null) {
            if (other.accessConstraints != null)
                return false;
        } else if (!accessConstraints
                .equals(other.accessConstraints))
            return false;

        return true;
    }
}
