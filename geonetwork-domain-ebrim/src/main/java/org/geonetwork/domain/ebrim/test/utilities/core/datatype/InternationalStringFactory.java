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

package org.geonetwork.domain.ebrim.test.utilities.core.datatype;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.Language;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;

public class InternationalStringFactory {

	public synchronized static InternationalString create() {
		InternationalString o = new InternationalString();

		Set<LocalizedString> localizedStrings = new HashSet<LocalizedString>();
		LocalizedString localizedString1 = new LocalizedString();
		localizedString1.setCharset("UTF-8");
		Language lang1 = new Language();
		lang1.setValue("fr-FR");
		localizedString1.setLang(lang1);
		localizedString1.setValue("value-1");
		LocalizedString localizedString2 = new LocalizedString();
		localizedString2.setCharset("UTF-8");
		Language lang2 = new Language();
		lang2.setValue("en-GB");
		localizedString2.setLang(lang2);
		localizedString2.setValue("value-2");
		localizedStrings.add(localizedString1);
		localizedStrings.add(localizedString2);
		o.setLocalizedStrings(localizedStrings);

		return o;
	}
}
