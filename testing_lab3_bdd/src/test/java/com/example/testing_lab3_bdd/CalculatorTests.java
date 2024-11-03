package com.example.testing_lab3_bdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestingLab3BddApplicationTests.class)
@AutoConfigureMockMvc
public class CalculatorTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    @Sql("/testing_data.sql")
    void getCalculations() throws Exception {
        mockMvc.perform(get("/calculation/history")
                        .queryParam("start", "2024-11-01T11:00:00")
                        .queryParam("end", "2024-11-02T12:00:00")
                        .queryParam("firstBase", "DECIMAL")
                        .queryParam("secondBase", "BINARY")
                        .queryParam("operationType", "ADDITION"))
                .andExpectAll(
                        status().isOk(),
                        content().json("""
					[
					    {
					        "calculationId": 1,
             		        "firstNumber": "10",
             		        "firstBase": "DECIMAL",
             		        "secondNumber": "10",
             		        "secondBase": "BINARY",
             		        "operationType": "ADDITION",
             		        "calculationDatetime": "2024-11-01 12:00:00+00"
					    }
					]
					""")
                );
    }

    @Test
    void addCalculation() throws Exception {
        mockMvc.perform(post("/calculation/compute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
					{
					    "firstNumber": "1010",
					    "secondNumber": "10",
					    "firstBase": "BINARY",
					    "secondBase": "BINARY",
					    "operationType": "ADDITION"
					}
					"""))
                .andExpectAll(
                        status().isCreated(),
                        content().string("1100")
                );
    }
}
