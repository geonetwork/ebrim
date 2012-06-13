package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictiontype;

import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictiontype.classificationnode.Access;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictiontype.classificationnode.Use;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;

public class RestrictionType extends ClassificationScheme {
	public RestrictionType() {
		super();
		/*
		 * TODO
		this.id = new URN("urn:ogc:def:ebRIM-ClassificationScheme:CitedResponsibleParty");
		this.objectType = new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ClassificationScheme");
		this.setNodeType(new URI("urn:oasis:names:tc:ebxml-regrep:NodeType:UniqueCode"));
		this.setIsInternal(true);
		 
		 */
		
		this.classificationNodes.add(new Access());
		this.classificationNodes.add(new Use());
		
	}
}
