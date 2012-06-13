package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.characterset.classificationnode;

import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;

/**
 * 7-bit variable size UCS Transfer Format, based on ISO/IEC 10646.
 * 
 * @author heikki doeleman
 *
 */
public class UTF7 extends ClassificationNode {

	public UTF7() {
		super();
		this.objectType = new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ClassificationNode");
		this.setParent(new URI("urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet"));
		this.setCode(new LongName("utf7"));
		this.setId(new URN("urn:ogc:def:ebRIM-ClassificationNode:CharacterSet:utf7"));
	}
}
