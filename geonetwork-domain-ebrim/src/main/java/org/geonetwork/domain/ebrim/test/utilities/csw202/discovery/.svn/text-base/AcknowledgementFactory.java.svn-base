package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.geonetwork.domain.csw202.discovery.Acknowledgement;

public class AcknowledgementFactory {

	public synchronized static Acknowledgement create() {
		Acknowledgement o = new Acknowledgement();
		o.setRequestId("http://tempuri.org");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date;
		try {
			date = formatter.parse("2001-12-31 12:00:00");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		o.setTimestamp(date);
		return o;
	}

}
