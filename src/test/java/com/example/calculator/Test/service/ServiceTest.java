package com.example.calculator.Test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    public void helloCalculator() {
        String supposably = "<b>Добро пожаловать в калькулятор!</b>";
        assertEquals(supposably, calculatorService.welcome());
    }

    @Test
    public void TestingDivideException() {
        assertThrows(IllegalArgumentException.class,
                () -> { calculatorService.divide(2, 0);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"4,6", "-6,5"})
    public void divideCalculator(float a, float b) {
        assertTrue(calculatorService.divide(a, b).contains("" + (a / b)));
    }

    @ParameterizedTest
    @CsvSource(value = {"10,20", "-20,4"})
    public void plusCalculator(int a, int b) {
        assertTrue(calculatorService.plus(a, b).contains("" + (a + b)));
    }

    @ParameterizedTest
    @CsvSource(value = {"10,2", "-10,5"})
    public void minusCalculator(int a, int b) {
        assertTrue(calculatorService.minus(a, b).contains("" + (a - b)));
    }

    @ParameterizedTest
    @CsvSource(value = {"2,2", "-10,2"})
    public void multiplyCalculator(int a, int b) {
        assertTrue(calculatorService.multiply(a, b).contains("" + (a * b)));
    }
}
