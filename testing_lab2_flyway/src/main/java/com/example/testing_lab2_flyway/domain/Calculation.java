package com.example.testing_lab2_flyway.domain;

import com.example.testing_lab2_flyway.calculator.NumeralSystem;
import com.example.testing_lab2_flyway.calculator.OperationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="calculations")
public class Calculation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_number", nullable = false)
    private String firstNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "first_base", nullable = false)
    private NumeralSystem firstBase;

    @Column(name = "second_number", nullable = false)
    private String secondNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "second_base", nullable = false)
    private NumeralSystem secondBase;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", nullable = false)
    private OperationType operationType;

    @Column(name = "calculation_datetime", nullable = false)
    private LocalDateTime calculationDatetime = LocalDateTime.now();

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public NumeralSystem getFirstBase() {
        return firstBase;
    }

    public void setFirstBase(NumeralSystem firstBase) {
        this.firstBase = firstBase;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public NumeralSystem getSecondBase() {
        return secondBase;
    }

    public void setSecondBase(NumeralSystem secondBase) {
        this.secondBase = secondBase;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public LocalDateTime getCalculationDatetime() {
        return calculationDatetime;
    }

    public void setCalculationDatetime(LocalDateTime calculationDatetime) {
        this.calculationDatetime = calculationDatetime;
    }
}
