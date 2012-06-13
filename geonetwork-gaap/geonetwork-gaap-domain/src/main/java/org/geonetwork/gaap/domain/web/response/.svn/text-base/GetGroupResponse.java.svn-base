package org.geonetwork.gaap.domain.web.response;

import org.geonetwork.gaap.domain.group.Group;

/**
 * Get group response
 *
 * @author Jose
 */
public class GetGroupResponse extends BaseResponse {
    Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;

        GetGroupResponse that = (GetGroupResponse) o;

        if (group != null ? !group.equals(that.group) : that.group != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        
        int result = super.hashCode();
        result = prime * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
