/**
 * CSWEBRIMSOAPServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

package org.geonetwork.webservices.ebrim.csw202;

/**
 * CSWEBRIMSOAPServiceCallbackHandler Callback class, Users can extend this class and implement
 * their own receiveResult and receiveError methods.
 */
public abstract class CSWEBRIMSOAPServiceCallbackHandler {

	protected Object clientData;

	/**
	 * User can pass in any object that needs to be accessed once the NonBlocking Web service call
	 * is finished and appropriate method of this CallBack is called.
	 * 
	 * @param clientData
	 *            Object mechanism by which the user can pass in user data that will be avilable at
	 *            the time this callback is called.
	 */
	public CSWEBRIMSOAPServiceCallbackHandler(Object clientData) {
		this.clientData = clientData;
	}

	/**
	 * Please use this constructor if you don't want to set any clientData
	 */
	public CSWEBRIMSOAPServiceCallbackHandler() {
		this.clientData = null;
	}

	/**
	 * Get the client data
	 */

	public Object getClientData() {
		return clientData;
	}

	/**
	 * auto generated Axis2 call back method for GetRecords method override this method for handling
	 * normal response from GetRecords operation
	 */
	public void receiveResultGetRecords(org.geonetwork.domain.csw202.discovery.GetRecordsResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling error response from
	 * GetRecords operation
	 */
	public void receiveErrorGetRecords(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for GetDomain method override this method for handling
	 * normal response from GetDomain operation
	 */
	public void receiveResultGetDomain(org.geonetwork.domain.csw202.discovery.GetDomainResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling error response from
	 * GetDomain operation
	 */
	public void receiveErrorGetDomain(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for GetRecordByIdXml method override this method for
	 * handling normal response from GetRecordByIdXml operation
	 */
	public void receiveResultGetRecordByIdXml(org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling error response from
	 * GetRecordByIdXml operation
	 */
	public void receiveErrorGetRecordByIdXml(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for DescribeRecord method override this method for
	 * handling normal response from DescribeRecord operation
	 */
	public void receiveResultDescribeRecord(org.geonetwork.domain.csw202.discovery.DescribeRecordResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling error response from
	 * DescribeRecord operation
	 */
	public void receiveErrorDescribeRecord(java.lang.Exception e) {
	}

}
