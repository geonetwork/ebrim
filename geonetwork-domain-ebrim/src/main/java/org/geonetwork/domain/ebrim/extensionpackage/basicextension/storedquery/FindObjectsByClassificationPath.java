package org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery;

import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Returns the set of all registry objects that are classified according to the specified
 * classification path(s).
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 10.5 findObjectsByClassificationPath Invoking the findObjectsByClassificationPath query returns
 * the set of all registry objects that are classified according to the specified classification
 * path(s). A regular expression may be used to specify branching paths.
 * 
 * Table 60 � Predefined query: findServices Identifier
 * urn:ogc:def:ebRIM-Query:OGC:findObjectsByClassificationPath Name findObjectsByClassificationPath
 * Parameters objectType (optional) The type of registry object
 * ("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject" by default). path A classification
 * path that conforms to the syntax defined in section 4.2.5 of ebRIM 3.0; the value may be a
 * regular expression that encompasses branching paths. Response A <csw:GetRecordsResponse> element
 * containing registry objects of the requested type that are classified according to the the
 * specified path value(s).
 * 
 * @author heikki
 * 
 */
@Indexed
public class FindObjectsByClassificationPath extends StoredQuery {

}
