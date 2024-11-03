package com.example.testing_lab3_bdd.repository;

import com.example.testing_lab3_bdd.calculator.NumeralSystem;
import com.example.testing_lab3_bdd.calculator.OperationType;
import com.example.testing_lab3_bdd.domain.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ICalculationRepository extends JpaRepository<Calculation, Long> {
    List<Calculation> findAllByCalculationDatetimeBetweenAndFirstBaseAndSecondBaseAndOperationType(
            LocalDateTime start,
            LocalDateTime end,
            NumeralSystem firstBase,
            NumeralSystem secondBase,
            OperationType operationType
    );

    Integer countAllBy();
}
