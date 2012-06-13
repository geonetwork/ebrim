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

package org.geonetwork.persistence.ebrim.hibernate.customtype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.geonetwork.domain.ebrim.informationmodel.xsd.Duration;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

/**
 * 
 * Custom Hibernate type for Duration.
 * 
 * @author Heikki Doeleman
 * 
 */
public class DurationUserType implements UserType {

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Object deepCopy(Object o) throws HibernateException {
		// Assuming Duration is immutable
		return o;
	}

	public Serializable disassemble(Object o) throws HibernateException {
		return (Serializable) o;
	}

	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isMutable() {
		// Assuming Duration is immutable
		return false;
	}

	public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner) throws HibernateException,
			SQLException {
		String duration$ = resultSet.getString(names[0]);
		if (resultSet.wasNull()) {
			return null;
		}
		Duration duration = new Duration(duration$);
		return duration;
	}

	public void nullSafeSet(PreparedStatement statement, Object o, int index) throws HibernateException, SQLException {
		if (o == null) {
			statement.setNull(index, Hibernate.STRING.sqlType());
		} else {
			Duration duration = (Duration) o;
			statement.setString(index, duration.toString());
		}
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		// Assuming Duration is immutable
		return original;
	}

	public Class<Duration> returnedClass() {
		return Duration.class;
	}

	public int[] sqlTypes() {
		return new int[] { Hibernate.STRING.sqlType() };
	}

}
