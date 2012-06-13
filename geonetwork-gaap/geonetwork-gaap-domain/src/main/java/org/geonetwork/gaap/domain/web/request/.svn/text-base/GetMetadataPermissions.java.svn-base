package org.geonetwork.gaap.domain.web.request;

/**
 * Get metadata permissions request
 *
 * @author Jose
 */
public class GetMetadataPermissions extends BaseRequest {
    private String metadataUuid;

    public String getMetadataUuid() {
        return metadataUuid;
    }

    public void setMetadataUuid(String metadataUuid) {
        this.metadataUuid = metadataUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GetMetadataPermissions that = (GetMetadataPermissions) o;

        if (metadataUuid != null ? !metadataUuid.equals(that.metadataUuid) : that.metadataUuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (metadataUuid != null ? metadataUuid.hashCode() : 0);
        return result;
    }
}