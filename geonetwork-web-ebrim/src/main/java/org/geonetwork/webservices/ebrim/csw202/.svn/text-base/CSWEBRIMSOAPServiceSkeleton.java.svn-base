/**
 * CSWEBRIMSOAPServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package org.geonetwork.webservices.ebrim.csw202;

import org.apache.log4j.Logger;
import org.geonetwork.domain.csw202.discovery.Capabilities;
import org.geonetwork.domain.csw202.discovery.GetCapabilities;
import org.geonetwork.domain.csw202.discovery.GetRecordById;
import org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse;
import org.geonetwork.domain.csw202.discovery.GetRepositoryItem;
import org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse;
import org.geonetwork.domain.csw202.publication.Harvest;
import org.geonetwork.domain.csw202.publication.HarvestResponse;
import org.geonetwork.domain.csw202.publication.Transaction;
import org.geonetwork.domain.csw202.publication.TransactionResponse;
import org.geonetwork.services.ebrim.csw202.CSW202Service;
import org.geonetwork.services.ebrim.csw202.CSW202ServiceException;

/**
 * CSWEBRIMSOAPServiceSkeleton java skeleton for the axisService
 * 
 * This layer routes the requests from Axis to the logical service layer. And in casts any CSW202ServiceException into a
 * MsgInvalidRequestFault exception.
 * 
 * OGC 07-110r2: In the event that an exception report is produced for any reason, a single SOAP Fault element
 * information item shall be included as the only child element information item of the SOAP body element
 * 
 * 
 */
public class CSWEBRIMSOAPServiceSkeleton {

	private static Logger log = Logger.getLogger(CSWEBRIMSOAPServiceSkeleton.class);

	CSW202Service csw202Service;

	/**
	 * Routes request from Axis to the logical service layer (CSW202ServiceImpl)
	 * 
	 * @param request
	 * @return response
	 * @throws MsgInvalidRequestFault
	 */
	public org.geonetwork.domain.csw202.discovery.GetRecordsResponse GetRecords(
			org.geonetwork.domain.csw202.discovery.GetRecords GetRecords) throws MsgInvalidRequestFault {

		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("------------------    GetRecords      -----------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");
		log.debug("----------------------------------------------------------------------");

		try {
			return csw202Service.getRecords(GetRecords);
		} catch (CSW202ServiceException e) {
			throw new MsgInvalidRequestFault(e);
		}

	}

	/**
	 * Auto generated method signature
	 * 
	 * @param GetDomain
	 * @throws MsgInvalidRequestFault
	 *             :
	 */

	public org.geonetwork.domain.csw202.discovery.GetDomainResponse GetDomain(
			org.geonetwork.domain.csw202.discovery.GetDomain GetDomain) throws MsgInvalidRequestFault {

		try {
			return csw202Service.getDomain(GetDomain);
		} catch (CSW202ServiceException e) {
			throw new MsgInvalidRequestFault(e);
		}
	}

	/**
	 * Routes request from Axis to the logical service layer (CSW202ServiceImpl)
	 * 
	 * @param request
	 * @return response
	 * @throws MsgInvalidRequestFault
	 */
	public org.geonetwork.domain.csw202.discovery.DescribeRecordResponse DescribeRecord(
			org.geonetwork.domain.csw202.discovery.DescribeRecord DescribeRecord) throws MsgInvalidRequestFault {

		try {
			return csw202Service.describeRecord(DescribeRecord);
		} catch (CSW202ServiceException e) {
			throw new MsgInvalidRequestFault(e);
		}

	}

	/**
	 * Routes request from Axis to the logical service layer (CSW202ServiceImpl)
	 * 
	 * @param request
	 * @return response
	 * @throws MsgInvalidRequestFault
	 */
	public Capabilities GetCapabilities(GetCapabilities request) throws MsgInvalidRequestFault {
		try {
			return csw202Service.getCapabilities(request);
		} catch (CSW202ServiceException e) {
			throw new MsgInvalidRequestFault(e);
		}
	}

	/**
	 * Routes request from Axis to the logical service layer (CSW202ServiceImpl)
	 * 
	 * @param request
	 * @return response
	 * @throws MsgInvalidRequestFault
	 */
	public GetRecordByIdResponse GetRecordById(GetRecordById request) throws MsgInvalidRequestFault {
		try {
			return csw202Service.getRecordById(request);
		} catch (CSW202ServiceException e) {
			throw new MsgInvalidRequestFault(e);
		}
	}

	/**
	 * Routes request from Axis to the logical service layer (CSW202ServiceImpl)
	 * 
	 * @param request
	 * @return response
	 * @throws MsgInvalidRequestFault
	 */
	public GetRepositoryItemResponse GetRepositoryItem(GetRepositoryItem request) throws MsgInvalidRequestFault {
		try {
			return csw202Service.getRepositoryItem(request.getId());
		} catch (CSW202ServiceException e) {
			throw new MsgInvalidRequestFault(e);
		}
	}

	/**
	 * Routes request from Axis to the logical service layer (CSW202ServiceImpl)
	 * 
	 * @param request
	 * @return response
	 * @throws MsgInvalidRequestFault
	 */
	public HarvestResponse Harvest(Harvest request) throws MsgInvalidRequestFault {
		try {
			return csw202Service.harvest(request);
		} catch (CSW202ServiceException e) {
			throw new MsgInvalidRequestFault(e);
		}
	}

	/**
	 * Routes request from Axis to the logical service layer (CSW202ServiceImpl)
	 * 
	 * @param request
	 * @return response
	 * @throws MsgInvalidRequestFault
	 */
	public TransactionResponse Transaction(Transaction request) throws MsgInvalidRequestFault {
		try {
			return csw202Service.transaction(request);
		} catch (CSW202ServiceException e) {
			throw new MsgInvalidRequestFault(e);
		}
	}

	public void setCsw202Service(CSW202Service csw202Service) {
		this.csw202Service = csw202Service;
	}

}
