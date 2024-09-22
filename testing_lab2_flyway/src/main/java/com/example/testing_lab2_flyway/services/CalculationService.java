package com.example.testing_lab2_flyway.services;

import com.example.testing_lab2_flyway.calculator.CalculatorFactory;
import com.example.testing_lab2_flyway.calculator.ICalculator;
import com.example.testing_lab2_flyway.calculator.NumeralSystem;
import com.example.testing_lab2_flyway.calculator.OperationType;
import com.example.testing_lab2_flyway.domain.Calculation;
import com.example.testing_lab2_flyway.repository.ICalculationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CalculationService {
    private final ICalculationRepository calculationRepository;

    public CalculationService(ICalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public String calculate(String num1, String num2, NumeralSystem base, OperationType operationType) {
        ICalculator calculator = CalculatorFactory.getCalculator(base);

        String result = switch (operationType) {
            case ADDITION -> calculator.add(num1, num2);
            case SUBTRACTION -> calculator.subtract(num1, num2);
            case MULTIPLICATION -> calculator.multiply(num1, num2);
            case DIVISION -> calculator.divide(num1, num2);
            default -> throw new IllegalArgumentException("Invalid operation type");
        };

        Calculation calculation = new Calculation();
        calculation.setFirstNumber(num1);
        calculation.setFirstBase(base);
        calculation.setSecondNumber(num2);
        calculation.setSecondBase(base);
        calculation.setOperationType(operationType);

        calculationRepository.save(calculation);

        return result;
    }

    public List<Calculation> getCalculationByDatetimeBetweenAndNumeralSystemAndOperationType(LocalDateTime start, LocalDateTime end, NumeralSystem firstBase, NumeralSystem secondBase, OperationType operationType) {
        return calculationRepository.findAllByCalculationDatetimeBetweenAndNumeralSystemAndOperationType(start, end, firstBase, secondBase, operationType);
    }
}
