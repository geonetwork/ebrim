package org.geonetwork.gaap.domain.web.request;

import org.geonetwork.gaap.domain.group.Group;

/**
 * Save group info request
 *
 * @author Jose
 */
public class CreateGroup extends BaseRequest {
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
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CreateGroup saveGroup = (CreateGroup) o;

        if (group != null ? !group.equals(saveGroup.group) : saveGroup.group != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (group != null ? group.hashCode() : 0);        
        return result;
    }
}
