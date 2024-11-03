package com.example.testing_lab3_bdd.services;

import com.example.testing_lab3_bdd.calculator.CalculatorFactory;
import com.example.testing_lab3_bdd.calculator.ICalculator;
import com.example.testing_lab3_bdd.calculator.NumeralSystem;
import com.example.testing_lab3_bdd.calculator.OperationType;
import com.example.testing_lab3_bdd.domain.Calculation;
import com.example.testing_lab3_bdd.repository.ICalculationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.example.testing_lab3_bdd.calculator.NumeralSystem.DECIMAL;

@Service
@AllArgsConstructor
public class CalculationService {
    private final ICalculationRepository calculationRepository;

    public String calculate(String num1, String num2, NumeralSystem firstBase, NumeralSystem secondBase, OperationType operationType) {
        Calculation calculation = new Calculation();
        calculation.setFirstNumber(num1);
        calculation.setFirstBase(firstBase);
        calculation.setSecondNumber(num2);
        calculation.setSecondBase(secondBase);
        calculation.setOperationType(operationType);

        calculationRepository.save(calculation);

        ICalculator calculator;

        if (firstBase.getBase() != secondBase.getBase()) {
            calculator = CalculatorFactory.getCalculator(DECIMAL);
            num1 = NumberConverter(num1, firstBase);
            num2 = NumberConverter(num2, secondBase);
        } else {
            calculator = CalculatorFactory.getCalculator(firstBase);
        }


        String result = switch (operationType) {
            case ADDITION -> calculator.add(num1, num2);
            case SUBTRACTION -> calculator.subtract(num1, num2);
            case MULTIPLICATION -> calculator.multiply(num1, num2);
            case DIVISION -> calculator.divide(num1, num2);
            default -> throw new IllegalArgumentException("Неверный тип операции!");
        };

        return result;
    }

    public List<Calculation> getCalculationByDatetimeBetweenAndNumeralSystemAndOperationType(LocalDateTime start, LocalDateTime end, NumeralSystem firstBase, NumeralSystem secondBase, OperationType operationType) {
        return calculationRepository.findAllByCalculationDatetimeBetweenAndFirstBaseAndSecondBaseAndOperationType(start, end, firstBase, secondBase, operationType);
    }

    public int getCountBy(){
        return calculationRepository.countAllBy();
    }

    public void clearCalculationsTable() {
        calculationRepository.deleteAll();
    }

    public void saveCalculations(ArrayList<Calculation> calculations) {
        calculationRepository.saveAllAndFlush(calculations);
    }


    private static String NumberConverter(String number, NumeralSystem base)
    {
        int res = 0;
        switch (base) {
            case BINARY -> res = Integer.parseInt(number, 2);
            case OCTAL -> res = Integer.parseInt(number, 8);
            case HEXADECIMAL -> res = Integer.parseInt(number, 16);
            case DECIMAL -> res = Integer.parseInt(number);
        }

        return String.valueOf(res);
    }
}
