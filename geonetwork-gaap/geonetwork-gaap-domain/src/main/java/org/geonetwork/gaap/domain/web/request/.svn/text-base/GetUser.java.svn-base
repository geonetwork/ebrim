package org.geonetwork.gaap.domain.web.request;

/**
 * Get user info request
 *
 * @author Jose
 */
public class GetUser extends BaseRequest {
    private String userUuid;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GetUser that = (GetUser) o;

        if (userUuid != null ? !userUuid.equals(that.userUuid) : that.userUuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (userUuid != null ? userUuid.hashCode() : 0);
        return result;
    }
}
