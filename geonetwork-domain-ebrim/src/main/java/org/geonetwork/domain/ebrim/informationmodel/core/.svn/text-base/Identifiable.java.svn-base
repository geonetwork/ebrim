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

package org.geonetwork.domain.ebrim.informationmodel.core;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
public abstract class Identifiable {

	@DocumentId
	private long hibernateId;
	@IndexedEmbedded
	protected URN id;
	@IndexedEmbedded
	protected URI home;
	@IndexedEmbedded
	protected Set<Slot> slots;

	public long getHibernateId() {
		return hibernateId;
	}

	public void setHibernateId(long hibernateId) {
		this.hibernateId = hibernateId;
	}

	/**
	 * For Jixb binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<Slot> setFactory() {
		return new HashSet<Slot>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((home == null) ? 0 : home.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((slots == null) ? 0 : slots.hashCode());
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
		Identifiable other = (Identifiable) obj;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (slots == null) {
			if (other.slots != null)
				return false;
		} else if (!slots.equals(other.slots))
			return false;
		return true;
	}

	public URN getId() {
		return id;
	}

	public void setId(URN id) {
		this.id = id;
	}

	public URI getHome() {
		return home;
	}

	public void setHome(URI home) {
		this.home = home;
	}

	public Set<Slot> getSlots() {
		return slots;
	}

	public void setSlots(Set<Slot> slots) {
		this.slots = slots;
	}

	public void addSlot(Slot slot) {
		this.slots.add(slot);
	}

    /**
     * Returns slots with the slotName
     *
     * @param slotName      Slot name to return
     * @return              List of slots with slotName, null otherwise
     */
    public List<Slot> findSlotsByName(String slotName) {
        List<Slot> findedSlots = new ArrayList<Slot>();

        for(Slot slot: slots) {
            String name = slot.getName().getValue();
            if (name.equalsIgnoreCase(slotName)) {
                findedSlots.add(slot);
            }
        }

        return findedSlots;
     }

}
