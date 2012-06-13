package org.geonetwork.gaap.domain.web.request;

/**
 * Get operation list request
 *
 * @author Jose
 */
public class GetOperations extends BaseRequest {
    int startPosition = 1;

    // pageSize = 0 -> all operations from startPosition
    int pageSize = 0;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GetOperations getGroups = (GetOperations) o;

        if (pageSize != getGroups.pageSize) return false;
        if (startPosition != getGroups.startPosition) return false;

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