package org.geonetwork.domain.ebrim.extensionpackage.basicextension.association;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Associates a Service with a ServiceGrounding resource that describes how to access the service
 * using some communication protocol.
 * 
 * 
 * 8.2.3 Supports The "Supports" association relates a Service offer with a ServiceGrounding
 * resource (see 8.1.2) that describes how to access the service using some communication protocol;
 * this association type derives from the top level of the OWL-S service ontology [OWL-S]. For an
 * association of this type, the source and target objects shall be of the types indicated in Figure
 * 5. i.e. Service and ServiceGrounding
 * 
 * Table 18 � Association type: Supports Property Value Identifier
 * urn:ogc:def:ebRIM-AssociationType:OGC:Supports Name Supports Description Associates a Service
 * with a ServiceGrounding resource that describes how to access the service using some
 * communication protocol. Parent
 * urn:oasis:names:tc:ebxml-regrep:classificationScheme:AssociationType Code Supports NOTE See
 * <http://www.daml.org/services/owl-s/1.1/overview/>.
 * 
 * @author heikki
 * 
 */
@Indexed
public class Supports extends Association {

	public Supports() {
		super();
		associationType = new URI();
		associationType.setValue("urn:ogc:def:ebRIM-AssociationType:OGC:Supports");
	}
}
