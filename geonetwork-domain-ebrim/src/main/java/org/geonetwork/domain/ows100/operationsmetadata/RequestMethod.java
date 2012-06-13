package org.geonetwork.domain.ows100.operationsmetadata;

import java.util.List;
import java.util.ArrayList;

import org.geonetwork.domain.ows100._19115subset.OnlineResource;

/**
 * Connect point URL and any constraints for this HTTP request method for this operation 
 * request. In the OnlineResourceType, the xlink:href attribute in the xlink:simpleLink attribute 
 * group shall be used to contain this URL. The other attributes in the xlink:simpleLink 
 * attribute group should not be used. 
 * 
 * @author heikki doeleman
 *
 */
public abstract class RequestMethod extends OnlineResource {

	/**
	 * Optional unordered list of valid domain constraints on non-parameter quantities that each 
	 * apply to this request method for this operation. If one of these Constraint elements has 
	 * the same "name" attribute as a Constraint element in the OperationsMetadata or Operation 
	 * element, this Constraint element shall override the other one for this operation. The list 
	 * of required and optional constraints for this request method for this operation shall be 
	 * specified in the Implementation Specification for this service.
	 */
	private List<Domain> constraint;

    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<Domain> constraintListFactory() {
		return new ArrayList<Domain>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
        result=super.hashCode();
		result = prime * result + ((constraint == null) ? 0 : constraint.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RequestMethod)) {
			return false;
		}
		RequestMethod other = (RequestMethod) obj;

        if (!super.equals(obj)) return false;

        if (constraint == null) {
            if (other.constraint != null)
                return false;
        } else if (!constraint
                .equals(other.constraint))
            return false;

		return true;
	}
}
