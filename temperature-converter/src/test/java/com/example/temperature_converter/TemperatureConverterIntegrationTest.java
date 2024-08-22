package com.example.temperature_converter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TemperatureConverterIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testConvertToCelsiusEndpoint() throws Exception {
        mockMvc.perform(get("/api/convert/toCelsius").param("fahrenheit", "32"))
                .andExpect(status().isOk())
                .andExpect(content().string("32.00 Fahrenheit is 0.00 Celsius"));

        mockMvc.perform(get("/api/convert/toCelsius").param("fahrenheit", "abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid Input"));
    }

    @Test
    public void testConvertToFahrenheitEndpoint() throws Exception {
        mockMvc.perform(get("/api/convert/toFahrenheit").param("celsius", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0.00 Celsius is 32.00 Fahrenheit"));

        mockMvc.perform(get("/api/convert/toFahrenheit").param("celsius", "abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid Input"));
    }
}