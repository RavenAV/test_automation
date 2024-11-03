package com.example.testing_lab3_bdd.contracts;

import com.example.testing_lab3_bdd.calculator.NumeralSystem;
import com.example.testing_lab3_bdd.calculator.OperationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddCalculationRequest {
    private String firstNumber;

    private NumeralSystem firstBase;

    private String secondNumber;

    private NumeralSystem secondBase;

    private OperationType operationType;
}
