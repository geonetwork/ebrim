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

package org.geonetwork.services.ebrim.iso19139;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.custommonkey.xmlunit.XMLTestCase;
import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;
import org.geonetwork.services.ebrim.GeonetworkServiceException;
import org.geonetwork.utils.xslt.GeonetworkTransformerException;
import org.jibx.runtime.*;

/**
 * Tests transforming an ISO19139 document into ebRIM documents.
 * 
 * @author heikki doeleman
 * 
 */
public class ISO191392ebRIMTransformationTest extends XMLTestCase {

	

	public ISO191392ebRIMTransformationTest(String name) {
		super(name);
	}	
	
	/**
	 * Tests transforming an ISO19139 document into an ebRIM RegistryObjectList document.
	 *
	 * 
	 * 
	 * @throws FileNotFoundException
	 * @throws GeonetworkTransformerException
	 * @throws GeonetworkServiceException
	 * @throws JiBXException
	 */
	public void testTransformToEbRIM() throws IOException, GeonetworkTransformerException, GeonetworkServiceException,
			JiBXException {
		FileInputStream xml = new FileInputStream(new File(DataResource.iso19139));
      	ISO19139Service iSO19139InsertionService = new ISO19139Service();
		RegistryObjectList actualResult = iSO19139InsertionService.transformToEbRIM(xml);
		// create JiBX unmarshal context
        IBindingFactory bfact = BindingDirectory.getFactory(Identifiable.class);
        		IUnmarshallingContext unMarshallingContext = bfact.createUnmarshallingContext();
		// get expected result from filesystem
		FileInputStream fis = new FileInputStream(new File(DataResource.ebrim));
		RegistryObjectList expectedResult = (RegistryObjectList) unMarshallingContext.unmarshalDocument(fis, "UTF-8");
		// comparison test compares the number of objects
		assertEquals("Transformer result matches expected result ", expectedResult.getRegistryObjects().size(),
				actualResult.getRegistryObjects().size());
	}



	
}
