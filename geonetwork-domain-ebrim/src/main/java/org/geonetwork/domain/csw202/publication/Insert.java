package org.geonetwork.domain.csw202.publication;

import java.util.List;

/**
 * Submits one or more records to the catalogue. The representation is defined by the application
 * profile. The handle attribute may be included to specify a local identifier for the action (it 
 * must be unique within the context of the transaction).
 * 
 * @author heikki doeleman
 *
 */
public class Insert {

	private List<Object> records;
	
	// TODO must be anyURI
	private String typeName;
	
	// TODO this is xsd:ID
	private String handle;

	public List<Object> getRecords() {
		return records;
	}

	public void setRecords(List<Object> records) {
		this.records = records;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	
}
