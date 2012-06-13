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

package org.geonetwork.search.ebrim.query;

import org.geonetwork.domain.ebrim.informationmodel.core.RegistryObject;
import org.geonetwork.domain.csw202.discovery.ElementSetName;

import java.util.List;

/**
 * Query result data
 *
 * @author Jose
 */
public class QueryResult {
    //private final String DEFAULT_OUTPUT_SCHEMA = "http://www.opengis.net/cat/csw/2.0.2";

    // EbRIM 3.0 output schema
    private final String DEFAULT_OUTPUT_SCHEMA = "urn:oasis:names:tc:ebxml-regrep:rim:xsd:3.0";
    
    // Number of records matched in query
    private int numberOfRecordsMatched;

    // Number of records returned in query
    private int numberOfRecordsReturned;

    // Position of next record to query
    private int nextRecord;

    // Element set name: brief, summary, full
    private ElementSetName elementSetName;

    // Output schema
    private String outputSchema;

    // Data returned by query
    private List<RegistryObject> data;

    // TODO: Check expires attribute 

    /**
     * Constructor
     */
     public QueryResult() {
        this(0,0,0,null, null); 
     }

    /**
     * Constructor
     *
     * @param numberOfRecordsMatched  Number of records matched in query
     * @param numberOfRecordsReturned Number of records returned in query
     * @param nextRecord              Position of next record to query
     * @param elementSetName          Element set name: brief, summary, full
     * @param data                    RData returned by query
     */
    public QueryResult(int numberOfRecordsMatched, int numberOfRecordsReturned,
                       int nextRecord, ElementSetName elementSetName, List<RegistryObject> data) {
        this.numberOfRecordsMatched = numberOfRecordsMatched;
        this.numberOfRecordsReturned = numberOfRecordsReturned;
        this.nextRecord = nextRecord;
        this.elementSetName = elementSetName;
        this.data = data;

        // Sets default output schema
        this.outputSchema = DEFAULT_OUTPUT_SCHEMA;
    }

    public int getNumberOfRecordsMatched() {
        return numberOfRecordsMatched;
    }

    public void setNumberOfRecordsMatched(int numberOfRecordsMatched) {
        this.numberOfRecordsMatched = numberOfRecordsMatched;
    }

    public int getNumberOfRecordsReturned() {
        return numberOfRecordsReturned;
    }

    public void setNumberOfRecordsReturned(int numberOfRecordsReturned) {
        this.numberOfRecordsReturned = numberOfRecordsReturned;
    }

    public int getNextRecord() {
        return nextRecord;
    }

    public void setNextRecord(int nextRecord) {
        this.nextRecord = nextRecord;
    }

    public ElementSetName getElementSetName() {
        return elementSetName;
    }

    public void setElementSetName(ElementSetName elementSetName) {
        this.elementSetName = elementSetName;
    }

    public String getOutputSchema() {
        return outputSchema;
    }

    public void setOutputSchema(String outputSchema) {
        this.outputSchema = outputSchema;
    }

    public List<RegistryObject>  getData() {
        return data;
    }

    public void setData(List<RegistryObject> data) {
        this.data = data;
    }
}
