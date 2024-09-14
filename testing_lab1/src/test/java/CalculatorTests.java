import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {
    @ParameterizedTest
    @CsvSource({
            "binary, 1010, 10, 1100",
            "octal, 12, 5, 17",
            "decimal, 10, 20, 30",
            "hex, a, 1, b"
    })
    @DisplayName("Test addition operation in various numeral systems")
    void testAddition(String system, String num1, String num2, String expected) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertEquals(expected, calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "binary, 1010, 10, 1000",
            "octal, 12, 5, 5",
            "decimal, 20, 10, 10",
            "hex, a, 1, 9"
    })
    @DisplayName("Test subtraction operation in various numeral systems")
    void testSubtraction(String system, String num1, String num2, String expected) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertEquals(expected, calculator.subtract(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "binary, 10, 11, 110",
            "octal, 3, 4, 14",
            "decimal, 5, 6, 30",
            "hex, a, 2, 14"
    })
    @DisplayName("Test multiplication operation in various numeral systems")
    void testMultiplication(String system, String num1, String num2, String expected) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertEquals(expected, calculator.multiply(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "binary, 110, 10, 11",
            "octal, 14, 2, 6",
            "decimal, 30, 5, 6",
            "hex, 14, 2, a"
    })
    @DisplayName("Test division operation in various numeral systems")
    void testDivision(String system, String num1, String num2, String expected) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertEquals(expected, calculator.divide(num1, num2));
    }

    @ParameterizedTest
    @CsvSource({
            "binary, 0",
            "octal, 0",
            "decimal, 0",
            "hex, 0"
    })
    @DisplayName("Test division by zero throws exception")
    void testDivisionByZero(String system, String num2) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide("1", num2);
        });
    }
}

