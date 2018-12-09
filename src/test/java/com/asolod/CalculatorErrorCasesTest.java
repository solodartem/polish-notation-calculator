package com.asolod;

import com.asolod.operation.result.OperationError;
import com.asolod.parser.operands.FloatOperandParser;
import org.junit.Before;
import org.junit.Test;

public class CalculatorErrorCasesTest extends AbstractCalculatorTest {

    @Before
    public void reset() {
        this.calculator = new Calculator<Float>(new FloatOperandParser());
    }

    @Test
    public void wrongUserInputError() {
        //Sure I almost forgot about NPE J
        sendInputAndAssert(null, OperationError.USER_INPUT_IS_WRONG);
        sendInputAndAssert("5d", OperationError.USER_INPUT_IS_WRONG);
        sendInputAndAssert("8 a", OperationError.USER_INPUT_IS_WRONG);
        sendInputAndAssert("+ a s ", OperationError.USER_INPUT_IS_WRONG);
    }

    @Test
    public void emptyStackError() {
        sendInputAndAssert("5d", OperationError.USER_INPUT_IS_WRONG);
        sendInputAndAssert("8 a", OperationError.USER_INPUT_IS_WRONG);
        sendInputAndAssert("+ a s ", OperationError.USER_INPUT_IS_WRONG);
    }

}