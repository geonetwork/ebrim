package org.geonetwork.services.ebrim.csw202.registryobject;

import org.junit.Test;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import junit.framework.TestCase;

/**
 * Test class for SummaryRegistryObjectConversion
 *
 * @author Jose
 */
public class SummaryRegistryObjectConversionTest extends TestCase {

    @Test
    public void testConvert() {
        RegistryObject r = RegistryObjectFactory.create();

        SummaryRegistryObjectConversion summaryConversion = new SummaryRegistryObjectConversion();

        RegistryObject result = summaryConversion.convert(r);

        assertEquals(r.getId(), result.getId());
        assertEquals(r.getLid(), result.getLid());
        assertEquals(r.getObjectType(), result.getObjectType());
        assertEquals(r.getStatus(), result.getStatus());
        assertEquals(r.getVersionInfo(), result.getVersionInfo());
        assertEquals(r.getName(), result.getName());
        assertEquals(r.getDescription(), result.getDescription());
        assertEquals(r.getSlots(), result.getSlots());       
    }
}
