package com.asolod.parser;

import com.asolod.Calculator;
import com.asolod.OperationExecutor;
import com.asolod.operation.Operation;
import com.asolod.parser.operands.OperandParser;
import com.asolod.parser.operations.OperationTemplate;

import java.util.Iterator;

public class UserInputParser<T extends Number> {

    private final OperandParser<T> operandParser;

    public UserInputParser(OperandParser operandParser) {
        this.operandParser = operandParser;
    }

    public OperationExecutor<T> parse(String[] args) {

        Iterator<OperationTemplate> operationParserIterator = Calculator.OPERATION_PARSERS.iterator();
        while (operationParserIterator.hasNext()) {
            OperationTemplate operationTemplate = operationParserIterator.next();

            Operation operation = null;
            T operand1 = null;
            T operand2 = null;

            // check qty of parameters
            if (args.length != operationTemplate.getArgsLength()) {
                continue;
            }

            if (operationTemplate.getOperationIdx() != -1) {
                operation = findOperation(args, operationTemplate);
                if (operation == null) {
                    continue;
                }
            }

            if (operationTemplate.getOperand1Idx() != -1) {
                operand1 = findOperand(args, operationTemplate.getOperand1Idx());
                if (operand1 == null) {
                    continue;
                }
            }

            if (operationTemplate.getOperand2Idx() != -1) {
                operand2 = findOperand(args, operationTemplate.getOperand2Idx());
                if (operand2 == null) {
                    continue;
                }
            }

            return new OperationExecutor<>(operation, operand1, operand2);

        }

        return null;
    }

    private Operation findOperation(String[] args, OperationTemplate operationTemplate) {

        String sign = args[operationTemplate.getOperationIdx()];
        Iterator<Operation> arithmeticOperationsIt = Calculator.OPERATIONS.iterator();
        while (arithmeticOperationsIt.hasNext()) {
            Operation operation = arithmeticOperationsIt.next();
            if (operation.getSign().equals(sign)) {
                return operation;
            }
        }
        return null;
    }

    private T findOperand(String[] args, int operandIdx) {
        return operandParser.parseOperandFromString(args[operandIdx]);
    }

}
