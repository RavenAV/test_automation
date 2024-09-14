import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorDynamicTest {
    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCsv() throws Exception {
        List<DynamicTest> dynamicTests = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("test-data.csv")))) {
            String line;
            boolean isFirstLine = true; // Пропустить заголовки CSV

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] data = line.split(",");
                String system = data[0];
                String num1 = data[1];
                String num2 = data[2];
                String expected = data[3];

                // Создание динамических тестов
                Executable testExecution = () -> {
                    ICalculator calculator = CalculatorFactory.getCalculator(system);
                    assertEquals(expected, calculator.add(num1, num2));
                };

                String testName = String.format("Addition Test: %s system, %s + %s = %s", system, num1, num2, expected);
                dynamicTests.add(DynamicTest.dynamicTest(testName, testExecution));
            }
        }

        return dynamicTests;
    }
}
