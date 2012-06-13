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

import org.jibx.runtime.IUnmarshallingContext;

import java.util.List;
import java.util.ArrayList;

/**
 * Convenience operation to retrieve default record representations by identifier.
 *
 * @author heikki doeleman
 */
public class GetRecordById extends RequestBase {

	public static final String GET_RECORD_BY_ID = "GetRecordById" ;	
	public static final String ELEMENT_SET_NAME = "elementsetname" ;

    private String service;

    private String version;

    private String authToken;

    //
    // Basic Retrieval Options
    //

    public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public GetRecordById() {
		super();
		// default elementsetname is 'summary'.
		ElementSetName summaryElementSetName = new ElementSetName();
		summaryElementSetName.setElementSet(ElementSet.summary);     
		this.elementSetName = summaryElementSetName;
	}
	
    /**
     * object identifier (a URI) that provides a reference to a catalogue item (or a result set
     * if the catalogue supports persistent result sets).
     */
    // TODO must be List<anyURI>
    private List<String> id;

    /**
     * one of "brief, "summary", or "full"
     */
    private ElementSetName elementSetName;

    private String outputFormat = "application/xml";

    private String outputSchema = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0";

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getOutputSchema() {
        return outputSchema;
    }

    public void setOutputSchema(String outputSchema) {
        this.outputSchema = outputSchema;
    }

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }

    public ElementSetName getElementSetName() {
        return elementSetName;
    }

    public void setElementSetName(ElementSetName elementSetName) {
        this.elementSetName = elementSetName;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * For Jixb binding.
     *
     * @return
     */
    @SuppressWarnings("unused")
    private static List<String> idFactory() {
        return new ArrayList<String>();
    }
    @SuppressWarnings("unused")
    private void defaultValues(IUnmarshallingContext ctx) {
        if (this.elementSetName == null) {
            ElementSetName summaryElementSetName = new ElementSetName();
            summaryElementSetName.setElementSet(ElementSet.summary);
            this.elementSetName = summaryElementSetName;
        }

        // Can be set also in jibx mapping as default="application/xml"
        if (outputFormat == null) outputFormat="application/xml";

        // Can be set also in jibx mapping as  default="urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0"
        if (outputSchema == null) outputSchema="urn:oasis:names:tc:ebxml-regrep:xsd:rim:3.0";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((elementSetName == null) ? 0 : elementSetName.hashCode());
        result = prime * result + ((outputFormat == null) ? 0 : outputFormat.hashCode());
        result = prime * result + ((outputSchema == null) ? 0 : outputSchema.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
        result = prime * result + ((service == null) ? 0 : service.hashCode());
        result = prime * result + ((authToken == null) ? 0 : authToken.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof GetRecordById)) {
            return false;
        }
        GetRecordById other = (GetRecordById) obj;

        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id
                .equals(other.id))
            return false;

        if (elementSetName == null) {
            if (other.elementSetName != null)
                return false;
        } else if (!elementSetName
                .equals(other.elementSetName))
            return false;

        if (outputFormat == null) {
            if (other.outputFormat != null)
                return false;
        } else if (!outputFormat
                .equals(other.outputFormat))
            return false;

        if (outputSchema == null) {
            if (other.outputSchema != null)
                return false;
        } else if (!outputSchema
                .equals(other.outputSchema))
            return false;

        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version
                .equals(other.version))
            return false;

        if (service == null) {
            if (other.service != null)
                return false;
        } else if (!service
                .equals(other.service))
            return false;

        if (authToken == null) {
           if (other.authToken != null)
               return false;
       } else if (!authToken
               .equals(other.authToken))
           return false;

        return true;
	}
}
