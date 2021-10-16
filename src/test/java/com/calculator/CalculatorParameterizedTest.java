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
        private final int a;
        private final int b;
        private final int expected;

        public AddTest(int a, int b, int expected) {
            this.a = a;
            this.b = b;
            this.expected = expected;
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
        public void shouldCorrectlyPerformAddition() {
            assertEquals(expected, calculator.add(a, b));
        }
    }

    @RunWith(Parameterized.class)
    public static class SubtractTest {
        private final int a;
        private final int b;
        private final int expected;

        public SubtractTest(int a, int b, int expected) {
            this.a = a;
            this.b = b;
            this.expected = expected;
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
        public void shouldCorrectlyPerformSubtraction() {
            assertEquals(expected, calculator.subtract(a, b));
        }
    }

    @RunWith(Parameterized.class)
    public static class MultiplyTest {
        private final int a;
        private final int b;
        private final int expected;

        public MultiplyTest(int a, int b, int expected) {
            this.a = a;
            this.b = b;
            this.expected = expected;
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
        public void shouldCorrectlyPerformMultiplication() {
            assertEquals(expected, calculator.multiply(a, b));
        }
    }

    @RunWith(Parameterized.class)
    public static class DivideTest {
        private final int a;
        private final int b;
        private final double expected;

        public DivideTest(int a, int b, double expected) {
            this.a = a;
            this.b = b;
            this.expected = expected;
        }

        @Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {25, 5, 5.0d},
                    {-25, -5, 5.0d},
                    {25, -5, -5.0d},
            });
        }

        @Test
        public void shouldCorrectlyPerformDivision() {
            assertEquals(expected, calculator.divide(a, b), 0.001);
        }
    }
}