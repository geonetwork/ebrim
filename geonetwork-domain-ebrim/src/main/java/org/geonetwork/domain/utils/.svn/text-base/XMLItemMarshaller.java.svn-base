package org.geonetwork.domain.utils;

import org.jibx.runtime.*;
import org.jibx.extras.DomElementMapper;
import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.StringReader;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

/**
 * Marshaller to manage xml content marshalling in Jibx
 *
 * @author Jose
 */
public class XMLItemMarshaller extends DomElementMapper implements IMarshaller, IUnmarshaller, IAliasable {
    protected String m_uri;
    protected int m_index;
    protected String m_name;

    public XMLItemMarshaller() throws JiBXException {
        super();

        m_uri = null;
        m_name = "";
    }

    public XMLItemMarshaller(String uri, int index, String name) throws JiBXException {
        super();

        m_uri = uri;
        m_index = index;
        m_name = name;
    }

    public boolean isExtension(int i) {
        return false;
    }

    public void marshal(Object obj, IMarshallingContext ictx) throws JiBXException {
        String response = (String) obj;
        
        if (!(obj instanceof String)) {
            throw new JiBXException(
                    "Mapped object not valid");
        } else {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                factory.setNamespaceAware(true);
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new InputSource(new StringReader(response)));

                // marshal element and all content with only leading indentation
                m_xmlWriter = ictx.getXmlWriter();

                m_xmlWriter.indent();
                int indent = ictx.getIndent();
                ictx.setIndent(-1);
                m_defaultNamespaceURI = null;

                NodeList nl = document.getDocumentElement().getChildNodes();
                marshalElement((Element) document.getDocumentElement());
                ictx.setIndent(indent);

            } catch (Exception e) {
                e.printStackTrace();
                throw new JiBXException("Error writing to document", e);

            }
        }


    }

    public boolean isPresent(IUnmarshallingContext ctx) throws JiBXException {
        return ctx.isAt(m_uri, m_name);
    }

     public Object unmarshal(Object obj, IUnmarshallingContext ictx) throws JiBXException {
        return null;
     }
}
