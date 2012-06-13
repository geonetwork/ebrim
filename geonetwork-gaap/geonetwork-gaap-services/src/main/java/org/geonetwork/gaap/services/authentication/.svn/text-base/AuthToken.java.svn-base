package org.geonetwork.gaap.services.authentication;

import org.geonetwork.gaap.domain.user.User;

import java.util.Date;

/**
 * Authentication token
 *
 * @author Jose
 */
public class AuthToken {
    String token;
    Date old;
    User user;

    public AuthToken(String token, User user, Date old) {
        this.token = token;
        this.user = user;
        this.old = old;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public Date getOld() {
        return old;
    }

    public void setOld(Date old) {
        if (old.after(this.old))
            this.old = old;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthToken authToken = (AuthToken) o;

        if (old != null ? !old.equals(authToken.old) : authToken.old != null) return false;
        if (user != null ? !user.equals(authToken.user) : authToken.user != null) return false;
        if (token != null ? !token.equals(authToken.token) : authToken.token != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = token != null ? token.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (old != null ? old.hashCode() : 0);
        return result;
    }
}
