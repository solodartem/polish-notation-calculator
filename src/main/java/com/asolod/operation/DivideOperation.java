package com.asolod.operation;

public class DivideOperation extends AbstractOperation {

    public DivideOperation() {
        super("/");
    }

    @Override
    public Float execute(Float operand1, Float operand2) {
        return operand1 / operand2;
    }

    @Override
    protected Integer execute(Integer operand1, Integer operand2) {
        return operand1 / operand1;
    }

}
