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
package org.geonetwork.utils.xslt;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

/**
 * 
 * Wrapper class for XSLT transformations.
 * 
 * @author heikki doeleman
 *
 */
public class Transformer {

	private static Logger log = Logger.getLogger(Transformer.class);	

	public static OutputStream transform(InputStream xml, InputStream xslt, OutputStream target) throws GeonetworkTransformerException {
		try {
			log.debug("start transformation");
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Source xsltSource = new StreamSource(xslt);
			Source xmlSource = new StreamSource(xml);
			javax.xml.transform.Transformer transformer = transformerFactory.newTransformer(xsltSource);
			transformer.transform(xmlSource, new javax.xml.transform.stream.StreamResult(target));
			log.debug("end transformation");
			return target;
		}
		catch(Exception x) {
			System.err.println(x.getMessage());
			x.printStackTrace();
			throw new GeonetworkTransformerException(x);
		}
	}
}
