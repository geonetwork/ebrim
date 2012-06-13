package org.geonetwork.domain.csw202.discovery;

import java.util.List;
import java.util.ArrayList;

/**
 * The response contains a list of matching schema components in the requested schema language.
 * 
 * @author heikki doeleman
 *
 */
public class DescribeRecordResponse {

	private List<SchemaComponent> schemaComponent ;

	public List<SchemaComponent> getSchemaComponent() {
		return schemaComponent;
	}

	public void setSchemaComponent(List<SchemaComponent> schemaComponent) {
		this.schemaComponent = schemaComponent;
	}


    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<SchemaComponent> schemaComponentFactory() {
		return new ArrayList<SchemaComponent>();
	}


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schemaComponent == null) ? 0 : schemaComponent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DescribeRecordResponse)) {
			return false;
		}
		DescribeRecordResponse other = (DescribeRecordResponse) obj;

        if (schemaComponent == null) {
            if (other.schemaComponent != null)
                return false;
        } else if (!schemaComponent
                .equals(other.schemaComponent))
            return false;

		return true;
	}
}
