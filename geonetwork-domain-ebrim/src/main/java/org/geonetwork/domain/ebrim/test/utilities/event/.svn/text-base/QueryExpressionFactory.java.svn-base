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

package org.geonetwork.domain.ebrim.test.utilities.event;

import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.event.QueryExpression;

public class QueryExpressionFactory {

	public synchronized static QueryExpression create() {
		QueryExpression o = new QueryExpression();

		String randomObject = "<csw:Query typeNames='Service Classification'>\n" +
                "          <csw:ElementSetName typeNames='Service'>summary</csw:ElementSetName>\n" +
                "          <csw:Constraint version='1.1.0'>\n" +
                "          <ogc:Filter>\n" +
                "          <ogc:And>\n" +
                "            <ogc:PropertyIsEqualTo>\n" +
                "              <ogc:PropertyName>/Service/@id</ogc:PropertyName>\n" +
                "              <ogc:PropertyName>/Classification/@classifiedObject</ogc:PropertyName>\n" +
                "            </ogc:PropertyIsEqualTo>\n" +
                "            <ogc:PropertyIsEqualTo>\n" +
                "              <ogc:PropertyName>/Classification/@classificationScheme</ogc:PropertyName>\n" +
                "              <ogc:Literal>urn:x-iso-tc211:19119(2003)/scheme/services</ogc:Literal>\n" +
                "            </ogc:PropertyIsEqualTo>\n" +
                "            <ogc:PropertyIsEqualTo>\n" +
                "              <ogc:PropertyName>/Classification/@classificationNode</ogc:PropertyName>\n" +
                "              <ogc:Literal>${serviceType}</ogc:Literal>\n" +
                "            </ogc:PropertyIsEqualTo>\n" +
                "          </ogc:And>\n" +
                "          </ogc:Filter>\n" +
                "          </csw:Constraint>\n" +
                "        </csw:Query>";
        
		o.setAny(randomObject);
		o.setQueryLanguage(new URI("http://queryLanguage"));

		return o;
	}
}
