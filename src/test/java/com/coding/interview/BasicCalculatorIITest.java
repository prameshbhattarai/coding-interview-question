package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicCalculatorIITest {

    private static final String expression1 = "3+2*2";
    private static final int expected1 = 7;

    private static final String expression2 = " 3/2 ";
    private static final int expected2 = 1;

    private static final String expression3 = " 3+5 / 2 ";
    private static final int expected3 = 5;

    private static final BasicCalculatorII calculator = new BasicCalculatorII();

    @Test
    public void testCalculator() {
        Assertions.assertEquals(expected1, calculator.calculate(expression1));
        Assertions.assertEquals(expected2, calculator.calculate(expression2));
        Assertions.assertEquals(expected3, calculator.calculate(expression3));
    }

}
