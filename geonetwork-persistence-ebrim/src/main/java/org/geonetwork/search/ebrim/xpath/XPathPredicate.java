package org.geonetwork.search.ebrim.xpath;

import java.util.Map;
import java.util.HashMap;

public class XPathPredicate {
    private Map<String, String> values = new HashMap<String,String>();

    XPathPredicate(String value) {
        parsePredicate(value);
    }

    public Map<String, String> getValues() {
        return values;
    }

    private void parsePredicate(String predicateValue) {
       String[] predicateTokens = predicateValue.split("=");

        if (predicateTokens.length == 2) {
            String predicateProperty = predicateTokens[0];
            String predicatePropertyValue = predicateTokens[1];

            predicateProperty = predicateProperty.replace("@", "");
            if (predicatePropertyValue.startsWith("'")) predicatePropertyValue = predicatePropertyValue.substring(1);
            if (predicatePropertyValue.endsWith("'"))
                predicatePropertyValue = predicatePropertyValue.substring(0, predicatePropertyValue.length() - 1);

            values.put(predicateProperty, predicatePropertyValue);
        }
    }
}
