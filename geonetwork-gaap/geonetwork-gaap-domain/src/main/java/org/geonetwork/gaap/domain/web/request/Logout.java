package org.geonetwork.gaap.domain.web.request;

/**
 * Logout user request
 *
 * @author Jose
 */
public class Logout extends BaseRequest {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
 if (!super.equals(o)) return false;
        Logout that = (Logout) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }

}