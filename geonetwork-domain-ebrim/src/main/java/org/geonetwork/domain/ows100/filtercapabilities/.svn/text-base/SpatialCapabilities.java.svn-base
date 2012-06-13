package org.geonetwork.domain.ows100.filtercapabilities;

import java.util.List;
import java.util.ArrayList;


public class SpatialCapabilities {
    private List<GeometryOperand> geometryOperands;
    private List<SpatialOperator> spatialOperators;

    public List<GeometryOperand> getGeometryOperands() {
        return geometryOperands;
    }

    public void setGeometryOperands(List<GeometryOperand> geometryOperands) {
        this.geometryOperands = geometryOperands;
    }

    public List<SpatialOperator> getSpatialOperators() {
        return spatialOperators;
    }

    public void setSpatialOperators(List<SpatialOperator> spatialOperators) {
        this.spatialOperators = spatialOperators;
    }

    /**
     * For JiBX binding.
     *
     * @return
     */
    @SuppressWarnings("unused")
    private static List<String> geometryOperandListFactory() {
        return new ArrayList<String>();
    }

    @SuppressWarnings("unused")
    private static List<String> spatialOperatorListFactory() {
        return new ArrayList<String>();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime
                * result
                + ((geometryOperands == null) ? 0 : geometryOperands
                .hashCode());
        result = prime * result
                + ((spatialOperators == null) ? 0 : spatialOperators.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
                    return false;
                }
		if (!(obj instanceof SpatialCapabilities)) {
			return false;
		}

        SpatialCapabilities other = (SpatialCapabilities) obj;
        if (geometryOperands == null) {
            if (other.geometryOperands != null)
                return false;
        } else if (!geometryOperands.equals(other.geometryOperands))
            return false;
        if (spatialOperators == null) {
            if (other.spatialOperators != null)
                return false;
        } else if (!spatialOperators.equals(other.spatialOperators))
            return false;
        return true;
    }
}
