package org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery;

import org.hibernate.search.annotations.Indexed;

/**
 * Returns a list of supported extension packages.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 10.1 listExtensionPackages Invoking the listExtensionPackages query returns a list of supported
 * extension packages. The Basic package shall be supported by every conforming service.
 * 
 * Table 56 � Predefined query: listExtensionPackages Identifier
 * urn:ogc:def:ebRIM-Query:OGC:listExtensionPackages Name listExtensionPackages Parameters None
 * Response A <csw:GetRecordsResponse> element containing a <rim:RegistryPackage> element
 * corresponding to each supported extension package.
 * 
 * @author heikki
 * 
 */
@Indexed
public class ListExtensionPackages extends StoredQuery {

}
