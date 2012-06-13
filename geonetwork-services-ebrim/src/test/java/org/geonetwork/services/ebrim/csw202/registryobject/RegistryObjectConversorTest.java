package org.geonetwork.services.ebrim.csw202.registryobject;

import junit.framework.TestCase;
import org.junit.Test;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.test.utilities.cooperatingregistries.RegistryFactory;
import org.geonetwork.domain.csw202.discovery.ElementSet;

/**
 * Test class for RegistryObjectConversor
 *
 * @author Jose
 */
public class RegistryObjectConversorTest extends TestCase {

    @Test
    public void testConvert() {
        RegistryObject r = RegistryFactory.create();
        assertNotNull(r.getSlots());
        assertTrue(r.getSlots().size() > 0);
        assertNotNull(r.getName());

        RegistryObject result = RegistryObjectConversor.convert(ElementSet.brief, null, r);
        assertNull(result.getSlots());
        assertNull(result.getName());

        result = RegistryObjectConversor.convert(ElementSet.summary, null, r);
        assertNotNull(result.getSlots());
        assertNotNull(result.getName());

        result = RegistryObjectConversor.convert(ElementSet.full, null, r);
        assertSame(r, result);
    }
}
