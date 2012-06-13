package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.association;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;

/**
 * Provides the identifier of the code space to which an IdentifiedItem pertains.
 * 
 * Source object type:
 * urn:x-ogc:specification:csw-ebrim-cim:ObjectType:IdentifiedItem
 * 
 * Target object type:
 * urn:x-ogc:specification:csw-ebrim-cim:ObjectType:IdentifiedItem
 * 
 * @author heikki doeleman
 *
 */
public class CodeSpace extends Association {

	public CodeSpace() {
		super();
		this.associationType = new URI("urn:x-ogc:specification:csw-ebrim-cim:AssociationType:CodeSpace");
	}
}
