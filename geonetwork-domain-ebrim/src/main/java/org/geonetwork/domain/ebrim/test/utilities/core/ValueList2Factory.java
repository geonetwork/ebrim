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

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.AnyValue;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.Envelope;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.LowerCorner;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.UpperCorner;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.ValueList;

public class ValueList2Factory {

	public synchronized static ValueList create() {
		ValueList o = new ValueList();
		
		List<AnyValue> values = new ArrayList<AnyValue>();
		
		AnyValue anyValue = new AnyValue();
		
		Envelope value = new Envelope();
		LowerCorner lowerCorner = new LowerCorner(" 3.0");
		value.setLowerCorner(lowerCorner);
		UpperCorner upperCorner = new UpperCorner(" 7.3");
		value.setUpperCorner(upperCorner);
		
		anyValue.setValue(value);
		
		values.add(anyValue);
		
		o.setValues(values);
		return o;
	}
}
