package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Information about the rights held in and over a resource.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.11 Rights A Rights item represents information about the rights held in and over a resource.
 * Typically, a Rights object embodies a rights management statement that stipulates conditions of
 * use or distribution. No specific means of expressing or enforcing rights are prescribed, but the
 * use of open standards is encouraged.
 * 
 * EXAMPLE An ODRL or MPEG-21/REL statement.
 * 
 * Table 15 � Object type: Rights Property Value Identifier urn:ogc:def:ebRIM-ObjectType:OGC:Rights
 * Name Rights Description Information about the rights held in and over a resource. Typically, a
 * Rights object embodies a rights management statement that stipulates conditions of use or
 * distribution. Parent urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExtrinsicObject
 * Code Rights NOTE See <http://odrl.net/>.
 * 
 * 
 * @author heikki
 * 
 */
@Indexed
public class Rights extends ExtrinsicObject {
	public Rights() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:Rights");
	}
}
