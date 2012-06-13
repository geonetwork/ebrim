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
package org.geonetwork.search.ebrim;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.Query;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EbrimGenericSearchDao extends HibernateDaoSupport {
	
	private static Logger log = Logger.getLogger(EbrimGenericSearchDao.class);

    public Query parseQuery(Query query) throws GeoNetworkException {
        FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());

        QueryParser parser =
            new QueryParser("title", fullTextSession.getSearchFactory().getAnalyzer( RegistryObject.class ));
        Query querya = null;
        try {
            querya = parser.parse(query.toString());
        } catch (ParseException e) {
            throw new GeoNetworkException(e);
        }

        return querya;
    }

	@SuppressWarnings("unchecked")
	public List<Object> search(String searchTerm, String[] properties, Class<?>... entities) throws GeoNetworkException {
		FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());
		MultiFieldQueryParser parser = new MultiFieldQueryParser(properties, new StandardAnalyzer());
        org.apache.lucene.search.Query query = null;
		try {
			query = parser.parse(searchTerm);
		} catch (ParseException e) {
			throw new GeoNetworkException(e);
		}
		log.debug(query.toString());
		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, entities);
		List<Object> result = hibQuery.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Object> search(String searchTerm, String[] properties, List<SortField> sortFields, Class<?>... entities)
			throws GeoNetworkException {
		FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());
		MultiFieldQueryParser parser = new MultiFieldQueryParser(properties, new StandardAnalyzer());
		org.apache.lucene.search.Query query = null;
		try {
			query = parser.parse(searchTerm);
		} catch (ParseException e) {
			throw new GeoNetworkException(e);
		}
		log.debug(query.toString());
		org.hibernate.search.FullTextQuery hibQuery = fullTextSession.createFullTextQuery(query, entities);

		if (sortFields != null) {
			SortField[] sortFieldsArray = sortFields.toArray(new SortField[0]);
			org.apache.lucene.search.Sort sort = new Sort(sortFieldsArray);
			hibQuery.setSort(sort);
		}

		List<Object> result = hibQuery.list();
		return result;
	}

    @SuppressWarnings("unchecked")
    public List<RegistryObject> search(Query query, List<SortField> sortFields,
			Class<?>... entities) throws GeoNetworkException {
        
		FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());

        QueryParser parser =
            new QueryParser("title", fullTextSession.getSearchFactory().getAnalyzer( RegistryObject.class ));
        Query querya = null;
        try {
            querya = parser.parse(query.toString());
        } catch (ParseException e) {
            throw new GeoNetworkException(e);
        }
        
		org.hibernate.search.FullTextQuery hibQuery = fullTextSession.createFullTextQuery(querya, entities);

		if (sortFields != null) {
			SortField[] sortFieldsArray = sortFields.toArray(new SortField[0]);
			org.apache.lucene.search.Sort sort = new Sort(sortFieldsArray);
			hibQuery.setSort(sort);
		}

        log.debug("Search lucene query: " + querya.toString());
		List<RegistryObject> result = (List<RegistryObject>) hibQuery.list();

        for(int i = 0; i < result.size(); i++) {
            RegistryObject r = result.get(i);

            if (r instanceof HibernateProxy){
                result.set(i, (RegistryObject) ((HibernateProxy)r).getHibernateLazyInitializer().getImplementation());
            }
        }

        return result;
	}

     @SuppressWarnings("unchecked")
    public List<RegistryObject> search2(Query query, List<SortField> sortFields,
			Class<?>... entities) throws GeoNetworkException {
		FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());
         
       org.hibernate.search.FullTextQuery hibQuery = fullTextSession.createFullTextQuery(query, entities);

		if (sortFields != null) {
			SortField[] sortFieldsArray = sortFields.toArray(new SortField[0]);
			org.apache.lucene.search.Sort sort = new Sort(sortFieldsArray);
			hibQuery.setSort(sort);
		}

        //log.debug("Search lucene query: " + querya.toString());
        log.debug("Search lucene query: " + query.toString());
		List<RegistryObject> result = (List<RegistryObject>) hibQuery.list();

        for(int i = 0; i < result.size(); i++) {
            RegistryObject r = result.get(i);

            if (r instanceof HibernateProxy){
                result.set(i, (RegistryObject) ((HibernateProxy)r).getHibernateLazyInitializer().getImplementation());
            }
        }

		return result;
	}

    @SuppressWarnings("unchecked")
    public List<Object> search(String hql) throws GeoNetworkException {
        List<Object> result = this.getHibernateTemplate().find(hql);

        return result;
    }


	/**
	 * TODO Erik implement some optimization strategy
	 */
	public void optimizeAllLuceneIndices() {
		FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());
		fullTextSession.getSearchFactory().optimize();
	}

}
