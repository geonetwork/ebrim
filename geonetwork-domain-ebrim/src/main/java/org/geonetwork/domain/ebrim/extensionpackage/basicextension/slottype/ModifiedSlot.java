package org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Date on which the resource was changed.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 49 � Slot: Modified Name http://purl.org/dc/terms/modified Definition Date on which the
 * resource was changed. Source DCMI Metadata terms
 * <http://dublincore.org/documents/dcmi-terms/#modified> Slot type
 * urn:oasis:names:tc:ebxml-regrep:DataType:DateTime Parent object type
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject
 * 
 * @author heikki
 * 
 */
@Indexed
public class ModifiedSlot extends Slot {
	public ModifiedSlot() {
		slotType = new LongName("urn:oasis:names:tc:ebxml-regrep:DataType:DateTime");
	}
}
