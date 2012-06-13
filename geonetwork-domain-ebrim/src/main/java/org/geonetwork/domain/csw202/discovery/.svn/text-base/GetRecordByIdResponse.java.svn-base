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
package org.geonetwork.domain.csw202.discovery;

import java.util.List;
import java.util.ArrayList;

import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;

/**
 * Returns a representation of the matching entry. If there is no matching record, the response 
 * message must be empty.
 * 
 * @author heikki doeleman
 *
 */
public class GetRecordByIdResponse {

	// the 2 below are in a choice (either one is present)
	private List<AbstractRecord> abstractRecords;
	// this is <xsd:any namespace="##other" processContents="strict" minOccurs="0" maxOccurs="unbounded"/>
	private List<? extends Identifiable> otherRecords;
	
	public List<AbstractRecord> getAbstractRecords() {
		return abstractRecords;
	}
	public void setAbstractRecords(List<AbstractRecord> abstractRecords) {
		this.abstractRecords = abstractRecords;
	}
	public List<? extends Identifiable> getOtherRecords() {
		return otherRecords;
	}
	public void setOtherRecords(List<? extends Identifiable> otherRecords) {
		this.otherRecords = otherRecords;
	}

    /**
	 * For JiBX binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<AbstractRecord> abstractRecordsListFactory() {
		return new ArrayList<AbstractRecord>();
	}

        /**
	 * For JiBX binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<? extends Identifiable> otherRecordsListFactory() {
		return new ArrayList<Identifiable>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
        result = prime * result + ((abstractRecords == null) ? 0 : abstractRecords.hashCode());
		result = prime * result + ((otherRecords == null) ? 0 : otherRecords.hashCode());
 
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GetRecordByIdResponse)) {
			return false;
		}
		GetRecordByIdResponse other = (GetRecordByIdResponse) obj;

        if (abstractRecords == null) {
            if (other.abstractRecords != null)
                return false;
        } else if (!abstractRecords
                .equals(other.abstractRecords))
            return false;

        if (otherRecords == null) {
            if (other.otherRecords != null)
                return false;
        } else if (!otherRecords
                .equals(other.otherRecords))
            return false;

		return true;
	}
}
