package org.geonetwork.domain.ows100._19115subset;

/**
 * Information required to enable contact with the responsible person and/or organization. 
 * 
 * For OWS use in the service metadata document, the optional hoursOfService and 
 * contactInstructions elements were retained, as possibly being useful in the ServiceProvider 
 * section.
 * 
 * @author heikki doeleman
 *
 */
public class Contact {

	private Telephone phone;
	private Address address;
	private OnlineResource onlineResource;
	private String hoursOfService;
	private String contactInstructions;
	
	public Telephone getPhone() {
		return phone;
	}
	public void setPhone(Telephone phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public OnlineResource getOnlineResource() {
		return onlineResource;
	}
	public void setOnlineResource(OnlineResource onlineResource) {
		this.onlineResource = onlineResource;
	}
	public String getHoursOfService() {
		return hoursOfService;
	}
	public void setHoursOfService(String hoursOfService) {
		this.hoursOfService = hoursOfService;
	}
	public String getContactInstructions() {
		return contactInstructions;
	}
	public void setContactInstructions(String contactInstructions) {
		this.contactInstructions = contactInstructions;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((onlineResource == null) ? 0 : onlineResource.hashCode());
        result = prime * result + ((hoursOfService == null) ? 0 : hoursOfService.hashCode());
        result = prime * result + ((contactInstructions == null) ? 0 : contactInstructions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Contact)) {
			return false;
		}
		Contact other = (Contact) obj;

        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone
                .equals(other.phone))
            return false;

        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address
                .equals(other.address))
            return false;

        if (onlineResource == null) {
            if (other.onlineResource != null)
                return false;
        } else if (!onlineResource
                .equals(other.onlineResource))
            return false;

        if (hoursOfService == null) {
            if (other.hoursOfService != null)
                return false;
        } else if (!hoursOfService
                .equals(other.hoursOfService))
            return false;

        if (contactInstructions == null) {
            if (other.contactInstructions != null)
                return false;
        } else if (!contactInstructions
                .equals(other.contactInstructions))
            return false;

		return true;
	}
}
