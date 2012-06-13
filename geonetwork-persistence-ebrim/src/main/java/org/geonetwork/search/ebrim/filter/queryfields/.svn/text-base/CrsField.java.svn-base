package org.geonetwork.search.ebrim.filter.queryfields;

import org.apache.lucene.search.Query;

public class CrsField extends Field {
    public CrsField(String fieldName) {
        super(fieldName);
    }

    @Override
    public Query process(Query query) {
    /*    // Format: <Prefix><Authority>::<ID> --> Example: urn:opengis:crs:EPSG::4326
        String crs = values.get(0);
        String[] tokens = getTokens(crs, "::");
        String authority = tokens[0];
        String id = tokens[1];

        String[] authorityTokens = getTokens(authority, ":");
        authority = authorityTokens[authority.length()-1];     */
        
        return null;
    }

    private String[] getTokens(String text, String sep) {
        return text.split(sep);    
    }
}
