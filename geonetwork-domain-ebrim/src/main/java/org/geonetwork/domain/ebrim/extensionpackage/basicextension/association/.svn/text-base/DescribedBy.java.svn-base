package org.geonetwork.domain.ebrim.extensionpackage.basicextension.association;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Associates a Service with a ServiceModel resource that describes how the service works (i.e., its
 * interfaces or processing model).
 * 
 * 
 * 8.2.4 DescribedBy The "DescribedBy" association relates a Service offer with a ServiceModel
 * resource (see 8.1.3) that describes how the service works�a specification of its interfaces or
 * processing model; this association type derives from the top level of the OWL-S service ontology
 * [OWL-S]. For an association of this type, the source and target objects shall be of the types
 * indicated in Figure 6. i.e. Service and ServiceModel, resp.
 * 
 * Table 19 � Association type: DescribedBy Property Value Identifier urn:ogc:def:
 * ebRIM-AssociationType:OGC:DescribedBy Name DescribedBy Description Associates a Service with a
 * ServiceModel resource that describes how the service works (i.e., its interfaces or processing
 * model). Parent urn:oasis:names:tc:ebxml-regrep:classificationScheme:AssociationType Code
 * DescribedBy NOTE See <http://www.daml.org/services/owl-s/1.1/overview/>.
 * 
 * 
 * @author heikki
 * 
 */
@Indexed
public class DescribedBy extends Association {

	public DescribedBy() {
		super();
		associationType = new URI();
		associationType.setValue("urn:ogc:def:ebRIM-AssociationType:OGC:DescribedBy");
	}
}
