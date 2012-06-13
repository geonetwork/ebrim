package org.geonetwork.utils;

import java.util.Set;

public class RandomHelperBase {

	
	private long hibernateId;
	private long id;
	
	
	
	Set<RandomHelperAttribute> randomHelperAttributeSet;

	public Set<RandomHelperAttribute> getRandomHelperAttributeSet() {
		return randomHelperAttributeSet;
	}

	public void setRandomHelperAttributeSet(Set<RandomHelperAttribute> randomHelperAttributeSet) {
		this.randomHelperAttributeSet = randomHelperAttributeSet;
	}

	public long getHibernateId() {
		return hibernateId;
	}

	public void setHibernateId(long hibernateId) {
		this.hibernateId = hibernateId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
