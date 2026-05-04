package com.santo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
        assertEquals(-1, calc.add(2, -3));
        assertEquals(0, calc.add(0, 0));
    }

    @Test
    void testSubtract() {
        assertEquals(-1, calc.subtract(2, 3));
        assertEquals(5, calc.subtract(2, -3));
        assertEquals(0, calc.subtract(0, 0));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
        assertEquals(-6, calc.multiply(2, -3));
        assertEquals(0, calc.multiply(0, 5));
    }

    @Test
    void testDivide() {
        assertEquals(2, calc.divide(6, 3));
        assertEquals(-2, calc.divide(6, -3));
        assertEquals(0, calc.divide(0, 5));
    }

    @Test
    void testDivideByZero() {
        // Controlla che venga lanciata l'eccezione corretta
        assertThrows(IllegalArgumentException.class, () -> calc.divide(5, 0));
    }
}