package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.association;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;

/**
 * Associates Resource Metadata with a set of IdentifiedItem corresponding to the description of reference 
 * systems.
 * 
 * Source object type:
 * urn:x-ogc:specification:csw-ebrim-cim:ObjectType:ResourceMetadata
 * 
 * Target object type:
 * urn:x-ogc:specification:csw-ebrim-cim:ObjectType:IdentifiedItem
 * 
 * @author heikki doeleman
 *
 */
public class ResourceReferenceSystem extends Association {

	public ResourceReferenceSystem() {
		super();
		this.associationType = new URI("urn:x-ogc:specification:csw-ebrim-cim:AssociationType:ResourceReferenceSystem");
	}
}
