package com.example.testing_lab2_flyway;

import com.example.testing_lab2_flyway.calculator.NumeralSystem;
import com.example.testing_lab2_flyway.calculator.OperationType;
import com.example.testing_lab2_flyway.domain.Calculation;
import com.example.testing_lab2_flyway.dto.CalculationCreateDTO;
import com.example.testing_lab2_flyway.services.CalculationService;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(classes = TestingLab2FlywayApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestingLab2FlywayApplicationTests extends AuditVizualizationBaseTest {
	@Autowired
	CalculationService calculationService;
	@LocalServerPort
	private int port;

	@FlywayTest
	@Test
	void quantityTest() {

		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<Integer> response;
		response = testRestTemplate.getForEntity(
				String.format("http://localhost:%s/quantity?",
						port),
				Integer.class);

		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assertions.assertEquals(response.getBody(), 20);
	}

	@FlywayTest
	@Test
	void computeTest() {

		CalculationCreateDTO createRequest = new CalculationCreateDTO("16", NumeralSystem.DECIMAL,
				"14", NumeralSystem.DECIMAL, OperationType.ADDITION);

		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<String> response;
		response = testRestTemplate.postForEntity(
				String.format("http://localhost:%s/compute?firstNumber=%s&firstBase=%s&secondNumber=%s&secondBase=%s&operationType=%s",
						port,
						createRequest.getFirstNumber(),
						createRequest.getFirstBase(),
						createRequest.getSecondNumber(),
						createRequest.getSecondBase(),
						createRequest.getOperationType()),
				null, String.class);

		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

	}

	@FlywayTest
	@Test
	void historyTest() {
		LocalDateTime end = LocalDateTime.now();
		LocalDateTime start = end.minusMinutes(1);
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ResponseEntity<List<Calculation>> response;
		response = testRestTemplate.exchange(String.format("http://localhost:%s/history?start=%s&end=%s&firstBase=%s&secondBase=%s&operationType=%s",
						port,
						start,
						end,
						NumeralSystem.DECIMAL,
						NumeralSystem.BINARY,
						OperationType.ADDITION),
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Calculation>>() {});

		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		// сравниваем, что у нас три записи с такими параметрами
		Assertions.assertEquals(response.getBody().size(), 3);
	}
}
