package org.geonetwork.domain.csw202.discovery;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery.StoredQuery;
import org.geonetwork.domain.ebrim.informationmodel.event.AdhocQuery;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.impl.UnmarshallingContext;

/**
 * The principal means of searching the catalogue. The matching catalogue entries may be
 * included with the response. The client may assign a requestId (absolute URI). A distributed
 * search is performed if the DistributedSearch element is present and the catalogue is a member
 * of a federation. Profiles may allow alternative query expressions.
 * <p/>
 * ebRIM profile of CSW :
 * The ResponseHandler and DistributedSearch elements, if present, shall be ignored and the
 * request processed in the normal synchronous manner by the recipient.
 *
 * @author heikki doeleman
 */
public class GetRecords extends RequestBase {

    private String requestID;

    private ResultType resultType = ResultType.hits;
    
    private String service;
    
    private String version;

    private List<String> namespace;

    private String authToken;

    //
    // Namespace
    //
    public List<String> getNamespace() {
       return namespace;
    }

    public void setNamespace(List<String> namespace) {
       this.namespace = namespace;
    }

    //
    // Basic Retrieval Options
    //

    public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }


	/**
     * the media type of the response message
     */
    private String outputFormat = "application/xml";

    /**
     * the preferred schema for records in the result set
     */
    private String outputSchema = "http://www.opengis.net/cat/csw/2.0.2";

    /**
     * requests a slice of the result set, starting at this position
     */
    private Integer startPosition = 1;

    /**
     * the maximum number of records to return. No records are  returned if maxRecords=0.
     */
    private Integer maxRecords = 10;

    //
    // End of Basic Retrieval Options
    //

    
    private DistributedSearch distributedSearch;

    private List<String> responseHandler;
	/**
	 * For JiBX binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<String> responseHandlerFactory() {
		return new ArrayList<String>();
	}	
    @SuppressWarnings("unused")
    private void defaultValues(IUnmarshallingContext ctx) {
        if (this.resultType == null) this.resultType = ResultType.hits;

        if (outputFormat == null) outputFormat="application/xml";

        if (outputSchema == null) outputSchema="http://www.opengis.net/cat/csw/2.0.2";

        if (startPosition == null) startPosition = 1;

        if (maxRecords == null) maxRecords = 10;
    }
    /**
     * OGC 05-025r3: A csw:GetRecords element must include a query statement. The schema fragment below 
     * allows a choice between any element that can substitute for csw:AbstractQuery or any element from 
     * a namespace that is not "http://www.opengis.net/cat/csw". In practice only one of the following 
     * elements may appear in this context: a csw:Query element (see Subclause 9.1.4), a rim:AdhocQuery 
     * element (see Subclause 9.1.6), or a wrs:StoredQuery element (Subclause 9.1.8).
     * 
     * <xsd:choice>
     *     <xsd:element ref="csw:AbstractQuery"/>
     *     <xsd:any processContents="strict" namespace="##other" />
     * </xsd:choice>
     * 
     */
    private Query query;
    private StoredQuery storedQuery;
    private AdhocQuery adhocQuery;

    
    public StoredQuery getStoredQuery() {
		return storedQuery;
	}

	public void setStoredQuery(StoredQuery storedQuery) {
		this.storedQuery = storedQuery;
	}

	public AdhocQuery getAdhocQuery() {
		return adhocQuery;
	}

	public void setAdhocQuery(AdhocQuery adhocQuery) {
		this.adhocQuery = adhocQuery;
	}

	public DistributedSearch getDistributedSearch() {
        return distributedSearch;
    }

    public void setDistributedSearch(DistributedSearch distributedSearch) {
        this.distributedSearch = distributedSearch;
    }

    public List<String> getResponseHandler() {
        return responseHandler;
    }

    public void setResponseHandler(List<String> responseHandler) {
        this.responseHandler = responseHandler;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getOutputSchema() {
        return outputSchema;
    }

    public void setOutputSchema(String outputSchema) {
        this.outputSchema = outputSchema;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getMaxRecords() {
        return maxRecords;
    }

    public void setMaxRecords(Integer maxRecords) {
        this.maxRecords = maxRecords;
    }

        /**
     * For Jixb binding.
     *
     * @return
     */
    @SuppressWarnings("unused")
    private static List<String> responseHandlerListFactory() {
        return new ArrayList<String>();
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((adhocQuery == null) ? 0 : adhocQuery.hashCode());
		result = prime
				* result
				+ ((distributedSearch == null) ? 0 : distributedSearch
						.hashCode());
		result = prime * result
				+ ((maxRecords == null) ? 0 : maxRecords.hashCode());
		result = prime * result
				+ ((outputFormat == null) ? 0 : outputFormat.hashCode());
		result = prime * result
				+ ((outputSchema == null) ? 0 : outputSchema.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result
				+ ((requestID == null) ? 0 : requestID.hashCode());
		result = prime * result
				+ ((responseHandler == null) ? 0 : responseHandler.hashCode());
        result = prime * result
				+ ((resultType == null) ? 0 : resultType.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result
				+ ((startPosition == null) ? 0 : startPosition.hashCode());
		result = prime * result
				+ ((storedQuery == null) ? 0 : storedQuery.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
        result = prime * result + ((authToken == null) ? 0 : authToken.hashCode());		
        return result;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GetRecords other = (GetRecords) obj;
		if (adhocQuery == null) {
			if (other.adhocQuery != null)
				return false;
		} else if (!adhocQuery.equals(other.adhocQuery))
			return false;
		if (distributedSearch == null) {
			if (other.distributedSearch != null)
				return false;
		} else if (!distributedSearch.equals(other.distributedSearch))
			return false;
		if (maxRecords == null) {
			if (other.maxRecords != null)
				return false;
		} else if (!maxRecords.equals(other.maxRecords))
			return false;
		if (outputFormat == null) {
			if (other.outputFormat != null)
				return false;
		} else if (!outputFormat.equals(other.outputFormat))
			return false;
		if (outputSchema == null) {
			if (other.outputSchema != null)
				return false;
		} else if (!outputSchema.equals(other.outputSchema))
			return false;
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		if (requestID == null) {
			if (other.requestID != null)
				return false;
		} else if (!requestID.equals(other.requestID))
			return false;
		if (responseHandler == null) {
			if (other.responseHandler != null)
				return false;
		} else if (!responseHandler.equals(other.responseHandler))
			return false;
		if (resultType == null) {
			if (other.resultType != null)
				return false;
		} else if (!resultType.equals(other.resultType))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (startPosition == null) {
			if (other.startPosition != null)
				return false;
		} else if (!startPosition.equals(other.startPosition))
			return false;
		if (storedQuery == null) {
			if (other.storedQuery != null)
				return false;
		} else if (!storedQuery.equals(other.storedQuery))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
        if (authToken == null) {
			if (other.authToken != null)
				return false;
		} else if (!authToken.equals(other.authToken))
			return false;
		return true;
	}

        /**
     * For Jibx binding. Processes namespaces
     *
     * @param obj       IUnmarshallingContext
     */
    public void preset(IUnmarshallingContext obj) {
        UnmarshallingContext obj2 = (UnmarshallingContext) obj;

        int namespaceCount = obj2.getNamespaceCount();

        if (namespaceCount > 0) {
            namespace = new ArrayList<String>();
            for (int i = 0; i < namespaceCount; i++) {
                System.out.println(obj2.getNamespacePrefix(i) + "=" + obj2.getNamespaceUri(i));
                namespace.add(obj2.getNamespacePrefix(i) + "=" + obj2.getNamespaceUri(i));
            }

        }
    }
}
