package com.asolod.operation;

public class QuiteOperation extends AbstractOperation {

    public QuiteOperation() {
        super("q");
    }

    @Override
    public Float execute(Float operand1, Float operand2) {
        return null;
    }

    @Override
    protected Integer execute(Integer operand1, Integer operand2) {
        return operand1 + operand2;
    }

}
