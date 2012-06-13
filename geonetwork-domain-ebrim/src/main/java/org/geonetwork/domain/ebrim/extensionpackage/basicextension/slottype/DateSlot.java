package org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * A point or period of time associated with an event in the lifecycle of the resource.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 48 � Slot: Date Name http://purl.org/dc/elements/1.1/date Definition A point or period of
 * time associated with an event in the lifecycle of the resource. Source DCMI Metadata terms
 * <http://dublincore.org/documents/dcmi-terms/#date> Slot type
 * urn:oasis:names:tc:ebxml-regrep:DataType:Date Parent object type
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject
 * 
 * @author heikki
 * 
 */
@Indexed
public class DateSlot extends Slot {
	public DateSlot() {
		slotType = new LongName("urn:oasis:names:tc:ebxml-regrep:DataType:Date");
	}
}
