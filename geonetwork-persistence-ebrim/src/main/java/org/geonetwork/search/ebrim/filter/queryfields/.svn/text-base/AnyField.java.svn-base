package org.geonetwork.search.ebrim.filter.queryfields;

import org.apache.lucene.search.*;
import org.apache.lucene.index.Term;

import java.util.Map;

/**
 * Class to process Anytext field query.
 */
public class AnyField extends Field {
    Map<String, Field> fields;

    public void setFields(Map<String, Field> fields) {
        this.fields = fields;
    }

    public AnyField() {
        super("");
    }

    @Override
    public Query process(Query query) {
        BooleanQuery boolQuery = new BooleanQuery();

        for (String key : fields.keySet()) {
            if (!key.equalsIgnoreCase("anytext")) {

                Field field = fields.get(key);
                Query queryField = field.process(getModifiedQuery(field.getFieldName(), query));
                boolQuery.add(queryField, BooleanClause.Occur.SHOULD);
            }
        }

        return boolQuery;
    }


    private Query getModifiedQuery(String fieldNameToReplace, Query query) {

        if (query instanceof TermQuery) {

            TermQuery termQuery = (TermQuery) query;
            Term originalTerm = termQuery.getTerm();
            Term newTerm = new Term(fieldNameToReplace, originalTerm.text());
            return new TermQuery(newTerm);

        } else if (query instanceof RangeQuery) {

            RangeQuery rangeQuery = (RangeQuery) query;

            Term lowerTerm = rangeQuery.getLowerTerm();
            Term newLowerTerm = null;
            if (lowerTerm != null) {
                newLowerTerm = new Term(fieldNameToReplace, lowerTerm.text());
            }

            Term upperTerm = rangeQuery.getUpperTerm();
            Term newUpperTerm = null;
            if (upperTerm != null) {
                newUpperTerm = new Term(fieldNameToReplace, upperTerm.text());
            }

            return new RangeQuery(newLowerTerm, newUpperTerm, rangeQuery.isInclusive());

        } else if (query instanceof WildcardQuery) {

            WildcardQuery wildCardQuery = (WildcardQuery) query;

            Term originalTerm = wildCardQuery.getTerm();
            Term newTerm = new Term(fieldNameToReplace, originalTerm.text());
            return new WildcardQuery(newTerm);
        }

        return null;
    }
}
