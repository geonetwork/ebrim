package org.geonetwork.services.ebrim.csw202.record;

import junit.framework.TestCase;
import org.junit.Test;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.InternationalString;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.*;
import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.csw202.record.BriefRecord;
import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.csw202.record.SummaryRecord;
import org.geonetwork.domain.utils.FindSlot;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Test class for SummaryRecordConversion
 *
 * @author Jose
 */
public class SummaryRecordConversionTest extends TestCase {

    @Test
    public void testConversion() {
        RegistryObject r = createTestRegistryObject();

        SummaryRecordConversion summaryConversion = new SummaryRecordConversion();

        AbstractRecord record = summaryConversion.convert(r);
        assertTrue(record instanceof SummaryRecord);

        SummaryRecord summaryRecord = (SummaryRecord) record;

        // id
        assertEquals(r.getId().getValue(), summaryRecord.getIdentifier());

        // type
        assertEquals(r.getObjectType().getValue(), summaryRecord.getType());

        // title
        Set<LocalizedString> ls = r.getName().getLocalizedStrings();
        boolean titleFinded = false;
        for (LocalizedString s : ls) {
            if (summaryRecord.getTitle().equals(s.getValue())) {
                titleFinded = true;
                break;
            }
        }
        assertTrue(titleFinded);

        // subject
        Slot subjectSlot = FindSlot.findByName(r, "http://purl.org/dc/elements/1.1/subject");
        assertEquals(FindSlot.findslotValueAsString(subjectSlot), summaryRecord.getSubject());

        // format
        Slot formatSlot = FindSlot.findByName(r, "http://purl.org/dc/elements/1.1/format");
        assertEquals(FindSlot.findslotValueAsString(formatSlot), summaryRecord.getFormat());

        // relation
        Slot relationSlot = FindSlot.findByName(r, "http://purl.org/dc/elements/1.1/relation");
        assertEquals(FindSlot.findslotValueAsString(relationSlot), summaryRecord.getRelation());

        // modified
        Slot modifiedSlot = FindSlot.findByName(r, "http://purl.org/dc/terms/modified");
        assertEquals(FindSlot.findslotValueAsString(modifiedSlot), summaryRecord.getModified());

        // abstrakt
        boolean abstrackFinded = false;
        Set<LocalizedString> lsDescription = r.getDescription().getLocalizedStrings();
        for (LocalizedString s : lsDescription) {
            if (summaryRecord.getAbstrakt().equals(s.getValue())) {
                abstrackFinded = true;
                break;
            }
        }
        assertTrue(abstrackFinded);

        // boundingbox
        Slot envelopeSlot = FindSlot.findByName(r, "http://purl.org/dc/terms/spatial");
        BoundingBox b = FindSlot.createBoundingBox(envelopeSlot);
        assertEquals(b, summaryRecord.getBoundingBox());

    }


    private RegistryObject createTestRegistryObject() {
        RegistryObject r = RegistryObjectFactory.create();
        InternationalString is = new InternationalString();
        Set<LocalizedString> ls = new HashSet<LocalizedString>();
        LocalizedString description = new LocalizedString();
        description.setValue("abstract");
        ls.add(description);
        is.setLocalizedStrings(ls);
        r.setDescription(is);

        Slot boundingBoxSlot = new Slot();
        boundingBoxSlot.setName(new LongName("http://purl.org/dc/terms/spatial"));
        ValueList basicExtensionValueList = new ValueList();
        List<AnyValue> bb = new ArrayList<AnyValue>();
        AnyValue a = new AnyValue();
        Envelope env = new Envelope();
        env.setLowerCorner(new LowerCorner("10 10"));
        env.setUpperCorner(new UpperCorner("30 30"));
        a.setValue(env);

        bb.add(a);
        basicExtensionValueList.setValues(bb);

        boundingBoxSlot.setBasicExtensionValueList(basicExtensionValueList);
        r.addSlot(boundingBoxSlot);


         org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList vl;


        // Subject slot
        Slot subjectSlot = new Slot();
        subjectSlot.setName(new LongName("http://purl.org/dc/elements/1.1/subject"));
        vl = new  org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList();
        vl.add(new LongName("subject"));
        subjectSlot.setValueList(vl);
        r.addSlot(subjectSlot);

        // format slot
        Slot formatSlot = new Slot();
        formatSlot.setName(new LongName("http://purl.org/dc/elements/1.1/format"));
        vl = new  org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList();
        vl.add(new LongName("format"));
        subjectSlot.setValueList(vl);
        r.addSlot(formatSlot);

        // relation slot
        Slot relationSlot = new Slot();
        relationSlot.setName(new LongName("http://purl.org/dc/elements/1.1/relation"));
        vl = new  org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList();
        vl.add(new LongName("format"));
        subjectSlot.setValueList(vl);
        r.addSlot(relationSlot);



        // modified slot
        Slot modifiedSlot = new Slot();
        modifiedSlot.setName(new LongName("http://purl.org/dc/terms/modified"));
        vl = new  org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList();
        vl.add(new LongName("modified"));
        subjectSlot.setValueList(vl);
        r.addSlot(modifiedSlot);

        return r;
    }

}