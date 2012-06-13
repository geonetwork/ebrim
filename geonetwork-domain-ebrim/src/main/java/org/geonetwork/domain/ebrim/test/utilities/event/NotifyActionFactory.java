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

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.event.NotifyAction;

public class NotifyActionFactory {

	public synchronized static NotifyAction create() {
		NotifyAction o = new NotifyAction();

		o.setEndPoint(new URI("http://notifyAction-endPoint"));
		o.setNotificationOption(new URI("http://notifyAction-notificationOption"));

		return o;
	}
}
