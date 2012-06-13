package org.geonetwork.domain.csw202.publication;

/**
 * 
 * Reports the total number of catalogue items modified by a transaction request (i.e, inserted, 
 * updated, deleted). If the client did not specify a requestId, the server may assign one (a 
 * URI value).
 * 
 * @author heikki doeleman
 *
 */
public class TransactionSummary {

	private Integer totalInserted;
	private Integer totalUpdated;
	private Integer totalDeleted;
	
	// TODO must be anyURI
	private String requestId;
}
