package org.geonetwork.gaap.domain.web.request;

/**
 * Get user list request
 *
 * @author Jose
 */
public class GetUsers extends BaseRequest {
    int startPosition = 1;

    // pageSize = 0 -> all groups from startPosition
    int pageSize = 0;

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GetUsers getUsers = (GetUsers) o;

        if (pageSize != getUsers.pageSize) return false;
        if (startPosition != getUsers.startPosition) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + startPosition;
        result = 31 * result + pageSize;
        return result;
    }
}
