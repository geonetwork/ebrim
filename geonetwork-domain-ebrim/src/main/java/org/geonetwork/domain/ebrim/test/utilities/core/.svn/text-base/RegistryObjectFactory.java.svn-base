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

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.VersionInfo;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.Language;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.String16;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;
import org.geonetwork.domain.ebrim.test.utilities.association.AssociationFactory;

public class RegistryObjectFactory {

	public synchronized static RegistryObject create() {
		RegistryObject ro = new RegistryObject();

		URI home = new URI();
		home.setValue("http://home");
		ro.setHome(home);

		URN id = new URN();
		id.setValue("http://id");
		ro.setId(id);

		Slot slot = new Slot();
		slot.setName(new LongName("slot-1"));
		slot.setSlotType(new LongName("slottype-1"));
		LongName value = new LongName("value-for-slot-1");
		LongName value2 = new LongName("another-value-for-slot-1");
		ValueList valueList = new ValueList();
		valueList.add(value);
		valueList.add(value2);
		slot.setValueList(valueList);

		Slot slot2 = new Slot();
		slot2.setName(new LongName("slot-2"));
		slot2.setSlotType(new LongName("slottype-2"));
		LongName value3 = new LongName("value-for-slot-2");
		LongName value4 = new LongName("another-value-for-slot-2");
		ValueList valueList2 = new ValueList();
		valueList2.add(value3);
		valueList2.add(value4);
		slot2.setValueList(valueList2);

		Set<Slot> slots = new HashSet<Slot>();
		slots.add(slot);
		slots.add(slot2);
		ro.setSlots(slots);

		Set<Classification> classifications = new HashSet<Classification>();
		Classification classification = new Classification();
		classification.setClassificationNode(new URI("http://classificationNode"));
		classification.setClassificationScheme(new URI("http://classificationScheme"));
		classification.setClassifiedObject(new URI("http://classifiedObject"));
		classification.setNodeRepresentation(new LongName("nodeRepresentation"));

		InternationalString classdescription = new InternationalString();
		Set<LocalizedString> classlocalizedStrings = new HashSet<LocalizedString>();
		LocalizedString classlocalizedString = new LocalizedString();
		classlocalizedString.setValue("classification-hoi");
		classlocalizedString.setCharset("UTF-8");
		Language classlang = new Language();
		classlang.setValue("en-US");
		classlocalizedString.setLang(classlang);
		classlocalizedStrings.add(classlocalizedString);
		classdescription.setLocalizedStrings(classlocalizedStrings);
		classification.setDescription(classdescription);

		classification.setLid(new URN("http://class-lid"));
		classification.setId(new URN("http://class-id"));
		classification.setHome(new URI("http://classification-home"));
		classification.setObjectType(new URI("http://classification-objecttype"));
		classification.setStatus(new URI("http://classification-status"));
		VersionInfo version = new VersionInfo();
		version.setVersionName(new String16("classification.1.0"));
		version.setComment(new LongName("Comment on classification version 1.0"));
		classification.setVersionInfo(version);

		Classification classification2 = new Classification();
		classification2.setClassificationNode(new URI("http://classificationNode2"));
		classification2.setClassificationScheme(new URI("http://classificationScheme2"));
		classification2.setClassifiedObject(new URI("http://classifiedObject2"));
		classification2.setNodeRepresentation(new LongName("nodeRepresentation2"));

		InternationalString classdescription2 = new InternationalString();
		Set<LocalizedString> classlocalizedStrings2 = new HashSet<LocalizedString>();
		LocalizedString classlocalizedString2 = new LocalizedString();
		classlocalizedString2.setValue("classification-hoi-2");
		classlocalizedString2.setCharset("UTF-8");
		Language classlang2 = new Language();
		classlang2.setValue("fr-FR");
		classlocalizedString2.setLang(classlang2);
		classlocalizedStrings2.add(classlocalizedString2);
		classdescription2.setLocalizedStrings(classlocalizedStrings2);
		classification2.setDescription(classdescription2);

		classification2.setLid(new URN("http://class2-lid"));
		classification2.setId(new URN("http://class2-id"));
		classification2.setHome(new URI("http://classification2-home"));
		classification2.setObjectType(new URI("http://classification2-objecttype"));
		classification2.setStatus(new URI("http://classification2-status"));
		VersionInfo version2 = new VersionInfo();
		version2.setVersionName(new String16("classification.2.0"));
		version2.setComment(new LongName("Comment on classification version 2.0"));
		classification2.setVersionInfo(version2);

		classifications.add(classification);
		classifications.add(classification2);
		ro.setClassifications(classifications);

		InternationalString description = new InternationalString();
		Set<LocalizedString> localizedStrings = new HashSet<LocalizedString>();
		LocalizedString localizedString = new LocalizedString();
		localizedString.setValue("description");
		localizedString.setCharset("UTF-8");
		Language lang = new Language();
		lang.setValue("en-US");
		localizedString.setLang(lang);
		localizedStrings.add(localizedString);
		description.setLocalizedStrings(localizedStrings);
		ro.setDescription(description);

		InternationalString name = new InternationalString();
		Set<LocalizedString> localizedStrings2 = new HashSet<LocalizedString>();
		LocalizedString localizedString2 = new LocalizedString();
		localizedString2.setValue("name");
		localizedString2.setCharset("UTF-8");
		Language lang2 = new Language();
		lang2.setValue("fr-FR");
		localizedString2.setLang(lang2);
		localizedStrings2.add(localizedString2);
		name.setLocalizedStrings(localizedStrings2);
		ro.setName(name);

		VersionInfo versionInfo = new VersionInfo();
		versionInfo.setVersionName(new String16("1.1"));
		versionInfo.setComment(new LongName("comment"));
		ro.setVersionInfo(versionInfo);

		URN lid = new URN();
		lid.setValue("http://lid");
		ro.setLid(lid);

		URI objectType = new URI();
		objectType.setValue("http://objectType");
		ro.setObjectType(objectType);

		URI status = new URI();
		status.setValue("http://status");
		ro.setStatus(status);

		
		RegistryObject registryObjectTarget = new RegistryObject();
		URN targetObjectId = new URN("harari" );
		registryObjectTarget.setId(targetObjectId);
		
		Association a = new Association();
		a.setAssociationType(new URI("http://associationType"));
        a.setHome(new URI("http://association-home"));
		a.setId(new URN("urn:association-id"));
		a.setLid(new URN("urn:association-lid"));
        //a.setTargetRegistryObject(registryObjectTarget);

        URI targetObject = new URI(registryObjectTarget.getId().getValue());
		a.setTargetObject(targetObject);

		URI sourceUri = new URI(ro.getId().getValue());
		a.setSourceObject(sourceUri);
		Set<Association> associationsSet = new HashSet<Association>();
		associationsSet.add(a);
		ro.setAssociationsSet(associationsSet);

		return ro;
	}
}
