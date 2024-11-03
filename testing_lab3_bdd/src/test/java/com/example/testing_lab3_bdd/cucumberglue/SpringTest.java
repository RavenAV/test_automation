package com.example.testing_lab3_bdd.cucumberglue;

import com.example.testing_lab3_bdd.TestingLab3BddApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestingLab3BddApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public class SpringTest {
}
