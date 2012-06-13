package org.geonetwork.domain.referencedata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.geonetwork.domain.ebrim.informationmodel.core.Identifiable;

/**
 * 
 * @author heikki doeleman
 *
 */
public class ReferenceData {
	
	private static List<Identifiable> referenceData = new ArrayList<Identifiable>();
	
	/**
	 * Prevent instatiation.
	 */
	private ReferenceData() {
	}
	
	public synchronized static List<Identifiable> getReferenceData() {
		return referenceData;
	}

	public boolean add(Identifiable e) {
		return referenceData.add(e);
	}

	public boolean addAll(Collection<? extends Identifiable> c) {
		return referenceData.addAll(c);
	}

	public boolean contains(Object o) {
		return referenceData.contains(o);
	}

	public Identifiable get(int index) {
		return referenceData.get(index);
	}

	public boolean isEmpty() {
		return referenceData.isEmpty();
	}

	public Iterator<Identifiable> iterator() {
		return referenceData.iterator();
	}

	public boolean remove(Object o) {
		return referenceData.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return referenceData.removeAll(c);
	}

	public int size() {
		return referenceData.size();
	}
	
	

}
