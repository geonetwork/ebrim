package org.geonetwork.domain.ebrim.extensionpackage.basicextension.datatype;


/**
 * 
 * A position in time.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.3.13 TM_Instant The TM_Instant data type represents a position in time; in practice, an instant is an interval
 * whose duration is less than the resolution of the time scale (see ISO 19108, Clause 5.2.3.2). The lexical
 * representation is a <gml:TimeInstant> element.
 * 
 * Table 35 � Data type: TM_Instant Property Value Identifier urn:ogc:def:dataType:ISO-19108:TM_Instant Name
 * TM_Instant Description The gml:TimeInstant element denotes a position in time. Parent
 * urn:ogc:def:dataType:ISO-19108:TM_GeometricPrimitive Code TM_Instant
 * 
 * @author heikki
 * 
 */

public class TM_Instant extends TM_GeometricPrimitive {

}
