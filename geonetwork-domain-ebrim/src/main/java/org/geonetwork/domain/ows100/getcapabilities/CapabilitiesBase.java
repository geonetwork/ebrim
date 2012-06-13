package org.geonetwork.domain.ows100.getcapabilities;

import org.geonetwork.domain.ows100.operationsmetadata.OperationsMetadata;
import org.geonetwork.domain.ows100.serviceidentification.ServiceIdentification;
import org.geonetwork.domain.ows100.serviceprovider.ServiceProvider;

/**
 * XML encoded GetCapabilities operation response. This document provides clients with service 
 * metadata about a specific service instance, usually including metadata about the 
 * tightly-coupled data served. If the server does not implement the updateSequence parameter, 
 * the server shall always return the complete Capabilities document, without the updateSequence 
 * parameter. When the server implements the updateSequence parameter and the GetCapabilities 
 * operation request included the updateSequence parameter with the current value, the server 
 * shall return this element with only the "version" and "updateSequence" attributes. Otherwise, 
 * all optional elements shall be included or not depending on the actual value of the Contents 
 * parameter in the GetCapabilities operation request. This base type shall be extended by each 
 * specific OWS to include the additional contents needed. 
 * 
 * @author heikki doeleman
 *
 */
public class CapabilitiesBase {

	private String version ;
	private String updateSequence ;
	
	private ServiceIdentification serviceIdentification ;
	private ServiceProvider serviceProvider;
	private OperationsMetadata operationsMetadata;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUpdateSequence() {
		return updateSequence;
	}
	public void setUpdateSequence(String updateSequence) {
		this.updateSequence = updateSequence;
	}
	public ServiceIdentification getServiceIdentification() {
		return serviceIdentification;
	}
	public void setServiceIdentification(ServiceIdentification serviceIdentification) {
		this.serviceIdentification = serviceIdentification;
	}
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public OperationsMetadata getOperationsMetadata() {
		return operationsMetadata;
	}
	public void setOperationsMetadata(OperationsMetadata operationsMetadata) {
		this.operationsMetadata = operationsMetadata;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((version == null) ? 0 : version.hashCode());
        result = prime * result + ((updateSequence == null) ? 0 : updateSequence.hashCode());
        result = prime * result + ((serviceIdentification == null) ? 0 : serviceIdentification.hashCode());
        result = prime * result + ((serviceProvider == null) ? 0 : serviceProvider.hashCode());
        result = prime * result + ((operationsMetadata == null) ? 0 : operationsMetadata.hashCode());
 		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CapabilitiesBase)) {
			return false;
		}
		CapabilitiesBase other = (CapabilitiesBase) obj;

        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version
                .equals(other.version))
            return false;

        if (updateSequence == null) {
            if (other.updateSequence != null)
                return false;
        } else if (!updateSequence
                .equals(other.updateSequence))
            return false;

        if (serviceIdentification == null) {
            if (other.serviceIdentification != null)
                return false;
        } else if (!serviceIdentification
                .equals(other.serviceIdentification))
            return false;

        if (serviceProvider == null) {
            if (other.serviceProvider != null)
                return false;
        } else if (!serviceProvider
                .equals(other.serviceProvider))
            return false;

        if (operationsMetadata == null) {
            if (other.operationsMetadata != null)
                return false;
        } else if (!operationsMetadata
                .equals(other.operationsMetadata))
            return false;

		return true;
	}
}
