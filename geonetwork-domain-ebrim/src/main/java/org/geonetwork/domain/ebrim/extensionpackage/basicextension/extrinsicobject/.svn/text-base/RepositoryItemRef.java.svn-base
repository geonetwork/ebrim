package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Field;

@Indexed
public class RepositoryItemRef {

   @Field
   String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((href == null) ? 0 : href.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepositoryItemRef other = (RepositoryItemRef) obj;
		if (href == null) {
			if (other.href != null)
				return false;
		}
		return true;
	}
}
