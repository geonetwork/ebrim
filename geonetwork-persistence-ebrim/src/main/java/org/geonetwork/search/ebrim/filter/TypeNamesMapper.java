package org.geonetwork.search.ebrim.filter;

import org.geonetwork.domain.ebrim.informationmodel.service.Service;
import org.geonetwork.domain.ebrim.informationmodel.classification.Classification;
import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.*;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;
import org.geonetwork.domain.ebrim.informationmodel.event.AuditableEvent;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject.WrsExtrinsicObject;

import java.util.Map;
import java.util.HashMap;


/**
 * Class to map EbRim typeNames to model classes
 *
 */
public class TypeNamesMapper {
    private static Map<String, Class<?>> typeNamesMapping;
    
    static {
        typeNamesMapping = new HashMap<String,Class<?>>();

        typeNamesMapping.put("rim:RegistryObject", RegistryObject.class);
        typeNamesMapping.put("rim:Service", Service.class);
        typeNamesMapping.put("rim:Classification", Classification.class);
        typeNamesMapping.put("rim:Association", Association.class);
        typeNamesMapping.put("rim:ExtrinsicObject", ExtrinsicObject.class);
        typeNamesMapping.put("rim:ExternalIdentifier", ExternalIdentifier.class);
        typeNamesMapping.put("rim:ExternalLink", ExternalLink.class);
        typeNamesMapping.put("rim:RegistryPackage", RegistryPackage.class);
        typeNamesMapping.put("rim:Slot", Slot.class);
        typeNamesMapping.put("rim:Value", LongName.class);
        typeNamesMapping.put("rim:ValueList", ValueList.class);
        typeNamesMapping.put("wrs:ExtrinsicObject", WrsExtrinsicObject.class);
        typeNamesMapping.put("rim:Name", InternationalString.class);
        typeNamesMapping.put("rim:Description", InternationalString.class);
        typeNamesMapping.put("rim:LocalizedString", LocalizedString.class);
        typeNamesMapping.put("rim:AuditableEvent", AuditableEvent.class);

    }

    public static Class<?> getTypeNameClass(String typeName) {
        return typeNamesMapping.get(typeName);
    }
}
