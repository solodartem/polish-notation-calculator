package com.asolod;

import com.asolod.operation.Operation;
import com.asolod.operation.result.OperationError;
import com.asolod.operation.result.OperationResult;

import java.util.Stack;

public class OperationExecutor<T extends Number> {

    private Operation<T> operation;
    private T operand1;
    private T operand2;

    public OperationExecutor(Operation operation, T operand1, T operand2) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public int getStackOperandsQty() {
        int qty = 0;
        if (this.operand1 == null) {
            qty++;
        }

        if (this.operand2 == null) {
            qty++;
        }

        return qty;
    }

    public OperationResult runOperation(Stack<T> stack) {
        // there are no calculations, just adding parameter to the stack
        if (this.operation == null) {
            if (this.operand1 != null) {
                stack.push(operand1);
            }
            if (this.operand2 != null) {
                stack.push(operand2);
            }
            return new OperationResult<>(stack);
        }

        // peek not existing operands from stack, perform calculations and push to the stack
        if (getStackOperandsQty() > stack.size()) {
            return new OperationResult<>(OperationError.STACK_NOT_CONTAINS_REQUIRED_OPERANDS, stack);
        }

        if (this.operand2 == null) {
            this.operand2 = stack.pop();
        }

        if (this.operand1 == null) {
            this.operand1 = stack.pop();
        }
        stack.push(this.operation.execute(this.operand1, this.operand2));

        return new OperationResult<>(stack);
    }

    @Override
    public String toString() {
        return "OperationExecutor{" +
                "operation=" + operation +
                ", operand1=" + operand1 +
                ", operand2=" + operand2 +
                '}';
    }
}
