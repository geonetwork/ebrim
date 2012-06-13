package org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * An entity primarily responsible for making the resource.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 47 � Slot: Creator Name http://purl.org/dc/elements/1.1/creator Definition An entity
 * primarily responsible for making the resource. Source DCMI Metadata terms
 * <http://dublincore.org/documents/dcmi-terms/#creator> Slot type
 * urn:oasis:names:tc:ebxml-regrep:DataType:String Parent object type
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject
 * 
 * @author heikki
 * 
 */
@Indexed
public class CreatorSlot extends Slot {
	public CreatorSlot() {
		slotType = new LongName("urn:oasis:names:tc:ebxml-regrep:DataType:String");
	}
}
