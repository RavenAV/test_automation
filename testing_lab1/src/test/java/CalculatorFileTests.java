import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorFileTests {
    @ParameterizedTest
    @CsvFileSource(resources = "addition_data.csv")
    @DisplayName("Test addition operation from CSV file")
    void testAdditionFromCsv(String system, String num1, String num2, String expected) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertEquals(expected, calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "subtraction_data.csv", numLinesToSkip = 1)
    @DisplayName("Test subtraction operation from CSV file")
    void testSubtractionFromCsv(String system, String num1, String num2, String expected) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertEquals(expected, calculator.subtract(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "multiplication_data.csv", numLinesToSkip = 1)
    @DisplayName("Test multiplication operation from CSV file")
    void testMultiplicationFromCsv(String system, String num1, String num2, String expected) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertEquals(expected, calculator.multiply(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "division_data.csv", numLinesToSkip = 1)
    @DisplayName("Test division operation from CSV file")
    void testDivisionFromCsv(String system, String num1, String num2, String expected) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertEquals(expected, calculator.divide(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "division_by_zero_data.csv", numLinesToSkip = 1)
    @DisplayName("Test subtraction operation from CSV file")
    void testDivisionByZeroFromCsv(String system, String num2) {
        ICalculator calculator = CalculatorFactory.getCalculator(system);
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide("1", num2);
        });
    }

    // Можете аналогично реализовать тесты для умножения и деления
}
