package org.geonetwork.domain.csw202.discovery;

/**
 * The response message for a GetRecords request. Some or all of the matching records may be 
 * included as children of the SearchResults element. The RequestId is only included if the 
 * client specified it.
 * 
 * @author heikki doeleman
 *
 */
public class GetRecordsResponse {

	// TODO must be anyURI
	private String requestId;
	
	private RequestStatus searchStatus;
	
	private SearchResults searchResults;
	
	private String version;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public RequestStatus getSearchStatus() {
		return searchStatus;
	}

	public void setSearchStatus(RequestStatus searchStatus) {
		this.searchStatus = searchStatus;
	}

	public SearchResults getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(SearchResults searchResults) {
		this.searchResults = searchResults;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
        result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((searchStatus == null) ? 0 : searchStatus.hashCode());
        result = prime * result + ((searchResults == null) ? 0 : searchResults.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GetRecordsResponse)) {
			return false;
		}
		GetRecordsResponse other = (GetRecordsResponse) obj;

        if (requestId == null) {
            if (other.requestId != null)
                return false;
        } else if (!requestId
                .equals(other.requestId))
            return false;

        if (searchStatus == null) {
            if (other.searchStatus != null)
                return false;
        } else if (!searchStatus
                .equals(other.searchStatus))
            return false;

        if (searchResults == null) {
            if (other.searchResults != null)
                return false;
        } else if (!searchResults
                .equals(other.searchResults))
            return false;

         if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version
                .equals(other.version))
            return false;
		return true;
	}
}
