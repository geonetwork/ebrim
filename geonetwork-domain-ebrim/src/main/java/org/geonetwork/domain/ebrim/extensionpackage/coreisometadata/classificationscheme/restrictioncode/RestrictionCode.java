package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictioncode;

import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictioncode.classificationnode.Copyright;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictioncode.classificationnode.IntellectualPropertyRights;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictioncode.classificationnode.License;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictioncode.classificationnode.OtherRestrictions;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictioncode.classificationnode.Patent;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictioncode.classificationnode.PatentPending;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictioncode.classificationnode.Restricted;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.restrictioncode.classificationnode.Trademark;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;

public class RestrictionCode extends ClassificationScheme {
	public RestrictionCode() {
		super();
		/*
		 * TODO
		this.id = new URN("urn:ogc:def:ebRIM-ClassificationScheme:CitedResponsibleParty");
		this.objectType = new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ClassificationScheme");
		this.setNodeType(new URI("urn:oasis:names:tc:ebxml-regrep:NodeType:UniqueCode"));
		this.setIsInternal(true);
		 
		 */
		
		this.classificationNodes.add(new Copyright());
		this.classificationNodes.add(new IntellectualPropertyRights());
		this.classificationNodes.add(new License());
		this.classificationNodes.add(new OtherRestrictions());
		this.classificationNodes.add(new Patent());
		this.classificationNodes.add(new PatentPending());
		this.classificationNodes.add(new Restricted());
		this.classificationNodes.add(new Trademark());
		
	}
}
