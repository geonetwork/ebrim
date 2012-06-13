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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.geonetwork.domain.csw202.discovery.Query;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.filter110.sort.SortBy;
import org.geonetwork.domain.filter110.sort.SortProperty;
import org.geonetwork.domain.filter110.sort.SortOrder;
import org.geonetwork.domain.filter110.expression.PropertyName;
import org.geonetwork.domain.xsd.QName;
import org.geonetwork.search.ebrim.SearchEngine;
import org.geonetwork.search.ebrim.SearchEngineException;
import org.geonetwork.search.ebrim.filter.queryfields.Field;
import org.geonetwork.search.ebrim.query.QueryResult;
import org.geonetwork.search.ebrim.query.QueryParameters;
import org.geonetwork.gaap.client.GaapServicesClient;
import org.geotools.xml.Configuration;
import org.geotools.xml.Parser;
import org.opengis.filter.Filter;
import org.xml.sax.SAXException;
import org.apache.lucene.search.SortField;
import org.apache.log4j.Logger;

/**
 * Search engine using OGC Filter expressions
 *
 * @author Jose
 */
public class FilterSearchEngine extends SearchEngine {
    private static Logger log = Logger.getLogger(FilterSearchEngine.class);

    private GaapServicesClient gaapClient;

    public void setGaapClient(GaapServicesClient gaapClient) {
        this.gaapClient = gaapClient;
    }

    public QueryResult query(Query query, QueryParameters params) throws SearchEngineException {
        try {
            List<RegistryObject> data = null;

            //TODO convert geonetwork-ebrim Filter to opengid Filter
            log.debug("FilterSearchEngine: start");

            String queryFilter = null;
            if (query.getConstraint() != null) queryFilter = query.getConstraint().getFilter();
            log.debug("FilterSearchEngine: queryFilter");

            // Process typeNames variables in filter
            List<QName> typeNames = query.getTypeNames();

            // retrieve all objects
            if (queryFilter == null) {
                data = coreDao.loadAllRegistryObject();

            } else {

                FilterTypeNamesProcessor typeNamesProcessor =
                        new FilterTypeNamesProcessor(queryFilter, typeNames);
                queryFilter = typeNamesProcessor.process();

                data = retrieveData(query, queryFilter, typeNames);


            }

            // Process typeNames
            data = filterTypeNames(data, params.getTypeNameList());

            log.debug("Number of retrieved metadata:" + data.size());
            log.debug("User tokena:" + params.getUserUuid());
            log.debug("Number of retrieved metadata (afterPermissions:" + data.size());

            data = applyPermissions(data, params.getUserUuid());

            return processData(data, params);

        } catch (Exception ex) {
            throw new SearchEngineException(ex);
        }
    }

    /**
     * Filter the metadata results based on user permissions
     *
     * @param data List of metadata to filter
     * @param user User to use. If not set only public metadata is returned
     * @return Filtered metadata based on permissions
     * @throws SearchEngineException
     */
    private List<RegistryObject> applyPermissions(List<RegistryObject> data, String user) throws SearchEngineException {
        Set<String> metadataUuids = new HashSet<String>();
        List<RegistryObject> filteredData = new ArrayList<RegistryObject>();

        // Get iso metadata identiers
        for (RegistryObject ro : data) {
            if (ro.getRegistryObjectListInverse() != null) {
                String iso19139Id = ro.getRegistryObjectListInverse().getIso19139Id();

                metadataUuids.add(iso19139Id);
            }
        }

        try {
            // Filter  iso metadata identifiers using gaap service
            List<String> filteredmetadataUuids = gaapClient.filterMetadata(new ArrayList<String>(metadataUuids), user);

            // Return only the allowed RegistryObjects
            for (RegistryObject ro : data) {
                if (ro.getRegistryObjectListInverse() != null) {
                    String iso19139Id = ro.getRegistryObjectListInverse().getIso19139Id();
                    if (filteredmetadataUuids.contains(iso19139Id)) {
                        filteredData.add(ro);
                    }
                }
            }

            return filteredData;

        } catch (Exception e) {
            e.printStackTrace();
            throw new SearchEngineException(e);
        }
    }

    /**
     * Get lucene sort fields
     */
    private List<SortField> getLuceneSortFields(SortBy sortBy) {
        if ((sortBy == null) || sortBy.getSortPropertyList().isEmpty()) return null;

        List<SortProperty> sortProperties = sortBy.getSortPropertyList();
        List<SortField> luceneSortFields = new ArrayList<SortField>();

        for (SortProperty s : sortProperties) {
            PropertyName property = s.getPropertyName();
            String propertyName = property.getValue();

            PropertyResolver pr = PropertyResolverFactory.getPropertyResolver(propertyName);
            Field sortPropertyField = pr.resolveProperty("");
            String propertyLuceneName = sortPropertyField.getFieldName();
            SortField sf = new SortField(propertyLuceneName, (s.getSortOrder() == SortOrder.DESC));
            luceneSortFields.add(sf);
        }

        return luceneSortFields;
    }

    /**
     * Process data returned by search
     *
     * @param data   Data returned by search
     * @param params Parameters of query
     * @return QueryResults with data and info of the search
     */
    private QueryResult processData(List<RegistryObject> data, QueryParameters params) {
        QueryResult queryResult = new QueryResult();

        // Process typeNames
        //List<RegistryObject> processedData = filterTypeNames(data, params.getTypeNameList());
        List<RegistryObject> processedData = data;

        // Set number of records matched
        queryResult.setNumberOfRecordsMatched(processedData.size());

        // Set number of records returned and data to return
        int maxRecords = params.getMaxRecords();
        int startPosition = params.getStartPosition();

        if ((startPosition + maxRecords) >= processedData.size()) {
            queryResult.setNumberOfRecordsReturned(processedData.size() - startPosition + 1);
            queryResult.setData(processedData.subList(startPosition - 1, processedData.size()));
            queryResult.setNextRecord(0);

        } else {
            queryResult.setNumberOfRecordsReturned(maxRecords);
            queryResult.setData(processedData.subList(startPosition - 1, startPosition - 1 + maxRecords));
            queryResult.setNextRecord(startPosition + maxRecords + 1);
        }

        return queryResult;
    }

    /**
     * Filter result data to return using typeNames defined
     *
     * @param data
     * @param typeNames
     * @return Search elements that are instances of requested typeNames
     */
    private List<RegistryObject> filterTypeNames(List<RegistryObject> data, List<String> typeNames) {
        List<RegistryObject> typeNamesFilteredData = new ArrayList<RegistryObject>();

        if (((typeNames == null) || (typeNames.isEmpty()))) {
            typeNamesFilteredData = data;

        } else {
            for (String typeName : typeNames) {
                Class<?> typeNameClass = TypeNamesMapper.getTypeNameClass(typeName);

                if (typeNameClass != null) {
                    for (RegistryObject reg : data) {
                        if (typeNameClass.isInstance(reg)) {
                            if (!typeNamesFilteredData.contains(reg))
                                typeNamesFilteredData.add(reg);
                        }
                    }
                }
            }
        }

        return typeNamesFilteredData;
    }

    /**
     * Parses a a query that contains the filter document and gets a Filter
     *
     * @param filterQuery XML filter document according OGC Filter specification
     * @return Filter
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    private Filter getFilter(String filterQuery) throws IOException, SAXException, ParserConfigurationException {
        Configuration configuration = new org.geotools.filter.v1_1.OGCConfiguration();

        Parser parser = new Parser(configuration);

        filterQuery = filterQuery.replaceAll("<ogc:", "<");
        filterQuery = filterQuery.replaceAll("</ogc:", "</");

        // the xml instance document above
        InputStream xml = new ByteArrayInputStream(filterQuery.getBytes("UTF-8"));

        // parse the document into a Filter
        return (Filter) parser.parse(xml);
    }

    /**
     * Executes the query to retrieve the data.
     * Uses different FilterVisitor depending on the type of Filter
     *
     * @param queryFilter
     * @param typeNames
     * @return
     * @throws Exception
     */
    private List<RegistryObject> retrieveData(Query query, String queryFilter, List<QName> typeNames) throws Exception {
        List<RegistryObject> data = null;

        if (useJoinFilter(queryFilter)) {
            // Process filter to get lucene query
            FilterToLuceneJoin filterLucene = new FilterToLuceneJoin();
            filterLucene.setSearchDao(searchDao);
            Filter filter = getFilter(queryFilter);

            if ((typeNames != null) && (typeNames.size() == 1))
                filterLucene.encode(filter, typeNames.get(0).getValue());
            else
                filterLucene.encode(filter, "");

            if (!filterLucene.isEmptyQuery()) {
                data = filterLucene.getResult();
            } else {
                data = coreDao.loadAllRegistryObject();
            }
        } else {
            // Process filter to get lucene query
            FilterToLucene filterLucene = new FilterToLucene();
            filterLucene.setSearchDao(searchDao);
            Filter filter = getFilter(queryFilter);

            //List<SortField> luceneSortFields = getLuceneSortFields(query.getSortBy());

            if ((typeNames != null) && (typeNames.size() == 1))
                filterLucene.encode(filter, typeNames.get(0).getValue());
            else
                filterLucene.encode(filter, "");

            if (!filterLucene.isEmptyQuery()) {
                data = filterLucene.getResult();
            } else {
                data = coreDao.loadAllRegistryObject();
            }
        }

        return data;
    }

    /**
     * Checks the filter expression to decide if use the FilterVisitor with Joins (Lucene/Hql)
     * or the FilterVIsitor without  joins (Lucene)
     *
     * @param queryFilter
     * @return
     */
    private boolean useJoinFilter(String queryFilter) {

        queryFilter = queryFilter.replaceAll("<ogc:", "<");
        queryFilter = queryFilter.replaceAll("</ogc:", "</");

        if (queryFilter.contains("<PropertyIsNull>")) {
            return true;
        } else {
            if (queryFilter.matches("<PropertyName>(.)*</PropertyName>(\\W)*<PropertyName>(.)*</PropertyName>")) {
                return true;
            } else {
                return false;
            }
        }
    }

}
