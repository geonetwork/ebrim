package org.geonetwork.services.ebrim.csw202.record;

import org.geonetwork.domain.csw202.record.BriefRecord;
import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.utils.FindSlot;
import org.apache.log4j.Logger;

import java.util.Set;

/**
 * Transformation from RegistryObject to BriefRecord
 *
 * @author Jose
 */
public class BriefRecordConversion extends AbstractRecordConversion {

    public AbstractRecord convert(RegistryObject registryObject) {
        BriefRecord brief = new BriefRecord();
        //
        // identifier
        //
        String identifier = registryObject.getId().getValue();
        brief.setIdentifier(identifier);

        //
        // title
        //
        if (registryObject.getName() != null) {
            Set<LocalizedString> ls = registryObject.getName().getLocalizedStrings();
            for (LocalizedString s : ls) {
                brief.setTitle(s.getValue());
                break;
            }
        } else {
            brief.setTitle("");    
        }

        //
        // type
        //
        if (registryObject.getObjectType() != null) {
            String type = registryObject.getObjectType().getValue();
            brief.setType(type);
        }

        //
        // bounding box
        //
        Slot envelopeSlot = FindSlot.findByName(registryObject, "http://purl.org/dc/terms/spatial");
        if (envelopeSlot != null) {
            BoundingBox boundingBox = FindSlot.createBoundingBox(envelopeSlot);
            brief.setBoundingBox(boundingBox);
        }

        return brief;
    }
}
