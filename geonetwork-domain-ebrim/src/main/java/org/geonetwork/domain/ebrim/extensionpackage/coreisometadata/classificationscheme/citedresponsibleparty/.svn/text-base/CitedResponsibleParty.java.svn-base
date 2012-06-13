package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty.classificationnode.Author;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty.classificationnode.Originator;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty.classificationnode.PointOfContact;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty.classificationnode.Publisher;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.Language;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

@Indexed
public class CitedResponsibleParty extends ClassificationScheme {

	public CitedResponsibleParty() {
		super();
		this.id = new URN("urn:ogc:def:ebRIM-ClassificationScheme:CitedResponsibleParty");
		this.objectType = new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ClassificationScheme");
		this.setNodeType(new URI("urn:oasis:names:tc:ebxml-regrep:NodeType:UniqueCode"));
		this.setIsInternal(true);
		
		LocalizedString localizedName = new LocalizedString();
		localizedName.setValue("Cited Responsible Party");
		Language english = new Language("en");
		localizedName.setLang(english);
		Set<LocalizedString> localizedNames = new HashSet<LocalizedString>();
		localizedNames.add(localizedName);
		InternationalString name = new InternationalString();
		name.setLocalizedStrings(localizedNames);
		this.name = name;
		LocalizedString localizedDescription = new LocalizedString();
		localizedDescription.setValue("Defines a classification for CitedResponsibleParty");
		localizedDescription.setLang(english);
		Set<LocalizedString> localizedDescriptions = new HashSet<LocalizedString>();
		localizedDescriptions.add(localizedDescription);
		InternationalString description = new InternationalString();
		description.setLocalizedStrings(localizedDescriptions);
		this.description = description;
		
		this.classificationNodes.add(new Author());
		this.classificationNodes.add(new Originator());
		this.classificationNodes.add(new PointOfContact());
		this.classificationNodes.add(new Publisher());

	}
}
