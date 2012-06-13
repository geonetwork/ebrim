package org.geonetwork.domain.csw202.discovery;



/**
 * A search constraint that adheres to one of the following syntaxes:
 * Filter   - OGC filter expression
 * CqlText  - OGC CQL predicate
 * 
 * @author heikki doeleman
 *
 */
public class QueryConstraint {

	/**
	 * Query language version.
	 */
	private String version;
	
	// the 2 below are in a choice (either one is present)
	/**
	 * OGC filter expression
	 */
	// TODO how so is this deprecated ? javadoc doesn't mention it ?
	//private Filter filter ;
    private String filter;
	/**
	 * OGC CQL predicate
	 */
	private String CQLText;
	
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getCQLText() {
		return CQLText;
	}
	public void setCQLText(String text) {
		CQLText = text;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        result = prime * result + ((filter == null) ? 0 : filter.hashCode());
        result = prime * result + ((CQLText == null) ? 0 : CQLText.hashCode());
 
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof QueryConstraint)) {
            return false;
        }
        QueryConstraint other = (QueryConstraint) obj;

        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version
                .equals(other.version))
            return false;

        if (filter == null) {
            if (other.filter != null)
                return false;
        } else if (!filter
                .equals(other.filter))
            return false;

        if (CQLText == null) {
            if (other.CQLText != null)
                return false;
        } else if (!CQLText
                .equals(other.CQLText))
            return false;

        return true;
    }
	
	
}
