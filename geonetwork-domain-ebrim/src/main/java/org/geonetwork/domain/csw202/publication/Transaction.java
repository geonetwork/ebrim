package org.geonetwork.domain.csw202.publication;

import org.geonetwork.domain.csw202.discovery.RequestBase;

/**
 * Users may insert, update, or delete catalogue entries. If the verboseResponse attribute has 
 * the value "true", then one or more csw:InsertResult elements must be included in the response.
 * 
 * @author heikki doeleman
 *
 */
public class Transaction extends RequestBase {

	// the next 3 are in a choice (either is present)
	
	private Insert insert;
	
	private Update update;
	
	private Delete delete;
	
	private Boolean verboseResponse;

	// TODO must be anyURI
	private String requestId;

	public Insert getInsert() {
		return insert;
	}

	public void setInsert(Insert insert) {
		this.insert = insert;
	}

	public Update getUpdate() {
		return update;
	}

	public void setUpdate(Update update) {
		this.update = update;
	}

	public Delete getDelete() {
		return delete;
	}

	public void setDelete(Delete delete) {
		this.delete = delete;
	}

	public Boolean getVerboseResponse() {
		return verboseResponse;
	}

	public void setVerboseResponse(Boolean verboseResponse) {
		this.verboseResponse = verboseResponse;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	
}
