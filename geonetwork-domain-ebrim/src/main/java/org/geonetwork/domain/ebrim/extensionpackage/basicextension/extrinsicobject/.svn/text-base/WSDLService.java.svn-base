package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * A specialized ServiceGrounding object that describes the service endpoints using the WSDL content
 * model.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.5 WSDL-Service A WSDL-Service item describes a specialized ServiceGrounding object that
 * describes the service endpoints using the WSDL content model. The WSDL description shall include
 * only service-specific details that permit a user agent to access the service. The properties of
 * the classification node are summarized in the table below.
 * 
 * Table 9 � Object type: WSDL-Service Property Value Identifier
 * urn:ogc:def:ebRIM-ObjectType:OGC:ServiceGrounding:WSDL-Service Name WSDL-Service Description
 * Describes the service endpoints and alternative protocol bindings using the WSDL content model.
 * No abstract interface details are provided. Parent
 * urn:ogc:def:ebRIM-ObjectType:OGC:ServiceGrounding Code WSDL-Service
 * 
 * 
 * @author heikki
 * 
 */
@Indexed
public class WSDLService extends ServiceGrounding {
	public WSDLService() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:ServiceGrounding:WSDL-Service");
	}
}
