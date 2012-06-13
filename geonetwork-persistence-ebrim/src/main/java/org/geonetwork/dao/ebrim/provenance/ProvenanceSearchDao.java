package org.geonetwork.dao.ebrim.provenance;

import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.provenance.EmailAddress;
import org.hibernate.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ProvenanceSearchDao extends HibernateDaoSupport {
	// private static final String[] FIELD_NAMES = new String[] { "EmailAddress.",
	// "EmailAddress.type" };

	/**
	 * This search uses a Lucene query builder.
	 * 
	 * 
	 * @param searchTerm
	 * @return
	 * @throws GeoNetworkException
	 */
	@SuppressWarnings("unchecked")
	public List<EmailAddress> searchEmailAddressLucene(final String searchTerm) throws GeoNetworkException {
		FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());
		MultiFieldQueryParser parser = new MultiFieldQueryParser(new String[] { "address.value", "type.value" },
				new StandardAnalyzer());
		org.apache.lucene.search.Query query = null;
		try {
			query = parser.parse(searchTerm);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new GeoNetworkException(e);
		}
		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, EmailAddress.class);
		List<EmailAddress> result = hibQuery.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<EmailAddress> searchEmailAddressHql(final String searchTerm) {
		FullTextSession fullTextSession = Search.getFullTextSession(this.getSession());
		String hqlQuery = "from EmailAddress e where e.address.value like '%" + searchTerm + "%' "
				+ "or e.type.value like '%" + searchTerm + "%' ";
		Query hibQuery = fullTextSession.createQuery(hqlQuery);
		List<EmailAddress> result = hibQuery.list();
		return result;
	}

	/**
	 * This search uses hql
	 * 
	 * 
	 * @param searchTerm
	 * @return
	 */
	// @SuppressWarnings("unchecked")
	// public List<EmailAddress> searchEmailAddressHql(String searchTerm) {
	// return result;
	// }
}
