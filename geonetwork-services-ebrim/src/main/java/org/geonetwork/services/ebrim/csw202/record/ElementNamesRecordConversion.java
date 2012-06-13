package org.geonetwork.services.ebrim.csw202.record;

import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.csw202.record.Record;
import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.utils.FindSlot;

import java.util.List;
import java.util.Set;

/**
 * Transformation from RegistryObject to Record filling the properties specified in
 * ElementNames in the query
 */
public class ElementNamesRecordConversion {
    public AbstractRecord convert(RegistryObject registryObject, List<String> elementNames) {
        Record record = new Record();

        for (String elementName : elementNames) {
            elementName = removeElementnameNamespace(elementName);

            addElementNameToRecord(record, registryObject, elementName);
        }

        return record;
    }

    /**
     * Add an element name property of RegistryObject to Record
     * 
     * @param record
     * @param registryObject
     * @param elementName
     */
    private void addElementNameToRecord(Record record, RegistryObject registryObject, String elementName) {
        // audience
        if (elementName.equals("audience")) {
            record.setAudience(findSlotValue(registryObject, "http://purl.org/dc/terms/audience"));

        // educationLevel
        } else if (elementName.equals("educationLevel")) {
            record.setEducationLevel(findSlotValue(registryObject, "http://purl.org/dc/terms/educationLevel"));

        // mediator
        } else if (elementName.equals("mediator")) {
            record.setMediator(findSlotValue(registryObject, "http://purl.org/dc/terms/mediator"));

        // contributor
        } else if (elementName.equals("contributor")) {
            record.setContributor(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/contributor"));

        // coverage
        } else if (elementName.equals("coverage")) {
            record.setCoverage(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/coverage"));

        // temporal
        } else if (elementName.equals("temporal")) {
            record.setTemporal(findSlotValue(registryObject, "http://purl.org/dc/terms/temporal"));

        // creator
        } else if (elementName.equals("creator")) {
            record.setCreator(findSlotValue(registryObject, "http://purl.org/dc/terms/creator"));

        // date
        } else if (elementName.equals("date")) {
            record.setDate(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/date"));

        // available
        } else if (elementName.equals("available")) {
            record.setAvailable(findSlotValue(registryObject, "http://purl.org/dc/terms/avalaible"));

        // created
        } else if (elementName.equals("created")) {
            record.setCreated(findSlotValue(registryObject, "http://purl.org/dc/terms/created"));

        // dateAccepted
        } else if (elementName.equals("dateAccepted")) {
            record.setDateAccepted(findSlotValue(registryObject, "http://purl.org/dc/terms/dateAccepted"));

        // dateCopyrighted
        } else if (elementName.equals("dateCopyrighted ")) {
            record.setAvailable(findSlotValue(registryObject, "http://purl.org/dc/terms/dateCopyrighted"));

        // dateSubmitted
        } else if (elementName.equals("dateSubmitted")) {
            record.setDateSubmitted(findSlotValue(registryObject, "http://purl.org/dc/terms/dateSubmitted"));

        // issued
        } else if (elementName.equals("issued")) {
            record.setIssued(findSlotValue(registryObject, "http://purl.org/dc/terms/issued"));

        // modified
        } else if (elementName.equals("modified")) {
            record.setModified(findSlotValue(registryObject, "http://purl.org/dc/terms/modified"));

        // valid
        } else if (elementName.equals("valid")) {
            record.setValid(findSlotValue(registryObject, "http://purl.org/dc/terms/valid"));

        // description
        } else if (elementName.equals("description")) {
            record.setDescription(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/description"));

        // abstrakt
        } else if (elementName.equals("abstract")) {
            if (registryObject.getDescription() != null) {
                Set<LocalizedString> lsDescription = registryObject.getDescription().getLocalizedStrings();
                for (LocalizedString s : lsDescription) {
                    record.setAbstrakt(s.getValue());
                    break;
                }
            }

        // tableOfContents
        } else if (elementName.equals("tableOfContents")) {
            record.setTableOfContents(findSlotValue(registryObject, "http://purl.org/dc/terms/avalaible"));

        // format
        } else if (elementName.equals("format")) {
            record.setFormat(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/format"));

        // extent
        } else if (elementName.equals("extent")) {
            record.setExtent(findSlotValue(registryObject, "http://purl.org/dc/terms/extent"));

        // medium
        } else if (elementName.equals("medium")) {
            record.setMedium(findSlotValue(registryObject, "http://purl.org/dc/terms/medium"));

        // identifier
        } else if (elementName.equals("identifier")) {
            String identifier = registryObject.getId().getValue();
            record.setIdentifier(identifier);

        // bibliographicCitation
        } else if (elementName.equals("bibliographicCitation")) {
            record.setBibliographicCitation(findSlotValue(registryObject, "http://purl.org/dc/terms/bibliographicCitation"));

        // language
        } else if (elementName.equals("language")) {
            record.setLanguage(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/language"));

        // provenance
        } else if (elementName.equals("provenance")) {
            record.setProvenance(findSlotValue(registryObject, "http://purl.org/dc/terms/provenance"));

        // publisher
        } else if (elementName.equals("publisher")) {
            record.setPublisher(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/publisher"));

        // relation
        } else if (elementName.equals("relation")) {
            record.setRelation(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/relation"));

        // conformsTo
        } else if (elementName.equals("conformsTo")) {
            record.setConformsTo(findSlotValue(registryObject, "http://purl.org/dc/terms/conformsTo"));

        // hasFormat
        } else if (elementName.equals("hasFormat")) {
            record.setHasFormat(findSlotValue(registryObject, "http://purl.org/dc/terms/hasFormat"));

        // hasPart
        } else if (elementName.equals("hasPart")) {
            record.setHasPart(findSlotValue(registryObject, "http://purl.org/dc/terms/hasPart"));

        // hasVersion
        } else if (elementName.equals("hasVersion")) {
            record.setHasVersion(findSlotValue(registryObject, "http://purl.org/dc/terms/hasVersion"));

        // isFormatOf
        } else if (elementName.equals("isFormatOf")) {
            record.setFormatOf(findSlotValue(registryObject, "http://purl.org/dc/terms/isFormatOf"));

        // isPartOf
        } else if (elementName.equals("isPartOf")) {
            record.setPartOf(findSlotValue(registryObject, "http://purl.org/dc/terms/isPartOf"));

        // isReferencedBy
        } else if (elementName.equals("isReferencedBy")) {
            record.setReferencedBy(findSlotValue(registryObject, "http://purl.org/dc/terms/isReferencedBy"));

        // isReplacedBy
        } else if (elementName.equals("isReplacedBy")) {
            record.setReplacedBy(findSlotValue(registryObject, "http://purl.org/dc/terms/isReplacedBy"));

        // isRequiredBy
        } else if (elementName.equals("isRequiredBy")) {
            record.setRequiredBy(findSlotValue(registryObject, "http://purl.org/dc/terms/isRequiredBy"));

        // isVersionOf
        } else if (elementName.equals("isVersionOf")) {
            record.setVersionOf(findSlotValue(registryObject, "http://purl.org/dc/terms/isVersionOf"));

        // references
        } else if (elementName.equals("references")) {
            record.setReferences(findSlotValue(registryObject, "http://purl.org/dc/terms/references"));

        // replaces
        } else if (elementName.equals("replaces")) {
            record.setReplaces(findSlotValue(registryObject, "http://purl.org/dc/terms/replaces"));

        // requires
        } else if (elementName.equals("requires")) {
            record.setRequires(findSlotValue(registryObject, "http://purl.org/dc/terms/requires"));

        // rights
        } else if (elementName.equals("rights")) {
            record.setRights(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/rights"));

        // accessRights
        } else if (elementName.equals("accessRights")) {
            record.setAccessRights(findSlotValue(registryObject, "http://purl.org/dc/terms/accessRights"));

        // license
        } else if (elementName.equals("accessRights")) {
            record.setLicense(findSlotValue(registryObject, "http://purl.org/dc/terms/license"));

        // rightsHolder
        } else if (elementName.equals("rightsHolder")) {
            record.setRightsHolder(findSlotValue(registryObject, "http://purl.org/dc/terms/rightsHolder"));

        // source
        } else if (elementName.equals("source")) {
            record.setSource(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/source"));

        // subject
        } else if (elementName.equals("subject")) {
            record.setSubject(findSlotValue(registryObject, "http://purl.org/dc/elements/1.1/subject"));

        // title
        } else if (elementName.equals("title")) {
            if (registryObject.getName() != null) {
                Set<LocalizedString> lsName = registryObject.getName().getLocalizedStrings();
                for (LocalizedString s : lsName) {
                    record.setTitle(s.getValue());
                    break;
                }
            }

        // alternative
        } else if (elementName.equals("alternative")) {
            record.setAlternative(findSlotValue(registryObject, "http://purl.org/dc/terms/alternative"));

        // type
        } else if (elementName.equals("type")) {
            if (registryObject.getObjectType() != null) {
                String type = registryObject.getObjectType().getValue();
                record.setType(type);
            }

        //
        // bounding box
        //
        } else if (elementName.equals("boundingbox")) {
            Slot envelopeSlot = FindSlot.findByName(registryObject, "http://purl.org/dc/terms/spatial");
            if (envelopeSlot != null) {
                BoundingBox boundingBox = FindSlot.createBoundingBox(envelopeSlot);
                record.setBoundingBox(boundingBox);
            }
        }

    }

    private String removeElementnameNamespace(String elementName) {
        String[] tokens = elementName.split(":");
        if (tokens.length == 2)
            return tokens[1];
        else
            return elementName;
    }

    public String findSlotValue(RegistryObject registryObject, String url) {
        Slot slot = FindSlot.findByName(registryObject, url);
        if (slot != null)
            return FindSlot.findslotValueAsString(slot);
        else
            return "";
    }
}
