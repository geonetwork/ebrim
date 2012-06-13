package org.geonetwork.gaap.domain.web.response;

import org.geonetwork.gaap.domain.group.Group;
import org.geonetwork.gaap.domain.operation.Operation;

import java.util.List;

/**
 * Get operations response
 *
 * @author Jose
 */
public class GetOperationsResponse extends BaseResponse {
    List<Operation> operations;

    int nextPosition;

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public int getNextPosition() {
        return nextPosition;
    }

    public void setNextPosition(int nextPosition) {
        this.nextPosition = nextPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;

        GetOperationsResponse that = (GetOperationsResponse) o;

        if (nextPosition != that.nextPosition) return false;
        if (operations != null ? !operations.equals(that.operations) : that.operations != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;

        int result = super.hashCode();
        result = prime * result + (operations != null ? operations.hashCode() : 0);
        result = prime * result + nextPosition;
        return result;
    }
}