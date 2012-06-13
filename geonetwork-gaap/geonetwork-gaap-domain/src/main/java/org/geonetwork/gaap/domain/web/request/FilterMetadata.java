package org.geonetwork.gaap.domain.web.request;

import java.util.List;

/**
 * Filter metadata request
 *
 * @author Jose
 */
public class FilterMetadata extends BaseRequest {
    List<String> metadataUuids;
    String userName;

    public List<String> getMetadataUuids() {
        return metadataUuids;
    }

    public void setMetadataUuids(List<String> metadataUuids) {
        this.metadataUuids = metadataUuids;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FilterMetadata that = (FilterMetadata) o;

        if (metadataUuids != null ? !metadataUuids.equals(that.metadataUuids) : that.metadataUuids != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (metadataUuids != null ? metadataUuids.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
