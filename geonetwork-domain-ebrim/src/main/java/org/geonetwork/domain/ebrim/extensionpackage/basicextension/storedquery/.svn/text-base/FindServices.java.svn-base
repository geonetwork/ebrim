package org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery;

import org.hibernate.search.annotations.Indexed;

/**
 * 
 * Returns a listing of all service offers.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 10.3 findServices Invoking the findServices query returns a listing of all service offers. The
 * serviceType parameter may be included to request a subset of services classified using the ISO
 * 19119 services taxonomy (see Clause 7.1).
 * 
 * Table 58 � Predefined query: findServices Identifier urn:ogc:def:ebRIM-Query:OGC:findServices
 * Name findServices Parameters serviceType (optional) A service type code value from the ISO 19119
 * services taxonomy. Response A <csw:GetRecordsResponse> element containing <rim:Service> items
 * that are classified as the requested type. If the type corresponds to a branch node in the
 * scheme, all service offers classified anywhere in the subtree shall be included.
 * 
 * @author heikki
 * 
 */
@Indexed
public class FindServices extends StoredQuery {

}
