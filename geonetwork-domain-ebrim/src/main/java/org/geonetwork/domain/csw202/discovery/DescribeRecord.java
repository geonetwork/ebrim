package org.geonetwork.domain.csw202.discovery;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.impl.UnmarshallingContext;

/**
 * This request allows a user to discover elements of the information model supported by the
 * catalogue. If no TypeName elements are included, then all of the schemas for the information
 * model must be returned.
 * <p/>
 * schemaLanguage - preferred schema language
 * (W3C XML Schema by default)
 * outputFormat - preferred output format (application/xml by default)
 * <p/>
 * The mandatory DescribeRecord operation allows a client to discover elements of the information
 * model supported by the target catalogue service. The operation allows some or all of the
 * information model to be described.
 *
 * @author heikki doeleman
 */
public class DescribeRecord extends RequestBase {

    public static final String XMLSCHEMA = "http://www.w3.org/2001/XMLSchema";

    private List<String> typeName;

    /**
     * Not modelled in the XSD. All namespace declarations in the document are needed in the processing
     * logic; they are put in this list.
     */
    private List<String> namespace;

    private String outputFormat = "application/xml";

    private String schemaLanguage = XMLSCHEMA;

    private String service = SERVICE;

    private String version = VERSION;


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

    public List<String> getTypeName() {
        return typeName;
    }

    public List<String> getNamespace() {
        return namespace;
    }

    public void setNamespace(List<String> namespace) {
        this.namespace = namespace;
    }

    public void setTypeName(List<String> typeName) {
        this.typeName = typeName;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getSchemaLanguage() {
        return schemaLanguage;
    }

    public void setSchemaLanguage(String schemaLanguage) {
        this.schemaLanguage = schemaLanguage;
    }

    /*public void preset(IUnmarshallingContext ctx) {
         System.out.println("preset @@@@@@@@");
         System.out.println("preset @@@@@@@@ " + ctx);
         System.out.println("preset @@@@@@@@ " + ctx.getDocumentName());
         System.out.println("preset @@@@@@@@ " + ctx.getStackDepth());
         System.out.println("preset @@@@@@@@ " + ctx.getStackTop());
         System.out.println("preset @@@@@@@@ " + ctx.getUserContext());
     } */

//	public void preset(Object o){
//		System.out.println("preset @@@@@@@@ " + o.toString());		
//	}

    /**
     * For Jixb binding.
     *
     * @return
     */
    @SuppressWarnings("unused")
    private static List<String> typeNameListFactory() {
        return new ArrayList<String>();
    }

    /**
     * For Jixb binding.
     *
     * @return
     */
    @SuppressWarnings("unused")
    private static List<String> namespaceListFactory() {
        return new ArrayList<String>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((namespace == null) ? 0 : namespace.hashCode());
        result = prime * result
                + ((outputFormat == null) ? 0 : outputFormat.hashCode());
        result = prime * result
                + ((schemaLanguage == null) ? 0 : schemaLanguage.hashCode());
        result = prime * result + ((service == null) ? 0 : service.hashCode());
        result = prime * result
                + ((typeName == null) ? 0 : typeName.hashCode());
        result = prime * result + ((version == null) ? 0 : version.hashCode());
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
        DescribeRecord other = (DescribeRecord) obj;
        if (namespace == null) {
            if (other.namespace != null)
                return false;
        } else if (!namespace.equals(other.namespace))
            return false;
        if (outputFormat == null) {
            if (other.outputFormat != null)
                return false;
        } else if (!outputFormat.equals(other.outputFormat))
            return false;
        if (schemaLanguage == null) {
            if (other.schemaLanguage != null)
                return false;
        } else if (!schemaLanguage.equals(other.schemaLanguage))
            return false;
        if (service == null) {
            if (other.service != null)
                return false;
        } else if (!service.equals(other.service))
            return false;
        if (typeName == null) {
            if (other.typeName != null)
                return false;
        } else if (!typeName.equals(other.typeName))
            return false;
        if (version == null) {
            if (other.version != null)
                return false;
        } else if (!version.equals(other.version))
            return false;
        return true;
    }

    /**
     * For Jibx binding. Processes namespaces
     *
     * @param obj IUnmarshallingContext
     */
    public void preset(IUnmarshallingContext obj) {
        UnmarshallingContext obj2 = (UnmarshallingContext) obj;

        int namespaceCount = obj2.getNamespaceCount();

        if (namespaceCount > 0) {
            namespace = new ArrayList<String>();
            for (int i = 0; i < namespaceCount; i++) {
                System.out.println(obj2.getNamespacePrefix(i) + "=" + obj2.getNamespaceUri(i));
                namespace.add(obj2.getNamespacePrefix(i) + "=" + obj2.getNamespaceUri(i));
            }

        }
    }
}
