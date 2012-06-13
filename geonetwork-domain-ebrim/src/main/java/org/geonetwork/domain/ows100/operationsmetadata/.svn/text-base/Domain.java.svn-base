package org.geonetwork.domain.ows100.operationsmetadata;

import java.util.List;
import java.util.ArrayList;

import org.geonetwork.domain.ows100.common.Metadata;

/**
 * Valid domain (or set of values) of one parameter or other quantity used by this server. A 
 * non-parameter quantity may not be explicitly represented in the server software. (Informative: 
 * An example is the outputFormat parameter of a WFS. Each WFS server should provide a Parameter 
 * element for the outputFormat parameter that lists the supported output formats, such as GML2, 
 * GML3, etc. as the allowed "Value" elements.)
 * 
 * @author heikki doeleman
 *
 */
public class Domain {

	/**
	 * Unordered list of all the valid values for this parameter or other quantity. For those 
	 * parameters that contain a list or sequence of values, these values shall be for individual 
	 * values in the list. The allowed set of values and the allowed server restrictions on that 
	 * set of values shall be specified in the Implementation Specification for this service. 
	 */
	private List<String> value;
	
	/**
	 * Optional unordered list of additional metadata about this parameter. A list of required and 
	 * optional metadata elements for this domain should be specified in the Implementation 
	 * Specification for this service. (Informative: This metadata might specify the meanings of 
	 * the valid values.)
	 */
	private List<Metadata> metadata;
	
	/**
	 * Name or identifier of this parameter or other quantity. 
	 */
	private String name;

	public List<String> getValue() {
		return value;
	}

	public void setValue(List<String> value) {
		this.value = value;
	}

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<String> valueListFactory() {
		return new ArrayList<String>();
	}

    @SuppressWarnings("unused")
	private static  List<Metadata> metadataListFactory() {
		return new ArrayList<Metadata>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((metadata == null) ? 0 : metadata.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Domain)) {
			return false;
		}
		Domain other = (Domain) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value
                .equals(other.value))
            return false;

        if (metadata == null) {
            if (other.metadata != null)
                return false;
        } else if (!metadata
                .equals(other.metadata))
            return false;

        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name
                .equals(other.name))
            return false;

		return true;
	}
}
