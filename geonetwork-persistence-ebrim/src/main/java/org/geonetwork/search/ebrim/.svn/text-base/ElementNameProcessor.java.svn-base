package org.geonetwork.search.ebrim;

import org.apache.log4j.Logger;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.search.ebrim.filter.XPathPropertyResolver;
import org.geonetwork.search.ebrim.filter.queryfields.Field;

import java.util.*;
import java.lang.reflect.Method;


public class ElementNameProcessor {
    private static final String PROPERTY_SEPARATOR = "/";
    private static final String PROPERTY_VALUE = "@";

    private static Logger log = Logger.getLogger(ElementNameProcessor.class);


    public static void processElementNames(List<RegistryObject> data,
                                           List<String> elementNames, List<String> typeNames) {

        try {

            for (String elementName : elementNames) {
                XPathPropertyResolver xpathPresolver;
                if ((typeNames != null) && (typeNames.size() == 1)) {
                    // elementName can ignore typeName in this case
                    if (elementName.startsWith(PROPERTY_SEPARATOR + typeNames.get(0)))
                        xpathPresolver = new XPathPropertyResolver(elementName);

                    else
                        xpathPresolver = new XPathPropertyResolver(typeNames.get(0) + elementName);

                } else {
                    xpathPresolver = new XPathPropertyResolver(elementName);

                }


                Field field = xpathPresolver.resolveProperty("");
                String property = field.getFieldName();

                for (RegistryObject reg : data) {
                    infoValues(reg, null, property);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static RegistryObject processElementNames(RegistryObject data,
                                                     List<String> elementNames, List<String> typeNames) {

        Class params[] = {};
        Object paramsObj[] = {};
        RegistryObject dest = null;


        try {
            Class thisClass = Class.forName(data.getClass().getName());
            dest =(RegistryObject) thisClass.newInstance();

            for (String elementName : elementNames) {
                String[] elementNameTokens = elementName.split(PROPERTY_SEPARATOR);
                String className = elementNameTokens[0].split(":")[1];
                elementName = elementName.replace(elementNameTokens[0] + PROPERTY_SEPARATOR, "");
                if (data.getClass().getName().endsWith(className)) {
                   infoValues(data, dest, elementName);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dest;
    }

    private static void infoValues(Object obj, Object dest, String property) throws Exception {
        String[] path = property.split(PROPERTY_SEPARATOR);
        String actualProperty = property.replace(PROPERTY_VALUE, "");

        // Move throught property path to get it's value
        for (String p : path) {
            boolean isValue = p.startsWith(PROPERTY_VALUE);
            p = p.replace(PROPERTY_VALUE, "");

            // Check if is a collection
            if (obj instanceof Collection) {
                for (Object objElement : (Collection<?>) obj) {
                    infoValues(objElement, dest, actualProperty);
                    //returnValues.add(getValues(objElement, dest, actualProperty));
                }

                //return returnValues;

            } else {
                // Use reflection to get value of property
                String mname = "get" + capitalizeFirstLetter(p);
                Class<?>[] types = new Class[]{};
                Method method = obj.getClass().getMethod(mname, types);
                obj = method.invoke(obj, new Object[0]);

                String msetname = "set" + capitalizeFirstLetter(p);
                Class<?>[] settypes;
                if (obj.getClass().getName().equals("org.hibernate.collection.PersistentSet"))
                    settypes = new Class[]{Set.class};
                else
                    settypes = new Class[]{obj.getClass()};

                Method methodSet = dest.getClass().getMethod(msetname, settypes);

                if (isValue) {
                    methodSet.invoke(dest, obj);
                } else {
                    Class thisClass = Class.forName(obj.getClass().getName());
                    Object iClass = thisClass.newInstance();

                    methodSet.invoke(dest, iClass);

                    mname = "get" + capitalizeFirstLetter(p);
                    types = new Class[]{};
                    method = dest.getClass().getMethod(mname, types);
                    dest = method.invoke(dest, new Object[0]);
                }

            }
            actualProperty = actualProperty.replace(p + ".", "");
        }

        //returnValues.add(obj);

        //return returnValues;
    }

    private static String capitalizeFirstLetter(String text) {
        if ((text == null) || (text.equals(""))) return text;

        String firstLetter = text.substring(0, 1);  // Get first letter
        String remainder = text.substring(1);    // Get remainder of word.

        return firstLetter.toUpperCase() + remainder;
    }
}
