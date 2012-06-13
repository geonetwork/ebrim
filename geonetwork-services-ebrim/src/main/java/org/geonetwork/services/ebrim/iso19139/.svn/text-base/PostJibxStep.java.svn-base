package org.geonetwork.services.ebrim.iso19139;

import java.util.*;

import org.geonetwork.domain.ebrim.exception.GeoNetworkException;
import org.geonetwork.domain.ebrim.informationmodel.association.Association;
import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObjectList;

public class PostJibxStep {

	/**
	 * If an association could be associated with a source, it will be deleted from the list and
	 * turn into an attribute from source
	 * 
	 * If an association could be associated with a target, the target will be added as an attribute
	 * on Association
	 * 
	 * When Identifiable's have the same id, the last one will be used for the association.
	 * 
	 * This method is null proof, e.g. it ignore objects will non defined id's etcetera.
	 * 
	 * @param registryObjectList
	 * @return registryObjectList
	 * @throws GeoNetworkException
	 */
	public RegistryObjectList enrichAssociationRelations(RegistryObjectList registryObjectList) throws GeoNetworkException {
        Set<RegistryObject> ilist = registryObjectList.getRegistryObjects();

		List<Association> alist = new ArrayList<Association>();
		Map<String, Association> aMap = new HashMap<String, Association>();
		Map<String, RegistryObject> rMap = new HashMap<String, RegistryObject>();

		// setup lists and map
		for (Identifiable identifiable : ilist) {
			if (identifiable instanceof Association) {
				alist.add((Association) identifiable);
				if (hasValidId(identifiable))
					aMap.put(identifiable.getId().getValue(), (Association) identifiable);
			} else if (identifiable instanceof RegistryObject) {
				if (hasValidId(identifiable))
					rMap.put(identifiable.getId().getValue(), (RegistryObject) identifiable);
			} else if (!(identifiable instanceof Identifiable))
				throw new GeoNetworkException("Identifiable should have found a its place now....");
		}

		// find associations
		for (Association association : alist) {
			if (hasValidId(association)) {
				// process source
				if (association.getSourceObject() != null && association.getSourceObject().getValue() != null) {
					String sourceId = association.getSourceObject().getValue();
					if (rMap.containsKey(sourceId)) {
						RegistryObject foundRegistryObject = rMap.get(sourceId);
						// add association to source
						foundRegistryObject.getAssociationsSet().add(association);
						// remove association from original list
						registryObjectList.remove(association);
					}
				}
				// process target
				if (association.getTargetObject() != null && association.getTargetObject().getValue() != null) {
					String targetId = association.getTargetObject().getValue();
					if (rMap.containsKey(targetId))
						// set target
						association.setTargetRegistryObject(rMap.get(targetId));
				}
			}
		}
		return registryObjectList;
	}

	boolean hasValidId(Identifiable identifiable) {
		return (identifiable.getId() != null && identifiable.getId().getValue() != null);
	}

}