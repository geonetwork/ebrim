package org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * A language of the resource.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 50 � Slot: Language Name http://purl.org/dc/elements/1.1/language Definition A language of
 * the resource. Source DCMI Metadata terms <http://dublincore.org/documents/dcmi-terms/#language>
 * Slot type urn:ogc:def:dataType:RFC-4646:Language Parent object type
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject
 * 
 * @author heikki
 * 
 */
@Indexed
public class LanguageSlot extends Slot {
	public LanguageSlot() {
		slotType = new LongName("urn:ogc:def:dataType:RFC-4646:Language");
	}
}
