package org.geonetwork.domain.gml311.basictypes;
/**
 * 
 * Name or code with an (optional) authority.  Text token.  
 * 
 * If the codeSpace attribute is present, then its value should identify a dictionary, 
 * thesaurus or authority for the term, such as the organisation who assigned the value, 
 * or the dictionary from which it is taken.  
 * 
 * A text string with an optional codeSpace attribute. 
 * 
 * @author heikki doeleman
 *
 */
public class CodeType {

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codeSpace == null) ? 0 : codeSpace.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodeType other = (CodeType) obj;
		if (codeSpace == null) {
			if (other.codeSpace != null)
				return false;
		} else if (!codeSpace.equals(other.codeSpace))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	private String value;
	private String codeSpace;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCodeSpace() {
		return codeSpace;
	}
	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}
	
	
	
}
