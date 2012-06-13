//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================

package org.geonetwork.domain.ebrim.informationmodel.event;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.core.ObjectRef;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.*;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class AuditableEvent extends RegistryObject {
	// private ObjectRef eventType;
	@IndexedEmbedded
	private URI eventType;
	@IndexedEmbedded
	private Set<ObjectRef> affectedObjects;
	@IndexedEmbedded
	private URI requestId;
	@Field(index= Index.UN_TOKENIZED, store=Store.YES)
    @DateBridge(resolution=Resolution.DAY)    
	private Date timestamp;
	// private ObjectRef user;
	@IndexedEmbedded
	private URI user;

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static Set<ObjectRef> setFactory() {
		return new HashSet<ObjectRef>();
	}

	public enum eventTypeType {
		Approved, Created, Deleted, Deprecated, Downloaded, Relocated, Undeprecated, Updated, Versioned
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((affectedObjects == null) ? 0 : affectedObjects.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuditableEvent other = (AuditableEvent) obj;
		if (affectedObjects == null) {
			if (other.affectedObjects != null)
				return false;
		} else if (!affectedObjects.equals(other.affectedObjects))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	public URI getEventType() {
		return eventType;
	}

	public void setEventType(URI eventType) {
		this.eventType = eventType;
	}

	public Set<ObjectRef> getAffectedObjects() {
		return affectedObjects;
	}

	public void setAffectedObjects(Set<ObjectRef> affectedObjects) {
		this.affectedObjects = affectedObjects;
	}

	public URI getRequestId() {
		return requestId;
	}

	public void setRequestId(URI requestId) {
		this.requestId = requestId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public URI getUser() {
		return user;
	}

	public void setUser(URI user) {
		this.user = user;
	}

}
