package com.asolod.operation.result;

import java.util.Stack;

public class OperationResult<T> {

    private OperationError operationError;
    private Stack<T> stack;

    public OperationResult(OperationError operationError, Stack<T> stack) {
        this.operationError = operationError;
        this.stack = stack;
    }

    public OperationResult(Stack<T> stack) {
        this.stack = stack;
    }

    public boolean isSuccessOperation() {
        return this.operationError == null;
    }

    public OperationError getOperationError() {
        return operationError;
    }

    public Stack<T> getStack() {
        return stack;
    }

    @Override
    public String toString() {
        return "OperationResult{" +
                "operationError=" + operationError +
                ", stack=" + stack +
                '}';
    }

    public T getLastCalculatedValue() {
        return getStack().peek();
    }
}
