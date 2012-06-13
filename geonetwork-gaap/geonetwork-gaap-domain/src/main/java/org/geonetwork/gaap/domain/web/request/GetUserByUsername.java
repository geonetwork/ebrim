package org.geonetwork.gaap.domain.web.request;

/**
 * Get user by username info request
 *
 * @author Jose
 */
public class GetUserByUsername extends BaseRequest {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        
        GetUserByUsername that = (GetUserByUsername) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}