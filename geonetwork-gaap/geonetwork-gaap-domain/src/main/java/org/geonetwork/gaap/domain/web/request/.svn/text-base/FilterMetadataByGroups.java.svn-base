package org.geonetwork.gaap.domain.web.request;

import java.util.List;

/**
 * Filter metadata request
 *
 * @author Jose
 */
public class FilterMetadataByGroups extends BaseRequest {
    List<String> groupUuids;

    public List<String> getGroupUuids() {
        return groupUuids;
    }

    public void setGroupUuids(List<String> groupUuids) {
        this.groupUuids = groupUuids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FilterMetadataByGroups that = (FilterMetadataByGroups) o;

        if (groupUuids != null ? !groupUuids.equals(that.groupUuids) : that.groupUuids != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
       int result = super.hashCode();

        result = 31 * result + (groupUuids != null ? groupUuids.hashCode() : 0);
        return result;
    }
}