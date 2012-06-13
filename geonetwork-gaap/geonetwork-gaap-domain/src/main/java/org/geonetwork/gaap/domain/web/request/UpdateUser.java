package org.geonetwork.gaap.domain.web.request;

import org.geonetwork.gaap.domain.user.User;

/**
 * Updates user info request
 *
 * @author Jose
 */
public class UpdateUser extends BaseRequest {
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
        if (o == null || getClass() != o.getClass()) return false;
         if (!super.equals(o)) return false;

        UpdateUser saveUser = (UpdateUser) o;

        if (user != null ? !user.equals(saveUser.user) : saveUser.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}