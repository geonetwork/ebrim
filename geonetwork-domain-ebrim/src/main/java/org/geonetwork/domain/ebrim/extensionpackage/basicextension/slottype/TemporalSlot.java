package org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Temporal characteristics of the intellectual content of the resource.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 46 � Slot: Temporal Name http://purl.org/dc/terms/temporal Definition Temporal
 * characteristics of the intellectual content of the resource. Source DCMI Metadata terms
 * <http://dublincore.org/documents/dcmi-terms/#creator> Slot type
 * urn:oasis:names:tc:ebxml-regrep:DataType:DateTime Parent object type
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject
 * 
 * @author heikki
 * 
 */
@Indexed
public class TemporalSlot extends Slot {
	public TemporalSlot() {
		slotType = new LongName("urn:oasis:names:tc:ebxml-regrep:DataType:DateTime");
	}
}
