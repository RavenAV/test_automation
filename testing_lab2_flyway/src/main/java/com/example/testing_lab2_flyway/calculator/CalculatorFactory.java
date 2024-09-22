package com.example.testing_lab2_flyway.calculator;

public class CalculatorFactory {
    public static ICalculator getCalculator(NumeralSystem base) {
        switch (base.getBase()) {
            case 2:
                return new BinaryCalculator();
            case 8:
                return new OctalCalculator();
            case 10:
                return new DecimalCalculator();
            case 16:
                return new HexCalculator();
            default:
                throw new IllegalArgumentException("Unknown number base: " + base);
        }
    }
}
