//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================

package org.geonetwork.dao.facade;

import org.geonetwork.dao.ebrim.informationmodel.CoreDao;
import org.geonetwork.dao.ebrim.AbstractDaoTest;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;
import org.geonetwork.domain.ebrim.test.utilities.core.RegistryObjectFactory;
import org.junit.Test;

import java.util.List;

/**
 * Tests for RegistryObjectStoreFacade class
 *
 * @author Jose
 */
public class RegistryObjectStoreFacadeTest extends AbstractDaoTest {
    private static final String IDENTIFIER_NAME = "http://purl.org/dc/elements/1.1/identifier";

    CoreDao coreDao;
    RegistryObjectStoreFacade registryObjectStoreFacade;

    public void setCoreDao(CoreDao coreDao) {
        this.coreDao = coreDao;
    }

    @Override
    public void onSetUp() throws Exception {
        super.onSetUp();

        registryObjectStoreFacade = new RegistryObjectStoreFacade();
        registryObjectStoreFacade.setCoreDao(coreDao);
    }

    @Test
    public void testSave() {
        try {
            // Initializes fileIdentifier slot
            String fileIdentifier = "63C2378A-17A7-B863-BFF4-CC3EF507D10E";
            Slot slotFileIdentifier = new Slot();
            slotFileIdentifier.setName(new LongName(IDENTIFIER_NAME));
            slotFileIdentifier.setSlotType(new LongName("xsd:string"));
            LongName slotValue = new LongName(fileIdentifier);
            ValueList valueList = new ValueList();
            valueList.add(slotValue);
            slotFileIdentifier.setValueList(valueList);

            // Creates registryObject1 with slot fileIdentifier
            RegistryObject registryObject1 = RegistryObjectFactory.create();
            registryObject1.setId(new URN("id1"));
            registryObject1.getSlots().add(slotFileIdentifier);
            registryObjectStoreFacade.save(registryObject1);

            // Check only one RegistryObject with fileIdentifier value in registry
            List<RegistryObject> findedRegistryObjects = coreDao.findRegistryObjectBySlotNameAndValue(IDENTIFIER_NAME, fileIdentifier);
            assertEquals(1, findedRegistryObjects.size());
            RegistryObject registryObjectExpected = findedRegistryObjects.get(0);

            // Check RegistryObject fileIdentifier value
            List<Slot> identifierSlot = registryObjectExpected.findSlotsByName(IDENTIFIER_NAME);
            assertEquals(1, identifierSlot.size());
            assertEquals(fileIdentifier,identifierSlot.get(0).getValueList().getValues().get(0).getValue());

            // Check RegistryObject has the registryObject1 id
            assertEquals(registryObject1.getId(),registryObjectExpected.getId());

            // Creates registryObject2 with same fileIdentifier as registryObject1 and different id
            RegistryObject registryObject2 = RegistryObjectFactory.create();
            registryObject2.setId(new URN("id2"));
            slotFileIdentifier = new Slot();
            slotFileIdentifier.setName(new LongName(IDENTIFIER_NAME));
            slotFileIdentifier.setSlotType(new LongName("xsd:string"));
            slotValue = new LongName(fileIdentifier);
            valueList = new ValueList();
            valueList.add(slotValue);
            slotFileIdentifier.setValueList(valueList);
            registryObject2.getSlots().add(slotFileIdentifier);
            registryObjectStoreFacade.save(registryObject2);

            // Check only one RegistryObject with fileIdentifier value in registry
            findedRegistryObjects = coreDao.findRegistryObjectBySlotNameAndValue(IDENTIFIER_NAME, fileIdentifier);
            assertEquals(1, findedRegistryObjects.size());
            registryObjectExpected = findedRegistryObjects.get(0);

            // Check RegistryObject fileIdentifier value
            identifierSlot = registryObjectExpected.findSlotsByName(IDENTIFIER_NAME);
            assertEquals(1, identifierSlot.size());
            assertEquals(fileIdentifier,identifierSlot.get(0).getValueList().getValues().get(0).getValue());

            // Check RegistryObject has the registryObject2 id
            assertEquals(registryObject2.getId(),registryObjectExpected.getId());
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
