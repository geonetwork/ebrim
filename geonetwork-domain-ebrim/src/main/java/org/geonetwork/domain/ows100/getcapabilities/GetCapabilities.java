package org.geonetwork.domain.ows100.getcapabilities;

import org.jibx.runtime.IUnmarshallingContext;
import org.geonetwork.domain.csw202.discovery.ElementSetName;
import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.ows100.common.MimeType;

import java.util.List;
import java.util.ArrayList;

/**
 * XML encoded GetCapabilities operation request. This operation allows clients to retrieve
 * service metadata about a specific service instance. In this XML encoding, no "request"
 * parameter is included, since the element name specifies the specific operation. This base
 * type shall be extended by each specific OWS to include the additional required "service"
 * attribute, with the correct value for that OWS.
 *
 * @author heikki doeleman
 *
 */
public class GetCapabilities {

    /**
     * When omitted or not supported by server, server shall return latest complete service
     * metadata document.
     */
    private String updateSequence;

    /**
     * When omitted, server shall return latest supported version.
     */
    private AcceptVersions acceptVersions;

    /**
     * When omitted or not supported by server, server shall return complete service metadata
     * (Capabilities) document.
     */
    private Sections sections;

    /**
     * When omitted or not supported by server, server shall return service metadata document
     * using the MIME type "text/xml".
     */
    private AcceptFormats acceptFormats;

    public String getUpdateSequence() {
        return updateSequence;
    }

    public void setUpdateSequence(String updateSequence) {
        this.updateSequence = updateSequence;
    }

    public AcceptVersions getAcceptVersions() {
        return acceptVersions;
    }

    public void setAcceptVersions(AcceptVersions acceptVersions) {
        this.acceptVersions = acceptVersions;
    }

    public Sections getSections() {
        return sections;
    }

    public void setSections(Sections sections) {
        this.sections = sections;
    }

    public AcceptFormats getAcceptFormats() {
        return acceptFormats;
    }

    public void setAcceptFormats(AcceptFormats acceptFormats) {
        this.acceptFormats = acceptFormats;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((updateSequence == null) ? 0 : updateSequence.hashCode());
        result = prime * result + ((acceptVersions == null) ? 0 : acceptVersions.hashCode());
        result = prime * result + ((sections == null) ? 0 : sections.hashCode());
        result = prime * result + ((acceptFormats == null) ? 0 : acceptFormats.hashCode());
        return result;
    }

    @SuppressWarnings("unused")
    private void defaultValues(IUnmarshallingContext ctx) {
        if (this.acceptVersions == null) {
            this.acceptVersions = new AcceptVersions();
            List<String> versions = new ArrayList<String>();
            versions.add("1.0.0");

            this.acceptVersions.setVersion(versions);
        }

        if (this.acceptFormats == null) {
            this.acceptFormats = new AcceptFormats();
            List<MimeType> formats = new ArrayList<MimeType>();
            MimeType applicationXml = new MimeType();
            applicationXml.setValue("application/xml");
            formats.add(applicationXml);

            this.acceptFormats.setOutputFormat(formats);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof GetCapabilities)) {
            return false;
        }
        GetCapabilities other = (GetCapabilities) obj;

        if (updateSequence == null) {
            if (other.updateSequence != null)
                return false;
        } else if (!updateSequence
                .equals(other.updateSequence))
            return false;

        if (acceptVersions == null) {
            if (other.acceptVersions != null)
                return false;
        } else if (!acceptVersions
                .equals(other.acceptVersions))
            return false;

        if (sections == null) {
            if (other.sections != null)
                return false;
        } else if (!sections
                .equals(other.sections))
            return false;

        if (acceptFormats == null) {
            if (other.acceptFormats != null)
                return false;
        } else if (!acceptFormats
                .equals(other.acceptFormats))
            return false;

        return true;
	}
	
}
