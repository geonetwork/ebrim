package org.geonetwork.domain.ebrim.test.utilities.csw202.record;

import org.geonetwork.domain.csw202.record.Empty;

public class EmptyFactory {

	public synchronized static Empty create() {
		Empty o = new Empty();
		return o;
	}

}
