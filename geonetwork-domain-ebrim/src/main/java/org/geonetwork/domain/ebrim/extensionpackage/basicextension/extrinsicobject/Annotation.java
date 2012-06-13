package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * A commentary intended to interpret, explain, or clarify some other resource or part thereof.
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.9 Annotation An Annotation item represents commentary intended to interpret, explain, or
 * clarify some other resource or part thereof. Annotations are not restricted to textual resources;
 * graphic, audio, and video content may also be employed to provide such metadata.
 * 
 * Table 13 � Object type: Annotation Property Value Identifier
 * urn:ogc:def:ebRIM-ObjectType:OGC:Annotation Name Annotation Description Commentary intended to
 * interpret, explain, or clarify some other resource or part thereof. Parent
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExtrinsicObject Code Annotation
 * 
 * 
 * @author heikki
 * 
 */
@Indexed
public class Annotation extends ExtrinsicObject {

	public Annotation() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:Annotation");
	}

}
