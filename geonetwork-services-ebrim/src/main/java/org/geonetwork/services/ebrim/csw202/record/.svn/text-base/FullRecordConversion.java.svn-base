package org.geonetwork.services.ebrim.csw202.record;

import org.geonetwork.domain.csw202.record.Record;
import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.utils.FindSlot;

import java.util.Set;

/**
 * Transformation from RegistryObject to Record
 *
 * @author Jose
 */
public class FullRecordConversion extends AbstractRecordConversion  {

    public AbstractRecord convert(RegistryObject registryObject) {
        Record full = new Record();

        // audience
        full.setAudience(findSlotValue(registryObject, "http://purl.org/dc/terms/audience"));

        // educationLevel
        full.setEducationLevel(findSlotValue(registryObject, "http://purl.org/dc/terms/educationLevel"));

        // mediator
        full.setMediator(findSlotValue(registryObject, "http://purl.org/dc/terms/mediator"));

        // contributor
        full.setContributor(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/contributor"));

        // coverage
        full.setCoverage(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/coverage"));

        // temporal
        full.setTemporal(findSlotValue(registryObject, "http://purl.org/dc/terms/temporal"));

        // creator
        full.setCreator(findSlotValue(registryObject, "http://purl.org/dc/terms/creator"));

        // date
        full.setDate(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/date"));

        // available
        full.setAvailable(findSlotValue(registryObject, "http://purl.org/dc/terms/avalaible"));

        // created
        full.setCreated(findSlotValue(registryObject, "http://purl.org/dc/terms/created"));

        // dateAccepted
        full.setDateAccepted(findSlotValue(registryObject, "http://purl.org/dc/terms/dateAccepted"));

        // dateCopyrighted
        full.setAvailable(findSlotValue(registryObject, "http://purl.org/dc/terms/dateCopyrighted"));

        // dateSubmitted
        full.setDateSubmitted(findSlotValue(registryObject, "http://purl.org/dc/terms/dateSubmitted"));

        // issued
        full.setIssued(findSlotValue(registryObject, "http://purl.org/dc/terms/issued"));

        // modified
        full.setModified(findSlotValue(registryObject, "http://purl.org/dc/terms/modified"));

        // valid
        full.setValid(findSlotValue(registryObject, "http://purl.org/dc/terms/valid"));

        // description
        full.setDescription(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/description"));

        // abstrakt
        if (registryObject.getDescription() != null) {
            Set<LocalizedString> lsDescription = registryObject.getDescription().getLocalizedStrings();
            for (LocalizedString s : lsDescription) {
                full.setAbstrakt(s.getValue());
                break;
            }
        }

        // tableOfContents
        full.setTableOfContents(findSlotValue(registryObject, "http://purl.org/dc/terms/avalaible"));

        // format
        full.setFormat(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/format"));

        // extent
        full.setExtent(findSlotValue(registryObject, "http://purl.org/dc/terms/extent"));

        // medium
        full.setMedium(findSlotValue(registryObject, "http://purl.org/dc/terms/medium"));

        // identifier
        String identifier = registryObject.getId().getValue();
        full.setIdentifier(identifier);

        // bibliographicCitation;
        full.setBibliographicCitation(findSlotValue(registryObject, "http://purl.org/dc/terms/bibliographicCitation"));

        // language
        full.setLanguage(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/language"));

        // provenance
        full.setProvenance(findSlotValue(registryObject, "http://purl.org/dc/terms/provenance"));

        // publisher
        full.setPublisher(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/publisher"));

        // relation
        full.setRelation(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/relation"));

        // conformsTo
        full.setConformsTo(findSlotValue(registryObject, "http://purl.org/dc/terms/conformsTo"));

        // hasFormat
        full.setHasFormat(findSlotValue(registryObject, "http://purl.org/dc/terms/hasFormat"));

        // hasPart
        full.setHasPart(findSlotValue(registryObject, "http://purl.org/dc/terms/hasPart"));

        // hasVersion
        full.setHasVersion(findSlotValue(registryObject, "http://purl.org/dc/terms/hasVersion"));

        // isFormatOf
        full.setFormatOf(findSlotValue(registryObject, "http://purl.org/dc/terms/isFormatOf"));

        // isPartOf
        full.setPartOf(findSlotValue(registryObject, "http://purl.org/dc/terms/isPartOf"));

        // isReferencedBy
        full.setReferencedBy(findSlotValue(registryObject, "http://purl.org/dc/terms/isReferencedBy"));

        // isReplacedBy
        full.setReplacedBy(findSlotValue(registryObject, "http://purl.org/dc/terms/isReplacedBy"));

        // isRequiredBy
        full.setRequiredBy(findSlotValue(registryObject, "http://purl.org/dc/terms/isRequiredBy"));

        // isVersionOf
        full.setVersionOf(findSlotValue(registryObject, "http://purl.org/dc/terms/isVersionOf"));

        // references
        full.setReferences(findSlotValue(registryObject, "http://purl.org/dc/terms/references"));

        // replaces
        full.setReplaces(findSlotValue(registryObject, "http://purl.org/dc/terms/replaces"));

        // requires
        full.setRequires(findSlotValue(registryObject, "http://purl.org/dc/terms/requires"));

        // rights
        full.setRights(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/rights"));

        // accessRights
        full.setAccessRights(findSlotValue(registryObject, "http://purl.org/dc/terms/accessRights"));

        // license
        full.setLicense(findSlotValue(registryObject, "http://purl.org/dc/terms/license"));

        // rightsHolder
        full.setRightsHolder(findSlotValue(registryObject, "http://purl.org/dc/terms/rightsHolder"));

        // source
        full.setSource(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/source"));

        // subject
        full.setSubject(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/subject"));

        // title
        if (registryObject.getName() != null) {
            Set<LocalizedString> lsName = registryObject.getName().getLocalizedStrings();
            for (LocalizedString s : lsName) {
                full.setTitle(s.getValue());
                break;
            }
        }

        // alternative;
        full.setAlternative(findSlotValue(registryObject, "http://purl.org/dc/terms/alternative"));

        // type
        if (registryObject.getObjectType() != null) {
            String type = registryObject.getObjectType().getValue();
            full.setType(type);
        }
        
        //
        // bounding box
        //
        Slot envelopeSlot = FindSlot.findByName(registryObject, "http://purl.org/dc/terms/spatial");
        if (envelopeSlot != null) {
            BoundingBox boundingBox = FindSlot.createBoundingBox(envelopeSlot);
            full.setBoundingBox(boundingBox);
        }

        return full;
    }
}
