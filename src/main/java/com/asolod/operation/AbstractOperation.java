package com.asolod.operation;

public abstract class AbstractOperation implements Operation {

    protected String sign;

    public AbstractOperation(String sign) {
        this.sign = sign;
    }

    protected abstract Float execute(Float operand1, Float operand2);

    protected abstract Integer execute(Integer operand1, Integer operand2);

    public Number execute(Number operand1, Number operand2) {
        if (operand1 instanceof Float && operand2 instanceof Float) {
            return execute((Float) operand1, (Float) operand2);
        }
        if (operand1 instanceof Integer && operand2 instanceof Integer) {
            return execute((Integer) operand1, (Integer) operand2);
        }
        throw new RuntimeException("Type " + operand1.getClass().getCanonicalName() + " not supports in Arithmetic Operation");
    }

    public String getSign() {
        return sign;
    }


    @Override
    public String toString() {
        return "AbstractOperation{" +
                "sign='" + sign + '\'' +
                '}';
    }
}