package org.geonetwork.domain.csw202.publication;

import java.util.List;

import org.geonetwork.domain.csw202.discovery.QueryConstraint;

/**
 * 
 * Update statements may replace an entire record or only update part of a record:
 * 1) To replace an existing record, include a new instance of the record;
 * 2) To update selected properties of an existing record, include a set of RecordProperty 
 *    elements. The scope of the update statement  is determined by the Constraint element. The 
 *    'handle' is a local identifier for the action.
               
 * @author heikki doeleman
 *
 */
public class Update {
	
	// TODO this is xsd:ID
	private String handle;

	
	// here is a choice of either :
	private Object record;
	
	// or both of 
	
	private List<RecordProperty> recordProperties;
	private QueryConstraint constraint;
	
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public Object getRecord() {
		return record;
	}
	public void setRecord(Object record) {
		this.record = record;
	}
	public List<RecordProperty> getRecordProperties() {
		return recordProperties;
	}
	public void setRecordProperties(List<RecordProperty> recordProperties) {
		this.recordProperties = recordProperties;
	}
	public QueryConstraint getConstraint() {
		return constraint;
	}
	public void setConstraint(QueryConstraint constraint) {
		this.constraint = constraint;
	}

	
}
