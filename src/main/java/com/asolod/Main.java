package com.asolod;

import com.asolod.operation.result.OperationResult;
import com.asolod.parser.operands.FloatOperandParser;
import com.asolod.streams.input.CalculatorInputStream;
import com.asolod.streams.input.ConsoleInputStream;
import com.asolod.streams.output.CalculatorOutputStream;
import com.asolod.streams.output.ConsoleOutputStream;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator<Float>(new FloatOperandParser());

        try (CalculatorInputStream inputStream = new ConsoleInputStream();
             CalculatorOutputStream outputStream = new ConsoleOutputStream()) {
            while (inputStream.hasNext()) {
                OperationResult operationResult = calculator.parseAndExecute(inputStream.next());
                if (operationResult.isSuccessOperation()) {
                    outputStream.writeLine(operationResult.getLastCalculatedValue());
                } else {
                    outputStream.writeLine(operationResult.getOperationError());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
