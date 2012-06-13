package org.geonetwork.services.ebrim.csw202.record;

import org.junit.Test;
import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.csw202.record.BriefRecord;
import org.geonetwork.domain.csw202.record.SummaryRecord;
import org.geonetwork.domain.csw202.record.Record;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for RegistryObjectToAbstractRecord
 *
 * @author Jose
 */
public class RegistryObjectToAbstractRecordTest extends TestCase {

    @Test
    public void testConvert() {
        RegistryObject r = RegistryObjectFactory.create();

        AbstractRecord a =  RegistryObjectToAbstractRecord.convert(ElementSet.brief, null, r);
        assertTrue(a instanceof BriefRecord);

        a =  RegistryObjectToAbstractRecord.convert(ElementSet.summary, null, r);
        assertTrue(a instanceof SummaryRecord);

        a =  RegistryObjectToAbstractRecord.convert(ElementSet.full, null, r);
        assertTrue(a instanceof Record);

        List<String> elementNames = new ArrayList<String>();
        elementNames.add("identifier");
        a =  RegistryObjectToAbstractRecord.convert(null, elementNames, r);
        assertTrue(a instanceof Record);
    }
}
