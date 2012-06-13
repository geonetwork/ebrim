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

package org.geonetwork.domain.ebrim.test.utilities.event;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.VersionInfo;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery;
import org.geonetwork.domain.ebrim.informationmodel.event.QueryExpression;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;
import org.geonetwork.domain.ebrim.test.utilities.core.SlotFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.VersionInfoFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.datatype.InternationalStringFactory;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery.StoredQuery;

public class AdhocQueryFactory {

	public synchronized static AdhocQuery create() {
		AdhocQuery o = new AdhocQuery();

		QueryExpression queryExpression = QueryExpressionFactory.create();
		o.setQueryExpression(queryExpression);

		InternationalString description = InternationalStringFactory.create();
		o.setDescription(description);

		o.setHome(new URI("http://adhocquery-home"));
		o.setId(new URN("urn:adhocquery-id"));
		o.setLid(new URN("urn:adhocquery-lid"));

		InternationalString name = InternationalStringFactory.create();
		o.setName(name);

		o.setObjectType(new URI("http://adhocquery-objectType"));

		Set<Slot> slots = new HashSet<Slot>();
		Slot slot1 = SlotFactory.create();
		Slot slot2 = SlotFactory.create();
		slot2.setName(new LongName("slot2-name"));
		slots.add(slot1);
		slots.add(slot2);
		o.setSlots(slots);

		o.setStatus(new URI("http://adhocquery-status"));

		VersionInfo versionInfo = VersionInfoFactory.create();
		o.setVersionInfo(versionInfo);

		return o;
	}

    public static AdhocQuery create2() {
        AdhocQuery adhocQuery = new AdhocQuery();
        adhocQuery.setId(new URN("storedQueryId"));
        adhocQuery.setHome(new URI("storedQueryHome"));

        Slot slot = new Slot();
        slot.setSlotType(new LongName("http://www.playboy.com.br"));
        slot.setName(new LongName("playboyBrasilQueryParameter"));
        ValueList valueList = new ValueList();
        valueList.add(new LongName("onetwothree"));
        slot.setValueList(valueList);

        Set<Slot> slots = new HashSet<Slot>();
        slots.add(slot);
        adhocQuery.setSlots(slots);

        return adhocQuery;

	}
}
