package org.geonetwork.domain.ows100.common;

/**
 * This element either references or contains more metadata about the element that includes this 
 * element. To reference metadata stored remotely, at least the xlinks:href attribute in 
 * xlink:simpleLink shall be included. Either at least one of the attributes in xlink:simpleLink 
 * or a substitute for the AbstractMetaData element shall be included, but not both. An 
 * Implementation Specification can restrict the contents of this element to always be a reference 
 * or always contain metadata. (Informative: This element was adapted from the metaDataProperty 
 * element in GML 3.0.) 
 * 
 * @author heikki doeleman
 *
 */
public class Metadata {

	private AbstractMetadata abstractMetadata;
	
	// TODO how to model this?
	
/*	
		<attributeGroup ref="xlink:simpleLink">
			<annotation>
				<documentation>Reference to metadata recorded elsewhere, either external to this XML document or within it. Whenever practical, the xlink:href attribute with type anyURI should include a URL from which this metadata can be electronically retrieved. </documentation>
			</annotation>
		</attributeGroup>
	
*/	
	/**
	 * Optional reference to the aspect of the element which includes this "metadata" element that 
	 * this metadata provides more information about.
	 */
	private String about;

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abstractMetadata == null) ? 0 : abstractMetadata.hashCode());
        result = prime * result + ((about == null) ? 0 : about.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Metadata)) {
			return false;
		}
		Metadata other = (Metadata) obj;

        if (abstractMetadata == null) {
            if (other.abstractMetadata != null)
                return false;
        } else if (!about
                .equals(other.about))
            return false;

		return true;
	}
}
