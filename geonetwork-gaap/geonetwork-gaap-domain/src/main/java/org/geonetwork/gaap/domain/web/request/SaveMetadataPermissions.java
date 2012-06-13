package org.geonetwork.gaap.domain.web.request;

import org.geonetwork.gaap.domain.operation.MetadataPermissions;

/**
 * Save metadata permissions request
 *
 * @author Jose
 */
public class SaveMetadataPermissions extends BaseRequest {
    MetadataPermissions permissions;

    public MetadataPermissions getPermissions() {
        return permissions;
    }

    public void setPermissions(MetadataPermissions permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SaveMetadataPermissions that = (SaveMetadataPermissions) o;

        if (permissions != null ? !permissions.equals(that.permissions) : that.permissions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (permissions != null ? permissions.hashCode() : 0);
        return result;
    }
}
