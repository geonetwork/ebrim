package org.geonetwork.domain.filter110.logicalop;

import org.geonetwork.domain.filter110.Operator;

public class UnaryLogicOp extends LogicOps {
    Operator operand;

    public Operator getOperator() {
        return operand;
    }

    public void setOperand(Operator operand) {
        this.operand = operand;
    }

}
