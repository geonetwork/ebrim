package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.characterset.classificationnode;

import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;

/**
 * ISO/IEC 8859-2, Information technology – 8-bit single-byte coded graphic character sets – Part 2: Latin 
 * alphabet No. 2.
 * 
 * @author heikki doeleman
 *
 */
public class _8859Part2 extends ClassificationNode {

	public _8859Part2() {
		super();
		this.objectType = new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ClassificationNode");
		this.setParent(new URI("urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet"));
		this.setCode(new LongName("8859part2"));
		this.setId(new URN("urn:ogc:def:ebRIM-ClassificationNode:CharacterSet:8859part2"));
	}
}
