package com.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void initCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void shouldCorrectlyPerformAddition_PositiveNumbers() {
        int expected = 10;
        int actual = calculator.add(5, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformAddition_NegativeNumbers() {
        int expected = -10;
        int actual = calculator.add(-5, -5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformAddition_PositiveToNegativeNumber() {
        int expected = 0;
        int actual = calculator.add(5, -5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformSubtraction_PositiveNumbers() {
        int expected = 10;
        int actual = calculator.subtract(15, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformSubtraction_NegativeNumbers() {
        int expected = 0;
        int actual = calculator.subtract(-5, -5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformSubtraction_PositiveFromNegativeNumber() {
        int expected = -10;
        int actual = calculator.subtract(-5, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformMultiplication_PositiveNumbers() {
        int expected = 10;
        int actual = calculator.multiply(5, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformMultiplication_NegativeNumbers() {
        int expected = 10;
        int actual = calculator.multiply(-5, -2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformMultiplication_PositiveByNegativeNumber() {
        int expected = -10;
        int actual = calculator.multiply(5, -2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformMultiplication_ByZero() {
        int expected = 0;
        int actual = calculator.multiply(5, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCorrectlyPerformDivision_PositiveNumbers() {
        double expected = 5.0d;
        double actual = calculator.divide(25, 5);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void shouldCorrectlyPerformDivision_NegativeNumbers() {
        double expected = 5.0d;
        double actual = calculator.divide(-25, -5);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void shouldCorrectlyPerformDivision_PositiveByNegativeNumber() {
        double expected = -5.0d;
        double actual = calculator.divide(25, -5);
        assertEquals(expected, actual, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowArithmeticException_IfPerformingDivisionByZero() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.divide(5, 0);
        assertEquals(expected, actual, 0.001);
    }
}