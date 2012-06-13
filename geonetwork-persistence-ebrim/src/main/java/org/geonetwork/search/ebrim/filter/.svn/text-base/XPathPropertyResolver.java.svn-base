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

package org.geonetwork.search.ebrim.filter;

import org.geonetwork.search.ebrim.filter.queryfields.Field;
import org.geonetwork.search.ebrim.xpath.XPathToken;
import org.geonetwork.search.ebrim.xpath.XPathSimpleParser;
import org.geonetwork.search.ebrim.xpath.XPathPredicate;
import org.geonetwork.domain.ebrim.informationmodel.xsd.AbstractValueList;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Class to resolve XPath expression in a filter to a lucene
 * index name, ready to use with Hibernate Search
 * <p/>
 * For example:
 * rim:Association/@associationType --> associationType.value
 *
 * @author Jose
 */
public class XPathPropertyResolver extends PropertyResolver {
    private String result = "";
    private String ebRimClass = "";

    private Map<String, String> predicates = new HashMap<String, String>();

    public XPathPropertyResolver(String propertyName) {
        super(propertyName);
        this.propertyName = propertyName;
    }

    public String getEbRimClass() {
        return ebRimClass;
    }

    public Field resolveProperty(String rootEntity) {
        fixPropertyNameWithRootEntity(rootEntity);

        if (!validate(propertyName)) return null;

        String name = internalResolveProperty();

        return new Field(name, predicates);
    }

    private String internalResolveProperty() {
        result = "";
        ebRimClass = "";

        boolean firstToken = true;
        List<XPathToken> tokens = new XPathSimpleParser().parse(propertyName);

        for (XPathToken token : tokens) {
            if (firstToken) {
                ebRimClass = token.getName();
                firstToken = false;
            } else {
                concatProperty(token);
            }

        }

        result = result + ".value";

        return result;
    }

    private void concatProperty(XPathToken property) {
        String mappedProperty = EbRimToModelPropertiesMapper.getPropertyName(property.getFullName());
        if (mappedProperty == null) mappedProperty = property.getFullName();

        if (result.trim().equalsIgnoreCase("")) {
            result = mappedProperty;
        } else {
            result = result + "." + mappedProperty;
        }

        // Process predicate for the property
        if (property.hasPredicate()) {
            Map<String, String> predicateValues = property.getPredicate().getValues();

            for (String predicateProperty : predicateValues.keySet()) {
                predicates.put(result + "." + predicateProperty + ".value", predicateValues.get(predicateProperty));
            }
        }
    }

    private void fixPropertyNameWithRootEntity(String rootEntity) {
        if ((rootEntity == null) || (rootEntity.trim().equals(""))) return;

        // Check if propertyName starts with the rootEntity, if not then append
        if (!propertyName.startsWith("/" + rootEntity)) {
            propertyName = "/" + rootEntity + "/" + propertyName;
        }
    }

    /**
     * Validate that the property it's valid
     *
     * @param property
     * @return
     */
    private boolean validate(String property) {
        List<XPathToken> tokens = new XPathSimpleParser().parse(property);
        Class classz = null;
        boolean firstToken = true;

        for (XPathToken token : tokens) {
            if (firstToken) {
                classz = TypeNamesMapper.getTypeNameClass(token.getFullName());
                firstToken = false;
                continue;
            }

            String value = "";

            if (token.getType() == XPathToken.XPathTokenType.XPATH_ELEMENT) {
                value = EbRimToModelPropertiesMapper.getPropertyName(token.getFullName());
            } else {
                value = token.getName();
            }

            String items[] = value.split("\\.");

            for (int i = 0; i < items.length; i++) {
                java.lang.reflect.Field ff = getDeclaredField(items[i], classz);

                //java.lang.reflect.Field ff = getDeclaredField(value, classz);

                if (ff != null) {
                    if ((ff.getType().equals(Set.class)) || ((ff.getType().equals(List.class)))) {
                        classz = TypeNamesMapper.getTypeNameClass(token.getFullName());

                        // Process predicate
                        if (token.hasPredicate()) {
                            XPathPredicate pred = token.getPredicate();

                            Map<String, String> values = pred.getValues();
                            Set<String> keySet = values.keySet();
                            for (String key : keySet) {
                                String v = values.get(key);

                                // Check valid slot name
                                if (classz.equals(Slot.class)) {
                                    if (key.equals("name")) {

                                        boolean isValid = SlotNames.isValidSlotName(v);
                                        if (!isValid) return false;
                                    }
                                }
                            }
                        }

                    } else {
                        if (ff.getType().getSuperclass().equals(AbstractValueList.class)) {
                            classz = TypeNamesMapper.getTypeNameClass(token.getFullName());
                        } else {
                            classz = ff.getType();
                        }
                    }


                } else {
                    return false;
                }
            } // for items[]
        }

        return true;
    }


    private java.lang.reflect.Field getDeclaredField(String field, Class classz) {
        java.lang.reflect.Field ff = null;

        try {
            ff = classz.getDeclaredField(field);
        } catch (Exception ee) {
            try {
                if (classz.getSuperclass() != null) {
                    ff = getDeclaredField(field, classz.getSuperclass());
                }

            } catch (Exception e) {

            }
        }

        return ff;
    }
}
