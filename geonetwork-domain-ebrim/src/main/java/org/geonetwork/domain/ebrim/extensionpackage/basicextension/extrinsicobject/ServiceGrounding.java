package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Denotes an extrinsic object that describes how an agent may access a service using specific
 * communication protocols and network endpoints.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.2 ServiceGrounding
 * 
 * A ServiceGrounding item denotes an extrinsic object that describes how an agent may access a
 * service using specific communication protocols and network endpoints. Alternative representations
 * of such information�such as WSDL and OWL-S documents�are permitted. The properties of the
 * classification node are summarized in the table below.
 * 
 * Table 6 � Object type: ServiceGrounding
 * 
 * Property Value Identifier urn:ogc:def:ebRIM-ObjectType:OGC:ServiceGrounding Name ServiceGrounding
 * Description Describes how to access the service: the communications protocols and network
 * endpoints (e.g., a WSDL service description). Parent
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExtrinsicObject Code ServiceGrounding A
 * service-specific WSDL document (containing service and binding elements) corresponds to an
 * extrinsic object of this type. It shall be related to a Service item using the "Supports"
 * association (see 8.2.3). NOTE See <http://www.daml.org/services/owl-s/1.1/overview/>.
 * 
 * @author heikki
 * 
 */
@Indexed
public class ServiceGrounding extends ExtrinsicObject {
	public ServiceGrounding() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:ServiceGrounding");
	}
}
