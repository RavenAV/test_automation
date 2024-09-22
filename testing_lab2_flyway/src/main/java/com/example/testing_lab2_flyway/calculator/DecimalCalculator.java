package com.example.testing_lab2_flyway.calculator;

public class DecimalCalculator implements ICalculator {
    @Override
    public String add(String num1, String num2) {
        int result = Integer.parseInt(num1) + Integer.parseInt(num2);
        return Integer.toString(result);
    }

    @Override
    public String subtract(String num1, String num2) {
        int result = Integer.parseInt(num1) - Integer.parseInt(num2);
        return Integer.toString(result);
    }

    @Override
    public String multiply(String num1, String num2) {
        int result = Integer.parseInt(num1) * Integer.parseInt(num2);
        return Integer.toString(result);
    }

    @Override
    public String divide(String num1, String num2) {
        int result = Integer.parseInt(num1) / Integer.parseInt(num2);
        return Integer.toString(result);
    }
}
