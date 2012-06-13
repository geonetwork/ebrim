package org.geonetwork.search.ebrim.xpath;

public class XPathToken {
    public enum XPathTokenType {
        XPATH_ELEMENT, XPATH_ATTRIBUTE
    };

    private String prefix;
    private String name;
    private XPathPredicate predicate;
    private XPathTokenType type;

    XPathToken(String prefix, String name, XPathTokenType type) {
        this(prefix, name, null, type);
    }

    XPathToken(String prefix, String name, XPathPredicate predicate, XPathTokenType type) {
        this.prefix = prefix;
        this.name = name;
        this.type = type;
        this.predicate = predicate;
    }

    public String getPrefix() {
        return prefix;
    }


    public String getName() {
        return name;
    }

    public String getFullName() {
        if (!prefix.equals(""))
            return prefix + ":" + name;
        else
            return name;
    }

    public XPathTokenType getType() {
        return type;
    }

    public XPathPredicate getPredicate() {
        return predicate;
    }

    public boolean hasPredicate() {
        return (predicate != null);
    }

};


