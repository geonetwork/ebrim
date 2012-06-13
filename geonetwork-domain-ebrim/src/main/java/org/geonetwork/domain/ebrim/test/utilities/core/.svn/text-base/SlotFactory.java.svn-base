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

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;

public class SlotFactory {

	public synchronized static Slot create() {
		Slot o = new Slot();
		o.setName(new LongName("slot-name"));
		o.setSlotType(new LongName("slottype"));
		ValueList valueList = ValueListFactory.create();
		o.setValueList(valueList);
		return o;
	}
	
	public synchronized static Slot create2() {
		Slot o = new Slot();
		o.setName(new LongName("http://purl.org/dc/terms/spatial"));
		o.setSlotType(new LongName("urn:ogc:def:dataType:ISO-19107:GM_Envelope"));
		org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.ValueList valueList = ValueList2Factory.create();
		o.setBasicExtensionValueList(valueList);
		return o;
	}	
}
