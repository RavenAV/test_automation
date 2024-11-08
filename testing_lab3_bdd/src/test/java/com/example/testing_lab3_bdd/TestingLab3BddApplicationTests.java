package com.example.testing_lab3_bdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
class TestingLab3BddApplicationTests {

    public static void main(String[] args) {
        SpringApplication.from(TestingLab3BddApplication::main).with(TestingLab3BddApplicationTests.class).run(args);
    }
}
