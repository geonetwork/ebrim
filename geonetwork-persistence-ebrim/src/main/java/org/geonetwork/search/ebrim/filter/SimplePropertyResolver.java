package org.geonetwork.search.ebrim.filter;

import org.geonetwork.search.ebrim.filter.queryfields.FieldMapper;
import org.geonetwork.search.ebrim.filter.queryfields.Field;

/**
 *  Class to resolve OCG queryables to lucene index names
 */
public class SimplePropertyResolver extends PropertyResolver {
    private FieldMapper fieldMapper;

    /**
     * Constructor
     *
     * @param propertyName      OCG queryable to resolve to lucene index name
     */
    SimplePropertyResolver(String propertyName) {
        // Convert to lowercase to ignore name case in comparations
        super(propertyName.toLowerCase());

        fieldMapper = new FieldMapper();
    }

    public Field resolveProperty(String rootEntity) {
        Field fld = fieldMapper.findField(propertyName);

        if (fld == null) fld =  fieldMapper.findField(rootEntity + "/" + propertyName);

        return fld;
    }
}
