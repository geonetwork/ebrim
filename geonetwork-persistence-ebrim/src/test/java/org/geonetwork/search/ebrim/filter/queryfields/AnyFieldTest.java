package org.geonetwork.search.ebrim.filter.queryfields;

import junit.framework.TestCase;
import org.junit.Test;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.BooleanClause;

/**
 * Tests for AnyField class
 */
public class AnyFieldTest extends TestCase {
    @Test
    public void testProcess() {
        FieldMapper fldMapper = new FieldMapper();

        Field fld = fldMapper.findField("anytext");
        assertTrue(fld instanceof AnyField);

        Term term = new Term(fld.getFieldName(), "value");
        TermQuery query = new TermQuery(term);

        Query resultQuery = fld.process(query);
        assertTrue(resultQuery instanceof BooleanQuery);

        BooleanQuery boolQuery = (BooleanQuery) resultQuery;
        BooleanClause[] clauses = boolQuery.getClauses();

        // We don't count anytext field
        assertEquals(clauses.length, fldMapper.getFields().size() - 1);
    }
}
