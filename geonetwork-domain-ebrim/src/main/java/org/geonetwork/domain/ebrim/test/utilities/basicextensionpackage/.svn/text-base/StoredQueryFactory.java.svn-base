package org.geonetwork.domain.ebrim.test.utilities.basicextensionpackage;

import java.util.HashSet;
import java.util.Set;

import org.geonetwork.domain.ebrim.extensionpackage.basicextension.storedquery.StoredQuery;
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
public class StoredQueryFactory {

	public static StoredQuery create() {
        StoredQuery storedQuery = new StoredQuery();
        storedQuery.setId(new URN("storedQueryId"));
        storedQuery.setHome(new URI("storedQueryHome"));
        
        Slot slot = new Slot();
        slot.setSlotType(new LongName("http://www.playboy.com.br"));
        slot.setName(new LongName("playboyBrasilQueryParameter"));
        ValueList valueList = new ValueList();
        valueList.add(new LongName("onetwothree"));
        slot.setValueList(valueList);
        
        Set<Slot> slots = new HashSet<Slot>();
        slots.add(slot);
        storedQuery.setSlots(slots);	
        
        return storedQuery;
        
	}
}
