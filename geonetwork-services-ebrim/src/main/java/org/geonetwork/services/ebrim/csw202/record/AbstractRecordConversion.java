package org.geonetwork.services.ebrim.csw202.record;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.utils.FindSlot;
import org.geonetwork.domain.csw202.record.AbstractRecord;

/**
 * Abstract class for RegistryObject to AbstractRecord conversion
 *
 * @author Jose
 */
public abstract class AbstractRecordConversion {

    public abstract AbstractRecord convert(RegistryObject registryObject);

    public String findSlotValue(RegistryObject registryObject, String url) {
		Slot slot = FindSlot.findByName(registryObject, url);
		if (slot != null)
			return FindSlot.findslotValueAsString(slot);
		else
			return null;
	}
}
