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

package org.geonetwork.domain.ebrim.test.utilities.cooperatingregistries;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.cooperatingregistries.Federation;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.VersionInfo;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.xsd.Duration;
import org.geonetwork.domain.ebrim.test.utilities.classification.ClassificationFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.SlotFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.VersionInfoFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.datatype.InternationalStringFactory;

public class FederationFactory {

	public synchronized static Federation create() {
		Federation o = new Federation();

		Duration replicationSyncLatency = new Duration();
		replicationSyncLatency.setDays(1);
		replicationSyncLatency.setHours(2);
		replicationSyncLatency.setMinutes(3);
		replicationSyncLatency.setMonths(4);
		replicationSyncLatency.setNegative(true);
		replicationSyncLatency.setSeconds(5d);
		replicationSyncLatency.setYears(6);
		o.setReplicationSyncLatency(replicationSyncLatency);

		Set<Classification> classifications = new HashSet<Classification>();
		Classification classification1 = ClassificationFactory.create();
		Classification classification2 = ClassificationFactory.create();
		classification2.setClassificationNode(new URI("http://federation-node2"));
		classification2.setId(new URN("urn:classification2-id"));
		classifications.add(classification1);
		classifications.add(classification2);
		o.setClassifications(classifications);

		InternationalString description = InternationalStringFactory.create();
		o.setDescription(description);

		o.setHome(new URI("http://federation-home"));
		o.setId(new URN("urn:federation-id"));
		o.setLid(new URN("urn:federation-lid"));

		InternationalString name = InternationalStringFactory.create();
		o.setName(name);

		o.setObjectType(new URI("http://federation-objectType"));

		Set<Slot> slots = new HashSet<Slot>();
		Slot slot1 = SlotFactory.create();
		Slot slot2 = SlotFactory.create();
		slot2.setName(new LongName("slot2-name"));
		slots.add(slot1);
		slots.add(slot2);
		o.setSlots(slots);

		o.setStatus(new URI("http://federation-status"));

		VersionInfo versionInfo = VersionInfoFactory.create();
		o.setVersionInfo(versionInfo);

		return o;
	}
}
