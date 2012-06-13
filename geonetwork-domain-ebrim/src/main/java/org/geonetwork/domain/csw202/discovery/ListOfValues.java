package org.geonetwork.domain.csw202.discovery;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author heikki doeleman
 *
 */
public class ListOfValues {

	private List<Object> values;

	public List<Object> getValues() {
		return values;
	}

	public void setValues(List<Object> values) {
		this.values = values;
	}

    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<Object> valuesFactory() {
		return new ArrayList<Object>();
	}

   @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((values == null) ? 0 : values.hashCode());
 		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ListOfValues)) {
			return false;
		}
		ListOfValues other = (ListOfValues) obj;

        if (values == null) {
            if (other.values != null)
                return false;
        } else if (!values
                .equals(other.values))
            return false;

		return true;
	}
}
