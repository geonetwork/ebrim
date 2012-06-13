package org.geonetwork.gaap.domain.organisation;

/**
 * Class to model an organisation
 *
 * @author Jose
 *
 */
public class Organisation {
    private long hibernateId;
    private String name;
    private String description;
    private String email;

    public long getHibernateId() {
        return hibernateId;
    }

    public void setHibernateId(long hibernateId) {
        this.hibernateId = hibernateId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organisation group = (Organisation) o;

        if (description != null ? !description.equals(group.description) : group.description != null) return false;
        if (email != null ? !email.equals(group.email) : group.email != null) return false;
        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (name != null ? name.hashCode() : 0);
        result = prime * result + (description != null ? description.hashCode() : 0);
        result = prime * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}