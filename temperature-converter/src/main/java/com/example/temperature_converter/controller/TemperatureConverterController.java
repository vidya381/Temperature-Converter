package com.example.temperature_converter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/convert")
public class TemperatureConverterController {

    @GetMapping("/toCelsius")
    public String convertToCelsius(@RequestParam String fahrenheit) {
        try {
            double f = Double.parseDouble(fahrenheit);
            double celsius = (f - 32) * 5 / 9;
            return String.format("%.2f Fahrenheit is %.2f Celsius", f, celsius);
        } catch (NumberFormatException e) {
            return "Invalid Input";
        }
    }

    @GetMapping("/toFahrenheit")
    public String convertToFahrenheit(@RequestParam String celsius) {
        try {
            double c = Double.parseDouble(celsius);
            double fahrenheit = (c * 9 / 5) + 32;
            return String.format("%.2f Celsius is %.2f Fahrenheit", c, fahrenheit);
        } catch (NumberFormatException e) {
            return "Invalid Input";
        }
    }
}