package org.geonetwork.gaap.domain.operation;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

import java.util.Set;


/**
 * Class to model a metadata operation
 *
 * @author Jose
 *
 */
@Indexed
public class Operation {
    @DocumentId
    private long hibernateId;
    @Field
    private String name;
    private boolean reserved;

     Set<OperationDescription> descriptions;

    public Set<OperationDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Set<OperationDescription> descriptions) {
        this.descriptions = descriptions;
    }


    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHibernateId() {
        return hibernateId;
    }

    public void setHibernateId(long hibernateId) {
        this.hibernateId = hibernateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (reserved != operation.reserved) return false;
        if (name != null ? !name.equals(operation.name) : operation.name != null) return false;
        if (descriptions != null ? !descriptions.equals(operation.descriptions) : operation.descriptions != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
		int result = 1;

        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (reserved ? 1 : 0);
        result = prime * result + (descriptions != null ? descriptions.hashCode() : 0);
                
        return result;
    }
}
