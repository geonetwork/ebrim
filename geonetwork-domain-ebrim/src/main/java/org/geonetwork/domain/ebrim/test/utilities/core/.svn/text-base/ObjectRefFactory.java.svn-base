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

package org.geonetwork.domain.ebrim.test.utilities.core;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.core.ObjectRef;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;

public class ObjectRefFactory {

	public synchronized static ObjectRef create() {

		ObjectRef or = new ObjectRef();

		or.setCreateReplica(Boolean.TRUE);
		URI home = new URI();
		home.setValue("http://home");
		or.setHome(home);
		URN id = new URN();
		id.setValue("id");
		or.setId(id);
		Set<Slot> slots = new HashSet<Slot>();
		Slot slot1 = SlotFactory.create();
		Slot slot2 = SlotFactory.create();
		slots.add(slot1);
		slots.add(slot2);
		or.setSlots(slots);

		return or;

	}
}
