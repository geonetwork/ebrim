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

package org.geonetwork.domain.ebrim.informationmodel.core;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author Heikki Doeleman
 * 
 */
@Indexed
public class ExtrinsicObject extends RegistryObject {

	@IndexedEmbedded
	private VersionInfo contentVersionInfo;
	@Field
	private Boolean isOpaque;
	@IndexedEmbedded
	private LongName mimeType;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contentVersionInfo == null) ? 0 : contentVersionInfo.hashCode());
		result = prime * result + ((isOpaque == null) ? 0 : isOpaque.hashCode());
		result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtrinsicObject other = (ExtrinsicObject) obj;
		if (contentVersionInfo == null) {
			if (other.contentVersionInfo != null)
				return false;
		} else if (!contentVersionInfo.equals(other.contentVersionInfo))
			return false;
		if (isOpaque == null) {
			if (other.isOpaque != null)
				return false;
		} else if (!isOpaque.equals(other.isOpaque))
			return false;
		if (mimeType == null) {
			if (other.mimeType != null)
				return false;
		} else if (!mimeType.equals(other.mimeType))
			return false;
		return true;
	}

	public VersionInfo getContentVersionInfo() {
		return contentVersionInfo;
	}

	public void setContentVersionInfo(VersionInfo contentVersionInfo) {
		this.contentVersionInfo = contentVersionInfo;
	}

	public Boolean getIsOpaque() {
		return isOpaque;
	}

	public void setIsOpaque(Boolean isOpaque) {
		this.isOpaque = isOpaque;
	}

	public LongName getMimeType() {
		return mimeType;
	}

	public void setMimeType(LongName mimeType) {
		this.mimeType = mimeType;
	}

}
