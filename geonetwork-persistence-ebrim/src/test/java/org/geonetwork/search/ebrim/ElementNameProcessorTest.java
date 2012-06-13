package org.geonetwork.search.ebrim;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import org.junit.Test;

public class ElementNameProcessorTest extends TestCase {

    @Test
    public void testProcess() {
        RegistryObject reg1 = RegistryObjectFactory.create();
        reg1.setStatus(new URI("status1"));
        RegistryObject reg2 = RegistryObjectFactory.create();
        reg1.setStatus(new URI("status2"));

        List<RegistryObject> list = new ArrayList<RegistryObject>();
        list.add(reg1);
        list.add(reg2);

        List<String> elementNames = new ArrayList<String>();
        elementNames.add("rim:RegistryObject/@status");
        elementNames.add("rim:RegistryObject/classifications/@classificationNode");

        ElementNameProcessor.processElementNames(list, elementNames, null);        
    }
}
