package org.geonetwork.domain.gml311.gmlbase;

import java.util.ArrayList;
import java.util.List;

import org.geonetwork.domain.gml311.basictypes.CodeType;

/**
 * All complexContent GML elements are directly or indirectly derived from this abstract 
 * supertype to establish a hierarchy of GML types that may be distinguished from other 
 * XML types by their ancestry. Elements in this hierarchy may have an ID and are thus 
 * referenceable.
 * 
 * @author heikki doeleman
 *
 */
public abstract class AbstractGML {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((metaDataPropertyList == null) ? 0 : metaDataPropertyList
						.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractGML other = (AbstractGML) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (metaDataPropertyList == null) {
			if (other.metaDataPropertyList != null)
				return false;
		} else if (!metaDataPropertyList.equals(other.metaDataPropertyList))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	private String id;
	
	private List<MetaDataProperty> metaDataPropertyList = new ArrayList<MetaDataProperty>();
	private StringOrRef description;
	private CodeType name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<MetaDataProperty> getMetaDataPropertyList() {
		return metaDataPropertyList;
	}
	public void setMetaDataPropertyList(List<MetaDataProperty> metaDataPropertyList) {
		this.metaDataPropertyList = metaDataPropertyList;
	}
	public StringOrRef getDescription() {
		return description;
	}
	public void setDescription(StringOrRef description) {
		this.description = description;
	}
	public CodeType getName() {
		return name;
	}
	public void setName(CodeType name) {
		this.name = name;
	}
	
	
}
