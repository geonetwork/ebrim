package org.geonetwork.gaap.domain.web.response;

import org.geonetwork.gaap.domain.group.Group;

/**
 * Get user uuid associated to AuthToken response
 *
 * @author Jose
 */
public class GetUserUuidByAuthTokenResponse extends BaseResponse {
    String userUuid;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;

        GetUserUuidByAuthTokenResponse that = (GetUserUuidByAuthTokenResponse) o;

        if (userUuid != null ? !userUuid.equals(that.userUuid) : that.userUuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = super.hashCode();
        result = prime * result + (userUuid != null ? userUuid.hashCode() : 0);
        return result;
    }
}