package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * A specialized ServiceModel object that describes the service interface(s) using the WSDL content
 * model.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.4 WSDL-Interface A WSDL-Interface item describes a specialized ServiceModel object that
 * describes the service interface(s) using the WSDL content model. The WSDL description must not
 * include any service-specific information; this represents an abstract characterization of service
 * operations�interfaces and standard protocol bindings�that are common to all implementa-tions. The
 * properties of the classification node are summarized in the table below.
 * 
 * Table 8 � Object type: WSDL-Interface Property Value Identifier
 * urn:ogc:def:ebRIM-ObjectType:OGC:ServiceModel:WSDL-Interface Name WSDL-Interface Description
 * Describes the service interface(s) and standard protocol bindings using the WSDL content model.
 * No service-specific details are provided. Parent urn:ogc:def:ebRIM-ObjectType:OGC:ServiceModel
 * Code WSDL-Interface
 * 
 * @author heikki
 * 
 */
@Indexed
public class WSDLInterface extends ServiceModel {
	public WSDLInterface() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:ServiceModel:WSDL-Interface");
	}
}
