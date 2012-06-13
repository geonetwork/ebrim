package org.geonetwork.search.ebrim.filter.queryfields;

import junit.framework.TestCase;
import org.junit.Test;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.index.Term;

/**
 * Tests for Field class
 */
public class FieldTest extends TestCase {

    @Test
    public void testProcess() {
        FieldMapper fldMapper = new FieldMapper();

        Field fld = fldMapper.findField("title");
        assertNotNull(fld);

        Term term = new Term(fld.getFieldName(), "value");
        TermQuery query = new TermQuery(term);

        // Test that processed query is the same as source query
        Query resultQuery = fld.process(query);
        assertEquals(query, resultQuery);
      }
}
