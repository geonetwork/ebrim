package org.geonetwork.domain.ebrim.test.utilities.csw202.record;

import org.geonetwork.domain.csw202.record.DCMIRecord;

public class DCMIRecordFactory {

	public synchronized static DCMIRecord create() {
		DCMIRecord o = new DCMIRecord();
		/*Set<String> DCMI_Terms = new HashSet<String>();
		DCMI_Terms.add("http://tempuri.org.1");
		DCMI_Terms.add("http://tempuri.org.2");
		o.setDCMI_Terms(DCMI_Terms);  */
        o.setAbstrakt("text");
        o.setTitle("title");
        o.setAudience("audience");
		return o;
	}

}
