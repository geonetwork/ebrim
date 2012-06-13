package org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * Substitute for ebrim ValueList in CSW Basic Extension Package.
 * 
 * @author heikki
 * 
 */
@Indexed
public class ValueList {
	
	/**
	 * For JiXB binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<AnyValue> valueListFactory() {
		return new ArrayList<AnyValue>();
	}
	

	@IndexedEmbedded
	private List<AnyValue> values = new ArrayList<AnyValue>();

	public List<AnyValue> getValues() {
		return values;
	}

	public void setValues(List<AnyValue> values) {
		this.values = values;
	}

	public boolean add(AnyValue e) {
		return values.add(e);
	}

	public Iterator<AnyValue> iterate() {
		return values.iterator();
	}

	public int size() {
		return values.size();
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueList other = (ValueList) obj;
		if (values == null) {
			if (other.values != null)
				return false;
		} else {
			Iterator<AnyValue> otherValues = other.values.iterator();
			for(AnyValue anyValue : values) {
				AnyValue otherAnyValue = otherValues.next();
				if(!anyValue.equals(otherAnyValue)) {
					return false;
				}
			}
		}
		return true;
	}
	


}
