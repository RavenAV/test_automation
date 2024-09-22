package com.example.testing_lab2_flyway.calculator;

public class OctalCalculator implements ICalculator {
    @Override
    public String add(String num1, String num2) {
        int result = Integer.parseInt(num1, 8) + Integer.parseInt(num2, 8);
        return Integer.toOctalString(result);
    }

    @Override
    public String subtract(String num1, String num2) {
        int result = Integer.parseInt(num1, 8) - Integer.parseInt(num2, 8);
        return Integer.toOctalString(result);
    }

    @Override
    public String multiply(String num1, String num2) {
        int result = Integer.parseInt(num1, 8) * Integer.parseInt(num2, 8);
        return Integer.toOctalString(result);
    }

    @Override
    public String divide(String num1, String num2) {
        int result = Integer.parseInt(num1, 8) / Integer.parseInt(num2, 8);
        return Integer.toOctalString(result);
    }
}
