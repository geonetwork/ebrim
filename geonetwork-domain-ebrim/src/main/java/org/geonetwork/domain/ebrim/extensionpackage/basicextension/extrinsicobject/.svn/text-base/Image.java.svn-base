package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * A visual representation other than text.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.10 Image An Image item is a visual representation other than text. Both still and moving
 * images fall under this category. EXAMPLE Photographs, maps, diagrams, videos, animations. Table
 * 14 � Object type: Image Property Value Identifier urn:ogc:def:ebRIM-ObjectType:OGC:Image Name
 * Image Description A visual representation other than text. Examples: Photographs, maps, diagrams,
 * videos, animations. Parent
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExtrinsicObject Code Image NOTE The
 * IANA media type registry is available at this URL:
 * <http://www.iana.org/assignments/media-types/>.
 * 
 * 
 * @author heikki
 * 
 */
@Indexed
public class Image extends DataSet {
	public Image() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:Image");
	}
}
