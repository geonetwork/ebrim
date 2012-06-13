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

package org.geonetwork.domain.ebrim.test.utilities.classification;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.VersionInfo;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.test.utilities.core.SlotFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.VersionInfoFactory;
import org.geonetwork.domain.ebrim.test.utilities.core.datatype.InternationalStringFactory;

public class ClassificationSchemeFactory {

	public synchronized static ClassificationScheme create() {

		ClassificationScheme o = new ClassificationScheme();

		o.setIsInternal(Boolean.TRUE);
		o.setNodeType(new URI("http://classificationScheme-nodeType"));

		Set<Classification> classifications = new HashSet<Classification>();
		o.setClassifications(classifications);
		InternationalString description = InternationalStringFactory.create();
		o.setDescription(description);
		o.setHome(new URI("http://home"));
		o.setId(new URN("urn:id"));
		InternationalString name = InternationalStringFactory.create();
		o.setName(name);
		o.setObjectType(new URI("http://objectType"));
		Set<Slot> slots = new HashSet<Slot>();
		Slot slot1 = SlotFactory.create();
		Slot slot2 = SlotFactory.create();
		slot2.setName(new LongName("slot2-name"));
		slots.add(slot1);
		slots.add(slot2);
		o.setSlots(slots);
		o.setStatus(new URI("http://status"));
		VersionInfo versionInfo = VersionInfoFactory.create();
		o.setVersionInfo(versionInfo);

		ClassificationNode classificationNode = new ClassificationNode();
		classificationNode.setLid(new URN("urn:oasis:names:tc:ebxml-regrep:EmailType:OfficeEmail"));
		classificationNode.setCode(new LongName("OfficeEmail"));
		classificationNode.setId(new URN("urn:oasis:names:tc:ebxml-regrep:EmailType:OfficeEmail"));
		
		ClassificationNode classificationNode2 = new ClassificationNode();
		classificationNode2.setLid(new URN("urn:oasis:names:tc:ebxml-regrep:EmailType:HomeEmail"));
		classificationNode2.setCode(new LongName("HomeEmail"));
		classificationNode2.setId(new URN("urn:oasis:names:tc:ebxml-regrep:EmailType:HomeEmail"));
		
		Set<ClassificationNode> classificationNodes = new HashSet<ClassificationNode>();
		classificationNodes.add(classificationNode);
		classificationNodes.add(classificationNode2);
		o.setClassificationNodes(classificationNodes);
		return o;

	}
}
