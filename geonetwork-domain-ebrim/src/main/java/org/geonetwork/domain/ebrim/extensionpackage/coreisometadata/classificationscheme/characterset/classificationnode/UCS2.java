package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.characterset.classificationnode;

import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;

/**
 * 16-bit fixed size Universal Character Set, based on ISO/IEC 10646.
 * 
 * @author heikki doeleman
 *
 */
public class UCS2 extends ClassificationNode {

	public UCS2() {
		super();
		this.objectType = new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ClassificationNode");
		this.setParent(new URI("urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet"));
		this.setCode(new LongName("ucs2"));
		this.setId(new URN("urn:ogc:def:ebRIM-ClassificationNode:CharacterSet:ucs2"));
	}
}
