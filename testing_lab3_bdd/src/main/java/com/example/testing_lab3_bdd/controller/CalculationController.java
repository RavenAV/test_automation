package com.example.testing_lab3_bdd.controller;

import com.example.testing_lab3_bdd.calculator.NumeralSystem;
import com.example.testing_lab3_bdd.calculator.OperationType;
import com.example.testing_lab3_bdd.contracts.AddCalculationRequest;
import com.example.testing_lab3_bdd.domain.Calculation;
import com.example.testing_lab3_bdd.services.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/calculation")
public class CalculationController {
    private final CalculationService _calculationService;


    @Autowired
    public CalculationController(CalculationService calculationService) {
        this._calculationService = calculationService;
    }

    @PostMapping("/compute")
    public ResponseEntity<String> compute(@RequestBody AddCalculationRequest request) {

        String res = _calculationService.calculate(request.getFirstNumber(), request.getSecondNumber(), request.getFirstBase(), request.getSecondBase(), request.getOperationType());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Calculation>> getHistory(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
            @RequestParam NumeralSystem firstBase,
            @RequestParam NumeralSystem secondBase,
            @RequestParam OperationType operationType) {

        List<Calculation> calculations = _calculationService.getCalculationByDatetimeBetweenAndNumeralSystemAndOperationType(start, end, firstBase, secondBase, operationType);

        return ResponseEntity.ok(calculations);
    }

    @GetMapping("/quantity")
    public ResponseEntity<Integer> getQuantity() {

        Integer quantity = _calculationService.getCountBy();
        System.out.println(quantity);
        return ResponseEntity.ok(quantity);
    }

}
