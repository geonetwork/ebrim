package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty.classificationnode;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.Language;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;

/**
 * 
 * @author heikki doeleman
 *
 */
public class PointOfContact extends ClassificationNode {

	public PointOfContact() {
		super();
		this.objectType = new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ClassificationNode");
		this.setParent(new URI("urn:ogc:def:ebRIM-ClassificationScheme:CitedResponsibleParty"));
		this.setCode(new LongName("pointOfContact"));
		this.setId(new URN("urn:ogc:def:ebRIM-ClassificationNode:CitedResponsibleParty:pointOfContact"));

		LocalizedString localizedName = new LocalizedString();
		localizedName.setValue("pointOfContact");
		Language english = new Language("en");
		localizedName.setLang(english);
		Set<LocalizedString> localizedNames = new HashSet<LocalizedString>();
		localizedNames.add(localizedName);
		InternationalString name = new InternationalString();
		name.setLocalizedStrings(localizedNames);
		this.name = name;
		LocalizedString localizedDescription = new LocalizedString();
		localizedDescription.setValue("party who can be contacted for acquiring knowledge about or acquisition of the resource");
		localizedDescription.setLang(english);
		Set<LocalizedString> localizedDescriptions = new HashSet<LocalizedString>();
		localizedDescriptions.add(localizedDescription);
		InternationalString description = new InternationalString();
		description.setLocalizedStrings(localizedDescriptions);
		this.description = description;		
	}
}
