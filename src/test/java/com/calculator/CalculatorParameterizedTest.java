package com.calculator;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class CalculatorParameterizedTest {
    private static Calculator calculator;

    @BeforeClass
    public static void initCalculator() {
        calculator = new Calculator();
    }

    @AfterClass
    public static void clearCalculator() {
        calculator = null;
    }

    @RunWith(Parameterized.class)
    public static class AddTest {
        private final int numberA;
        private final int numberB;
        private final int expectedInteger;

        public AddTest(int numberA, int numberB, int expectedInteger) {
            this.numberA = numberA;
            this.numberB = numberB;
            this.expectedInteger = expectedInteger;
        }

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 2},
                    {2, -2, 0},
                    {-8, 2, -6},
                    {0, -2, -2},
                    {100500, 500100, 600600}
            });
        }

        @Test
        public void addTwoNumbersTest() {
            assertEquals(expectedInteger, calculator.add(numberA, numberB));
        }
    }

    @RunWith(Parameterized.class)
    public static class SubtractTest {
        private final int numberA;
        private final int numberB;
        private final int expectedInteger;

        public SubtractTest(int numberA, int numberB, int expectedInteger) {
            this.numberA = numberA;
            this.numberB = numberB;
            this.expectedInteger = expectedInteger;
        }

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {1, 1, 0},
                    {2, -2, 4},
                    {-8, 2, -10},
                    {0, -0, 0},
                    {-100500, -500100, 399600}
            });
        }

        @Test
        public void subtractTwoNumbersTest() {
            assertEquals(expectedInteger, calculator.subtract(numberA, numberB));
        }
    }

    @RunWith(Parameterized.class)
    public static class MultiplyTest {
        private final int numberA;
        private final int numberB;
        private final int expectedInteger;

        public MultiplyTest(int numberA, int numberB, int expectedInteger) {
            this.numberA = numberA;
            this.numberB = numberB;
            this.expectedInteger = expectedInteger;
        }

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {5, 2, 10},
                    {-5, -2, 10},
                    {5, -2, -10},
                    {-100, 0, 0}
            });
        }

        @Test
        public void multiplyTwoNumbersTest() {
            assertEquals(expectedInteger, calculator.multiply(numberA, numberB));
        }
    }

    @RunWith(Parameterized.class)
    public static class DivideTest {
        private final int numberA;
        private final int numberB;
        private final double expectedDouble;

        public DivideTest(int numberA, int numberB, double expectedDouble) {
            this.numberA = numberA;
            this.numberB = numberB;
            this.expectedDouble = expectedDouble;
        }

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {25, 5, 5.0d},
                    {-25, -5, 5.0d},
                    {25, -5, -5.0d},
                    {5, 0, Double.POSITIVE_INFINITY}
            });
        }

        @Test
        public void divideTwoNumbersTest() {
            assertEquals(expectedDouble, calculator.divide(numberA, numberB), 0.001);
        }
    }
}