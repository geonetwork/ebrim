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

import java.util.List;

import org.geonetwork.domain.csw202.discovery.ElementSet;
import org.geonetwork.domain.csw202.discovery.ElementSetName;
import org.geonetwork.domain.csw202.discovery.ResultType;
import org.geonetwork.domain.filter110.sort.SortBy;

/**
 * Query parameters to perform search
 * 
 * @author Jose
 */
public class QueryParameters {
	// Query result type. Default value = hits
	private ResultType resultType;

	// Start position of results. Default value 1
	private int startPosition;

	// Max records to obtain. Default value 10
	private int maxRecords;

	// Query expression
	private String filter;

	// List of fields to sort the results
	private SortBy sortBy;
	
	// List of objects types implicated in the query
	private List<String> typeNameList;

	// Element set name
	private ElementSetName elementSetName;

	// Element names
	private List<String> elementNames;

    // User to filter metadata by permissions
	private String userUuid;

	/**
	 * Default constructor
	 */
	public QueryParameters() {
		// Set default values
		this(ResultType.hits, 1, 10, null, null);
	}

	/**
	 * Constructor without sort fields
	 * 
	 * @param resultType
	 *            Result type
	 * @param startPosition
	 *            Start record position to return
	 * @param maxRecords
	 *            Max records to return
	 * @param filter
	 *            Query filter
	 */
	public QueryParameters(ResultType resultType, int startPosition, int maxRecords, String filter) {
		this(resultType, startPosition, maxRecords, filter, null);
	}

	/**
	 * Constructor with sort fields
	 * 
	 * @param resultType
	 *            Result type
	 * @param startPosition
	 *            Start record position to return
	 * @param maxRecords
	 *            Max records to return
	 * @param filter
	 *            Query filter
	 * @param sortBy
	 *            Sort fields
	 */
	public QueryParameters(ResultType resultType, int startPosition, int maxRecords, String filter, SortBy sortBy) {
		// Set default values
		this.resultType = resultType;
		this.startPosition = startPosition;
		this.maxRecords = maxRecords;
		this.filter = filter;
		this.sortBy = sortBy;

		// Default value SUMMARY (CSW 2.0.2 specification)
		this.elementSetName = new ElementSetName();
		this.elementSetName.setElementSet(ElementSet.brief);

		this.elementNames = null;
	}

	public ResultType getResultType() {
		return resultType;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public int getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}

	public int getMaxRecords() {
		return maxRecords;
	}

	public void setMaxRecords(int maxRecords) {
		this.maxRecords = maxRecords;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public SortBy getSortBy() {
		return sortBy;
	}

	public void setSortBy(SortBy sortBy) {
		this.sortBy = sortBy;
	}

	public ElementSetName getElementSetName() {
		return elementSetName;
	}

	public void setElementSetName(ElementSetName elementSetName) {
		this.elementSetName = elementSetName;
	}

	public List<String> getElementNames() {
		return elementNames;
	}

	public void setElementNames(List<String> elementNames) {
		this.elementNames = elementNames;
	}

	public List<String> getTypeNameList() {
		return typeNameList;
	}

	public void setTypeNameList(List<String> typeNameList) {
		this.typeNameList = typeNameList;
	}

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }
}