package org.geonetwork.search.ebrim.filter;

import java.util.List;
import java.util.ArrayList;


public class SlotNames {
    private static List<String> slotNames = new ArrayList<String>();

    static {
        slotNames.add("http://purl.org/dc/terms/created");
        slotNames.add("http://purl.org/dc/terms/modified");
        slotNames.add("http://purl.org/dc/terms/issued");
        slotNames.add("urn:x-ogc:specification:csw-ebrim-cim:Slot:scaleDenominator");
        slotNames.add("urn:x-ogc:specification:csw-ebrim-cim:Slot:resolution");
        slotNames.add("http://purl.org/dc/elements/1.1/contributor");
        slotNames.add("http://purl.org/dc/terms/spatial");
        slotNames.add("http://purl.org/dc/terms/temporal");
        slotNames.add("http://purl.org/dc/elements/1.1/creator");
        slotNames.add("http://purl.org/dc/elements/1.1/date");
        slotNames.add("http://purl.org/dc/elements/1.1/language");
        slotNames.add("http://purl.org/dc/elements/1.1/rights");
        slotNames.add("http://purl.org/dc/elements/1.1/source");
        slotNames.add("http://purl.org/dc/elements/1.1/subject");
        slotNames.add("http://purl.org/dc/elements/1.1/format");
        slotNames.add("http://purl.org/dc/elements/1.1/coverage");
        slotNames.add("http://purl.org/dc/terms/conformsTo");
        slotNames.add("http://purl.org/dc/elements/1.1/title");
        slotNames.add("http://purl.org/dc/elements/1.1/identifier");
        slotNames.add("http://purl.org/dc/elements/1.1/type");
        slotNames.add("http://purl.org/dc/elements/1.1/abstract");
        slotNames.add("Conformance");
        slotNames.add("http://purl.org/dc/terms/references");
    }

    public static boolean isValidSlotName(String slotName) {
        return slotNames.contains(slotName);
    }

}
