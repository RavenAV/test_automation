package com.example.testing_lab3_bdd.calculator;

public class HexCalculator implements ICalculator {
    @Override
    public String add(String num1, String num2) {
        int result = Integer.parseInt(num1, 16) + Integer.parseInt(num2, 16);
        return Integer.toHexString(result);
    }

    @Override
    public String subtract(String num1, String num2) {
        int result = Integer.parseInt(num1, 16) - Integer.parseInt(num2, 16);
        return Integer.toHexString(result);
    }

    @Override
    public String multiply(String num1, String num2) {
        int result = Integer.parseInt(num1, 16) * Integer.parseInt(num2, 16);
        return Integer.toHexString(result);
    }

    @Override
    public String divide(String num1, String num2) {
        int result = Integer.parseInt(num1, 16) / Integer.parseInt(num2, 16);
        return Integer.toHexString(result);
    }
}
