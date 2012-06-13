package org.geonetwork.services.ebrim.csw202;

import org.geonetwork.domain.csw202.discovery.Capabilities;
import org.geonetwork.domain.csw202.discovery.DescribeRecord;
import org.geonetwork.domain.csw202.discovery.DescribeRecordResponse;
import org.geonetwork.domain.csw202.discovery.GetCapabilities;
import org.geonetwork.domain.csw202.discovery.GetDomain;
import org.geonetwork.domain.csw202.discovery.GetDomainResponse;
import org.geonetwork.domain.csw202.discovery.GetRecordById;
import org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse;
import org.geonetwork.domain.csw202.discovery.GetRecords;
import org.geonetwork.domain.csw202.discovery.GetRecordsResponse;
import org.geonetwork.domain.csw202.discovery.GetRepositoryItemResponse;
import org.geonetwork.domain.csw202.publication.Harvest;
import org.geonetwork.domain.csw202.publication.HarvestResponse;
import org.geonetwork.domain.csw202.publication.Transaction;
import org.geonetwork.domain.csw202.publication.TransactionResponse;

/**
 * 
 * @author heikki doeleman
 * 
 */
public interface CSW202Service {

	public Capabilities getCapabilities(GetCapabilities request) throws CSW202ServiceException;

	public GetRecordsResponse getRecords(GetRecords request) throws CSW202ServiceException;

	public GetRecordByIdResponse getRecordById(GetRecordById request) throws CSW202ServiceException;

	public GetDomainResponse getDomain(GetDomain request) throws CSW202ServiceException;

	public DescribeRecordResponse describeRecord(DescribeRecord request) throws CSW202ServiceException;

	public HarvestResponse harvest(Harvest request) throws CSW202ServiceException;

	public TransactionResponse transaction(Transaction request) throws CSW202ServiceException;
	
	public GetRepositoryItemResponse getRepositoryItem(String id) throws CSW202ServiceException;

}
