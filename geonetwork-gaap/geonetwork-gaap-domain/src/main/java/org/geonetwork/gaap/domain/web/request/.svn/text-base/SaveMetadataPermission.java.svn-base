package org.geonetwork.gaap.domain.web.request;

/**
 * Save metadata permission request
 *
 * @author Jose
 */
public class SaveMetadataPermission extends BaseRequest {
    String metadataUuid;
    String operationName;
    String groupUuid;


    public String getMetadataUuid() {
        return metadataUuid;
    }

    public void setMetadataUuid(String metadataUuid) {
        this.metadataUuid = metadataUuid;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getGroupUuid() {
        return groupUuid;
    }

    public void setGroupUuid(String groupUuid) {
        this.groupUuid = groupUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SaveMetadataPermission that = (SaveMetadataPermission) o;

        if (groupUuid != null ? !groupUuid.equals(that.groupUuid) : that.groupUuid != null) return false;
        if (metadataUuid != null ? !metadataUuid.equals(that.metadataUuid) : that.metadataUuid != null) return false;
        if (operationName != null ? !operationName.equals(that.operationName) : that.operationName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (metadataUuid != null ? metadataUuid.hashCode() : 0);
        result = 31 * result + (operationName != null ? operationName.hashCode() : 0);
        result = 31 * result + (groupUuid != null ? groupUuid.hashCode() : 0);
        return result;
    }
}