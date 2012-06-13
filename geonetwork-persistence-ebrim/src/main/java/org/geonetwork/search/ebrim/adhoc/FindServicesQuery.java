package org.geonetwork.search.ebrim.adhoc;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.dao.ebrim.informationmodel.ServiceDao;

import java.util.List;
import java.util.Map;

/**
 * Returns a listing of all service offers.
 *
 * Query parameters: serviceType (optional)
 *                   A service type code value from the ISO 19119 services taxonomy.   
 *
 * @author Jose
 */
public class FindServicesQuery extends AdhocQuerySearch {
    private static final String QUERY_IDENTIFIER = "urn:ogc:def:ebRIM-Query:OGC:findServices";

    ServiceDao serviceDao;

    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    public static String getIdentifier() {
            return QUERY_IDENTIFIER;
    }
    
    public List<? extends RegistryObject> query(Map<String, String> parameters) {
        return serviceDao.loadAllService();
    }
}
