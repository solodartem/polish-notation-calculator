package com.asolod.parser.operations;


public abstract class AbstractOperationTemplate implements OperationTemplate {

    abstract public int getArgsLength();

    public int getOperationIdx() {
        return -1;
    }

    public int getOperand1Idx() {
        return -1;
    }

    public int getOperand2Idx() {
        return -1;
    }

}
