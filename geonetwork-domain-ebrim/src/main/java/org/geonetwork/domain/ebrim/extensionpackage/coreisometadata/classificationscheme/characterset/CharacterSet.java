package org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.characterset;

import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty.classificationnode.Author;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty.classificationnode.Originator;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty.classificationnode.PointOfContact;
import org.geonetwork.domain.ebrim.extensionpackage.coreisometadata.classificationscheme.citedresponsibleparty.classificationnode.Publisher;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.hibernate.search.annotations.Indexed;

/**
 * TODO add the characterset classificationnodes. And write them all, first ..
 * 
 * @author heikki doeleman
 *
 */
@Indexed
public class CharacterSet extends ClassificationScheme {

	public CharacterSet() {
		super();
		this.id = new URN("urn:ogc:def:ebRIM-ClassificationScheme:CharacterSet");
		this.objectType = new URI("urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject:ClassificationScheme");
		this.setNodeType(new URI("urn:oasis:names:tc:ebxml-regrep:NodeType:UniqueCode"));
		this.setIsInternal(true);
		
		this.classificationNodes.add(new Author());
		this.classificationNodes.add(new Originator());
		this.classificationNodes.add(new PointOfContact());
		this.classificationNodes.add(new Publisher());

	}
}
