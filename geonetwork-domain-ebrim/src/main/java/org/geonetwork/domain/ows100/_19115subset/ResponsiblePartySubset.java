package org.geonetwork.domain.ows100._19115subset;

/**
 * Identification of, and means of communication with, person responsible for the server. 
 * 
 * For OWS use in the ServiceProvider section of a service metadata document, the optional 
 * organizationName element was removed, since this type is always used with the ProviderName 
 * element which provides that information. The mandatory "role" element was changed to optional, 
 * since no clear use of this information is known in the ServiceProvider section. 
 * 
 * @author heikki doeleman
 *
 */
public class ResponsiblePartySubset {

	private String individualName;
	private String positionName;
	private Contact contactInfo;
	private CodeType role;
	
	public String getIndividualName() {
		return individualName;
	}
	public void setIndividualName(String individualName) {
		this.individualName = individualName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public Contact getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(Contact contactInfo) {
		this.contactInfo = contactInfo;
	}
	public CodeType getRole() {
		return role;
	}
	public void setRole(CodeType role) {
		this.role = role;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((individualName == null) ? 0 : individualName.hashCode());
        result = prime * result + ((positionName == null) ? 0 : positionName.hashCode());
        result = prime * result + ((contactInfo == null) ? 0 : contactInfo.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ResponsiblePartySubset)) {
			return false;
		}
		ResponsiblePartySubset other = (ResponsiblePartySubset) obj;

        if (individualName == null) {
            if (other.individualName != null)
                return false;
        } else if (!individualName
                .equals(other.individualName))
            return false;

        if (positionName == null) {
            if (other.positionName != null)
                return false;
        } else if (!positionName
                .equals(other.positionName))
            return false;

        if (contactInfo == null) {
            if (other.contactInfo != null)
                return false;
        } else if (!contactInfo
                .equals(other.contactInfo))
            return false;

        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role
                .equals(other.role))
            return false;

		return true;
	}
}
