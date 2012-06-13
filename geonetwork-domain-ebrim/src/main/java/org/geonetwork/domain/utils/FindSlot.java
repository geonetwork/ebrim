package org.geonetwork.domain.utils;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.AnyValue;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.Envelope;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.LowerCorner;
import org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.UpperCorner;
import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;
import org.geonetwork.domain.ebrim.informationmodel.core.Slot;
import org.geonetwork.domain.ebrim.informationmodel.core.datatype.LongName;
import org.geonetwork.domain.ebrim.informationmodel.xsd.ValueList;

public class FindSlot {

	/**
	 * Creates a CSW202 BoundingBox from an ebRIM Slot.
	 * @param slot
	 * @return
	 */
	public static BoundingBox createBoundingBox(Slot slot) {
		BoundingBox boundingBox = new BoundingBox();
		org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.ValueList beValueList = slot.getBasicExtensionValueList();
        if(beValueList != null) {
			List<AnyValue> values = beValueList.getValues();
			if(values != null && values.size() > 0) {
				AnyValue value = values.get(0);
				if(value != null) {
					Envelope envelope = value.getValue();
					if(envelope != null) {
						LowerCorner lowerCorner = envelope.getLowerCorner();
						if(lowerCorner != null) {
							boundingBox.setLowerCorner(lowerCorner.getValue());
						}
						UpperCorner upperCorner = envelope.getUpperCorner();
						if(upperCorner != null) {
							boundingBox.setUpperCorner(upperCorner.getValue());
						}					
					}
				}
				
			}
		}
		return boundingBox;
		
	}
	
	/**
	 * Returns the first value in this slot as a string. The standard ValueList is tried
	 * first, if nothing is found the Basic Extension Package valuelist is used.
	 * @param slot
	 * @return
	 */
	public static String findslotValueAsString(Slot slot) {
		String slotValue = null;
		ValueList valueList = slot.getValueList();
		if(valueList != null) { 
			List<LongName> longNames = valueList.getValues();
			if(longNames != null && longNames.size() > 0) {
				LongName longName = longNames.get(0);
				if(longName != null) {
					slotValue = longName.getValue();		
				}
			}
		}
		if(slotValue == null) {
			org.geonetwork.domain.ebrim.extensionpackage.basicextension.xsd.ValueList beValueList = slot.getBasicExtensionValueList();
			if(beValueList != null) { 
				List<AnyValue> values = beValueList.getValues();
				if(values != null && values.size() > 0) {
					AnyValue value = values.get(0);
					slotValue = value.toString();
				}
			}
		}
		return slotValue;
	}
	
	/**
	 * Returns the first slot in a collection that has a matching slotName.
	 * @param slots
	 * @param slotName
	 * @return
	 */
	public static Slot findByName(Collection<Slot> slots, String slotName) {
		if(slots != null) {
	        for(Slot slot: slots) {
	            String name = slot.getName().getValue();
	            if (name.equalsIgnoreCase(slotName)) {
	                return slot;
	            }
	        }
		}
        return null;
	}

	/**
	 * Returns the first slot in a Identifiable that has a matching slotName.
	 * @param identifiable
	 * @param slotName
	 * @return
	 */
	public static Slot findByName(Identifiable identifiable, String slotName) {
		Set<Slot> slots = identifiable.getSlots();
		return findByName(slots, slotName);
	}	
}
