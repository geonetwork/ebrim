package org.geonetwork.domain.ebrim.extensionpackage.basicextension.association;

import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Associates a Dataset item with an Image resource that illustrates or summarizes the data in some
 * manner (e.g., a browsing aid).
 * 
 * 
 * 8.2.6 GraphicOverview The "GraphicOverview" association relates a Dataset item with an Image
 * resource that illustrates or graphically summarizes the data set in some manner (see ISO 19115,
 * B.2.2.1). For an association of this type, the source and target objects shall be of the types
 * indicated in Figure 8. i.e. DataSet and Image, resp.
 * 
 * Table 21 � Association type: GraphicOverview Property Value Identifier urn:ogc:def:
 * ebRIM-AssociationType:OGC:GraphicOverview Name GraphicOverview Description Associates a Dataset
 * item with an Image resource that illustrates or summarizes the data in some manner (e.g., a
 * browsing aid). Parent urn:oasis:names:tc:ebxml-regrep:classificationScheme:AssociationType Code
 * GraphicOverview
 * 
 * 
 * @author heikki
 * 
 */
@Indexed
public class GraphicOverview extends Association {

	public GraphicOverview() {
		super();
		associationType = new URI();
		associationType.setValue("urn:ogc:def:ebRIM-AssociationType:OGC: GraphicOverview");
	}
}
