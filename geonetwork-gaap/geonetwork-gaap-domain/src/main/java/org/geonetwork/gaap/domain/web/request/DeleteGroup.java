package org.geonetwork.gaap.domain.web.request;

/**
 * Delete group request
 *
 * @author Jose
 */
public class DeleteGroup extends BaseRequest {
    private String groupUuid;

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

        DeleteGroup that = (DeleteGroup) o;

        if (groupUuid != null ? !groupUuid.equals(that.groupUuid) : that.groupUuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (groupUuid != null ? groupUuid.hashCode() : 0);
        return result;
    }
}
