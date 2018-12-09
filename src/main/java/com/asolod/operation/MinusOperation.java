package com.asolod.operation;

public class MinusOperation extends AbstractOperation {

    public MinusOperation() {
        super("-");
    }

    protected Float execute(Float operand1, Float operand2) {
        return operand1 - operand2;
    }

    protected Integer execute(Integer operand1, Integer operand2) {
        return operand1 - operand2;
    }

}
