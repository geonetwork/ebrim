package org.geonetwork.domain.ows100._19115subset;

/**
 * Name or code with an (optional) authority. If the codeSpace attribute is present, its value 
 * should reference a dictionary, thesaurus, or authority for the name or code, such as the 
 * organisation who assigned the value, or the dictionary from which it is taken.
 * 
 * Type copied from basicTypes.xsd of GML 3 with documentation edited, for possible use outside 
 * the ServiceIdentification section of a service metadata document.
 * 
 * @author heikki doeleman
 *
 */
public class CodeType {

	private String value ;
	
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
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((codeSpace == null) ? 0 : codeSpace.hashCode());
 		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CodeType)) {
			return false;
		}
		CodeType other = (CodeType) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value
                .equals(other.value))
            return false;

        if (codeSpace == null) {
            if (other.codeSpace != null)
                return false;
        } else if (!codeSpace
                .equals(other.codeSpace))
            return false;

		return true;
	}
}
