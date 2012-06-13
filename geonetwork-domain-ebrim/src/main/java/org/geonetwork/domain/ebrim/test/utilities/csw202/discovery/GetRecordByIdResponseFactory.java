//=============================================================================
//===	Copyright (C) 2008 European Space Agency (ESA).
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - E-mail: geonetwork@osgeo.org

//==============================================================================
package org.geonetwork.domain.ebrim.test.utilities.csw202.discovery;

import org.geonetwork.domain.csw202.discovery.GetRecordByIdResponse;
import org.geonetwork.domain.csw202.record.AbstractRecord;
import org.geonetwork.domain.csw202.record.BoundingBox;
import org.geonetwork.domain.csw202.record.DCMIRecord;
import org.geonetwork.domain.csw202.record.Record;
import org.geonetwork.domain.csw202.record.SummaryRecord;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Jose
 */
public class GetRecordByIdResponseFactory {
    public synchronized static GetRecordByIdResponse create() {
        GetRecordByIdResponse r = new GetRecordByIdResponse();

        List<AbstractRecord> records = new ArrayList<AbstractRecord>();
        SummaryRecord summary = new SummaryRecord();

        summary.setIdentifier("00180e67-b7cf-40a3-861d-b3a09337b195");
        summary.setTitle("title: 1141987690552");
        summary.setType("service");
        summary.setSubject("City");
        summary.setFormat("digital");
        summary.setRelation("5a389ad2-22dd-11d1-aa77-002035b29093");
        summary.setModified("2004-10-04 00:00:00");        
        summary.setAbstrakt("Orthophotos 1:5 000 (OP5) einer Stadt");

        records.add(summary);

        r.setAbstractRecords(records);

        return r;
    }
    public synchronized static GetRecordByIdResponse createLegacy() {
        GetRecordByIdResponse r = new GetRecordByIdResponse();

        List<AbstractRecord> records = new ArrayList<AbstractRecord>();
        Record record = new Record();

        record.setIdentifier("urn:hma:eum:msg1:6666");
        record.setTitle("Meteosat 8 (MSG product family) - SEVI - MSG15");
        BoundingBox boundingBox = new BoundingBox();
        boundingBox.setCrs("::");
        String lowerCorner = "180.00 -90.00";
        boundingBox.setLowerCorner(lowerCorner);
        String upperCorner = "-180.00 90.00";
        boundingBox.setUpperCorner(upperCorner);
        record.setBoundingBox(boundingBox);
        record.setAbstrakt("Meteosat 8 (MSG product family), SEVI instrument (MSG), MSG Level 1.5");
        //record.setType("series");
        records.add(record);

        r.setAbstractRecords(records);

        return r;
    }}
