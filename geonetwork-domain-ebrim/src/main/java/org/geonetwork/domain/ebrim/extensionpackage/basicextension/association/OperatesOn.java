package org.geonetwork.domain.ebrim.extensionpackage.basicextension.association;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Associates a Service with a Dataset.
 * 
 * 
 * 8.2.1 OperatesOn The "OperatesOn" association relates a Service offer with a description of the
 * data that the service operates on as input or output (see ISO 19119, Table C.1). For an
 * association of this type, the source and target objects shall be of the types indicated in Figure
 * 3. i.e. Service and DataSet, resp.
 * 
 * Table 16 � Association type: OperatesOn Property Value Identifier
 * urn:ogc:def:ebRIM-AssociationType:OGC:OperatesOn Name OperatesOn Description Associates a Service
 * with a Dataset. Parent urn:oasis:names:tc:ebxml-regrep:classificationScheme:AssociationType Code
 * OperatesOn
 * 
 * @author heikki
 * 
 */
@Indexed
public class OperatesOn extends Association {

	public OperatesOn() {
		super();
		associationType = new URI();
		associationType.setValue("urn:ogc:def:ebRIM-AssociationType:OGC:OperatesOn");
	}
}
