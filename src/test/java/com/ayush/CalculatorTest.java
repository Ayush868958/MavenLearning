package com.ayush;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testDivide() {
        calculator calculator = new calculator();

        int result = calculator.divide(10, 2);

        assertEquals(5, result);
    }
}