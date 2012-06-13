package org.geonetwork.domain.ebrim.informationmodel.core;

import java.util.*;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * 
 * @author heikki doeleman
 * 
 */
@Indexed
public class RegistryObjectList {

	/**
	 * Not in specification -- used to correlate all ebRIM objects resulting from the transformation of 1 iso metadata
	 * document.
	 */
	@DocumentId
	private long hibernateId;

	@Field
	private String iso19139Id;

	@IndexedEmbedded(depth = 2)
	private Set<RegistryObject> registryObjects = new HashSet<RegistryObject>();

	public Set<RegistryObject> getRegistryObjects() {
		return registryObjects;
	}

	public void setRegistryObjects(Set<RegistryObject> registryObjects) {
		this.registryObjects = registryObjects;
	}

	public long getHibernateId() {
		return hibernateId;
	}

	public void setHibernateId(long hibernateId) {
		this.hibernateId = hibernateId;
	}

	public String getIso19139Id() {
		return iso19139Id;
	}

	public void setIso19139Id(String iso19139Id) {
		this.iso19139Id = iso19139Id;
	}

	/**
	 * For JiBX binding.
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private static Set<RegistryObject> registryObjectsFactory() {
		return new HashSet<RegistryObject>();
	}

	public boolean add(RegistryObject e) {
		return registryObjects.add(e);
	}

	public boolean addAll(Collection<? extends RegistryObject> c) {
		return registryObjects.addAll(c);
	}

	public void clear() {
		registryObjects.clear();
	}

	public boolean contains(Object o) {
		return registryObjects.contains(o);
	}

	public RegistryObject get(int index) {
        return(registryObjects.toArray(new RegistryObject[0]))[index];
	}

	public Iterator<RegistryObject> iterator() {
		return registryObjects.iterator();
	}

	public boolean remove(Object o) {
		return registryObjects.remove(o);
	}

	public int size() {
		return registryObjects.size();
	}

}
