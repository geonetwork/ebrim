package org.geonetwork.services.ebrim.csw202.registryobject;

import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;

import java.util.List;

/**
 * Converts RegistryObject to brief, summary version
 *
 * @author Jose
 */
public class RegistryObjectConversor {
    public static RegistryObject convert(ElementSet elementSet, List<String> elementNames,
			RegistryObject registryObject) {

        if (elementSet != null) {
            if (elementSet == ElementSet.brief) {
                return new BriefRegistryObjectConversion().convert(registryObject);

            }  else if (elementSet == ElementSet.full) {
                return registryObject;

            } else {
                return new SummaryRegistryObjectConversion().convert(registryObject);
            }
        } else {
            return new ElementNamesRegistryObjectConversion().convert(registryObject, elementNames);
        }
    }
}
