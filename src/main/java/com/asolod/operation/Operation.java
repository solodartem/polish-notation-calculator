package com.asolod.operation;

public interface Operation<T extends Number> {

    T execute(Number operand1, Number operand2);

    String getSign();
}
