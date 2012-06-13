package org.geonetwork.services.ebrim.csw202.registryobject;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.services.ebrim.csw202.registryobject.BriefRegistryObjectConversion;
import org.apache.log4j.Logger;

/**
 * Transformation from RegistryObject to sumary RegistryObject:
 *      rim:RegistryObject/@id
 *      rim:RegistryObject/@lid
 *      rim:RegistryObject/@objectType
 *      rim:RegistryObject/@status
 *      rim:RegistryObject/rim:VersionInfo
 *
 *      rim:RegistryObject/rim:Slot
 *      rim:RegistryObject/rim:Name (in preferred language)
 *      rim:RegistryObject/rim:Description (in preferred language)
 *
 * @author Jose
 */
public class SummaryRegistryObjectConversion extends BriefRegistryObjectConversion {
    private static Logger log = Logger.getLogger(SummaryRegistryObjectConversion.class);

    public RegistryObject convert(RegistryObject registryObject) {
        RegistryObject summary = super.convert(registryObject);

        //
        // slot
        //
         summary.setSlots(registryObject.getSlots());

        //
        // name
        //
        summary.setName(registryObject.getName());

        //
        // description
        //
        summary.setDescription(registryObject.getDescription());

        return summary;
    }
}