//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================

package org.geonetwork.domain.ebrim.informationmodel.xsd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

@Indexed
public class ValueList extends AbstractValueList {

	/**
	 * For JiXB binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<LongName> valueListFactory() {
		return new ArrayList<LongName>();
	}

	@IndexedEmbedded
	private List<LongName> values = new ArrayList<LongName>();

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
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

	public List<LongName> getValues() {
		return values;
	}

	public void setValues(List<LongName> values) {
		this.values = values;
	}

	public boolean add(LongName e) {
		return values.add(e);
	}

	public Iterator<LongName> iterate() {
		return values.iterator();
	}

}
