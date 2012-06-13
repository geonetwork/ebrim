package org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject;

import org.geonetwork.domain.ebrim.informationmodel.core.ExtrinsicObject;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Indexed;

@Indexed
public class WrsExtrinsicObject extends ExtrinsicObject {
    @IndexedEmbedded
    RepositoryItemRef repositoryItemRef;

    public RepositoryItemRef getRepositoryItemRef() {
        return repositoryItemRef;
    }

    public void setRepositoryItemRef(RepositoryItemRef repositoryItemRef) {
        this.repositoryItemRef = repositoryItemRef;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((repositoryItemRef == null) ? 0 : repositoryItemRef.hashCode());
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
		WrsExtrinsicObject other = (WrsExtrinsicObject) obj;
		if (repositoryItemRef == null) {
			if (other.repositoryItemRef != null)
				return false;
		} 
		return true;
	}
}
