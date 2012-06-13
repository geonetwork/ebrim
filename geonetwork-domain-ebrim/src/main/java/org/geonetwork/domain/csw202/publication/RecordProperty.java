package org.geonetwork.domain.csw202.publication;

/**
 * 
 * The RecordProperty element is used to specify the new value of a record property in an update 
 * statement.
 * 
 * @author heikki doeleman
 *
 */
public class RecordProperty {

	/**
	 * The Name element contains the name of a property to be updated.  The name may be a path 
	 * expression.
	 */
	private String name;
	
	/**
	 * The Value element contains the replacement value for the named property.
	 */
	private Object value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
