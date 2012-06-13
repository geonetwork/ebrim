package org.geonetwork.services.ebrim.csw202.registryobject;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;

import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.lang.reflect.Method;

/**
 * Transformation from RegistryObject to RegistryObject filling the properties specified in
 * ElementNames in the query
 */

// TODO: Complete
public class ElementNamesRegistryObjectConversion {
    private static final String PROPERTY_SEPARATOR = "/";
    private static final String PROPERTY_VALUE = "@";

    public RegistryObject convert(RegistryObject registryObject, List<String> elementNames) {
        RegistryObject dest = null;

        try {
            Class thisClass = Class.forName(registryObject.getClass().getName());
            dest =(RegistryObject) thisClass.newInstance();

            for (String elementName : elementNames) {
                String[] elementNameTokens = elementName.split(PROPERTY_SEPARATOR);
                String className = elementNameTokens[0].split(":")[1];
                elementName = elementName.replace(elementNameTokens[0] + PROPERTY_SEPARATOR, "");
                if (registryObject.getClass().getName().endsWith(className)) {
                   infoValues(registryObject, dest, elementName);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dest;
    }

    private void infoValues(Object obj, Object dest, String property) throws Exception {
        String[] path = property.split(PROPERTY_SEPARATOR);

        // Move throught property path to get it's value
        for (String propertyName : path) {
            boolean isValue = propertyName.startsWith(PROPERTY_VALUE);
            propertyName = propertyName.replace(PROPERTY_VALUE, "");

            if (obj instanceof Collection) {
                for (Object objElement : (Collection<?>) obj) {
                    // TODO: Create element in collection


                    infoValues(objElement, dest, propertyName);
                }

            } else {
                // Use reflection to get value of property
                propertyName = capitalizeFirstLetter(propertyName);
                String mname = "get" + propertyName;
                Class<?>[] types = new Class[]{};
                Method method = obj.getClass().getMethod(mname, types);
                obj = method.invoke(obj, new Object[0]);

                String msetname = "set" + propertyName;
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

                    mname = "set" + propertyName;
                    types = new Class[]{};
                    method = dest.getClass().getMethod(mname, types);
                    dest = method.invoke(dest,iClass);
                }

            }

        }
    }

    private String capitalizeFirstLetter(String text) {
        if ((text == null) || (text.equals(""))) return text;

        String firstLetter = text.substring(0, 1);  // Get first letter
        String remainder = text.substring(1);    // Get remainder of word.

        return firstLetter.toUpperCase() + remainder;
    }
}