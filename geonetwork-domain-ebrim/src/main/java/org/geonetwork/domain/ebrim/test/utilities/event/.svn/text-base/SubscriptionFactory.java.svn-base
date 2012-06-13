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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.VersionInfo;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.event.NotifyAction;
import org.geonetwork.domain.ebrim.informationmodel.event.Subscription;
import org.geonetwork.domain.ebrim.informationmodel.xsd.Duration;
import org.geonetwork.domain.ebrim.test.utilities.core.SlotFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.VersionInfoFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.datatype.InternationalStringFactory;

public class SubscriptionFactory {

	public synchronized static Subscription create() {
		Subscription o = new Subscription();

		Set<NotifyAction> actions = new HashSet<NotifyAction>();
		NotifyAction action1 = NotifyActionFactory.create();
		actions.add(action1);
		o.setActions(actions);

		Date endTime = new Date();
		endTime.setTime(0);
		o.setEndTime(endTime);

		Duration notificationInterval = new Duration();
		notificationInterval.setDays(1);
		notificationInterval.setHours(2);
		notificationInterval.setMinutes(3);
		notificationInterval.setMonths(4);
		notificationInterval.setNegative(true);
		notificationInterval.setSeconds(5d);
		notificationInterval.setYears(6);
		o.setNotificationInterval(notificationInterval);

		o.setSelector(new URI("subscription-selector"));

		Date startTime = new Date();
		startTime.setTime(0);
		o.setStartTime(startTime);

		InternationalString description = InternationalStringFactory.create();
		o.setDescription(description);

		o.setHome(new URI("http://subscription-home"));
		o.setId(new URN("urn:subscription-id"));
		o.setLid(new URN("urn:subscription-lid"));

		InternationalString name = InternationalStringFactory.create();
		o.setName(name);

		o.setObjectType(new URI("http://subscription-objectType"));

		Set<Slot> slots = new HashSet<Slot>();
		Slot slot1 = SlotFactory.create();
		Slot slot2 = SlotFactory.create();
		slot2.setName(new LongName("slot2-name"));
		slots.add(slot1);
		slots.add(slot2);
		o.setSlots(slots);

		o.setStatus(new URI("http://subscription-status"));

		VersionInfo versionInfo = VersionInfoFactory.create();
		o.setVersionInfo(versionInfo);

		return o;
	}
}
