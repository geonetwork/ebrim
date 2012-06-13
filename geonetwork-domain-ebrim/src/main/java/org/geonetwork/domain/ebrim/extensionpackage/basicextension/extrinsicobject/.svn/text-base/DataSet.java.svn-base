package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * 
 * A description of an available data resource.
 * 
 * 
 * From OGC 07-144r2 : CSW-ebRIM_Registry_Service__Part_2_Basic_extension_package.pdf:
 * 
 * 8.1.6 Dataset A Dataset item represents a description of an available data resource. No
 * particular data access methods are presumed, nor are any specific representations prescribed. No
 * absolute distinction is drawn between "data" and "metadata", as such a differentiation is largely
 * a matter of context. Geographic data providers are encouraged to adopt the ISO/TS 19139 standard;
 * this standard defines an XML grammar derived from ISO 19115 (Geographic information -- Metadata).
 * It provides much information about many aspects of digital geographic data.
 * 
 * Table 10 � Object type: Dataset Property Value Identifier
 * urn:ogc:def:ebRIM-ObjectType:OGC:Dataset Name Dataset Description Description of a data resource
 * that may or may not be electronically available. Parent
 * urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ExtrinsicObject Code Dataset A data
 * description may be related to a Service item using the "OperatesOn" association (see 8.2.1).
 * 
 * NOTE The ISO 19139 schemas are publicly available at this URL:
 * <http://standards.iso.org/ittf/PubliclyAvailableStandards/ISO_19139_Schemas/>.
 * 
 * 
 * @author heikki
 * 
 */
@Indexed
public class DataSet extends ExtrinsicObject {

	public DataSet() {
		id = new URN("urn:ogc:def:ebRIM-ObjectType:OGC:Dataset");
	}
}
