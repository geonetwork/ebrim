package org.geonetwork.gaap.domain.web.response;

import org.geonetwork.gaap.domain.user.User;

/**
 * Get user response
 *
 * @author Jose
 */
public class GetUserResponse extends BaseResponse {
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;

        GetUserResponse that = (GetUserResponse) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = super.hashCode();
        result = prime * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
