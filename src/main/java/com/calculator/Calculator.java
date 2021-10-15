package com.calculator;

public class Calculator {

    public Calculator() {
    }

    public int add(int number1, int number2) {
        return number1 + number2;
    }

    public int subtract(int number1, int number2) {
        return number1 - number2;
    }

    public int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public double divide(int number1, int number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Cannot divide by 0");
        }
        return (double) number1 / number2;
    }
}