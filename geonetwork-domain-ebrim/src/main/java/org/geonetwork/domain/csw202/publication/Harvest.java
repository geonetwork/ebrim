package org.geonetwork.domain.csw202.publication;

import java.util.List;

import org.geonetwork.domain.csw202.discovery.RequestBase;
import org.geonetwork.domain.ebrim.informationmodel.xsd.Duration;

/**
 * 
 * Requests that the catalogue attempt to harvest a resource from some network location 
 * identified by the source URL.
 * 
 * 
 * @author heikki doeleman
 *
 */
public class Harvest extends RequestBase {
	
	/**
	 * a URL from which the resource is retrieved
	 */
	// TODO must be anyURI
	private String source;
	
	/**
	 * normally a URI that specifies the type of the resource (DCMES v1.1) being harvested if it 
	 * is known.
	 */
	private String resourceType;

	/**
	 * a media type indicating the format of the resource being harvested.  The default is "application/xml".
	 */
	private String resourceFormat = "application/xml";
	
	/**
	 * an interval expressed using the ISO 8601 syntax; it specifies the interval between harvest
	 * attempts (e.g., P6M indicates an interval of six months).
	 */
	private Duration harvestInterval;
	
	/**
	 * a reference to some endpoint to which the response shall be forwarded when the harvest 
	 * operation has been completed
	 */
	// TODO must be List<anyURI>
	private List<String> responseHandler;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceFormat() {
		return resourceFormat;
	}

	public void setResourceFormat(String resourceFormat) {
		this.resourceFormat = resourceFormat;
	}

	public Duration getHarvestInterval() {
		return harvestInterval;
	}

	public void setHarvestInterval(Duration harvestInterval) {
		this.harvestInterval = harvestInterval;
	}

	public List<String> getResponseHandler() {
		return responseHandler;
	}

	public void setResponseHandler(List<String> responseHandler) {
		this.responseHandler = responseHandler;
	}
	
	
	
}
