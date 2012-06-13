package org.geonetwork.gaap.domain.web.request;

/**
 * Base request
 *
 * @author Jose
 */
public abstract class BaseRequest {
    String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseRequest that = (BaseRequest) o;

        if (authToken != null ? !authToken.equals(that.authToken) : that.authToken != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return authToken != null ? authToken.hashCode() : 0;
    }
}
