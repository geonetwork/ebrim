package org.geonetwork.domain.ows100.filtercapabilities;

import java.util.List;
import java.util.ArrayList;

public class ScalarCapabilities {
    List<LogicalOperator> logicalOperators;
    List<ComparisonOperator> comparisonOperators;
    List<ArithmeticOperator> arithmeticOperators;

    public List<LogicalOperator> getLogicalOperators() {
        return logicalOperators;
    }

    public void setLogicalOperators(List<LogicalOperator> logicalOperators) {
        this.logicalOperators = logicalOperators;
    }

    public List<ComparisonOperator> getComparisonOperators() {
        return comparisonOperators;
    }

    public void setComparisonOperators(List<ComparisonOperator> comparisonOperators) {
        this.comparisonOperators = comparisonOperators;
    }

    public List<ArithmeticOperator> getArithmeticOperators() {
        return arithmeticOperators;
    }

    public void setArithmeticsOperators(List<ArithmeticOperator> arithmeticOperators) {
        this.arithmeticOperators = arithmeticOperators;
    }

    /**
     * For JiBX binding.
     *
     * @return
     */
    @SuppressWarnings("unused")
    private static List<LogicalOperator> logicalOperatorListFactory() {
        return new ArrayList<LogicalOperator>();
    }

    @SuppressWarnings("unused")
    private static List<ComparisonOperator> comparisonOperatorsListFactory() {
        return new ArrayList<ComparisonOperator>();
    }

    @SuppressWarnings("unused")
        private static List<ArithmeticOperator> arithmeticOperatorsListFactory() {
            return new ArrayList<ArithmeticOperator>();
        }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((logicalOperators == null) ? 0 : logicalOperators.hashCode());
        result = prime
                * result
                + ((comparisonOperators == null) ? 0 : comparisonOperators
                .hashCode());
        result = prime
                * result
                + ((arithmeticOperators == null) ? 0 : arithmeticOperators
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
		if (!(obj instanceof ScalarCapabilities)) {
			return false;
		}
        
        ScalarCapabilities other = (ScalarCapabilities) obj;
        if (logicalOperators == null) {
            if (other.logicalOperators != null)
                return false;
        } else if (!logicalOperators.equals(other.logicalOperators))
            return false;
        if (comparisonOperators == null) {
            if (other.comparisonOperators != null)
                return false;
        } else if (!comparisonOperators.equals(other.comparisonOperators))
            return false;
        if (arithmeticOperators == null) {
            if (other.arithmeticOperators != null)
                return false;
        } else if (!arithmeticOperators.equals(other.arithmeticOperators))
            return false;
        return true;
    }
}
