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

import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.commons.collections.ListUtils;
import org.geotools.filter.FilterCapabilities;
import org.opengis.filter.And;
import org.opengis.filter.BinaryComparisonOperator;
import org.opengis.filter.BinaryLogicOperator;
import org.opengis.filter.ExcludeFilter;
import org.opengis.filter.Filter;
import org.opengis.filter.FilterVisitor;
import org.opengis.filter.Id;
import org.opengis.filter.IncludeFilter;
import org.opengis.filter.Not;
import org.opengis.filter.Or;
import org.opengis.filter.PropertyIsBetween;
import org.opengis.filter.PropertyIsEqualTo;
import org.opengis.filter.PropertyIsGreaterThan;
import org.opengis.filter.PropertyIsGreaterThanOrEqualTo;
import org.opengis.filter.PropertyIsLessThan;
import org.opengis.filter.PropertyIsLessThanOrEqualTo;
import org.opengis.filter.PropertyIsLike;
import org.opengis.filter.PropertyIsNotEqualTo;
import org.opengis.filter.PropertyIsNull;
import org.opengis.filter.expression.*;
import org.opengis.filter.spatial.BBOX;
import org.opengis.filter.spatial.Beyond;
import org.opengis.filter.spatial.Contains;
import org.opengis.filter.spatial.Crosses;
import org.opengis.filter.spatial.DWithin;
import org.opengis.filter.spatial.Disjoint;
import org.opengis.filter.spatial.Equals;
import org.opengis.filter.spatial.Intersects;
import org.opengis.filter.spatial.Overlaps;
import org.opengis.filter.spatial.Touches;
import org.opengis.filter.spatial.Within;
import org.geonetwork.search.ebrim.filter.queryfields.Field;
import org.geonetwork.search.ebrim.EbrimGenericSearchDao;
import org.geonetwork.search.ebrim.xpath.XPathToken;
import org.geonetwork.search.ebrim.xpath.XPathSimpleParser;
import org.geonetwork.search.ebrim.xpath.XPathPredicate;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.xsd.AbstractValueList;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

import java.util.*;

/**
 * Encodes a OCG filter into a Lucene filter
 *
 * @author Jose
 */
public class FilterToLuceneJoin implements FilterVisitor, ExpressionVisitor {
    private final String MIN_DATE = "0000-00-00";
    private final String MAX_DATE = "9999-99-99";

    // The filter types that this class can encode
    protected FilterCapabilities capabilities = null;

    private EbrimGenericSearchDao searchDao;

    private Stack<List> queries;

    private String rootEntity;

    private boolean processingNotQuery = false;

    // The lucene query
    private Query luceneQuery;

    public Query getLuceneQuery() {
        return luceneQuery;
    }


    public void setSearchDao(EbrimGenericSearchDao searchDao) {
        this.searchDao = searchDao;
    }

    /**
     * Constructor
     */
    public FilterToLuceneJoin() {
        queries = new Stack();
    }

    public List<RegistryObject> getResult() {
        List<Object> result = queries.pop();
        List<RegistryObject> flatResult = new ArrayList<RegistryObject>();

        for (Object o : result) {
            if (o instanceof Object[]) {
                Object[] values = (Object[]) o;

                for (int k = 0; k < values.length; k++) {
                    flatResult.add((RegistryObject) values[k]);
                }

            } else {
                flatResult.add((RegistryObject) o);
            }
        }
        return flatResult;
    }

    /**
     * Checks if results stack is empty (no query was launched, as non
     * valid queriables indicated)
     *
     * @return
     */
    public boolean isEmptyQuery() {
        return ((queries.isEmpty()) || (queries.get(0) == null));
    }

    /**
     * Encodes an OGC filter to a Lucene query string
     *
     * @param filter OGC filter
     * @return Lucene query as a string
     * @throws org.geonetwork.search.ebrim.filter.FilterToLuceneException
     *
     */
    public String encode(Filter filter, String rootEntity) throws FilterToLuceneException {
        // Checks that filter is supported
        if (getCapabilities().fullySupports(filter)) {
            //luceneQuery = (Query) filter.accept(this, null);
            //return luceneQuery.toString();

            this.rootEntity = rootEntity;
            filter.accept(this, null);
            return "";
        } else {
            throw new FilterToLuceneException("Filter type not supported");
        }
    }

    /**
     * Describes the capabilities of this encoder.
     * <p/>
     * <p>
     * Performs lazy creation of capabilities.
     * </p>
     * <p/>
     * If you're subclassing this class, override createFilterCapabilities to declare which
     * filtercapabilities you support. Don't use this method.
     *
     * @return The capabilities supported by this encoder.
     */
    public synchronized final FilterCapabilities getCapabilities() {
        if (capabilities == null) {
            capabilities = createFilterCapabilities();
        }

        return capabilities; // maybe clone? Make immutable somehow
    }

    /**
     * Sets the capabilities of this filter.
     *
     * @return FilterCapabilities for this Filter
     */
    protected FilterCapabilities createFilterCapabilities() {
        FilterCapabilities capabilities = new FilterCapabilities();

        capabilities.addAll(FilterCapabilities.LOGICAL_OPENGIS);
        capabilities.addAll(FilterCapabilities.SIMPLE_COMPARISONS_OPENGIS);
        capabilities.addType(BBOX.class);
        capabilities.addType(PropertyIsBetween.class);
        capabilities.addType(PropertyIsLike.class);
        capabilities.addType(PropertyIsNull.class);
        capabilities.addType(During.class);

        return capabilities;
    }

    public Object visit(ExcludeFilter filter, Object extraData) {
        return extraData;
    }

    public Object visit(IncludeFilter filter, Object extraData) {
        return extraData;
    }

    public Object visit(And filter, Object extraData) {
        try {
            return visit((BinaryLogicOperator) filter, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Object visit(Id filter, Object extraData) {
        return extraData;
    }

    public Object visit(Not filter, Object extraData) {
        return visit((BinaryLogicOperator) filter, "NOT");
    }

    public Object visit(Or filter, Object extraData) {
        try {
            return visit((BinaryLogicOperator) filter, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
      * (non-Javadoc)
      *
      * @see org.opengis.filter.FilterVisitor#visit(org.opengis.filter.PropertyIsBetween,
      * java.lang.Object)
      */
    public Object visit(PropertyIsBetween filter, Object extraData) {
        Expression expr = (Expression) filter.getExpression();
        Expression lowerbounds = (Expression) filter.getLowerBoundary();
        Expression upperbounds = (Expression) filter.getUpperBoundary();

        Field fld = (Field) expr.accept(this, extraData);
        Term lowerTerm = new Term(fld.getFieldName(), lowerbounds.toString());
        Term upperTerm = new Term(fld.getFieldName(), upperbounds.toString());

        try {
            makeLuceneQuery(fld.process(new RangeQuery(lowerTerm, upperTerm, true)));

        } catch (GeoNetworkException e) {
            e.printStackTrace();
        }

        return extraData;
    }

    /*
      * (non-Javadoc)
      *
      * @see org.opengis.filter.FilterVisitor#visit(org.opengis.filter.PropertyIsEqualTo,
      * java.lang.Object)
      */
    public Object visit(PropertyIsEqualTo filter, Object extraData) {
        try {
            return visitBinaryComparisonOperator((BinaryComparisonOperator) filter, extraData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /*
      * (non-Javadoc)
      *
      * @see org.opengis.filter.FilterVisitor#visit(org.opengis.filter.PropertyIsNotEqualTo,
      * java.lang.Object)
      */
    public Object visit(PropertyIsNotEqualTo filter, Object extraData) {
        try {
            return visitBinaryComparisonOperator((BinaryComparisonOperator) filter, extraData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return extraData;
    }

    /*
      * (non-Javadoc)
      *
      * @see org.opengis.filter.FilterVisitor#visit(org.opengis.filter.PropertyIsGreaterThan,
      * java.lang.Object)
      */
    public Object visit(PropertyIsGreaterThan filter, Object extraData) {
        try {
            return visitBinaryComparisonOperator((BinaryComparisonOperator) filter, extraData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return extraData;
    }

    /*
      * (non-Javadoc)
      *
      * @see
      * org.opengis.filter.FilterVisitor#visit(org.opengis.filter.PropertyIsGreaterThanOrEqualTo,
      * java.lang.Object)
      */
    public Object visit(PropertyIsGreaterThanOrEqualTo filter, Object extraData) {
        try {
            return visitBinaryComparisonOperator((BinaryComparisonOperator) filter, extraData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return extraData;
    }

    /*
      * (non-Javadoc)
      *
      * @see org.opengis.filter.FilterVisitor#visit(org.opengis.filter.PropertyIsLessThan,
      * java.lang.Object)
      */
    public Object visit(PropertyIsLessThan filter, Object extraData) {
        try {
            return visitBinaryComparisonOperator((BinaryComparisonOperator) filter, extraData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return extraData;
    }

    /*
      * (non-Javadoc)
      *
      * @see org.opengis.filter.FilterVisitor#visit(org.opengis.filter.PropertyIsLessThanOrEqualTo,
      * java.lang.Object)
      */
    public Object visit(PropertyIsLessThanOrEqualTo filter, Object extraData) {
        try {
            return visitBinaryComparisonOperator((BinaryComparisonOperator) filter, extraData);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return extraData;
    }

    /*
      * (non-Javadoc)
      *
      * @see org.opengis.filter.FilterVisitor#visit(org.opengis.filter.PropertyIsLike,
      * java.lang.Object)
      */
    public Object visit(PropertyIsLike filter, Object extraData) {
        char esc = filter.getEscape().charAt(0);
        char multi = filter.getWildCard().charAt(0);
        char single = filter.getSingleChar().charAt(0);

        String literal = filter.getLiteral();
        if (literal.startsWith("*")) literal = literal.substring(1);
        Expression att = filter.getExpression();

        // Convert characters: wildcard and singlechar
        literal = literal.replace(multi, '*');
        literal = literal.replace(single, '?');

        Field fld = (Field) att.accept(this, extraData);
        Term term = new Term(fld.getFieldName(), literal.toString());

        //return fld.process(new WildcardQuery(term));
        try {
            makeLuceneQuery(fld.process(new WildcardQuery(term)));

        } catch (GeoNetworkException e) {
            e.printStackTrace();
        }

        return extraData;
    }

    /*
      * (non-Javadoc)
      *
      * @see org.opengis.filter.FilterVisitor#visit(org.opengis.filter.PropertyIsNull,
      * java.lang.Object)
      */
    public Object visit(PropertyIsNull filter, Object extraData) {
        Expression att = filter.getExpression();
        List<XPathToken> tokens = new XPathSimpleParser().parse(att.toString());

        Class classz = null;
        String hql = "";
        String propertyLeft = "";
        String propertyLeft2 = "";

        // Process expression
        boolean firstToken = true;
        boolean prevCollection = false;
        int aliasIndex = 1;
        String whereCondition = "";

        for (XPathToken token : tokens) {
            if (firstToken) {
                classz = TypeNamesMapper.getTypeNameClass(token.getFullName());
                hql = "from " + classz.getName() + " l1 ";
                firstToken = false;
            } else {
                String value = "";

                if (token.getType() == XPathToken.XPathTokenType.XPATH_ELEMENT) {
                    value = EbRimToModelPropertiesMapper.getPropertyName(token.getFullName());
                } else {
                    value = token.getName();
                }

                java.lang.reflect.Field ff = getDeclaredField(value, classz);

                if (ff != null) {
                    // Collection property
                    if ((ff.getType().equals(Set.class)) || ((ff.getType().equals(List.class)))) {
                        if ((!prevCollection) && (!propertyLeft.equals("")))
                            hql += " join l" + aliasIndex + "." + propertyLeft + value + " l" + (++aliasIndex);
                        else
                            hql += " join l" + aliasIndex + "." + value + " l" + (++aliasIndex);

                        // Process predicate
                        if (token.hasPredicate()) {
                            XPathPredicate pred = token.getPredicate();

                            Map<String, String> values = pred.getValues();
                            Set<String> keySet = values.keySet();
                            for (String key : keySet) {
                                String f = key;
                                String v = values.get(key);

                                if (whereCondition.equals(""))
                                    whereCondition += "l" + aliasIndex + "." + f + " = '" + v + "'";
                                else
                                    whereCondition += " and " + "l" + aliasIndex + "." + f + " = '" + v + "'";
                            }
                        }

                        classz = TypeNamesMapper.getTypeNameClass(token.getFullName());
                        prevCollection = true;

                    // Simple property
                    } else {
                        if (ff.getType().getSuperclass().equals(AbstractValueList.class)) {
                            //hql += " join l" + aliasIndex +".valueList.values l" + (++aliasIndex);
                            propertyLeft += value + ".";
                            propertyLeft2 = "value.";
                            classz = TypeNamesMapper.getTypeNameClass(token.getFullName());
                            prevCollection = false;
                        } else {

                            prevCollection = false;
                            propertyLeft += value + ".";
                            propertyLeft2 = propertyLeft;
                            classz = ff.getType();
                        }
                    }
                }
            }
        }

        if (propertyLeft2.length() > 0) propertyLeft2 = propertyLeft2.substring(0, propertyLeft2.length() - 1);

        hql += " where ((l" + aliasIndex + "." + propertyLeft2 + " is null) or (l" + aliasIndex + "." + propertyLeft2 + " = ''))";

        if (!whereCondition.equals("")) hql += " and " + whereCondition;

        try {
            List<Object> result = searchDao.search(hql);
            System.out.println("result: " + result.size());
            queries.add(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return extraData;
    }

    private java.lang.reflect.Field getDeclaredField(String field, Class classz) {
        java.lang.reflect.Field ff = null;

        try {
            ff = classz.getDeclaredField(field);
        } catch (Exception ee) {
            try {
                if (classz.getSuperclass() != null) {
                    ff = getDeclaredField(field, classz.getSuperclass());
                }

            } catch (Exception e) {

            }
        }

        return ff;
    }

    /*
      * (non-Javadoc)
      *
      * @see org.opengis.filter.FilterVisitor#visit(org.opengis.filter.spatial.BBOX,
      * java.lang.Object)
      */
    public Object visit(BBOX filter, Object extraData) {
        Expression left = (Expression) filter.getExpression1();     // Property name
        Expression right = (Expression) filter.getExpression2();    // Bounding box

        Geometry bbox = (Geometry) ((Literal) right).getValue();
        Coordinate[] coords = bbox.getEnvelope().getCoordinates();

        double westBL = coords[0].x + 360;
        double eastBL = coords[2].x + 360;
        double southBL = coords[0].y + 360;
        double northBL = coords[2].y + 360;

        BooleanQuery bboxQuery = new BooleanQuery();

        PropertyResolver propertyResolver = PropertyResolverFactory.getPropertyResolver(left.toString());

        String lucenePropertyPrefix = propertyResolver.resolveProperty(rootEntity).getFieldName() + "."; // "slots.basicExtensionValueList.values.value.";

        Term eastLowerTerm = new Term(lucenePropertyPrefix + "upperCorner.longitude", new Double(westBL).toString());
        Term eastUpperTerm = new Term(lucenePropertyPrefix + "upperCorner.longitude", new Double(180 + 360).toString());
        RangeQuery eastRangeQuery = new RangeQuery(eastLowerTerm, eastUpperTerm, true);

        Term westLowerTerm = new Term(lucenePropertyPrefix + "lowerCorner.longitude", new Double(-180 + 360).toString());
        Term westUpperTerm = new Term(lucenePropertyPrefix + "lowerCorner.longitude", new Double(eastBL).toString());
        RangeQuery westRangeQuery = new RangeQuery(westLowerTerm, westUpperTerm, true);

        Term northLowerTerm = new Term(lucenePropertyPrefix + "upperCorner.latitude", new Double(southBL).toString());
        Term northUpperTerm = new Term(lucenePropertyPrefix + "upperCorner.latitude", new Double(90 + 360).toString());
        RangeQuery northRangeQuery = new RangeQuery(northLowerTerm, northUpperTerm, true);

        Term southLowerTerm = new Term(lucenePropertyPrefix + "lowerCorner.latitude", new Double(-90 + 360).toString());
        Term southUpperTerm = new Term(lucenePropertyPrefix + "lowerCorner.latitude", new Double(northBL).toString());
        RangeQuery southRangeQuery = new RangeQuery(southLowerTerm, southUpperTerm, true);

        bboxQuery.add(eastRangeQuery, BooleanClause.Occur.MUST);
        bboxQuery.add(westRangeQuery, BooleanClause.Occur.MUST);
        bboxQuery.add(northRangeQuery, BooleanClause.Occur.MUST);
        bboxQuery.add(southRangeQuery, BooleanClause.Occur.MUST);

        try {
            makeLuceneQuery(bboxQuery);
        } catch (Exception e) {
            return null;
        }

        return bboxQuery;
    }

    /**
     * @param filter
     * @param extraData
     * @return
     */
    protected Object visit(BinaryLogicOperator filter, Object extraData) {
        BooleanQuery booleanQuery = new BooleanQuery();

        Iterator<?> list = filter.getChildren().iterator();

        if (!(filter instanceof Not)) {
            /*BooleanClause.Occur occur;

            if ((extraData != null) && (extraData == "NOT"))
                occur = (filter instanceof And) ? BooleanClause.Occur.SHOULD : BooleanClause.Occur.MUST;
            else
                occur = (filter instanceof And) ? BooleanClause.Occur.MUST : BooleanClause.Occur.SHOULD;*/

            while (list.hasNext()) {
                ((Filter) list.next()).accept(this, null);
                //Query itemQuery = (Query) ((Filter)

                //booleanQuery.add(itemQuery, occur);
            }

            // return booleanQuery;


            int numTerms = filter.getChildren().size();

            if (numTerms > 1) {
                int i = 0;

                while (i < numTerms) {
                    i = i + 2;
                    List<Object> result = new ArrayList<Object>();

                    if (filter instanceof And) {
                        List<Object> l1 = (List<Object>) queries.pop();
                        List<Object> l2 = (List<Object>) queries.pop();

                        // check null queries (due to invalid fields in query are ignored)
                        if ((l1 == null) && (l2 == null)) {
                            queries.push(null);
                            continue;
                        } else if ((l1 == null) && (l2 != null)) {
                            queries.push(l2);
                            continue;
                        } else if ((l1 != null) && (l2 == null)) {
                            queries.push(l2);
                            continue;
                        } else {
                            if ((l1.isEmpty()) || (l2.isEmpty())) {
                                queries.push(result);
                                continue;
                            }
                        }

                        boolean isJoinData1 = false;
                        boolean isJoinData2 = false;

                        // Check if data comes from hql join
                        if ((!l1.isEmpty()) && (l1.get(0) instanceof Object[])) {
                            isJoinData1 = true;
                        }

                        if ((!l2.isEmpty()) && (l2.get(0) instanceof Object[])) {
                            isJoinData2 = true;
                        }

                        if ((isJoinData1) && (isJoinData2)) {
                            //TODO: Manage this


                        } else if (isJoinData1) {
                            Iterator it = l1.iterator();
                            while (it.hasNext()) {
                                Object[] value = (Object[]) it.next();

                                for (int k = 0; k < value.length; k++) {
                                    if (l2.contains(value[k])) {
                                        result.add(value[k]);
                                        break;
                                    }
                                }
                            }

                        } else if (isJoinData2) {
                            Iterator it = l2.iterator();
                            while (it.hasNext()) {
                                Object[] value = (Object[]) it.next();

                                for (int k = 0; k < value.length; k++) {
                                    if (l1.contains(value[k])) {
                                        result.add(value[k]);
                                        break;
                                    }
                                }
                            }
                        } else {
                            result = ListUtils.intersection(l1, l2);
                        }

                        queries.push(result);

                    } else if (filter instanceof Or) {

                        List<Object> l1 = (List<Object>) queries.pop();
                        List<Object> l2 = (List<Object>) queries.pop();

                        if ((l1 == null) && (l2 == null)) {
                            queries.push(null);

                        } else if ((l1 == null) && (l2 != null)) {
                            queries.push(l2);

                        } else if ((l1 != null) && (l2 == null)) {
                            queries.push(l2);

                        } else {
                            result = ListUtils.union(l1, l2);
                            queries.push(result);
                        }
                    }
                }
            }

        } else {
            processingNotQuery = true;
            visit((BinaryLogicOperator) filter.getChildren().get(0), extraData);
            processingNotQuery = false;
        }

        return extraData;
    }

    /**
     * Process a BinaryComparisonOperator
     *
     * @param filter    A binary comparison operator
     * @param itemQuery
     * @return Lucene query
     * @throws Exception
     */
    protected Object visitBinaryComparisonOperator(BinaryComparisonOperator filter, Object itemQuery) throws Exception {
        Expression left = filter.getExpression1();
        Expression right = filter.getExpression2();

        if (right instanceof Function) {
            return right.accept(this, itemQuery);
        } else if (right instanceof PropertyName) {

            Field leftFld = (Field) left.accept(this, itemQuery);
            Field rightFld = (Field) right.accept(this, itemQuery);
            makeHqlQuery(left, right);

            return itemQuery;
        }

        //List<FieldMappingInfo> fieldMappingInfo = (List<FieldMappingInfo>) left.accept(this, itemQuery);

        Field fld = (Field) left.accept(this, itemQuery);

        // If field it's not valid (don't use in query: add a dummy null query)
        if (fld == null) {
            queries.add(null);
            return itemQuery;
        }

        BooleanQuery boolQuery = new BooleanQuery();
        Term term = new Term(fld.getFieldName(), QueryParser.escape(right.toString()));

        Query q = null;

        if (filter instanceof PropertyIsEqualTo) {
            q = fld.process(new TermQuery(term));

        } else if (filter instanceof PropertyIsLessThan) {
            q = fld.process(new RangeQuery(new Term(fld.getFieldName(), MIN_DATE), term, false));
            //q = fld.process(new ConstantScoreRangeQuery(fld.getFieldName(), null, QueryParser.escape(right.toString()), true, true));

        } else if (filter instanceof PropertyIsLessThanOrEqualTo) {
            q = fld.process(new RangeQuery(new Term(fld.getFieldName(), MIN_DATE), term, true));
            //q = fld.process(new ConstantScoreRangeQuery(fld.getFieldName(), null, QueryParser.escape(right.toString()), true, true));

        } else if (filter instanceof PropertyIsGreaterThan) {
            q = fld.process(new RangeQuery(term, new Term(fld.getFieldName(), MAX_DATE), false));
            //q = fld.process(new ConstantScoreRangeQuery(fld.getFieldName(), QueryParser.escape(right.toString()), null, true, true));

        } else if (filter instanceof PropertyIsGreaterThanOrEqualTo) {
            q = fld.process(new RangeQuery(term, new Term(fld.getFieldName(), MAX_DATE), true));
            //q = fld.process(new ConstantScoreRangeQuery(fld.getFieldName(), QueryParser.escape(right.toString()), null, true, true));


        } else if (filter instanceof PropertyIsNotEqualTo) {
            boolQuery.add(new TermQuery(term), BooleanClause.Occur.MUST_NOT);
            q = fld.process(boolQuery);
        }

        makeLuceneQuery(q);

        return itemQuery;
    }

    /**
     * Not implemented
     */
    public Object visit(Beyond filter, Object extraData) {
        return extraData;
    }

    public Object visit(Contains filter, Object extraData) {
        return extraData;
    }

    public Object visit(Crosses arg0, Object extraData) {
        return extraData;
    }

    public Object visit(Disjoint arg0, Object extraData) {
        return extraData;
    }

    public Object visit(DWithin arg0, Object extraData) {
        return extraData;
    }

    public Object visit(Equals arg0, Object extraData) {
        return extraData;
    }

    public Object visit(Intersects arg0, Object extraData) {
        return extraData;
    }

    public Object visit(Overlaps arg0, Object extraData) {
        return extraData;
    }

    public Object visit(Touches arg0, Object extraData) {
        return extraData;
    }

    public Object visit(Within arg0, Object extraData) {
        return extraData;
    }

    public Object visitNullFilter(Object extraData) {
        return extraData;
    }

    // Expressions visitor
    public Object visit(NilExpression nilExpression, Object o) {
        return null;
    }

    public Object visit(Add add, Object o) {
        return null;
    }

    public Object visit(Divide divide, Object o) {
        return null;
    }

    public Object visit(Function function, Object o) {
        if (isSupportedFunction(function.getName())) {
            return function.evaluate(o);
        } else {
            return null;
        }
    }

    public Object visit(Literal literal, Object o) {
        return null;
    }

    public Object visit(Multiply multiply, Object o) {
        return null;
    }

    public Object visit(PropertyName propertyName, Object o) {
        String name = propertyName.getPropertyName();
        PropertyResolver propertyResolver = PropertyResolverFactory.getPropertyResolver(name);

        return propertyResolver.resolveProperty(rootEntity);
    }

    public Object visit(Subtract subtract, Object o) {
        return null;
    }

    /**
     * Checks if a filter function is supported
     * <p/>
     * For now, only During function, see org.geonetwork.search.ebrim.filter.During
     *
     * @param functionName Name of the function to check
     * @return boolean indicating if the function is supported
     */
    private boolean isSupportedFunction(String functionName) {
        if (functionName.equalsIgnoreCase("DURING"))
            return true;
        else
            return false;
    }


    private void makeHqlQuery(Expression leftFld, Expression rightFld) throws GeoNetworkException {

        String hql = ""; // = "select a1 from ";

        Class classzLeft = null;
        Class classzRight = null;
        Class classz = null;
        String propertyLeft = "";
        String propertyRight = "";

        // Parse XPath expressions
        List<XPathToken> leftTokens = new XPathSimpleParser().parse(leftFld.toString());
        List<XPathToken> rightTokens = new XPathSimpleParser().parse(rightFld.toString());

        // Process left expression
        boolean firstToken = true;
        boolean prevCollection = false;
        boolean leftJoin = false;

        for (XPathToken token : leftTokens) {
            if (firstToken) {
                classzLeft = TypeNamesMapper.getTypeNameClass(token.getFullName());
                classz = classzLeft;
                hql = "from " + classzLeft.getName() + " l1 ";
                firstToken = false;
            } else {
                String value = "";

                if (token.getType() == XPathToken.XPathTokenType.XPATH_ELEMENT) {
                    value = EbRimToModelPropertiesMapper.getPropertyName(token.getName());
                } else {
                    value = token.getName();
                }

                if (prevCollection) {
                    prevCollection = false;
                    classz = TypeNamesMapper.getTypeNameClass(value);
                    continue;
                }

                java.lang.reflect.Field ff = null;

                try {
                    ff = classz.getDeclaredField(value);
                } catch (Exception ee) {
                    try {
                        ff = classz.getSuperclass().getDeclaredField(value);
                    } catch (Exception e) {

                    }
                }

                if (ff != null) {
                    if (ff.getType().equals(Set.class)) {
                        hql += "join l1." + value + " l2";
                        prevCollection = true;
                        leftJoin = true;

                    } else {
                        propertyLeft += value + ".";
                        classz = ff.getClass();

                    }
                }
            }
        }

        if (propertyLeft.length() > 0) propertyLeft = propertyLeft.substring(0, propertyLeft.length() - 1);


        // Process right expression
        firstToken = true;
        prevCollection = false;
        boolean rightJoin = false;
        for (XPathToken token : rightTokens) {
            if (firstToken) {
                classzRight = TypeNamesMapper.getTypeNameClass(token.getFullName());
                hql += ", " + classzRight.getName() + " r1 ";
                firstToken = false;
            } else {
                String value = "";

                if (token.getType() == XPathToken.XPathTokenType.XPATH_ELEMENT) {
                    value = EbRimToModelPropertiesMapper.getPropertyName(token.getName());
                } else {
                    value = token.getName();
                }

                if (prevCollection) {
                    prevCollection = false;
                    classz = TypeNamesMapper.getTypeNameClass(value);
                    continue;
                }

                java.lang.reflect.Field ff = null;

                try {
                    ff = classz.getDeclaredField(value);
                } catch (Exception ee) {
                    try {
                        ff = classz.getSuperclass().getDeclaredField(value);
                    } catch (Exception e) {

                    }
                }

                if (ff != null) {
                    if (ff.getType().equals(Set.class)) {
                        hql += "join r1." + value + " r2";
                        prevCollection = true;
                        rightJoin = true;

                    } else {
                        propertyRight += value + ".";
                        classz = ff.getClass();

                    }
                }
            }
        }

        if (propertyRight.length() > 0) propertyRight = propertyRight.substring(0, propertyRight.length() - 1);

        hql += " where " + (leftJoin ? "l2" : "l1") + "." + propertyLeft + " = " + (rightJoin ? "r2" : "r1") + "." + propertyRight;

        System.out.println("Hql: " + hql);

        //hql = "from org.geonetwork.domain.ebrim.informationmodel.core.RegistryPackage r join r.registryObjectList s where s.id=r.id";
        List<Object> result = searchDao.search(hql);
        System.out.println("result: " + result.size());

        queries.add(result);
    }

    private void makeLuceneQuery(Query query) throws GeoNetworkException {
        List<RegistryObject> result = null;
        try {
            if (processingNotQuery) {
                BooleanQuery boolQuery = new BooleanQuery();
                boolQuery.add(new MatchAllDocsQuery(),  BooleanClause.Occur.SHOULD );
                boolQuery.add(searchDao.parseQuery(query), BooleanClause.Occur.MUST_NOT);
                result = searchDao.search2(boolQuery, null, RegistryObject.class);
            } else {
                result = searchDao.search2(searchDao.parseQuery(query), null, RegistryObject.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        queries.add(result);
    }
}