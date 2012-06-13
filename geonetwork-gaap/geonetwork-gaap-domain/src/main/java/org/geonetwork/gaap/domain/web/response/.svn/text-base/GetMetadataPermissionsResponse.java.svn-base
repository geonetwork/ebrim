package org.geonetwork.gaap.domain.web.response;

import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.operation.MetadataPermissions;

import java.util.List;

/**
 * Get group response
 *
 * @author Jose
 */
public class GetMetadataPermissionsResponse extends BaseResponse {
    MetadataPermissions permissions;

    public MetadataPermissions getMetadataPermissions() {
        return permissions;
    }

    public void setMetadataPermissions(MetadataPermissions permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;

        GetMetadataPermissionsResponse that = (GetMetadataPermissionsResponse) o;

        if (permissions != null ? !permissions.equals(that.permissions) : that.permissions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = super.hashCode();
        result = prime * result + (permissions != null ? permissions.hashCode() : 0);
        return result;
    }
}