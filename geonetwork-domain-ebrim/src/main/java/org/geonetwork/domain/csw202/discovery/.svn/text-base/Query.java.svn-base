package org.geonetwork.domain.csw202.discovery;

import java.util.List;
import java.util.ArrayList;

import org.geonetwork.domain.filter110.sort.SortBy;
import org.geonetwork.domain.xsd.QName;

/**
 * Specifies a query to execute against instances of one or more object types. A set of
 * ElementName elements may be included to specify an adhoc view of the csw:Record instances in
 * the result set. Otherwise, use ElementSetName to specify a predefined view. The Constraint
 * element contains a query filter expressed in a supported query language. A sorting criterion
 * that specifies a property to sort by may be included.
 *
 * @author heikki doeleman
 */
public class Query extends AbstractQuery {

    /**
     * The ElementName parameter is used to specify one or more metadata record elements, from
     * the output schema specified using the outputSchema parameter, that the query shall
     * present in the response to the a GetRecords operation. Since clause 10.2.5 realizes the
     * core metadata properties using XML schema, the value of the ElementName parameter would
     * be an XPath expression perhaps using qualified names. In the general case, a complete
     * XPath expression may be required to correctly reference an element in the information
     * model of the catalog.
     * <p/>
     * However, in the case where the typeNames attribute on the Query element contains a single
     * value, the catalogue can infer the first step in the path expression and it can be
     * omitted. This is usually the case when querying the core metadata properties since the
     * only queryable target is csw:Record.
     * If the metadata record element names are not from the schema specified using the
     * outputSchema parameter, then the service shall raise an exception as described in
     * Subclause 10.3.7.
     * <p/>
     * As mentioned in Subclause 10.8.4.4, if the outputFormat parameter is set to
     * application/xml, then the response to the GetRecords operation shall validate against a
     * schema document that is referenced in the response using the xmlns:schemaLocation
     * attribute. If the set of metadata record elements that the client specifies in the query
     * is insufficient to generate a valid XML response document, a CSW shall augment the list
     * of elements presented to the client in order to be able to generate a valid XML document.
     * Thus a client application should expect to receive more than the requested elements if
     * the output format is set to generate an XML document.
     * <p/>
     * Well known sets of elements may be named, in which case the ElementSetName parameter can
     * be used (e.g., brief, summary or full) to indicate which named set the service shall
     * present to the client. In the case where the query includes more than one entity name as
     * the value of the typeName attribute on the Query element, the typeName attribute on the
     * ElementSetName element can be used to discriminate which element set or sets should be
     * presented. The names specified for the typeName attribute on the ElementSetName element
     * shall be a proper subset of the names specified as the value of the typeName attribute on
     * the Query element. If the typeName attribute is not included on the ElementSetName
     * element, then the named element sets for all entities specified as the value of the
     * typeName attribute on the Query element shall be presented. If any entity name specified
     * as a value of the typeName attribute on the ElementSetName element does not match a name
     * specified as a value of the typeName attribute on the Query element, then the server
     * shall raise an exception as described in Subclause 10.3.7.
     * <p/>
     * The ElementName and ElementSetName parameters are mutually exclusive. Either an
     * ElementSetName parameter OR one or more ElementSetName parameters shall be specified in
     * a query.
     */
    private List<String> elementName;
    private ElementSetName elementSetName;


    private QueryConstraint constraint;
    /**
     * The result set may be sorted by specifying one or more metadata record elements upon
     * which to sort.
     */
    private SortBy sortBy;


    /**
     * The typeNames parameter is a list of one or more names of queryable entities in the
     * catalogue's information model that may be constrained in the predicate of the query. In
     * the case of XML realization of the OGC core metadata properties (Subclause 10.2.5), the
     * element csw:Record is the only queryable entity. Other information models may include
     * more than one queryable component. For example, queryable components for the XML
     * realization of the ebRIM include rim:Service, rim:ExtrinsicObject and rim:Association.
     * In such cases the application profile shall describe how multiple typeNames values should
     * be processed.
     * In addition, all or some of the these queryable entity names may be specified in the
     * query to define which metadata record elements the query should present in the response
     * to the GetRecords operation.
     */
    private List<QName> typeNames;

    public ElementSetName getElementSetName() {
        return elementSetName;
    }

    public void setElementSetName(ElementSetName elementSetName) {
        this.elementSetName = elementSetName;
    }

    public List<String> getElementName() {
        return elementName;
    }

    public void setElementName(List<String> elementName) {
        this.elementName = elementName;
    }

    public QueryConstraint getConstraint() {
        return constraint;
    }

    public void setConstraint(QueryConstraint constraint) {
        this.constraint = constraint;
    }

    public SortBy getSortBy() {
        return sortBy;
    }

    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
    }

    public List<QName> getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(List<QName> typeNames) {
        this.typeNames = typeNames;
    }

    /**
     * For Jixb binding.
     *
     * @return
     */
    @SuppressWarnings("unused")
    private static List<String> elementNameListFactory() {
        return new ArrayList<String>();
    }


    @SuppressWarnings("unused")
    private static List<String> typeNamesListFactory() {
        return new ArrayList<String>();
    }

    public static List<QName> deserializeTypeNames(String text) {
        List<QName> listTypeNames = null;

        if (text != null) {
            listTypeNames = new ArrayList<QName>();

            String[] typeNames = text.split(" ");
            for (String t : typeNames) {
                QName qn = new QName();
                qn.setValue(t);

                listTypeNames.add(qn);
            }
        }

        return listTypeNames;
    }

    public static String serializeTypeNames(List<QName> listTypeNames) {
        String typeNames = null;

        if (listTypeNames != null) {
            listTypeNames = new ArrayList<QName>();

            for (QName t : listTypeNames) {
                if (typeNames != null) typeNames += " ";
                typeNames += t.getValue();
            }
        }

        return typeNames;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result
                + ((constraint == null) ? 0 : constraint.hashCode());
        result = prime * result
                + ((elementName == null) ? 0 : elementName.hashCode());
        result = prime * result
                + ((elementSetName == null) ? 0 : elementSetName.hashCode());
        result = prime * result + ((sortBy == null) ? 0 : sortBy.hashCode());
        result = prime * result
                + ((typeNames == null) ? 0 : typeNames.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Query other = (Query) obj;
        if (constraint == null) {
            if (other.constraint != null)
                return false;
        } else if (!constraint.equals(other.constraint))
            return false;
        if (elementName == null) {
            if (other.elementName != null)
                return false;
        } else if (!elementName.equals(other.elementName))
            return false;
        if (elementSetName == null) {
            if (other.elementSetName != null)
                return false;
        } else if (!elementSetName.equals(other.elementSetName))
            return false;
        if (sortBy == null) {
            if (other.sortBy != null)
                return false;
        } else if (!sortBy.equals(other.sortBy))
            return false;
        if (typeNames == null) {
            if (other.typeNames != null)
				return false;
		} else if (!typeNames.equals(other.typeNames))
			return false;
		return true;
	}

}
