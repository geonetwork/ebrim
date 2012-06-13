package org.geonetwork.domain.ebrim.extensionpackage.basicextension.association;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Associates an Annotation resource with a registry object that it provides commentary about.
 * 
 * 
 * 8.2.5 Annotates The "Annotates" association relates an Annotation resource (see 8.1.7) with a
 * registry object (of any type) that it provides additional commentary about. For an association of
 * this type, the source and target objects shall be of the types indicated in Figure 7. i.e.
 * Annotation and RegistryObject
 * 
 * Table 20 � Association type: Annotates Property Value Identifier urn:ogc:def:
 * ebRIM-AssociationType:OGC:Annotates Name Annotates Description Associates an Annotation resource
 * with a registry object that it provides commentary about. Parent
 * urn:oasis:names:tc:ebxml-regrep:classificationScheme:AssociationType Code Annotates
 * 
 * @author heikki
 * 
 */
@Indexed
public class Annotates extends Association {

	public Annotates() {
		super();
		associationType = new URI();
		associationType.setValue("urn:ogc:def:ebRIM-AssociationType:OGC:Annotates");
	}
}
