package org.geonetwork.search.ebrim.filter.queryfields;

import junit.framework.TestCase;
import org.junit.Test;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.BooleanClause;

/**
 * Tests for SlotField class
 */
public class SlotFieldTest extends TestCase {
    @Test
    public void testProcess() {
        FieldMapper fldMapper = new FieldMapper();

        Field fld = fldMapper.findField("modified");
        assertTrue(fld instanceof SlotField);

        Term term = new Term(fld.getFieldName(), "value");
        TermQuery query = new TermQuery(term);

        // Test that processed query is a boolean query
        Query resultQuery = fld.process(query);
        assertTrue(resultQuery instanceof BooleanQuery);

        // Test that processed boolean query includes query
        BooleanQuery boolQuery = (BooleanQuery) resultQuery;
        BooleanClause[] clauses = boolQuery.getClauses();
        assertEquals(query, clauses[0].getQuery());
    }
}
