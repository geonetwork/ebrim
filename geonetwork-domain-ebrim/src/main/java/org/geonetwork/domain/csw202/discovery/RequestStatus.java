package org.geonetwork.domain.csw202.discovery;

import java.util.Date;

/**
 *  This element provides information about the status of the search request.
 *                 
 *  TODO the XSD mentions "status", but does not define it
 *                 
 * @author heikki doeleman
 *
 */
public class RequestStatus {

    /**
	 * the date and time when the result set was modified 
	 * (ISO 8601 format: YYYY-MM-DDThh:mm:ss[+|-]hh:mm).
	 */
	// TODO handle format
	private Date timestamp;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
            
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof RequestStatus)) {
            return false;
        }
        RequestStatus other = (RequestStatus) obj;

        if (timestamp == null) {
            if (other.timestamp != null)
                return false;
        } else if (!timestamp
                .equals(other.timestamp))
            return false;

        return true;
    }
}
