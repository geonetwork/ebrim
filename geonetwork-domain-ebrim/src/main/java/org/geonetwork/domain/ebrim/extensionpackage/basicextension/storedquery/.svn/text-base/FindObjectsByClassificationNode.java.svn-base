package org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery;

import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Returns the set of all registry objects that are classified using the specified classification
 * node(s).
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 10.4 findObjectsByClassificationNode Invoking the findObjectsByClassificationNode query returns
 * the set of all registry objects that are classified using the specified classification node(s). A
 * regular expression�as defined in section F of XML Schema Part 2�may be used to expand the search
 * to also encompass descendent or ancestor nodes.
 * 
 * Table 59 � Predefined query: findObjectsByClassificationNode Identifier
 * urn:ogc:def:ebRIM-Query:OGC:findObjectsByClassificationNode Name findObjectsByClassificationNode
 * Parameters objectType (optional) The type of registry object
 * ("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject" by default). node A reference to a
 * classification node; the value may be a regular expression that matches multiple nodes. Response
 * A <csw:GetRecordsResponse> element containing registry objects of the requested type that are
 * classified using the specified node(s).
 * 
 * @author heikki
 * 
 */
@Indexed
public class FindObjectsByClassificationNode extends StoredQuery {

}
