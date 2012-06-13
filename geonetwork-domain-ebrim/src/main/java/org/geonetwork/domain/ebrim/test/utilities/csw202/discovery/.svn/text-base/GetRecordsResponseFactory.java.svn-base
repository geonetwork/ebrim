package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import org.geonetwork.domain.csw202.discovery.GetRecordsResponse;
import org.geonetwork.domain.csw202.discovery.RequestStatus;
import org.geonetwork.domain.csw202.discovery.SearchResults;
import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.csw202.record.BriefRecord;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class GetRecordsResponseFactory {
    public synchronized static GetRecordsResponse create() throws ParseException {
        GetRecordsResponse r = new GetRecordsResponse();

        r.setRequestId("4");
        r.setVersion("1");
        
        RequestStatus rs = new RequestStatus();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date timestamp = dateFormat.parse("2009-04-20T21:00:38.326Z");
        rs.setTimestamp(timestamp);

        r.setSearchStatus(rs);


        SearchResults sr = new SearchResults();

        sr.setNumberOfRecordsMatched(new Integer(10));
        sr.setNumberOfRecordsReturned(new Integer(5));
        sr.setNextRecord(new Integer(6));
        sr.setRecordSchema("http://www.opengis.net/cat/csw/2.0.2");

        Date expiresDate = dateFormat.parse("2009-04-20T19:00:38.326Z");
        sr.setExpires(expiresDate);

        sr.setElementSet(ElementSet.brief);
        
        sr.setResultSetId("1");
        List<AbstractRecord> records = new ArrayList<AbstractRecord>();

        BriefRecord br = new BriefRecord();
        br.setIdentifier("REC-1");
        br.setTitle("title");
       
        records.add(br);
        sr.setRecords(records);


        r.setSearchResults(sr);
        return r;
    }

}
