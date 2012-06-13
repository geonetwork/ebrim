package org.geonetwork.gaap.services.authorization;

/**
 * Authorization manager
 *
 * @author Jose
 */

public class Authorization {
    Class service;
    String request;
    String profile;

    public Authorization(Class service, String request, String profile) {
        this.service = service;
        this.request = request;
        this.profile = profile;
    }

    public Class getService() {
        return service;
    }

    public String getProfile() {
        return profile;
    }

    public String getRequest() {
        return request;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authorization that = (Authorization) o;

        if (profile != null ? !profile.equals(that.profile) : that.profile != null) return false;
        if (request != null ? !request.equals(that.request) : that.request != null) return false;
        if (service != null ? !service.equals(that.service) : that.service != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = service != null ? service.hashCode() : 0;
        result = 31 * result + (request != null ? request.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        return result;
    }
}
