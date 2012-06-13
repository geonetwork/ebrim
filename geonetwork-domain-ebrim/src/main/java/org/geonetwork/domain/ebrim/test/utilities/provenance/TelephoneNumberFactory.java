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

package org.geonetwork.domain.ebrim.test.utilities.provenance;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String16;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String32;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String8;
import org.geonetwork.domain.ebrim.informationmodel.provenance.TelephoneNumber;

public class TelephoneNumberFactory {

	public synchronized static TelephoneNumber create() {
		TelephoneNumber o = new TelephoneNumber();

		o.setAreaCode(new String8("areacode"));
		o.setCountryCode(new String8("country"));
		o.setExtension(new String8("extensio"));
		o.setNumber(new String16("number"));
		o.setPhoneType(new String32("phonetype"));

		return o;
	}
}
