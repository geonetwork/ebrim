package org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * The resource from which the described resource is derived.
 * 
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 52 � Slot: Source Name http://purl.org/dc/elements/1.1/source Definition The resource from
 * which the described resource is derived. Source DCMI Metadata terms
 * <http://dublincore.org/documents/dcmi-terms/#source> Slot type
 * urn:oasis:names:tc:ebxml-regrep:DataType:URI Parent object type
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject
 * 
 * @author heikki
 * 
 */
@Indexed
public class SourceSlot extends Slot {
	public SourceSlot() {
		slotType = new LongName("urn:oasis:names:tc:ebxml-regrep:DataType:URI");
	}
}
