package org.geonetwork.domain.ebrim.test.utilities.basicextensionpackage;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery.StoredQuery;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject.WrsExtrinsicObject;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.extrinsicobject.RepositoryItemRef;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URI;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.URN;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;

/**
 *
 * @author heikki doeleman
 *
 */
public class WrsExtrinsicObjectFactory {

	public static WrsExtrinsicObject create() {
        WrsExtrinsicObject wrsExtrinsicObject = new WrsExtrinsicObject();
        wrsExtrinsicObject.setId(new URN("storedQueryId"));
        wrsExtrinsicObject.setHome(new URI("storedQueryHome"));

        wrsExtrinsicObject.setIsOpaque(true);

        RepositoryItemRef repositoryItemRef = new RepositoryItemRef();
        repositoryItemRef.setHref("http://repositoryitem.url");

        wrsExtrinsicObject.setRepositoryItemRef(repositoryItemRef);

        Slot slot = new Slot();
        slot.setSlotType(new LongName("http://www.slot.nl"));
        slot.setName(new LongName("slotname"));
        ValueList valueList = new ValueList();
        valueList.add(new LongName("onetwothree"));
        slot.setValueList(valueList);

        Set<Slot> slots = new HashSet<Slot>();
        slots.add(slot);
        wrsExtrinsicObject.setSlots(slots);

        return wrsExtrinsicObject;

	}
}