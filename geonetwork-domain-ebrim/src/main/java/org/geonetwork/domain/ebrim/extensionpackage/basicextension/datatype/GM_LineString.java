package org.geonetwork.domain.ebrim.extensionpackage.basicextension.datatype;


/**
 * A special curve that consists of a single segment with linear interpolation.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.3.5 GM_LineString The GM_LineString data type represents a special curve that consists of a single segment with
 * linear interpolation (see ISO 19107, Clause 6.4.10). The lexical representation is a <gml:LineString> element.
 * 
 * Table 27 � Data type: GM_LineString Property Value Identifier urn:ogc:def:dataType:ISO-19107:GM_LineString Name
 * GM_LineString Description A LineString is a special curve that consists of a single segment with linear
 * interpolation. It is represented by a gml:LineString element.. Parent urn:ogc:def:dataType:ISO-19107:GM_Curve Code
 * GM_LineString
 * 
 * @author heikki
 * 
 */

public class GM_LineString extends GM_Curve {

}
