//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================

package org.geonetwork.search.ebrim.filter;

import java.util.List;

import org.geonetwork.domain.xsd.QName;

/**
 * Class to process a filter string and replace type aliases names with type names
 *
 * @author Jose
 */
public class FilterTypeNamesProcessor {
    private final String ALIAS_PREFIX = "$";

    private String filterString;
    List<QName> typeNames;

    /**
     * Constructor
     *
     * @param filterString      Filter string
     * @param typeNames         Type names used in filter
     *
     * TODO: Get type names from filter string
     */
    public FilterTypeNamesProcessor(String filterString, List<QName> typeNames) {
        this.filterString = filterString;
        this.typeNames = typeNames;
    }

    /**
     * Process a filter string to replace type aliases names with type names
     *
     * @return Filter processed
     */
    public String process() {
        if (typeNames == null) return filterString;

        String filterStringProcessed = filterString;

        for (QName typeName : typeNames) {
            String typeNameValue = typeName.getValue();

            String[] tokens = typeNameValue.split("_");

            if (tokens.length > 1) {
                String type = tokens[0];
                String[] names = new String[tokens.length-1];
                System.arraycopy(tokens,1, names, 0, tokens.length-1);
                
                for (int i = 0; i < names.length; i++) {
                    filterStringProcessed = replaceNamesWithType(filterStringProcessed, names[i], type);
                }
            }
        }

        return filterStringProcessed;
    }

    /**
     * Replaces all occurrences of a type alias name with type name
     *
     * @param filter        Filter string to replace type alias
     * @param name          Type alias name
     * @param type          Type name
     * @return
     */
    private String replaceNamesWithType(String filter, String name, String type) {
        int pos = filter.indexOf(ALIAS_PREFIX + name);
        int lastPos = 0;
        StringBuffer sb = new StringBuffer();

        while (pos > -1) {
            sb.append(filter.substring(lastPos, pos));
            sb.append("/" + type);
            lastPos = pos + (ALIAS_PREFIX + name).length();
            pos = filter.indexOf(ALIAS_PREFIX + name, lastPos);
        }

        sb.append(filter.substring(lastPos));

        return sb.toString();
    }
}