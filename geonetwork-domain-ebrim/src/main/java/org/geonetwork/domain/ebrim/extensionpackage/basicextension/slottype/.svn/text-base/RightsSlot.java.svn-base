package org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Information about rights held in and over the resource.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 51 � Slot: Rights Name http://purl.org/dc/elements/1.1/rights Definition Information about
 * rights held in and over the resource.. Source DCMI Metadata terms
 * <http://dublincore.org/documents/dcmi-terms/#rights> Slot type none Parent object type
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject
 * 
 * @author heikki
 * 
 */
@Indexed
public class RightsSlot extends Slot {
	public RightsSlot() {
		slotType = new LongName("");
	}
}
