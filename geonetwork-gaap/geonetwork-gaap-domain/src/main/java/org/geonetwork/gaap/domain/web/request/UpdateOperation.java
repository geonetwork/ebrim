package org.geonetwork.gaap.domain.web.request;

import org.geonetwork.gaap.domain.operation.Operation;

/**
 * Save operation info request
 *
 * @author Jose
 */
public class UpdateOperation extends BaseRequest {
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
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UpdateOperation saveOperation = (UpdateOperation) o;

        if (operation != null ? !operation.equals(saveOperation.operation) : saveOperation.operation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }
}