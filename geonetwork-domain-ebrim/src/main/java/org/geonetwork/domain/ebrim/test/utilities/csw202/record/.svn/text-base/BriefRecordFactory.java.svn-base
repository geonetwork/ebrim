package org.geonetwork.domain.ebrim.test.utilities.csw202.record;

import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.csw202.record.BriefRecord;

public class BriefRecordFactory {

	public synchronized static BriefRecord create() {
		BriefRecord o = new BriefRecord();

		o.setIdentifier("http://tempuri.org");
		o.setTitle("http://tempuri.org");
		o.setType("http://tempuri.org");
		o.setSchemaLocation("http://www.opengis.net/cat/csw/2.0.2 http://schemas.opengis.net/csw/2.0.2/record.xsd ");

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
