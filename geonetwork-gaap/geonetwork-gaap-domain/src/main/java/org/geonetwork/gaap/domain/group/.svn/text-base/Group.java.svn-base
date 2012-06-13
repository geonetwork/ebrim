package org.geonetwork.gaap.domain.group;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.geonetwork.gaap.domain.operation.Permission;
import org.geonetwork.gaap.domain.user.User;

import java.util.Set;

/**
 * Class to model user groups
 *
 * @author Jose
 */
@Indexed
public class Group {
    @DocumentId
    private long hibernateId;
    @Field
    private String uuid;
    @Field
    private String name;
    private String description;
    private String email;
    private boolean referrer;

    private Set<GroupDescription> descriptions;

    private Set<Permission> permissions;

    private Set<User> users;

    public Group() {
        this.uuid = java.util.UUID.randomUUID().toString();
    }

    public long getHibernateId() {
        return hibernateId;
    }

    public void setHibernateId(long hibernateId) {
        this.hibernateId = hibernateId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Set<GroupDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Set<GroupDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getReferrer() {
        return referrer;
    }

    public void setReferrer(boolean referrer) {
        this.referrer = referrer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (uuid != null ? !uuid.equals(group.uuid) : group.uuid != null) return false;
        if (description != null ? !description.equals(group.description) : group.description != null) return false;
        if (email != null ? !email.equals(group.email) : group.email != null) return false;
        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        if (referrer != group.referrer) return false;
        if (descriptions != null ? !descriptions.equals(group.descriptions) : group.descriptions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (uuid != null ? uuid.hashCode() : 0);
        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (description != null ? description.hashCode() : 0);
        result = prime * result + (email != null ? email.hashCode() : 0);
        result = prime * result + (referrer ? 1 : 0);
        result = prime * result + (descriptions != null ? descriptions.hashCode() : 0);
        return result;
    }
}
