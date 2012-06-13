package org.geonetwork.search.ebrim.filter.queryfields;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;

import java.util.Map;

/**
 * Class to process a lucene field query.
 */
public class Field {
    String fieldName;

    // Additional query conditions to apply to the field
    Map<String, String> queryConditions;

    public String getFieldName() {
        return fieldName;
    }

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public Field(String fieldName, Map<String, String> queryConditions) {
        this.fieldName = fieldName;
        this.queryConditions = queryConditions;
    }

    /**
     * Process a query for the field and returns a modified query
     * This class not modifify the query, returning the original query,
     * subclasses should define different logic.
     * <p/>
     * See AnyField, SlotField classes
     *
     * @param query Query
     * @return Processed query
     */
    public Query process(Query query) {
        if ((queryConditions != null) && (!queryConditions.isEmpty())) {
            BooleanQuery boolQuery = new BooleanQuery();

            if (query instanceof BooleanQuery) {
                boolQuery= (BooleanQuery) query;
            } else {
                boolQuery.add(query, BooleanClause.Occur.MUST);
            }

            for (String queryField : queryConditions.keySet()) {
                Term term = new Term(queryField,  QueryParser.escape(queryConditions.get(queryField)));
                boolQuery.add(new TermQuery(term), BooleanClause.Occur.MUST);
            }

            return boolQuery;
        } else {
            return query;
        }

    }
}
