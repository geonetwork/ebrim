package org.geonetwork.domain.ows100._19115subset;

import java.util.List;
import java.util.ArrayList;

/**
 * Location of the responsible individual or organization. 
 * 
 * @author heikki doeleman
 *
 */
public class Address {

	/**
	 * Address line for the location. 
	 */
	private List<String> deliveryPoint;
	
	/**
	 * City of the location. 
	 */
	private String city;
	
	/**
	 * State or province of the location.
	 */
	private String administrativeArea;
	
	/**
	 * ZIP or other postal code. 
	 */
	private String postalCode ;
	
	/**
	 * Country of the physical address. 
	 */
	private String country ;
	
	/**
	 * Address of the electronic mailbox of the responsible organization or individual.
	 */
	private List<String> electronicMailAddress;

	public List<String> getDeliveryPoint() {
		return deliveryPoint;
	}

	public void setDeliveryPoint(List<String> deliveryPoint) {
		this.deliveryPoint = deliveryPoint;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdministrativeArea() {
		return administrativeArea;
	}

	public void setAdministrativeArea(String administrativeArea) {
		this.administrativeArea = administrativeArea;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getElectronicMailAddress() {
		return electronicMailAddress;
	}

	public void setElectronicMailAddress(List<String> electronicMailAddress) {
		this.electronicMailAddress = electronicMailAddress;
	}

    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<String>deliveryPointListFactory() {
		return new ArrayList<String>();
	}

    @SuppressWarnings("unused")
	private static List<String>electronicMailAddressListFactory() {
		return new ArrayList<String>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryPoint == null) ? 0 : deliveryPoint.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((administrativeArea == null) ? 0 : administrativeArea.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((electronicMailAddress == null) ? 0 : electronicMailAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;

        if (deliveryPoint == null) {
            if (other.deliveryPoint != null)
                return false;
        } else if (!deliveryPoint
                .equals(other.deliveryPoint))
            return false;

        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city
                .equals(other.city))
            return false;

        if (administrativeArea == null) {
            if (other.administrativeArea != null)
                return false;
        } else if (!administrativeArea
                .equals(other.administrativeArea))
            return false;

        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode
                .equals(other.postalCode))
            return false;

        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country
                .equals(other.country))
            return false;

        if (electronicMailAddress == null) {
            if (other.electronicMailAddress != null)
                return false;
        } else if (!electronicMailAddress
                .equals(other.electronicMailAddress))
            return false;

		return true;
	}
	
}
