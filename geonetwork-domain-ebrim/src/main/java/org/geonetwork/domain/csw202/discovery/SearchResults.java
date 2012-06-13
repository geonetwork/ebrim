package org.geonetwork.domain.csw202.discovery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;

/**
 * Includes representations of result set members if maxRecords > 0. The items must conform to
 * one of the csw:Record views or a profile-specific representation.
 *
 * @author heikki doeleman
 */
public class SearchResults {

    // the 2 below are in a choice (either one is present)
    private List<AbstractRecord> records;
    // this one is
    // <xsd:any namespace="##other" processContents="strict" minOccurs="0" maxOccurs="unbounded"/>
    private List<?> otherRecords;

    /**
     * id of the result set (a URI).
     * A server-generated identifier for the result set. May be used in subsequent GetRecords operations to further refine the result set. If the 
     * server does not implement this capability then the attribute should be omitted.
     */
    private String resultSetId;

    /**
     * The element set that has been returned (i.e., "brief", "summary", "full").
     */
    private ElementSet elementSet;

    /**
     * Schema reference for included records(URI). A reference to the type or schema of the records returned.
     */
    private String recordSchema;

    /**
     * Number of records found by the GetRecords operation.
     */
    private Integer numberOfRecordsMatched;

    /**
     * Number of records actually returned to client. This may not be the entire result set since some servers may limit the number of records returned 
     * to limit the size of the response package transmitted to the client. Subsequent queries may be executed to see more of the result set. 
     * The nextRecord attribute will indicate to the client where to begin the next query.
     */
    private Integer numberOfRecordsReturned;

    /**
     * Start position of next record. A value of 0 means all records have been returned.
     */
    private Integer nextRecord;

    /**
     * An ISO 8601 format date indicating when the result set will expire. If this value is not specified then the result set expires immediately.
     */
    private Date expires;

    public List<AbstractRecord> getRecords() {
        return records;
    }

    public void setRecords(List<AbstractRecord> records) {
        this.records = records;
    }

    public List<?> getOtherRecords() {
        return otherRecords;
    }

    public void setOtherRecords(List<?> otherRecords) {
        this.otherRecords = otherRecords;
    }

    public String getResultSetId() {
        return resultSetId;
    }

    public void setResultSetId(String resultSetId) {
        this.resultSetId = resultSetId;
    }

    public ElementSet getElementSet() {
        return elementSet;
    }

    public void setElementSet(ElementSet elementSet) {
        this.elementSet = elementSet;
    }

    public String getRecordSchema() {
        return recordSchema;
    }

    public void setRecordSchema(String recordSchema) {
        this.recordSchema = recordSchema;
    }

    public Integer getNumberOfRecordsMatched() {
        return numberOfRecordsMatched;
    }

    public void setNumberOfRecordsMatched(Integer numberOfRecordsMatched) {
        this.numberOfRecordsMatched = numberOfRecordsMatched;
    }

    public Integer getNumberOfRecordsReturned() {
        return numberOfRecordsReturned;
    }

    public void setNumberOfRecordsReturned(Integer numberOfRecordsReturned) {
        this.numberOfRecordsReturned = numberOfRecordsReturned;
    }

    public Integer getNextRecord() {
        return nextRecord;
    }

    public void setNextRecord(Integer nextRecord) {
        this.nextRecord = nextRecord;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<AbstractRecord> recordsListFactory() {
		return new ArrayList<AbstractRecord>();
	}

    @SuppressWarnings("unused")
	private static  List<Identifiable> otherRecordsListFactory() {
		return new ArrayList<Identifiable>();
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((records == null) ? 0 : records.hashCode());
        result = prime * result + ((otherRecords == null) ? 0 : otherRecords.hashCode());
        result = prime * result + ((resultSetId == null) ? 0 : resultSetId.hashCode());
        result = prime * result + ((elementSet == null) ? 0 : elementSet.hashCode());
        result = prime * result + ((recordSchema == null) ? 0 : recordSchema.hashCode());
        result = prime * result + ((numberOfRecordsMatched == null) ? 0 : numberOfRecordsMatched.hashCode());
        result = prime * result + ((numberOfRecordsReturned == null) ? 0 : numberOfRecordsReturned.hashCode());
        result = prime * result + ((nextRecord == null) ? 0 : nextRecord.hashCode());
        result = prime * result + ((expires == null) ? 0 : expires.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SearchResults)) {
            return false;
        }
        SearchResults other = (SearchResults) obj;

        if (records == null) {
            if (other.records != null)
                return false;
        } else if (!records
                .equals(other.records))
            return false;

        if (otherRecords == null) {
            if (other.otherRecords != null)
                return false;
        } else if (!otherRecords
                .equals(other.otherRecords))
            return false;

        if (resultSetId == null) {
            if (other.resultSetId != null)
                return false;
        } else if (!resultSetId
                .equals(other.resultSetId))
            return false;

        if (elementSet == null) {
            if (other.elementSet != null)
                return false;
        } else if (!elementSet
                .equals(other.elementSet))
            return false;

        if (recordSchema == null) {
            if (other.recordSchema != null)
                return false;
        } else if (!recordSchema
                .equals(other.recordSchema))
            return false;

        if (numberOfRecordsMatched == null) {
            if (other.numberOfRecordsMatched != null)
                return false;
        } else if (!numberOfRecordsMatched
                .equals(other.numberOfRecordsMatched))
            return false;

        if (numberOfRecordsReturned == null) {
            if (other.numberOfRecordsReturned != null)
                return false;
        } else if (!numberOfRecordsReturned
                .equals(other.numberOfRecordsReturned))
            return false;

        if (nextRecord == null) {
            if (other.nextRecord != null)
                return false;
        } else if (!nextRecord
                .equals(other.nextRecord))
            return false;

        if (expires == null) {
            if (other.expires != null)
                return false;
        } else if (!expires
                .equals(other.expires))
            return false;

        return true;
    }
}
