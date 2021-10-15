package com.calculator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeClass
    public static void initCalculator() {
        calculator = new Calculator();
    }

    @AfterClass
    public static void clearCalculator() {
        calculator = null;
    }

    @Test
    public void additionPositiveNumbersTest() {
        int expected = 10;
        int actual = calculator.add(5, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void additionNegativeNumbersTest() {
        int expected = -10;
        int actual = calculator.add(-5, -5);
        assertEquals(expected, actual);
    }

    @Test
    public void additionPositiveToNegativeNumberTest() {
        int expected = 0;
        int actual = calculator.add(5, -5);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractPositiveNumbersTest() {
        int expected = 10;
        int actual = calculator.subtract(15, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractNegativeNumbersTest() {
        int expected = 0;
        int actual = calculator.subtract(-5, -5);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractPositiveFromNegativeNumberTest() {
        int expected = -10;
        int actual = calculator.subtract(-5, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyPositiveNumbersTest() {
        int expected = 10;
        int actual = calculator.multiply(5, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyNegativeNumbersTest() {
        int expected = 10;
        int actual = calculator.multiply(-5, -2);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyPositiveByNegativeNumberTest() {
        int expected = -10;
        int actual = calculator.multiply(5, -2);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyByZero() {
        int expected = 0;
        int actual = calculator.multiply(5, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void dividePositiveNumbersTest() {
        double expected = 5.0d;
        double actual = calculator.divide(25, 5);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void divideNegativeNumbersTest() {
        double expected = 5.0d;
        double actual = calculator.divide(-25, -5);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void dividePositiveByNegativeNumberTest() {
        double expected = -5.0d;
        double actual = calculator.divide(25, -5);
        assertEquals(expected, actual, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.divide(5, 0);
        assertEquals(expected, actual, 0.001);
    }
}