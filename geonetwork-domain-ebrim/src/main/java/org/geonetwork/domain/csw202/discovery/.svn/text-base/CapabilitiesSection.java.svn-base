package org.geonetwork.domain.csw202.discovery;

/**
 * Sections of Capabilities documents.
 * 
 * From OGC 05-008 :
 * 
 * The common set of section names and meanings shall be as specified in Table 7. Each specific OWS 
 * shall use these section names and meanings when relevant, and can specify additional sections 
 * when needed. All four sections of a Capabilities document specified in Table 7 shall be 
 * implemented by all OWS servers, unless clearly not relevant to that specific OWS and thus 
 * replaced by substitute relevant sections.
 * 
 * @author heikki doeleman
 *
 */
public enum CapabilitiesSection {
	
	// 
	// from OGC 07-006r1 Table 58 :
	//
	 /** 
	 * A Filter_Capabilities section shall be included in the service metadata to describe which 
	 * elements of the predicate language are supported. All CSW implementations shall support at 
	 * least the following filter operators:
	 * 
	 * logical operators: And, Or, Not
	 * comparison operators: PropertyIsEqualTo, PropertyIsNotEqualTo, PropertyIsLessThan, PropertyIsGreaterThan, PropertyIsLessThanOrEqualTo, PropertyIsGreaterThanOrEqualTo, PropertyIsLike
	 * spatial operators: BBOX.
	 * 
	 */
	Filter_Capabilities,
	
	//
	// from OGC 05-008 Table 7 :
	//
	/**
	 * Metadata about this specific server. The schema of this section shall be the same for all OWSs.
	 */
	ServiceIdentification,
	
	/**
	 * Metadata about the organization operating this server. The schema of this section shall be 
	 * the same for all OWSs.
	 */
	ServiceProvider,
	
	/**
	 * Metadata about the operations specified by this service and implemented by this server, 
	 * including the URLs for operation requests. The basic contents and organization of this 
	 * section shall be the same for all OWSs, but individual services can add elements and/or 
	 * change the optionality of optional elements.
	 */
	OperationsMetadata,
	
	/**
	 * Metadata about the data served by this server. The schema of this section is specific to each 
	 * OWS type, as defined by that Implementation Specification.
	 * 
	 * Whenever applicable, this section shall contain a set of dataset descriptions, which should 
	 * each be based on the MD_DataIdentification class specified in ISO 19115 and used in ISO 19119.
	 * 
	 */
	Contents,

    /**
     * Complete service metadata document, containing all elements
     */
    All
}
