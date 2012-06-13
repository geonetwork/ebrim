package org.geonetwork.domain.ows100.filtercapabilities;

import java.util.List;
import java.util.ArrayList;


public class SpatialOperator {
    private SpatialOperatorName name;

    private List<GeometryOperand> geometryOperands;


    public SpatialOperatorName getName() {
        return name;
    }

    public void setName(SpatialOperatorName name) {
        this.name = name;
    }

    public List<GeometryOperand> getGeometryOperands() {
        return geometryOperands;
    }

    public void setGeometryOperands(List<GeometryOperand> geometryOperands) {
        this.geometryOperands = geometryOperands;
    }

    /**
     * For JiBX binding.
     *
     * @return
     */
    @SuppressWarnings("unused")
    private static List<GeometryOperand> geometryOperandListFactory() {
        return new ArrayList<GeometryOperand>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        result = prime
                * result
                + ((geometryOperands == null) ? 0 : geometryOperands
                .hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null) {
                    return false;
                }
		if (!(obj instanceof SpatialOperator)) {
			return false;
		}

        SpatialOperator other = (SpatialOperator) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (geometryOperands == null) {
            if (other.geometryOperands != null)
                return false;
        } else if (!geometryOperands.equals(other.geometryOperands))
            return false;
        return true;
    }
}