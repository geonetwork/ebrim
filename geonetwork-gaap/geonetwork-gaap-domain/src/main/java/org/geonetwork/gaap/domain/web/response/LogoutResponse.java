package org.geonetwork.gaap.domain.web.response;

/**
 * Logout response
 *
 * @author Jose
 */
public class LogoutResponse extends BaseResponse {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}