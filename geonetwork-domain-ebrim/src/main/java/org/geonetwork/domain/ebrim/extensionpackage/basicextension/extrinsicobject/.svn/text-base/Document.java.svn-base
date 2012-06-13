package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * A text resource consisting primarily of words for reading.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.8 Document A Document item represents a text resource consisting primarily of words for
 * reading.
 * 
 * Table 12 � Object type: Document Property Value Identifier
 * urn:ogc:def:ebRIM-ObjectType:OGC:Document Name Document Description A text resource consisting
 * primarily of words for reading. Parent
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExtrinsicObject Code Document
 * 
 * 
 * @author heikki
 * 
 */
@Indexed
public class Document extends ExtrinsicObject {

	public Document() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:Document");
	}
}
