package org.geonetwork.gaap.domain.group;

/**
 * Class to model a localized group description
 *
 * @author Jose
 */
public class GroupDescription {
    private long hibernateId;
    private String langId;
    private String label;

    public long getHibernateId() {
        return hibernateId;
    }

    public void setHibernateId(long hibernateId) {
        this.hibernateId = hibernateId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupDescription that = (GroupDescription) o;

        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (langId != null ? !langId.equals(that.langId) : that.langId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = langId != null ? langId.hashCode() : 0;
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }
}
