package org.geonetwork.domain.ebrim.extensionpackage.basicextension.slottype;

import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * An entity responsible for making contributions to the resource.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 44 � Slot: Contributor Name http://purl.org/dc/elements/1.1/contributor Definition An
 * entity responsible for making contributions to the resource. Source DCMI Metadata terms
 * <http://dublincore.org/documents/dcmi-terms/#contributor> Slot type
 * urn:oasis:names:tc:ebxml-regrep:DataType:String Parent object type
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject
 * 
 * @author heikki
 * 
 */
@Indexed
public class ContributorSlot extends Slot {
	public ContributorSlot() {
		slotType = new LongName("urn:oasis:names:tc:ebxml-regrep:DataType:String");
	}
}
