package com.asolod;

import com.asolod.parser.operands.FloatOperandParser;
import org.junit.Before;
import org.junit.Test;

public class CalculatorMainCasesTest extends AbstractCalculatorTest {

    @Before
    public void reset() {
        this.calculator = new Calculator<Float>(new FloatOperandParser());
    }

    @Test
    public void case1() {
        sendInputAndAssert("5", 5f);
        sendInputAndAssert("8", 8f);
        sendInputAndAssert("+", 13f);
    }

    @Test
    public void case2() {
        sendInputAndAssert("5 8 +", 13f);
        sendInputAndAssert("13 -", 0f);
    }

    @Test
    public void case3() {
        sendInputAndAssert("-3", -3f);
        sendInputAndAssert("-2", -2f);
        sendInputAndAssert("*", 6f);
        sendInputAndAssert("5", 5f);
        sendInputAndAssert("+", 11f);
    }

    @Test
    public void case4() {
        sendInputAndAssert("5", 5f);
        sendInputAndAssert("9", 9f);
        sendInputAndAssert("1", 1f);
        sendInputAndAssert("-", 8f);
        sendInputAndAssert("/", 0.625f);
    }
}