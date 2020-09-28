package com.example.helloworld;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SimpleCalculatorUnitTest {
    @Test
    public void function_isCorrect() {
        // assertEquals(4, 2 + 2);

        SimpleCalculator calc = new SimpleCalculator();

        assertEquals(6, calc.add(2, 4));

        assertEquals(2, calc.sub(4, 2));

        assertEquals(10, calc.mult(2, 5));

        assertEquals(0, calc.div(0, 2));
    }




}