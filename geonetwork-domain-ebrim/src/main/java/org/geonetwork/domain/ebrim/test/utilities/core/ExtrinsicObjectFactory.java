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

import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.Language;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.test.utilities.classification.ClassificationFactory;

public class ExtrinsicObjectFactory {

	public synchronized static ExtrinsicObject create() {

		ExtrinsicObject o = new ExtrinsicObject();

		Set<Classification> classifications = new HashSet<Classification>();
		Classification classification1 = ClassificationFactory.create();
		Classification classification2 = ClassificationFactory.create();
		classifications.add(classification1);
		classifications.add(classification2);
		o.setClassifications(classifications);

		InternationalString description = new InternationalString();
		Set<LocalizedString> localizedStrings = new HashSet<LocalizedString>();
		LocalizedString localizedString1 = new LocalizedString();
		localizedString1.setCharset("UTF-8");
		Language language1 = new Language();
		language1.setValue("fr-FR");
		localizedString1.setLang(language1);
		localizedString1.setValue("localizedString1-value");
		LocalizedString localizedString2 = new LocalizedString();
		localizedString2.setCharset("UTF-8");
		Language language2 = new Language();
		language2.setValue("en-US");
		localizedString2.setLang(language2);
		localizedString2.setValue("localizedString2-value");

		localizedStrings.add(localizedString1);
		localizedStrings.add(localizedString2);

		description.setLocalizedStrings(localizedStrings);
		o.setDescription(description);

		o.setHome(new URI("http://extrinsicobject-home"));
		o.setId(new URN("urn:extrinsicobject-id"));
		o.setIsOpaque(Boolean.TRUE);
		o.setLid(new URN("urn:extrinsicobject-lid"));
		o.setMimeType(new LongName("extrinsicobject-mimetype"));

		InternationalString name = new InternationalString();
		Set<LocalizedString> names = new HashSet<LocalizedString>();
		LocalizedString name1 = new LocalizedString();
		name1.setCharset("UTF-8");
		name1.setLang(new Language("en-GB"));
		name1.setValue("extrinsicobject-name1");
		LocalizedString name2 = new LocalizedString();
		name2.setCharset("UTF-8");
		name2.setLang(new Language("nl-NL"));
		name2.setValue("extrinsicobject-name2");
		names.add(name1);
		names.add(name2);
		name.setLocalizedStrings(names);
		o.setName(name);

		o.setObjectType(new URI("http://extrinsic-object-objecttype"));

		Set<Slot> slots = new HashSet<Slot>();
		Slot slot1 = SlotFactory.create();
		Slot slot2 = SlotFactory.create();
		slots.add(slot1);
		slots.add(slot2);
		o.setSlots(slots);

		o.setStatus(new URI("http://extrinsic-object-status"));
		o.setVersionInfo(VersionInfoFactory.create());
		o.setContentVersionInfo(VersionInfoFactory.create());

		return o;

	}
}
