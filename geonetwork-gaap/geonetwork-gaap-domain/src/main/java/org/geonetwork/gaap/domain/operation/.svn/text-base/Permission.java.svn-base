package org.geonetwork.gaap.domain.operation;

import org.geonetwork.gaap.domain.group.Group;
import org.hibernate.search.annotations.*;


/**
 * Class to model a permission for a metadata
 *
 * @author Jose
 *
 */
@Indexed
public class Permission {
    @DocumentId
    private long hibernateId;
    @IndexedEmbedded
    private Group group;
    @IndexedEmbedded
    private Operation operation;
    @Field(store= Store.YES)
    private String metadataUuid;

    public long getHibernateId() {
        return hibernateId;
    }

    public void setHibernateId(long hibernateId) {
        this.hibernateId = hibernateId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getMetadataUuid() {
        return metadataUuid;
    }

    public void setMetadataUuid(String metadataUuid) {
        this.metadataUuid = metadataUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (metadataUuid != null ? !metadataUuid.equals(that.metadataUuid) : that.metadataUuid != null) return false;
        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
		int result = 1;

        result = prime * result + (group != null ? group.hashCode() : 0);
        result = prime * result + (operation != null ? operation.hashCode() : 0);
        result = prime * result + (metadataUuid != null ? metadataUuid.hashCode() : 0);
        return result;
    }
}
