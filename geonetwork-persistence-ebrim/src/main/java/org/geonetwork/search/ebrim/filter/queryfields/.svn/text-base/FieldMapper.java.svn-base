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

package org.geonetwork.search.ebrim.filter.queryfields;

import org.apache.lucene.queryParser.QueryParser;

import java.util.Map;
import java.util.HashMap;

/**
 * Class to map queriable properties to lucene index names
 *
 * @author Jose
 */
public class FieldMapper {

    private Map<String, Field> fields;

    public FieldMapper() {
        // TODO: Complete mappings
        fields = new HashMap<String, Field>();

        // Mapping of the OGC Core Queryable
        // anytext
        fields.put("anytext", new AnyField());

        // title
        fields.put("title", new Field("name.localizedStrings.value"));

        // identifier
        fields.put("identifier", new Field("externalIdentifiers.value.value"));

        // abstract
        fields.put("abstract", new Field("description.localizedStrings.value"));

        // type
        fields.put("type", new Field("classifications.objectType.value"));


        // format
        fields.put("format", new SlotField("slots.valueList.values.value", QueryParser.escape("http://purl.org/dc/elements/1.1/format")));

        // modified
        fields.put("modified", new SlotField("slots.valueList.values.value", QueryParser.escape("http://purl.org/dc/terms/modified")));

        // BoundingBox
        /*fieldList = new ArrayList<FieldMappingInfo>();
        //  WestBoundLongitude
        fieldList.add(new FieldMappingInfo("slots.basicExtensionValueList.values.value.lowerCorner.longitude", FieldMappingInfo.FIELD_REPLACE_VALUE));
        //  SouthBoundLatitude
        fieldList.add(new FieldMappingInfo("slots.basicExtensionValueList.values.value.lowerCorner.latitude", FieldMappingInfo.FIELD_REPLACE_VALUE));
        //  EastBoundLatitude
        fieldList.add(new FieldMappingInfo("slots.basicExtensionValueList.values.value.upperCorner.longitude", FieldMappingInfo.FIELD_REPLACE_VALUE));
        //  NorthBoundLatitude
        fieldList.add(new FieldMappingInfo("slots.basicExtensionValueList.values.value.upperCorner.latitude", FieldMappingInfo.FIELD_REPLACE_VALUE));
        queryfields.put("boundingbox", fieldList); */

        // CRS
        /*fieldList = new ArrayList<FieldMappingInfo>();
        fieldList.add(new FieldMappingInfo("identifiedItem.citedItem.organization.name", FieldMappingInfo.FIELD_REPLACE_VALUE));
        fieldList.add(new FieldMappingInfo("identifiedItem.name", FieldMappingInfo.FIELD_REPLACE_VALUE));
        queryfields.put("modified", fieldList);  */

        // ISO Profile additional queryable properties common to all information resources
        // FileIdentifier
        fields.put("fileidentifier", new SlotField("slots.valueList.values.value", QueryParser.escape("http://purl.org/dc/elements/1.1/identifier")));


        // MetadataLanguage
        fields.put("metadatalanguage", new SlotField("slots.valueList.values.value", QueryParser.escape("http://purl.org/dc/elements/1.1/language")));

        // Datestamp
        fields.put("datestamp", new SlotField("slots.valueList.values.value",  QueryParser.escape("http://purl.org/dc/elements/1.1/date")));

        // AlternateTitle
        fields.put("alternatetitle", new SlotField("slots.valueList.values.value", QueryParser.escape("http://purl.org/dc/elements/1.1/title")));

        // CreationDate3
        fields.put("creationdate3", new SlotField("slots.valueList.values.value", QueryParser.escape("http://purl.org/dc/terms/created")));

        // OrganizationName

        // HierarchyLevelName
        fields.put("hierarchylevelname", new SlotField("slots.valueList.values.value", QueryParser.escape("http://purl.org/dc/elements/1.1/type")));


        /*queryfields.put("ParentIdentifier", "");
        queryfields.put("KeywordType", "");

        // Additional ISO Profile queryable properties for datasets, dataset collection and applications
        queryfields.put("TopicCategory","");
        queryfields.put("Language","");
        queryfields.put("GeographicDescriptionCode","");
        queryfields.put("SpatialResolution","");
        queryfields.put("TempExtent_begin","");
        queryfields.put("TempExtent_end",""); */


        AnyField anyField = (AnyField) fields.get("anytext");
        anyField.setFields(fields);
    }

    public Field findField(String fieldName) {
        return fields.get(fieldName);
    }

    public Map<String, Field> getFields() {
        return fields;
    }
}
