package org.geonetwork.services.ebrim.csw202.record;

import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;

import java.util.List;

/**
 * Class to manage conversions from RegistryObject to AbstractRecord
 *
 * @author Jose
 */
public class RegistryObjectToAbstractRecord {

    public static AbstractRecord convert(ElementSet elementSet, List<String> elementNames,
			RegistryObject registryObject) {

        if (elementSet != null) {
            if (elementSet == ElementSet.brief) {
                return new BriefRecordConversion().convert(registryObject);

            }  else if (elementSet == ElementSet.full) {
                return new FullRecordConversion().convert(registryObject);

            } else {
                return new SummaryRecordConversion().convert(registryObject);
            }
        } else {
            return new ElementNamesRecordConversion().convert(registryObject, elementNames);
        }
    }
}
