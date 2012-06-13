package org.geonetwork.gaap.domain.web.response;

/**
 * Authentication response
 *
 * @author Jose
 */
public class AuthenticationResponse extends BaseResponse {
    String authenticationToken;

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AuthenticationResponse that = (AuthenticationResponse) o;

        if (authenticationToken != null ? !authenticationToken.equals(that.authenticationToken) : that.authenticationToken != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (authenticationToken != null ? authenticationToken.hashCode() : 0);
        return result;
    }
}