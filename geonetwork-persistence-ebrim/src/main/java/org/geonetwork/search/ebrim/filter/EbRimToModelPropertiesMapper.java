package org.geonetwork.search.ebrim.filter;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to map EbRim names to related custom model properties
 *
 * @author Jose
 */
public class EbRimToModelPropertiesMapper {

    private static Map<String, String> mapping;

    static {
        // Mapping from XPath to model property name
        mapping = new HashMap<String, String>();

        mapping.put("rim:Name", "name.localizedStrings");
        mapping.put("rim:Description", "description.localizedStrings");
        mapping.put("rim:Classification", "classifications");
        mapping.put("rim:Association", "associationsSet");
        mapping.put("rim:ExternalIdentifier", "externalidentifiers");
        mapping.put("rim:Slot", "slots");
        mapping.put("rim:VersionInfo", "versionInfo");
        mapping.put("rim:RegistryObjectList", "registryObjectList");
        mapping.put("wrs:ValueList", "basicExtensionValueList");
        mapping.put("wrs:AnyValue", "values");
        mapping.put("rim:ValueList", "valueList");
        mapping.put("rim:Value", "values");
    }

    public static String getPropertyName(String typeName) {
        return mapping.get(typeName);
    }
}
