package com.asolod.parser.operands;

public class FloatOperandParser implements OperandParser<Float> {

    @Override
    public Float parseOperandFromString(String string) {
        if (string.matches("[+-]?([0-9]*[.])?[0-9]+")) {
            return Float.parseFloat(string);
        }
        return null;
    }
}
