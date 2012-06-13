package org.geonetwork.domain.csw202.publication;

import java.util.List;

/**
 * The response for a transaction request that was successfully completed. If the transaction 
 * failed for any reason, a service exception report indicating a TransactionFailure is returned
 * instead.
 * 
 * @author heikki doeleman
 *
 */
public class TransactionResponse {

	private TransactionSummary transactionSummary;
	
	private List<InsertResult> insertResults;
	
	private String version;

	public TransactionSummary getTransactionSummary() {
		return transactionSummary;
	}

	public void setTransactionSummary(TransactionSummary transactionSummary) {
		this.transactionSummary = transactionSummary;
	}

	public List<InsertResult> getInsertResults() {
		return insertResults;
	}

	public void setInsertResults(List<InsertResult> insertResults) {
		this.insertResults = insertResults;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
