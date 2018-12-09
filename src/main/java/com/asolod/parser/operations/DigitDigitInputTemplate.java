package com.asolod.parser.operations;

public class DigitDigitInputTemplate extends AbstractOperationTemplate {

    @Override
    public int getArgsLength() {
        return 2;
    }

    @Override
    public int getOperand1Idx() {
        return 0;
    }

    @Override
    public int getOperand2Idx() {
        return 1;
    }
}
