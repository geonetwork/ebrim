package org.geonetwork.services.ebrim.csw202.record;

import junit.framework.TestCase;
import org.junit.Test;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LocalizedString;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.*;
import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.csw202.record.BriefRecord;
import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.utils.FindSlot;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * Test class for BriefRecordConversion
 *
 * @author Jose
 */
public class BriefRecordConversionTest extends TestCase {

    @Test
    public void testConversion() {
        RegistryObject r = createTestRegistryObject();

        BriefRecordConversion briefConversion = new BriefRecordConversion();

        AbstractRecord record = briefConversion.convert(r);
        assertTrue(record instanceof BriefRecord);

        BriefRecord briefRecord = (BriefRecord) record;

        // id
        assertEquals(r.getId().getValue(), briefRecord.getIdentifier());
        // type
        assertEquals(r.getObjectType().getValue(), briefRecord.getType());

        // title
        Set<LocalizedString> ls = r.getName().getLocalizedStrings();
        boolean titleFinded = false;
        for (LocalizedString s : ls) {
            if (briefRecord.getTitle().equals(s.getValue())) {
                titleFinded = true;
                break;
            }
        }
        assertTrue(titleFinded);

        // boundingbox
        Slot envelopeSlot = FindSlot.findByName(r, "http://purl.org/dc/terms/spatial");
        BoundingBox b = FindSlot.createBoundingBox(envelopeSlot);
        assertEquals(b, briefRecord.getBoundingBox());

    }


    private RegistryObject createTestRegistryObject() {
        RegistryObject r = RegistryObjectFactory.create();
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

        return r;
    }

}
