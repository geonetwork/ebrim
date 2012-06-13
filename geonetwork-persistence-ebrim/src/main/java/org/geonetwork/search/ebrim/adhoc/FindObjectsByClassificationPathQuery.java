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
package org.geonetwork.search.ebrim.adhoc;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.geonetwork.search.ebrim.EbrimGenericSearchDao;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.regex.RegexQuery;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.Transformer;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Returns the set of all registry objects that are classified according to the specified classification path(s). 
 * A regular expression may be used to specify branching paths.
 *
 * QueryParameters:
 *      objectType (optional)
 *          The type of registry object (urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject. by default).
 *
 *      path
 *          A classification path that conforms to the syntax defined in section 4.2.5 of ebRIM 3.0;
 *          the value may be a regular expression that encompasses branching paths.
 *
 * @author Jose
 */
public class FindObjectsByClassificationPathQuery extends AdhocQuerySearch {
    private  static final String DEFAULT_OBJECTTYPE = "urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject";
    private static final String QUERY_IDENTIFIER = "urn:ogc:def:ebRIM-Query:OGC:findObjectsByClassificationPath";

    private static final String PARAM_OBJECTTYPE = "objectType";
    private static final String PARAM_PATH = "path";

    EbrimGenericSearchDao searchDao;

    public void setEbrimGenericSearchDao(EbrimGenericSearchDao searchDao) {
        this.searchDao = searchDao;
    }

    public static String getIdentifier() {
            return QUERY_IDENTIFIER;
    }

    @SuppressWarnings("unchecked")
	public List<? extends RegistryObject> query(Map<String, String> parameters) throws SearchEngineException {
        if (parameters == null) throw new SearchEngineException("Parameter node is required");

        // Process parameters
        String objectType = parameters.get(PARAM_OBJECTTYPE);
        String path = parameters.get(PARAM_PATH);

        if (path == null) throw new SearchEngineException("Parameter path is required");
        if (!validatePath(path)) throw new SearchEngineException("Parameter path syntax is not valid");
        if (objectType == null) objectType = DEFAULT_OBJECTTYPE;


        try {
            Query findByObjectTypeAndPathQuery = makeQuery(objectType, path);
            
            List<RegistryObject> registryObjects = (List<RegistryObject>) searchDao.search(findByObjectTypeAndPathQuery, null , RegistryObject.class);

            // Convert List<Objects> to List<RegistryObject>
            return ListUtils.transformedList(registryObjects,new ObjectToRegistryObjectTransformer());

        } catch (GeoNetworkException e) {
            throw new SearchEngineException(e);
        }
    }

    /**
     * Gets a Lucene query using objectType and classificationNode properties
     *
     * @param objectType
     * @param path
     * @return              Gets a Lucene query
     */
    private Query makeQuery(String objectType, String path) {
        BooleanQuery booleanQuery = new BooleanQuery();

        Query objectTypeQuery = new TermQuery(new Term("objectType.value", QueryParser.escape(objectType)));
        
        Query nodeQuery = new RegexQuery(new Term("path", path));

        booleanQuery.add(objectTypeQuery, BooleanClause.Occur.MUST);
        booleanQuery.add(nodeQuery, BooleanClause.Occur.MUST);

        return booleanQuery;
    }

    /**
     * Checks path syntax according:
     *      canonicalPath ::= '/' rootSchemeOrNodeId nodePath
     *      nodePath ::= '/' nodeCode
     *              |   '/' nodeCode ( nodePath )?
     *
     * @param path      Path to check
     * @return          true if path syntax is valid, false otherwise
     */
    private boolean validatePath(String path) {

        Pattern pattern = Pattern.compile("/[^/]+(/[^/]+)*/?");
        Matcher m =  pattern.matcher(path);

        return   m.matches();
    }


    private class ObjectToRegistryObjectTransformer implements Transformer {
        public Object transform(Object input) {
            return (RegistryObject) input;
        }
    }
}
