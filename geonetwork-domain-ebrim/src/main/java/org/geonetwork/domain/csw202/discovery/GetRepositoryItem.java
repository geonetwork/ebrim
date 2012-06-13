package org.geonetwork.domain.csw202.discovery;

/**
 * This is *not* part of standard CSW 2.0.2 and as such is not described by the CSW 202 schema.
 * 
 * From OGC 07-110r2 :
 * 
 * This request is submitted using the GET method. The values of the request and service parameters 
 * shall be GetRepositoryItem and CSW-ebRIM, respectively. The mandatory id parameter shall be an 
 * absolute URI that specifies the identifier of the extrinsic object that describes the item.
 * 
 * @author heikki doeleman
 *
 */
public class GetRepositoryItem {

	public static final String REQUEST = "GetRepositoryItem";
	
	public static final String SERVICE = "CSW-ebRIM" ;
	
	private String request;
	
	private String service;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequest() {
		return request;
	}

	public String getService() {
		return service;
	}
	
	
	
}
