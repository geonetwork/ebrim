package org.geonetwork.domain.utils;

import org.jibx.runtime.*;
import org.jibx.runtime.impl.UnmarshallingContext;

import java.util.*;

/**
 * Marshaller to manage in Jibx properties as string
 *
 * @author Jose
 */
public class GenericStringMarshaller implements IMarshaller, IUnmarshaller, IAliasable {
    private String m_uri;
    private int m_index;
    private String m_name;

    public GenericStringMarshaller() {
        m_uri = null;
        m_name = "filter";
    }

    public GenericStringMarshaller(String uri, int index, String name) {
        m_uri = uri;
        m_index = index;
        m_name = name;
    }

    public boolean isExtension(int i) {
        return false;
    }

    public void marshal(Object obj, IMarshallingContext ictx) throws JiBXException {
        // Not for now
    }

    public boolean isPresent(IUnmarshallingContext ctx) throws JiBXException {
        return ctx.isAt(m_uri, m_name);
    }

    public Object unmarshal(Object obj, IUnmarshallingContext ictx) throws JiBXException {
        // make sure we're at the appropriate start tag
        UnmarshallingContext ctx = (UnmarshallingContext) ictx;
        if (!ctx.isAt(m_uri, m_name)) {
            ctx.throwStartTagNameError(m_uri, m_name);
        }

        // create new string if needed
        String filterString = (String) obj;
        if (filterString == null) {
            filterString = new String();
        }

        ctx.toStart();

        // Process content of Filter tag
        boolean isText = true;
        boolean processed = false;
        String initialTag = ctx.getElementName();

        // Check if all element data is contained in text property 
        // (when using Axis this is not true)
        try {
            ctx.getText();
        } catch (Exception e) {
            isText = false;
        }

        if (isText) {
            while (!processed) {
                filterString += ctx.getText();
                ctx.nextToken();

                processed = (initialTag.equals(ctx.getElementName()));
            }
            filterString += ctx.getText();

        } else {
            while (!processed) {

                // Check if it's content element
                boolean isContentElement = true;
                try {
                    filterString += ctx.getText();
                } catch (Exception e) {
                    isContentElement = false;
                }

                // Tag element
                if (!isContentElement) {
                    String tag = ctx.getElementName();
                    if (initialTag == null) initialTag = tag;

                    if (ctx.isEnd()) {
                        filterString += "</" + ctx.getPrefix() + ":" + tag + ">";
                    } else {
                        int attCount = ctx.getAttributeCount();
                        filterString += "<" + ctx.getPrefix() + ":" + tag;
                        for (int i = 0; i < attCount; i++) {
                            filterString += " ";
                            if (ctx.getAttributePrefix(i) != null)
                                filterString += ctx.getAttributePrefix(i) + ":";

                            filterString += ctx.getAttributeName(i) +
                                    "=\"" + ctx.getAttributeValue(i) + "\" ";
                        }

                        if (tag == initialTag) {
                            int nsCount = ctx.getActiveNamespaceCount();
                            List<String> ns = new ArrayList<String>();

                            for (int i = 0; i < nsCount; i++) {
                                if (!ns.contains(ctx.getActiveNamespacePrefix(i))) {
                                    ns.add(ctx.getActiveNamespacePrefix(i));
                                    filterString += " xmlns:" + ctx.getActiveNamespacePrefix(i) + "=\"" +
                                            ctx.getActiveNamespaceUri(i) + "\" ";
                                }
                            }
                        }

                        filterString += ">";
                    }
                }

                ctx.nextToken();

                processed = (initialTag.equals(ctx.getElementName()));
                if (processed) {
                    filterString += "</" + ctx.getPrefix() + ":" + ctx.getElementName() + ">";
                }
            } // while
        }


        ctx.parsePastEndTag(m_uri, m_name);
        return filterString;
    }
}