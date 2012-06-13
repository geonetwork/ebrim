package org.geonetwork.gaap.domain.web.response;

import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.operation.Operation;

/**
 * Get operation response
 *
 * @author Jose
 */
public class GetOperationResponse extends BaseResponse {
    Operation operation;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;

        GetOperationResponse that = (GetOperationResponse) o;

        if (operation != null ? !operation.equals(that.operation) : that.operation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = super.hashCode();
        result = prime * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }
}