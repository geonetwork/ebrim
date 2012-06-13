package org.geonetwork.domain.ebrs;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;

/**
 * 
 * Canonical reference data and extension package reference data is often published in XML
 * documents containing a SubmitObjectsRequest. That's why it's useful to have a partial
 * domain mapping (and JiBX binding), so we can easily read such documents in to memory.
 * 
 * From regrep-3.0-os/schema/lcm.xsd :
 * 
 * The SubmitObjectsRequest allows one to submit a list of RegistryObject elements. 
 * 
 * Each RegistryEntry element provides metadata for a single submitted object. Note that the 
 * repository item being submitted is in a separate document that is not in this DTD. 
 * 
 * The ebXML Messaging Services Specfication defines packaging, for submission, of the metadata of 
 * a repository item with the repository item itself. 
 * 
 * The value of the id attribute of the ExtrinsicObject element must be the same as the xlink:href 
 * attribute within the Reference element within the Manifest element of the MessageHeader.
 * 
 * @author heikki doeleman
 *
 */
public class SubmitObjectsRequest {

	//
	// from RegistryRequestType (rs.xsd)
	//
	public URI id;
	/**
	 *  Comment may be used by requestor to describe the request. Used in VersionInfo.comment.
	 */
	public String comment;
	/**
	 * every request may be extended using Slots. NOT JiBX-mapped yet !
	 */
	public List<Slot> requestSlotList;
	
	//
	// end of RegistryRequestType
	//
	
	public List<? extends Identifiable> registryObjectList = new ArrayList<Identifiable>();
	/**
	 * For JiBX binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<? extends Identifiable> registryObjectListFactory() {
		return new ArrayList<Identifiable>();
	}
	public URI getId() {
		return id;
	}
	public void setId(URI id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Slot> getRequestSlotList() {
		return requestSlotList;
	}
	public void setRequestSlotList(List<Slot> requestSlotList) {
		this.requestSlotList = requestSlotList;
	}
	public List<? extends Identifiable> getRegistryObjectList() {
		return registryObjectList;
	}
	public void setRegistryObjectList(List<? extends Identifiable> registryObjectList) {
		this.registryObjectList = registryObjectList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubmitObjectsRequest other = (SubmitObjectsRequest) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
