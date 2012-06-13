package org.geonetwork.search.ebrim.filter;

import org.geonetwork.search.ebrim.filter.queryfields.Field;

/**
 * Abstract class  that extend classes to resolve
 * filter property names to model properties
 *
 * @author Jose
 */
public abstract class PropertyResolver {
    protected String propertyName;

    PropertyResolver(String propertyName) {
        this.propertyName = propertyName.toLowerCase();
    }

    /**
     * Returns model property name
     *
     * @return              The model property name associated to filter property name
     */
    public abstract Field resolveProperty(String rootEntity);
}
