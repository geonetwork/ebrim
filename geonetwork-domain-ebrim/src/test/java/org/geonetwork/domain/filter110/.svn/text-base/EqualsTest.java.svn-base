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

package org.geonetwork.domain.filter110;

import java.io.FileNotFoundException;

import org.custommonkey.xmlunit.XMLTestCase;
import org.geonetwork.domain.ebrim.test.utilities.filter110.FilterFactory;
import org.geonetwork.domain.filter110.expression.PropertyName;
import org.geonetwork.domain.filter110.spatialop.Beyond;
import org.geonetwork.domain.filter110.test.utilities.sort.PropertyNameFactory;
import org.jibx.runtime.JiBXException;

/**
 * Tests equals.
 * 
 * @author heikki doeleman
 * 
 */
public class EqualsTest extends XMLTestCase {

	public EqualsTest(String name) {
		super(name);
	}

	/**
	 * Tests equals().
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testEquals() throws FileNotFoundException, JiBXException {
		Filter beyondYou = FilterFactory.createBeyond();
		Filter beyondMe = FilterFactory.createBeyond();
		// test equality
		assertTrue("equality Filter Beyond", beyondYou.equals(beyondMe));
		
		Beyond beyond = (Beyond)beyondYou.getOperator();
		beyond.getPropertyName().setValue("something else");
		beyondYou.setOperator(beyond);

		assertFalse("equality Filter Beyond", beyondYou.equals(beyondMe));

	}
	
	/**
	 * Tests equals().
	 * 
	 * @throws FileNotFoundException
	 * @throws JiBXException
	 */
	public void testEquals2() throws FileNotFoundException, JiBXException {
		PropertyName propertyName1 = PropertyNameFactory.create();
		PropertyName propertyName2 = PropertyNameFactory.create();
		
		// test equality
		assertTrue("equality PropertyName", propertyName1.equals(propertyName2));
		
		
		PropertyName propertyName3 = new PropertyName();
		propertyName3.setValue("propertyneem");

		assertTrue("equality PropertyName", propertyName1.equals(propertyName3));

	}
	
}
