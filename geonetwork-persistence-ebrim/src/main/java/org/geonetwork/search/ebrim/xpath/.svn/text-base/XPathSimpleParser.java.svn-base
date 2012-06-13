package org.geonetwork.search.ebrim.xpath;

import java.util.List;
import java.util.ArrayList;

/**
 * Class to parse XPath expressions in
 *
 * @author Jose
 */
public class XPathSimpleParser {

    public List<XPathToken> parse(String xpath) {
        int initPosition = 0;
        if (xpath.startsWith("/")) xpath = xpath.substring(1);
        int sepPosition = xpath.indexOf('/');

        List<XPathToken> tokenList = new ArrayList<XPathToken>();

        while (true) {
            String token = xpath.substring(initPosition, sepPosition);

            // Attribute
            if (token.startsWith("@")) {
                tokenList.add(new XPathToken("", token.replace("@", ""), XPathToken.XPathTokenType.XPATH_ATTRIBUTE));
            } else {
                String tokenValue = token;
                String predicateValue = null;
                XPathPredicate predicate = null;
                XPathToken xpathToken;

                // Check if have a selector
                if (token.endsWith("]")) {
                    tokenValue = token.substring(0, token.indexOf("["));
                    predicateValue = token.substring(token.indexOf("[") + 1, token.indexOf("]"));

                   predicate = new XPathPredicate(predicateValue);
                }

                // Element
                String[] tokenElements = tokenValue.split(":");
                if (tokenElements.length > 1) {
                    xpathToken = new XPathToken(tokenElements[0], tokenElements[1], predicate, XPathToken.XPathTokenType.XPATH_ELEMENT);
                } else {
                    xpathToken = new XPathToken("", token, predicate, XPathToken.XPathTokenType.XPATH_ELEMENT);
                }

                tokenList.add(xpathToken);
            }

            // Exit condition
            if (sepPosition >= xpath.length()) break;

            initPosition = sepPosition + 1;
            sepPosition = xpath.indexOf('/', initPosition);

            // Ignore / in predicate
            int b1 = xpath.indexOf("[",initPosition);
            int b2 = xpath.indexOf("]",initPosition);
            if ((sepPosition > b1) && (sepPosition < b2)) sepPosition = xpath.indexOf('/', b2+1);

            if (sepPosition == -1) sepPosition = xpath.length();
        }

        return tokenList;
    }


}
