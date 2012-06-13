package org.geonetwork.search.ebrim.adhoc;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.search.ebrim.SearchEngineException;

import java.util.List;
import java.util.Map;

/**
 * Interface to implement Adhoc queries
 */
public abstract class AdhocQuerySearch {
     public static String getIdentifier() {
         return null;
     }
    
     public abstract List<? extends RegistryObject> query(Map<String, String> parameters) throws SearchEngineException;
}
