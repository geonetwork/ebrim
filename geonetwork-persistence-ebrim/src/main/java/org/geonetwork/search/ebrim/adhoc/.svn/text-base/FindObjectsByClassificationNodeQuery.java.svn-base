package org.geonetwork.search.ebrim.adhoc;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.geonetwork.search.ebrim.EbrimGenericSearchDao;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.regex.RegexQuery;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.ListUtils;

import java.util.List;
import java.util.Map;


/**
 * Returns the set of all registry objects that are classified using the specified classification node(s)
 * 
 * QueryParameters:
 *      objectType (optional)
 *          The type of registry object (urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject by default). 
 *      node
 *          A reference to a classification node; the value may be a regular expression that matches multiple nodes.
 *
 * @author Jose
 */
public class FindObjectsByClassificationNodeQuery extends AdhocQuerySearch {
    private static final String DEFAULT_OBJECTTYPE = "urn:oasis:names:tc:ebxml-regrep:ObjectType:RegistryObject";
    private static final String QUERY_IDENTIFIER = "urn:ogc:def:ebRIM-Query:OGC:findObjectsByClassificationNode";

    private static final String PARAM_OBJECTTYPE = "objectType";
    private static final String PARAM_NODE = "node";

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
        String node = parameters.get(PARAM_NODE);

        if ((node == null) || (node.equals(""))) throw new SearchEngineException("Parameter node is required");
        if (objectType == null) objectType = DEFAULT_OBJECTTYPE;


        try {
            Query findByObjectTypeAndClassificationNodeQuery = makeQuery(objectType, node);
            List<RegistryObject> registryObjects = (List<RegistryObject>) searchDao.search(findByObjectTypeAndClassificationNodeQuery, null , RegistryObject.class);

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
     * @param node
     * @return              Gets a Lucene query
     */
    private Query makeQuery(String objectType, String node) {
        BooleanQuery booleanQuery = new BooleanQuery();

        Query objectTypeQuery = new TermQuery(new Term("objectType.value", QueryParser.escape(objectType)));
        Query nodeQuery = new RegexQuery(new Term("classifications.classificationNode.value",   QueryParser.escape(node)));

        booleanQuery.add(objectTypeQuery, BooleanClause.Occur.MUST);
        booleanQuery.add(nodeQuery, BooleanClause.Occur.MUST);

        return booleanQuery;

    }

    private class ObjectToRegistryObjectTransformer implements Transformer {
        public Object transform(Object input) {
            return (RegistryObject) input;
        }
    }
}