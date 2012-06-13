package org.geonetwork.domain.utils;

import org.jibx.runtime.JiBXException;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.impl.UnmarshallingContext;

import java.util.List;
import java.util.ArrayList;

/**
 * Marshaller for schema field in DescribeRecord
 *
 * @author Jose
 */
public class DescribeRecordSchemaMarshaller extends XMLItemMarshaller {
    public DescribeRecordSchemaMarshaller() throws JiBXException {
        super();
        m_name = "schema";
    }

    public DescribeRecordSchemaMarshaller(String uri, int index, String name) throws JiBXException {
        super(uri, index, name);
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
            String text = "";

            while (!processed) {
                if (!initialTag.equals(ctx.getElementName())) {
                    // Elements <tag /> are processed twice with the same text, discard the second time
                    if (!text.equals(ctx.getText())) {
                        filterString += ctx.getText();
                        text = ctx.getText();
                    }
                }

                ctx.nextToken();

                processed = (initialTag.equals(ctx.getElementName()));
            }
            //filterString += ctx.getText();

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
