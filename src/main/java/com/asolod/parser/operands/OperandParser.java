package com.asolod.parser.operands;

@FunctionalInterface
public interface OperandParser<T> {

    T parseOperandFromString(String string);
}
