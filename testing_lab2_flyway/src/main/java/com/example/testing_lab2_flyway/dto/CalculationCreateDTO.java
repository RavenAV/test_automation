package com.example.testing_lab2_flyway.dto;

import com.example.testing_lab2_flyway.calculator.NumeralSystem;
import com.example.testing_lab2_flyway.calculator.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculationCreateDTO {
    private String firstNumber;
    private NumeralSystem firstBase;
    private String secondNumber;
    private NumeralSystem secondBase;
    private OperationType operationType;
}