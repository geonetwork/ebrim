package org.geonetwork.search.ebrim.filter;

/**
 * Property resolver factory.
 * Returns the property resolver class based on property name.
 *
 * @author Jose
 */
public class PropertyResolverFactory {    
    /**
     * Returns XPathPropertyResolver o SimplePropertyResolver
     *
     * @param property          Property name
     * @return                  Property resolver
     */
    public static PropertyResolver getPropertyResolver(String property) {
        // XPath property expression
        if (property.contains("/") || property.contains("@"))
            return new XPathPropertyResolver(property);
        else
            return new SimplePropertyResolver(property);
    }
}
