package org.geonetwork.domain.ebrim.test.utilities.csw202.record;

import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.csw202.record.SummaryRecord;

public class SummaryRecordFactory {

	public synchronized static SummaryRecord create() {
		SummaryRecord o = new SummaryRecord();
		String content = "http://tempuri.org";
		o.setIdentifier(content);
		o.setTitle(content);
		o.setType(content);
		o.setSubject(content);
		o.setFormat(content);
		o.setRelation(content);
		o.setModified(content);
		o.setAbstrakt(content);
		o.setSpatial(content);

		BoundingBox bb = new BoundingBox();
		bb.setLowerCorner("3.6");
		bb.setUpperCorner("5.36585");
		bb.setCrs("http://tempuri.org");
		bb.setDimensions("1");
		bb.setBbtype("ows:BoundingBoxType");
		o.setBoundingBox(bb);
		return o;
	}

}
