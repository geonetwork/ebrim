package org.geonetwork.domain.ebrim.extensionpackage.basicextension.datatype;


/**
 * 
 * An extent in time.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.3.14 TM_Period The TM_Period data type represents an extent in time; it is an open interval bounded by beginning
 * and end points (i.e. instants), and has a duration (see ISO 19108, Clause 5.2.3.3). The lexical representation is a
 * <gml:TimePeriod> element.
 * 
 * Table 36 � Data type: TM_Period Property Value Identifier urn:ogc:def:dataType:ISO-19108:TM_Period Name TM_Period
 * Description The gml:TimePeriod element denotes an extent in time. It is an open interval bounded by beginning and end
 * points (i.e. instants). Parent urn:ogc:def:dataType:ISO-19108:TM_GeometricPrimitive Code TM_Period
 * 
 * @author heikki
 * 
 */

public class TM_Period extends TM_GeometricPrimitive {

}
