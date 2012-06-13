package org.geonetwork.domain.ebrim.test.utilities.csw202.record;

import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.csw202.record.Record;

public class RecordFactory {

	public synchronized static Record create() {
		Record o = new Record();
		o.setAnyText("");

		BoundingBox bb = new BoundingBox();
		bb.setLowerCorner("3.6");
		bb.setUpperCorner("5.36585");
		bb.setCrs("http://tempuri.org");
		bb.setDimensions("1");
		bb.setBbtype("ows:BoundingBoxType");

		o.setBoundingBox(bb);
		return o;
	}


    public synchronized static Record create2() {
    	Record o = new Record();
		o.setAnyText("");

        o.setAbstrakt("text");
        o.setTitle("title");
        o.setAudience("audience");

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
