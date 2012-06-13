package org.geonetwork.domain.ows100.filtercapabilities;

import java.util.List;
import java.util.ArrayList;

public class ArithmeticOperator {
    private SimpleArithmetic simpleArithmetic;

    private List<FunctionName> functions;

    public SimpleArithmetic getSimpleArithmetic() {
        return simpleArithmetic;
    }

    public void setSimpleArithmetic(SimpleArithmetic simpleArithmetic) {
        this.simpleArithmetic = simpleArithmetic;
    }

    public List<FunctionName> getFunctions() {
        return functions;
    }

    public void setFunctions(List<FunctionName> functions) {
        this.functions = functions;
    }

    /**
	 * For JiBX binding.
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<FunctionName> functionListFactory() {
		return new ArrayList<FunctionName>();
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime
				* result
				+ ((simpleArithmetic == null) ? 0 : simpleArithmetic
						.hashCode());
        result = prime
                        * result
                        + ((functions == null) ? 0 : functions
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
		if (!(obj instanceof ArithmeticOperator)) {
			return false;
		}
		ArithmeticOperator other = (ArithmeticOperator) obj;
        if (simpleArithmetic == null) {
			if (other.simpleArithmetic != null)
				return false;
		} else if (!simpleArithmetic.equals(other.simpleArithmetic))
			return false;
		if (functions == null) {
			if (other.functions != null)
				return false;
		} else if (!functions.equals(other.functions))
			return false;
		return true;
	}

}
