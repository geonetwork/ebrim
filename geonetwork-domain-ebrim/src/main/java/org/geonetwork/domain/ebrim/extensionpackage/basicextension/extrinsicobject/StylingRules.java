package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * A set of rules for portraying or formatting an information resource for display on some device;
 * it is typically expressed using a formal style language.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.7 StylingRules A StylingRules item is a representation of a set of rules for portraying or
 * formatting an information resource for display on some device; it is typically expressed using a
 * formal style language. No style languages are prescribed, but standards such as XSLT and CSS are
 * widely used. The mimeType attribute value will often serve to identify the style language (e.g.
 * application/xslt+xml, text/css).
 * 
 * Table 11 � Object type: StylingRules Property Value Identifier
 * urn:ogc:def:ebRIM-ObjectType:OGC:StylingRules Name StylingRules Description Defines a set of
 * rules for portraying or formatting some information resource for display, typically expressed
 * using a style language (e.g., XSLT, CSS). Parent
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExtrinsicObject Code StylingRules
 * 
 * 
 * @author heikki
 * 
 */
@Indexed
public class StylingRules extends ExtrinsicObject {
	public StylingRules() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:StylingRules");
	}
}
