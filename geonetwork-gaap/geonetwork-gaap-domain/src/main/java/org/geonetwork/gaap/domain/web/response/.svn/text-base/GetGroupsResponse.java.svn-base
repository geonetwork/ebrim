package org.geonetwork.gaap.domain.web.response;

import org.geonetwork.gaap.domain.group.Group;

import java.util.List;

/**
 * Get groups response
 *
 * @author Jose
 */
public class GetGroupsResponse extends BaseResponse {
    List<Group> groups;

    int nextPosition;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public int getNextPosition() {
        return nextPosition;
    }

    public void setNextPosition(int nextPosition) {
        this.nextPosition = nextPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;

        GetGroupsResponse that = (GetGroupsResponse) o;

        if (nextPosition != that.nextPosition) return false;
        if (groups != null ? !groups.equals(that.groups) : that.groups != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = super.hashCode();
        result = prime * result + (groups != null ? groups.hashCode() : 0);
        result = prime * result + nextPosition;
        return result;
    }
}
