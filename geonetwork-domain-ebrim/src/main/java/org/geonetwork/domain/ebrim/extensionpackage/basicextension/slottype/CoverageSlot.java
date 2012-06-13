package org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * The spatial or temporal topic of the resource, the spatial applicability of the resource, or the
 * jurisdiction under which the resource is relevant.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 55 � Slot: Coverage Name http://purl.org/dc/elements/1.1/coverage Definition The spatial or
 * temporal topic of the resource, the spatial applicability of the resource, or the jurisdiction
 * under which the resource is relevant. Source DCMI Metadata terms
 * <http://dublincore.org/documents/dcmi-terms/#coverage> Slot type none Parent object type
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject
 * 
 * @author heikki
 * 
 */
@Indexed
public class CoverageSlot extends Slot {
	public CoverageSlot() {
		slotType = new LongName("urn:oasis:names:tc:ebxml-regrep:DataType:String");
	}
}
