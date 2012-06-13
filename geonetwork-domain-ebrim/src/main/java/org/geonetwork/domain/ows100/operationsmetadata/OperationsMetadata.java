package org.geonetwork.domain.ows100.operationsmetadata;

import java.util.List;
import java.util.ArrayList;

/**
 * Metadata about the operations and related abilities specified by this service and implemented 
 * by this server, including the URLs for operation requests. The basic contents of this section 
 * shall be the same for all OWS types, but individual services can add elements and/or change the 
 * optionality of optional elements. 
 * 
 * @author heikki doeleman
 *
 */
public class OperationsMetadata {

	/**
	 * Metadata for unordered list of all the (requests for) operations that this server interface 
	 * implements. The list of required and optional operations implemented shall be specified in 
	 * the Implementation Specification for this service.
	 */
	private List<Operation> operation;
	
	/**
	 * Optional unordered list of parameter valid domains that each apply to one or more operations 
	 * which this server interface implements. The list of required and optional parameter domain 
	 * limitations shall be specified in the Implementation Specification for this service.
	 */
	private List<Domain> parameter; 
	
	/**
	 * Optional unordered list of valid domain constraints on non-parameter quantities that each 
	 * apply to this server. The list of required and optional constraints shall be specified in 
	 * the Implementation Specification for this service.
	 */
	private List<Domain> constraint;
	
	/**
	 * Individual software vendors and servers can use this element to provide metadata about any 
	 * additional server abilities.
	 */
	private ExtendedCapabilities extendedCapabilities;

	public List<Operation> getOperation() {
		return operation;
	}

	public void setOperation(List<Operation> operation) {
		this.operation = operation;
	}

	public List<Domain> getParameter() {
		return parameter;
	}

	public void setParameter(List<Domain> parameter) {
		this.parameter = parameter;
	}

	public List<Domain> getConstraint() {
		return constraint;
	}

	public void setConstraint(List<Domain> constraint) {
		this.constraint = constraint;
	}

	public Object getExtendedCapabilities() {
		return extendedCapabilities;
	}

	public void setExtendedCapabilities(ExtendedCapabilities extendedCapabilities) {
		this.extendedCapabilities = extendedCapabilities;
	}

    /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<Operation> operationListFactory() {
		return new ArrayList<Operation>();
	}

    @SuppressWarnings("unused")
	private static  List<Domain> parameterListFactory() {
		return new ArrayList<Domain>();
	}

    @SuppressWarnings("unused")
	private static  List<Domain> constraintListFactory() {
		return new ArrayList<Domain>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
        result = prime * result + ((parameter == null) ? 0 : parameter.hashCode());
        result = prime * result + ((constraint == null) ? 0 : constraint.hashCode());
        result = prime * result + ((extendedCapabilities == null) ? 0 : extendedCapabilities.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof OperationsMetadata)) {
			return false;
		}
		OperationsMetadata other = (OperationsMetadata) obj;

        if (operation == null) {
            if (other.operation != null)
                return false;
        } else if (!operation
                .equals(other.operation))
            return false;

        if (parameter == null) {
            if (other.parameter != null)
                return false;
        } else if (!parameter
                .equals(other.parameter))
            return false;

        if (constraint == null) {
            if (other.constraint != null)
                return false;
        } else if (!constraint
                .equals(other.constraint))
            return false;

        if (extendedCapabilities == null) {
            if (other.extendedCapabilities != null)
                return false;
        } else if (!extendedCapabilities
                .equals(other.extendedCapabilities))
            return false;

		return true;
	}
}
