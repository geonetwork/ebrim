package org.geonetwork.services.ebrim.csw202.registryobject;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.services.ebrim.csw202.registryobject.AbstractRegistryObjectConversion;

/**
 * Transformation from RegistryObject to brief RegistryObject:
 *      rim:RegistryObject/@id
 *      rim:RegistryObject/@lid
 *      rim:RegistryObject/@objectType
 *      rim:RegistryObject/@status
 *      rim:RegistryObject/rim:VersionInfo
 *
 * @author Jose
 */
public class BriefRegistryObjectConversion extends AbstractRegistryObjectConversion {

    public RegistryObject convert(RegistryObject registryObject) {
         RegistryObject brief = new RegistryObject();

        //
        // identifier
        //
        brief.setId(registryObject.getId());

        //
        // lid
        //
        brief.setLid(registryObject.getLid());

        //
        // objecttype
        //
        brief.setObjectType(registryObject.getObjectType());

        //
        // status
        //
        brief.setStatus(registryObject.getStatus());

        //
        // versioninfo
        //
        brief.setVersionInfo(registryObject.getVersionInfo());

        return brief;
    }
}