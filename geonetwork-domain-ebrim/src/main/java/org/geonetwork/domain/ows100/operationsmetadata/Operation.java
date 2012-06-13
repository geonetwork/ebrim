package org.geonetwork.domain.ows100.operationsmetadata;

import java.util.List;
import java.util.ArrayList;

import org.geonetwork.domain.ows100.common.Metadata;

/**
 * Metadata for one operation that this server implements. 
 * 
 * @author heikki doeleman
 *
 */
public class Operation {

	/**
	 * Unordered list of Distributed Computing Platforms (DCPs) supported for this operation. At 
	 * present, only the HTTP DCP is defined, so this element will appear only once.
	 */
	// TODO should be List<ows:DCP>
	private List<DCP> DCP;
	
	/**
	 * Optional unordered list of parameter domains that each apply to this operation which this 
	 * server implements. If one of these Parameter elements has the same "name" attribute as a 
	 * Parameter element in the OperationsMetadata element, this Parameter element shall override 
	 * the other one for this operation. The list of required and optional parameter domain 
	 * limitations for this operation shall be specified in the Implementation Specification for 
	 * this service. 
	 */
	private List<Domain> parameter;
	
	/**
	 * Optional unordered list of valid domain constraints on non-parameter quantities that each 
	 * apply to this operation. If one of these Constraint elements has the same "name" attribute 
	 * as a Constraint element in the OperationsMetadata element, this Constraint element shall 
	 * override the other one for this operation. The list of required and optional constraints 
	 * for this operation shall be specified in the Implementation Specification for this service.
	 */
	private List<Domain> constraint;
	
	/**
	 * Optional unordered list of additional metadata about this operation and its' implementation. A list of required and optional metadata elements for this operation should be specified in the Implementation Specification for this service. (Informative: This metadata might specify the operation request parameters or provide the XML Schemas for the operation request.)
	 */
	private List<Metadata> metadata;
	
	/**
	 * Name or identifier of this operation (request) (for example, GetCapabilities). The list of 
	 * required and optional operations implemented shall be specified in the Implementation 
	 * Specification for this service.
	 */
	private String name ;

	public List<DCP> getDCP() {
		return DCP;
	}

	public void setDCP(List<DCP> dcp) {
		DCP = dcp;
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

	public List<Metadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<Metadata> metadata) {
		this.metadata = metadata;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

        /**
	 * For Jixb binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static  List<DCP> DCPListFactory() {
		return new ArrayList<DCP>();
	}

    @SuppressWarnings("unused")
	private static  List<Domain> parameterListFactory() {
		return new ArrayList<Domain>();
	}

    @SuppressWarnings("unused")
	private static  List<Domain> constraintListFactory() {
		return new ArrayList<Domain>();
	}

    @SuppressWarnings("unused")
	private static  List<Metadata> metadataListFactory() {
		return new ArrayList<Metadata>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DCP == null) ? 0 : DCP.hashCode());
        result = prime * result + ((parameter == null) ? 0 : parameter.hashCode());
        result = prime * result + ((constraint == null) ? 0 : constraint.hashCode());
        result = prime * result + ((metadata == null) ? 0 : metadata.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Operation)) {
			return false;
		}
		Operation other = (Operation) obj;

        if (DCP == null) {
            if (other.DCP != null)
                return false;
        } else if (!DCP
                .equals(other.DCP))
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

        if (metadata == null) {
            if (other.metadata != null)
                return false;
        } else if (!metadata
                .equals(other.metadata))
            return false;

        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name
                .equals(other.name))
            return false;

		return true;
	}
}
