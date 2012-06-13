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

package org.geonetwork.domain.ebrim.test.utilities.association;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.VersionInfo;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.test.utilities.classification.ClassificationFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.SlotFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.VersionInfoFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.datatype.InternationalStringFactory;

public class AssociationFactory {

	public synchronized static Association create() {
		Association o = new Association();

		o.setAssociationType(new URI("http://associationType"));

		Set<Classification> classifications = new HashSet<Classification>();
		Classification classification1 = ClassificationFactory.create();
		Classification classification2 = ClassificationFactory.create();
		classification2.setClassificationNode(new URI("http://classification-node2"));
		classifications.add(classification1);
		classifications.add(classification2);
		o.setClassifications(classifications);

		InternationalString description = InternationalStringFactory.create();
		o.setDescription(description);

		o.setHome(new URI("http://association-home"));
		o.setId(new URN("urn:association-id"));
		o.setLid(new URN("urn:association-lid"));

		InternationalString name = InternationalStringFactory.create();
		o.setName(name);

		o.setObjectType(new URI("http://association-objectType"));

		Set<Slot> slots = new HashSet<Slot>();
		Slot slot1 = SlotFactory.create();
		Slot slot2 = SlotFactory.create();
		slot2.setName(new LongName("slot2-name"));
		slots.add(slot1);
		slots.add(slot2);
		o.setSlots(slots);

		o.setSourceObject(new URI("http://association-sourceObject"));
		o.setStatus(new URI("http://association-status"));
		o.setTargetObject(new URI("http://association-targetObject"));

		VersionInfo versionInfo = VersionInfoFactory.create();
		o.setVersionInfo(versionInfo);

		return o;
	}
}
