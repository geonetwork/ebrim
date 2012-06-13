package org.geonetwork.gaap.domain.web.response;

import java.util.List;

/**
 * Filter metadata response
 *
 * @author Jose
 */
public class FilterMetadataResponse extends BaseResponse {
    List<String> metadataUuids;

    public List<String> getMetadataUuids() {
        return metadataUuids;
    }

    public void setMetadataUuids(List<String> metadataUuids) {
        this.metadataUuids = metadataUuids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilterMetadataResponse that = (FilterMetadataResponse) o;

        if (metadataUuids != null ? !metadataUuids.equals(that.metadataUuids) : that.metadataUuids != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = super.hashCode();
        result = prime * result + (metadataUuids != null ? metadataUuids.hashCode() : 0);
        return result;
    }
}
