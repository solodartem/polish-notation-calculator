package com.asolod;

import com.asolod.operation.result.OperationResult;
import com.asolod.parser.operands.FloatOperandParser;
import com.asolod.parser.operands.IntegerOperandParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorFloatIntegerTest extends AbstractCalculatorTest {

    @Before
    public void reset() {
        this.calculator = new Calculator<Float>(new FloatOperandParser());
    }

    @Test
    public void floatTest() {
        this.calculator = new Calculator<Float>(new FloatOperandParser());
        OperationResult operationResult = this.calculator.parseAndExecute("1 2 /");
        Assert.assertTrue(operationResult.getLastCalculatedValue() instanceof Float);
        Assert.assertEquals(0.5f, operationResult.getLastCalculatedValue());
    }

    @Test
    public void integerTest() {
        this.calculator = new Calculator<Integer>(new IntegerOperandParser());
        OperationResult operationResult = this.calculator.parseAndExecute("1");
        Assert.assertTrue(operationResult.getLastCalculatedValue() instanceof Integer);
        // Yes I know that division integer on integer leads to data truncation
        // In this case we are getting rounded value
        // But idea was to show how to solve issue with JAva generics without real type data
        Assert.assertEquals(1, operationResult.getLastCalculatedValue());
    }


}