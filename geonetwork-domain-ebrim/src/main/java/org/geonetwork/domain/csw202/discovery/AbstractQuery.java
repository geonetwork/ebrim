package org.geonetwork.domain.csw202.discovery;

/**
 * Non-abstract query elements to be substituted are defined in the XSD like this:
 * <code>
 * <xsd:element name="Query" type="csw:QueryType" substitutionGroup="csw:AbstractQuery" id="Query"/>
 * </code>
 * 
 * @author heikki doeleman
 *
 */
public abstract class AbstractQuery {

	public boolean equals(Object o){
		return o instanceof AbstractQuery;
	}
	
	public int hashCode() {
		return super.hashCode();
	}
}
