package org.geonetwork.domain.ebrs.test.utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationNode;
import org.geonetwork.domain.ebrim.informationmodel.classification.ClassificationScheme;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrs.SubmitObjectsRequest;

public class SubmitObjectsRequestFactory {
	public synchronized static SubmitObjectsRequest create() {
		SubmitObjectsRequest submitObjectsRequest = new SubmitObjectsRequest();
		List<ClassificationScheme> registryObjectList = new ArrayList<ClassificationScheme>();
		
		ClassificationScheme classificationScheme = new ClassificationScheme();
		
		InternationalString name = new InternationalString();
		Set<LocalizedString> localizedStrings = new HashSet<LocalizedString>();
		LocalizedString localizedString = new LocalizedString();
		localizedString.setCharset("UTF-8");
		localizedString.setValue("EmailType");
		localizedStrings.add(localizedString);
		name.setLocalizedStrings(localizedStrings);
		classificationScheme.setName(name);
		
		InternationalString description = new InternationalString();
		Set<LocalizedString> localizedStrings2 = new HashSet<LocalizedString>();
		LocalizedString localizedString2 = new LocalizedString();
		localizedString2.setCharset("UTF-8");
		localizedString2.setValue("This is the canonical ClassificationScheme for pre-defined email address types");
		localizedStrings2.add(localizedString2);
		description.setLocalizedStrings(localizedStrings2);
		
		ClassificationNode classificationNode = new ClassificationNode();
		classificationNode.setLid(new URN("urn:oasis:names:tc:ebxml-regrep:EmailType:OfficeEmail"));
		classificationNode.setCode(new LongName("OfficeEmail"));
		classificationNode.setId(new URN("urn:oasis:names:tc:ebxml-regrep:EmailType:OfficeEmail"));
		
		ClassificationNode classificationNode2 = new ClassificationNode();
		classificationNode2.setLid(new URN("urn:oasis:names:tc:ebxml-regrep:EmailType:HomeEmail"));
		classificationNode2.setCode(new LongName("HomeEmail"));
		classificationNode2.setId(new URN("urn:oasis:names:tc:ebxml-regrep:EmailType:HomeEmail"));
		
		Set<ClassificationNode> classificationNodes = new HashSet<ClassificationNode>();
		classificationNodes.add(classificationNode);
		classificationNodes.add(classificationNode2);
		classificationScheme.setClassificationNodes(classificationNodes);
		
		classificationScheme.setLid(new URN("urn:oasis:names:tc:ebxml-regrep:classificationScheme:EmailType"));
		classificationScheme.setId(new URN("urn:oasis:names:tc:ebxml-regrep:classificationScheme:EmailType"));
		classificationScheme.setIsInternal(true);
		classificationScheme.setNodeType(new URI("urn:oasis:names:tc:ebxml-regrep:NodeType:UniqueCode"));

		submitObjectsRequest.setRegistryObjectList(registryObjectList);
		return submitObjectsRequest;
	}
}
