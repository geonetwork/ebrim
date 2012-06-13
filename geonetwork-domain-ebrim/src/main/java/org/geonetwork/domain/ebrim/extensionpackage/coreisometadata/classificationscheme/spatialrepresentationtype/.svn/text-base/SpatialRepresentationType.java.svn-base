package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.spatialrepresentationtype;

import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.spatialrepresentationtype.classificationnode.Grid;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.spatialrepresentationtype.classificationnode.StereoModel;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.spatialrepresentationtype.classificationnode.TextTable;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.spatialrepresentationtype.classificationnode.Tin;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.spatialrepresentationtype.classificationnode.Vector;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.spatialrepresentationtype.classificationnode.Video;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;

public class SpatialRepresentationType extends ClassificationScheme {
	public SpatialRepresentationType() {
		super();

		this.id = new URN("urn:x-ogc:specification:csw-ebrim:ClassificationScheme:ISO-19115:SpatialRepresentationType");
		this.objectType = new URI("urn:x-ogc:specification:csw-ebrim:ClassificationScheme");
		this.setNodeType(new URI("urn:oasis:names:tc:ebxml-regrep:NodeType:UniqueCode"));
		this.setIsInternal(true);
		 
		 
		
		this.classificationNodes.add(new Grid());
		this.classificationNodes.add(new StereoModel());
		this.classificationNodes.add(new TextTable());
		this.classificationNodes.add(new Tin());
		this.classificationNodes.add(new Vector());
		this.classificationNodes.add(new Video());
		
	}
}
