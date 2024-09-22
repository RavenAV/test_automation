package com.example.testing_lab2_flyway.repository;

import com.example.testing_lab2_flyway.calculator.NumeralSystem;
import com.example.testing_lab2_flyway.calculator.OperationType;
import com.example.testing_lab2_flyway.domain.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ICalculationRepository extends JpaRepository<Calculation, Long> {
    List<Calculation> findAllByCalculationDatetimeBetweenAndNumeralSystemAndOperationType(
            LocalDateTime start,
            LocalDateTime end,
            NumeralSystem firstBase,
            NumeralSystem secondBase,
            OperationType operationType
    );
}
