package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.spatialrepresentationtype.classificationnode;

import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;

public class Vector extends ClassificationNode {

	public Vector() {
		super();
		this.objectType = new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ClassificationNode");
		this.setParent(new URI("urn:ogc:def:ebRIM-ClassificationScheme:SpatialRepresentationType"));
		this.setCode(new LongName("vector"));
		this.setId(new URN("urn:ogc:def:ebRIM-ClassificationNode:SpatialRepresentationType:vector"));
	}
}
