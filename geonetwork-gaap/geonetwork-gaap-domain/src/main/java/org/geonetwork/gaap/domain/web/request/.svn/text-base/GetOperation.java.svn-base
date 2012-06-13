package org.geonetwork.gaap.domain.web.request;

/**
 * Get operation info request
 *
 * @author Jose
 */
public class GetOperation extends BaseRequest {
    private String opName;

    public String getOperationName() {
        return opName;
    }

    public void setOperationName(String opName) {
        this.opName = opName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GetOperation that = (GetOperation) o;

        if (opName != null ? !opName.equals(that.opName) : that.opName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + (opName != null ? opName.hashCode() : 0);
        return result;
    }
}