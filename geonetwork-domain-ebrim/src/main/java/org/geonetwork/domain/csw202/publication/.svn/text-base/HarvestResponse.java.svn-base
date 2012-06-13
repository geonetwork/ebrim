package org.geonetwork.domain.csw202.publication;

import org.geonetwork.domain.csw202.discovery.Acknowledgement;

/**
 *  The content of the response varies depending on the presence of the ResponseHandler element. 
 *  If present, then the catalogue should verify the request and respond immediately with an 
 *  csw:Acknowledgement element in the response. The catalogue must then attempt to harvest the 
 *  resource at some later time and send the response message to the location specified by the 
 *  value of the ResponseHandler element using the indicated protocol (e.g. ftp, mailto, http).
 *  
 *  If the ResponseHandler element is absent, then the catalogue must attempt to harvest the 
 *  resource immediately and include a TransactionResponse element in the response.
 *  
 *  In any case, if the harvest attempt is successful the response shall include summary 
 *  representations of the newly created catalogue item(s).
 *  
 * @author heikki doeleman
 *
 */
public class HarvestResponse {

	// the 2 below are in a choice (either is present) :
	
	private Acknowledgement acknowledgement;
	private TransactionResponse transactionResponse;
	
	public Acknowledgement getAcknowledgement() {
		return acknowledgement;
	}
	public void setAcknowledgement(Acknowledgement acknowledgement) {
		this.acknowledgement = acknowledgement;
	}
	public TransactionResponse getTransactionResponse() {
		return transactionResponse;
	}
	public void setTransactionResponse(TransactionResponse transactionResponse) {
		this.transactionResponse = transactionResponse;
	}
	
	
}
