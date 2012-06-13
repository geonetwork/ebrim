package org.geonetwork.domain.ebrim.extensionpackage.basicextension.association;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Associates a registry object with an extrinsic object describing the resource from which the
 * registry object is derived.
 * 
 * 
 * 8.2.7 Source The "Source" association relates a registry object with an extrinsic object
 * describing the resource from which it is derived in whole or in part. Such a derived registry
 * object is typically created using information extracted from the corresponding repository item
 * according to a set of mapping rules (see clause 12). For an association of this type, the source
 * and target objects shall be of the types indicated in Figure 9. i.e. RegistryObject and
 * ExtrinsicObject, resp.
 * 
 * Table 22 � Association type: Source Property Value Identifier urn:ogc:def:
 * ebRIM-AssociationType:OGC:Source Name Source Description Associates a registry object with an
 * extrinsic object describing the resource from which the registry object is derived. It may be
 * derived from the source resource in whole or in part. Parent
 * urn:oasis:names:tc:ebxml-regrep:classificationScheme:AssociationType Code Source
 * 
 * @author heikki
 * 
 */
@Indexed
public class Source extends Association {
	public Source() {
		super();
		associationType = new URI();
		associationType.setValue("urn:ogc:def:ebRIM-AssociationType:OGC:Source");
	}
}
