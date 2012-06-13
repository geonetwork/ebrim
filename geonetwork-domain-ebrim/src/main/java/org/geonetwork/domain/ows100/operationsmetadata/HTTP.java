package org.geonetwork.domain.ows100.operationsmetadata;

import java.util.List;
import java.util.ArrayList;

/**
 * Connect point URLs for the HTTP Distributed Computing Platform (DCP). Normally, only one Get 
 * and/or one Post is included in this element. More than one Get and/or Post is allowed to 
 * support including alternative URLs for uses such as load balancing or backup. 
 * 
 * @author heikki doeleman
 *
 */
public class HTTP {

	private List<RequestMethod> value;

	public List<RequestMethod> getValue() {
		return value;
	}

	public void setValue(List<RequestMethod> value) {
		this.value = value;
	}

    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<RequestMethod> valueListFactory() {
		return new ArrayList<RequestMethod>();
	}
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof HTTP)) {
			return false;
		}
		HTTP other = (HTTP) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value
                .equals(other.value))
            return false;

		return true;
	}
}
