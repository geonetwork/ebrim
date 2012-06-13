package org.geonetwork.services.ebrim.csw202.record;

import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.csw202.record.SummaryRecord;
import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.utils.FindSlot;
import org.apache.log4j.Logger;

import java.util.Set;

/**
 * Transformation from RegistryObject to SummaryRecord
 *
 * @author Jose
 */
public class SummaryRecordConversion extends AbstractRecordConversion {
    private static Logger log = Logger.getLogger(BriefRecordConversion.class);

    public AbstractRecord convert(RegistryObject registryObject) {
        SummaryRecord summary = new SummaryRecord();

        //
        // identifier
        //
        String identifier = registryObject.getId().getValue();
        summary.setIdentifier(identifier);

        //
        // title
        //
        if (registryObject.getName() != null) {
            Set<LocalizedString> lsName = registryObject.getName().getLocalizedStrings();
            for (LocalizedString s : lsName) {
                summary.setTitle(s.getValue());
                break;
            }
        } else {
            summary.setTitle("");    
        }

        //
        // type
        //
        if (registryObject.getObjectType() != null) {
            String type = registryObject.getObjectType().getValue();
            summary.setType(type);
        }
        
        //
        // bounding box
        //
        Slot envelopeSlot = FindSlot.findByName(registryObject, "http://purl.org/dc/terms/spatial");
        if (envelopeSlot != null) {            
            BoundingBox boundingBox = FindSlot.createBoundingBox(envelopeSlot);
            summary.setBoundingBox(boundingBox);
        }

        //
        // subject
        //
        Slot subjectSlot = FindSlot.findByName(registryObject, "http://purl.org/dc/elements/1.1/subject");
        if (subjectSlot != null) {
            String subject = FindSlot.findslotValueAsString(subjectSlot);
            summary.setSubject(subject);
        }

        //
        // format
        //
        summary.setFormat(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/format"));

        //
        // relation
        //
        summary.setRelation(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/relation"));

        //
        // modified
        //
        summary.setModified(findSlotValue(registryObject, "http://purl.org/dc/terms/modified"));

        //
        // abstrack
        //
        if (registryObject.getDescription() != null) {
            Set<LocalizedString> lsDescription = registryObject.getDescription().getLocalizedStrings();
            for (LocalizedString s : lsDescription) {
                summary.setAbstrakt(s.getValue());
                break;
            }
        }

        return summary;
    }
}
