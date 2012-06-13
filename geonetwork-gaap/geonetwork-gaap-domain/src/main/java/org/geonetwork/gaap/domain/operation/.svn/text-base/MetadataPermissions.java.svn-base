package org.geonetwork.gaap.domain.operation;


import java.util.Set;

/**
 * Class to model the list of permissions (OperationsAllowed) for a metadata
 *
 * @author Jose
 *
 */
public class MetadataPermissions {
    private String metadataUuid;
    Set<Permission> permissions;

    public String getMetadataUuid() {
        return metadataUuid;
    }

    public void setMetadataUuid(String metadataUuid) {
        this.metadataUuid = metadataUuid;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetadataPermissions that = (MetadataPermissions) o;
        
        if (metadataUuid != null ? !metadataUuid.equals(that.metadataUuid) : that.metadataUuid != null) return false;
        if (permissions != null ? !permissions.equals(that.permissions) : that.permissions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (metadataUuid != null ? metadataUuid.hashCode() : 0);
        result = prime * result + (permissions != null ? permissions.hashCode() : 0);
        return result;
    }
}
