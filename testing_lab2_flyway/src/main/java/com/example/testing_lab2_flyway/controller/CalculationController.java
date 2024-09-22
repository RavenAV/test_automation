package com.example.testing_lab2_flyway.controller;

import com.example.testing_lab2_flyway.calculator.NumeralSystem;
import com.example.testing_lab2_flyway.calculator.OperationType;
import com.example.testing_lab2_flyway.domain.Calculation;
import com.example.testing_lab2_flyway.services.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/calculation")
public class CalculationController {
    private final CalculationService _calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this._calculationService = calculationService;
    }

    @PostMapping("/compute")
    public ResponseEntity<String> compute(
            @RequestParam String firstNumber,
            @RequestParam String secondNumber,
            @RequestParam NumeralSystem base,
            @RequestParam OperationType operationType) {

        String res = _calculationService.calculate(firstNumber, secondNumber, base, operationType);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Calculation>> getHistory(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam NumeralSystem base,
            @RequestParam OperationType operationType) {

        List<Calculation> calculations = _calculationService.getCalculationByDatetimeBetweenAndNumeralSystemAndOperationType(start, end, base, base, operationType);
        return ResponseEntity.ok(calculations);
    }
}
