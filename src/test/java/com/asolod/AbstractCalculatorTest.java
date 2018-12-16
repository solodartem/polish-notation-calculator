package com.asolod;

import com.asolod.operation.result.OperationError;
import com.asolod.operation.result.OperationResult;

import static org.junit.Assert.*;

public class AbstractCalculatorTest {

    protected Calculator<?> calculator;

    protected void sendInputAndAssert(String input, Float expectedResult) {
        OperationResult<Number> result = this.calculator.parseAndExecute(input);
        assertTrue(result.isSuccessOperation());
        assertEquals(expectedResult, result.getLastCalculatedValue());
    }

    protected void sendInputAndAssert(String input, OperationError expectedError) {
        OperationResult result = this.calculator.parseAndExecute(input);
        assertFalse(result.isSuccessOperation());
        assertEquals(expectedError, result.getOperationError());
    }


}
