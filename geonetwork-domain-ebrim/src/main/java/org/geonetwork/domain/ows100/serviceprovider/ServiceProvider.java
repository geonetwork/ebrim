package org.geonetwork.domain.ows100.serviceprovider;

import org.geonetwork.domain.ows100._19115subset.OnlineResource;
import org.geonetwork.domain.ows100._19115subset.ResponsiblePartySubset;

/**
 * 
 * Metadata about the organization that provides this specific service instance or server. 
 * 
 * @author heikki doeleman
 *
 */
public class ServiceProvider {

	private String providerName ;
	private OnlineResource providerSite ;
	private ResponsiblePartySubset serviceContact;
	
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public OnlineResource getProviderSite() {
		return providerSite;
	}
	public void setProviderSite(OnlineResource providerSite) {
		this.providerSite = providerSite;
	}
	public ResponsiblePartySubset getServiceContact() {
		return serviceContact;
	}
	public void setServiceContact(ResponsiblePartySubset serviceContact) {
		this.serviceContact = serviceContact;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((providerName == null) ? 0 : providerName.hashCode());
        result = prime * result + ((providerSite == null) ? 0 : providerSite.hashCode());
        result = prime * result + ((serviceContact == null) ? 0 : serviceContact.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ServiceProvider)) {
			return false;
		}
		ServiceProvider other = (ServiceProvider) obj;

        if (providerName == null) {
            if (other.providerName != null)
                return false;
        } else if (!providerName
                .equals(other.providerName))
            return false;

        if (providerSite == null) {
            if (other.providerSite != null)
                return false;
        } else if (!providerSite
                .equals(other.providerSite))
            return false;

        if (serviceContact == null) {
            if (other.serviceContact != null)
                return false;
        } else if (!serviceContact
                .equals(other.serviceContact))
            return false;

		return true;
	}
}
