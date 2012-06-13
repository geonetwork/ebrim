package org.geonetwork.domain.filter110.logicalop;

import org.geonetwork.domain.filter110.Operator;

public class Not extends UnaryLogicOp {
    Operator op;

    public Operator getOp() {
        return op;
    }

    public void setOp(Operator op) {
        this.op = op;
    }
}
