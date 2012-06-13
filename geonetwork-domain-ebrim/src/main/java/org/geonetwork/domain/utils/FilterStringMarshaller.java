package org.geonetwork.domain.utils;

import org.jibx.runtime.*;
import org.jibx.runtime.impl.UnmarshallingContext;

/**
 * Marshaller to manage in Jibx the filter property in
 * GetRecords request as a String
 *
 * @author Jose
 */
public class FilterStringMarshaller implements IMarshaller, IUnmarshaller, IAliasable {
    private String m_uri;
    private int m_index;
    private String m_name;

    public FilterStringMarshaller() {
        m_uri = null;
        m_name = "filter";
    }

    public FilterStringMarshaller(String uri, int index, String name) {
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
        UnmarshallingContext ctx = (UnmarshallingContext)ictx;
        if (!ctx.isAt(m_uri, m_name)) {
            ctx.throwStartTagNameError(m_uri, m_name);
        }
        
        // create new string if needed
        String filterString = (String)obj;
        if (filterString == null) {
            filterString = new String();
        }

        ctx.toStart();

        // Process content of Filter tag
        boolean processed = false;
        String initialTag =  ctx.getElementName();
        while (!processed) {
            filterString += ctx.getText();
            ctx.nextToken();
            
            processed = (initialTag.equals(ctx.getElementName()));
        }
        filterString += ctx.getText();

        ctx.parsePastEndTag(m_uri, m_name);
        return filterString;
    }
}
