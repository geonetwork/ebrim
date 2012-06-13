package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Describes what the service does: its features and capabilities (e.g., a capabilities document).
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * Table 5 � Object type: ServiceProfile Property Value Identifier
 * urn:ogc:def:ebRIM-ObjectType:OGC:ServiceProfile Name ServiceProfile Description Describes what
 * the service does: its features and capabilities (e.g., a capabilities document). Parent
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExtrinsicObject Code ServiceProfile An
 * OGC capabilities document corresponds to an extrinsic object of this type. It shall be related to
 * a Service item using the "Presents" association (see 8.2.2). NOTE See
 * <http://www.daml.org/services/owl-s/1.1/overview/>.
 * 
 * @author heikki
 * 
 */
@Indexed
public class ServiceProfile extends ExtrinsicObject {
	public ServiceProfile() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:ServiceProfile");
	}
}
