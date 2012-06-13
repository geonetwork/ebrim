package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * An extrinsic object that describes the service interfaces and the semantic content of requests.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.3 ServiceModel
 * 
 * A ServiceModel item denotes an extrinsic object that describes the service interfaces and the
 * semantic content of requests. No specific representation is prescribed, but a WSDL resource
 * (containing interface and types elements) is commonly used for this purpose. The properties of
 * the classification node are summarized in the table below. Table 7 � Object type: ServiceModel
 * Property Value Identifier urn:ogc:def:ebRIM-ObjectType:OGC:ServiceModel Name ServiceModel
 * Description Describes how the service works, including its essential computational
 * characteristics and behaviours (e.g., a WSDL interface description). Parent
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExtrinsicObject Code ServiceModel An
 * interface or a process specification corresponds to an extrinsic object of this type. It shall be
 * related to a Service item using the "DescribedBy" association (see 8.2.4). NOTE See
 * <http://www.daml.org/services/owl-s/1.1/overview/>.
 * 
 * @author heikki
 * 
 */
@Indexed
public class ServiceModel extends ExtrinsicObject {
	public ServiceModel() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:ServiceModel");
	}
}
