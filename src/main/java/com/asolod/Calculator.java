package com.asolod;

import com.asolod.operation.Operation;
import com.asolod.operation.result.OperationError;
import com.asolod.operation.result.OperationResult;
import com.asolod.parser.UserInputParser;
import com.asolod.parser.operands.OperandParser;
import com.asolod.parser.operations.OperationTemplate;

import java.util.ServiceLoader;
import java.util.Stack;

public class Calculator<T extends Number> {

    static public ServiceLoader<Operation> OPERATIONS = ServiceLoader.load(Operation.class);

    static public ServiceLoader<OperationTemplate> OPERATION_PARSERS = ServiceLoader.load(OperationTemplate.class);

    private OperandParser operandParser;

    private Stack<T> stack = new Stack<>();

    public Calculator(OperandParser operandParser) {
        this.operandParser = operandParser;
    }

    public OperationResult parseAndExecute(String userInput) {
        OperationExecutor<T> operationExecutor = null;

        UserInputParser<T> userInputParser = new UserInputParser<>(operandParser);

        if (userInput != null) {
            operationExecutor = userInputParser.parse(userInput.split(" "));
            if (operationExecutor != null) {
                return operationExecutor.runOperation(stack);
            }
        }
        return new OperationResult<>(OperationError.USER_INPUT_IS_WRONG, stack);
    }

}
