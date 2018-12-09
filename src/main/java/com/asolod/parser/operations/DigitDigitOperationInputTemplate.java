package com.asolod.parser.operations;

public class DigitDigitOperationInputTemplate extends AbstractOperationTemplate {

    @Override
    public int getArgsLength() {
        return 3;
    }

    @Override
    public int getOperand1Idx() {
        return 0;
    }

    @Override
    public int getOperand2Idx() {
        return 1;
    }

    @Override
    public int getOperationIdx() {
        return 2;
    }
}
