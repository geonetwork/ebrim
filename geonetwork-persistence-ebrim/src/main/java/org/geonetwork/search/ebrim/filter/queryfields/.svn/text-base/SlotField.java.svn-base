package org.geonetwork.search.ebrim.filter.queryfields;

import org.apache.lucene.search.Query;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.index.Term;

/**
 * Class to process field query in slots. Creates a BooleanQuery to
 * filter slot also by name
 */
public class SlotField extends Field {
    String slotNameValue;
    
    public SlotField(String fieldName, String slotNameValue) {
        super(fieldName);
        this.slotNameValue = slotNameValue;
    }

    @Override
    public Query process(Query query) {
        Term term = new Term("slots.name.value", slotNameValue);

        BooleanQuery boolQuery = new BooleanQuery();

        boolQuery.add(query, BooleanClause.Occur.MUST);
        boolQuery.add(new TermQuery(term), BooleanClause.Occur.MUST);

        return boolQuery;
    }
}
