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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.TestCase;

import org.geotools.xml.Configuration;
import org.geotools.xml.Parser;
import org.junit.Test;
import org.opengis.filter.Filter;
import org.xml.sax.SAXException;
import org.apache.lucene.search.Query;
import org.geonetwork.search.ebrim.EbrimGenericSearchDao;
import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.gaap.client.GaapServicesClient;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * Tests for FilterToLucene class
 *
 * @author Jose
 */
public class FilterToLuceneTest extends AbstractDaoTest {
    Parser parser;
    EbrimGenericSearchDao ebRimGenericSearchDao;

    public void setEbrimGenericSearchDao(EbrimGenericSearchDao ebRimGenericSearchDao) {
        this.ebRimGenericSearchDao = ebRimGenericSearchDao;
    }

    @Override
    protected void onSetUp() throws Exception {
        // create the parser with the filter 1.1 configuration
        Configuration configuration = new org.geotools.filter.v1_1.OGCConfiguration();
        parser = new Parser(configuration);
    }

    @Test
    public void testDummy() {
        
    }
    
    /**
     * Test Binary comparison operators: PropertyIsEqualTo,
     * PropertyIsLessThan,PropertyIsLessThanOrEqualTo, PropertyIsGreaterThan,
     * PropertyIsGreaterThanOrEqualTo, PropertyIsLike, PropertyIsBetween, PropertyIsNotEqualTo
     */
    @Test
    public void testEncodeBinaryComparisonOperators() {
        try {
            // Test PropertyIsEqualTo

            InputStream testData = new FileInputStream(new File("src/test/resources/search/PropertyIsEqualTo.xml"));
            String testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/PropertyIsEqualTo_lucene.txt")));

            String luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("PropertyIsEqualTo filter", testExpectedResult.toString(), luceneQuery);

            // Test PropertyIsLessThan
            testData = new FileInputStream(new File("src/test/resources/search/PropertyIsLessThan.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/PropertyIsLessThan_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("PropertyIsLessThan filter", testExpectedResult.toString(), luceneQuery);

            // Test PropertyIsLessThanOrEqualTo
            testData = new FileInputStream(new File("src/test/resources/search/PropertyIsLessThanOrEqualTo.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/PropertyIsLessThanOrEqualTo_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("PropertyIsLessThanOrEqualTo filter", testExpectedResult.toString(), luceneQuery);

            // Test PropertyIsGreaterThan
            testData = new FileInputStream(new File("src/test/resources/search/PropertyIsGreaterThan.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/PropertyIsGreaterThan_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("PropertyIsGreaterThan filter", testExpectedResult.toString(), luceneQuery);

            // Test PropertyIsGreaterThanOrEqualTo
            testData = new FileInputStream(new File("src/test/resources/search/PropertyIsGreaterThanOrEqualTo.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/PropertyIsGreaterThanOrEqualTo_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("PropertyIsGreaterThanOrEqualTo filter", testExpectedResult.toString(), luceneQuery);

            // Test PropertyIsLike
            testData = new FileInputStream(new File("src/test/resources/search/PropertyIsLike.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/PropertyIsLike_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("PropertyIsLike filter", testExpectedResult.toString(), luceneQuery);

            // Test PropertyIsBetween
            testData = new FileInputStream(new File("src/test/resources/search/PropertyIsBetween.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/PropertyIsBetween_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("PropertyIsBetween filter", testExpectedResult.toString(), luceneQuery);

            // Test PropertyIsNotEqualTo
            testData = new FileInputStream(new File("src/test/resources/search/PropertyIsNotEqualTo.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/PropertyIsNotEqualTo_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("PropertyIsNotEqualTo filter", testExpectedResult.toString(), luceneQuery);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Test binary logic operators: And, Or, Not
     */
    @Test
    public void xtestEncodeBinaryLogicOperators() {
        try {
            // Test And
            InputStream testData = new FileInputStream(new File("src/test/resources/search/And.xml"));
            String testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/And_lucene.txt")));

            String luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("And filter", testExpectedResult.toString(), luceneQuery);

            // Test Or
            testData = new FileInputStream(new File("src/test/resources/search/Or.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/Or_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("Or filter", testExpectedResult.toString(), luceneQuery);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());

        }
    }

    /**
     * Test mixed binary logic operators: And, Or, Not
     */
    @Test
    public void xtestMultipleBinaryOperators() {
        try {
            // Test Multiple binary operators
            InputStream testData = new FileInputStream(new File("src/test/resources/search/AndAnd.xml"));
            String testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/AndAnd_lucene.txt")));

            String luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("And And filter", testExpectedResult.toString(), luceneQuery);

            testData = new FileInputStream(new File("src/test/resources/search/OrAnd.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/OrAnd_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("Or And filter", testExpectedResult.toString(), luceneQuery);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());

        }
    }

    /**
     * Test Bounding Box Spatial Operator
     */
    @Test
    public void xtestEncodeBbox
            () {
        try {
            // Test BBox
            InputStream testData = new FileInputStream(new File("src/test/resources/search/BBox.xml"));
            String testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/BBox_lucene.txt")));

            String luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("Bbox filter", testExpectedResult.toString(), luceneQuery);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());

        }
    }

    /**
     * Test filter with Anytext property
     * 
     * TODO : investigate why this test is faling in the long run
     */
    public void _testAnytextProperty() {
        try {
            // Test Anytext property
            InputStream testData = new FileInputStream(new File("src/test/resources/search/Anytext.xml"));
            String testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/Anytext_lucene.txt")));

            String luceneQuery = getLuceneQuery(testData, parser);
            assertEquals(testExpectedResult, luceneQuery);

            testData = new FileInputStream(new File("src/test/resources/search/Anytext2.xml"));
            testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/Anytext2_lucene.txt")));

            luceneQuery = getLuceneQuery(testData, parser);
            assertEquals(testExpectedResult, luceneQuery);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test Binary comparison operator PropertyIsEqualTo with XPath expression
     */
    @Test
    public void xtestXPathExpression() {
        try {
            InputStream testData = new FileInputStream(new File("src/test/resources/search/PropertyIsEqualToXPath.xml"));
            String testExpectedResult = convertStreamToString(new FileInputStream(new File(
                    "src/test/resources/search/PropertyIsEqualToXPath_lucene.txt")));

            String luceneQuery = getLuceneQuery(testData, parser);
            assertEquals("PropertyIsEqualTo filter (testXPathExpression)", testExpectedResult.toString(), luceneQuery);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Test the parser with a bad formatted Filter
     */
    @Test
    public void xtestBadFormatFilter
            () {
        try {
            // Test BBox
            InputStream testData = new FileInputStream(new File("src/test/resources/search/BadFormatFilter.testxml"));
            // parse
            parser.parse(testData);

            fail();

        } catch (SAXException e) {
            e.printStackTrace();

        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Convenience method to get the lucene query generated from OGC filter
     *
     * @param testData InputStream with OGC filter
     * @param parser   Parser for OGC filter
     * @return Lucene query generated from OGC filter as a string
     * @throws Exception
     */

    private String getLuceneQuery(InputStream testData, Parser parser) throws Exception {
        FilterToLucene filterToLucene = new FilterToLucene();
        filterToLucene.setSearchDao(ebRimGenericSearchDao);

        // parse
        Filter filter = (Filter) parser.parse(testData);
        filterToLucene.encode(filter, "");
        Query query = filterToLucene.getQuery();

        if (query != null) {
            return query.toString();
        } else {
            return "";
        }
    }

    /**
     * Convenience method to get string data from an InputStream
     *
     * @param is InputStream
     * @return String data from the InputStreams
     */
    private String convertStreamToString(InputStream is) {
        /*
           * To convert the InputStream to String we use the BufferedReader.readLine() method. We
           * iterate until the BufferedReader return null which means there's no more data to read.
           * Each line will appended to a StringBuilder and returned as String.
           */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}