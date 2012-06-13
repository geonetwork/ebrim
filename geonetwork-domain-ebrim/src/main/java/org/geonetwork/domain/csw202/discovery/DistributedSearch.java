package org.geonetwork.domain.csw202.discovery;

/**
 * Governs the behaviour of a distributed search.
 *     
 * @author heikki doeleman
 *
 */
public class DistributedSearch {

	/**
	 * the maximum number of message hops before the search is terminated. Each catalogue node 
	 * decrements this value when the request is received, and must not forward the request if 
	 * hopCount=0.
	 */
	// TODO this element is optional, but has default 2. How to handle that?
	Integer hopCount = 2 ;

    
    public Integer getHopCount() {
        return hopCount;
    }

    public void setHopCount(Integer hopCount) {
        this.hopCount = hopCount;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hopCount == null) ? 0 : hopCount.hashCode());
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
		DistributedSearch other = (DistributedSearch) obj;
		if (hopCount == null) {
			if (other.hopCount != null)
				return false;
		} else if (!hopCount.equals(other.hopCount))
			return false;
		return true;
	}
    
    
}
