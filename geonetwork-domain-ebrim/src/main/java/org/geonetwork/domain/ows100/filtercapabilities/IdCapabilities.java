package org.geonetwork.domain.ows100.filtercapabilities;

import java.util.List;
import java.util.ArrayList;


public class IdCapabilities {
    List<ID> ids;

    public List<ID> getIds() {
        return ids;
    }

    public void setIds(List<ID> ids) {
        this.ids = ids;
    }


    /**
	 * For JiBX binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<String> idListFactory() {
		return new ArrayList<String>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ids == null) ? 0 : ids.hashCode());

		return result;
	}

    @Override
	public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
                    return false;
                }
		if (!(obj instanceof IdCapabilities)) {
			return false;
		}

		IdCapabilities other = (IdCapabilities) obj;
		if (ids == null) {
			if (other.ids != null)
				return false;
		} else if (!ids.equals(other.ids))
			return false;
		
		return true;
	}
}
