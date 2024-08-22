package com.example.temperature_converter.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemperatureConverterControllerTest {

    @Autowired
    private TemperatureConverterController controller;

    @Test
    void testConvertToCelsius() {
        assertEquals("32.00 Fahrenheit is 0.00 Celsius", controller.convertToCelsius("32"));
        assertEquals("212.00 Fahrenheit is 100.00 Celsius", controller.convertToCelsius("212"));
        assertEquals("-40.00 Fahrenheit is -40.00 Celsius", controller.convertToCelsius("-40"));
        assertEquals("Invalid Input", controller.convertToCelsius("abc"));
    }

    @Test
    void testConvertToFahrenheit() {
        assertEquals("0.00 Celsius is 32.00 Fahrenheit", controller.convertToFahrenheit("0"));
        assertEquals("100.00 Celsius is 212.00 Fahrenheit", controller.convertToFahrenheit("100"));
        assertEquals("-40.00 Celsius is -40.00 Fahrenheit", controller.convertToFahrenheit("-40"));
        assertEquals("Invalid Input", controller.convertToFahrenheit("abc"));
    }
}