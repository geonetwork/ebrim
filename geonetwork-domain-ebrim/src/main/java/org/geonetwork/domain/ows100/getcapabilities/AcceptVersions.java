package org.geonetwork.domain.ows100.getcapabilities;

import java.util.List;
import java.util.ArrayList;

/**
 * Prioritized sequence of one or more specification versions accepted by client, with 
 * preferred versions listed first. See Version negotiation subclause for more information.
 * 
 * @author heikki doeleman
 *
 */
public class AcceptVersions {

	private List<String> version;

	public List<String> getVersion() {
		return version;
	}

	public void setVersion(List<String> version) {
		this.version = version;
	}
	
    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<String> versionFactory() {
		return new ArrayList<String>();
	}


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AcceptVersions)) {
			return false;
		}
		AcceptVersions other = (AcceptVersions) obj;

        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version
                .equals(other.version))
            return false;
        
		return true;
	}
}
