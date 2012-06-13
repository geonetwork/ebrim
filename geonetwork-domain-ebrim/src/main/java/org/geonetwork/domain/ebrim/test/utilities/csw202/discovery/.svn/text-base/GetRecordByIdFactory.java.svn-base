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
package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import org.geonetwork.domain.csw202.discovery.GetRecordById;
import org.geonetwork.domain.csw202.discovery.ElementSetName;
import org.geonetwork.domain.csw202.discovery.ElementSet;

import java.util.List;
import java.util.ArrayList;

/**
 *
 *  @author Jose
 */
public class GetRecordByIdFactory {
    public synchronized static GetRecordById create() {
        GetRecordById r = new GetRecordById();

        r.setService("CSW");
        r.setVersion("2.0.2");

        r.setOutputFormat("application/xml");
        r.setOutputSchema("http://www.w3.org/2001/XMLSchema");

        ElementSetName e = new ElementSetName();
        e.setElementSet(ElementSet.summary);
        r.setElementSetName(e);

        List<String> typeNames= new ArrayList<String>();
        typeNames.add("csw:Record");
        
        e.setTypeNames(typeNames);

        List<String> id = new ArrayList<String>();
        id.add("efc40467-284d-4fee-af2a-522c717e7165");

        r.setId(id);

        return r;
    }
}
