package com.asolod.parser.operands;

public class IntegerOperandParser implements OperandParser<Integer> {

    @Override
    public Integer parseOperandFromString(String string) {
        if (string.matches("[+-]?[0-9]+")) {
            return Integer.parseInt(string);
        }
        return null;
    }
}
